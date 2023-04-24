package com.alumno.simulacionims.gas;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alumno.simulacionims.DataBaseHelper;
import com.alumno.simulacionims.R;
import com.alumno.simulacionims.luz.ActivityLuz;
import com.alumno.simulacionims.luz.ActivityLuz_Fecha;
import com.alumno.simulacionims.luz.ActivityLuz_Importe_Total;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * @author David Ruiz Garcia
 * Objeto ActivityGas_Fecha para hacer uso de la actividad con dicho nombre
 */
public class ActivityGas_Fecha extends AppCompatActivity {
    //region Variables
    private String inicio="";
    private String fin="";
    private String peaje;
    private String oferta;
    private int mYear, mMonth, mDay;
    private boolean validaFecha, validaCampos;

    private TextView rellena;
    private TextView mesinicio;
    private TextView mesfin;
    private EditText fechainicio;
    private EditText fechafin;
    private EditText diasfacturados;
    private EditText terminoFijo;
    private EditText AlquilerEquipo;

    private SharedPreferences prefs;
    private SQLiteDatabase db;

    private Button anterior;
    private Button siguiente;
    private CheckBox recordar;

    private ActivityResultLauncher activityLauncher;
    //endregion
    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_fecha);

        mesinicio = findViewById(R.id.lblMesInicioGas);
        mesfin = findViewById(R.id.lblMesFinGas);
        fechainicio = findViewById(R.id.txtFechaInicioGas);
        fechafin = findViewById(R.id.txtFechaFinGas);
        diasfacturados = findViewById(R.id.txtDiasFacturadosGas);
        terminoFijo = findViewById(R.id.txtE1InicioGas);
        AlquilerEquipo = findViewById(R.id.txtP1Gas);
        recordar = findViewById(R.id.chkRecordar2Gas);
        anterior = findViewById(R.id.btnAnterior1Gas);
        siguiente = findViewById(R.id.btnSiguiente1Gas);
        //rellena = findViewById(R.id.lblRellenar);

        DataBaseHelper inerbase = new DataBaseHelper(ActivityGas_Fecha.this, "IMS.db", null, 1);
        db = inerbase.getWritableDatabase();
        Bundle extras = getIntent().getExtras();

        peaje = extras.getString("peaje");
        oferta = extras.getString("oferta");

        Cargar(prefs);

        activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), null);


        deshabilitar();

        //region dtpFechaInicio
        fechainicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(ActivityGas_Fecha.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                inicio = getMonthByNumber(monthOfYear);
                                fechainicio.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                calcularDiferenciaFechas();
                                System.out.println(inicio.toUpperCase());
                                mesinicio.setText(inicio.toUpperCase(Locale.ROOT));

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });
        //endregion
        //region dtpFechaFin
        fechafin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(ActivityGas_Fecha.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                fin = getMonthByNumber(monthOfYear);
                                fechafin.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                calcularDiferenciaFechas();
                                System.out.println(fin.toUpperCase());
                                mesfin.setText(fin.toUpperCase(Locale.ROOT));

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        //endregion
        //region chkRecordar
        recordar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        //region btmSiguiente
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaFecha = validateDates();
                validaCampos = validaCampos();
                if(validaFecha==true && validaCampos == true) {
                    actualizaDB();
                    siguienteActividad();
                }

            }
        });
        //endregion

    }
    //endregion
    //region onBackPress

    /**
     * Mediante este método el usuario puede ir a la actividad anterior
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
     * Mediante este método bloquea la escritura en los campo que deseo que no sean modificables
     */
    private void deshabilitar(){
        diasfacturados.setEnabled(false);
    }
    //endregion
    //region ModificaCampos

    /**
     * Revisa que todos los que si los campos estan vacios automaticamento les pone valor 0
     * @return
     */
    private boolean validaCampos(){
        boolean validado;
        ArrayList<EditText> listaEdit = new ArrayList<EditText>();

        listaEdit.add(terminoFijo);
        listaEdit.add(AlquilerEquipo);

        try {
            for (int i = 0; i < listaEdit.size(); i++) {
                String valor;
                Double numero;

                if (!(listaEdit.get(i).getText().toString().length() > 0)) {
                    listaEdit.get(i).setText("0");

                }
                valor = listaEdit.get(i).getText().toString();

                try{

                    numero = Double.parseDouble(valor);

                }catch(Exception e){

                    Toast.makeText(getApplicationContext(), "No habido un error con la conversion de datos.", Toast.LENGTH_SHORT).show();
                    return validado = false;
                }
            }
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Ha habido un error con los campos a rellenar.",Toast.LENGTH_SHORT).show();
            return validado = false;
        }
        return validado=true;
    }
    //endregion
    //region ModificaFechas

    /**
     * Mediante este método se obtiene el mes de la fecha seleccionada pasandole por parametro el mes como número
     * @param monthnum este es el valor que se le pasa para sacar el mes
     * @return
     */
    private String getMonthByNumber(int monthnum) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        c.set(Calendar.MONTH, monthnum);
        Date date = c.getTime();
        return month_date.format(date);
    }

    /**
     * Mediante este método se valida si las fechas ingresadas nohagan cosas raras como
     * que la fecha de inicio sea mayor a la de fin y viceversa
     * @return
     */
    private boolean validateDates() {
        if (TextUtils.isEmpty(fechainicio.getText().toString())) {
            Toast.makeText(ActivityGas_Fecha.this, "Ingrese una fecha de inicio", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(fechafin.getText().toString())) {
            Toast.makeText(ActivityGas_Fecha.this, "Ingrese una fecha de fin", Toast.LENGTH_SHORT).show();
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date startDate = sdf.parse(fechainicio.getText().toString());
            Date endDate = sdf.parse(fechafin.getText().toString());
            Date currentDate = new Date(); // fecha actual

            if (endDate.compareTo(startDate) < 0) {
                // TODO La fecha de fin es anterior a la fecha de inicio
                Toast.makeText(ActivityGas_Fecha.this, "La fecha de fin no puede ser anterior a la fecha de inicio", Toast.LENGTH_SHORT).show();
                return false;
            } else if (startDate.compareTo(currentDate) > 0) {
                // TODO La fecha de inicio es posterior a la fecha actual
                Toast.makeText(ActivityGas_Fecha.this, "La fecha de inicio no puede ser posterior a la fecha actual", Toast.LENGTH_SHORT).show();
                return false;
            } else if (endDate.compareTo(currentDate) > 0) {
                // TODO La fecha de fin es posterior a la fecha actual
                Toast.makeText(ActivityGas_Fecha.this, "La fecha de fin no puede ser posterior a la fecha actual", Toast.LENGTH_SHORT).show();
                return false;
            } else if (endDate.compareTo(startDate) == 0) {
                // TODO Las fechas son iguales
                Toast.makeText(ActivityGas_Fecha.this, "Las fechas no pueden ser iguales", Toast.LENGTH_SHORT).show();
                return false;
            } else if (endDate.before(startDate)) {
                Toast.makeText(ActivityGas_Fecha.this, "La fecha de fin debe ser posterior a la fecha de inicio", Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     *  Mediante este metodo se calcula la diferencia de dia que hay entre los dias para sacar el total de dias facturados
     */
    private void calcularDiferenciaFechas() {
        // TODO Parsear las fechas seleccionadas
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        Date fechaInicio, fechaFin;
        try {
            fechaInicio = sdf.parse(fechainicio.getText().toString());
            fechaFin = sdf.parse(fechafin.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
            return; // TODO En caso de error, salir del método
        }

        TimeUnit timeUnit =  TimeUnit.DAYS;
        // TODO Calcular la diferencia en días

        int diffInDays = (int)( (fechaFin.getTime() - fechaInicio.getTime())
                / (1000 * 60 * 60 * 24) );
        System.out.println(diffInDays);
        // TODO Mostrar el resultado en el EditText
        diasfacturados.setText(String.valueOf(diffInDays));
    }
    //endregion
    //region Guardar_Cargar

    /**
     * Mediante este metodo se guardan los datos con el uso del Objeto SharedPreferences
     */
    public void Guardar() {
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("fecha_inicio", fechainicio.getText().toString());
        editor.putString("fecha_fin", fechafin.getText().toString());
        editor.putString("dias",diasfacturados.getText().toString());
        editor.putString("mes_inicio",mesinicio.getText().toString());
        editor.putString("mes_fin",mesfin.getText().toString());
        editor.putString("termino_fijo",terminoFijo.getText().toString());
        editor.putString("alquiler_equipo",AlquilerEquipo.getText().toString());
        editor.putBoolean("Checked", recordar.isChecked());
        editor.commit();
    }

    /**
     * Mediante este metodo se cargan los datos guardados previamente con el Objeto SharedPreferences
     * @param prefs este es el objeto utilizado para poder cargar los datos
     */
    public void Cargar(SharedPreferences prefs){
        try {
            //Recuperar los valores guardados en SharedPreferences
            prefs = getSharedPreferences("datos", Context.MODE_PRIVATE);
            recordar.setChecked(prefs.getBoolean("Checked", false));
            fechainicio.setText(prefs.getString("fecha_inicio", ""));
            fechafin.setText(prefs.getString("fecha_fin", ""));
            diasfacturados.setText(prefs.getString("dias", ""));
            mesinicio.setText(prefs.getString("mes_inicio",""));
            mesfin.setText(prefs.getString("mes_fin",""));
            terminoFijo.setText(prefs.getString("termino_fijo", ""));
            AlquilerEquipo.setText(prefs.getString("alquiler_equipo", ""));
        } catch(Exception e){
            Toast.makeText(getApplicationContext(),"Vuelve a escribir los datos a rellenar",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Este metodo vacia los campos de texto de la actividad
     */
    public void Vaciar(){
        fechainicio.setText("");
        fechafin.setText("");
        diasfacturados.setText("");
        mesinicio.setText((""));
        mesfin.setText((""));
        terminoFijo.setText("");
        AlquilerEquipo.setText("");
    }
    //endregion
    //region ModificaDB

    /**
     * Mediante este metodo los datos de la base de datos interna son modificados
     * mediante los datos que se recogen de la actividad
     */
    public void actualizaDB(){
        String actualizar= "UPDATE SIMULACION SET FECHA_INICIO = '"+fechainicio.getText().toString()+"', FECHA_FIN = '"+fechafin.getText().toString()+"',DIAS = '"+Integer.parseInt(diasfacturados.getText().toString())+
                "',E1_INICIO = "+Double.parseDouble(terminoFijo.getText().toString())+",ALQUILER_EQUIPO = "+Double.parseDouble(AlquilerEquipo.getText().toString())+" WHERE ID = 1";
        System.out.println(actualizar);
        db.execSQL(actualizar);
    }
    //endregion
    //region ActividadLanzada

    /**
     * Mediante este método se consigue ir a la siguiente actividad
     */
    public void siguienteActividad(){
        String mesInicio = mesinicio.getText().toString();
        String mesFin = mesfin.getText().toString();
        System.out.println(mesInicio);
        System.out.println(mesFin);
        Intent i = new Intent(getApplicationContext(), ActivityGas_Importe_Total.class);
        i.putExtra("mesInicioGas",mesInicio);
        i.putExtra("mesFinGas",mesFin);
        activityLauncher.launch(i);
    }

    /**
     * Mediante este método se consigue ir a la anterior actividad
     */
    public void anteriorActividad(){
        Intent i = new Intent(getApplicationContext(), ActivityGas.class);
        activityLauncher.launch(i);
    }
    //endregion

}
