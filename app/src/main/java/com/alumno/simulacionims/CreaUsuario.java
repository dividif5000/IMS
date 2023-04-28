package com.alumno.simulacionims;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alumno.simulacionims.models.Usuario;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * @author David Ruiz Garcia
 * Objeto CrearUsuario para hacer uso de la actividad con dicho nombre
 */
public class CreaUsuario extends AppCompatActivity {
    //region Variables
    private int idag;
    private EditText nombre;
    private EditText contraseña;
    private EditText confirma;
    private ImageView mostrar;
    private Spinner sede;
    private EditText privilegios;
    private EditText idAgente;
    private EditText mail;
    private Button crear;

    private SQLiteDatabase db;

    private boolean isPasswordVisible = false;

    final String [] sucursales = {"INER EUSKADI","INER CASTILLA"};
    //endregion
    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(androidx.appcompat.R.style.Theme_AppCompat_DayNight);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_usuario);

        nombre = findViewById(R.id.txtNombre);
        contraseña = findViewById(R.id.txtContraseña);
        confirma = findViewById(R.id.txtConfirmaCon);
        mostrar = findViewById(R.id.imgOjo);
        sede = findViewById(R.id.spnSedes);
        privilegios = findViewById(R.id.txtPrivilegios);
        idAgente = findViewById(R.id.txtIdAgente);
        mail = findViewById(R.id.txtCorreo);
        crear = findViewById(R.id.btnCrear2);

        DataBaseHelper inerbase = new DataBaseHelper(CreaUsuario.this, "IMS.db", null, 1);
        db = inerbase.getWritableDatabase();

        //region spnSede
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>
                (this, R.layout.spinneriner,sucursales);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sede.setAdapter(adaptador);
        String sucur = (String) sede.getSelectedItem();
        sede.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sucursal = (String) sede.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No seleccionaron nada
            }


        });
        //endregion
        //region btnMostrar
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPasswordVisible = !isPasswordVisible;
                if (isPasswordVisible) {
                    muestra();
                } else {
                    oculta();
                }
            }
        });
        //endregion
        //region btnCrear
        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nombre == null && contraseña == null && confirma == null && privilegios == null && idAgente == null && mail == null) {
                    Toast.makeText(getApplicationContext(),"Los valores no se pueden dejar vacios", Toast.LENGTH_SHORT).show();
                } else {
                    if (nombre.getText().length() == 0 && contraseña.getText().length() == 0 && confirma.getText().length() == 0 && privilegios.getText().length() == 0 && idAgente.getText().length() == 0 && mail.getText().length() == 0) {
                        Toast.makeText(getApplicationContext(), "Tiene que rellenar todos los campos", Toast.LENGTH_SHORT).show();
                    } else if (!contraseña.getText().toString().trim().equals(confirma.getText().toString().trim())) {
                        Toast.makeText(getApplicationContext(), "No coinciden las contraseñas", Toast.LENGTH_SHORT).show();
                    } else {
                        idag = Integer.parseInt(idAgente.getText().toString());
                        actualizaDB();
                        try {
                            writeToXmlFile(null);
                        } catch (ParserConfigurationException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (SAXException e) {
                            e.printStackTrace();
                        } catch (TransformerException e) {
                            e.printStackTrace();
                        }
                        //Toast.makeText(getApplicationContext(),"Se ha creado correctamente el nuevo usuario",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
        //endregion
    }
    //endregion
    //region ModificaDB
    public void actualizaDB(){
        db.execSQL("INSERT INTO USUARIO (NOMBRE,CONTRASEÑA,SEDE,PRIVILEGIOS,IDAGENTE,MAIL) VALUES ('" + nombre.getText().toString().toUpperCase(Locale.ROOT) + "','" + confirma.getText().toString() + "','" + ((String) sede.getSelectedItem().toString()) + "','" + privilegios.getText().toString().toUpperCase(Locale.ROOT) + "'," + idAgente.getText() + ",'" + mail.getText().toString().toLowerCase(Locale.ROOT) + "')");
    }
    //endregion
    //region Mostrado
    /**
     * Mediante este metodo se muestras los campos de las contraseñas
     */
    public void muestra(){
        contraseña.setTransformationMethod(null);// Mostrar contraseña
        confirma.setTransformationMethod(null);// Mostrar contraseña
        mostrar.setImageResource(R.drawable.ojo__1_);//Cambiar de imagen
    }
    /**
     * Mediante este metodo se ocultan los campos de las contraseñas
     */
    public void oculta(){
        contraseña.setTransformationMethod(new PasswordTransformationMethod()); //Ocultar contraseña
        confirma.setTransformationMethod(new PasswordTransformationMethod()); //Ocultar contraseña
        mostrar.setImageResource(R.drawable.ojo);
    }
    //endregion
    //region XML

    /**
     * Mediante este método podemos escribir en un xml
     * @param view
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     * @throws TransformerException
     */
    private void writeToXmlFile(View view) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        System.out.println("**************************************************************************************************************************");
        String ruta;
        ruta = this.getExternalFilesDir(null) + "/ims_usuario.xml";
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(nombre.getText().toString(),confirma.getText().toString(),sede.getSelectedItem().toString(),privilegios.getText().toString(),idag,mail.getText().toString()));
        File directory = new File(ruta);
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(directory);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = documentBuilderFactory.newDocumentBuilder();

        Document doc = docBuilder.parse(ruta);

        Node root=doc.getFirstChild();
        Element newusuario=doc.createElement("usuario");
        root.appendChild(newusuario);

        Element idusuario = doc.createElement("id");
        idusuario.appendChild(doc.createTextNode(""));
        newusuario.appendChild(idusuario);

        Element nomb = doc.createElement("nombre");
        nomb.appendChild(doc.createTextNode(nombre.getText().toString()));
        newusuario.appendChild(nomb);

        Element contra = doc.createElement("contraseña");
        nomb.appendChild(doc.createTextNode(contraseña.getText().toString()));
        newusuario.appendChild(contra);

        Element sed = doc.createElement("sede");
        nomb.appendChild(doc.createTextNode(sede.getSelectedItem().toString()));
        newusuario.appendChild(sed);

        Element privi = doc.createElement("privilegios");
        nomb.appendChild(doc.createTextNode(privilegios.getText().toString()));
        newusuario.appendChild(privi);

        System.out.println("EscribiendoXML "+ privilegios.getText());
        Element idage = doc.createElement("nombre");
        nomb.appendChild(doc.createTextNode(idAgente.getText().toString()));
        newusuario.appendChild(idage);

        Element mai = doc.createElement("mail");
        nomb.appendChild(doc.createTextNode(mail.getText().toString()));
        newusuario.appendChild(mai);

        // Abrir el archivo XML existente o crear uno nuevo si no existe



        // Crear un nuevo XmlSerializer
        /*XmlSerializer serializer = Xml.newSerializer();

        try {
            serializer.setOutput(fos, "UTF-8");
            serializer.startDocument(null, true);

            // Inicio de la etiqueta principal
            serializer.startTag(null, "usuarios");

            for (Usuario usuario : usuarios) {

                // Inicio de la etiqueta de usuario
                serializer.startTag(null, "usuario");

                // Etiqueta de id
                serializer.startTag(null, "id");
                serializer.text(String.valueOf(usuario.getId()));
                serializer.endTag(null, "id");

                // Etiqueta de nombre
                serializer.startTag(null, "nombre");
                serializer.text(usuario.getNombre());
                serializer.endTag(null, "nombre");

                // Etiqueta de contraseña
                serializer.startTag(null, "contraseña");
                serializer.text(usuario.getContraseña());
                serializer.endTag(null, "contraseña");

                // Etiqueta de sede
                serializer.startTag(null, "sede");
                serializer.text(usuario.getSede());
                serializer.endTag(null, "sede");

                // Etiqueta de privilegios
                serializer.startTag(null, "privilegios");
                serializer.text(usuario.getPrivilegios());
                serializer.endTag(null, "privilegios");

                // Etiqueta de idagente
                serializer.startTag(null, "idagente");
                serializer.text(String.valueOf(usuario.getIdAgente()));
                serializer.endTag(null, "idagente");

                //Etiqueta de mail
                serializer.startTag(null, "mail");
                serializer.text(usuario.getMail());
                serializer.endTag(null, "mail");

                // Cierre de la etiqueta de usuario
                serializer.endTag(null, "usuario");

            }

            // Cierre de la etiqueta principal
            serializer.endTag(null, "usuarios");

            serializer.endDocument();
            serializer.flush();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        DOMSource source = new DOMSource(doc);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        System.out.println(ruta);
        StreamResult result = new StreamResult(ruta);
        transformer.transform(source, result);

        // Mostrar mensaje de éxito al usuario
        Toast.makeText(this, "Usuarios agregados al archivo XML.", Toast.LENGTH_SHORT).show();

    }
    //endregion

}