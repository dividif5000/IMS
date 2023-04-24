package com.alumno.simulacionims.models;

/**
 * @author David Ruiz Garcia
 * Objeto Molde para hacer uso de los datos de las Simulaciones
 */
public class Simulacion {
    //region Atributos
    //atributos
    private int id;
    private String cliente;
    private String cups;
    private String fecha_inicio;
    private String fecha_final;
    private int dias;
    private String tarifa;
    private String peaje;
    private String oferta;
    private String fee;
    private String precio_potencia;
    private double E1inicio;
    private double E2inicio;
    private double E3inicio;
    private double E4inicio;
    private double E5inicio;
    private double E6inicio;
    private double E1fin;
    private double E2fin;
    private double E3fin;
    private double E4fin;
    private double E5fin;
    private double E6fin;
    private double P1;
    private double P2;
    private double P3;
    private double P4;
    private double P5;
    private double P6;
    private double E1Importe;
    private double E2Importe;
    private double E3Importe;
    private double E4Importe;
    private double E5Importe;
    private double E6Importe;
    private double E1Total;
    private double E2Total;
    private double E3Total;
    private double E4Total;
    private double E5Total;
    private double E6Total;
    private double P1Importe;
    private double P2Importe;
    private double P3Importe;
    private double P4Importe;
    private double P5Importe;
    private double P6Importe;
    private double P1Total;
    private double P2Total;
    private double P3Total;
    private double P4Total;
    private double P5Total;
    private double P6Total;
    private double gestio_iner;
    private double base_imponible;
    private double impuesto;
    private double alquiler_equipo;
    private double iva;
    private double total;
    //endregion
    //region Constructores
    //Constructores

    /**
     * Contructor sin ningun tipo de dato o por defecto
     */
    public Simulacion() {
    }

    /**
     * Este Constructor Contiene todos los atributos declarados anteriormente en privado para el uso del objeto Simulación
     * para usar tanto en Simulación-Luz como en Simulación-Gas
     *
     * @param id              dato tipo int
     * @param cliente         dato tipo String
     * @param cups            dato tipo String
     * @param fecha_inicio    dato tipo String
     * @param fecha_final     dato tipo String
     * @param dias            dato tipo int
     * @param tarifa          dato tipo String
     * @param peaje           dato tipo String
     * @param oferta          dato tipo String
     * @param fee             dato tipo String
     * @param precio_potencia dato tipo String
     * @param e1inicio        dato tipo double
     * @param e2inicio        dato tipo double
     * @param e3inicio        dato tipo double
     * @param e4inicio        dato tipo double
     * @param e5inicio        dato tipo double
     * @param e6inicio        dato tipo double
     * @param e1fin           dato tipo double
     * @param e2fin           dato tipo double
     * @param e3fin           dato tipo double
     * @param e4fin           dato tipo double
     * @param e5fin           dato tipo double
     * @param e6fin           dato tipo double
     * @param p1              dato tipo double
     * @param p2              dato tipo double
     * @param p3              dato tipo double
     * @param p4              dato tipo double
     * @param p5              dato tipo double
     * @param p6              dato tipo double
     * @param e1Importe       dato tipo double
     * @param e2Importe       dato tipo double
     * @param e3Importe       dato tipo double
     * @param e4Importe       dato tipo double
     * @param e5Importe       dato tipo double
     * @param e6Importe       dato tipo double
     * @param e1Total         dato tipo double
     * @param e2Total         dato tipo double
     * @param e3Total         dato tipo double
     * @param e4Total         dato tipo double
     * @param e5Total         dato tipo double
     * @param e6Total         dato tipo double
     * @param p1Importe       dato tipo double
     * @param p2Importe       dato tipo double
     * @param p3Importe       dato tipo double
     * @param p4Importe       dato tipo double
     * @param p5Importe       dato tipo double
     * @param p6Importe       dato tipo double
     * @param p1Total         dato tipo double
     * @param p2Total         dato tipo double
     * @param p3Total         dato tipo double
     * @param p4Total         dato tipo double
     * @param p5Total         dato tipo double
     * @param p6Total         dato tipo double
     * @param gestio_iner     dato tipo double
     * @param base_imponible  dato tipo double
     * @param impuesto        dato tipo double
     * @param alquiler_equipo dato tipo double
     * @param iva             dato tipo double
     * @param total           dato tipo double
     */
    public Simulacion(int id, String cliente, String cups, String fecha_inicio, String fecha_final, int dias, String tarifa, String peaje, String oferta, String fee, String precio_potencia, double e1inicio, double e2inicio, double e3inicio, double e4inicio, double e5inicio, double e6inicio, double e1fin, double e2fin, double e3fin, double e4fin, double e5fin, double e6fin, double p1, double p2, double p3, double p4, double p5, double p6, double e1Importe, double e2Importe, double e3Importe, double e4Importe, double e5Importe, double e6Importe, double e1Total, double e2Total, double e3Total, double e4Total, double e5Total, double e6Total, double p1Importe, double p2Importe, double p3Importe, double p4Importe, double p5Importe, double p6Importe, double p1Total, double p2Total, double p3Total, double p4Total, double p5Total, double p6Total, double gestio_iner, double base_imponible, double impuesto, double alquiler_equipo, double iva, double total) {
        this.id = id;
        this.cliente = cliente;
        this.cups = cups;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.dias = dias;
        this.tarifa = tarifa;
        this.peaje = peaje;
        this.oferta = oferta;
        this.fee = fee;
        this.precio_potencia = precio_potencia;
        E1inicio = e1inicio;
        E2inicio = e2inicio;
        E3inicio = e3inicio;
        E4inicio = e4inicio;
        E5inicio = e5inicio;
        E6inicio = e6inicio;
        E1fin = e1fin;
        E2fin = e2fin;
        E3fin = e3fin;
        E4fin = e4fin;
        E5fin = e5fin;
        E6fin = e6fin;
        P1 = p1;
        P2 = p2;
        P3 = p3;
        P4 = p4;
        P5 = p5;
        P6 = p6;
        E1Importe = e1Importe;
        E2Importe = e2Importe;
        E3Importe = e3Importe;
        E4Importe = e4Importe;
        E5Importe = e5Importe;
        E6Importe = e6Importe;
        E1Total = e1Total;
        E2Total = e2Total;
        E3Total = e3Total;
        E4Total = e4Total;
        E5Total = e5Total;
        E6Total = e6Total;
        P1Importe = p1Importe;
        P2Importe = p2Importe;
        P3Importe = p3Importe;
        P4Importe = p4Importe;
        P5Importe = p5Importe;
        P6Importe = p6Importe;
        P1Total = p1Total;
        P2Total = p2Total;
        P3Total = p3Total;
        P4Total = p4Total;
        P5Total = p5Total;
        P6Total = p6Total;
        this.gestio_iner = gestio_iner;
        this.base_imponible = base_imponible;
        this.impuesto = impuesto;
        this.alquiler_equipo = alquiler_equipo;
        this.iva = iva;
        this.total = total;
    }
    //endregion
    //region Getter&Setter
    //Getters y Setter

    /**
     * Devuelve un int para el id de la simulación
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
     * Devuelve un String para el cliente de la simulación
     *
     * @return
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Llena el campo cliente mediante un argumento String que se pasa
     *
     * @param cliente este es el argumento que se pasa para rellenar el campo cliente
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * Devuelve un String para el cups de la simulación
     *
     * @return
     */
    public String getCups() {
        return cups;
    }

    /**
     * Llena el campo cups mediante yn argumento String que se pasa
     *
     * @param cups este es el argumento que se pasa para rellenar el campo cups
     */
    public void setCups(String cups) {
        this.cups = cups;
    }

    /**
     * Devuelve un String para la fecha de inicio de la simulación
     *
     * @return
     */
    public String getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * LLena el campo fecha de inicio mediante un argumento String que se pasa
     *
     * @param fecha_inicio este es el argumento que se pasa para rellenar el campo fecha de inicio
     */
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    /**
     * Devuelve un String para la decha de fin de la simulación
     *
     * @return
     */
    public String getFecha_final() {
        return fecha_final;
    }

    /**
     * Llena el campo de fecha de fin mediante un argumento String que se pasa
     *
     * @param fecha_final este es el argumento que se pasa para rellenar el campo fecha de fin
     */
    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    /**
     * Devuelve un int para los dias de la simulación
     *
     * @return
     */
    public int getDias() {
        return dias;
    }

    /**
     * Llena el campo de dias mediante un argumento int que se pasa
     *
     * @param dias este es el argumento que se pasa para rellenar el campo dias
     */
    public void setDias(int dias) {
        this.dias = dias;
    }

    /**
     * Devuelve un String para la tarifa de la simulación
     *
     * @return
     */
    public String getTarifa() {
        return tarifa;
    }

    /**
     * LLena el campo de dias mediante un argumento String que se pasa
     *
     * @param tarifa este es el argumento que se pasa para rellenar el campo tarifa
     */
    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * Devuelve un String para el peaje de la simulación
     *
     * @return
     */
    public String getPeaje() {
        return peaje;
    }

    /**
     * LLena el campo de peaje mediante un argumento String que se pasa
     *
     * @param peaje este es el argumento que se pasa para rellenar el campo peaje
     */
    public void setPeaje(String peaje) {
        this.peaje = peaje;
    }

    /**
     * Devuelve un String la oferta de la simulación
     *
     * @return
     */
    public String getOferta() {
        return oferta;
    }

    /**
     * LLena el campo de oferta mediante un argumento String que se pasa
     *
     * @param oferta este es el argumento que se pasa para rellenar el campo oferta
     */
    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    /**
     * Devuelve un String el fee de la simulación
     *
     * @return
     */
    public String getFee() {
        return fee;
    }

    /**
     * Llena el campo de fee mediante un argumento String que se pasa
     *
     * @param fee este es el argumento que se pasa para rellenar el campo fee
     */
    public void setFee(String fee) {
        this.fee = fee;
    }

    /**
     * Devuelve un String para el precio potencia de la simulación
     *
     * @return
     */
    public String getPrecio_potencia() {
        return precio_potencia;
    }

    /**
     * Llena el campo del precio potencia mediante yn argumento String que se pasa
     *
     * @param precio_potencia este es el argumento que se pasa para rellenar el campo precio potencia
     */
    public void setPrecio_potencia(String precio_potencia) {
        this.precio_potencia = precio_potencia;
    }

    /**
     * Devuelve un double para el Consumo del E1 del mes de inicio de la simulación
     *
     * @return
     */
    public double getE1inicio() {
        return E1inicio;
    }

    /**
     * Llena el campo del Consumo del E1 del mes de inicio mediante un argumento double que se pasa
     *
     * @param e1inicio este es el argumento que se pasa para rellenar el campo de Consumo del E1 de mes de inicio
     */
    public void setE1inicio(double e1inicio) {
        this.E1inicio = e1inicio;
    }

    /**
     * Devuelve un double para el Consumo del E2 del mes de inicio de la simulación
     *
     * @return
     */
    public double getE2inicio() {
        return E2inicio;
    }

    /**
     * Llena el campo del Consumo del E2 del mes de inicio mediante un argumento double que se pasa
     *
     * @param e2inicio este es el argumento que se pasa para rellenar el campo de Consumo del E2 del mes de inicio
     */
    public void setE2inicio(double e2inicio) {
        this.E2inicio = e2inicio;
    }

    /**
     * Devuelve un double para el Consumo del E3 del mes de inicio de la simulación
     *
     * @return
     */
    public double getE3inicio() {
        return E3inicio;
    }

    /**
     * Llena el campo del Consumo del E3 del mes de inicio mediante un argumento double que se pasa
     *
     * @param e3inicio este es el argumento que se pasa para rellenar el campo de Consumo del E3 del mes de inicio
     */
    public void setE3inicio(double e3inicio) {
        this.E3inicio = e3inicio;
    }

    /**
     * Devuelve un double para el Consumo del E3 del mes de inicio de la simulación
     *
     * @return
     */
    public double getE4inicio() {
        return E4inicio;
    }

    /**
     * Llena el campo de Consumo del E4 del mes de inicio mediante un argumento double que se pasa
     *
     * @param e4inicio este es el argumento que se pasa para rellanar el campo de Consumo del E4 del mes de inicio
     */
    public void setE4inicio(double e4inicio) {
        this.E4inicio = e4inicio;
    }

    /**
     * Devuelve un double para el Consumo del E5 del mes de inicio de la simulación
     *
     * @return
     */
    public double getE5inicio() {
        return E5inicio;
    }

    /**
     * LLena el campo de Consumo del E5 del mes inicio mediante un argumento double que se pasa
     *
     * @param e5inicio este es el argumento para rellenar el campo de Consumo del E5 del mes de inicio
     */
    public void setE5inicio(double e5inicio) {
        this.E5inicio = e5inicio;
    }

    /**
     * Devuelve un double para el Consumo del E6 del mes de inicio de la simulación
     *
     * @return
     */
    public double getE6inicio() {
        return E6inicio;
    }

    /**
     * LLena el campo del Consumo del E6 del mes inicio mediante un argumento double que se pasa
     *
     * @param e6inicio este es el argumento para rellanar el campo de Consumo del E6 del mes de inicio
     */
    public void setE6inicio(double e6inicio) {
        this.E6inicio = e6inicio;
    }

    /**
     * Devuelve un double para el Consumo del E1 del mes de fin de la simulación
     *
     * @return
     */
    public double getE1fin() {
        return E1fin;
    }

    /**
     * Llena el campo del Consumo del E1 del mes de fin mediante un argumento double que se pasa
     *
     * @param e1fin este es el argumento para rellenar el campo de Consumo del E1 del mes de fin
     */
    public void setE1fin(double e1fin) {
        this.E1fin = e1fin;
    }

    /**
     * Devuelve un double para el Consumo del E2 del mes de fin de la simulación
     *
     * @return
     */
    public double getE2fin() {
        return E2fin;
    }

    /**
     * Llena el campo del Consumo del E2 del mes de fin mediante un argumento double que se pasa
     *
     * @param e2fin este es el argumento para rellenar el campo de Consumo del E2 del mes de fin
     */
    public void setE2fin(double e2fin) {
        this.E2fin = e2fin;
    }

    /**
     * Devuelve un double para el Consumo del E3 del mes de fin de la simulación
     *
     * @return
     */
    public double getE3fin() {
        return E3fin;
    }

    /**
     * LLena el campo de Consumo del E3 del mes de fin mediante un argumento double que se pasa
     *
     * @param e3fin este es el argumento para rellenar el campo del Consumo del E3 del mes de fin
     */
    public void setE3fin(double e3fin) {
        this.E3fin = e3fin;
    }

    /**
     * Devuelve un double para el Consumo del E4 del mes de fin de la simulación
     *
     * @return
     */
    public double getE4fin() {
        return E4fin;
    }

    /**
     * Llena el campo de Consumo del E4 del mes de fin mediante un argumento double que se pasa
     *
     * @param e4fin este es el argumento para rellenar el campo del Consumo del E4 del mes de fin
     */
    public void setE4fin(double e4fin) {
        this.E4fin = e4fin;
    }

    /**
     * Devuelve un double para el Consumo del E5 del mes de fin de la simulación
     *
     * @return
     */
    public double getE5fin() {
        return E5fin;
    }

    /**
     * Llena el cmapo de Consumo del E5 del mes de fin mediante un argumento double que se pasa
     *
     * @param e5fin este es el argumento para rellenar el campo del Consumo del E5 del mes de fin
     */
    public void setE5fin(double e5fin) {
        this.E5fin = e5fin;
    }

    /**
     * Devuelve un double para el Consumo del E6 del mes de fin de la simulación
     *
     * @return
     */
    public double getE6fin() {
        return E6fin;
    }

    /**
     * Llena el campo de Consumo del E6 del mes de fin mediante un argumento double que se pasa
     *
     * @param e6fin este es el argumento para rellenar el campo del Consumo del E6 del mes de fin
     */
    public void setE6fin(double e6fin) {
        this.E6fin = e6fin;
    }

    /**
     * Devuelve un double para la Potencia Real del P1 de la simulación
     *
     * @return
     */
    public double getP1() {
        return P1;
    }

    /**
     * Llena el campo de la Potencia Real del P1 mediante un argumento double que se pasa
     *
     * @param p1 este es el argumento para rellenar el campo de la Potencia Real del P1
     */
    public void setP1(double p1) {
        this.P1 = p1;
    }

    /**
     * Devuelve un double para la Potencia Real del P2 de la simulación
     *
     * @return
     */
    public double getP2() {
        return P2;
    }

    /**
     * Llena el campo de la Potencia Real del P2 mediante un argumento double que se pasa
     *
     * @param p2 este es el argumento para rellenar el campo de la Potencia Real del P2
     */
    public void setP2(double p2) {
        this.P2 = p2;
    }

    /**
     * Devuelve un double para la Potencia Real del P3 de la simulación
     *
     * @return
     */
    public double getP3() {
        return P3;
    }

    /**
     * LLena el campo de la Potencia Real del P3 mediante un argumento double que se pasa
     *
     * @param p3 este es el argumento para rellenar el campo de la Potencia Real del P3
     */
    public void setP3(double p3) {
        this.P3 = p3;
    }

    /**
     * Devuelve un double para la Potencia Real del P4 de la simulación
     *
     * @return
     */
    public double getP4() {
        return P4;
    }

    /**
     * Llena el campo de la Potencia Real del P4 mediante un argumento double que se pasa
     *
     * @param p4 este es el argumento para rellenar el campo de la Potencia Real del P4
     */
    public void setP4(double p4) {
        this.P4 = p4;
    }

    /**
     * Devuelve un double para la Potencia Real del P5 de la simulación
     *
     * @return
     */
    public double getP5() {
        return P5;
    }

    /**
     * Llena el campo de la Potencia Real del P5 mediante un argumento double que se pasa
     *
     * @param p5 este es el argumento para rellenar el campo de la Potencia Real del P5
     */
    public void setP5(double p5) {
        this.P5 = p5;
    }

    /**
     * Devuelve un double para la Potencia real del P6 de la simulación
     *
     * @return
     */
    public double getP6() {
        return P6;
    }

    /**
     * Llena el campo de la Potencia Real del P6 mediante un argumento double que se pasa
     *
     * @param p6 este es el argumento para rellenar el campo de la Potencia Real del P6
     */
    public void setP6(double p6) {
        this.P6 = p6;
    }

    /**
     * Devuelve un double para el Importe del E1 de la simulación
     *
     * @return
     */
    public double getE1Importe() {
        return E1Importe;
    }

    /**
     * Llena el campo del Importe del E1 mediante un argumento double que se pasa
     *
     * @param e1Importe este es el argumento para rellenar el campo del Importe del E1
     */
    public void setE1Importe(double e1Importe) {
        this.E1Importe = e1Importe;
    }

    /**
     * Devuelve un double para el Importe del E2 de la simulación
     *
     * @return
     */
    public double getE2Importe() {
        return E2Importe;
    }

    /**
     * LLena el campo del Importe del E2 mediante un argumento double que se pasa
     *
     * @param e2Importe este es el argumento para rellenar el campo del Importe E2
     */
    public void setE2Importe(double e2Importe) {
        this.E2Importe = e2Importe;
    }

    /**
     * Devuelve un double para el Importe del E3 de la simulación
     *
     * @return
     */
    public double getE3Importe() {
        return E3Importe;
    }

    /**
     * Llena el campo del Importe del E3 mediante un argumente double que se pasa
     *
     * @param e3Importe este es el argumento para rellenar el campo del Importe E3
     */
    public void setE3Importe(double e3Importe) {
        this.E3Importe = e3Importe;
    }

    /**
     * Devuelve un double el Importe del E4 de la simulación
     *
     * @return
     */
    public double getE4Importe() {
        return E4Importe;
    }

    /**
     * Llena el campo del Importe del E4 mediante un argumento double que se pasa
     *
     * @param e4Importe este es el argumento para rellenar el campo del Importe E4
     */
    public void setE4Importe(double e4Importe) {
        this.E4Importe = e4Importe;
    }

    /**
     * Devuelve un double para el Importe del E5 de la simulación
     *
     * @return
     */
    public double getE5Importe() {
        return E5Importe;
    }

    /**
     * Llena el campo del Importe del E5 mediante un argumento double que se pasa
     *
     * @param e5Importe este es el argumento para rellenar el campo del Importe E5
     */
    public void setE5Importe(double e5Importe) {
        this.E5Importe = e5Importe;
    }

    /**
     * Devuelve un double para el Importe del E6 de la simulación
     *
     * @return
     */
    public double getE6Importe() {
        return E6Importe;
    }

    /**
     * Llena el campo del Importe del E6 mediante un argumento double que se pasa
     *
     * @param e6Importe este es el argumento para rellenar el campo del Importe E6
     */
    public void setE6Importe(double e6Importe) {
        this.E6Importe = e6Importe;
    }

    /**
     * Devuelve un double para el Total del E1 de la simulación
     *
     * @return
     */
    public double getE1Total() {
        return E1Total;
    }

    /**
     * Llena el campo del Total del E1 mediante un argumento double que se pasa
     *
     * @param e1Total este es el argumento para rellenar el campo del Total E1
     */
    public void setE1Total(double e1Total) {
        this.E1Total = e1Total;
    }

    /**
     * Devuelve un double para el Total del E2 de la simulación
     *
     * @return
     */
    public double getE2Total() {
        return E2Total;
    }

    /**
     * LLena el campo de Total del E2 mediante un argumento double que se pasa
     *
     * @param e2Total este es el argumento para rellenar el campo del Total E2
     */
    public void setE2Total(double e2Total) {
        this.E2Total = e2Total;
    }

    /**
     * Devuelve un double para el Total del E3 de la simulación
     *
     * @return
     */
    public double getE3Total() {
        return E3Total;
    }

    /**
     * Llena el campo de Total del E3 mediante un argumento double que se pasa
     *
     * @param e3Total este es el argumento para rellenar el campo del Total E3
     */
    public void setE3Total(double e3Total) {
        this.E3Total = e3Total;
    }

    /**
     * Devuelve un double para el Total del E4 de la simulación
     *
     * @return
     */
    public double getE4Total() {
        return E4Total;
    }

    /**
     * Llena el campo del Total del E4 mediante un argumento double que se pasa
     *
     * @param e4Total este es el argumento para rellenar el campo del Total E4
     */
    public void setE4Total(double e4Total) {
        this.E4Total = e4Total;
    }

    /**
     * Devuelve un double para el Total del E5 de la simulación
     *
     * @return
     */
    public double getE5Total() {
        return E5Total;
    }

    /**
     * Llena el campo del Total del E5 mediante un argumento double que se pasa
     *
     * @param e5Total este es el argumento para rellenar el campo del Total E5
     */
    public void setE5Total(double e5Total) {
        this.E5Total = e5Total;
    }

    /**
     * Devuelve un double para el Total del E6 de la simulación
     *
     * @return
     */
    public double getE6Total() {
        return E6Total;
    }

    /**
     * Llena el campo del Total del E6 mediante un argumento double que pasa
     *
     * @param e6Total este es el argumento para rellenar el campo del Total E6
     */
    public void setE6Total(double e6Total) {
        this.E6Total = e6Total;
    }

    /**
     * Devuelve un double para el Importe del P1 de la simulación
     *
     * @return
     */
    public double getP1Importe() {
        return P1Importe;
    }

    /**
     * Llena el campo del Importe del P1 mediante un argumento double que pasa
     *
     * @param p1Importe este es el argumento para rellenar el campo del Importe P1
     */
    public void setP1Importe(double p1Importe) {
        this.P1Importe = p1Importe;
    }

    /**
     * Devuelve un double para el Importe del P2 de la simulación
     *
     * @return
     */
    public double getP2Importe() {
        return P2Importe;
    }

    /**
     * Llena el campo del Importe del P2 mediante un argumento double que pasa
     *
     * @param p2Importe este es el argumento para rellenar el campo del Importe P2
     */
    public void setP2Importe(double p2Importe) {
        this.P2Importe = p2Importe;
    }

    /**
     * Devuelve un double para el Importe del P3 de la simulación
     *
     * @return
     */
    public double getP3Importe() {
        return P3Importe;
    }

    /**
     * Llena el campo del Importe del P3 mediante un argumento double que pasa
     *
     * @param p3Importe este es el argumento para rellenar el campo del Importe P3
     */
    public void setP3Importe(double p3Importe) {
        this.P3Importe = p3Importe;
    }

    /**
     * Devuelve un double para el Importe del P4 de la simulación
     *
     * @return
     */
    public double getP4Importe() {
        return P4Importe;
    }

    /**
     * Llena el campo del Importe del P4 mediante un argumento double que pasa
     *
     * @param p4Importe este es el argumento para rellenar el campo del Importe P4
     */
    public void setP4Importe(double p4Importe) {
        this.P4Importe = p4Importe;
    }

    /**
     * Devuelve un double para el Importe del P5 de la simulación
     *
     * @return
     */
    public double getP5Importe() {
        return P5Importe;
    }

    /**
     * Llena el campo del Importe del P5 mediante un argumento double que pasa
     *
     * @param p5Importe este es el argumento para rellenar el campo del Importe P5
     */
    public void setP5Importe(double p5Importe) {
        this.P5Importe = p5Importe;
    }

    /**
     * Devuelve un double para el Importe del P6 de la simulación
     *
     * @return
     */
    public double getP6Importe() {
        return P6Importe;
    }

    /**
     * Llena el campo del Importe del P6 mediante un argumento double que pasa
     *
     * @param p6Importe este es el argumento para rellenar el campo del Importe P6
     */
    public void setP6Importe(double p6Importe) {
        this.P6Importe = p6Importe;
    }

    /**
     * Devuelve un double para el Total del P1 de la simulación
     *
     * @return
     */
    public double getP1Total() {
        return P1Total;
    }

    /**
     * Llena el campo del Total del P1 mediante un argumento double que pasa
     *
     * @param p1Total este es el argumento para rellenar el campo del Total P1
     */
    public void setP1Total(double p1Total) {
        this.P1Total = p1Total;
    }

    /**
     * Devuelve un double para el Total del P2 de la simulación
     *
     * @return
     */
    public double getP2Total() {
        return P2Total;
    }

    /**
     * Llena el campo del Total del P2 mediante un argumento double que pasa
     *
     * @param p2Total este es el argumento para rellenar el campo del Total P2
     */
    public void setP2Total(double p2Total) {
        this.P2Total = p2Total;
    }

    /**
     * Devuelve un double para el Total del P3 de la simulación
     *
     * @return
     */
    public double getP3Total() {
        return P3Total;
    }

    /**
     * Llena el campo del Total del P3 mediante un argumento double que pasa
     *
     * @param p3Total este es el argumento para rellenar el campo del Total P3
     */
    public void setP3Total(double p3Total) {
        this.P3Total = p3Total;
    }

    /**
     * Devuelve un double para el Total del P4 de la simulación
     *
     * @return
     */
    public double getP4Total() {
        return P4Total;
    }

    /**
     * Llena el campo del Total del P4 mediante un argumento double que pasa
     *
     * @param p4Total este es el argumento para rellenar el campo del Total P4
     */
    public void setP4Total(double p4Total) {
        this.P4Total = p4Total;
    }

    /**
     * Devuelve un double para el Total del P5 de la simulación
     *
     * @return
     */
    public double getP5Total() {
        return P5Total;
    }

    /**
     * Llena el campo del Total del P5 mediante un argumento double que pasa
     *
     * @param p5Total este es el argumento para rellenar el campo del Total P5
     */
    public void setP5Total(double p5Total) {
        this.P5Total = p5Total;
    }

    /**
     * Devuelve un double para el Total del P6 de la simulación
     *
     * @return
     */
    public double getP6Total() {
        return P6Total;
    }

    /**
     * Llena el campo del Total del P6 mediante un argumento double que pasa
     *
     * @param p6Total este es el argumento para rellenar el campo del Total P6
     */
    public void setP6Total(double p6Total) {
        this.P6Total = p6Total;
    }

    /**
     * Devuelve un double para el valor de Gestión Iner este es Específico para las tarifas GESTION INER Y EL GESTION INER INDEXADO
     *
     * @return
     */
    public double getGestio_iner() {
        return gestio_iner;
    }

    /**
     * Llena el campo de Gestión Iner mediante un argumento double que pasa
     *
     * @param gestio_iner este es el argumento para rellenar el campo de Gestión Iner que sera Específico para las tarifas GESTION INER Y GESTION INER INDEXADO
     */
    public void setGestio_iner(double gestio_iner) {
        this.gestio_iner = gestio_iner;
    }

    /**
     * Devuelve un dobule para el valor de la Base Imponible que sería el total de los precios sin aplicar ningun tipo de impuesto
     *
     * @return
     */
    public double getBase_imponible() {
        return base_imponible;
    }

    /**
     * Llena el campo de la Base Imponible mediante un argumento double que pasa
     *
     * @param base_imponible este es el argumento que pasa para rellenar el campo Base Imponible que sería el total de los precios sin aplicar ningun tipo de impuesto
     */
    public void setBase_imponible(double base_imponible) {
        this.base_imponible = base_imponible;
    }

    /**
     * Devuelve un double para el valor de el Impuesto según el tipo de simulacion que sea siendo de Electricidad para la de Luz y de Hidrocarburos para la de Gas
     *
     * @return
     */
    public double getImpuesto() {
        return impuesto;
    }

    /**
     * Llena el campo de el Impuesto mediante un argumento double que pasa
     *
     * @param impuesto este es el argumento que pasa para rellenar el campo Impuesto que según el tipo de simulacion que sea siendo de Electricidad para la de Luz y de Hidrocarburos para la de Gas
     */
    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    /**
     * Devuelve un double para el valor de Alquiler de Equipo que es proporcionada por la distribuidora
     *
     * @return
     */
    public double getAlquiler_equipo() {
        return alquiler_equipo;
    }

    /**
     * Llena el campo de el Alquiler de Equipo mediante un argumento double que pasa
     *
     * @param alquiler_equipo este es el argumento que pasa para rellenar el campo Alquiler de Equipo que es proporcionada por la distribuidora
     */
    public void setAlquiler_equipo(double alquiler_equipo) {
        this.alquiler_equipo = alquiler_equipo;
    }

    /**
     * Devuelve un double para el valor del Iva que se saca de un calculo con la Base Imponible
     *
     * @return
     */
    public double getIva() {
        return iva;
    }

    /**
     * Llena el campo de el Iva mediante un argumento  double que pasa
     *
     * @param iva este es el argumento que pasa para rellenar el campo Iva se saca de un calculo con la Base Imponible
     */
    public void setIva(double iva) {
        this.iva = iva;
    }

    /**
     * Devuelve un double para el valor Total que se saca haciendo la suma de todos los precios anteriores
     *
     * @return
     */
    public double getTotal() {
        return total;
    }

    /**
     * Llena el campo de el Total mediante un argumento double que pasa
     *
     * @param total este es el argumento que pasa para rellenar el campo Total que se saca haciendo la suma de todos los precios anteriores
     */
    public void setTotal(double total) {
        this.total = total;
    }
    //endregion
    //region toString
    /**
     * Devuelve un String con todos los atributos de la clase Molde Simulacion mediate el método toString()
     *
     * @return
     */
    @Override
    public String toString() {
        return "Simulacion{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", cups='" + cups + '\'' +
                ", fecha_inicio='" + fecha_inicio + '\'' +
                ", fecha_final='" + fecha_final + '\'' +
                ", dias=" + dias +
                ", tarifa='" + tarifa + '\'' +
                ", peaje='" + peaje + '\'' +
                ", oferta='" + oferta + '\'' +
                ", fee='" + fee + '\'' +
                ", precio_potencia='" + precio_potencia + '\'' +
                ", E1inicio=" + E1inicio +
                ", E2inicio=" + E2inicio +
                ", E3inicio=" + E3inicio +
                ", E4inicio=" + E4inicio +
                ", E5inicio=" + E5inicio +
                ", E6inicio=" + E6inicio +
                ", E1fin=" + E1fin +
                ", E2fin=" + E2fin +
                ", E3fin=" + E3fin +
                ", E4fin=" + E4fin +
                ", E5fin=" + E5fin +
                ", E6fin=" + E6fin +
                ", P1=" + P1 +
                ", P2=" + P2 +
                ", P3=" + P3 +
                ", P4=" + P4 +
                ", P5=" + P5 +
                ", P6=" + P6 +
                ", E1Importe=" + E1Importe +
                ", E2Importe=" + E2Importe +
                ", E3Importe=" + E3Importe +
                ", E4Importe=" + E4Importe +
                ", E5Importe=" + E5Importe +
                ", E6Importe=" + E6Importe +
                ", E1Total=" + E1Total +
                ", E2Total=" + E2Total +
                ", E3Total=" + E3Total +
                ", E4Total=" + E4Total +
                ", E5Total=" + E5Total +
                ", E6Total=" + E6Total +
                ", P1Importe=" + P1Importe +
                ", P2Importe=" + P2Importe +
                ", P3Importe=" + P3Importe +
                ", P4Importe=" + P4Importe +
                ", P5Importe=" + P5Importe +
                ", P6Importe=" + P6Importe +
                ", P1Total=" + P1Total +
                ", P2Total=" + P2Total +
                ", P3Total=" + P3Total +
                ", P4Total=" + P4Total +
                ", P5Total=" + P5Total +
                ", P6Total=" + P6Total +
                ", gestio_iner=" + gestio_iner +
                ", base_imponible=" + base_imponible +
                ", impuesto=" + impuesto +
                ", alquiler_equipo=" + alquiler_equipo +
                ", iva=" + iva +
                ", total=" + total +
                '}';
    }
    //endregion
}
