package com.alumno.simulacionims.luz;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
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
import com.alumno.simulacionims.models.Pricing;
import com.alumno.simulacionims.models.Simulacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * @author David Ruiz Garcia
 * Objeto ActivityLuz_Fecha para hacer uso de la actividad con dicho nombre
 */
public class ActivityLuz_Fecha extends AppCompatActivity {
    //region Variables
    private String inicio = "";
    private String fin = "";
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
    private EditText E1inicio;
    private EditText E2inicio;
    private EditText E3inicio;
    private EditText E4inicio;
    private EditText E5inicio;
    private EditText E6inicio;
    private EditText E1fin;
    private EditText E2fin;
    private EditText E3fin;
    private EditText E4fin;
    private EditText E5fin;
    private EditText E6fin;
    private EditText txtP1;
    private EditText txtP2;
    private EditText txtP3;
    private EditText txtP4;
    private EditText txtP5;
    private EditText txtP6;

    private SQLiteDatabase db;
    private LinearLayout E4, E5, E6, P3, P4, P5, P6;

    private Button anterior;
    private Button siguiente;
    private CheckBox recordar;

    private ActivityResultLauncher activityLauncher;

    private Simulacion simula;
    private SharedPreferences prefe;
    //endregion
    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luz_fecha);

        mesinicio = findViewById(R.id.lblMesInicio);
        mesfin = findViewById(R.id.lblMesFin);
        fechainicio = findViewById(R.id.txtFechaInicio);
        fechafin = findViewById(R.id.txtFechaFin);
        diasfacturados = findViewById(R.id.txtDiasFacturados);
        E1inicio = findViewById(R.id.txtE1Inicio);
        E2inicio = findViewById(R.id.txtE2Inicio);
        E3inicio = findViewById(R.id.txtE3Inicio);
        E4inicio = findViewById(R.id.txtE4Inicio);
        E5inicio = findViewById(R.id.txtE5Inicio);
        E6inicio = findViewById(R.id.txtE6Inicio);
        E1fin = findViewById(R.id.txtE1Fin);
        E2fin = findViewById(R.id.txtE2Fin);
        E3fin = findViewById(R.id.txtE3Fin);
        E4fin = findViewById(R.id.txtE4Fin);
        E5fin = findViewById(R.id.txtE5Fin);
        E6fin = findViewById(R.id.txtE6Fin);
        txtP1 = findViewById(R.id.txtP1);
        txtP2 = findViewById(R.id.txtP2);
        txtP3 = findViewById(R.id.txtP3);
        txtP4 = findViewById(R.id.txtP4);
        txtP5 = findViewById(R.id.txtP5);
        txtP6 = findViewById(R.id.txtP6);
        P3 = findViewById(R.id.layoutP3);
        P4 = findViewById(R.id.layoutP4);
        P5 = findViewById(R.id.layoutP5);
        P6 = findViewById(R.id.layoutP6);
        E4 = findViewById(R.id.layoutE4);
        E5 = findViewById(R.id.layoutE5);
        E6 = findViewById(R.id.layoutE6);
        recordar = findViewById(R.id.chkRecordar2);
        anterior = findViewById(R.id.btnAnterior1);
        siguiente = findViewById(R.id.btnSiguiente1);


        DataBaseHelper inerbase = new DataBaseHelper(ActivityLuz_Fecha.this, "IMS.db", null, 1);
        db = inerbase.getWritableDatabase();
        Bundle extras = getIntent().getExtras();
        simula = recogeValores();
        peaje = extras.getString("peaje");
        oferta = extras.getString("oferta");
        rellenaPotencias();

        Cargar(prefe);

        activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), null);

        desapaereceCampos(peaje, E1fin, E2fin, E3fin, E4, E5, E6, P3, P4, P5, P6);
        deshabilitar();

        //region btnFechaInicio
        fechainicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(ActivityLuz_Fecha.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                inicio = getMonthByNumber(monthOfYear);
                                fechainicio.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                calcularDiferenciaFechas();
                                mesinicio.setText(inicio.toUpperCase(Locale.ROOT));
                                ocultarCampos(peaje, inicio, E1inicio, E2inicio, E3inicio, E4inicio, E5inicio);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });
        //endregion
        //region btnFechaFin
        fechafin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(ActivityLuz_Fecha.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                fin = getMonthByNumber(monthOfYear);
                                fechafin.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                calcularDiferenciaFechas();
                                mesfin.setText(fin.toUpperCase(Locale.ROOT));
                                ocultarCampos(peaje, fin, E1fin, E2fin, E3fin, E4fin, E5fin);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                if (mesfin.getText().toString().equals(mesinicio.getText().toString())) {
                    mesfin.setVisibility(View.GONE);
                }
            }
        });
        //endregion
        //region btnRecordar
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
        //region btnSiguiente
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaFecha = validateDates();
                validaCampos = validaCampos();
                if (validaFecha == true && validaCampos == true) {
                    actualizaDB();
                    siguienteActividad();
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
     * Mediate este método se dehabilita el campo de dias facturados para que este no sea modificable
     */
    public void deshabilitar() {
        diasfacturados.setEnabled(false);
    }
    //endregion
    //region ModificaCampos
    /**
     * Mediante este método y segun el peaje y el mes se haran visibles los meses
     *
     * @param peaje
     * @param meslabel
     * @param e1
     * @param e2
     * @param e3
     * @param e4
     * @param e5
     */
    public void ocultarCampos(String peaje, String meslabel, EditText e1, EditText e2, EditText e3, EditText e4, EditText e5) {
        if (peaje.equalsIgnoreCase("3.0TD") || peaje.equalsIgnoreCase("6.1TD")) {
            // Se ponen los campos en invisible para que luego aparezcan según el mes
            e1.setVisibility(View.INVISIBLE);
            e2.setVisibility(View.INVISIBLE);
            e3.setVisibility(View.INVISIBLE);
            e4.setVisibility(View.INVISIBLE);
            e5.setVisibility(View.INVISIBLE);

            // TODO Se utiliza para adaptar el texto a que solo sean letras en mayúscula
            meslabel = meslabel.split("_")[0].toUpperCase();

            if (meslabel.equalsIgnoreCase("ENERO") || meslabel.equalsIgnoreCase("FEBRERO")) {

                // TODO Se quedarian a la vista p1 p2 p6
                e1.setVisibility(View.VISIBLE);
                e2.setVisibility(View.VISIBLE);

            } else if (meslabel.equalsIgnoreCase("MARZO") || meslabel.equalsIgnoreCase("NOVIEMBRE")) {

                // TODO Se quedaria a la vista p2 p3 p6
                e2.setVisibility(View.VISIBLE);
                e3.setVisibility(View.VISIBLE);

            } else if (meslabel.equalsIgnoreCase("ABRIL") || meslabel.equalsIgnoreCase("MAYO") || meslabel.contains("OCTUBRE")) {

                // TODO Se quedaria a la vista p4 p5 p6
                e4.setVisibility(View.VISIBLE);
                e5.setVisibility(View.VISIBLE);

            } else if (meslabel.equalsIgnoreCase("JUNIO") || meslabel.equalsIgnoreCase("AGOSTO") || meslabel.equalsIgnoreCase("SEPTIEMBRE")) {

                // TODO Se quedaria a la vista p3 p4 p6
                e3.setVisibility(View.VISIBLE);
                e4.setVisibility(View.VISIBLE);

            }
        }
    }

    /**
     * Mediante este metodo hacemos que dependiendo del mes que se le pase por parametro
     * desparezca o aparezcan los campo a rellenar y en caso de que sea solament la tarifa 2.0TD
     *
     * @param peaje este es el mes que se pasa para saber que campos se pueden rellenar
     * @param e1 este es el campo de la primer cansumo
     * @param e2 este es el campo de la segundo cansumo
     * @param e3 este es el campo de la tercer cansumo
     * @param e4 este es el campo de la cuarto cansumo
     * @param e5 este es el campo de la quinto cansumo
     * @param e6 este es el campo de la sexto cansumo
     * @param p3 este es el campo de la tercer potencia real
     * @param p4 este es el campo de la cuarta potencia real
     * @param p5 este es el campo de la quinta potencia real
     * @param p6 este es el campo de la sexta potencia real
     */
    public void desapaereceCampos(String peaje, EditText e1, EditText e2, EditText e3, LinearLayout e4, LinearLayout e5, LinearLayout e6, LinearLayout p3, LinearLayout p4, LinearLayout p5, LinearLayout p6) {
        if (peaje.equalsIgnoreCase("2.0TD")) {
            e1.setVisibility(View.GONE);
            e2.setVisibility(View.GONE);
            e3.setVisibility(View.GONE);
            e4.setVisibility(View.GONE);
            e5.setVisibility(View.GONE);
            e6.setVisibility(View.GONE);
            p3.setVisibility(View.GONE);
            p4.setVisibility(View.GONE);
            p5.setVisibility(View.GONE);
            p6.setVisibility(View.GONE);

        } else {

            e1.setVisibility(View.VISIBLE);
            e2.setVisibility(View.VISIBLE);
            e3.setVisibility(View.VISIBLE);
            e4.setVisibility(View.VISIBLE);
            e5.setVisibility(View.VISIBLE);
            e6.setVisibility(View.VISIBLE);
            p3.setVisibility(View.VISIBLE);
            p4.setVisibility(View.VISIBLE);
            p5.setVisibility(View.VISIBLE);
            p6.setVisibility(View.VISIBLE);
        }

    }

    /**
     * Revisa que todos los que si los campos estan vacios automaticamento les pone valor 0
     * @return
     */
    public boolean validaCampos() {
        boolean validado;
        ArrayList<EditText> listaEdit = new ArrayList<EditText>();

        listaEdit.add(E1inicio);
        listaEdit.add(E2inicio);
        listaEdit.add(E3inicio);
        listaEdit.add(E4inicio);
        listaEdit.add(E5inicio);
        listaEdit.add(E6inicio);
        listaEdit.add(E1fin);
        listaEdit.add(E2fin);
        listaEdit.add(E3fin);
        listaEdit.add(E4fin);
        listaEdit.add(E5fin);
        listaEdit.add(E6fin);
        listaEdit.add(txtP1);
        listaEdit.add(txtP2);
        listaEdit.add(txtP3);
        listaEdit.add(txtP4);
        listaEdit.add(txtP5);
        listaEdit.add(txtP6);

        try {
            for (int i = 0; i < listaEdit.size(); i++) {
                String valor;
                Double numero;

                if (!(listaEdit.get(i).getText().toString().length() > 0)) {
                    listaEdit.get(i).setText("0");

                }
                valor = listaEdit.get(i).getText().toString();

                try {

                    numero = Double.parseDouble(valor);

                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "No habido un error con la conversion de datos.", Toast.LENGTH_SHORT).show();
                    return validado = false;
                }
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Ha habido un error con los campos a rellenar.", Toast.LENGTH_SHORT).show();
            return validado = false;
        }
        return validado = true;
    }
    //endregion
    //region ModificaFechas
    /**
     * Mediante este método se obtiene el mes de la fecha seleccionada pasandole por parametro el mes como número
     * @param monthnum este es el valor que se le pasa para sacar el mes
     * @return
     */
    public String getMonthByNumber(int monthnum) {
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
    public boolean validateDates() {
        if (TextUtils.isEmpty(fechainicio.getText().toString())) {
            Toast.makeText(ActivityLuz_Fecha.this, "Ingrese una fecha de inicio", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(fechafin.getText().toString())) {
            Toast.makeText(ActivityLuz_Fecha.this, "Ingrese una fecha de fin", Toast.LENGTH_SHORT).show();
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date startDate = sdf.parse(fechainicio.getText().toString());
            Date endDate = sdf.parse(fechafin.getText().toString());
            Date currentDate = new Date(); // fecha actual

            if (endDate.compareTo(startDate) < 0) {
                // TODO La fecha de fin es anterior a la fecha de inicio
                Toast.makeText(ActivityLuz_Fecha.this, "La fecha de fin no puede ser anterior a la fecha de inicio", Toast.LENGTH_SHORT).show();
                return false;
            } else if (startDate.compareTo(currentDate) > 0) {
                // TODO La fecha de inicio es posterior a la fecha actual
                Toast.makeText(ActivityLuz_Fecha.this, "La fecha de inicio no puede ser posterior a la fecha actual", Toast.LENGTH_SHORT).show();
                return false;
            } else if (endDate.compareTo(currentDate) > 0) {
                // TODO La fecha de fin es posterior a la fecha actual
                Toast.makeText(ActivityLuz_Fecha.this, "La fecha de fin no puede ser posterior a la fecha actual", Toast.LENGTH_SHORT).show();
                return false;
            } else if (endDate.compareTo(startDate) == 0) {
                // TODO Las fechas son iguales
                Toast.makeText(ActivityLuz_Fecha.this, "Las fechas no pueden ser iguales", Toast.LENGTH_SHORT).show();
                return false;
            } else if (endDate.before(startDate)) {
                Toast.makeText(ActivityLuz_Fecha.this, "La fecha de fin debe ser posterior a la fecha de inicio", Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Mediante este metodo se calcula la diferencia de dia que hay entre los dias para sacar el total de dias facturados
     */
    public void calcularDiferenciaFechas() {
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

        TimeUnit timeUnit = TimeUnit.DAYS;
        // TODO Calcular la diferencia en días

        int diffInDays = (int) ((fechaFin.getTime() - fechaInicio.getTime())
                / (1000 * 60 * 60 * 24));
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
        editor.putString("dias", diasfacturados.getText().toString());
        editor.putString("e1_inicio", E1inicio.getText().toString());
        editor.putString("e2_inicio", E2inicio.getText().toString());
        editor.putString("e3_inicio", E3inicio.getText().toString());
        editor.putString("e4_inicio", E4inicio.getText().toString());
        editor.putString("e5_inicio", E5inicio.getText().toString());
        editor.putString("e6_inicio", E6inicio.getText().toString());
        editor.putString("e1_fin", E1fin.getText().toString());
        editor.putString("e2_fin", E2fin.getText().toString());
        editor.putString("e3_fin", E3fin.getText().toString());
        editor.putString("e4_fin", E4fin.getText().toString());
        editor.putString("e5_fin", E5fin.getText().toString());
        editor.putString("e6_fin", E6fin.getText().toString());
        editor.putString("mes_inicio", mesinicio.getText().toString());
        editor.putString("mes_fin", mesfin.getText().toString());
        editor.putString("p1", txtP1.getText().toString());
        editor.putString("p2", txtP2.getText().toString());
        editor.putString("p3", txtP3.getText().toString());
        editor.putString("p4", txtP4.getText().toString());
        editor.putString("p5", txtP5.getText().toString());
        editor.putString("p6", txtP6.getText().toString());
        editor.putBoolean("Checked", recordar.isChecked());
        editor.commit();
    }

    /**
     * Mediante este metodo se cargan los datos guardados previamente con el Objeto SharedPreferences
     * @param prefs este es el objeto utilizado para poder cargar los datos
     */
    public void Cargar(SharedPreferences prefs) {

        try {
            //Recuperar los valores guardados en SharedPreferences
            prefs = getSharedPreferences("datos", Context.MODE_PRIVATE);
            recordar.setChecked(prefs.getBoolean("Checked", false));
            fechainicio.setText(prefs.getString("fecha_inicio", ""));
            fechafin.setText(prefs.getString("fecha_fin", ""));
            diasfacturados.setText(prefs.getString("dias", ""));
            E1inicio.setText(prefs.getString("e1_inicio", ""));
            E2inicio.setText(prefs.getString("e2_inicio", ""));
            E3inicio.setText(prefs.getString("e3_inicio", ""));
            E4inicio.setText(prefs.getString("e4_inicio", ""));
            E5inicio.setText(prefs.getString("e5_inicio", ""));
            E6inicio.setText(prefs.getString("e6_inicio", ""));
            E1fin.setText(prefs.getString("e1_fin", ""));
            E2fin.setText(prefs.getString("e2_fin", ""));
            E3fin.setText(prefs.getString("e3_fin", ""));
            E4fin.setText(prefs.getString("e4_fin", ""));
            E5fin.setText(prefs.getString("e5_fin", ""));
            E6fin.setText(prefs.getString("e6_fin", ""));
            mesinicio.setText(prefs.getString("mes_inicio", ""));
            mesfin.setText(prefs.getString("mes_fin", ""));
            txtP1.setText(prefs.getString("p1", ""));
            txtP2.setText(prefs.getString("p2", ""));
            txtP3.setText(prefs.getString("p3", ""));
            txtP4.setText(prefs.getString("p4", ""));
            txtP5.setText(prefs.getString("p5", ""));
            txtP6.setText(prefs.getString("p6", ""));
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Vuelve a escribir los datos a rellenar", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Este metodo vacia los campos de texto de la actividad
     */
    public void Vaciar() {
        fechainicio.setText("");
        fechafin.setText("");
        diasfacturados.setText("");
        mesinicio.setText("");
        mesfin.setText("");
        E1inicio.setText("");
        E2inicio.setText("");
        E3inicio.setText("");
        E4inicio.setText("");
        E5inicio.setText("");
        E6inicio.setText("");
        E1fin.setText("");
        E2fin.setText("");
        E3fin.setText("");
        E4fin.setText("");
        E5fin.setText("");
        E6fin.setText("");
        txtP1.setText("");
        txtP2.setText("");
        txtP3.setText("");
        txtP4.setText("");
        txtP5.setText("");
        txtP6.setText("");
    }
    //endregion
    //region ModificaDB
    /**
     * Devuelve el Objeto Simulacion con los datos de las potencias que recogeremos de la base de datos interna
     * @return
     */
    @SuppressLint("Range")
    public Simulacion recogeValores() {
        String sentencia;
        Pricing cosFijo = new Pricing();
        Simulacion simu = new Simulacion();
        DataBaseHelper inerbase = new DataBaseHelper(getApplicationContext(), "IMS.db", null, 1);
        db = inerbase.getWritableDatabase();
        sentencia = "SELECT * FROM SIMULACION";
        System.out.println(sentencia);
        Cursor c = db.rawQuery(sentencia, null);

        c.moveToFirst();
        simu.setP1(c.getDouble(c.getColumnIndex("P1")));
        simu.setP2(c.getDouble(c.getColumnIndex("P2")));
        simu.setP3(c.getDouble(c.getColumnIndex("P3")));
        simu.setP4(c.getDouble(c.getColumnIndex("P4")));
        simu.setP5(c.getDouble(c.getColumnIndex("P5")));
        simu.setP6(c.getDouble(c.getColumnIndex("P6")));


        c.close();
        return simu;
    }

    /**
     * Mediante este metodo se rellenaran los campos de las potencias las cuales habremos recogido
     * previamente de la base de datos interna y con ayuda del Objeto Simulación
     */
    public void rellenaPotencias(){
        txtP1.setText(String.valueOf(simula.getP1()));
        txtP2.setText(String.valueOf(simula.getP2()));
        txtP3.setText(String.valueOf(simula.getP3()));
        txtP4.setText(String.valueOf(simula.getP4()));
        txtP5.setText(String.valueOf(simula.getP5()));
        txtP6.setText(String.valueOf(simula.getP6()));
    }

    /**
     * Mediante este metodo los datos de la base de datos interna son modificados
     * mediante los datos que se recogen de la actividad
     */
    public void actualizaDB(){
        String actualizar = "UPDATE SIMULACION SET FECHA_INICIO = '" + fechainicio.getText().toString() + "', FECHA_FIN = '" + fechafin.getText().toString() + "',DIAS = '" + Integer.parseInt(diasfacturados.getText().toString()) +
                "',E1_INICIO = " + Double.parseDouble(E1inicio.getText().toString()) + " ,E2_INICIO = " + Double.parseDouble(E2inicio.getText().toString()) + ",E3_INICIO = " + Double.parseDouble(E3inicio.getText().toString()) + ",E4_INICIO = " + Double.parseDouble(E4inicio.getText().toString()) + ",E5_INICIO = " + Double.parseDouble(E5inicio.getText().toString()) + ",E6_INICIO = " + Double.parseDouble(E6inicio.getText().toString()) +
                ",E1_FIN = " + Double.parseDouble(E1fin.getText().toString()) + ",E2_FIN = " + Double.parseDouble(E2fin.getText().toString()) + ",E3_FIN = " + Double.parseDouble(E3fin.getText().toString()) + ",E4_FIN = " + Double.parseDouble(E4fin.getText().toString()) + ",E5_FIN = " + Double.parseDouble(E5fin.getText().toString()) + ",E6_FIN = " + Double.parseDouble(E6fin.getText().toString()) +
                " WHERE ID = 1";
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
        Intent i = new Intent(getApplicationContext(), ActivityLuz_Importe_Total.class);
        i.putExtra("mesInicio", mesInicio);
        i.putExtra("mesFin", mesFin);
        activityLauncher.launch(i);
    }

    /**
     * Mediante este método se consigue ir a la anterior actividad
     */
    public void anteriorActividad(){
        Intent i = new Intent(getApplicationContext(), ActivityLuz.class);
        activityLauncher.launch(i);
    }
    //endregion
}