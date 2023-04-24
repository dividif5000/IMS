package com.alumno.simulacionims;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.StrictMode;
import android.widget.Toast;

import com.alumno.simulacionims.models.CodigosPrecio;
import com.alumno.simulacionims.models.Pricing;
import com.alumno.simulacionims.models.PricingGas;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

public class SQLPostgresHelper {
    //region Variables
    private final String host = "192.168.0.29";
    private final String database = "ITSAPP";
    private final int port = 5432;
    private final String user = "postgres";
    private final String pass = "admineus";
    private Connection connection;
    private String url;
    private boolean status;
    private SQLiteDatabase db;
    //endregion
    //region Constructor

    /**
     * Constructor por defecto de la Clase SQLPostgresHelper
     */
    public SQLPostgresHelper() {
        //connect(ubicacion, ctxt);
    }
    //endregion
    //region Server_Usuario

    /**
     * Mediante este método se obtiene loss deatos de los usuario registrados en la base de datos externa a la aplicación
     * @param ubicacion
     * @param ctxt
     */
    public void connect(Location ubicacion, Context ctxt) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Statement stmt = null;
                    url = "jdbc:postgresql://imsweb.sytes.net:5432/ITSAPP";
                    //url = "jdbc:postgresql://192.168.0.29:5432/ITSAPP";
                    String user = "postgres";
                    String pass = "admineus";
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    status = true;
                    System.out.println("connected:" + status);
                    // Toast.makeText(ctxt, "connected:" + status, Toast.LENGTH_LONG).show();

                    connection.setAutoCommit(false);
                    System.out.println("Opened database successfully");
                    //Toast.makeText(ctxt, "Opened database successfully", Toast.LENGTH_LONG).show();

                    String direc = "Dirección no disponible. Posible problema de conexión o no se encuentra la calle";
                    try {
                        Geocoder geocoder = new Geocoder(ctxt);
                        List<Address> direccion = geocoder.getFromLocation(ubicacion.getLatitude(), ubicacion.getLongitude(), 1);
                        direc = direccion.get(0).getAddressLine(0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Date currentTime = Calendar.getInstance().getTime();

                    try {
                        stmt = connection.createStatement();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss");
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String hora = sdf3.format(timestamp);
                    String sql = "INSERT INTO public.\"UBICACIONES\" (\"FECHA_DATO\", \"USUARIO\", \"LATITUD\", \"LONGITUD\", \"ALTITUD\", \"VELOCIDAD\", \"PRECISIOND\", \"DIRECCION\", \"HORA\") "
                            + "VALUES ('" + currentTime.toString() + "', " +
                            "'Iner Euskadi'," +
                            "" + ubicacion.getLatitude() + ", " +
                            "" + ubicacion.getLongitude() + ", " +
                            "" + ubicacion.getAltitude() + ", " +
                            "" + ubicacion.getSpeed() + ", " +
                            "" + ubicacion.getAccuracy() + ", " +
                            "'" + direc + "','" + hora + "');";
                    System.out.println(sql);
                    //Toast.makeText(ctxt, sql, Toast.LENGTH_LONG).show();
                    stmt.executeUpdate(sql);

                    stmt.close();
                    connection.commit();
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            this.status = false;
        }
    }
    //endregion
    //region Server_Usuario2

    /**
     * Mediante este método se recoge uno datos en específico
     * @return
     */
    public Connection getExtraConnection() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(c.toString());
        return c;
    }
    //endregion
    //region Server_Agentes

    /**
     * Mediante este método se obtiene todos los datos de los agentes en la base de datos externa a la aplicación
     * @return
     */
    public List<String> getAgentes() {
        List<String> Agentes = new ArrayList<>();

        try {
            Statement stmt = null;
            url = "jdbc:postgresql://imsweb.sytes.net:5432/ITSAPP";
            String user = "postgres";
            String pass = "admineus";
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            status = true;
            System.out.println("connected:" + status);

            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            try {
                stmt = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String sql = "SELECT DISTINCT \"USUARIO\" FROM public.\"UBICACIONES\"";
            System.out.println(sql);
            ResultSet rs = null;

            if (stmt != null) {
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Agentes.add(rs.getString(1));
                }
            }
            stmt.close();
            connection.commit();
            connection.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return Agentes;
    }
    //endregion
    //region Server_Codigos

    /**
     * Mediante este método se obtienen la información de los codigo de la base de datos externa a la de la aplicación
     * mediante la infromacion del peaje y la tarifa
     * @param peaje
     * @param tarifa
     * @return
     */
    public List<CodigosPrecio> getCodigos(String peaje, String tarifa) {
        List<CodigosPrecio> codigos = new ArrayList<>();

        try {
            Statement stmt = null;
            url = "jdbc:postgresql://imsweb.es:5432/imsdb";
            //url = "jdbc:postgresql://192.168.0.29:5432/imsdb";
            String user = "admineus";
            String pass = "admineus";
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            status = true;
            System.out.println("connected:" + status);

            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            switch (tarifa) {
                case "COSTE GESTION FIJO":

                    tarifa = "CGF";

                    break;
                case "COSTE GESTION INDEXADO":

                    tarifa = "CGI";

                    break;

                case "GESTION INER FIJO":

                    tarifa = "GIF";

                    break;

                case "GESTION INER INDEXADO":

                    tarifa = "GII";

                    break;

                default:

                    break;

            }
            try {
                stmt = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String sql = "SELECT DISTINCT ON (\"CODIGO\") \"CODIGO\", \"FEECUOTA\", \"PRPOTENCIA\", \"FIJOINDEX\", \"TARIFA\", \"PEAJE\", \"DETALLE\", \"SUMINISTRO\", \"CODIGOVISIBLE\", \"COMISION\", \"ID\"  FROM public.\"codigosprecios\" WHERE \"TARIFA\"='" + tarifa + "' AND \"PEAJE\"='" + peaje + "'";
            System.out.println(sql);
            ResultSet rs = null;

            if (stmt != null) {
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    CodigosPrecio codi = new CodigosPrecio();
                    codi.setId(rs.getInt(11));
                    codi.setCodigo(rs.getString(1));
                    codi.setFeecuota(rs.getString(2));
                    codi.setPrpotencia(rs.getString(3));
                    codi.setFijoindex(rs.getString(4));
                    codi.setTarifa(rs.getString(5));
                    codi.setPeaje(rs.getString(6));
                    codi.setDetalle(rs.getString(7));
                    codi.setSuministro(rs.getString(8));
                    codi.setCodigovisible(rs.getString(9));
                    codi.setComision(rs.getDouble(10));
                    codigos.add(codi);
                }

            }
            stmt.close();
            connection.commit();
            connection.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            System.out.println("ERROR AL LEER CODIGO ");
        }

        return codigos;
    }
    //endregion
    //region Server_CGF

    /**
     * Mediante este metodo se obtienen los datos de los precios para la simulacion de luz
     * @param peaje
     * @return
     */
    public Pricing getCGF(String peaje) {
        Pricing precio = new Pricing();

        try {
            Statement stmt = null;
            url = "jdbc:postgresql://imsweb.es:5432/imsdb";
            //url = "jdbc:postgresql://192.168.0.29:5432/imsdb";

            String user = "admineus";
            String pass = "admineus";
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            status = true;
            System.out.println("connected:" + status);

            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "SELECT * FROM public.\"pricing\" WHERE \"PEAJE\" ='" + peaje + "' ORDER BY \"ID\" ASC";
            //String sql = "SELECT * FROM public.\"pricing\" WHERE \"PEAJE\" ='2.0TD' ORDER BY \"ID\" ASC";
            System.out.println(sql);
            try {
                stmt = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ResultSet rs = null;

            if (stmt != null) {
                rs = stmt.executeQuery(sql);
                while (rs.next()) {

                    precio.setId(rs.getInt(14));
                    precio.setPeaje(rs.getString(1));
                    precio.setP1e(rs.getDouble(2));
                    System.out.println(rs.getDouble(2));
                    precio.setP2e(rs.getDouble(3));
                    precio.setP3e(rs.getDouble(4));
                    precio.setP4e(rs.getDouble(5));
                    precio.setP5e(rs.getDouble(6));
                    precio.setP6e(rs.getDouble(7));
                    precio.setP1p(rs.getDouble(8));
                    System.out.println(rs.getDouble(8));
                    precio.setP2p(rs.getDouble(9));
                    precio.setP3p(rs.getDouble(10));
                    precio.setP4p(rs.getDouble(11));
                    precio.setP5p(rs.getDouble(12));
                    precio.setP6p(rs.getDouble(13));
                    return precio;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return precio;
    }
    //endregion
    //region CGFI

    /**
     * Mediante este metodo se obtienen los datos de los precios para la simulacion de luz pero indexado
     * @param peaje
     * @param mes
     * @return
     */
    public Pricing getCGFI(String peaje, String mes) {
        Pricing precio = new Pricing();

        try {
            Statement stmt = null;
            url = "jdbc:postgresql://imsweb.es:5432/imsdb";
            //url = "jdbc:postgresql://192.168.0.29:5432/imsdb";

            String user = "admineus";
            String pass = "admineus";
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            status = true;
            System.out.println("connected:" + status);

            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "SELECT * FROM public.\"pricingindex\" WHERE \"PEAJE\" ='" + peaje + "AND \"MES\" = '" + mes + "' ORDER BY \"ID\" ASC";
            //String sql = "SELECT * FROM public.\"pricing\" WHERE \"PEAJE\" ='2.0TD' ORDER BY \"ID\" ASC";
            System.out.println(sql);
            try {
                stmt = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ResultSet rs = null;

            if (stmt != null) {
                rs = stmt.executeQuery(sql);
                while (rs.next()) {

                    precio.setId(rs.getInt(1));
                    precio.setPeaje(rs.getString(4));
                    precio.setP1e(rs.getDouble(5));
                    precio.setP2e(rs.getDouble(6));
                    precio.setP3e(rs.getDouble(7));
                    precio.setP4e(rs.getDouble(8));
                    precio.setP5e(rs.getDouble(9));
                    precio.setP6e(rs.getDouble(10));
                    return precio;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return precio;
    }
    //endregion
    //region CGFG

    /**
     * Mediante este metodo se obtienen los datos de los precios para la simulacion de gas
     * @param peaje
     * @return
     */
    public PricingGas getCGFG(String peaje) {
        PricingGas precio = new PricingGas();
        String tar = "ZZ";

        try {
            Statement stmt = null;
            url = "jdbc:postgresql://imsweb.es:5432/imsdb";
            //url = "jdbc:postgresql://192.168.0.29:5432/imsdb";

            String user = "admineus";
            String pass = "admineus";
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            status = true;
            System.out.println("connected:" + status);

            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "SELECT * FROM public.\"pricinggas\" WHERE \"PEAJE\" ='" + peaje + "' AND \"TARIFA\" = '" + tar.toUpperCase(Locale.ROOT).trim() + "' ORDER BY \"ID\" ASC";
            //String sql = "SELECT * FROM public.\"pricing\" WHERE \"PEAJE\" ='2.0TD' ORDER BY \"ID\" ASC";
            System.out.println(sql);
            try {
                stmt = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ResultSet rs = null;

            if (stmt != null) {
                rs = stmt.executeQuery(sql);
                while (rs.next()) {

                    precio.setId(rs.getInt(1));
                    precio.setPeaje(rs.getString(2));
                    precio.setTermino_fijo(rs.getDouble(3));
                    System.out.println(rs.getDouble(3));
                    precio.setTermino_variable(rs.getDouble(4));
                    precio.setTarifa(rs.getString(5));
                    return precio;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return precio;
    }
    //endregion
    //region CGFGI

    /**
     * Mediante este metodo se obtienen los datos de los precios para la simulacion de gas pero indexado
     * @param peaje
     * @param mes
     * @return
     */
    public PricingGas getCGFGI(String peaje, String mes) {
        PricingGas precio = new PricingGas();
        String tar = "ZZ";
        String peaj = "";
        try {
            Statement stmt = null;
            url = "jdbc:postgresql://imsweb.es:5432/imsdb";
            //url = "jdbc:postgresql://192.168.0.29:5432/imsdb";

            String user = "admineus";
            String pass = "admineus";
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            status = true;
            System.out.println("connected:" + status);

            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            //String sql = "SELECT '"+peaje.replaceAll(".","")+"' FROM public.\"pricinggasindex\" WHERE \"MES\" = '" + mes + "' ORDER BY \"ID\" ASC";
            String sql = "SELECT '"+peaje.replaceAll(".","")+"' FROM public.\"pricinggasindex\" WHERE \"MES\" = '" + mes + "' ORDER BY \"ID\" ASC";
            //String sql = "SELECT * FROM public.\"pricing\" WHERE \"PEAJE\" ='2.0TD' ORDER BY \"ID\" ASC";
            System.out.println(sql);
            try {
                stmt = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ResultSet rs = null;

            if (stmt != null) {
                rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    try {
                        precio.setTermino_variable(rs.getDouble(1));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                    return precio;
                }
            } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return precio;
    }
    //endregion
}
