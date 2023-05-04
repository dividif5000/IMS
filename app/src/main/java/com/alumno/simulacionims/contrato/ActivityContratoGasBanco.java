package com.alumno.simulacionims.contrato;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.alumno.simulacionims.DataBaseHelper;
import com.alumno.simulacionims.MainActivity;
import com.alumno.simulacionims.R;
import com.alumno.simulacionims.models.Contrato;

/**
 * @author David Ruiz Garcia
 * Objeto con el que mediante la actividad para rellenar campos del Apartado de Banco Contratos Gas
 */
public class ActivityContratoGasBanco extends AppCompatActivity {
    //region Variables
    private EditText nif;
    private EditText nombre;
    private EditText iban;
    private CheckBox recordar;
    private Button anterior;
    private Button contrat;
    private Button home;
    private SharedPreferences prefs;
    private SQLiteDatabase db;

    private Contrato contrato;
    private ActivityResultLauncher activityLauncher;
    //endregion
    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrato_gas_banco);

        nif = findViewById(R.id.txtNIfBANContratoGas);
        nombre = findViewById(R.id.txtNombreBANContratoGas);
        iban = findViewById(R.id.txtIBANBANContratoGas);
        recordar = findViewById(R.id.chkRecordarDatosBancoGas);
        anterior = findViewById(R.id.btnAnteriorContratoGas5);
        contrat = findViewById(R.id.btnCreaContratoFinalGas);
        home = findViewById(R.id.btnHomeContratoGas);

        contrato = recogeValores();
        Cargar(prefs);

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
        //region btnAnterior
        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anteriorActividad();
            }

        });
        //endregion
        //region btnHome
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizaDB();
                homeActividad();
            }
        });
        //endregion
        //region btnCreaContrato
        contrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nif.length() == 0 && nombre.length() == 0 && iban.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Tiene que rellenar los campos", Toast.LENGTH_SHORT).show();
                } else {
                    actualizaDB();
                    //siguienteActividad();
                }
            }
        });
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

        editor.putString("nif", nif.getText().toString());
        editor.putString("nombre", nombre.toString());
        editor.putString("iban", iban.toString());
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
            nif.setText(prefs.getString("nif", ""));
            nombre.setText(prefs.getString("nombre", ""));
            iban.setText(prefs.getString("iban", ""));

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Vuelve a escribir los datos a rellenar", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Este metodo vacia los campos de texto de la actividad
     */
    public void Vaciar() {
        nif.setText("");
        nombre.setText("");
        iban.setText("");
    }
    //endregion
    //region ModificaDB
    /**
     * Mediante este metodo se actualiza la base de datos interna con los datos que se introducen en la actividad
     */
    public void actualizaDB() {

        String actualizar;
        actualizar = "UPDATE CONTRATO SET NIF_BAN = '" + nif.getText().toString().toUpperCase().trim() + "',NOMBRE_BAN = '" + nombre.getText().toString().toUpperCase().trim() + "', IBAN = '" + iban.getText().toString().toUpperCase().trim() +
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

        contra.setPymeCli(c.getString(c.getColumnIndex("PYME_CONTRATO")));
        contra.setTipoContratoCli(c.getString(c.getColumnIndex("TIPO_CONTRATO")));
        contra.setPermaneciaCli(Boolean.parseBoolean(c.getString(c.getColumnIndex("PERMANENCIA_CONTRATO"))));
        contra.setTarifaCli(c.getString(c.getColumnIndex("TARIFA_CONTRATO")));
        contra.setPeajeCli(c.getString(c.getColumnIndex("PEAJE_CONTRATO")));
        contra.setCodigoTarifaCli(c.getString(c.getColumnIndex("CODIGO_TARIFA_CONRTATO")));
        contra.setTitularCli(c.getString(c.getColumnIndex("TITULAR_CLI")));
        contra.setApellidosCli(c.getString(c.getColumnIndex("APELLIDOS_CLI")));
        contra.setTelefono1Cli(c.getString(c.getColumnIndex("TELEFONO1_CLI")));
        contra.setTelefono2Cli(c.getString(c.getColumnIndex("TELEFONO2_CLI")));
        contra.setEmailCli(c.getString(c.getColumnIndex("MAIL_CLI")));
        contra.setDireccionCli(c.getString(c.getColumnIndex("DIRECCION_CLI")));
        contra.setNumeroDireCli(c.getString(c.getColumnIndex("NUMERO_PORTAL_CLI")));
        contra.setPisoDireCli(c.getString(c.getColumnIndex("PISO_CLI")));
        contra.setPuertaDireCli(c.getString(c.getColumnIndex("PUERTA_CLI")));
        contra.setLocalidadCli(c.getString(c.getColumnIndex("LOCALIDAD_CLI")));
        contra.setProvinciaCli(c.getString(c.getColumnIndex("PROVINCIA_CLI")));
        contra.setCPCli(c.getString(c.getColumnIndex("CODIGO_POSTAL")));
        contra.setRepresentanteCli(c.getString(c.getColumnIndex("REPRESENTANTE")));
        contra.setNIFRepresentanteCli(c.getString(c.getColumnIndex("NIF_REPRESENTANTE_CLI")));
        contra.setDireccionSumi(c.getString(c.getColumnIndex("DIRECCION_SUMI")));
        contra.setNumeroDireSumi(c.getString(c.getColumnIndex("NUMERO_PORTAL_SUMI")));
        contra.setPisoDireSumi(c.getString(c.getColumnIndex("PISO_SUMI")));
        contra.setPuertaDireSumi(c.getString(c.getColumnIndex("PUERTA_SUMI")));
        contra.setLocalidadSumi(c.getString(c.getColumnIndex("LOCALIDAD_SUMI")));
        contra.setProvinciaSumi(c.getString(c.getColumnIndex("PROVINCIA_SUMI")));
        contra.setCPSumi(c.getString(c.getColumnIndex("CODIGO_PORTAL_SUMI")));
        contra.setDistribuidoraSumi(c.getString(c.getColumnIndex("DISTRIBUIDORA_SUMI")));
        contra.setCUPSSumi(c.getString(c.getColumnIndex("CUPS_SUMI")));
        contra.setCNAESumi(c.getString(c.getColumnIndex("CNAE_SUMI")));
        contra.setConsumoAnualSumi(c.getDouble(c.getColumnIndex("CONSUMO_ANUAL")));
        contra.setDireccionCon(c.getString(c.getColumnIndex("DIRECCION_CON")));
        contra.setNumeroDireCon(c.getString(c.getColumnIndex("NUMERO_PORTAL_CON")));
        contra.setPisoDireCon(c.getString(c.getColumnIndex("PISO_CON")));
        contra.setPuertaDireCon(c.getString(c.getColumnIndex("PUERTA_CON")));
        contra.setLocalidadCon(c.getString(c.getColumnIndex("LOCALIDAD_CON")));
        contra.setProvinciaCon(c.getString(c.getColumnIndex("PROVINCIA_CON")));
        contra.setCPCon(c.getString(c.getColumnIndex("CODIGO_POSTAL_CON")));
        contra.setP1Con(c.getDouble(c.getColumnIndex("POTENCIA1")));
        contra.setP2Con(c.getDouble(c.getColumnIndex("POTENCIA2")));
        contra.setP3Con(c.getDouble(c.getColumnIndex("POTENCIA3")));
        contra.setP4Con(c.getDouble(c.getColumnIndex("POTENCIA4")));
        contra.setP5Con(c.getDouble(c.getColumnIndex("POTENCIA5")));
        contra.setP6Con(c.getDouble(c.getColumnIndex("POTENCIA6")));
        contra.setGarantiaDeOrigen(Boolean.parseBoolean(c.getString(c.getColumnIndex("GARANTIA"))));
        contra.setFechaInicioContrato(c.getString(c.getColumnIndex("FECH_INI_CONTRATO")));
        contra.setDuracionContrato(c.getString(c.getColumnIndex("DURACION_CONTRATO")));
        contra.setNifCifNieBan(c.getString(c.getColumnIndex("NIF_BAN")));
        contra.setNombreBan(c.getString(c.getColumnIndex("NOMBRE_BAN")));
        contra.setIBAN(c.getString(c.getColumnIndex("IBAN")));

        c.close();
        return contra;
    }
    //endregion
    //region ActividadLanzada

    /**
     * Mediante este método se consigue ir a la siguiente actividad para el Contrato de Luz
     */
    public void siguienteActividad() {
        Intent intent = new Intent(getApplicationContext(), ActivityContratoLuzBanco.class);
        activityLauncher.launch(intent);
    }

    /**
     * Mediante este método se consigue ir a la anterior actividad para el Contrato Luz
     */
    public void anteriorActividad() {
        Intent intent = new Intent(getApplicationContext(), ActivityContratoLuzProducto.class);
        activityLauncher.launch(intent);
    }
    /**
     * Mediante este método se consigue ir a la actividad menú
     */
    public void homeActividad() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setTitle("Home");
        builder.setMessage("¿Está seguro de que desea volver al Home? Se perderán los datos");

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                activityLauncher.launch(i);
                //finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    //endregion
}