package com.alumno.simulacionims;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alumno.simulacionims.administrar.ActivityAdministrar;
import com.alumno.simulacionims.comisionado.ActivityComisionado;
import com.alumno.simulacionims.contrato.ActivityContrato;
import com.alumno.simulacionims.gas.ActivityGas;
import com.alumno.simulacionims.luz.ActivityLuz;
import com.alumno.simulacionims.mercado.ActivityMercado;
import com.alumno.simulacionims.models.Simulacion;
import com.alumno.simulacionims.pdf.PdfEditado_Simulacion;

public class MainActivity extends AppCompatActivity {

    //region Variables
    private String downloadPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
    private String borrar= "DELETE FROM SIMULACION WHERE 1 = 1";
    private static final int STORAGE_PERMISSION_CODE = 101;
    private Button luz;
    private Button gas;
    private Button oferta;
    private Button contrato;
    private Button comisionado;
    private Button administrar;
    private Button mercado;
    private Button salir;
    private SQLiteDatabase db;
    private Simulacion simula;
    private ActivityResultLauncher activityResultLauncher;
    private PdfEditado_Simulacion simula_luz = new PdfEditado_Simulacion() ;

    //endregion
    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        luz = findViewById(R.id.btnSimulaLuz);
        gas = findViewById(R.id.btnSimulaGas);
        oferta = findViewById(R.id.btnOferta);
        contrato = findViewById(R.id.btnContratos);
        comisionado = findViewById(R.id.btnComisionado);
        administrar = findViewById(R.id.btnAdministrar);
        mercado = findViewById(R.id.btnSituacionMercado);
        salir = findViewById(R.id.btnSalir);

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), null);

        DataBaseHelper inerbase = new DataBaseHelper(MainActivity.this, "IMS.db", null, 1);
        db = inerbase.getWritableDatabase();

       insertaDB();

        simula = costeFijo();

        //region btnLuz
        luz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, ActivityLuz.class);
                activityResultLauncher.launch(intento);
            }
        });
        //endregion
        //region btnGas
        gas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, ActivityGas.class);
                activityResultLauncher.launch(intento);
            }
        });
        //endregion
        //region btnOferta
        oferta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, com.alumno.simulacionims.sips.ActivitySips.class);
                activityResultLauncher.launch(intento);
            }
        });
        //endregion
        //region btnContrato
        contrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, ActivityContrato.class);
                activityResultLauncher.launch(intento);
            }
        });
        //endregion
        //region btnComisionado
        comisionado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, ActivityComisionado.class);
                activityResultLauncher.launch(intento);
            }
        });
        //endregion
        //region btnAdministrar
        administrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, ActivityAdministrar.class);
                activityResultLauncher.launch(intento);
            }
        });
        //endregion
        //region btnMercado
        mercado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, ActivityMercado.class);
                activityResultLauncher.launch(intento);
            }
        });
        //endregion
        //region btnSalir
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Cerrar Sesion");
                builder.setMessage("¿Está seguro de que desea cerrar sesion?");

                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DataBaseHelper tabla = new DataBaseHelper(getApplicationContext(), "IMS.db", null, 1);
                        db = tabla.getWritableDatabase();
                        db.execSQL("UPDATE USUARIO SET LOGUEADO = 0");
                        db.execSQL(borrar);
                        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(i);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Cerrar Sesion");
        builder.setMessage("¿Está seguro de que desea cerrar sesion?");

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DataBaseHelper tabla = new DataBaseHelper(getApplicationContext(), "IMS.db", null, 1);
                db = tabla.getWritableDatabase();
                db.execSQL("UPDATE USUARIO SET LOGUEADO = 0");
                db.execSQL(borrar);
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
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
    //region ModificaDB
    /**
     * Mediante este método se pueden insertar los datos predetenrminados para el uso de la tabla temporal de simulación
     */
    public void insertaDB(){
        if (db != null) {
            final String simulaLuz = "INSERT OR REPLACE INTO SIMULACION VALUES(1,' ' ,'' ,' ' ,' ' ,0,'' ,' ' ,' ' ,' ' ,' ',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)";
            System.out.println(simulaLuz);
            db.execSQL(simulaLuz);

            /*if (db != null) {
            final String simulaLuz = "INSERT OR REPLACE INTO SIMULACION VALUES(1,'pedro' ,'hfgg' ,'15-03-2023' ,'14-04-2023' ,29,'COSTE GESTION FIJO' ,'RL.1' ,'RL.1ZZ10' ,'10' ,'INER 10',27,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0.2287350000000000,0.184455,0.168265,0.01,0.01,0.01,52.15158,24.71697,34.32606,0,0,0,0.0969398802739726,0.031675930273972603,0.0273972602739726,0.0273972602739726,0.0273972602739726,0.0273972602739726,35.82897974926027,11.485663829260274,0,0,0,0,0,158.50925,0.7925462,33.28694,192.58873)";
            System.out.println(simulaLuz);
            db.execSQL(simulaLuz);
            }*/
        }
    }

    /**
     * Mediante este método podremos sacar la informacion de la base de datos devuolviendo el objeto simulacion
     * @return
     */
    @SuppressLint("Range")
    public Simulacion costeFijo(){
        String sentencia;
        //Pricing cosFijo = new Pricing();
        Simulacion simu = new Simulacion();
        DataBaseHelper inerbase = new DataBaseHelper(MainActivity.this, "IMS.db", null, 1);
        db = inerbase.getWritableDatabase();
        sentencia ="SELECT * FROM SIMULACION";
        System.out.println(sentencia);
        Cursor c = db.rawQuery(sentencia, null);

        c.moveToFirst();
        simu.setCliente(c.getString(c.getColumnIndex("CLIENTE")));
        simu.setCups(c.getString(c.getColumnIndex("CUPS")));
        simu.setFecha_inicio(c.getString(c.getColumnIndex("FECHA_INICIO")));
        simu.setFecha_final(c.getString(c.getColumnIndex("FECHA_FIN")));
        simu.setDias(c.getInt(c.getColumnIndex("DIAS")));
        simu.setTarifa(c.getString(c.getColumnIndex("TARIFA")));
        simu.setPeaje(c.getString(c.getColumnIndex("PEAJE")));
        simu.setOferta(c.getString(c.getColumnIndex("OFERTA")));
        simu.setFee(c.getString(c.getColumnIndex("FEE")));
        simu.setPrecio_potencia(c.getString(c.getColumnIndex("PRECIO_POTENCIA")));
        simu.setE1inicio(c.getDouble(c.getColumnIndex("E1_INICIO")));
        simu.setE2inicio(c.getDouble(c.getColumnIndex("E2_INICIO")));
        simu.setE3inicio(c.getDouble(c.getColumnIndex("E3_INICIO")));
        simu.setE4inicio(c.getDouble(c.getColumnIndex("E4_INICIO")));
        simu.setE5inicio(c.getDouble(c.getColumnIndex("E5_INICIO")));
        simu.setE6inicio(c.getDouble(c.getColumnIndex("E6_INICIO")));
        simu.setE1fin(c.getDouble(c.getColumnIndex("E1_FIN")));
        simu.setE2fin(c.getDouble(c.getColumnIndex("E2_FIN")));
        simu.setE3fin(c.getDouble(c.getColumnIndex("E3_FIN")));
        simu.setE4fin(c.getDouble(c.getColumnIndex("E4_FIN")));
        simu.setE5fin(c.getDouble(c.getColumnIndex("E5_FIN")));
        simu.setE6fin(c.getDouble(c.getColumnIndex("E6_FIN")));
        simu.setP1(c.getDouble(c.getColumnIndex("P1")));
        simu.setP2(c.getDouble(c.getColumnIndex("P2")));
        simu.setP3(c.getDouble(c.getColumnIndex("P3")));
        simu.setP4(c.getDouble(c.getColumnIndex("P4")));
        simu.setP5(c.getDouble(c.getColumnIndex("P5")));
        simu.setP6(c.getDouble(c.getColumnIndex("P6")));
        simu.setE1Importe(c.getDouble(c.getColumnIndex("E1_IMPORTE")));
        simu.setE2Importe(c.getDouble(c.getColumnIndex("E2_IMPORTE")));
        simu.setE3Importe(c.getDouble(c.getColumnIndex("E3_IMPORTE")));
        simu.setE4Importe(c.getDouble(c.getColumnIndex("E4_IMPORTE")));
        simu.setE5Importe(c.getDouble(c.getColumnIndex("E5_IMPORTE")));
        simu.setE6Importe(c.getDouble(c.getColumnIndex("E6_IMPORTE")));
        simu.setE1Total(c.getDouble(c.getColumnIndex("E1_TOTAL")));
        simu.setE2Total(c.getDouble(c.getColumnIndex("E2_TOTAL")));
        simu.setE3Total(c.getDouble(c.getColumnIndex("E3_TOTAL")));
        simu.setE4Total(c.getDouble(c.getColumnIndex("E4_TOTAL")));
        simu.setE5Total(c.getDouble(c.getColumnIndex("E5_TOTAL")));
        simu.setE6Total(c.getDouble(c.getColumnIndex("E6_TOTAL")));
        simu.setP1Importe(c.getDouble(c.getColumnIndex("P1_IMPORTE")));
        simu.setP2Importe(c.getDouble(c.getColumnIndex("P2_IMPORTE")));
        simu.setP3Importe(c.getDouble(c.getColumnIndex("P3_IMPORTE")));
        simu.setP4Importe(c.getDouble(c.getColumnIndex("P4_IMPORTE")));
        simu.setP5Importe(c.getDouble(c.getColumnIndex("P5_IMPORTE")));
        simu.setP6Importe(c.getDouble(c.getColumnIndex("P6_IMPORTE")));
        simu.setP1Total(c.getDouble(c.getColumnIndex("P1_TOTAL")));
        simu.setP2Total(c.getDouble(c.getColumnIndex("P2_TOTAL")));
        simu.setP3Total(c.getDouble(c.getColumnIndex("P3_TOTAL")));
        simu.setP4Total(c.getDouble(c.getColumnIndex("P4_TOTAL")));
        simu.setP5Total(c.getDouble(c.getColumnIndex("P5_TOTAL")));
        simu.setP6Total(c.getDouble(c.getColumnIndex("P6_TOTAL")));
        simu.setGestio_iner(c.getDouble(c.getColumnIndex("GESTION_INER")));
        simu.setBase_imponible(c.getDouble(c.getColumnIndex("BASE_IMPONIBLE")));
        simu.setImpuesto(c.getDouble(c.getColumnIndex("IMPUESTO")));
        simu.setIva(c.getDouble(c.getColumnIndex("IVA")));
        simu.setTotal(c.getDouble(c.getColumnIndex("TOTAL")));

        c.close();
        return simu;
    }
    //endregion
    //region Permisos

    /**
     * Este método permite que al usuario le pregunte por los permisos de guardado dentro de su sipositivo
     * @param requestCode
     * @param permissions .
     * @param grantResults
     */
    // TODO Manejar el resultado de la solicitud de permisos
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {
                Toast.makeText(this, "Permiso denegado para guardar el archivo", Toast.LENGTH_SHORT).show();
            }
        }
    }
    //endregion

}