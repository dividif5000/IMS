package com.alumno.simulacionims.contrato;

/**
 * @author David Ruiz Garcia
 * Objeto con el que mediante la actividad con el mismo nombre da a elegir entre diferentes opciones de Contratos
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.alumno.simulacionims.MainActivity;
import com.alumno.simulacionims.R;
import com.alumno.simulacionims.gas.ActivityGas;
import com.alumno.simulacionims.luz.ActivityLuz;
public class ActivityContrato extends AppCompatActivity {
    //region Variables
    private Button contratoLuz;
    private Button contratoGas;
    private Button atras;
    private ActivityResultLauncher activityLauncher;
    //endregion

    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(androidx.appcompat.R.style.Theme_AppCompat_DayNight);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrato);
        contratoLuz = findViewById(R.id.btnCreaContratoLuz);
        contratoGas = findViewById(R.id.btnCreaContratoGas);
        atras = findViewById(R.id.btnContratoAtras);

        activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), null);
        //region btnSipsLuz
        contratoLuz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siguienteLuz();
            }
        });
        //endregion
        //region btnSipsGas
        contratoGas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siguienteGas();
            }
        });
        //endregion
        //region btnAtras
        atras.setOnClickListener(new View.OnClickListener() {
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
    //region ActividadLanzada

    /**
     * Mediante este método se consigue ir a la siguiente actividad para el Contrato de Luz
     */
    public void siguienteLuz(){
        Intent i = new Intent(getApplicationContext(), ActivityLuz.class);
        i.putExtra("tipo","contrato");
        activityLauncher.launch(i);
    }

    /**
     * Mediante este método se consigue ir a la siguiente actividad para el Contrato de Gas
     */
    public void siguienteGas(){
        Intent i = new Intent(getApplicationContext(), ActivityGas.class);
        i.putExtra("tipo","contrato");
        activityLauncher.launch(i);
    }

    /**
     * Mediante este método se consigue ir a la anterior actividad
     */
    public void anteriorActividad() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        activityLauncher.launch(i);
        //finish();
    }
    //endregion
}