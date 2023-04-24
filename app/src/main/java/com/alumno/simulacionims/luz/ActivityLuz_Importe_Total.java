package com.alumno.simulacionims.luz;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alumno.simulacionims.DataBaseHelper;
import com.alumno.simulacionims.R;
import com.alumno.simulacionims.SQLPostgresHelper;
import com.alumno.simulacionims.models.Pricing;
import com.alumno.simulacionims.models.Simulacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivityLuz_Importe_Total extends AppCompatActivity {

    private String P1str;
    private String P2str;
    private String P3str;
    private String P4str;
    private String P5str;
    private String P6str;
    private String E1str;
    private String E2str;
    private String E3str;
    private String E4str;
    private String E5str;
    private String E6str;
    private String mesi;
    private String mesf;
    private double e1;
    private double e2;
    private double e3;
    private double e4;
    private double e5;
    private double e6;
    private double p1;
    private double p2;
    private double p3;
    private double p4;
    private double p5;
    private double p6;
    private double e1total;
    private double e2total;
    private double e3total;
    private double e4total;
    private double e5total;
    private double e6total;
    private double p1total;
    private double p2total;
    private double p3total;
    private double p4total;
    private double p5total;
    private double p6total;
    private double consumoE1;
    private double consumoE2;
    private double consumoE3;
    private double consumoE4;
    private double consumoE5;
    private double consumoE6;
    private boolean igual;

    private EditText E1Importe;
    private EditText E2Importe;
    private EditText E3Importe;
    private EditText E4Importe;
    private EditText E5Importe;
    private EditText E6Importe;
    private EditText E1Total;
    private EditText E2Total;
    private EditText E3Total;
    private EditText E4Total;
    private EditText E5Total;
    private EditText E6Total;
    private EditText P1Importe;
    private EditText P2Importe;
    private EditText P3Importe;
    private EditText P4Importe;
    private EditText P5Importe;
    private EditText P6Importe;
    private EditText P1Total;
    private EditText P2Total;
    private EditText P3Total;
    private EditText P4Total;
    private EditText P5Total;
    private EditText P6Total;
    private Button anterior;
    private Button siguiente;

    private Pricing costFijo;
    private Simulacion simula;
    private ActivityResultLauncher activityLauncher;
    private SQLiteDatabase db;
    private SQLPostgresHelper pdb = new SQLPostgresHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luz_importe_total);

        E1Importe = findViewById(R.id.txtE1Importe);
        E2Importe = findViewById(R.id.txtE2Importe);
        E3Importe = findViewById(R.id.txtE3Importe);
        E4Importe = findViewById(R.id.txtE4Importe);
        E5Importe = findViewById(R.id.txtE5Importe);
        E6Importe = findViewById(R.id.txtE6Importe);
        E1Total = findViewById(R.id.txtE1Total);
        E2Total = findViewById(R.id.txtE2Total);
        E3Total = findViewById(R.id.txtE3Total);
        E4Total = findViewById(R.id.txtE4Total);
        E5Total = findViewById(R.id.txtE5Total);
        E6Total = findViewById(R.id.txtE6Total);
        P1Importe = findViewById(R.id.txtP1Importe);
        P2Importe = findViewById(R.id.txtP2Importe);
        P3Importe = findViewById(R.id.txtP3Importe);
        P4Importe = findViewById(R.id.txtP4Importe);
        P5Importe = findViewById(R.id.txtP5Importe);
        P6Importe = findViewById(R.id.txtP6Importe);
        P1Total = findViewById(R.id.txtP1Total);
        P2Total = findViewById(R.id.txtP2Total);
        P3Total = findViewById(R.id.txtP3Total);
        P4Total = findViewById(R.id.txtP4Total);
        P5Total = findViewById(R.id.txtP5Total);
        P6Total = findViewById(R.id.txtP6Total);
        anterior = findViewById(R.id.btnAnterior2);
        siguiente = findViewById(R.id.btnSiguiente2);

        Bundle extras = getIntent().getExtras();
        mesi = extras.getString("mesInicio");
        mesf = extras.getString("mesFin");
        activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), null);

        deshabilitar();
        simula = costeFijo();
        calcula_impo_tot();



        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ActivityLuz_Fecha.class);
                activityLauncher.launch(i);
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String actualizar = "UPDATE SIMULACION SET   E1_IMPORTE = '" + Double.parseDouble(E1Importe.getText().toString()) + "', E2_IMPORTE= '" + Double.parseDouble(E2Importe.getText().toString()) + "',E3_IMPORTE = '" + Double.parseDouble(E3Importe.getText().toString()) + "',E4_IMPORTE =' " + Double.parseDouble(E4Importe.getText().toString()) + "',E5_IMPORTE ='" + Double.parseDouble(E5Importe.getText().toString()) + "',E6_IMPORTE = '" + Double.parseDouble(E6Importe.getText().toString()) + "'," +
                        "E1_TOTAL = '" + Double.parseDouble(E1Total.getText().toString()) + "', E2_TOTAL= '" + Double.parseDouble(E2Total.getText().toString()) + "',E3_TOTAL = '" + Double.parseDouble(E3Total.getText().toString()) + "',E4_TOTAL =' " + Double.parseDouble(E4Total.getText().toString()) + "',E5_TOTAL ='" + Double.parseDouble(E5Total.getText().toString()) + "',E6_TOTAL = '" + Double.parseDouble(E6Total.getText().toString()) + "'," +
                        "P1_IMPORTE = '" + Double.parseDouble(P1Importe.getText().toString()) + "', P2_IMPORTE= '" + Double.parseDouble(P2Importe.getText().toString()) + "',P3_IMPORTE = '" + Double.parseDouble(P3Importe.getText().toString()) + "',P4_IMPORTE =' " + Double.parseDouble(P4Importe.getText().toString()) + "',P5_IMPORTE ='" + Double.parseDouble(P5Importe.getText().toString()) + "',P6_IMPORTE = '" + Double.parseDouble(P6Importe.getText().toString()) + "'," +
                        "P1_TOTAL = '" + Double.parseDouble(P1Total.getText().toString()) + "', P2_TOTAL= '" + Double.parseDouble(P2Total.getText().toString()) + "',P3_TOTAL = '" + Double.parseDouble(P3Total.getText().toString()) + "',P4_TOTAL =' " + Double.parseDouble(P4Total.getText().toString()) + "',P5_TOTAL ='" + Double.parseDouble(P5Total.getText().toString()) + "',P6_TOTAL = '" + Double.parseDouble(P6Total.getText().toString()) + "'";
                System.out.println(actualizar);
                db.execSQL(actualizar);
                Intent i = new Intent(getApplicationContext(), ActivityLuz_Totales.class);
                activityLauncher.launch(i);
            }
        });

    }


    //TODO Este metodo sirve para volver a la Main activity
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent i = new Intent(this, ActivityLuz_Fecha.class);
        activityLauncher.launch(i);
    }

    private void deshabilitar() {
        E1Importe.setEnabled(false);
        E2Importe.setEnabled(false);
        E3Importe.setEnabled(false);
        E4Importe.setEnabled(false);
        E5Importe.setEnabled(false);
        E6Importe.setEnabled(false);
        E1Total.setEnabled(false);
        E2Total.setEnabled(false);
        E3Total.setEnabled(false);
        E4Total.setEnabled(false);
        E5Total.setEnabled(false);
        E6Total.setEnabled(false);
        P1Importe.setEnabled(false);
        P2Importe.setEnabled(false);
        P3Importe.setEnabled(false);
        P4Importe.setEnabled(false);
        P5Importe.setEnabled(false);
        P6Importe.setEnabled(false);
        P1Total.setEnabled(false);
        P2Total.setEnabled(false);
        P3Total.setEnabled(false);
        P4Total.setEnabled(false);
        P5Total.setEnabled(false);
        P6Total.setEnabled(false);
    }

    @SuppressLint("Range")
    private Simulacion costeFijo() {
        String sentencia;
        Pricing cosFijo = new Pricing();
        Simulacion simu = new Simulacion();
        DataBaseHelper inerbase = new DataBaseHelper(ActivityLuz_Importe_Total.this, "IMS.db", null, 1);
        db = inerbase.getWritableDatabase();
        sentencia = "SELECT * FROM SIMULACION";
        System.out.println(sentencia);
        Cursor c = db.rawQuery(sentencia, null);

        c.moveToFirst();
        System.out.println(c.getString(c.getColumnIndex("PEAJE")));
        simu.setFecha_inicio(c.getString(c.getColumnIndex("FECHA_INICIO")));
        simu.setFecha_final(c.getString(c.getColumnIndex("FECHA_FIN")));
        simu.setDias(c.getInt(c.getColumnIndex("DIAS")));
        simu.setTarifa(c.getString(c.getColumnIndex("TARIFA")));
        simu.setPeaje(c.getString(c.getColumnIndex("PEAJE")));
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
        simu.setP1Importe(c.getDouble(c.getColumnIndex("P1_IMPORTE")));
        simu.setP6Importe(c.getDouble(c.getColumnIndex("P2_IMPORTE")));
        simu.setP6Importe(c.getDouble(c.getColumnIndex("P3_IMPORTE")));
        simu.setP6Importe(c.getDouble(c.getColumnIndex("P4_IMPORTE")));
        simu.setP6Importe(c.getDouble(c.getColumnIndex("P5_IMPORTE")));
        simu.setP6Importe(c.getDouble(c.getColumnIndex("P6_IMPORTE")));

        cosFijo.setPeaje(c.getString(1));
        cosFijo.setP1e(c.getDouble(2));
        cosFijo.setP2e(c.getDouble(3));
        cosFijo.setP3e(c.getDouble(4));
        cosFijo.setP4e(c.getDouble(5));
        cosFijo.setP5e(c.getDouble(6));
        cosFijo.setP6e(c.getDouble(7));
        cosFijo.setP1p(c.getDouble(8));
        cosFijo.setP2p(c.getDouble(9));
        cosFijo.setP3p(c.getDouble(10));
        cosFijo.setP4p(c.getDouble(11));
        cosFijo.setP5p(c.getDouble(12));
        cosFijo.setP6p(c.getDouble(13));


        c.close();
        return simu;
    }


    public static boolean obtenerNumeroMes(String fecha_inicio, String fecha_fin) {
        int inicio;
        int fin;
        if (fecha_inicio.split("-")[1].equals(fecha_fin.split("-")[1])) {
            return true;
            //Son iguales
        } else {
            return false;
        }
    }

    // TODO Función para extraer el número de un String
    private static String extraerNumero(String cadena) {
        // TODO Definir la expresión regular para encontrar el número
        String patron = "\\d+";

        // TODO Crear un objeto Pattern y Matcher
        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(cadena.replaceAll("INER BOE","0"));
        // TODO Buscar el número en la cadena
        if (m.find()) {
            String numero = m.group();

            // TODO Devolver el número
            return numero;
        } else {
            // TODO Si no se encuentra ningún número, devolver una cadena vacía
            return "0";
        }
    }

    public void calcula_impo_tot(){
        if (simula.getTarifa().contains("GESTION INER")) {
            if (simula.getPeaje() != null) {
                costFijo = pdb.getCGF(simula.getPeaje());

                e1 = costFijo.getP1e();
                e2 = costFijo.getP2e();
                e3 = costFijo.getP3e();
                e4 = costFijo.getP4e();
                e5 = costFijo.getP5e();
                e6 = costFijo.getP6e();

                p1 = costFijo.getP1p();
                p2 = costFijo.getP2p();
                p3 = costFijo.getP3p();
                p4 = costFijo.getP4p();
                p5 = costFijo.getP5p();
                p6 = costFijo.getP6p();

                if (simula.getTarifa().equalsIgnoreCase("GESTION INER INDEXADO".trim())) {

                    igual = obtenerNumeroMes(simula.getFecha_inicio(), simula.getFecha_final());

                    if (igual == true) {
                        costFijo = pdb.getCGFI(simula.getPeaje(), mesi);

                        e1 = costFijo.getP1e();
                        e2 = costFijo.getP2e();
                        e3 = costFijo.getP3e();
                        e4 = costFijo.getP4e();
                        e5 = costFijo.getP5e();
                        e6 = costFijo.getP6e();

                    } else {

                        int diasinicio, diasfin, dias;
                        double pr1, pr2, pr3, pr4, pr5, pr6, kwi1, kwi2, kwi3, kwi4, kwi5, kwi6, kwf1, kwf2, kwf3, kwf4, kwf5, kwf6, to1, to2, to3, to4, to5, to6;

                        String fechaini;
                        String fechafin;
                        fechaini = simula.getFecha_inicio();
                        fechafin = simula.getFecha_final();
                        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                        try {
                            Date dateInicio = format.parse(fechaini);
                            Date dateFin = format.parse(fechafin);

                            Calendar calInicio = Calendar.getInstance();
                            calInicio.setTime(dateInicio);

                            Calendar calFin = Calendar.getInstance();
                            calFin.setTime(dateFin);

                            // TODO Obtenemos los dias que tiene el mes inicial
                            Calendar calMesInicio = (Calendar) calInicio.clone();

                            diasinicio = calMesInicio.getActualMaximum(Calendar.DAY_OF_MONTH) - calInicio.get(Calendar.DAY_OF_MONTH) + 1;

                            // TODO Obtenemos el número de días del segundo mes
                            diasfin = calFin.get(Calendar.DAY_OF_MONTH);

                            dias = simula.getDias();

                            consumoE1 = (simula.getE1inicio() + simula.getE1fin());
                            consumoE2 = (simula.getE2inicio() + simula.getE2fin());
                            consumoE3 = (simula.getE3inicio() + simula.getE3fin());
                            consumoE4 = (simula.getE4inicio() + simula.getE4fin());
                            consumoE5 = (simula.getE5inicio() + simula.getE5fin());
                            consumoE6 = (simula.getE6inicio() + simula.getE6fin());

                            pr1 = consumoE1 / dias;
                            pr2 = consumoE2 / dias;
                            pr3 = consumoE3 / dias;
                            pr4 = consumoE4 / dias;
                            pr5 = consumoE5 / dias;
                            pr6 = consumoE6 / dias;


                            costFijo = pdb.getCGFI(simula.getPeaje(), mesi);
                            e1 = costFijo.getP1e();
                            e2 = costFijo.getP2e();
                            e3 = costFijo.getP3e();
                            e4 = costFijo.getP4e();
                            e5 = costFijo.getP5e();
                            e6 = costFijo.getP6e();

                            kwi1 = pr1 * diasinicio * e1;
                            kwi2 = pr2 * diasinicio * e2;
                            kwi3 = pr3 * diasinicio * e3;
                            kwi4 = pr4 * diasinicio * e4;
                            kwi5 = pr5 * diasinicio * e5;
                            kwi6 = pr6 * diasinicio * e6;

                            costFijo = pdb.getCGFI(simula.getPeaje(), mesf);
                            e1 = costFijo.getP1e();
                            e2 = costFijo.getP2e();
                            e3 = costFijo.getP3e();
                            e4 = costFijo.getP4e();
                            e5 = costFijo.getP5e();
                            e6 = costFijo.getP6e();


                            kwf1 = pr1 * diasfin * e1;
                            kwf2 = pr2 * diasfin * e2;
                            kwf3 = pr3 * diasfin * e3;
                            kwf4 = pr4 * diasfin * e4;
                            kwf5 = pr5 * diasfin * e5;
                            kwf6 = pr6 * diasfin * e6;

                            to1 = kwi1 + kwf1;
                            to2 = kwi2 + kwf2;
                            to3 = kwi3 + kwf3;
                            to4 = kwi4 + kwf4;
                            to5 = kwi5 + kwf5;
                            to6 = kwi6 + kwf6;

                            E1Importe.setText(String.valueOf(e1));
                            E2Importe.setText(String.valueOf(e2));
                            E3Importe.setText(String.valueOf(e3));
                            E4Importe.setText(String.valueOf(e4));
                            E5Importe.setText(String.valueOf(e5));
                            E6Importe.setText(String.valueOf(e6));

                            E1Total.setText(String.valueOf(to1));
                            E2Total.setText(String.valueOf(to2));
                            E3Total.setText(String.valueOf(to3));
                            E4Total.setText(String.valueOf(to4));
                            E5Total.setText(String.valueOf(to5));
                            E6Total.setText(String.valueOf(to6));


                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        } else if (simula.getTarifa().contains("COSTE GESTION")) {
            if (simula.getPeaje() != null) {
                costFijo = pdb.getCGF(simula.getPeaje());
                e1 = costFijo.getP1e() + Double.parseDouble(simula.getFee()) / 1000;
                e2 = costFijo.getP2e() + Double.parseDouble(simula.getFee()) / 1000;
                e3 = costFijo.getP3e() + Double.parseDouble(simula.getFee()) / 1000;
                e4 = costFijo.getP4e() + Double.parseDouble(simula.getFee()) / 1000;
                e5 = costFijo.getP5e() + Double.parseDouble(simula.getFee()) / 1000;
                e6 = costFijo.getP6e() + Double.parseDouble(simula.getFee()) / 1000;
                P1str = extraerNumero(simula.getPrecio_potencia());
                p1 = costFijo.getP1p() + Double.parseDouble(P1str) / 365;
                P2str = extraerNumero(simula.getPrecio_potencia());
                p2 = costFijo.getP2p() + Double.parseDouble(P2str) / 365;
                P3str = extraerNumero(simula.getPrecio_potencia());
                p3 = costFijo.getP3p() + Double.parseDouble(P3str) / 365;
                P4str = extraerNumero(simula.getPrecio_potencia());
                p4 = costFijo.getP4p() + Double.parseDouble(P4str) / 365;
                P5str = extraerNumero(simula.getPrecio_potencia());
                p5 = costFijo.getP5p() + Double.parseDouble(P5str) / 365;
                P6str = extraerNumero(simula.getPrecio_potencia());
                p6 = costFijo.getP6p() + Double.parseDouble(P6str) / 365;
                System.out.println(simula.getTarifa());
                if (simula.getTarifa().equalsIgnoreCase("COSTE GESTION INDEXADO".trim())) {

                    igual = obtenerNumeroMes(simula.getFecha_inicio(), simula.getFecha_final());

                    if (igual == true) {
                        costFijo = pdb.getCGFI(simula.getPeaje(), mesi);

                        e1 = costFijo.getP1e() + Double.parseDouble(simula.getFee()) / 1000;
                        e2 = costFijo.getP2e() + Double.parseDouble(simula.getFee()) / 1000;
                        e3 = costFijo.getP3e() + Double.parseDouble(simula.getFee()) / 1000;
                        e4 = costFijo.getP4e() + Double.parseDouble(simula.getFee()) / 1000;
                        e5 = costFijo.getP5e() + Double.parseDouble(simula.getFee()) / 1000;
                        e6 = costFijo.getP6e() + Double.parseDouble(simula.getFee()) / 1000;

                    } else {

                        int diasinicio, diasfin, dias;
                        double pr1, pr2, pr3, pr4, pr5, pr6, kwi1, kwi2, kwi3, kwi4, kwi5, kwi6, kwf1, kwf2, kwf3, kwf4, kwf5, kwf6, to1, to2, to3, to4, to5, to6;

                        String fechaini;
                        String fechafin;
                        fechaini = simula.getFecha_inicio();
                        fechafin = simula.getFecha_final();
                        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                        try {
                            Date dateInicio = format.parse(fechaini);
                            Date dateFin = format.parse(fechafin);

                            Calendar calInicio = Calendar.getInstance();
                            calInicio.setTime(dateInicio);

                            Calendar calFin = Calendar.getInstance();
                            calFin.setTime(dateFin);

                            // TODO Obtenemos los dias que tiene el mes inicial
                            Calendar calMesInicio = (Calendar) calInicio.clone();

                            diasinicio = calMesInicio.getActualMaximum(Calendar.DAY_OF_MONTH) - calInicio.get(Calendar.DAY_OF_MONTH) + 1;

                            // TODO Obtenemos el número de días del segundo mes
                            diasfin = calFin.get(Calendar.DAY_OF_MONTH);

                            dias = simula.getDias();

                            consumoE1 = (simula.getE1inicio() + simula.getE1fin());
                            consumoE2 = (simula.getE2inicio() + simula.getE2fin());
                            consumoE3 = (simula.getE3inicio() + simula.getE3fin());
                            consumoE4 = (simula.getE4inicio() + simula.getE4fin());
                            consumoE5 = (simula.getE5inicio() + simula.getE5fin());
                            consumoE6 = (simula.getE6inicio() + simula.getE6fin());

                            pr1 = consumoE1 / dias;
                            pr2 = consumoE2 / dias;
                            pr3 = consumoE3 / dias;
                            pr4 = consumoE4 / dias;
                            pr5 = consumoE5 / dias;
                            pr6 = consumoE6 / dias;


                            costFijo = pdb.getCGFI(simula.getPeaje(), mesi);
                            e1 = costFijo.getP1e() + Double.parseDouble(simula.getFee()) / 1000;
                            e2 = costFijo.getP2e() + Double.parseDouble(simula.getFee()) / 1000;
                            e3 = costFijo.getP3e() + Double.parseDouble(simula.getFee()) / 1000;
                            e4 = costFijo.getP4e() + Double.parseDouble(simula.getFee()) / 1000;
                            e5 = costFijo.getP5e() + Double.parseDouble(simula.getFee()) / 1000;
                            e6 = costFijo.getP6e() + Double.parseDouble(simula.getFee()) / 1000;

                            kwi1 = pr1 * diasinicio * e1;
                            kwi2 = pr2 * diasinicio * e2;
                            kwi3 = pr3 * diasinicio * e3;
                            kwi4 = pr4 * diasinicio * e4;
                            kwi5 = pr5 * diasinicio * e5;
                            kwi6 = pr6 * diasinicio * e6;

                            costFijo = pdb.getCGFI(simula.getPeaje(), mesf);
                            e1 = costFijo.getP1e() + Double.parseDouble(simula.getFee()) / 1000;
                            e2 = costFijo.getP2e() + Double.parseDouble(simula.getFee()) / 1000;
                            e3 = costFijo.getP3e() + Double.parseDouble(simula.getFee()) / 1000;
                            e4 = costFijo.getP4e() + Double.parseDouble(simula.getFee()) / 1000;
                            e5 = costFijo.getP5e() + Double.parseDouble(simula.getFee()) / 1000;
                            e6 = costFijo.getP6e() + Double.parseDouble(simula.getFee()) / 1000;


                            kwf1 = pr1 * diasfin * e1;
                            kwf2 = pr2 * diasfin * e2;
                            kwf3 = pr3 * diasfin * e3;
                            kwf4 = pr4 * diasfin * e4;
                            kwf5 = pr5 * diasfin * e5;
                            kwf6 = pr6 * diasfin * e6;

                            to1 = kwi1 + kwf1;
                            to2 = kwi2 + kwf2;
                            to3 = kwi3 + kwf3;
                            to4 = kwi4 + kwf4;
                            to5 = kwi5 + kwf5;
                            to6 = kwi6 + kwf6;

                            E1Importe.setText(String.valueOf(e1));
                            E2Importe.setText(String.valueOf(e2));
                            E3Importe.setText(String.valueOf(e3));
                            E4Importe.setText(String.valueOf(e4));
                            E5Importe.setText(String.valueOf(e5));
                            E6Importe.setText(String.valueOf(e6));

                            E1Total.setText(String.valueOf(to1));
                            E2Total.setText(String.valueOf(to2));
                            E3Total.setText(String.valueOf(to3));
                            E4Total.setText(String.valueOf(to4));
                            E5Total.setText(String.valueOf(to5));
                            E6Total.setText(String.valueOf(to6));


                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
        igual = obtenerNumeroMes(simula.getFecha_inicio(), simula.getFecha_final());
        if (igual == true) {

            consumoE1 = (simula.getE1inicio() + simula.getE1fin());
            consumoE2 = (simula.getE2inicio() + simula.getE2fin());
            consumoE3 = (simula.getE3inicio() + simula.getE3fin());
            consumoE4 = (simula.getE4inicio() + simula.getE4fin());
            consumoE5 = (simula.getE5inicio() + simula.getE5fin());
            consumoE6 = (simula.getE6inicio() + simula.getE6fin());

            E1Importe.setText(String.valueOf(e1));
            E2Importe.setText(String.valueOf(e2));
            E3Importe.setText(String.valueOf(e3));
            E4Importe.setText(String.valueOf(e4));
            E5Importe.setText(String.valueOf(e5));
            E6Importe.setText(String.valueOf(e6));
        } else {
            E1Importe.setText(String.valueOf(e1));
            E2Importe.setText(String.valueOf(e2));
            E3Importe.setText(String.valueOf(e3));
            E4Importe.setText(String.valueOf(e4));
            E5Importe.setText(String.valueOf(e5));
            E6Importe.setText(String.valueOf(e6));

        }


        P1Importe.setText(String.valueOf(p1));
        P2Importe.setText(String.valueOf(p2));
        P3Importe.setText(String.valueOf(p3));
        P4Importe.setText(String.valueOf(p4));
        P5Importe.setText(String.valueOf(p5));
        P6Importe.setText(String.valueOf(p6));
        // TODO Calculo de los totales de Energia o Consumo
        e1total = consumoE1 * e1;
        e2total = consumoE2 * e2;
        e3total = consumoE3 * e3;
        e4total = consumoE4 * e4;
        e5total = consumoE5 * e5;
        e6total = consumoE6 * e6;
        E1Total.setText(String.valueOf(e1total));
        E2Total.setText(String.valueOf(e2total));
        E3Total.setText(String.valueOf(e3total));
        E4Total.setText(String.valueOf(e4total));
        E5Total.setText(String.valueOf(e5total));
        E6Total.setText(String.valueOf(e6total));

        //Calculo de los totales de Potencia
        p1total = p1 * simula.getP1() * simula.getDias();
        p2total = p2 * simula.getP2() * simula.getDias();
        p3total = p3 * simula.getP3() * simula.getDias();
        p4total = p4 * simula.getP4() * simula.getDias();
        p5total = p5 * simula.getP5() * simula.getDias();
        p6total = p6 * simula.getP6() * simula.getDias();
        P1Total.setText(String.valueOf(p1total));
        P2Total.setText(String.valueOf(p2total));
        P3Total.setText(String.valueOf(p3total));
        P4Total.setText(String.valueOf(p4total));
        P5Total.setText(String.valueOf(p5total));
        P6Total.setText(String.valueOf(p6total));

    }

}