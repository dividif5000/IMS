package com.alumno.simulacionims.luz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.alumno.simulacionims.DataBaseHelper;
import com.alumno.simulacionims.MainActivity;
import com.alumno.simulacionims.R;
import com.alumno.simulacionims.SQLPostgresHelper;
import com.alumno.simulacionims.contrato.ActivityContrato;
import com.alumno.simulacionims.contrato.contratoLuz.ActivityContratoLuz;
import com.alumno.simulacionims.models.CodigosPrecio;
import com.alumno.simulacionims.models.Simulacion;

import java.util.List;
import java.util.Locale;

/**
 * @author David Ruiz Garcia
 * Objeto ActivityLuz para hacer uso de la actividad con dicho nombre
 */
public class ActivityLuz extends AppCompatActivity {
    //region Variables
    private EditText cliente;
    private EditText cups;
    private Spinner pyme;
    private Spinner tipoContrato;
    private CheckBox permanencia;
    private Spinner tarifa;
    private Spinner peaje;
    private Spinner oferta;
    private Button atras;
    private Button siguiente;
    private CheckBox recordar;
    private SQLiteDatabase db;

    private SharedPreferences prefs;
    private List<CodigosPrecio> codigos;
    CodigosPrecio codigo;

    private Simulacion simula;


    private ActivityResultLauncher activityLauncher;
    private final String[] PYME = {"RESIDENCIAL", "PYME"};
    private final String[] TIPOCONTRA = {"Cambio de comercializadore sin cambios", "Cambio de comercializadora con cambios", "Renovación sin cambios", "Renovación con cambios", "Multipunto", "Alta Nueva", "Recuperación"};
    private final String[] TARI = {"COSTE GESTION FIJO", "COSTE GESTION INDEXADO", "GESTION INER FIJO", "GESTION INER INDEXADO"};
    private final String[] PEA = {"2.0TD", "3.0TD", "6.1TD"};

    private String tipo;

    //endregion
    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(androidx.appcompat.R.style.Theme_AppCompat_DayNight);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luz);

        cliente = findViewById(R.id.txtCliente);
        cups = findViewById(R.id.txtCUPS);
        pyme = findViewById(R.id.spnPyme);
        tipoContrato = findViewById(R.id.spnTipoContrato);
        permanencia = findViewById(R.id.chkPermanecia);
        tarifa = findViewById(R.id.spnTarifa);
        peaje = findViewById(R.id.spnPeaje);
        oferta = findViewById(R.id.spnOferta);
        atras = findViewById(R.id.btnAtras);
        siguiente = findViewById(R.id.btnSiguiente);
        recordar = findViewById(R.id.chkRecordar1);

        Bundle extras = getIntent().getExtras();
        tipo = extras.getString("tipo");
        System.out.println(tipo);
        ocultarCampos(cliente, cups, pyme, tipoContrato, permanencia, recordar, tipo);
        Cargar(prefs);
        simula = recogeValores();
        cups.setText(simula.getCups());


        activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), null);

        //region spnPyme
        ArrayAdapter<String> adaptadorPyme = new ArrayAdapter<String>
                (getApplicationContext(), R.layout.spinneriner, PYME);
        adaptadorPyme.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        pyme.setAdapter(adaptadorPyme);
        final String[] pym = {""};
        pyme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pym[0] = (String) pyme.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No seleccionaron nada
            }


        });
        //endregion
        //region spnTipoContrato
        ArrayAdapter<String> adaptadorTContrato = new ArrayAdapter<String>
                (getApplicationContext(), R.layout.spinneriner, TIPOCONTRA);
        adaptadorTContrato.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        tipoContrato.setAdapter(adaptadorTContrato);
        final String[] tCon = {""};
        tipoContrato.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tCon[0] = (String) tipoContrato.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No seleccionaron nada
            }


        });
        //endregion
        //region chkPermanencia
        permanencia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (permanencia.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Ha seleccionado la opción de Permanencia", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Ha deseleccionado la opción de Permanencia", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //endregion
        //region spnTarifa
        ArrayAdapter<String> adaptadorTarifa = new ArrayAdapter<String>
                (getApplicationContext(), R.layout.spinneriner, TARI);
        adaptadorTarifa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        tarifa.setAdapter(adaptadorTarifa);
        final String[] tar = {""};
        tarifa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tar[0] = (String) tarifa.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No seleccionaron nada
            }


        });
        //endregion
        //region spnPeaje
        ArrayAdapter<String> adaptadorPeaje = new ArrayAdapter<String>
                (getApplicationContext(), R.layout.spinneriner, PEA);
        adaptadorPeaje.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        peaje.setAdapter(adaptadorPeaje);
        String pe = (String) peaje.getSelectedItem();
        peaje.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String pe = (String) peaje.getSelectedItem();
                System.out.println("tarifa" + tar[0]);
                System.out.println("peaje" + pe);
                SQLPostgresHelper pdb = new SQLPostgresHelper();
                codigos = pdb.getCodigos(pe, tar[0]);
                String[] listofe;

                if (codigos.size() == 0) {
                    listofe = new String[1];
                    listofe[0] = "No hay precios";
                } else {
                    listofe = new String[codigos.size()];
                    for (int i = 0; i < codigos.size(); i++) {

                        listofe[i] = codigos.get(i).getCodigo();
                    }
                }
                ArrayAdapter<String> adaptadorOferta = new ArrayAdapter<String>
                        (getApplicationContext(), R.layout.spinneriner, listofe);
                adaptadorOferta.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                oferta.setAdapter(adaptadorOferta);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No seleccionaron nada
            }


        });
        //endregion
        //region spnOferta
        oferta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String ofe = (String) oferta.getSelectedItem();
                for (int i = 0; i < codigos.size(); i++) {
                    if (codigos.get(i).getCodigo().equals(ofe)) {
                        codigo = codigos.get(i);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No seleccionaron nada
            }


        });
        //endregion
        //region spnRecordar
        recordar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (recordar.isChecked()) {
                    Guardar();
                    Toast.makeText(getApplicationContext(), "Se recordaran los datos insertados", Toast.LENGTH_SHORT).show();
                } else {
                    Vaciar();
                    Guardar();
                    Toast.makeText(getApplicationContext(), "No se guardaran los datos insertados", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //endregion
        //region btnAnterior
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anteriorActividad();
            }
        });
        //endregion
        //region btnSiguiente
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tipo.equals("simulacion")) {
                    if (cliente.length() == 0 && cups.length() == 0 || oferta.getSelectedItem().toString().equalsIgnoreCase("No hay precios")) {
                        Toast.makeText(getApplicationContext(), "Tiene que rellenar los campos o debe de haber una OFERTA", Toast.LENGTH_SHORT).show();
                    } else {
                        actualizaSimulaDB();
                        lanzarSimulacionActividad(null);
                    }
                } else if (tipo.equals("contrato")) {
                    if (oferta.getSelectedItem().toString().equalsIgnoreCase("No hay precios")) {
                        Toast.makeText(getApplicationContext(), "Debe de haber una OFERTA", Toast.LENGTH_SHORT).show();

                    } else {
                        actualizaContratoDB();
                        lanzarContratoActividad(null);
                    }
                }
            }
        });
        //endregion
    }
    //endregion
    //region onBackPress

    /**
     * Mediante este método permitimos que el usuario pueda ir a la actividad anterior
     */
    //TODO Este metodo sirve para volver a la Main activity
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        anteriorActividad();
    }

    //endregion
    //region ModificaCampos

    /**
     * Mediante este método se que campos han de estar visible segun el tipo de actividad del que se provenga
     * @param cli
     * @param cup
     * @param pyme
     * @param tipoC
     * @param permanecia
     * @param rec
     * @param tip
     */
    public void ocultarCampos(EditText cli, EditText cup, Spinner pyme, Spinner tipoC, CheckBox permanecia, CheckBox rec, String tip) {
        if (tip.equals("simulacion")) {
            pyme.setVisibility(View.GONE);
            tipoC.setVisibility(View.GONE);
            permanecia.setVisibility(View.GONE);
        } else if (tip.equals("contrato")) {
            cli.setVisibility(View.GONE);
            cup.setVisibility(View.GONE);
            rec.setVisibility(View.GONE);
        }
    }
    //endregion
    //region Guardar_Cargar

    /**
     * Mediante este metodo se guardan los datos con el uso del Objeto SharedPreferences
     */
    public void Guardar() {

        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();

        editor.putString("cliente", cliente.getText().toString());
        editor.putString("cups", cups.getText().toString());
        editor.putBoolean("Checked", recordar.isChecked());
        editor.commit();
    }

    /**
     * Mediante este metodo se cargan los datos guardados previamente con el Objeto SharedPreferences
     *
     * @param prefs este es el objeto utilizado para poder cargar los datos
     */
    public void Cargar(SharedPreferences prefs) {
        try {
            //Recuperar los valores guardados en SharedPreferences
            prefs = getSharedPreferences("datos", Context.MODE_PRIVATE);
            recordar.setChecked(prefs.getBoolean("Checked", false));
            cliente.setText(prefs.getString("cliente", ""));
            cups.setText(prefs.getString("cups", ""));
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Vuelve a escribir los datos a rellenar", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Este metodo vacia los campos de texto de la actividad
     */
    public void Vaciar() {
        cliente.setText("");
        cups.setText("");
    }
    //endregion
    //region ModificaDB

    /**
     * Devuelve el Objeto Simulacion con los datos de el cups que recogeremos de la base de datos interna
     *
     * @return
     */
    @SuppressLint("Range")
    public Simulacion recogeValores() {
        String sentencia;
        Simulacion simu = new Simulacion();
        DataBaseHelper inerbase = new DataBaseHelper(getApplicationContext(), "IMS.db", null, 1);
        db = inerbase.getWritableDatabase();
        sentencia = "SELECT * FROM SIMULACION";
        System.out.println(sentencia);
        Cursor c = db.rawQuery(sentencia, null);

        c.moveToFirst();
        simu.setCups(c.getString(c.getColumnIndex("CUPS")));


        c.close();
        return simu;
    }

    /**
     * Mediante este método se recogen los valores de los spinner como string
     * y todos lo datos de la actividad se almacenan en la base de datos interna
     * en la tabla de Simulación
     */
    public void actualizaSimulaDB() {
        System.out.println("Tarifa: ");
        System.out.println(tarifa.getSelectedItem().toString());
        System.out.println("Peaje: ");
        System.out.println(peaje.getSelectedItem().toString());
        System.out.println("Oferta: ");
        System.out.println(oferta.getSelectedItem().toString());
        String actualizar;

        actualizar = "UPDATE SIMULACION SET CLIENTE = '" + cliente.getText().toString().toUpperCase(Locale.ROOT).trim() + "', CUPS = '" + cups.getText().toString().toUpperCase(Locale.ROOT).trim() + "', TARIFA = '" + tarifa.getSelectedItem().toString() + "', PEAJE = '" + peaje.getSelectedItem().toString() + "', OFERTA = '" + oferta.getSelectedItem().toString() + "', FEE = '" + codigo.getFeecuota() + "', PRECIO_POTENCIA ='" + codigo.getPrpotencia() + "' WHERE ID = 1";
        System.out.println(actualizar);
        db.execSQL(actualizar);
        Toast.makeText(getApplicationContext(), "Se han guardado los datos de la Simulación", Toast.LENGTH_SHORT).show();


    }

    /**
     * Mediante este método se recogen los valores de los spinner como string
     * y todos lo datos de la actividad se almacenan en la base de datos interna
     * en la tabla de Contrato
     */

    public void actualizaContratoDB() {
        System.out.println("Tarifa: ");
        System.out.println(tarifa.getSelectedItem().toString());
        System.out.println("Peaje: ");
        System.out.println(peaje.getSelectedItem().toString());
        System.out.println("Oferta: ");
        System.out.println(oferta.getSelectedItem().toString());
        String actualizar;
        actualizar = "UPDATE CONTRATO SET PYME_CONTRATO = '" + pyme.getSelectedItem().toString().toUpperCase(Locale.ROOT).trim() + "', TIPO_CONTRATO = '" + tipoContrato.getSelectedItem().toString() + "', PERMANENCIA_CONTRATO = " + (permanencia.isChecked() ? 1 : 0) + ", TARIFA_CONTRATO = '" + tarifa.getSelectedItem().toString() + "', PEAJE_CONTRATO = '" + peaje.getSelectedItem().toString() + "', CODIGO_TARIFA_CONTRATO = '" + oferta.getSelectedItem().toString() + "' WHERE ID = 1";
        System.out.println(actualizar);
        db.execSQL(actualizar);
        Toast.makeText(getApplicationContext(), "Se han guardado los datos del Contrato", Toast.LENGTH_SHORT).show();
    }
    //endregion
    //region ActividadLanzada

    /**
     * Metodo para poder lanza avanzar a la siguiente actividad de simulación guardando ciertos datos
     * @param view
     */
    public void lanzarSimulacionActividad(View view) {
        String peaj = peaje.getSelectedItem().toString();
        String ofer = oferta.getSelectedItem().toString();

        Intent intent = new Intent(getApplicationContext(), ActivityLuz_Fecha.class);
        intent.putExtra("peaje", peaj);
        intent.putExtra("oferta", ofer);
        activityLauncher.launch(intent);

    }

    /**
     * Metodo para poder lanza avanzar a la siguiente actividad de contrato
     * @param view
     */

    public void lanzarContratoActividad(View view){
        Intent intent = new Intent(getApplicationContext(), ActivityContratoLuz.class);
        intent.putExtra("tipo","contrato");
        activityLauncher.launch(intent);
    }


    /**
     * Mediante este método se consigue ir a la anterior actividad
     */
    public void anteriorActividad() {
        if (tipo.equals("simulacion")) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            activityLauncher.launch(i);
            //finish();

        } else if (tipo.equals("contrato")) {
            Intent intent = new Intent(getApplicationContext(), ActivityContrato.class);
            activityLauncher.launch(intent);
        }
    }
    //endregion

}