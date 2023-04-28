package com.alumno.simulacionims;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.alumno.simulacionims.models.Usuario;
import com.alumno.simulacionims.parse.Parse;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author David Ruiz Garcia
 * Objeto LoginActivity para hacer uso de la actividad con dicho nombre
 */
public class LoginActivity extends AppCompatActivity implements Pin.PinDialogListener {
    //region Variables
    // TODO Creacion de las variables de las cuales se hara uso
    private EditText usuario;
    private EditText contraseña;
    private ImageView mostrar;
    private Button iniciar;
    private Button crear;
    private CheckBox recordar;
    private Spinner sucursal;
    private SQLiteDatabase db;
    private boolean isPasswordVisible = false;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private final String PIN = "8635";
    private String pin = "";


    // TODO Creación de un array de Strings para poder adaptarlo mas adelante al Spinner anteriormente creado
    final String[] sucursales = {"INER EUSKADI", "INER CASTILLA"};

    private ArrayList<Usuario> listaUsuario;

    //endregion
    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(androidx.appcompat.R.style.Theme_AppCompat_DayNight);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //TODO Se asigna las variables creadas anteriormente a las id de los layout
        usuario = findViewById(R.id.txtUsuario);
        contraseña = findViewById(R.id.txtPassword);
        mostrar = findViewById(R.id.imgMostrar);
        recordar = findViewById(R.id.chkRecordar);
        iniciar = findViewById(R.id.btnIniciarSesion);
        crear = findViewById(R.id.btnCrearUsuario);
        sucursal = findViewById(R.id.spnSucursal);

        requestWriteExternalStoragePermission();

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();

        //consultarSedeUsuarios();

        //region spnSucursal
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>
                (this, R.layout.spinneriner, sucursales);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sucursal.setAdapter(adaptador);
        String sede = (String) sucursal.getSelectedItem();
        sucursal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sede = (String) sucursal.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No seleccionaron nada
            }


        });
        //endregion


        Cargar(prefs);

        DataBaseHelper inerbase = new DataBaseHelper(LoginActivity.this, "IMS.db", null, 1);
        db = inerbase.getWritableDatabase();
        actualizaDB();

        //region btnIniciar
        // TODO En caso de que se haga click en el boton de inicio de sesion revisara si los campos estan vacios
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizaUsuario();
                if (usuario.length() > 0 && contraseña.length() > 0) {
                    buscaDB();
                } else {
                    Toast.makeText(getApplicationContext(), "Rellena los campos", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //endregion
        //region btnMostrar
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPasswordVisible = !isPasswordVisible;
                if (isPasswordVisible) {
                    muestra();
                } else {
                    oculta();
                }
            }
        });
        //endregion
        //region chkRecordar
        recordar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (recordar.isChecked()) {
                    Guardar();
                    Toast.makeText(LoginActivity.this, "Se recordaran los datos insertados", Toast.LENGTH_SHORT).show();
                } else {
                    Vaciar();
                    Guardar();
                    Toast.makeText(LoginActivity.this, "No se guardaran los datos insertados", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //endregion
        //region btnCrear
        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Cuadro de texto en el que preguntara si por un pin para acceder a la creación del usuario
                openPinDialog();
                onPinEntered(pin);


            }
        });
        //endregion
    }
    //endregion
    //region Guarda_Carga

    /**
     * Mediante este metodo se guardan los datos con el uso del Objeto SharedPreferences
     */
    public void Guardar() {
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("usuario", usuario.getText().toString());
        editor.putString("contraseña", contraseña.getText().toString());
        editor.putBoolean("isChecked", recordar.isChecked());
        editor.commit();
    }

    /**
     * Mediante este metodo se cargan los datos guardados previamente con el Objeto SharedPreferences
     * @param prefs este es el objeto utilizado para poder cargar los datos
     */
    public void Cargar(SharedPreferences prefs) {
        // TODO Recuperar los valores guardados en SharedPreferences
        prefs = getSharedPreferences("datos", Context.MODE_PRIVATE);
        recordar.setChecked(prefs.getBoolean("isChecked", false));
        usuario.setText(prefs.getString("usuario", ""));
        contraseña.setText(prefs.getString("contraseña", ""));
    }

    /**
     * Este metodo vacia los campos de texto de la actividad
     */
    public void Vaciar(){
        usuario.setText("");
        contraseña.setText("");
    }
    //endregion
    //region Mostrado

    /**
     * Mediante este metodo se muestras los campos de las contraseñas
     */
    public void muestra(){
        contraseña.setTransformationMethod(null);// Mostrar contraseña
        mostrar.setImageResource(R.drawable.ojo__1_);//Cambiar de imagen
    }
    /**
     * Mediante este metodo se ocultan los campos de las contraseñas
     */
    public void oculta(){
        contraseña.setTransformationMethod(new PasswordTransformationMethod()); //Ocultar contraseña
        mostrar.setImageResource(R.drawable.ojo);
    }
    //endregion
    //region Pin

    /**
     * Mediante este método crearemos un objeto llamdo ping y apbriremos un ventana de dialogo
     */
    public void openPinDialog() {
        Pin dialog = new Pin();
        dialog.show(getSupportFragmentManager(), "Pin");
    }

    /**
     * Mediate este metodo sabremos de si el pin introducido haya sido el correcto
     *
     * @param pin
     */
    @Override
    public void onPinEntered(String pin) {
        if (PIN.equals(pin)) {
            Intent intent = new Intent(this, CreaUsuario.class);
            startActivity(intent);
        } else {
            if (pin.length() == 4) {
                Toast.makeText(this, "PIN incorrecto", Toast.LENGTH_SHORT).show();
            }
        }
    }
    //endregion
    //region XML

    /**
     * Mediante este metodo se importan los datos desde un xml
     */
    public void importarDatos() {
        XmlPullParser xmlPull;
        ArrayList<Usuario> lstUsuario = null;
        boolean isEmpty;
        String sql;


        //TODO importa los datos de un XML

        //USUARIOS
        try {
            xmlPull = getXml(R.xml.ims_usuarios);
            lstUsuario = Parse.processParsingPartners(xmlPull);

            isEmpty = verifyEmpty("USUARIO");

            if (isEmpty) {
                for (Usuario user : lstUsuario) {
                    sql = "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) " +
                            "VALUES(" + user.getNombre() + ", '" + user.getContraseña() + "', '" + user.getSede() + "', '" + user.getPrivilegios() + "', '" + user.getMail() + "')";

                    db.execSQL(sql);
                }
            }

        } catch (IOException | XmlPullParserException e) {
            finish();
        } finally {
            String sqlTrigger = "CREATE TRIGGER IF NOT EXISTS new_usuario " +
                    "AFTER INSERT ON USUARIO " +
                    "BEGIN " +
                    "INSERT INTO LOG_USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE,MAIL) " +
                    "VALUES(NEW.NOMBRE, NEW.CONTRASEÑA, NEW.SEDE, NEW.PRIVILEGIOS, NEW.IDAGENTE, NEW.MAIL);" +
                    "END";

            db.execSQL(sqlTrigger);
        }
    }

    /**
     * Mediante este metodo consegiremos encontrar la ruta del xml
     * @param ruta
     * @return
     */
    public XmlPullParser getXml(int ruta) {
        XmlPullParser xml = null;

        try {
            // TODO Recogemos el fichero de productos en la variable xParser
            xml = getResources().getXml(ruta);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return xml;
    }



    //endregion
    //region ActividadLanzada

    /**
     * Verifica de que la base de datos este vacio o no
     * @param tabla
     * @return
     */
    public boolean verifyEmpty(String tabla) {
        boolean vacio = false;
        String sql = "SELECT * FROM " + tabla;
        Cursor c = db.rawQuery(sql, null);

        if (!c.moveToFirst()) {
            return true;
        }

        return vacio;
    }

    /**
     * Metodo para poder lanza avanzar a la siguiente actividad guardando ciertos datos
     */
    public void siguienteActividad(){
        Intent intento = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intento);
        //db.close();
        finish();
    }
    //endregion
    //region ModificaDB

    public void actualizaUsuario(){
        db.execSQL("UPDATE USUARIO SET LOGUEADO = 0");
    }
    /**
     * Mediante este metodo se insertan todos y cada uno de los usuarios en la base de datos interna de la aplicación
     */
    public void actualizaDB(){
        //db.execSQL("INSERT INTO USUARIOS (IDUSUARIO,NOMBRE,CONTRASEÑA,SEDE,PRIVILEGIOS,IDAGENTE,MAIL) VALUES("+idusuario+",'"+nombre+"','"+contra+"','"+sede+"','"+privilegios+"',"+idagente+","+mail+")");

        //SQLiteDatabase db = new DataBaseOpenHelper(getApplicationContext()).getReadableDatabase();
        if (db != null) {
            final String usuario[] = {
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'JUAN', '1234','INER EUSKADI','ADMIN',5,'jperez@inereus.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'JUAN')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'UNAI URRUTIA', 'UNAIURRUTIA', 'INER EUSKADI',  'COMERCIAL', 29, 'unaiurrutia4626@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'UNAI URRUTIA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'LUR GORRI BARAÑAIN GESTION SLU', '1234567890', 'INER EUSKADI',  'COMERCIAL', 0, 'plizarraga@lurgorriasesores.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'LUR GORRI BARAÑAIN GESTION SLU')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'GRUPO GONCLA ENERGIA SOLUCIONES SLU', '12345', 'INER EUSKADI', 'COMERCIAL', 0, 'gonclaenergiasoluciones@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'GRUPO GONCLA ENERGIA SOLUCIONES SLU')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'EKON SOLUCIONES', '1234567890', 'INER EUSKADI',  'COMERCIAL', 30, 'alex@ekonsoluciones.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'EKON SOLUCIONES')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'AJ ASESORES', '1234567890', 'INER EUSKADI', 'COMERCIAL', 0, 'javier@ajasesores.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'AJ ASESORES')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'JAIME GARCIA-CALZADA VILLAR', '1234567890', 'INER EUSKADI', 'COMERCIAL', 32, 'jaimevillargarciacalzada@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'JAIME GARCIA-CALZADA VILLAR')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'PATRICIA GARCIA SOLLA', 'PGSOLLA', 'INER EUSKADI', 'COMERCIAL', 33, 'patriciaa.dlife@hotmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'PATRICIA GARCIA SOLLA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'ANTXON SAGASTUME LARRAÑAGA', '1234567890', 'INER EUSKADI', 'COMERCIAL', 34, 'sagastume@vascastec.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'ANTXON SAGASTUME LARRAÑAGA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'OSCISA', '1234567890', 'INER EUSKADI', 'COMERCIAL', 35, 'yolanda@oscisa.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'OSCISA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'JUAN IGNACIO AGUIRRE URIA', '1234567890', 'INER EUSKADI', 'COMERCIAL', 36, 'ji.agirre@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'JUAN IGNACIO AGUIRRE URIA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'ALFER ENERGIA SL', '1234567890', 'INER EUSKADI', 'COMERCIAL', 37, 'fernando.diaz@grupoalfer.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'ALFER ENERGIA SL')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'ALBERTO OSCISA', '1234567890', 'INER EUSKADI', 'COMERCIAL', 38, 'contratacioneuskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'ALBERTO OSCISA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'TEIBA SOLUCIONES ENERGETICAS', '1234567890', 'INER EUSKADI', 'COMERCIAL', 40, 'solucionesteiba@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'TEIBA SOLUCIONES ENERGETICAS')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'JOSE MANUEL GRAU', '1234567890', 'INER CASTILLA', 'COMERCIAL', 0, 'josegrau999@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'JOSE MANUEL GRAU')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'JAB ENERGIA', '1234567890', 'INER EUSKADI', 'COMERCIAL', 6, 'jobeotsl@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'JAB ENERGIA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'EDURNE ARRIETA', '1234567890', 'INER EUSKADI', 'COMERCIAL', 7, 'edurnearrieta@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'EDURNE ARRIETA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'JAIME HERNANDEZ CALDERERO', 'JCALDERERO', 'INER EUSKADI',  'COMERCIAL', 8, 'jhcalderero@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'JAIME HERNANDEZ CALDERERO')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'JAVIER CARRERA', '1234567890', 'INER EUSKADI', 'COMERCIAL', 9, 'jjcc60@hotmail.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'JAVIER CARRERA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'ELENA ALONSO', '1234567890', 'INER EUSKADI', 'COMERCIAL', 10, 'e.alonso@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'ELENA ALONSO')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'JOSEBA ETXEBERRIA', 'JOSEBA', 'INER EUSKADI', 'COMERCIAL', 11, 'jooseba66608@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'JOSEBA ETXEBERRIA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'OIHAN IRURIETA', '1234567890', 'INER EUSKADI', 'COMERCIAL', 13, 'contratacioneuskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'OIHAN IRURIETA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'MAITE IRASTORZA', '1234567890', 'INER EUSKADI', 'COMERCIAL', 14, 'iras.maite@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'MAITE IRASTORZA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'INNOLUX', '1234567890', 'INER EUSKADI', 'COMERCIAL', 15, 'info@innolux.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'INNOLUX')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'EDUARDO ALBA', '1234567890', 'INER EUSKADI', 'COMERCIAL', 16, 'edualbaelias@yahoo.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'EDUARDO ALBA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'OLIVER ADRIAN', '1234567890', 'INER EUSKADI', 'COMERCIAL', 17, 'oadrian1980@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'OLIVER ADRIAN')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'MANUEL ALBERTO GARCIA', '1234567890', 'INER EUSKADI', 'COMERCIAL', 18, 'energiagestiones245@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'MANUEL ALBERTO GARCIA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'PATRICIA MADRID', '1234567890', 'INER EUSKADI', 'COMERCIAL', 20, 'asesoriaenergeticavillarino@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'PATRICIA MADRID')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'NORA LEGORBURU', '1234567890', 'INER EUSKADI', 'COMERCIAL', 21, 'contratacioneuskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'NORA LEGORBURU')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'EDURNE BARTOLOME', '1234567890', 'INER EUSKADI', 'COMERCIAL', 22, 'contratacioneuskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'EDURNE BARTOLOME')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'VALORIZACIONES ENERGETICAS SL', '1234567890', 'INER EUSKADI', 'COMERCIAL', 23, 'contratacioneuskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'VALORIZACIONES ENERGETICAS SL')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'IVAN LOPEZ', 'IVANLOPEZ', 'INER EUSKADI', 'ADMIN', 1, 'contratacioneuskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'IVAN LOPEZ')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'JOSE CASAS', 'JCASAS', 'INER EUSKADI', 'ADMIN', 1, 'contratacioneuskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'JOSE CASAS')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'RAMON BAGLIETTO', 'RBAGLIETTO', 'INER EUSKADI', 'ADMIN', 1, 'gerenciaeuskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'RAMON BAGLIETTO')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'SERGIO BAGLIETTO', 'SBAGLIETTO', 'INER EUSKADI', 'ADMIN', 1, 'contratacioneuskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'SERGIO BAGLIETTO')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'SERGIO LUHIA', 'SLUHIA', 'INER EUSKADI', 'ADMIN', 1, 'programacion@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'SERGIO LUHIA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'OSCAR CID GIL', 'OSCARCID', 'INER EUSKADI', 'NOMINA', 4, 'oscarcgeuskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'OSCAR CID GIL')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'ADMINEUS', 'ADMINEUS', 'INER EUSKADI', 'ADMIN', 1, 'contratacioneuskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'ADMINEUS')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'ADMIN', 'ADMIN', 'INER CASTILLA', 'ADMIN', 0, 'contratacioneuskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'ADMIN')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'INERCASTILLA', 'INER', 'INER CASTILLA', 'OFICINA', 24, 'contratacioneuskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'INERCASTILLA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'INEREUSKADI', 'INER', 'INER EUSKADI', 'OFICINA', 0, 'contratacioneuskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'INEREUSKADI')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'JESUS PEINADO', 'JESUSPEINADO', 'INER EUSKADI', 'OFICINA', 28, 'contratacioneuskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'JESUS PEINADO')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'comercial', 'comercial', 'INER EUSKADI', 'COMERCIAL', 0, 'contratacioneuskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'comercial')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'PEDRO MERINO', 'PEDRO', 'INER EUSKADI', 'COMERCIAL', 12, 'deluxespecialista@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'PEDRO MERINO')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'ARGIEDER. S.L.', 'ARGIEDER', 'INER EUSKADI', 'COMERCIAL', 27, 'janire@argieder.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'ARGIEDER. S.L.')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'JOSEBENITO', 'JOSEBENITO', 'INER EUSKADI', 'COMERCIAL', 0, 'jobeotsl@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'JOSEBENITO')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'ELENA', 'ELENA', 'INER EUSKADI', 'COMERCIAL', 0, 'contratacioneuskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'ELENA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'JAIME', 'JAIME', 'INER EUSKADI', 'COMERCIAL', 0, 'contratacioneuskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'JAIME')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'XABIER EIZAGIRRE', 'XABIER', 'INER EUSKADI', 'NOMINA', 26, 'xeizagirre.euskadi@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'XABIER EIZAGIRRE')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'VICTOR BALZATEGUI', 'VICTORBALZATEGUI', 'INER EUSKADI', 'COMERCIAL', 19, 'victorbal1953@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'VICTOR BALZATEGUI')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'JOSE FRANCISCO RAMON FRESNEDA', 'FRESNEDA', 'INER EUSKADI', 'COMERCIAL', 25, 'energiagestcom@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'JOSE FRANCISCO RAMON FRESNEDA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'FOTON ASESORES SOCIEDAD LIMITADA', 'FASESORES', 'INER CASTILLA', 'COMERCIAL', 356, 'fasesoreslimitada@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'FOTON ASESORES SOCIEDAD LIMITADA')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'DAVID', '1234', 'INER EUSKADI', 'ADMIN', 5, 'david.r.g.12.5.99@gmail.com' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'DAVID')",
                    "INSERT INTO USUARIO (NOMBRE, CONTRASEÑA, SEDE, PRIVILEGIOS, IDAGENTE, MAIL) SELECT 'LOPEZ', '1234', 'INER EUSKADI', 'ADMIN', 2, 'ilopez@inerenergia.es' WHERE NOT EXISTS(SELECT * FROM USUARIO WHERE NOMBRE = 'LOPEZ')"
            };

            for (String insert : usuario) {
                System.out.println(insert);
                db.execSQL(insert);
            }
        }
    }

    /**
     * Este consulta ss utiliza para buscar si existe el usuario y la constraseña que se introducen en la actividad
     */
    public void buscaDB() {
        String consulta = "SELECT * FROM USUARIO WHERE LOWER(NOMBRE) = '" + usuario.getText().toString().toLowerCase() + "' AND CONTRASEÑA = '" + contraseña.getText().toString() + "'";
        Cursor c;
        System.out.println(consulta);
        c = db.rawQuery(consulta, null);
        if (c.moveToFirst()) {
            db.execSQL("UPDATE USUARIO SET LOGUEADO = 1 WHERE NOMBRE = '" + usuario.getText().toString() + "'");
            importarDatos();
            siguienteActividad();
        } else {
            Toast.makeText(getApplicationContext(), "No existe ese usuario con esa contraseña", Toast.LENGTH_SHORT).show();
        }
    }
    //endregion
    //region Permisos

    /**
     * Mediante este método pediremos al usuario que conceda los permisos para poder hace uso de los archivos internos
     */
    // TODO PEDIR PERMISOS ANDROID
    private void requestWriteExternalStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            new AlertDialog.Builder(this).setTitle("Conceder permiso").setMessage("¿Quiere conceder el permiso de escritura?🙏").setPositiveButton("Permitir", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(LoginActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
                }
            }).show();

        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);

        }
    }
    //endregion

}
