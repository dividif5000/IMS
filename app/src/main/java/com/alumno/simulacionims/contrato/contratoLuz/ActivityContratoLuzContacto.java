package com.alumno.simulacionims.contrato.contratoLuz;

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
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.alumno.simulacionims.DataBaseHelper;
import com.alumno.simulacionims.R;

/**
 * @author David Ruiz Garcia
 * Objeto con el que mediante la actividad para rellenar campos del Apartado de Contacto Contratos Luz
 */
public class ActivityContratoLuzContacto extends AppCompatActivity {
    //region Variables

    private EditText direccion;
    private EditText numero;
    private EditText piso;
    private EditText puerta;
    private EditText localidad;
    private EditText provincia;
    private EditText cp;
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
        setContentView(R.layout.activity_contrato_luz_contacto);

        direccion = findViewById(R.id.txtDireccionCONContrato);
        numero = findViewById(R.id.txtNumeroCONContrato);
        piso = findViewById(R.id.txtPisoCONContrato);
        puerta = findViewById(R.id.txtPuertaCONContrato);
        localidad = findViewById(R.id.txtLocalidadCONContrato);
        provincia = findViewById(R.id.txtProvinciaCONContrato);
        cp = findViewById(R.id.txtCPCONContrato);
        recordar = findViewById(R.id.chkRecordarDatosContacto);
        siguiente = findViewById(R.id.btnSiguienteContratoLuz3);
        anterior = findViewById(R.id.btnAnteriorContratoLuz3);


        Cargar(prefs);
        DataBaseHelper inerbase = new DataBaseHelper(getApplicationContext(), "IMS.db", null, 1);
        db = inerbase.getWritableDatabase();
        activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), null);
        //region btnSiguiente
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (direccion.length() == 0 && numero.length() == 0 && piso.length() == 0 && puerta.length() == 0 && localidad.length() == 0 && provincia.length() == 0 && cp.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Tiene que rellenar los campos", Toast.LENGTH_SHORT).show();
                } else {
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
                anteriorActividad();
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
     * Mediante este método permitimos que el usuario pueda ir a la actividad anterior
     */
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        anteriorActividad();
    }
    //endregion
    //region Guardar_Cargar

    /**
     * Mediante este metodo se guardan los datos con el uso del Objeto SharedPreferences
     */
    public void Guardar() {
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();

        editor.putString("direccion", direccion.getText().toString());
        editor.putString("numero", numero.getText().toString());
        editor.putString("piso", piso.getText().toString());
        editor.putString("puerta", puerta.getText().toString());
        editor.putString("localidad", localidad.getText().toString());
        editor.putString("provincia", provincia.getText().toString());
        editor.putString("cp", cp.getText().toString());
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
            direccion.setText(prefs.getString("direccion", ""));
            numero.setText(prefs.getString("numero", ""));
            piso.setText(prefs.getString("piso", ""));
            puerta.setText(prefs.getString("puerta", ""));
            localidad.setText(prefs.getString("localidad", ""));
            provincia.setText(prefs.getString("provincia", ""));
            cp.setText(prefs.getString("cp", ""));
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Vuelve a escribir los datos a rellenar", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Este metodo vacia los campos de texto de la actividad
     */
    public void Vaciar() {
        direccion.setText("");
        numero.setText("");
        piso.setText("");
        puerta.setText("");
        localidad.setText("");
        provincia.setText("");
        cp.setText("");
    }
    //endregion
    //region ModificaDB

    /**
     * Mediante este metodo se actualiza la base de datos interna con los datos que se introducen en la actividad
     */
    public void actualizaDB() {

        String actualizar;
        actualizar = "UPDATE CONTRATO SET DIRECCION_CON = '" + direccion.getText().toString().toUpperCase().trim() + "', NUMERO_PORTAL_CON = '" + numero.getText().toString().toUpperCase().trim() +
                "', PISO_CON = '" + piso.getText().toString().toUpperCase().trim() + "', PUERTA_CON = '" + puerta.getText().toString().toUpperCase().trim() +
                "', LOCALIDAD_CON = '" + localidad.getText().toString().toUpperCase().trim() + "', PROVINCIA_CON = '" + provincia.getText().toString().toUpperCase().trim() +
                "', CODIGO_POSTAL_CON = '" + cp.getText().toString().toUpperCase().trim() + "' WHERE ID = 1";
        System.out.println(actualizar);
        db.execSQL(actualizar);
        Toast.makeText(getApplicationContext(), "Se han guardado los datos del Contrato", Toast.LENGTH_SHORT).show();
    }
    //endregion
    //region ActividadLanzada

    /**
     * Mediante este método se consigue ir a la siguiente actividad para el Contrato de Luz
     */
    public void siguienteActividad() {
        Intent intent = new Intent(getApplicationContext(), ActivityContratoLuzProducto.class);
        activityLauncher.launch(intent);
    }

    /**
     * Mediante este método se consigue ir a la anterior actividad para el Contrato Luz
     */
    public void anteriorActividad() {
        Intent intent = new Intent(getApplicationContext(), ActivityContratoLuzSuministro.class);
        activityLauncher.launch(intent);
    }
    //endregion
}

