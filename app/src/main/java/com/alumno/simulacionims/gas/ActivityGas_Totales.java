package com.alumno.simulacionims.gas;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alumno.simulacionims.DataBaseHelper;
import com.alumno.simulacionims.MainActivity;
import com.alumno.simulacionims.R;
import com.alumno.simulacionims.models.Simulacion;
import com.alumno.simulacionims.pdf.PdfEditado_Simulacion;

import java.io.File;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ActivityGas_Totales extends AppCompatActivity {

    private String downloadPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
    private EditText gestion;
    private EditText impuesto;
    private EditText base;
    private EditText iva;
    private EditText total;
    private Button anterior;
    private Button home;
    private Button pdf;
    private Button precios;
    private static final int STORAGE_PERMISSION_CODE = 101;
    private float gest;
    private float impues;
    private float bas;
    private float iv;
    private float tot;
    private final double hidrocarburo = 0.00234;

    private ActivityResultLauncher activityLauncher;
    private SQLiteDatabase db ;
    private Simulacion simula = new Simulacion();
    private PdfEditado_Simulacion simula_luz = new PdfEditado_Simulacion() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_totales);

        gestion = findViewById(R.id.txtGestionGas);
        impuesto = findViewById(R.id.txtImpuestoHidrocarburosNumGas);
        base = findViewById(R.id.txtBaseGas);
        iva = findViewById(R.id.txtIvaNumGas);
        total = findViewById(R.id.txtTotalLuzGas);
        anterior = findViewById(R.id.btnAnteriorGas);
        home = findViewById(R.id.btnHomeGas);
        pdf = findViewById(R.id.btnPdfGas);

        activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), null);

        simula= costeFijo();
        deshabilitar();
        if(simula.getTarifa().contains("COSTE GESTION")) {
            gest = 0.0f;

        }else if(simula.getTarifa().contains("GESTION INER")){
            gest = Float.parseFloat(simula.getFee().replaceAll(",","."))*simula.getDias();
        }
        impues = (float) (hidrocarburo * simula.getE1inicio());
        bas = (float) (simula.getE1Total() + simula.getP1Total() + simula.getAlquiler_equipo() + impues);
        iv = (float) (bas * 21 / 100);
        tot = (float) (gest + bas + iv);

        // TODO Crear un objeto Locale personalizado para la moneda euro
        Locale euroLocale = new Locale("es", "ES"); // es_ES es el código para la moneda euro en España

        // TODO Crear un objeto NumberFormat para formato de moneda euro
        NumberFormat euroFormat = NumberFormat.getCurrencyInstance(euroLocale);

        gestion.setText(euroFormat.format(gest));
        base.setText(euroFormat.format(bas));
        impuesto.setText(euroFormat.format(impues));
        iva.setText(euroFormat.format(iv));
        total.setText(euroFormat.format(tot));

        String actualizar = "UPDATE SIMULACION SET   GESTION_INER = '" + gest + "', BASE_IMPONIBLE = '" + bas + "', IMPUESTO = '" + impues + "',IVA =' " + iv + "',TOTAL ='" + tot + "'";
        System.out.println(actualizar);
        db.execSQL(actualizar);

        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ActivityGas_Importe_Total.class);
                activityLauncher.launch(i);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityGas_Totales.this);
                builder.setTitle("Home");
                builder.setMessage("¿Está seguro de que desea volver al Home?");

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
        });

        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fecha = "";
                DateTimeFormatter dtf = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd HH-mm-ss");
                }
                LocalDateTime now = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    now = LocalDateTime.now();
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    fecha =dtf.format(now);
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityGas_Totales.this);
                builder.setTitle("PDF");
                builder.setMessage("¿Está seguro de que desea generar un PDF?");

                String finalFecha = fecha;
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                            // TODO Verificar si se tienen los permisos necesarios para guardar el archivo
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                                        == PackageManager.PERMISSION_DENIED) {
                                    String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                                    requestPermissions(permissions, STORAGE_PERMISSION_CODE);

                                } else {
                                    simula = costeFijo();
                                    // TODO Crear el archivo PDF
                                    simula_luz.createPDF_Gas(getApplicationContext(), simula);

                                    File pdfFile = new File(downloadPath,  "Simulacion-Gas"+ simula.getCups().toUpperCase(Locale.ROOT)+""+ finalFecha +".pdf"); ;
                                    System.out.println(pdfFile);
                                    Intent target = new Intent(Intent.ACTION_VIEW);
                                    target.setDataAndType(Uri.fromFile(pdfFile),"application/pdf");
                                    target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

                                    Intent intent = Intent.createChooser(target, "Open File");
                                    try {
                                        if(Build.VERSION.SDK_INT>=24){
                                            try{
                                                Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                                                m.invoke(null);
                                            }catch(Exception e){
                                                e.printStackTrace();
                                            }
                                        }
                                        startActivity(intent);
                                    } catch (ActivityNotFoundException e) {
                                        // Instruct the user to install a PDF reader here, or something
                                    }
                                }

                            } else {
                                simula = costeFijo();
                                // TODO Crear el archivo PDF
                                simula_luz.createPDF_Luz(getApplicationContext(), simula);

                                File pdfFile = new File(downloadPath,  "Simulacion-Gas"+ simula.getCups().toUpperCase(Locale.ROOT)+""+ finalFecha +".pdf"); ;
                                System.out.println(pdfFile);
                                Intent target = new Intent(Intent.ACTION_VIEW);
                                target.setDataAndType(Uri.fromFile(pdfFile),"application/pdf");
                                target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

                                Intent intent = Intent.createChooser(target, "Open File");
                                try {
                                    if(Build.VERSION.SDK_INT>=24){
                                        try{
                                            Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                                            m.invoke(null);
                                        }catch(Exception e){
                                            e.printStackTrace();
                                        }
                                    }
                                    startActivity(intent);
                                } catch (ActivityNotFoundException e) {
                                    // Instruct the user to install a PDF reader here, or something
                                }
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Error: La tarjeta SD no está montada", Toast.LENGTH_SHORT).show();
                        }
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

    }

    //TODO Este metodo sirve para volver a la Main activity
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent i = new Intent(this, ActivityGas_Importe_Total.class);
        activityLauncher.launch(i);
    }

    private void deshabilitar(){
        gestion.setEnabled(false);
        impuesto.setEnabled(false);
        base.setEnabled(false);
        iva.setEnabled(false);
        total.setEnabled(false);
    }

    @SuppressLint("Range")
    private Simulacion costeFijo(){
        String sentencia;
        //Pricing cosFijo = new Pricing();
        Simulacion simu = new Simulacion();
        DataBaseHelper inerbase = new DataBaseHelper(ActivityGas_Totales.this, "IMS.db", null, 1);
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



    // TODO Manejar el resultado de la solicitud de permisos
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Crear el archivo PDF
                simula_luz.createPDF_Luz(getApplicationContext(), simula);
            } else {
                Toast.makeText(this, "Permiso denegado para guardar el archivo", Toast.LENGTH_SHORT).show();
            }
        }
    }
}