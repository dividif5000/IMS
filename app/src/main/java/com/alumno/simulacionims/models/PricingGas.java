package com.alumno.simulacionims.models;

/**
 * @author David Ruiz Garcia
 * Objeto Molde para hacer uso de los datos de los PricingGas
 * Estos datos son recogidos mediate una conexión a un servidor externo
 */
public class PricingGas {
    //region Atributos
    //Atributos
    private int id;
    private String peaje;
    private double termino_fijo;
    private double termino_variable;
    private String tarifa;
    //endregion
    //region Constructores
    //Constructor

    /**
     * Constructor sin ningun tipo de dato o por defecto
     */
    public PricingGas() {
    }

    /**
     * Este constructor contiene todos los atributos es decir este constructor es el mas completo de todos
     *
     * @param id               dato tipo int
     * @param peaje            dato tipo String
     * @param termino_fijo     dato tipo double
     * @param termino_variable dato tipo double
     * @param tarifa           dato tipo String
     */
    public PricingGas(int id, String peaje, double termino_fijo, double termino_variable, String tarifa) {
        this.id = id;
        this.peaje = peaje;
        this.termino_fijo = termino_fijo;
        this.termino_variable = termino_variable;
        this.tarifa = tarifa;
    }
    //endregion
    //region Getter&Setter
    //Getters y Setters

    /**
     * Devuelve un int para el id del pricinggas
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
     * Devuelve un String para el peaje del pricinggas
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
     * Devuelve un double para el termino fijo del pricinggas
     *
     * @return
     */
    public double getTermino_fijo() {
        return termino_fijo;
    }

    /**
     * Llena el campo termino fijo mediante un argumento double que se pasa
     *
     * @param termino_fijo este es el argumento que se pasa para rellenar el campo termino fijo
     */
    public void setTermino_fijo(double termino_fijo) {
        this.termino_fijo = termino_fijo;
    }

    /**
     * Devuelve un double para el termino variable del pricinggas
     *
     * @return
     */
    public double getTermino_variable() {
        return termino_variable;
    }

    /**
     * Llena el campo termino fijo mediante un argumento double que se pasa
     *
     * @param termino_variable este es el argumento que se pasa para rellenar el campo termino variable
     */
    public void setTermino_variable(double termino_variable) {
        this.termino_variable = termino_variable;
    }

    /**
     * Devuelve un String para la tarifa del pricinggas
     *
     * @return
     */
    public String getTarifa() {
        return tarifa;
    }

    /**
     * Llena el campo tarifa mediante un argumento double que se pasa
     *
     * @param tarifa este es el argumento que se pasa para rellenar el campo tarifa
     */
    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }
    //endregion
    //region toString
    /**
     * Devuelve un String con todos los atributos de la clase Molde PricingGas mediate el método toString()
     *
     * @return
     */
    @Override
    public String toString() {
        return "PricingGas{" +
                "id=" + id +
                ", peaje='" + peaje + '\'' +
                ", termino_fijo=" + termino_fijo +
                ", termino_variable=" + termino_variable +
                ", tarifa='" + tarifa + '\'' +
                '}';
    }
    //endregion
}
