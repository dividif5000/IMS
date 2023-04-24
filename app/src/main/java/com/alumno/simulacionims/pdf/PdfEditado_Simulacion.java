package com.alumno.simulacionims.pdf;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.alumno.simulacionims.models.Simulacion;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author David Ruiz Garcia
 * Objeto Molde que se usa para poder generar en las actividades un pdf con localización x e y
 */
public class PdfEditado_Simulacion {

    //region pdfSimulaLuz

    /**
     * Mediante este método se crea un pdf apto para un dispositivo movil
     * pasandole como parametro el contexto de la actividad y el objeto del que se obtienen los datos
     * @param context
     * @param simula
     */
    public void createPDF_Luz(Context context, Simulacion simula) {

        // TODO Obtener los datos del cliente y cups desde la base de datos interna
        String cliente = simula.getCliente();
        String cups = simula.getCups();
        String fecha_inicio = simula.getFecha_inicio();
        String fecha_fin = simula.getFecha_final();
        String dias = String.valueOf(simula.getDias());
        String tarifa = simula.getTarifa();
        String oferta= simula.getOferta();
        String e1inicio= String.valueOf(simula.getE1inicio());
        String e2inicio= String.valueOf(simula.getE2inicio());
        String e3inicio= String.valueOf(simula.getE3inicio());
        String e4inicio= String.valueOf(simula.getE4inicio());
        String e5inicio= String.valueOf(simula.getE5inicio());
        String e6inicio= String.valueOf(simula.getE6inicio());
        String e1fin= String.valueOf(simula.getE1fin());
        String e2fin= String.valueOf(simula.getE2fin());
        String e3fin= String.valueOf(simula.getE3fin());
        String e4fin= String.valueOf(simula.getE4fin());
        String e5fin= String.valueOf(simula.getE5fin());
        String e6fin= String.valueOf(simula.getE6fin());
        String p1= String.valueOf(simula.getP1());
        String p2= String.valueOf(simula.getP2());
        String p3= String.valueOf(simula.getP3());
        String p4= String.valueOf(simula.getP4());
        String p5= String.valueOf(simula.getP5());
        String p6= String.valueOf(simula.getP6());
        String e1_importe= String.valueOf(simula.getE1Importe());
        String e2_importe= String.valueOf(simula.getE2Importe());
        String e3_importe= String.valueOf(simula.getE3Importe());
        String e4_importe= String.valueOf(simula.getE4Importe());
        String e5_importe= String.valueOf(simula.getE5Importe());
        String e6_importe= String.valueOf(simula.getE6Importe());
        String p1_importe= String.valueOf(simula.getP1Importe());
        String p2_importe= String.valueOf(simula.getP2Importe());
        String p3_importe= String.valueOf(simula.getP3Importe());
        String p4_importe= String.valueOf(simula.getP4Importe());
        String p5_importe= String.valueOf(simula.getP5Importe());
        String p6_importe= String.valueOf(simula.getP6Importe());
        String gestion_iner= String.valueOf(simula.getGestio_iner());
        String base_imponible= String.valueOf(simula.getBase_imponible());




        // TODO Crear un objeto Locale personalizado para la moneda euro
        Locale euroLocale = new Locale("es", "ES"); // es_ES es el código para la moneda euro en España

        // TODO Crear un objeto NumberFormat para formato de moneda euro
        NumberFormat euroFormat = NumberFormat.getCurrencyInstance(euroLocale);

        DecimalFormat formato = new DecimalFormat("#.#####");
        // TODO Obtener la ruta de la carpeta de descargas

        String downloadPath = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.FROYO) {
            downloadPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        }
        String fecha ="";
        String simulacion = "SIMULACION";
        //String factura = "Factura";
        //String datos = "Datos del cliente";
        String cli = "Nombre del Cliente: "+ cliente.toUpperCase();
        String cup = "CUPS: " + cups.toUpperCase();
        String tari = "Tarifa Acceso: " + tarifa.toUpperCase();
        String distribuidora = "Distribuidora: I-DE REDES ELECTRICAS INTELIGENTES, S.A.U";
        //String detalle = "Detalle de la factura";
        String concepto = "Concepto";
        String importe = "Importe en €";
        //String informacion = "Información de interés";
        String terminop1 = "Termino Potencia P1";
        Double p1impo = Double.parseDouble(p1_importe);
        String p1_5dec = formato.format(p1impo);
        String pot1 = p1+"  *  "+p1_5dec+"  *  "+dias;
        String p1_tot= euroFormat.format(simula.getP1Total());
        String terminop2 = "Termino Potencia P2";
        Double p2impo = Double.parseDouble(p2_importe);
        String p2_5dec = formato.format(p2impo);
        String pot2 = p2+"  *  "+p2_5dec+"  *  "+dias;
        String p2_tot= euroFormat.format(simula.getP2Total());
        String terminop3 = "Termino Potencia P3";
        Double p3impo = Double.parseDouble(p3_importe);
        String p3_5dec = formato.format(p3impo);
        String pot3 = p3+"  *  "+p3_5dec+"  *  "+dias;
        String p3_tot= euroFormat.format(simula.getP3Total());
        String terminop4 = "Termino Potencia P4";
        Double p4impo = Double.parseDouble(p4_importe);
        String p4_5dec = formato.format(p4impo);
        String pot4 = p4+"  *  "+p4_5dec+"  *  "+dias;
        String p4_tot= euroFormat.format(simula.getP4Total());
        String terminop5 = "Termino Potencia P5";
        Double p5impo = Double.parseDouble(p5_importe);
        String p5_5dec = formato.format(p5impo);
        String pot5 = p5+"  *  "+p5_5dec+"  *  "+dias;
        String p5_tot= euroFormat.format(simula.getP5Total());
        String terminop6 = "Termino Potencia P6";
        Double p6impo = Double.parseDouble(p6_importe);
        String p6_5dec = formato.format(p6impo);
        String pot6 = p6+"  *  "+p6_5dec+"  *  "+dias;
        String p6_tot= euroFormat.format(simula.getP6Total());
        String terminoe1 = "Termino Energia E1";
        Double tote1 = Double.parseDouble(e1inicio)+Double.parseDouble(e1fin);
        Double e1impo = Double.parseDouble(e1_importe);
        String e1_5dec = formato.format(e1impo);
        String texe1 = tote1+"  *  "+e1_5dec;
        String e1_tot= euroFormat.format(simula.getE1Total());
        String terminoe2 = "Termino Energia E2";
        Double tote2 = Double.parseDouble(e2inicio)+Double.parseDouble(e2fin);
        Double e2impo = Double.parseDouble(e2_importe);
        String e2_5dec = formato.format(e2impo);
        String texe2 = tote2+"  *  "+e2_5dec;
        String e2_tot= euroFormat.format(simula.getE2Total());
        String terminoe3 = "Termino Energia E3";
        Double tote3 = Double.parseDouble(e3inicio)+Double.parseDouble(e3fin);
        Double e3impo = Double.parseDouble(e3_importe);
        String e3_5dec = formato.format(e3impo);
        String texe3 = tote3+"  *  "+e3_5dec;
        String e3_tot= euroFormat.format(simula.getE3Total());
        String terminoe4 = "Termino Energia E4";
        Double tote4 = Double.parseDouble(e4inicio)+Double.parseDouble(e4fin);
        Double e4impo = Double.parseDouble(e4_importe);
        String e4_5dec = formato.format(e4impo);
        String texe4 = tote4+"  *  "+e4_5dec;
        String e4_tot= euroFormat.format(simula.getE4Total());
        String terminoe5 = "Termino Energia E5";
        Double tote5 = Double.parseDouble(e5inicio)+Double.parseDouble(e5fin);
        Double e5impo = Double.parseDouble(e5_importe);
        String e5_5dec = formato.format(e5impo);
        String texe5 = tote5+"  *  "+e5_5dec;
        String e5_tot= euroFormat.format(simula.getE5Total());
        String terminoe6 = "Termino Energia E6";
        Double tote6 = Double.parseDouble(e6inicio)+Double.parseDouble(e6fin);
        Double e6impo = Double.parseDouble(e6_importe);
        String e6_5dec = formato.format(e6impo);
        String texe6 = tote6+"  *  "+e6_5dec;
        String e6_tot = euroFormat.format(simula.getE6Total());
        String gestion = "Gestión Iner";
        String reactiva = "Reactiva";
        String excesos = "Excesos";
        String impuestoelec = "Impuesto Electricidad";
        String impueEle = "0,5%    "+base_imponible;
        String impuesellctri = euroFormat.format(simula.getImpuesto());
        String ajustegas = "Ajuste tope de Gas";
        String alquilerdistri = "Alquiler Equipo Distribuidora";
        String baseimp = "Base Imponible";
        String base_impo = euroFormat.format(simula.getBase_imponible());
        String ifa = "I.V.A.";
        String iwa = euroFormat.format(simula.getIva());
        String to = "TOTAL";
        String tota = euroFormat.format(simula.getTotal());
        String teldist = "Teléfono Distribuidora: 900 171 171";
        String teliner = "Teléfono Iner Euskadi S.L.: 943 930 600";

        DateTimeFormatter dtf = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd HH-mm-ss");
        }
        LocalDateTime now = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            now = LocalDateTime.now();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            fecha =dtf.format(now);
        }
        // TODO Crear el archivo PDF
        File pdfFile = new File(downloadPath, "Simulacion-Luz"+cups+".pdf");
        try {
            pdfFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TODO Escribir los datos del cliente y cups en el archivo PDF
        try {
            InputStream log = context.getResources().getAssets().open("InerEuskadi.png");
            FileOutputStream outputStream = new FileOutputStream(pdfFile);
            Document document = new Document();
            PdfWriter writer;
            writer=PdfWriter.getInstance(document, outputStream);
            document.open();

            //TODO IMAGEN DE LOGO INER EUSKADI
            // Carga la imagen desde un archivo
            Bitmap bitmap = BitmapFactory.decodeStream(log);

            // Crea un objeto Image con la imagen
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            Image logo = Image.getInstance(stream.toByteArray());

            // Obtiene el objeto PdfContentByte del escritor de PDF
            PdfContentByte canvas = writer.getDirectContent();

            // Establece la posición absoluta de la imagen en la página
            logo.setAbsolutePosition(50, 730);

            // Agrega la imagen al documento
            canvas.addImage(logo);

            //TODO IMAGEN DE FACTURA
            InputStream fac = context.getResources().getAssets().open("Factura.png");

            // Carga la imagen desde un archivo
            Bitmap bitma = BitmapFactory.decodeStream(fac);

            ByteArrayOutputStream strea = new ByteArrayOutputStream();
            bitma.compress(Bitmap.CompressFormat.PNG, 100, strea);
            Image factur = Image.getInstance(strea.toByteArray());

            // Obtiene el objeto PdfContentByte del escritor de PDF
            canvas = writer.getDirectContent();

            // Establece la posición absoluta de la imagen en la página
            factur.setAbsolutePosition(50, 710);

            // Agrega la imagen al documento
            canvas.addImage(factur);

            //TODO IMAGEN DE DATOS DEL CLIENTE
            InputStream dat = context.getResources().getAssets().open("Datos_Cliente.png");

            // Carga la imagen desde un archivo
            Bitmap bitm = BitmapFactory.decodeStream(dat);

            ByteArrayOutputStream stre = new ByteArrayOutputStream();
            bitm.compress(Bitmap.CompressFormat.PNG, 100, stre);
            Image dato = Image.getInstance(stre.toByteArray());

            // Obtiene el objeto PdfContentByte del escritor de PDF
            canvas = writer.getDirectContent();

            // Establece la posición absoluta de la imagen en la página
            dato.setAbsolutePosition(50, 645);

            // Agrega la imagen al documento
            canvas.addImage(dato);

            //TODO IMAGEN DE DETALLE DE LA FACTURA
            InputStream det = context.getResources().getAssets().open("Detalle_Factura.png");

            // Carga la imagen desde un archivo
            Bitmap bit = BitmapFactory.decodeStream(det);

            ByteArrayOutputStream str = new ByteArrayOutputStream();
            bit.compress(Bitmap.CompressFormat.PNG, 100, str);
            Image deta = Image.getInstance(str.toByteArray());

            // Obtiene el objeto PdfContentByte del escritor de PDF
            canvas = writer.getDirectContent();

            // Establece la posición absoluta de la imagen en la página
            deta.setAbsolutePosition(50, 530);

            // Agrega la imagen al documento
            canvas.addImage(deta);

            //TODO IMAGEN DE INFROMACIÓN DE INTERES
            InputStream inf = context.getResources().getAssets().open("Informacion_Interes.png");

            // Carga la imagen desde un archivo
            Bitmap bi = BitmapFactory.decodeStream(inf);

            ByteArrayOutputStream st = new ByteArrayOutputStream();
            bi.compress(Bitmap.CompressFormat.PNG, 100, st);
            Image info = Image.getInstance(st.toByteArray());

            // Obtiene el objeto PdfContentByte del escritor de PDF
            canvas = writer.getDirectContent();

            // Establece la posición absoluta de la imagen en la página
            info.setAbsolutePosition(50, 60);

            // Agrega la imagen al documento
            canvas.addImage(info);


            String hoy ="";
            String fecha_Actual;
            DateTimeFormatter actual = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                actual = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            }
            LocalDateTime ahora = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                ahora = LocalDateTime.now();
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                hoy =actual.format(ahora);
            }
            fecha_Actual ="Fecha Emisión: "+hoy;
            //Crear los recuadros para los datos del cliente y cups
            float recWidth = 10f;
            float recHeight = 5f;

            PdfContentByte cb = writer.getDirectContent();
            BaseFont font = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            //ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(factura, new Font(font, 10)), 80f + recWidth / 4, 710f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(fecha_Actual, new Font(font, 10)), 50f + recWidth / 4, 670f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(simulacion, new Font(font, 10)), 270f + recWidth / 4, 700f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(oferta, new Font(font, 10)), 410f + recWidth / 4, 670f + recHeight / 4, 0);
            //ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(datos, new Font(font, 10)), 80f + recWidth / 4, 650f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(cli, new Font(font, 12)), 50f + recWidth / 4, 630f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(cup, new Font(font, 10)), 50f + recWidth / 4, 615f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(tari, new Font(font, 10)), 50f + recWidth / 4, 600f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(distribuidora, new Font(font, 10)), 50f + recWidth / 4, 585f + recHeight / 4, 0);
            //ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(detalle, new Font(font, 10)), 260f + recWidth / 4, 530f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(fecha_inicio, new Font(font, 14)), 180f + recWidth / 4, 510f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(fecha_fin, new Font(font, 14)), 300f + recWidth / 4, 510f + recHeight / 4, 0);
            //ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(concepto, new Font(font, 10)), 330f + recWidth / 4, 510f + recHeight / 4, 0);
            //ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(importe, new Font(font, 8)), 460f + recWidth / 4, 510f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(terminop1, new Font(font, 10)), 50f + recWidth / 4, 490f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(pot1, new Font(font, 10)), 250f + recWidth / 4, 490f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(p1_tot, new Font(font, 10)), 470f + recWidth / 4, 490f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(terminop2, new Font(font, 10)), 50f + recWidth / 4, 470f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(pot2, new Font(font, 10)), 250f + recWidth / 4, 470f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(p2_tot, new Font(font, 10)), 470f + recWidth / 4, 470f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(terminop3, new Font(font, 10)), 50f + recWidth / 4, 450f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(pot3, new Font(font, 10)), 250f + recWidth / 4, 450f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(p3_tot, new Font(font, 10)), 470f + recWidth / 4, 450f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(terminop4, new Font(font, 10)), 50f + recWidth / 4, 430f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(pot4, new Font(font, 10)), 250f + recWidth / 4, 430f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(p4_tot, new Font(font, 10)), 470f + recWidth / 4, 430f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(terminop5, new Font(font, 10)), 50f + recWidth / 4, 410f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(pot5, new Font(font, 10)), 250f + recWidth / 4, 410f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(p5_tot, new Font(font, 10)), 470f + recWidth / 4, 410f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(terminop6, new Font(font, 10)), 50f + recWidth / 4, 390f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(pot6, new Font(font, 10)), 250f + recWidth / 4, 390f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(p6_tot, new Font(font, 10)), 470f + recWidth / 4, 390f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(terminoe1, new Font(font, 10)), 50f + recWidth / 4, 370f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(texe1, new Font(font, 10)), 250f + recWidth / 4, 370f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(e1_tot, new Font(font, 10)), 470f + recWidth / 4, 370f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(terminoe2, new Font(font, 10)), 50f + recWidth / 4, 350f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(texe2, new Font(font, 10)), 250f + recWidth / 4, 350f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(e2_tot, new Font(font, 10)), 470f + recWidth / 4, 350f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(terminoe3, new Font(font, 10)), 50f + recWidth / 4, 330f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(texe3, new Font(font, 10)), 250f + recWidth / 4, 330f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(e3_tot, new Font(font, 10)), 470f + recWidth / 4, 330f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(terminoe4, new Font(font, 10)), 50f + recWidth / 4, 310f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(texe4, new Font(font, 10)), 250f + recWidth / 4, 310f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(e4_tot, new Font(font, 10)), 470f + recWidth / 4, 310f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(terminoe5, new Font(font, 10)), 50f + recWidth / 4, 290f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(texe5, new Font(font, 10)), 250f + recWidth / 4, 290f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(e5_tot, new Font(font, 10)), 470f + recWidth / 4, 290f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(terminoe6, new Font(font, 10)), 50f + recWidth / 4, 270f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(texe6, new Font(font, 10)), 250f + recWidth / 4, 270f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(e6_tot, new Font(font, 10)), 470f + recWidth / 4, 270f + recHeight / 4, 0);
            if(simula.getTarifa().contains("GESTION INER")) {
                String gest = simula.getFee()+"   *   "+simula.getDias();
                ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(gestion, new Font(font, 10)), 50f + recWidth / 4, 250f + recHeight / 4, 0);
                ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(gest, new Font(font, 10)), 250f + recWidth / 4, 250f + recHeight / 4, 0);
                ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(gestion_iner, new Font(font, 10)), 470f + recWidth / 4, 250f + recHeight / 4, 0);
            }
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(reactiva, new Font(font, 10)), 50f + recWidth / 4, 230f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("0,00€", new Font(font, 10)), 470f + recWidth / 4, 230f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(excesos, new Font(font, 10)), 50f + recWidth / 4, 210f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("0,00€", new Font(font, 10)), 470f + recWidth / 4, 210f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(impuestoelec, new Font(font, 10)), 50f + recWidth / 4, 190f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(impuesellctri, new Font(font, 10)), 470f + recWidth / 4, 190f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(ajustegas, new Font(font, 10)), 50f + recWidth / 4, 170f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("0,00", new Font(font, 10)), 470f + recWidth / 4, 170f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(alquilerdistri, new Font(font, 10)), 50f + recWidth / 4, 150f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("0,00", new Font(font, 10)), 470f + recWidth / 4, 150f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(baseimp, new Font(font, 10)), 50f + recWidth / 4, 130f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(base_impo, new Font(font, 10)), 470f + recWidth / 4, 130f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(ifa, new Font(font, 10)), 50f + recWidth / 4, 110f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(iwa, new Font(font, 10)), 470f + recWidth / 4, 110f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(to, new Font(font, 10)), 50f + recWidth / 4, 90f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(tota, new Font(font, 10)), 470f + recWidth / 4, 90f + recHeight / 4, 0);
            //ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(informacion, new Font(font, 10)), 80f + recWidth / 4, 60f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(teldist, new Font(font, 10)), 110f + recWidth / 4, 40f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(teliner, new Font(font, 10)), 300f + recWidth / 4, 40f + recHeight / 4, 0);

            document.close();
            outputStream.close();
            Toast.makeText(context, "Archivo PDF creado en " + downloadPath, Toast.LENGTH_SHORT).show();

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("PDF");
            builder.setMessage("¿Está seguro de que desea Abri el PDF generado?");

            builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //endregion
    //region pdfSimulaGas

    /**
     * Mediante este método se crea un pdf apto para un dispositivo movil
     * pasandole como parametro el contexto de la actividad y el objeto del que se obtienen los datos
     * @param context
     * @param simula
     */
    public void createPDF_Gas(Context context, Simulacion simula) {

        // TODO Obtener los datos del cliente y cups desde la base de datos interna
        String cliente = simula.getCliente();
        String cups = simula.getCups();
        String fecha_inicio = simula.getFecha_inicio();
        String fecha_fin = simula.getFecha_final();
        String dias = String.valueOf(simula.getDias());
        String tarifa = simula.getTarifa();
        String oferta= simula.getOferta();
        String e1inicio= String.valueOf(simula.getE1inicio());
        String p1= String.valueOf(simula.getP1());
        String e1_importe= String.valueOf(simula.getE1Importe());
        String p1_importe= String.valueOf(simula.getP1Importe()/30);

        String gestion_iner= String.valueOf(simula.getGestio_iner());
        String base_imponible= String.valueOf(simula.getBase_imponible());
        String Alquiler_Equipo= String.valueOf(simula.getAlquiler_equipo());

        final String hidrocarbu = "0,00234€";


        // TODO Crear un objeto Locale personalizado para la moneda euro
        Locale euroLocale = new Locale("es", "ES"); // es_ES es el código para la moneda euro en España

        // TODO Crear un objeto NumberFormat para formato de moneda euro
        NumberFormat euroFormat = NumberFormat.getCurrencyInstance(euroLocale);

        DecimalFormat formato = new DecimalFormat("#.#####");
        // TODO Obtener la ruta de la carpeta de descargas

        String downloadPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        String fecha ="";
        String simulacion = "SIMULACION";
        //String factura = "Factura";
        //String datos = "Datos del cliente";
        String cli = "Nombre del Cliente: "+ cliente.toUpperCase(Locale.ROOT);
        String cup = "CUPS: " + cups.toUpperCase(Locale.ROOT);
        String tari = "Tarifa Acceso: " + tarifa.toUpperCase(Locale.ROOT);
        String distribuidora = "Distribuidora: Nortegas";
        //String detalle = "Detalle de la factura";
        String concepto = "Concepto";
        String importe = "Importe en €";
        //String informacion = "Información de interés";
        String terminop1 = "Termino Fijo";
        Double p1impo = Double.parseDouble(p1_importe);
        String p1_5dec = formato.format(p1impo);
        String pot1 = p1_5dec+"€/kWh  *  " +dias;
        String p1_tot= euroFormat.format(simula.getP1Total());
        String terminoe1 = "Termino Variable";
        Double tote1 = Double.parseDouble(e1inicio);
        Double e1impo = Double.parseDouble(e1_importe);
        String e1_5dec = formato.format(e1impo);
        String texe1 = e1_5dec+"€/kWh  *  "+tote1;
        String e1_tot= euroFormat.format(simula.getE1Total());
        String impuestohidro = "Impuesto Hidrocarburos";
        String impueHid = hidrocarbu+"  *  "+tote1;
        String impueshidrrocar = euroFormat.format(simula.getImpuesto());
        String gestion = "Gestión Iner";
        String reactiva = "Varios Gas";
        String alquilerdistri = "Alquiler Equipo Distribuidora";
        String alquiler_distri = euroFormat.format(simula.getAlquiler_equipo());
        String baseimp = "Base Imponible";
        String base_impo = euroFormat.format(simula.getBase_imponible());
        String ifa = "I.V.A.";
        String iwa = euroFormat.format(simula.getIva());
        String to = "TOTAL";
        String tota = euroFormat.format(simula.getTotal());
        String teldist = "Teléfono Distribuidora: 900 171 171";
        String teliner = "Teléfono Iner Euskadi S.L.: 943 930 600";

        DateTimeFormatter dtf = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd HH-mm-ss");
        }
        LocalDateTime now = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            now = LocalDateTime.now();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            fecha =dtf.format(now);
        }
        // TODO Crear el archivo PDF
        File pdfFile = new File(downloadPath, "Simulacion-Gas"+cups+".pdf");
        try {
            pdfFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TODO Escribir los datos del cliente y cups en el archivo PDF
        try {
            InputStream log = context.getResources().getAssets().open("inergas_logo.png");
            FileOutputStream outputStream = new FileOutputStream(pdfFile);
            Document document = new Document();
            PdfWriter writer;
            writer=PdfWriter.getInstance(document, outputStream);
            document.open();

            //TODO IMAGEN DE LOGO INER EUSKADI
            // Carga la imagen desde un archivo
            Bitmap bitmap = BitmapFactory.decodeStream(log);

            // Crea un objeto Image con la imagen
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            Image logo = Image.getInstance(stream.toByteArray());

            // Obtiene el objeto PdfContentByte del escritor de PDF
            PdfContentByte canvas = writer.getDirectContent();

            // Establece la posición absoluta de la imagen en la página
            logo.setAbsolutePosition(50, 730);

            // Agrega la imagen al documento
            canvas.addImage(logo);

            //TODO IMAGEN DE FACTURA
            InputStream fac = context.getResources().getAssets().open("FacturaGas.png");

            // Carga la imagen desde un archivo
            Bitmap bitma = BitmapFactory.decodeStream(fac);

            ByteArrayOutputStream strea = new ByteArrayOutputStream();
            bitma.compress(Bitmap.CompressFormat.PNG, 100, strea);
            Image factur = Image.getInstance(strea.toByteArray());

            // Obtiene el objeto PdfContentByte del escritor de PDF
            canvas = writer.getDirectContent();

            // Establece la posición absoluta de la imagen en la página
            factur.setAbsolutePosition(50, 710);

            // Agrega la imagen al documento
            canvas.addImage(factur);

            //TODO IMAGEN DE DATOS DEL CLIENTE
            InputStream dat = context.getResources().getAssets().open("Datos_ClienteGas.png");

            // Carga la imagen desde un archivo
            Bitmap bitm = BitmapFactory.decodeStream(dat);

            ByteArrayOutputStream stre = new ByteArrayOutputStream();
            bitm.compress(Bitmap.CompressFormat.PNG, 100, stre);
            Image dato = Image.getInstance(stre.toByteArray());

            // Obtiene el objeto PdfContentByte del escritor de PDF
            canvas = writer.getDirectContent();

            // Establece la posición absoluta de la imagen en la página
            dato.setAbsolutePosition(50, 645);

            // Agrega la imagen al documento
            canvas.addImage(dato);

            //TODO IMAGEN DE DETALLE DE LA FACTURA
            InputStream det = context.getResources().getAssets().open("Detalle_FacturaGas.png");

            // Carga la imagen desde un archivo
            Bitmap bit = BitmapFactory.decodeStream(det);

            ByteArrayOutputStream str = new ByteArrayOutputStream();
            bit.compress(Bitmap.CompressFormat.PNG, 100, str);
            Image deta = Image.getInstance(str.toByteArray());

            // Obtiene el objeto PdfContentByte del escritor de PDF
            canvas = writer.getDirectContent();

            // Establece la posición absoluta de la imagen en la página
            deta.setAbsolutePosition(50, 530);

            // Agrega la imagen al documento
            canvas.addImage(deta);

            //TODO IMAGEN DE INFROMACIÓN DE INTERES
            InputStream inf = context.getResources().getAssets().open("Informacion_InteresGas.png");

            // Carga la imagen desde un archivo
            Bitmap bi = BitmapFactory.decodeStream(inf);

            ByteArrayOutputStream st = new ByteArrayOutputStream();
            bi.compress(Bitmap.CompressFormat.PNG, 100, st);
            Image info = Image.getInstance(st.toByteArray());

            // Obtiene el objeto PdfContentByte del escritor de PDF
            canvas = writer.getDirectContent();

            // Establece la posición absoluta de la imagen en la página
            info.setAbsolutePosition(50, 300);

            // Agrega la imagen al documento
            canvas.addImage(info);


            String hoy ="";
            String fecha_Actual;
            DateTimeFormatter actual = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                actual = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            }
            LocalDateTime ahora = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                ahora = LocalDateTime.now();
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                hoy =actual.format(ahora);
            }
            fecha_Actual ="Fecha Emisión: "+hoy;
            //Crear los recuadros para los datos del cliente y cups
            float recWidth = 10f;
            float recHeight = 5f;

            PdfContentByte cb = writer.getDirectContent();
            BaseFont font = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            //ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(factura, new Font(font, 10)), 80f + recWidth / 4, 710f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(fecha_Actual, new Font(font, 10)), 50f + recWidth / 4, 675f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(simulacion, new Font(font, 10)), 270f + recWidth / 4, 700f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(oferta, new Font(font, 10)), 410f + recWidth / 4, 675f + recHeight / 4, 0);
            //ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(datos, new Font(font, 10)), 80f + recWidth / 4, 650f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(cli, new Font(font, 12)), 50f + recWidth / 4, 630f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(cup, new Font(font, 10)), 50f + recWidth / 4, 615f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(tari, new Font(font, 10)), 50f + recWidth / 4, 600f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(distribuidora, new Font(font, 10)), 50f + recWidth / 4, 585f + recHeight / 4, 0);
            //ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(detalle, new Font(font, 10)), 260f + recWidth / 4, 530f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(fecha_inicio, new Font(font, 14)), 180f + recWidth / 4, 510f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(fecha_fin, new Font(font, 14)), 300f + recWidth / 4, 510f + recHeight / 4, 0);
            //ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(concepto, new Font(font, 10)), 330f + recWidth / 4, 510f + recHeight / 4, 0);
            //ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(importe, new Font(font, 8)), 460f + recWidth / 4, 510f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(terminop1, new Font(font, 10)), 50f + recWidth / 4, 490f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(pot1, new Font(font, 10)), 250f + recWidth / 4, 490f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(p1_tot, new Font(font, 10)), 470f + recWidth / 4, 490f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(terminoe1, new Font(font, 10)), 50f + recWidth / 4, 470f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(texe1, new Font(font, 10)), 250f + recWidth / 4, 470f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(e1_tot, new Font(font, 10)), 470f + recWidth / 4, 470f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(impuestohidro, new Font(font, 10)), 50f + recWidth / 4, 450f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(impueHid, new Font(font, 10)), 250f + recWidth / 4, 450f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(impueshidrrocar, new Font(font, 10)), 470f + recWidth / 4, 450f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(reactiva, new Font(font, 10)), 50f + recWidth / 4, 430f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase("0,00€", new Font(font, 10)), 470f + recWidth / 4, 430f + recHeight / 4, 0);
            if(simula.getTarifa().contains("GESTION INER")) {
                String gest = simula.getFee()+"   *   "+simula.getDias();
                ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(gestion, new Font(font, 10)), 50f + recWidth / 4, 410f + recHeight / 4, 0);
                ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(gest, new Font(font, 10)), 250f + recWidth / 4, 410f + recHeight / 4, 0);
                ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(gestion_iner, new Font(font, 10)), 470f + recWidth / 4, 410f + recHeight / 4, 0);
            }
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(alquilerdistri, new Font(font, 10)), 50f + recWidth / 4, 390f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(alquiler_distri, new Font(font, 10)), 470f + recWidth / 4, 390f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(baseimp, new Font(font, 10)), 50f + recWidth / 4, 370f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(base_impo, new Font(font, 10)), 470f + recWidth / 4, 370f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(ifa, new Font(font, 10)), 50f + recWidth / 4, 350f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(iwa, new Font(font, 10)), 470f + recWidth / 4, 350f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(to, new Font(font, 10)), 50f + recWidth / 4, 330f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(tota, new Font(font, 10)), 470f + recWidth / 4, 330f + recHeight / 4, 0);
            //ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(informacion, new Font(font, 10)), 80f + recWidth / 4, 60f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(teldist, new Font(font, 10)), 110f + recWidth / 4, 280f + recHeight / 4, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(teliner, new Font(font, 10)), 300f + recWidth / 4, 280f + recHeight / 4, 0);

            document.close();
            outputStream.close();
            Toast.makeText(context, "Archivo PDF creado en " + downloadPath, Toast.LENGTH_SHORT).show();

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("PDF");
            builder.setMessage("¿Está seguro de que desea Abri el PDF generado?");

            builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //endregion
}
