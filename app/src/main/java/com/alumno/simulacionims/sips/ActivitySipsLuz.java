package com.alumno.simulacionims.sips;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.alumno.simulacionims.DataBaseHelper;
import com.alumno.simulacionims.MainActivity;
import com.alumno.simulacionims.R;
import com.alumno.simulacionims.contrato.ActivityContratoLuzSuministro;
import com.alumno.simulacionims.luz.ActivityLuz;
import com.alumno.simulacionims.models.ClasesSipsExtensa;
import com.alumno.simulacionims.models.ConsumosSips;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author David Ruiz Garcia
 * Objeto que se usa para hacer una busqueda de los datos de de consumos y potencias de las simulaciones de luz de los CUPS
 */

public class ActivitySipsLuz extends AppCompatActivity {
    //region Variables
    private String tipo;
    private EditText txtcups;
    private EditText txtactiva;
    private EditText txtpotencia1;
    private EditText txtpotencia2;
    private EditText txtpotencia3;
    private EditText txtpotencia4;
    private EditText txtpotencia5;
    private EditText txtpotencia6;
    private Button btncups;
    private Button btnatras;
    private Button btnenlazar;
    private String cups;
    private SQLiteDatabase db;
    private ActivityResultLauncher activityLauncher;
    //endregion
    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(androidx.appcompat.R.style.Theme_AppCompat_DayNight);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sips_luz);

        txtcups = findViewById(R.id.txtBuscaCups);
        btncups = findViewById(R.id.btnBuscaCups);
        txtactiva = findViewById(R.id.txtResultadoActiva);
        txtpotencia1 = findViewById(R.id.txtCupsPotencia1);
        txtpotencia2 = findViewById(R.id.txtCupsPotencia2);
        txtpotencia3 = findViewById(R.id.txtCupsPotencia3);
        txtpotencia4 = findViewById(R.id.txtCupsPotencia4);
        txtpotencia5 = findViewById(R.id.txtCupsPotencia5);
        txtpotencia6 = findViewById(R.id.txtCupsPotencia6);
        btnatras = findViewById(R.id.btnAtrasBuscaCups);
        btnenlazar = findViewById(R.id.btnSiguienteBuscaCups);

        Bundle extra = getIntent().getExtras();
        tipo = extra.getString("tipo");

        deshabilitar();
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

                    PonteciaUltimoMes();

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
    //region deshabilitar

    /**
     * Mediante este método bloqueamos el uso de los mismo para que los campos sean solamente de lectura
     */
    public void deshabilitar(){
        txtactiva.setEnabled(false);
        txtpotencia1.setEnabled(false);
        txtpotencia2.setEnabled(false);
        txtpotencia3.setEnabled(false);
        txtpotencia4.setEnabled(false);
        txtpotencia5.setEnabled(false);
        txtpotencia6.setEnabled(false);
    }
    //endregion
    //region Consumo

    /**
     * Mediante este método se consigue sacar la el valor de consumo anual según CUPS
     */
    public void ConsumoAnual(){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://sips.sigeenergia.com:61843/SIPSAPIvLast/api/v2/ClientesSips/ConsumoGet/?_SipsCupsFiltersDTO={%22CodigosCUPS%22:[%22"+cups+"%22]}")
                .method("GET", null)
                .build();

        try {
            float sumaactiva = 0;

            Response response = client.newCall(request).execute();

            Gson gson = new Gson();
            Type type = new TypeToken<List<ConsumosSips>>() {}.getType();
            List<ConsumosSips> myList = gson.fromJson(response.body().string(), type);
            System.out.println(myList.size());
            for (int i = myList.size()-1; i >myList.size()-13 ; i--) {
                sumaactiva += myList.get(i).Activa1+myList.get(i).Activa2+myList.get(i).Activa3+myList.get(i).Activa4+myList.get(i).Activa5+myList.get(i).Activa6;

            }



            txtactiva.setText(String.valueOf(sumaactiva/1000));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //endregion
    //region Pontecia

    /**
     * Mediantes este método se consigue sacar la el valor de las potencias del ultimo mes según CUPS
     */
    public void PonteciaUltimoMes(){
        OkHttpClient cliente = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaTyp = MediaType.parse("application/json");
        RequestBody bod = RequestBody.create(mediaTyp, "{\r\n    \"CodigoCUPS\": \""+txtcups.getText().toString()+"\",\r\n    \"NombreEmpresaDistribuidora\": \"\",\r\n    \"MunicipioPS\": \"\",\r\n    \"CodigoProvinciaPS\": \"\",\r\n    \"CodigoPostalPS\": \"\",\r\n    \"CodigoTarifaATREnVigor\": \"\",\r\n    \"ListCUPS\": \"\",\r\n    \"LoadAllDatosCliente\": true,\r\n    \"LoadConsumos\": false,\r\n    \"IsExist\": false\r\n} ");
        Request reques = new Request.Builder()
                .url("https://sips.sigeenergia.com:61843/SIPSAPIvLast/api/v2/ClientesSips/GetClientesPost")
                .method("POST", bod)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            float pot1 = 0;
            float pot2 = 0;
            float pot3 = 0;
            float pot4 = 0;
            float pot5 = 0;
            float pot6 = 0;
            Response respons = cliente.newCall(reques).execute();

            Gson wason = new Gson();
            Type typ = new TypeToken<ClasesSipsExtensa>() {}.getType();
            ClasesSipsExtensa myLis = wason.fromJson(respons.body().string(), typ);
            System.out.println(respons.body().toString());
            System.out.println(myLis.getClientesSips());
            pot1 += myLis.getClientesSips().get(myLis.getClientesSips().size()-1).PotenciasContratadasEnWP1;
            System.out.println( myLis.getClientesSips().get(myLis.getClientesSips().size()-1).PotenciasContratadasEnWP1);
            pot2 += myLis.getClientesSips().get(myLis.getClientesSips().size()-1).PotenciasContratadasEnWP2;
            System.out.println(myLis.getClientesSips().get(myLis.getClientesSips().size()-1).PotenciasContratadasEnWP2);
            pot3 += myLis.getClientesSips().get(myLis.getClientesSips().size()-1).PotenciasContratadasEnWP3;
            System.out.println(myLis.getClientesSips().get(myLis.getClientesSips().size()-1).PotenciasContratadasEnWP3);
            pot4 += myLis.getClientesSips().get(myLis.getClientesSips().size()-1).PotenciasContratadasEnWP4;
            System.out.println(myLis.getClientesSips().get(myLis.getClientesSips().size()-1).PotenciasContratadasEnWP4);
            pot5 += myLis.getClientesSips().get(myLis.getClientesSips().size()-1).PotenciasContratadasEnWP5;
            System.out.println(myLis.getClientesSips().get(myLis.getClientesSips().size()-1).PotenciasContratadasEnWP5);
            pot6 += myLis.getClientesSips().get(myLis.getClientesSips().size()-1).PotenciasContratadasEnWP6;
            System.out.println(myLis.getClientesSips().get(myLis.getClientesSips().size()-1).PotenciasContratadasEnWP6);

            txtpotencia1.setText(String.valueOf(pot1));
            txtpotencia2.setText(String.valueOf(pot2));
            txtpotencia3.setText(String.valueOf(pot3));
            txtpotencia4.setText(String.valueOf(pot4));
            txtpotencia5.setText(String.valueOf(pot5));
            txtpotencia6.setText(String.valueOf(pot6));
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
        DataBaseHelper inerbase = new DataBaseHelper(getApplicationContext(), "IMS.db", null, 1);
        db = inerbase.getWritableDatabase();
        if(tipo.equals("contrato")){
            String actualizar = "UPDATE CONTRATO SET CUPS_SUMI ='"+txtcups.getText().toString()+"', CONSUMO_ANUAL ="+Double.parseDouble(txtactiva.getText().toString())+", POTENCIA1 ="+Double.parseDouble(txtpotencia1.getText().toString())+", POTENCIA2 = "+Double.parseDouble(txtpotencia2.getText().toString())+", POTENCIA3 = "+Double.parseDouble(txtpotencia3.getText().toString())+", POTENCIA4 = "+Double.parseDouble(txtpotencia4.getText().toString())+", POTENCIA5 = "+Double.parseDouble(txtpotencia5.getText().toString())+", POTENCIA6 = "+Double.parseDouble(txtpotencia6.getText().toString())+" WHERE ID = 1";
            System.out.println(actualizar);
            db.execSQL(actualizar);
        }else{
            String actualizar = "UPDATE SIMULACION SET CUPS ='"+txtcups.getText().toString()+"', P1 ="+Double.parseDouble(txtpotencia1.getText().toString())+", P2 = "+Double.parseDouble(txtpotencia2.getText().toString())+", P3 = "+Double.parseDouble(txtpotencia3.getText().toString())+", P4 = "+Double.parseDouble(txtpotencia4.getText().toString())+", P5 = "+Double.parseDouble(txtpotencia5.getText().toString())+", P6 = "+Double.parseDouble(txtpotencia6.getText().toString())+" WHERE ID = 1";
            System.out.println(actualizar);
            db.execSQL(actualizar);
        }
        ;
    }
    //endregion
    //region ActividadLanzada

    /**
     * Mediante este método se consigue ir a la siguiente actividad
     */
    public void siguienteActividad(){
        if(tipo.equals("contrato")){
            Intent i = new Intent(getApplicationContext(), ActivityContratoLuzSuministro.class);
            activityLauncher.launch(i);
        }else{
            Intent i = new Intent(getApplicationContext(), ActivityLuz.class);
            activityLauncher.launch(i);
        }

    }

    /**
     * Mediante este método se consigue ir a la anterior actividad
     */
    public void anteriorActividad(){
        if(tipo.equals("contrato")){
            Intent i = new Intent(getApplicationContext(), ActivityContratoLuzSuministro.class);
            activityLauncher.launch(i);
        }else{
            Intent i = new Intent(getApplicationContext(), ActivitySips.class);
            activityLauncher.launch(i);
        }

    }
    //endregion
}