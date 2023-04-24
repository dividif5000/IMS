package com.alumno.simulacionims.models;

/**
 * @author David Ruiz Garcia
 * Objeto Molde para hacer uso de los datos de los CodigosPrecio
 * Estos datos son recogidos mediate una conexión a un servidor externo
 */
public class CodigosPrecio {
    //region Atributos
    //Atributos

    /**
     * Atributo tipo int el cual recoge el id
     */
    public int id;

    /**
     * Atributo tipo String el cual recoge el codigo
     */
    public String codigo;

    /**
     * Atributo tipo String el cual recoge el fee
     */
    public String feecuota;

    /**
     * Atributo tipo String el cual recoge el precio potencia
     */
    public String prpotencia;

    /**
     * Atributo tipo String el cual recoge tipo de fijo index
     */
    public String fijoindex;

    /**
     * Atributo tipo String el cual recoge la tarifa
     */
    public String tarifa;

    /**
     * Atributo tipo String el cual recoge el peaje
     */
    public String peaje;

    /**
     * Atributo tipo String el cual recoge el detalle
     */
    public String detalle;

    /**
     * Atributo tipo String el cual recoge el suministro
     */
    public String suministro;

    /**
     * Atributo tipo String el cual recoge el codigo invisible
     */
    public String codigovisible;

    /**
     * Atributo tipo double el cual recoge la comision
     */
    public double comision;
    //endregion
    //region Constructores
    //Constructores

    /**
     * Constructor sin ningun tipo de dato o por defecto
     */
    public CodigosPrecio() {
    }

    /**
     * Este constructor contiene todos los atributos es decir este constructor es el mas completo de todos
     * @param id dato tipo int
     * @param codigo dato tipo String
     * @param feecuota dato tipo String
     * @param prpotencia dato tipo String
     * @param fijoindex dato tipo String
     * @param tarifa dato tipo String
     * @param peaje dato tipo String
     * @param detalle dato tipo String
     * @param suministro dato tipo String
     * @param codigovisible dato tipo String
     * @param comision dato tipo double
     */
    public CodigosPrecio(int id, String codigo, String feecuota, String prpotencia, String fijoindex, String tarifa, String peaje, String detalle, String suministro, String codigovisible, double comision) {
        this.id = id;
        this.codigo = codigo;
        this.feecuota = feecuota;
        this.prpotencia = prpotencia;
        this.fijoindex = fijoindex;
        this.tarifa = tarifa;
        this.peaje = peaje;
        this.detalle = detalle;
        this.suministro = suministro;
        this.codigovisible = codigovisible;
        this.comision = comision;
    }
    //endregion
    //region Getter&Setter
    //Getters y Setters

    /**
     * Devuelve un int para el id de los codigos precio
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Llena el campo id mediante un argumento int que se pasa
     * @param id este es el argumento que se pasa para rellenar el campo id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve un String para el codigo de los codigos precio
     * @return
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *Llena el campo codigo mediante un argumento String que se pasa
     * @param codigo este es el argumento que se pasa para rellenar el campo codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve un String para el fee de los codigos precio
     * @return
     */
    public String getFeecuota() {
        return feecuota;
    }

    /**
     * Llena el campo feecuota mediante un argumento String que se pasa
     * @param feecuota este es el argumento que se pasa para rellenar el campo feecuota
     */
    public void setFeecuota(String feecuota) {
        this.feecuota = feecuota;
    }

    /**
     * Devuelve un String para el precio potencia de los codigos precio
     * @return
     */
    public String getPrpotencia() {
        return prpotencia;
    }

    /**
     * Llena el campo precio potencia mediante un argumento String que se pasa
     * @param prpotencia este es el argumento que se pasa para rellenar el campo precio potencia
     */
    public void setPrpotencia(String prpotencia) {
        this.prpotencia = prpotencia;
    }

    /**
     * Devuelve un String para el fijo index de los codigos precio
     * @return
     */
    public String getFijoindex() {
        return fijoindex;
    }

    /**
     * Llena el campo fijo index mediante un argumento String que se pasa
     * @param fijoindex este es el argumento que se pasa para rellenar el campo fijo index
     */
    public void setFijoindex(String fijoindex) {
        this.fijoindex = fijoindex;
    }

    /**
     * Devuelve un String para la tarifa de los codigos precio
     * @return
     */
    public String getTarifa() {
        return tarifa;
    }

    /**
     * Llena el campo tarifa mediante un argumento String que se pasa
     * @param tarifa este es el argumento que se pasa para rellenar el campo tarifa
     */
    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * Devuelve un String para el peaje de los codigos precio
     * @return
     */
    public String getPeaje() {
        return peaje;
    }

    /**
     * Llena el campo peaje mediante un argumento String que se pasa
     * @param peaje este es el argumento que se pasa para rellenar el campo peaje
     */
    public void setPeaje(String peaje) {
        this.peaje = peaje;
    }

    /**
     * Devuelve un String para el detalle de los codigos precio
     * @return
     */
    public String getDetalle() {
        return detalle;
    }

    /**
     * Llena el campo detalle mediante un argumento String que se pasa
     * @param detalle este es el argumento que se pasa para rellenar el campo detalle
     */
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    /**
     * Devuelve un String para el suministro de los codigos precio
     * @return
     */
    public String getSuministro() {
        return suministro;
    }

    /**
     * Llena el campo suministro mediante un argumento String que se pasa
     * @param suministro este es el argumento que se pasa para rellenar el campo suministro
     */
    public void setSuministro(String suministro) {
        this.suministro = suministro;
    }

    /**
     * Devuelve un String para el codigo visible de los codigos precio
     * @return
     */
    public String getCodigovisible() {
        return codigovisible;
    }

    /**
     * Llena el campo codigo visible mediante un argumento String que se pasa
     * @param codigovisible este es el argumento que se pasa para rellenar el campo codigo visible
     */
    public void setCodigovisible(String codigovisible) {
        this.codigovisible = codigovisible;
    }

    /**
     * Devuelve un double para la comision de los codigos precio
     * @return
     */
    public double getComision() {
        return comision;
    }

    /**
     * Llena el campo comision mediante un argumento String que se pasa
     * @param comision este es el argumento que se pasa para rellenar el campo comision
     */
    public void setComision(double comision) {
        this.comision = comision;
    }
    //endregion
    //region toString
    /**
     * Devuelve un String con todos los atributos de la clase Molde CodigosPrecio mediate el método toString()
     * @return
     */
    @Override
    public String toString() {
        return "CodigosPrecio{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", feecuota='" + feecuota + '\'' +
                ", prpotencia='" + prpotencia + '\'' +
                ", fijoindex='" + fijoindex + '\'' +
                ", tarifa='" + tarifa + '\'' +
                ", peaje='" + peaje + '\'' +
                ", detalle='" + detalle + '\'' +
                ", suministro='" + suministro + '\'' +
                ", codigovisible='" + codigovisible + '\'' +
                ", comision=" + comision +
                '}';
    }
    //endregion
}
