package com.alumno.simulacionims.contrato;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.alumno.simulacionims.R;
import com.alumno.simulacionims.gas.ActivityGas;

import java.util.Locale;

public class ActivityContratoLuz extends AppCompatActivity {
    //region Variables
    private String tipo;
    private EditText titular;
    private EditText apellidos;
    private EditText dni;
    private EditText telefono1;
    private EditText telefono2;
    private EditText email;
    private EditText direccion;
    private EditText numero;
    private EditText piso;
    private EditText puerta;
    private EditText localidad;
    private EditText provincia;
    private EditText cp;
    private EditText representante;
    private EditText nifRepresentante;
    private Button siguiente;
    private Button anterior;

    private CheckBox recordar;

    private SharedPreferences prefs;
    private SQLiteDatabase db;
    private ActivityResultLauncher activityLauncher;
    //endregion
    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(androidx.appcompat.R.style.Theme_AppCompat_DayNight);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrato_luz);

        titular = findViewById(R.id.txtTitularCLIContrato);
        apellidos = findViewById(R.id.txtApellidosCLIContrato);
        dni = findViewById(R.id.txtDNICLIContrato);
        telefono1 = findViewById(R.id.txtTelefono1CLIContrato);
        telefono2 = findViewById(R.id.txtTelefono2CLIContrato);
        email = findViewById(R.id.txtEmailCLIContrato);
        direccion = findViewById(R.id.txtDireccionCLIContrato);
        numero= findViewById(R.id.txtNumeroCLIContrato);
        piso = findViewById(R.id.txtPisoCLIContrato);
        puerta = findViewById(R.id.txtPuertaCLIContrato);
        localidad = findViewById(R.id.txtLocalidadCLIContrato);
        provincia = findViewById(R.id.txtProvinciaCLIContrato);
        cp = findViewById(R.id.txtCPCLIContrato);
        representante = findViewById(R.id.txtRepresentanteCLIContrato);
        nifRepresentante = findViewById(R.id.txtNIFRepresentanteCLIContrato);
        recordar = findViewById(R.id.chkRecordarDatosClienteLuz);
        siguiente = findViewById(R.id.btnSiguienteContratoLuz1);
        anterior = findViewById(R.id.btnAnteriorContratoLuz1);

        Bundle extra = getIntent().getExtras();
        tipo = extra.getString("tipo");

        Cargar(prefs);

        //region btnSiguiente
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(titular.length()==0 && apellidos.length()==0 && dni.length()==0 && telefono1.length()==0 && telefono2.length()==0 && email.length()==0 && direccion.length()==0 && numero.length()==0 && piso.length()==0 && puerta.length()==0 && localidad.length()==0 && provincia.length()==0 && cp.length()==0 && representante.length()==0 && nifRepresentante.length()==0){
                    Toast.makeText(getApplicationContext(), "Tiene que rellenar los campos", Toast.LENGTH_SHORT).show();
                }else {
                    actualizaDB();
                    siguienteActividad();
                }
            }
        });
        //endregion
        //region btnAtras
        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tipo.equals("simulacion")){
                    anteriorSimulacionActividad();
                }else if(tipo.equals("contrato")){
                    anteriorContratoActividad();
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
                    Toast.makeText(getApplicationContext(), "Se recordaran los datos insertados", Toast.LENGTH_SHORT).show();
                } else {
                    Vaciar();
                    Guardar();
                    Toast.makeText(getApplicationContext(), "No se guardaran los datos insertados", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //endregion
    }
    //endregion
    //region onBackPress
    //TODO Este metodo sirve para volver a la Main activity

    /**
     * Mediante este método permitimos que el usuario pueda ir a la actividad anterior ya sea la de luz como la de contratos
     */
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if(tipo.equals("simulacion")){
            anteriorSimulacionActividad();
        }else if(tipo.equals("contrato")){
            anteriorContratoActividad();
        }

    }
    //endregion
    //region Guardar_Cargar
    /**
     * Mediante este metodo se guardan los datos con el uso del Objeto SharedPreferences
     */
    public void Guardar(){
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();

        editor.putString("titular", titular.getText().toString());
        editor.putString("apellidos", apellidos.getText().toString());
        editor.putString("dni", dni.getText().toString());
        editor.putString("telefono1", telefono1.getText().toString());
        editor.putString("telefono2", telefono2.getText().toString());
        editor.putString("email", email.getText().toString());
        editor.putString("direccion", direccion.getText().toString());
        editor.putString("numero", numero.getText().toString());
        editor.putString("piso", piso.getText().toString());
        editor.putString("puerta", puerta.getText().toString());
        editor.putString("localidad", localidad.getText().toString());
        editor.putString("provincia", provincia.getText().toString());
        editor.putString("cp", cp.getText().toString());
        editor.putString("representate", representante.getText().toString());
        editor.putString("nifRepre", nifRepresentante.getText().toString());
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
            titular.setText(prefs.getString("titular", ""));
            apellidos.setText(prefs.getString("apellidos", ""));
            dni.setText(prefs.getString("dni", ""));
            telefono1.setText(prefs.getString("telefono1", ""));
            telefono2.setText(prefs.getString("telefono2", ""));
            email.setText(prefs.getString("email", ""));
            direccion.setText(prefs.getString("direccion", ""));
            numero.setText(prefs.getString("numero", ""));
            piso.setText(prefs.getString("piso", ""));
            puerta.setText(prefs.getString("puerta", ""));
            localidad.setText(prefs.getString("localidad", ""));
            provincia.setText(prefs.getString("provincia", ""));
            cp.setText(prefs.getString("cp", ""));
            representante.setText(prefs.getString("representate", ""));
            nifRepresentante.setText(prefs.getString("nifRepre", ""));
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Vuelve a escribir los datos a rellenar", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Este metodo vacia los campos de texto de la actividad
     */
    public void Vaciar() {
        titular.setText("");
        apellidos.setText("");
        dni.setText("");
        telefono1.setText("");
        telefono2.setText("");
        email.setText("");
        direccion.setText("");
        numero.setText("");
        piso.setText("");
        puerta.setText("");
        localidad.setText("");
        provincia.setText("");
        cp.setText("");
        representante.setText("");
        nifRepresentante.setText("");
    }
    //endregion
    //region ModificaDB

    /**
     * Mediante este metodo se actualiza la base de datos interna con los datos que se introducen en la actividad
     */
    public void actualizaDB() {

        String actualizar;
        actualizar = "UPDATE CONTRATO SET TITULAR_CLI = '" + titular.getText().toString().toUpperCase(Locale.ROOT).trim() +
                "', APELLIDOS_CLI = '" +apellidos.getText().toString().toUpperCase().trim() + "', TELEFONO1_CLI = '" +telefono1.getText().toString().trim() +
                "', TELEFONO2_CLI = '" + telefono2.getText().toString().trim() + "', MAIL_CLI = '" + email.getText().toString().toLowerCase().trim() +
                "', DIRECCION_CLI = '" + direccion.getText().toString().toUpperCase().trim() + "', NUMERO_PORTAL_CLI = '"+numero.getText().toString().toUpperCase().trim()+
                "', PISO_CLI = '"+piso.getText().toString().toUpperCase().trim()+"', PUERTA_CLI = '"+puerta.getText().toString().toUpperCase().trim()+
                "', LOCALIDAD_CLI = '"+localidad.getText().toString().toUpperCase().trim()+"', PROVINCIA_CLI = '"+provincia.getText().toString().toUpperCase().trim()+
                "', CODIGO_POSTAL_CLI = '"+cp.getText().toString().toUpperCase().trim()+"', REPRESENTATE_CLI = '"+representante.getText().toString().toUpperCase().trim()+
                "', NIF_REPRESENTATE_CLI = '"+nifRepresentante.getText().toString().toUpperCase().trim()+"' WHERE ID = 1";
        System.out.println(actualizar);
        db.execSQL(actualizar);
        Toast.makeText(getApplicationContext(), "Se han guardado los datos del Contrato", Toast.LENGTH_SHORT).show();
    }
    //endregion
    //region ActividadLanzada

    /**
     * Mediante este método se consigue ir a la siguiente actividad para el Contrato de Luz
     */
    public void siguienteActividad(){
        Intent intent = new Intent(getApplicationContext(), ActivityContratoGasSuministro.class);
        activityLauncher.launch(intent);
    }

    /**
     * Mediante este método se consigue ir a la anterior actividad de luz
     */
    public void anteriorSimulacionActividad() {
        Intent intent = new Intent(getApplicationContext(), ActivityGas.class);
        activityLauncher.launch(intent);
    }

    /**
     * Mediante este método se consigue ir a la anterior actividad de contrato
     */
    public void anteriorContratoActividad(){
        Intent intent = new Intent(getApplicationContext(), ActivityContrato.class);
        activityLauncher.launch(intent);
    }
    //endregion
}