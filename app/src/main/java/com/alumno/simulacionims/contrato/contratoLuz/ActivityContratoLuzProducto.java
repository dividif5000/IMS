package com.alumno.simulacionims.contrato.contratoLuz;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.alumno.simulacionims.DataBaseHelper;
import com.alumno.simulacionims.R;
import com.alumno.simulacionims.models.Contrato;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author David Ruiz Garcia
 * Objeto con el que mediante la actividad para rellenar campos del Apartado de Producto Contratos Luz
 */
public class ActivityContratoLuzProducto extends AppCompatActivity {

    //region Variables
    private String inicio = "";
    private int mYear, mMonth, mDay;
    private EditText p1;
    private EditText p2;
    private EditText p3;
    private EditText p4;
    private EditText p5;
    private EditText p6;
    private CheckBox garantiaOrigen;
    private EditText fechainicio;
    private Spinner duracioncontrato;
    private CheckBox recordar;
    private Button anterior;
    private Button siguiente;
    private SharedPreferences prefs;
    private Contrato contrato;
    private SQLiteDatabase db;
    private ActivityResultLauncher activityLauncher;

    private final String[] DURACION = {"ANUAL"};
    //endregion
    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(androidx.appcompat.R.style.Theme_AppCompat_DayNight);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrato_luz_producto);

        p1 = findViewById(R.id.txtProductoPotencia1);
        p2 = findViewById(R.id.txtProductoPotencia2);
        p3 = findViewById(R.id.txtProductoPotencia3);
        p4 = findViewById(R.id.txtProductoPotencia4);
        p5 = findViewById(R.id.txtProductoPotencia5);
        p6 = findViewById(R.id.txtProductoPotencia6);
        garantiaOrigen = findViewById(R.id.chkGarantiaOrigen);
        fechainicio = findViewById(R.id.txtInicioContrato);
        duracioncontrato = findViewById(R.id.spnDuracionContrato);
        recordar = findViewById(R.id.chkRecordarDatosProducto);
        anterior = findViewById(R.id.btnAnteriorContratoLuz4);
        siguiente = findViewById(R.id.btnSiguienteContratoLuz4);

        deshabilitar();
        contrato = recogeValores();
        rellenaCampos();
        Cargar(prefs);
        activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), null);

        //region txtFechaInicio
        fechainicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(ActivityContratoLuzProducto.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                if (year > mYear || (year == mYear && monthOfYear > mMonth)
                                        || (year == mYear && monthOfYear == mMonth && dayOfMonth > mDay)) {
                                    // La fecha seleccionada es mayor que la fecha actual, mostrar un mensaje de error
                                    Toast.makeText(getApplicationContext(), "No puedes seleccionar una fecha mayor que la actual", Toast.LENGTH_SHORT).show();
                                } else {
                                    inicio = getMonthByNumber(monthOfYear);
                                    fechainicio.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                                }

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });
        //endregion
        //region spnDuracionContrato
        ArrayAdapter<String> adaptadorPyme = new ArrayAdapter<String>
                (getApplicationContext(), R.layout.spinneriner, DURACION);
        adaptadorPyme.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        duracioncontrato.setAdapter(adaptadorPyme);
        final String[] durcon = {""};
        duracioncontrato.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                durcon[0] = (String) duracioncontrato.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No seleccionaron nada
            }


        });
        //endregion
        //region chkGarantiaDeOrigen
        garantiaOrigen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (garantiaOrigen.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Ha seleccionado la opción de Permanencia", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Ha deseleccionado la opción de Permanencia", Toast.LENGTH_SHORT).show();
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
        //region btnSiguiente
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fechainicio.length() == 0 && p1.length() == 0 && p2.length() == 0 && p3.length() == 0 && p4.length() == 0 && p5.length() == 0 && p6.length() == 0) {
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
    public void deshabilitar() {
        p1.setEnabled(false);
        p2.setEnabled(false);
        p3.setEnabled(false);
        p4.setEnabled(false);
        p5.setEnabled(false);
        p6.setEnabled(false);
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
    //endregion
    //region Guardar_Cargar

    /**
     * Mediante este metodo se guardan los datos con el uso del Objeto SharedPreferences
     */
    public void Guardar() {
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();

        editor.putString("fechainicio", fechainicio.getText().toString());
        editor.putBoolean("garantia", garantiaOrigen.isChecked());
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
            fechainicio.setText(prefs.getString("fechainicio", ""));
            garantiaOrigen.setChecked(prefs.getBoolean("garantia", false));
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Vuelve a escribir los datos a rellenar", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Este metodo vacia los campos de texto de la actividad
     */
    public void Vaciar() {
        fechainicio.setText("");
        garantiaOrigen.setChecked(false);
    }
    //endregion
    //region ModificaDB
    /**
     * Mediante este metodo se actualiza la base de datos interna con los datos que se introducen en la actividad
     */
    public void actualizaDB() {

        String actualizar;
        actualizar = "UPDATE CONTRATO SET GARANTIA = " + (garantiaOrigen.isChecked() ? 1 : 0) + ", FECH_INI_CONTRATO = '" + fechainicio.getText().toString().toUpperCase().trim() + "', DURACION_CONTRATO = '" + duracioncontrato.getSelectedItem().toString().toUpperCase().trim() +
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
    //region RellenaCampos
    public void rellenaCampos(){
        p1.setText(String.valueOf(contrato.getP1Con()));
        p2.setText(String.valueOf(contrato.getP2Con()));
        p3.setText(String.valueOf(contrato.getP3Con()));
        p4.setText(String.valueOf(contrato.getP4Con()));
        p5.setText(String.valueOf(contrato.getP5Con()));
        p6.setText(String.valueOf(contrato.getP6Con()));
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
        Intent intent = new Intent(getApplicationContext(), ActivityContratoLuzContacto.class);
        activityLauncher.launch(intent);
    }
    //endregion
}
