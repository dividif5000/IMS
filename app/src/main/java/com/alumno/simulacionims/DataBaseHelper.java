package com.alumno.simulacionims;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * @author David Ruiz Garcia
 * Objeto Molde utilizado para que en el codigo java de las actividades se pueda hacer uso
 * de la base de datos interna del dispositivo
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    //region Variables
    private Context contexto;
    //endregion
    //region Contructor

    /**
     * Mediante este contructor pasamos todos los parametros necesarios para poder crear las tablas de la base de datos interna
     * @param context
     * @param nombre
     * @param factory
     * @param version
     */
    public DataBaseHelper(@Nullable Context context, String nombre, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre,factory ,version);
        contexto=context;
    }
    //endregion
    //region onCreate
    @Override
    public void onCreate(SQLiteDatabase db) {

        //region TablaUsuarios
        /**
         * En esta sentencia se genera la tabla usuario
         */
        // TODO Creacion de la base de la tabla de Usuarios
        String sentencia;
        sentencia="CREATE TABLE USUARIO("+
                "IDUSUARIO INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
                "NOMBRE TEXT NOT NULL UNIQUE,"+
                "CONTRASEÑA TEXT NOT NULL,"+
                "SEDE TEXT,"+
                "PRIVILEGIOS TEXT,"+
                "IDAGENTE INTEGER NOT NULL,"+
                "MAIL TEXT,"+
                "LOGUEADO BOOLEAN"+
                ")";
        db.execSQL(sentencia);
        //endregion
        //region TablaLog_Usuario
        /**
         * En esta sentencia se genera la tabla temporal Log_Usuario
         */
        // TODO Creacion de la base de la tabla temporal de Usuarios
        sentencia="CREATE TABLE LOG_USUARIO("+
                "IDUSUARIO INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
                "NOMBRE TEXT NOT NULL UNIQUE,"+
                "CONTRASEÑA TEXT NOT NULL,"+
                "SEDE TEXT,"+
                "PRIVILEGIOS TEXT,"+
                "IDAGENTE INTEGER NOT NULL,"+
                "MAIL TEXT,"+
                "LOGUEADO BOOLEAN"+
                ")";
        db.execSQL(sentencia);
        //endregion
        //region Tabla_Simulacion
        /**
         * En esta sentencia se genera la tabla Simulacion
         */
        // TODO Creacion de la base de la tabla de los datos para Simulacion
        sentencia="CREATE TABLE IF NOT EXISTS SIMULACION("+
                "ID INTEGER NOT NULL PRIMARY KEY,"+
                "CLIENTE TEXT NOT NULL,"+
                "CUPS TEXT NOT NULL,"+
                "FECHA_INICIO TEXT,"+
                "FECHA_FIN TEXT,"+
                "DIAS INTEGER,"+
                "TARIFA TEXT,"+
                "PEAJE TEXT,"+
                "OFERTA TEXT,"+
                "FEE TEXT,"+
                "PRECIO_POTENCIA TEXT,"+
                "E1_INICIO DOUBLE,"+
                "E2_INICIO DOUBLE,"+
                "E3_INICIO DOUBLE,"+
                "E4_INICIO DOUBLE,"+
                "E5_INICIO DOUBLE,"+
                "E6_INICIO DOUBLE,"+
                "E1_FIN DOUBLE,"+
                "E2_FIN DOUBLE,"+
                "E3_FIN DOUBLE,"+
                "E4_FIN DOUBLE,"+
                "E5_FIN DOUBLE,"+
                "E6_FIN DOUBLE,"+
                "P1 DOUBLE,"+
                "P2 DOUBLE,"+
                "P3 DOUBLE,"+
                "P4 DOUBLE,"+
                "P5 DOUBLE,"+
                "P6 DOUBLE,"+
                "E1_IMPORTE DOUBLE,"+
                "E2_IMPORTE DOUBLE,"+
                "E3_IMPORTE DOUBLE,"+
                "E4_IMPORTE DOUBLE,"+
                "E5_IMPORTE DOUBLE,"+
                "E6_IMPORTE DOUBLE,"+
                "E1_TOTAL DOUBLE,"+
                "E2_TOTAL DOUBLE,"+
                "E3_TOTAL DOUBLE,"+
                "E4_TOTAL DOUBLE,"+
                "E5_TOTAL DOUBLE,"+
                "E6_TOTAL DOUBLE,"+
                "P1_IMPORTE DOUBLE,"+
                "P2_IMPORTE DOUBLE,"+
                "P3_IMPORTE DOUBLE,"+
                "P4_IMPORTE DOUBLE,"+
                "P5_IMPORTE DOUBLE,"+
                "P6_IMPORTE DOUBLE,"+
                "P1_TOTAL DOUBLE,"+
                "P2_TOTAL DOUBLE,"+
                "P3_TOTAL DOUBLE,"+
                "P4_TOTAL DOUBLE,"+
                "P5_TOTAL DOUBLE,"+
                "P6_TOTAL DOUBLE,"+
                "GESTION_INER DOUBLE,"+
                "BASE_IMPONIBLE DOUBLE,"+
                "IMPUESTO DOUBLE,"+
                "ALQUILER_EQUIPO,"+
                "IVA DOUBLE,"+
                "TOTAL DOUBLE"+
                ")";
        db.execSQL(sentencia);
        //endregion
        //region Tabla-Contratos
        // TODO Creacion de la base de la tabla de Usuarios

        sentencia="CREATE TABLE CONTRATO("+
                "IDCONTRATO INTEGER NOT NULL PRIMARY KEY,"+
                "PYME_CLI TEXT ,"+
                "CONTRATO_CLI TEXT ,"+
                "PERMANENCIA_CLI BOOLEAN,"+
                "TARIFA_CLI TEXT,"+
                "PEAJE_CLI TEXT ,"+
                "CODIGO_TARIFA_CLI TEXT,"+
                "TITULAR_CLI TEXT,"+
                "APELLIDOS_CLI TEXT,"+
                "TELEFONO1_CLI TEXT,"+
                "TELEFONO2_CLI TEXT,"+
                "MAIL_CLI TEXT,"+
                "DIRECCION_CLI TEXT,"+
                "NUMERO_PORTAL_CLI TEXT,"+
                "PISO_CLI TEXT,"+
                "PUERTA_CLI TEXT,"+
                "LOCALIDAD_CLI TEXT,"+
                "PROVINCIA_CLI TEXT,"+
                "CODIGO_POSTAL_CLI TEXT,"+
                "REPRESENTATE_CLI TEXT,"+
                "NIF_REPRESENTATE_CLI TEXT,"+
                "DIRECCION_SUMI TEXT,"+
                "NUMERO_PORTAL_SUMI TEXT,"+
                "PISO_SUMI TEXT,"+
                "PUERTA_SUMI TEXT,"+
                "LOCALIDAD_SUMI TEXT,"+
                "PROVINCIA_SUMI TEXT,"+
                "CODIGO_POSTAL_SUMI TEXT,"+
                "DISTRIBUIDORA_SUMI TEXT,"+
                "CUPS_SUMI TEXT,"+
                "CNAE_SUMI TEXT,"+
                "CONSUMO_ANUAL DOUBLE,"+
                "DIRECCION_CON TEXT,"+
                "NUMERO_PORTAL_CON TEXT,"+
                "PISO_CON TEXT,"+
                "PUERTA_CON TEXT,"+
                "LOCALIDAD_CON TEXT,"+
                "PROVINCIA_CON TEXT,"+
                "CODIGO_POSTAL_CON TEXT,"+
                "POTENCIA1 DOUBLE,"+
                "POTENCIA2 DOUBLE,"+
                "POTENCIA3 DOUBLE,"+
                "POTENCIA4 DOUBLE,"+
                "POTENCIA5 DOUBLE,"+
                "POTENCIA6 DOUBLE,"+
                "GARANTIA BOOLEAN,"+
                "FECH_INI_CONTRATO TEXT,"+
                "DURACION_CONTRATO TEXT,"+
                "NIF_BAN TEXT,"+
                "NOMBRE_BAN TEXT,"+
                "IBAN TEXT"+
                ")";
        db.execSQL(sentencia);
        //endregion
    }


    //endregion
    //region onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
    //endregion
}
