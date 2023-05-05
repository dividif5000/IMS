package com.alumno.simulacionims.contrato.contratoGas;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
 * Objeto con el que mediante la actividad para rellenar campos del Apartado de Producto Contratos Gas
 */
public class ActivityContratoGasProducto extends AppCompatActivity {
    //region Variables
    private String inicio = "";
    private int mYear, mMonth, mDay;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrato_gas_producto);

        fechainicio = findViewById(R.id.txtInicioContratoGas);
        duracioncontrato = findViewById(R.id.spnDuracionContratoGas);
        recordar = findViewById(R.id.chkRecordarDatosProductoGas);
        anterior = findViewById(R.id.btnAnteriorContratoGas4);
        siguiente = findViewById(R.id.btnSiguienteContratoGas4);

        DataBaseHelper inerbase = new DataBaseHelper(getApplicationContext(), "IMS.db", null, 1);
        db = inerbase.getWritableDatabase();
        activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), null);
        Cargar(prefs);

        //region txtFechaInicio
        fechainicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(ActivityContratoGasProducto.this,
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
                if (fechainicio.length() == 0) {
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
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Vuelve a escribir los datos a rellenar", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Este metodo vacia los campos de texto de la actividad
     */
    public void Vaciar() {
        fechainicio.setText("");
    }
    //endregion
    //region ModificaDB
    /**
     * Mediante este metodo se actualiza la base de datos interna con los datos que se introducen en la actividad
     */
    public void actualizaDB() {

        String actualizar;
        actualizar = "UPDATE CONTRATO SET FECH_INI_CONTRATO = '" + fechainicio.getText().toString().toUpperCase().trim() +
                "', DURACION_CONTRATO = '" + duracioncontrato.getSelectedItem().toString().toUpperCase().trim() +
                "' WHERE ID = 1";
        System.out.println(actualizar);
        db.execSQL(actualizar);
        Toast.makeText(getApplicationContext(), "Se han guardado los datos del Contrato", Toast.LENGTH_SHORT).show();
    }


    //endregion
    //region ActividadLanzada

    /**
     * Mediante este método se consigue ir a la siguiente actividad para el Contrato de Gas
     */
    public void siguienteActividad() {
        Intent intent = new Intent(getApplicationContext(), ActivityContratoGasBanco.class);
        activityLauncher.launch(intent);
    }

    /**
     * Mediante este método se consigue ir a la anterior actividad para el Contrato Gas
     */
    public void anteriorActividad() {
        Intent intent = new Intent(getApplicationContext(), ActivityContratoGasContacto.class);
        activityLauncher.launch(intent);
    }
    //endregion
}