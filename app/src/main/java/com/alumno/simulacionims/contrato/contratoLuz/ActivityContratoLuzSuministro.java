package com.alumno.simulacionims.contrato.contratoLuz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
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
import com.alumno.simulacionims.models.Contrato;
import com.alumno.simulacionims.sips.ActivitySipsLuz;

/**
 * @author David Ruiz Garcia
 * Objeto con el que mediante la actividad para rellenar campos del Apartado de Suministro Contratos Luz
 */
public class ActivityContratoLuzSuministro extends AppCompatActivity {
    //region Variables

    private EditText direccion;
    private EditText numero;
    private EditText piso;
    private EditText puerta;
    private EditText localidad;
    private EditText provincia;
    private EditText cp;
    private EditText distribuidora;
    private EditText CUPS;
    private EditText CNAE;
    private EditText consumo;
    private Button BuscaConPot;
    private Button siguiente;
    private Button anterior;

    private CheckBox recordar;

    private SharedPreferences prefs;
    private Contrato contrato;
    private SQLiteDatabase db;
    private ActivityResultLauncher activityLauncher;
    //endregion
    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(androidx.appcompat.R.style.Theme_AppCompat_DayNight);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrato_luz_suministro);

        direccion = findViewById(R.id.txtDireccionSUMIContrato);
        numero= findViewById(R.id.txtNumeroSUMIContrato);
        piso = findViewById(R.id.txtPisoSUMIContrato);
        puerta = findViewById(R.id.txtPuertaSUMIContrato);
        localidad = findViewById(R.id.txtLocalidadSUMIContrato);
        provincia = findViewById(R.id.txtProvinciaSUMIContrato);
        cp = findViewById(R.id.txtCPSUMIContrato);
        distribuidora = findViewById(R.id.txtDistribuidoraSUMIContrato);
        CUPS = findViewById(R.id.txtCUPSSUMIContrato);
        CNAE = findViewById(R.id.txtCNAESUMIContrato);
        consumo = findViewById(R.id.txtConsumoSUMIContrato);
        BuscaConPot = findViewById(R.id.btnBuscaConsumo);
        recordar = findViewById(R.id.chkRecordarDatosSuministroLuz);
        siguiente = findViewById(R.id.btnSiguienteContratoLuz2);
        anterior = findViewById(R.id.btnAnteriorContratoLuz2);

        Cargar(prefs);
        contrato = recogeValores();
        activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), null);
        CUPS.setText(contrato.getCUPSSumi());
        consumo.setText(String.valueOf(contrato.getConsumoAnualSumi()));
        //region btnBuscaConsumo
        consumo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sipsActividad();
            }
        });
        //endregion

        //region btnSiguiente
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(direccion.length()==0 && numero.length()==0 && piso.length()==0 && puerta.length()==0 && localidad.length()==0 && provincia.length()==0 && cp.length()==0 && distribuidora.length()==0 && CUPS.length()==0 && CNAE.length()==0 && consumo.length()==0){
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
    //region deshabilitar
    /**
     * Mediante este método se deshabilitan ciertos campos para que no estos no sean modificables
     */
    public void deshabilitar(){
        CUPS.setEnabled(false);
        consumo.setEnabled(false);
    }
    //endregion
    //region Guardar_Cargar
    /**
     * Mediante este metodo se guardan los datos con el uso del Objeto SharedPreferences
     */
    public void Guardar(){
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();

        editor.putString("direccion", direccion.getText().toString());
        editor.putString("numero", numero.getText().toString());
        editor.putString("piso", piso.getText().toString());
        editor.putString("puerta", puerta.getText().toString());
        editor.putString("localidad", localidad.getText().toString());
        editor.putString("provincia", provincia.getText().toString());
        editor.putString("cp", cp.getText().toString());
        editor.putString("distribuidora", distribuidora.getText().toString());
        editor.putString("CUPS", CUPS.getText().toString());
        editor.putString("CNAE", CNAE.getText().toString());
        editor.putString("consumo", consumo.getText().toString());
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
            distribuidora.setText(prefs.getString("distribuidora", ""));
            CUPS.setText(prefs.getString("CUPS", ""));
            CNAE.setText(prefs.getString("CNAE", ""));
            consumo.setText(prefs.getString("consumo", ""));
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
        distribuidora.setText("");
        CUPS.setText("");
        CNAE.setText("");
        consumo.setText("");
    }
    //endregion
    //region ModificaDB

    /**
     * Mediante este metodo se actualiza la base de datos interna con los datos que se introducen en la actividad
     */
    public void actualizaDB() {

        String actualizar;
        actualizar = "UPDATE CONTRATO SET DIRECCION_SUMI = '" + direccion.getText().toString().toUpperCase().trim() +
                "', NUMERO_PORTAL_SUMI = '"+numero.getText().toString().toUpperCase().trim()+
                "', PISO_SUMI = '"+piso.getText().toString().toUpperCase().trim()+
                "', PUERTA_SUMI = '"+puerta.getText().toString().toUpperCase().trim()+
                "', LOCALIDAD_SUMI = '"+localidad.getText().toString().toUpperCase().trim()+
                "', PROVINCIA_SUMI = '"+provincia.getText().toString().toUpperCase().trim()+
                "', CODIGO_POSTAL_SUMI = '"+cp.getText().toString().toUpperCase().trim()+
                "', DISTRIBUIDORA_SUMI = '"+distribuidora.getText().toString().toUpperCase().trim()+
                "', CUPS_SUMI = '"+CUPS.getText().toString().toUpperCase().trim()+
                "', CNAE_SUMI = '"+Integer.parseInt(CNAE.getText().toString())+
                "' WHERE ID = 1";
        System.out.println(actualizar);
        db.execSQL(actualizar);
        Toast.makeText(getApplicationContext(), "Se han guardado los datos del Contrato", Toast.LENGTH_SHORT).show();
    }

    /**
     * Devuelve el Objeto Contrato con los datos de las potencias y el consumo anual que recogeremos de la base de datos interna
     * @return
     */
    @SuppressLint("Range")
    public Contrato recogeValores() {
        String sentencia;
        Contrato contra = new Contrato();
        DataBaseHelper inerbase = new DataBaseHelper(getApplicationContext(), "IMS.db", null, 1);
        db = inerbase.getWritableDatabase();
        sentencia = "SELECT * FROM CONTRATO";
        System.out.println(sentencia);
        Cursor c = db.rawQuery(sentencia, null);

        c.moveToFirst();
        contra.setCUPSSumi(c.getString(c.getColumnIndex("CUPS_SUMI")));
        contra.setConsumoAnualSumi(c.getDouble(c.getColumnIndex("CONSUMO_ANUAL")));
        contra.setP1Con(c.getDouble(c.getColumnIndex("POTENCIA1")));
        contra.setP2Con(c.getDouble(c.getColumnIndex("POTENCIA2")));
        contra.setP3Con(c.getDouble(c.getColumnIndex("POTENCIA3")));
        contra.setP4Con(c.getDouble(c.getColumnIndex("POTENCIA4")));
        contra.setP5Con(c.getDouble(c.getColumnIndex("POTENCIA5")));
        contra.setP6Con(c.getDouble(c.getColumnIndex("POTENCIA6")));


        c.close();
        return contra;
    }
    //endregion
    //region ActividadLanzada

    /**
     * Mediante este método se consigue ir a la siguiente actividad para el Contrato de Luz
     */
    public void siguienteActividad(){
        Intent intent = new Intent(getApplicationContext(), ActivityContratoLuzContacto.class);
        activityLauncher.launch(intent);
    }

    /**
     * Mediante este método se consigue ir a la anterior actividad para el Contrato Luz
     */
    public void anteriorActividad() {
        Intent intent = new Intent(getApplicationContext(), ActivityContratoLuz.class);
        activityLauncher.launch(intent);
    }

    /**
     * Mediante este método se consigue ir a la siguiente actividad para el Sips de Luz
     */
    public void sipsActividad(){

        Intent i = new Intent(getApplicationContext(), ActivitySipsLuz.class);
        i.putExtra("tipo","contrato");
        activityLauncher.launch(i);
    }
    //endregion
}