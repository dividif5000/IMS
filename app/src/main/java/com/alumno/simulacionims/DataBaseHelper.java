package com.alumno.simulacionims;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public Context contexto;

    public DataBaseHelper(@Nullable Context context, String nombre, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre,factory ,version);
        contexto=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

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

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

}
