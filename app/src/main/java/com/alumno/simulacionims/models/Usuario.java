package com.alumno.simulacionims.models;

/**
 * @author David Ruiz Garcia
 * Objeto Molde para hacer uso de los datos de los Usuarios
 */
public class Usuario {
    //region Atributos
    //Declaración de atributos del Objeto Usuario
    private int id;
    private String nombre;
    private String contraseña;
    private String sede;
    private String privilegios;
    private int idAgente;
    private String mail;
    private boolean logueado;
    //endregion
    //region Constructores
    //Constructores

    /**
     * Constructor sin ningun tipo de dato o por defecto
     */
    public Usuario() {
    }

    /**
     * Este constructor contiene los siguientes datos:
     *
     * @param nombre      dato tipo String
     * @param contraseña  dato tipo String
     * @param sede        dato tipo String
     * @param privilegios dato tipo String
     * @param idAgente    dato tipo int
     * @param mail        dato tipo String
     */
    public Usuario(String nombre, String contraseña, String sede, String privilegios, int idAgente, String mail) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.sede = sede;
        this.privilegios = privilegios;
        this.idAgente = idAgente;
        this.mail = mail;
    }

    /**
     * Este constructor contiene los siguientes datos:
     *
     * @param id          dato tipo int
     * @param nombre      dato tipo String
     * @param contraseña  dato tipo String
     * @param sede        dato tipo String
     * @param privilegios dato tipo String
     * @param idAgente    dato tipo int
     * @param mail        dato tipo String
     */
    public Usuario(int id, String nombre, String contraseña, String sede, String privilegios, int idAgente, String mail) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.sede = sede;
        this.privilegios = privilegios;
        this.idAgente = idAgente;
        this.mail = mail;
    }

    /**
     * Este constructor contiene los siguientes datos:
     *
     * @param nombre      dato tipo String
     * @param contraseña  dato tipo String
     * @param sede        dato tipo String
     * @param privilegios dato tipo String
     * @param idAgente    dato tipo int
     * @param mail        dato tipo String
     * @param logueado    dato tipo boolean
     */
    public Usuario(String nombre, String contraseña, String sede, String privilegios, int idAgente, String mail, boolean logueado) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.sede = sede;
        this.privilegios = privilegios;
        this.idAgente = idAgente;
        this.mail = mail;
        this.logueado = logueado;
    }

    /**
     * Este constructor contiene todos los atributos es decir este constructor es el mas completo de todos
     *
     * @param id          dato tipo int
     * @param nombre      dato tipo String
     * @param contraseña  dato tipo String
     * @param sede        sato tipo String
     * @param privilegios dato tipo String
     * @param idAgente    dato tipo int
     * @param mail        dato tipo String
     * @param logueado    dato tipo boolean
     */
    public Usuario(int id, String nombre, String contraseña, String sede, String privilegios, int idAgente, String mail, boolean logueado) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.sede = sede;
        this.privilegios = privilegios;
        this.idAgente = idAgente;
        this.mail = mail;
        this.logueado = logueado;
    }
    //endregion
    //region Getter&Setter
    //Getters y Setters
    /**
     * Devuelve  un int para el id de Usuario
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Llena el campo id mediante un argumento int que se pasa
     *
     * @param id este es el argumento que se pasa para rellenar el campo id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve un String para el nombre del Usuario
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Llena el campo nombre mediante un argumento String que se le pasa
     *
     * @param nombre este es el argumento que se le pasa para rellenar el campo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve un String la contraseña del Usuario
     *
     * @return
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Llena el campo contraseña mediante un argumento String que se le pasa
     *
     * @param contraseña este es el argumento que se le pasa para rellenar el campo contraseña
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Devuelve un String para la sede de la que pertenece el Usuario
     *
     * @return
     */
    public String getSede() {
        return sede;
    }

    /**
     * Llena el campo sede mediante un argumento String que se le pasa
     *
     * @param sede este es el argumento que se le pasa para rellenar el campo sede
     */
    public void setSede(String sede) {
        this.sede = sede;
    }

    /**
     * Devuelve un String paralos privilegios que tiene el Usuario
     *
     * @return
     */
    public String getPrivilegios() {
        return privilegios;
    }

    /**
     * Llena el campo privilegio mediante un argumento String que se le pasa
     *
     * @param privilegios este es el argumento que se le pasa para rellenar el campo privilegios
     */
    public void setPrivilegios(String privilegios) {
        this.privilegios = privilegios;
    }

    /**
     * Devuelve un int para el id de agente correcpondiente al Usuario
     *
     * @return
     */
    public int getIdAgente() {
        return idAgente;
    }

    /**
     * Llena el campo id agente mediante un argumento int que se le pasa
     *
     * @param idAgente este es el argumento que se le pasa para rellenar el campo id agente
     */
    public void setIdAgente(int idAgente) {
        this.idAgente = idAgente;
    }

    /**
     * Devuleve un String para el mail del Usuario
     *
     * @return
     */
    public String getMail() {
        return mail;
    }

    /**
     * Llena el campo mail mediante un argumento String que se le pasa
     *
     * @param mail este es el argumento que se le pasa para rellenar el campo mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Devuelve un campo boolean para saber si el Usuario esta logueado
     *
     * @return
     */
    public boolean isLogueado() {
        return logueado;
    }

    /**
     * Llena el campo logueado mediate un argumento boolean que se le pasa
     *
     * @param logueado este es el argumento que se le pasa para rellenar el campo logueado
     */
    public void setLogueado(boolean logueado) {
        this.logueado = logueado;
    }
    //endregion
    //region toString
    /**
     * Devuelve un String con todos los atributos de la clase Molde Usuario mediate el método toString()
     *
     * @return
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", sede='" + sede + '\'' +
                ", privilegios='" + privilegios + '\'' +
                ", idAgente=" + idAgente +
                ", mail='" + mail + '\'' +
                ", logueado=" + logueado +
                '}';
    }
    //endregion
}
