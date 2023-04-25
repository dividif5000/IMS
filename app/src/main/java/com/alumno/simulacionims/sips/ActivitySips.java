package com.alumno.simulacionims.sips;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alumno.simulacionims.MainActivity;
import com.alumno.simulacionims.R;

/**
 * @author David Ruiz Garcia
 * Objeto con el que mediante la actividad con el mismo nombre da a elegir entre diferentes opciones de SIPS
 */
public class ActivitySips extends AppCompatActivity {

    //region Variables
    private Button sipsLuz;
    private Button sipsGas;
    private Button atras;
    private ActivityResultLauncher activityLauncher;
    //endregion

    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sips);

        sipsLuz = findViewById(R.id.btnSipsLuz);
        sipsGas = findViewById(R.id.btnSipsGas);
        atras = findViewById(R.id.btnSipsAtras);

        activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), null);
        //region btnSipsLuz
        sipsLuz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             siguienteLuz();
            }
        });
        //endregion
        //region btnSipsGas
        sipsGas.setOnClickListener(new View.OnClickListener() {
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
     * Mediante este método se consigue ir a la siguiente actividad para SIPS Luz
     */
    public void siguienteLuz(){
        Intent i = new Intent(getApplicationContext(), ActivitySipsLuz.class);
        activityLauncher.launch(i);
    }

    /**
     * Mediante este método se consigue ir a la siguiente actividad para SIPS Gas
     */
    public void siguienteGas(){
        Intent i = new Intent(getApplicationContext(), ActivitySipsGas.class);
        activityLauncher.launch(i);
    }

    /**
     * Mediante este método se consigue ir a la anterior actividad
     */
    public void anteriorActividad(){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        activityLauncher.launch(i);
    }
    //endregion
}