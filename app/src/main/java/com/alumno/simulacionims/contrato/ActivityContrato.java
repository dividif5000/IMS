package com.alumno.simulacionims.contrato;

/**
 * @author David Ruiz Garcia
 * Objeto con el que mediante la actividad con el mismo nombre da a elegir entre diferentes opciones de Contratos
 */
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alumno.simulacionims.MainActivity;
import com.alumno.simulacionims.R;
import com.alumno.simulacionims.gas.ActivityGas;
import com.alumno.simulacionims.luz.ActivityLuz;
import com.alumno.simulacionims.sips.ActivitySipsGas;
import com.alumno.simulacionims.sips.ActivitySipsLuz;

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
    public void anteriorActividad(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setTitle("Home");
        builder.setMessage("¿Está seguro de que desea volver al Home?");

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                activityLauncher.launch(i);
                finish();
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
    //endregion
}