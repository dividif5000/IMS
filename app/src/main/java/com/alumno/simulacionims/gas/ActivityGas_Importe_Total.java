package com.alumno.simulacionims.gas;

import static com.alumno.simulacionims.luz.ActivityLuz_Importe_Total.obtenerNumeroMes;

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
import com.alumno.simulacionims.luz.ActivityLuz_Totales;
import com.alumno.simulacionims.models.Pricing;
import com.alumno.simulacionims.models.PricingGas;
import com.alumno.simulacionims.models.Simulacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivityGas_Importe_Total extends AppCompatActivity {
    //region Variables
    private String P1str;

    private String mesiGas;
    private String mesfGas;
    private double fijo;

    private double energia;

    private double consumo;
    private int dia;
    private double consumomedio;
    private double mediai;
    private double mediaf;
    private double pr_mediai;
    private double pr_mediaf;
    private double precio_i;
    private double precio_f;
    private double fijototal;

    private double energiatotal;

    private double variatot;

    private double fijotot;


    private boolean igual;

    private EditText FijoImporte;
    private EditText FijoTotal;
    private EditText VariableImporte;
    private EditText VariableTotal;
    private Button anterior;
    private Button siguiente;

    private PricingGas costFijo;
    private Simulacion simula;
    private ActivityResultLauncher activityLauncher;
    private SQLiteDatabase db;
    private SQLPostgresHelper pdb = new SQLPostgresHelper();
    //endregion
    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_importe_total);
        FijoImporte = findViewById(R.id.txtFijoImporte);
        FijoTotal = findViewById(R.id.txtFijoTotal);
        VariableImporte = findViewById(R.id.txtVariableImporte);
        VariableTotal = findViewById(R.id.txtVariableTotal);
        anterior = findViewById(R.id.btnAnterior2Gas);
        siguiente = findViewById(R.id.btnSiguiente2Gas);


        Bundle extras = getIntent().getExtras();
        mesiGas = extras.getString("mesInicioGas");
        System.out.println(mesiGas);
        mesfGas = extras.getString("mesFinGas");
        System.out.println(mesfGas);
        activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), null);

        deshabilitar();
        simula = costeFij();
        calcula_impo_tot();

        //region btnAnterior
        anterior.setOnClickListener(new View.OnClickListener() {
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
                actualizaDB();
                siguienteActividad();
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
    //region deshabilitar

    /**
     * Mediate este método se dehabilita el campo de dias facturados para que este no sea modificable
     */
    private void deshabilitar() {
        FijoImporte.setEnabled(false);

        FijoTotal.setEnabled(false);

        VariableImporte.setEnabled(false);

        VariableTotal.setEnabled(false);

    }
    //endregion
    //region Oferta

    /**
     * Método de que en caso de que la oferta sea = a INER BOE de 0
     * @param cadena
     * @return
     */
    // TODO Función para extraer el número de un String
    public static String extraerNumero(String cadena) {
        // TODO Definir la expresión regular para encontrar el número
        String patron = "\\d+";

        // TODO Crear un objeto Pattern y Matcher
        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(cadena.replaceAll("INER BOE", "0"));
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
    //endregion
    //region CalculaCampos

    /**
     * Método el cuanl dependiendo de la tarifa que se le pase de unos valores u otros tanto a la energia/consumo como a la potencia
     */
    public void calcula_impo_tot(){
                /*if (simula.getTarifa().contains("GESTION INER")) {
            if (simula.getPeaje() != null) {
                costFijo = pdb.getCGFG(simula.getPeaje());

                fijo = costFijo.getTermino_fijo();
                energia = costFijo.getTermino_variable();


            } else*/
        if (simula.getTarifa().contains("COSTE GESTION")) {
            if (simula.getPeaje() != null) {
                costFijo = pdb.getCGFG(simula.getPeaje());
                System.out.println(costFijo.getTermino_variable());
                energia = (double) costFijo.getTermino_variable() / 100.0 + (double) Double.parseDouble(simula.getFee()) / 1000.0;


                VariableImporte.setText(String.valueOf(energia));

                // TODO Calculo de los totales de Energia o Consumo
                variatot = energia * simula.getE1inicio();
                VariableTotal.setText(String.valueOf(variatot));

                fijo = (double) costFijo.getTermino_fijo() / 30;
                FijoImporte.setText(String.valueOf(fijo));
                // TODO Calculo de los totales de Fijo
                fijotot = fijo * simula.getDias();
                FijoTotal.setText(String.valueOf(fijotot));

                if (simula.getTarifa().equalsIgnoreCase("COSTE GESTION INDEXADO".trim())) {
                    System.out.println(simula.getPeaje()+"**************************************************************");
                    String pj = simula.getPeaje();
                    igual = obtenerNumeroMes(simula.getFecha_inicio(), simula.getFecha_final());

                    if (igual == true) {
                        costFijo = pdb.getCGFGI(pj, mesiGas);
                        consumo = simula.getE1inicio();
                        dia = simula.getDias();
                        precio_i = costFijo.getTermino_variable();
                        consumomedio = consumo / dia;
                        mediai = dia * consumomedio;
                        pr_mediai = mediai * precio_i;
                        energia = pr_mediai / consumo;

                    } else {

                        int diasinicio, diasfin;


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


                            costFijo = pdb.getCGFGI(pj, mesiGas);
                            consumo = simula.getE1inicio();
                            precio_i = costFijo.getTermino_variable();
                            consumomedio = consumo / diasinicio;
                            mediai = diasinicio * consumomedio;
                            pr_mediai = mediai * precio_i;


                            costFijo = pdb.getCGFGI(pj, mesfGas);
                            precio_f = costFijo.getTermino_variable();
                            consumomedio = consumo / diasfin;
                            mediaf = diasfin * consumomedio;
                            pr_mediaf = mediaf * precio_f;

                            energiatotal = (pr_mediai + pr_mediaf) / consumo;
                            VariableImporte.setText(String.valueOf(energiatotal));

                            variatot = energiatotal * simula.getE1inicio();
                            VariableTotal.setText(String.valueOf(variatot));


                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
    }
    //endregion
    //region ModificaFecha

    /**
     * Mediates este metodo se consige el numero del mes de las 2 fechas recogidas en la actividad anterior
     * @param fecha_inicio
     * @param fecha_fin
     * @return
     */
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
    //endregion
    //region ModificaDB

    /**
     * Devuelve el Objeto Simulacion con los datos de las potencias que recogeremos de la base de datos interna
     * @return
     */
    @SuppressLint("Range")
    private Simulacion costeFij() {
        String sentencia;

        Simulacion simu = new Simulacion();
        DataBaseHelper inerbase = new DataBaseHelper(ActivityGas_Importe_Total.this, "IMS.db", null, 1);
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
        System.out.println(c.getColumnIndex("PEAJE"));
        System.out.println(c.getString(c.getColumnIndex("PEAJE")));
        simu.setFee(c.getString(c.getColumnIndex("FEE")));
        simu.setPrecio_potencia(c.getString(c.getColumnIndex("PRECIO_POTENCIA")));
        simu.setE1inicio(c.getDouble(c.getColumnIndex("E1_INICIO")));
        simu.setP1(c.getDouble(c.getColumnIndex("P1")));
        simu.setE1Importe(c.getDouble(c.getColumnIndex("E1_IMPORTE")));
        simu.setP1Importe(c.getDouble(c.getColumnIndex("P1_IMPORTE")));

        c.close();
        return simu;
    }

    /**
     * Mediante este metodo los datos de la base de datos interna son modificados
     * mediante los datos que se recogen de la actividad
     */
    public void actualizaDB(){
        String actualizar = "UPDATE SIMULACION SET   E1_IMPORTE = '" + Double.parseDouble(VariableImporte.getText().toString()) + "',E1_TOTAL = '" + Double.parseDouble(VariableTotal.getText().toString()) +
                "', P1_IMPORTE = '" + Double.parseDouble(FijoImporte.getText().toString()) + "',P1_TOTAL = '" + Double.parseDouble(FijoTotal.getText().toString()) + "'";
        System.out.println(actualizar);
        db.execSQL(actualizar);
    }
    //endregion
    //region ActividadLanzada
    /**
     * Mediante este método se consigue ir a la siguiente actividad
     */
    public void siguienteActividad(){
        Intent i = new Intent(getApplicationContext(), ActivityGas_Totales.class);
        activityLauncher.launch(i);
    }

    /**
     * Mediante este método se consigue ir a la anterior actividad
     */
    public void anteriorActividad(){
        Intent i = new Intent(getApplicationContext(), ActivityGas_Fecha.class);
        activityLauncher.launch(i);
    }
    //endregion
}