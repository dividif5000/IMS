package com.alumno.simulacionims.models;

/**
 * @author David Ruiz Garcia
 * Objeto Molde para hacer uso de los datos de los Pricing
 * Estos datos son recogidos mediate una conexión a un servidor externo
 */
public class Pricing {
    //region Atributos
    //Atributos
    private int id;
    private String peaje;
    private double p1e;
    private double p2e;
    private double p3e;
    private double p4e;
    private double p5e;
    private double p6e;
    private double p1p;
    private double p2p;
    private double p3p;
    private double p4p;
    private double p5p;
    private double p6p;
    //endregion
    //region Constructores
    //Constructores

    /**
     * Constructor sin ningun tipo de dato o por defecto
     */
    public Pricing() {

    }

    /**
     * Este constructor contiene todos los atributos es decir este constructor es el mas completo de todos
     *
     * @param id    dato tipo int
     * @param peaje dato tipo String
     * @param p1e   dato tipo double
     * @param p2e   dato tipo double
     * @param p3e   dato tipo double
     * @param p4e   dato tipo double
     * @param p5e   dato tipo double
     * @param p6e   dato tipo double
     * @param p1p   dato tipo double
     * @param p2p   dato tipo double
     * @param p3p   dato tipo double
     * @param p4p   dato tipo double
     * @param p5p   dato tipo double
     * @param p6p   dato tipo double
     */
    public Pricing(int id, String peaje, double p1e, double p2e, double p3e, double p4e, double p5e, double p6e, double p1p, double p2p, double p3p, double p4p, double p5p, double p6p) {
        this.id = id;
        this.peaje = peaje;
        this.p1e = p1e;
        this.p2e = p2e;
        this.p3e = p3e;
        this.p4e = p4e;
        this.p5e = p5e;
        this.p6e = p6e;
        this.p1p = p1p;
        this.p2p = p2p;
        this.p3p = p3p;
        this.p4p = p4p;
        this.p5p = p5p;
        this.p6p = p6p;
    }
    //endregion
    //region Getter&Setter
    //Getters y Setters

    /**
     * Devuelve un int para el id de el pricing
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
     * Devuelve un String para el peaje de el pricing
     *
     * @return
     */
    public String getPeaje() {
        return peaje;
    }

    /**
     * Llena el campo peaje mediante un argumento String que se pasa
     *
     * @param peaje este es el argumento que se pasa para rellenar el campo peaje
     */
    public void setPeaje(String peaje) {
        this.peaje = peaje;
    }

    /**
     * Devuelve un double para el importe energia 1
     *
     * @return
     */
    public double getP1e() {
        return p1e;
    }

    /**
     * Llena el campo importe energia 1 mediante un argumento double que se pasa
     *
     * @param p1e este es el argumento que se pasa para rellenar el campo importe energia 1
     */
    public void setP1e(double p1e) {
        this.p1e = p1e;
    }

    /**
     * Devuelve un double para el importe energia 2
     *
     * @return
     */
    public double getP2e() {
        return p2e;
    }

    /**
     * Llena el campo importe energia 2 mediante un argumento double que se pasa
     *
     * @param p2e este es el argumento que se pasa para rellenar el campo importe energia 2
     */
    public void setP2e(double p2e) {
        this.p2e = p2e;
    }

    /**
     * Devuelve un double para el importe energia 3
     *
     * @return
     */
    public double getP3e() {
        return p3e;
    }

    /**
     * Llena el campo importe energia 3 mediante un argumento double que se pasa
     *
     * @param p3e este es el argumento que se pasa para rellenar el campo importe energia 3
     */
    public void setP3e(double p3e) {
        this.p3e = p3e;
    }

    /**
     * Devuelve un double para el importe energia 4
     *
     * @return
     */
    public double getP4e() {
        return p4e;
    }

    /**
     * Llena el campo importe energia 4 mediante un argumento double que se pasa
     *
     * @param p4e este es el argumento que se pasa para rellenar el campo importe energia 4
     */
    public void setP4e(double p4e) {
        this.p4e = p4e;
    }

    /**
     * Devuelve un double para el importe energia 5
     *
     * @return
     */
    public double getP5e() {
        return p5e;
    }

    /**
     * Llena el campo importe energia 5 mediante un argumento double que se pasa
     *
     * @param p5e este es el argumento que se pasa para rellenar el campo importe energia 5
     */
    public void setP5e(double p5e) {
        this.p5e = p5e;
    }

    /**
     * Devuelve un double para el importe energia 6
     *
     * @return
     */
    public double getP6e() {
        return p6e;
    }

    /**
     * Llena el campo importe energia 6 mediante un argumento double que se pasa
     *
     * @param p6e este es el argumento que se pasa para rellenar el campo importe energia 6
     */
    public void setP6e(double p6e) {
        this.p6e = p6e;
    }

    /**
     * Devuelve un double para el importe potencia 1
     *
     * @return
     */
    public double getP1p() {
        return p1p;
    }

    /**
     * Llena el campo importe potencia 1 mediante un argumento double que se pasa
     *
     * @param p1p este es el argumento que se pasa para rellenar el campo importe potencia 1
     */
    public void setP1p(double p1p) {
        this.p1p = p1p;
    }

    /**
     * Devuelve un double para el importe potencia 2
     *
     * @return
     */
    public double getP2p() {
        return p2p;
    }

    /**
     * Llena el campo importe potencia 2 mediante un argumento double que se pasa
     *
     * @param p2p este es el argumento que se pasa para rellenar el campo importe potencia 2
     */
    public void setP2p(double p2p) {
        this.p2p = p2p;
    }

    /**
     * Devuelve un double para el importe potencia 3
     *
     * @return
     */
    public double getP3p() {
        return p3p;
    }

    /**
     * Llena el campo importe potencia 3 mediante un argumento double que se pasa
     *
     * @param p3p este es el argumento que se pasa para rellenar el campo importe potencia 3
     */
    public void setP3p(double p3p) {
        this.p3p = p3p;
    }

    /**
     * Devuelve un double para el importe potencia 4
     *
     * @return
     */
    public double getP4p() {
        return p4p;
    }

    /**
     * Llena el campo importe potencia 4 mediante un argumento double que se pasa
     *
     * @param p4p este es el argumento que se pasa para rellenar el campo importe potencia 4
     */
    public void setP4p(double p4p) {
        this.p4p = p4p;
    }

    /**
     * Devuelve un double para el importe potencia 5
     *
     * @return
     */
    public double getP5p() {
        return p5p;
    }

    /**
     * Llena el campo importe potencia 5 mediante un argumento double que se pasa
     *
     * @param p5p este es el argumento que se pasa para rellenar el campo importe potencia 5
     */
    public void setP5p(double p5p) {
        this.p5p = p5p;
    }

    /**
     * Devuelve un double para el importe potencia 6
     *
     * @return
     */
    public double getP6p() {
        return p6p;
    }

    /**
     * Llena el campo importe potencia 6 mediante un argumento double que se pasa
     *
     * @param p6p este es el argumento que se pasa para rellenar el campo importe potencia 6
     */
    public void setP6p(double p6p) {
        this.p6p = p6p;
    }
    //endregion
    //region toString
    /**
     * Devuelve un String con todos los atributos de la clase Molde Pricing mediate el método toString()
     *
     * @return
     */
    @Override
    public String toString() {
        return "Pricing{" +
                "id=" + id +
                ", peaje='" + peaje + '\'' +
                ", p1e=" + p1e +
                ", p2e=" + p2e +
                ", p3e=" + p3e +
                ", p4e=" + p4e +
                ", p5e=" + p5e +
                ", p6e=" + p6e +
                ", p1p=" + p1p +
                ", p2p=" + p2p +
                ", p3p=" + p3p +
                ", p4p=" + p4p +
                ", p5p=" + p5p +
                ", p6p=" + p6p +
                '}';
    }
    //endregion
}
