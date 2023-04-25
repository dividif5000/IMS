package com.alumno.simulacionims.sips;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alumno.simulacionims.MainActivity;
import com.alumno.simulacionims.R;
import com.alumno.simulacionims.gas.ActivityGas;
import com.alumno.simulacionims.models.ClasesSipsExtensa;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author David Ruiz Garcia
 * Objeto que se usa para hacer una busqueda de los datos de de consumos y potencias de las simulaciones de gas de los CUPS
 */

public class ActivitySipsGas extends AppCompatActivity {
    //region Variables
    private EditText txtcups;
    private EditText txtconsumo;
    private Button btncups;
    private Button btnatras;
    private Button btnenlazar;
    private String cups;
    private SQLiteDatabase db;
    private ActivityResultLauncher activityLauncher;
    private String fechaIni;
    private String fechaFin;

    //endregion
    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sips_gas);

        txtcups = findViewById(R.id.txtBuscaCupsGas);
        btncups = findViewById(R.id.btnBuscaCupsGas);
        txtconsumo = findViewById(R.id.txtCupsConsumoGas);
        btnatras = findViewById(R.id.btnAtrasBuscaCupsGas);
        btnenlazar = findViewById(R.id.btnSiguienteBuscaCupsGas);

        activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), null);
        //region btnCUPS
        btncups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtcups.length()==0){
                    Toast.makeText(getApplicationContext(), "El campo de cups no puede estar vacio", Toast.LENGTH_SHORT).show();
                }else {

                    cups = txtcups.getText().toString();
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                    StrictMode.setThreadPolicy(policy);

                    ConsumoAnual();
                }

            }
        });
        //endregion
        //region btnAtras
        btnatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anteriorActividad();
            }
        });
        //endregion
        //region btnEnlazar
        btnenlazar.setOnClickListener(new View.OnClickListener() {
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
     * Mediante este método el usuario puede ir a la actividad anterior
     */
    //TODO Este metodo sirve para volver a la Main activity
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent i = new Intent(this, MainActivity.class);
        activityLauncher.launch(i);
    }
    //endregion
    //region Consumo

    /**
     * Mediante este método se consigue sacar la el valor de consumo anual según CUPS
     */
    public void ConsumoAnual(){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"CodigoCUPS\": \"ES0224050004873564DG\",\r\n    \"NombreEmpresaDistribuidora\": \"\",\r\n    \"MunicipioPS\": \"\",\r\n    \"CodigoProvinciaPS\": \"\",\r\n    \"CodigoPostalPS\": \"\",\r\n    \"CodigoTarifaATREnVigor\": \"\",\r\n    \"ListCUPS\": \"\",\r\n    \"LoadAllDatosCliente\": true,\r\n    \"LoadConsumos\": true,\r\n    \"IsExist\": false\r\n} ");
        Request request = new Request.Builder()
                .url("https://sips.sigeenergia.com:61843/SIPSAPIvLast/api/v2/ClientesSipsGas/GetClientesPost")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();


        try {
            float sumaconsumo = 0;

            Response response = client.newCall(request).execute();

            Gson wason = new Gson();
            Type typ = new TypeToken<ClasesSipsExtensa>() {}.getType();
            ClasesSipsExtensa myList = wason.fromJson(response.body().string(), typ);
            System.out.println(response.body().toString());
            System.out.println(myList.getConsumosSips());

            for (int i =0; i < myList.length -1 || totaldias < 365 ; i--) {
                sumaconsumo += myList.getConsumosSips().get(myList.getConsumosSips().size()-1).ConsumoEnWhP1;

            }
                sumaconsumo += myList.getConsumosSips().get(myList.getConsumosSips().size()-1).ConsumoEnWhP1;



            txtconsumo.setText(String.valueOf(sumaconsumo));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //endregion
    //region ModificaDB

    /**
     * Mediante este método se consigo medificar la tabla de simulacion al menos lo valores de las potencias
     */
    public void actualizaDB(){
        String actualizar = "UPDATE SIMULACION SET CUPS ='"+txtcups.getText().toString()+"' WHERE ID = 1";
        System.out.println(actualizar);
        db.execSQL(actualizar);
    }
    //endregion
    //region ActividadLanzada

    /**
     * Mediante este método se consigue ir a la siguiente actividad
     */
    public void siguienteActividad(){
        Intent i = new Intent(getApplicationContext(), ActivityGas.class);
        activityLauncher.launch(i);
    }

    /**
     * Mediante este método se consigue ir a la anterior actividad
     */
    public void anteriorActividad(){
        Intent i = new Intent(getApplicationContext(), ActivitySips.class);
        activityLauncher.launch(i);
    }
    //endregion
}