package com.alumno.simulacionims.contrato;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.alumno.simulacionims.R;
import com.alumno.simulacionims.gas.ActivityGas;

public class ActivityContratoGas extends AppCompatActivity {

    private ActivityResultLauncher activityLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(androidx.appcompat.R.style.Theme_AppCompat_DayNight);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrato_gas);
    }

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

    ///**
    // * Mediante este método se consigue ir a la siguiente actividad para el Contrato de Luz
    // */
   /* public void siguienteGas(){
            Intent intent = new Intent(getApplicationContext(), ActivityContrato_Cliente_Gas.class);
            activityLauncher.launch(intent);
    }/*

    /**
     * Mediante este método se consigue ir a la anterior actividad
     */
    public void anteriorActividad(){
        Intent intent = new Intent(getApplicationContext(), ActivityGas.class);
        activityLauncher.launch(intent);
    }
    //endregion
}