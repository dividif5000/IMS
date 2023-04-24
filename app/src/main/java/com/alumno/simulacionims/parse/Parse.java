package com.alumno.simulacionims.parse;

import com.alumno.simulacionims.models.Usuario;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

public class Parse {
    //region xmlUSUARIOS
    //USUARIOS

    /**
     * Mediante este metodo se recorren los datos de los usuarios que se importaran desde un xml
     * @param parser
     * @return
     * @throws IOException
     * @throws XmlPullParserException
     */
    public static ArrayList<Usuario> processParsingPartners(XmlPullParser parser) throws IOException, XmlPullParserException {
        ArrayList<Usuario> listaMecenas = new ArrayList<Usuario>();

        int eventType = parser.getEventType();
        Usuario usuario = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String eltMecena; //Aqui se guardara la etiqueta que esta actualmente

            switch (eventType) {
                case XmlPullParser.START_TAG:
                    eltMecena = parser.getName();

                    if ("usuario".equals(eltMecena)) {
                        usuario = new Usuario();
                        listaMecenas.add(usuario);
                    } else if (usuario != null) {
                        //TODO recoge el id
                        if ("id".equals(eltMecena)) {
                            usuario.setId(Integer.parseInt(parser.nextText()));

                            //TODO recoge el nombre
                        } else if ("nombre".equals(eltMecena)) {
                            usuario.setNombre(parser.nextText());

                            //TODO recoge el contraseña
                        } else if ("contraseña".equals(eltMecena)) {
                            usuario.setContraseña(parser.nextText());
                            //nombre = parser.nextText();

                            //TODO recoge la sede
                        } else if ("sede".equals(eltMecena)) {
                            usuario.setSede(parser.nextText());
                            //telefono = parser.nextText();

                            //TODO recoge el privilegio
                        } else if ("privilegio".equals(eltMecena)) {
                            usuario.setPrivilegios(parser.nextText());
                            //correo = parser.nextText();

                            //TODO recoge el idAgente
                        } else if ("idagente".equals(eltMecena)) {
                            usuario.setIdAgente(Integer.parseInt(parser.nextText()));
                            //provincia = parser.nextText();

                            // TODO recoge el mail
                        } else if ("mail".equals(eltMecena)) {
                            usuario.setMail(parser.nextText());
                            //poblacion = parser.nextText();
                        }
                    }
                    break;
            }

                    eventType = parser.next(); //Cambio a siguiente usuario

        }

            return listaMecenas;

    }
    //endregion
}
