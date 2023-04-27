package com.alumno.simulacionims.models;

/**
 * @author David Ruiz Garcia
 * Objeto Model para hacer uso de los datos de los Contratos
 */
public class Contrato {
    //region Atributos
    private int id;
    //Datos del Cliente
    private String pymeCli;
    private String tipoContratoCli;
    private boolean permaneciaCli;
    private String tarifaCli;
    private String peajeCli;
    private String codigoTarifaCli;
    private String titularCli;
    private String apellidosCli;
    private String telefono1Cli;
    private String telefono2Cli;
    private String emailCli;
    private String direccionCli;
    private String numeroDireCli;
    private String pisoDireCli;
    private String puertaDireCli;
    private String localidadCli;
    private String provinciaCli;
    private String CPCli;
    private String representanteCli;
    private String NIFRepresentanteCli;
    //Datos del punto de suministro
    private String direccionSumi;
    private String numeroDireSumi;
    private String pisoDireSumi;
    private String puertaDireSumi;
    private String localidadSumi;
    private String provinciaSumi;
    private String CPSumi;
    private String distribuidoraSumi;
    private String CUPSSumi;
    private String CNAESumi;
    private double ConsumoAnualSumi;
    //Datos de contacto para notificaciones
    private String direccionCon;
    private String numeroDireCon;
    private String pisoDireCon;
    private String puertaDireCon;
    private String localidadCon;
    private String provinciaCon;
    private String CPCon;
    //Producto contratación
    private double p1Con;
    private double p2Con;
    private double p3Con;
    private double p4Con;
    private double p5Con;
    private double p6Con;
    //Servicios
    private boolean garantiaDeOrigen;
    private String fechaInicioContrato;
    private String duracionContrato;
    //Datos Bancarios
    private String nifCifNieBan;
    private String nombreBan;
    private String IBAN;
    //endregion
    //region Constructores
    /**
     * Contructor sin ningun tipo de dato o por defecto
     */
    public Contrato() {
    }

    /**
     * Este Constructor Contiene todos los atributos declarados anteriormente en privado para el uso del objeto Contrato
     * para usar tanto en Contrato-Luz como en Contrato-Gas
     *
     * @param id
     * @param pymeCli
     * @param tipoContratoCli
     * @param permaneciaCli
     * @param tarifaCli
     * @param peajeCli
     * @param codigoTarifaCli
     * @param titularCli
     * @param apellidosCli
     * @param telefono1Cli
     * @param telefono2Cli
     * @param emailCli
     * @param direccionCli
     * @param numeroDireCli
     * @param pisoDireCli
     * @param puertaDireCli
     * @param localidadCli
     * @param provinciaCli
     * @param CPCli
     * @param representanteCli
     * @param NIFRepresentanteCli
     * @param direccionSumi
     * @param numeroDireSumi
     * @param pisoDireSumi
     * @param puertaDireSumi
     * @param localidadSumi
     * @param provinciaSumi
     * @param CPSumi
     * @param distribuidoraSumi
     * @param CUPSSumi
     * @param CNAESumi
     * @param consumoAnualSumi
     * @param direccionCon
     * @param numeroDireCon
     * @param pisoDireCon
     * @param puertaDireCon
     * @param localidadCon
     * @param provinciaCon
     * @param CPCon
     * @param p1Con
     * @param p2Con
     * @param p3Con
     * @param p4Con
     * @param p5Con
     * @param p6Con
     * @param garantiaDeOrigen
     * @param fechaInicioContrato
     * @param duracionContrato
     * @param nifCifNieBan
     * @param nombreBan
     * @param IBAN
     */
    public Contrato(int id,String pymeCli, String tipoContratoCli, boolean permaneciaCli, String tarifaCli, String peajeCli, String codigoTarifaCli, String titularCli, String apellidosCli, String telefono1Cli, String telefono2Cli, String emailCli, String direccionCli, String numeroDireCli, String pisoDireCli, String puertaDireCli, String localidadCli, String provinciaCli, String CPCli, String representanteCli, String NIFRepresentanteCli, String direccionSumi, String numeroDireSumi, String pisoDireSumi, String puertaDireSumi, String localidadSumi, String provinciaSumi, String CPSumi, String distribuidoraSumi, String CUPSSumi, String CNAESumi, double consumoAnualSumi, String direccionCon, String numeroDireCon, String pisoDireCon, String puertaDireCon, String localidadCon, String provinciaCon, String CPCon, double p1Con, double p2Con, double p3Con, double p4Con, double p5Con, double p6Con, boolean garantiaDeOrigen, String fechaInicioContrato, String duracionContrato, String nifCifNieBan, String nombreBan, String IBAN) {
        this.id = id;
        this.pymeCli = pymeCli;
        this.tipoContratoCli = tipoContratoCli;
        this.permaneciaCli = permaneciaCli;
        this.tarifaCli = tarifaCli;
        this.peajeCli = peajeCli;
        this.codigoTarifaCli = codigoTarifaCli;
        this.titularCli = titularCli;
        this.apellidosCli = apellidosCli;
        this.telefono1Cli = telefono1Cli;
        this.telefono2Cli = telefono2Cli;
        this.emailCli = emailCli;
        this.direccionCli = direccionCli;
        this.numeroDireCli = numeroDireCli;
        this.pisoDireCli = pisoDireCli;
        this.puertaDireCli = puertaDireCli;
        this.localidadCli = localidadCli;
        this.provinciaCli = provinciaCli;
        this.CPCli = CPCli;
        this.representanteCli = representanteCli;
        this.NIFRepresentanteCli = NIFRepresentanteCli;
        this.direccionSumi = direccionSumi;
        this.numeroDireSumi = numeroDireSumi;
        this.pisoDireSumi = pisoDireSumi;
        this.puertaDireSumi = puertaDireSumi;
        this.localidadSumi = localidadSumi;
        this.provinciaSumi = provinciaSumi;
        this.CPSumi = CPSumi;
        this.distribuidoraSumi = distribuidoraSumi;
        this.CUPSSumi = CUPSSumi;
        this.CNAESumi = CNAESumi;
        ConsumoAnualSumi = consumoAnualSumi;
        this.direccionCon = direccionCon;
        this.numeroDireCon = numeroDireCon;
        this.pisoDireCon = pisoDireCon;
        this.puertaDireCon = puertaDireCon;
        this.localidadCon = localidadCon;
        this.provinciaCon = provinciaCon;
        this.CPCon = CPCon;
        this.p1Con = p1Con;
        this.p2Con = p2Con;
        this.p3Con = p3Con;
        this.p4Con = p4Con;
        this.p5Con = p5Con;
        this.p6Con = p6Con;
        this.garantiaDeOrigen = garantiaDeOrigen;
        this.fechaInicioContrato = fechaInicioContrato;
        this.duracionContrato = duracionContrato;
        this.nifCifNieBan = nifCifNieBan;
        this.nombreBan = nombreBan;
        this.IBAN = IBAN;
    }
    //endregion
    //region Getter&Setter

    /**
     * Devuelve un int para el id del contrato
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
     * Devuelve un String para el pyme del cliente del contrato
     * @return
     */
    public String getPymeCli() {
        return pymeCli;
    }

    /**
     * Llena el campo pymeCli mediante un argumento String que se pasa
     * @param pymeCli este es el argumento que se pasa para rellenar el campo pymeCli
     */
    public void setPymeCli(String pymeCli) {
        this.pymeCli = pymeCli;
    }

    /**
     * Devuelve un String para el tipo de contrato del cliente del contrato
     * @return
     */
    public String getTipoContratoCli() {
        return tipoContratoCli;
    }

    /**
     * Llena el campo tipoContratoCli mediante un argumento String que se pasa
     * @param tipoContratoCli este es el argumento que se pasa para rellenar el campo tipoContratoCli
     */
    public void setTipoContratoCli(String tipoContratoCli) {
        this.tipoContratoCli = tipoContratoCli;
    }

    /**
     * Devuelve un boolean para la permanecia del cliente del contrato
     * @return
     */
    public boolean isPermaneciaCli() {
        return permaneciaCli;
    }

    /**
     * Llena el campo permanenciaCli mediante un argumento boolean que se pasa
     * @param permaneciaCli este es el argumento que se pasa para rellenar el campo permanenciaCli
     */
    public void setPermaneciaCli(boolean permaneciaCli) {
        this.permaneciaCli = permaneciaCli;
    }

    /**
     * Devuelve un String para la tarifa del cliente del contrato
     * @return
     */
    public String getTarifaCli() {
        return tarifaCli;
    }

    /**
     * Llena el campo tarifaCli mediante un argumento String que se pasa
     * @param tarifaCli este es el argumento que se pasa para rellenar el campo tarifaCli
     */
    public void setTarifaCli(String tarifaCli) {
        this.tarifaCli = tarifaCli;
    }

    /**
     * Devuelve un String para la tarifa del cliente del contrato
     * @return
     */
    public String getPeajeCli() {
        return peajeCli;
    }

    /**
     * Llena el campo tarifaCli mediante un argumento String que se pasa
     * @param peajeCli este es el argumento que se pasa para rellenar el campo tarifaCli
     */
    public void setPeajeCli(String peajeCli) {
        this.peajeCli = peajeCli;
    }

    /**
     * Devuelve un String para el codigo de tarifa del cliente del contrato
     * @return
     */
    public String getCodigoTarifaCli() {
        return codigoTarifaCli;
    }

    /**
     * Llena el campo codigoTarifaCli mediante un argumento String que se pasa
     * @param codigoTarifaCli este es el argumento que se pasa para rellenar el campo codigoTarifaCli
     */
    public void setCodigoTarifaCli(String codigoTarifaCli) {
        this.codigoTarifaCli = codigoTarifaCli;
    }

    /**
     * Devuelve un String para el titular/cliente del contrato
     * @return
     */
    public String getTitularCli() {
        return titularCli;
    }

    /**
     * Llena el campo titularCli mediante un argumento String que se pasa
     * @param titularCli este es el argumento que se pasa para rellenar el campo titularCli
     */
    public void setTitularCli(String titularCli) {
        this.titularCli = titularCli;
    }

    /**
     * Devuelve un String para el apellidos del cliente del contrato
     * @return
     */
    public String getApellidosCli() {
        return apellidosCli;
    }

    /**
     * Llena el campo apellidosCli mediante un argumento String que se pasa
     * @param apellidosCli este es el argumento que se pasa para rellenar el campo titularCli
     */
    public void setApellidosCli(String apellidosCli) {
        this.apellidosCli = apellidosCli;
    }

    /**
     * Devuelve un String para el primer télefono del cliente del contrato
     * @return
     */
    public String getTelefono1Cli() {
        return telefono1Cli;
    }

    /**
     * Llena el campo telefono1Cli mediante un argumento String que se pasa
     * @param telefono1Cli este es el argumento que se pasa para rellenar el campo telefono1Cli
     */
    public void setTelefono1Cli(String telefono1Cli) {
        this.telefono1Cli = telefono1Cli;
    }

    /**
     * Devuelve un String para el segundo télefono del cliente del contrato
     * @return
     */
    public String getTelefono2Cli() {
        return telefono2Cli;
    }

    /**
     * Llena el campo telefono2Cli mediante un argumento String que se pasa
     * @param telefono2Cli este es el argumento que se pasa para rellenar el campo telefono2Cli
     */
    public void setTelefono2Cli(String telefono2Cli) {
        this.telefono2Cli = telefono2Cli;
    }

    /**
     * Devuelve un String para el email del cliente del contrato
     * @return
     */
    public String getEmailCli() {
        return emailCli;
    }

    /**
     * Llena el campo emailCli mediante un argumento String que se pasa
     * @param emailCli este es el argumento que se pasa para rellenar el campo emailCli
     */
    public void setEmailCli(String emailCli) {
        this.emailCli = emailCli;
    }

    /**
     * Devuelve un String para la dirección del cliente del contrato
     * @return
     */
    public String getDireccionCli() {
        return direccionCli;
    }

    /**
     * Llena el campo direccionCli mediante un argumento String que se pasa
     * @param direccionCli este es el argumento que se pasa para rellenar el campo direccionCli
     */
    public void setDireccionCli(String direccionCli) {
        this.direccionCli = direccionCli;
    }

    /**
     * Devuelve un String para la número de portal del cliente del contrato
     * @return
     */
    public String getNumeroDireCli() {
        return numeroDireCli;
    }

    /**
     * Llena el campo numeroDireCli mediante un argumento String que se pasa
     * @param numeroDireCli este es el argumento que se pasa para rellenar el campo numeroDireCli
     */
    public void setNumeroDireCli(String numeroDireCli) {
        this.numeroDireCli = numeroDireCli;
    }

    /**
     * Devuelve un String para la piso del cliente del contrato
     * @return
     */
    public String getPisoDireCli() {
        return pisoDireCli;
    }

    /**
     * Llena el campo pisoDireCli mediante un argumento String que se pasa
     * @param pisoDireCli este es el argumento que se pasa para rellenar el campo pisoDireCli
     */
    public void setPisoDireCli(String pisoDireCli) {
        this.pisoDireCli = pisoDireCli;
    }

    /**
     * Devuelve un String para la piso del cliente del contrato
     * @return
     */
    public String getPuertaDireCli() {
        return puertaDireCli;
    }

    /**
     * Llena el campo pisoDireCli mediante un argumento String que se pasa
     * @param puertaDireCli este es el argumento que se pasa para rellenar el campo pisoDireCli
     */
    public void setPuertaDireCli(String puertaDireCli) {
        this.puertaDireCli = puertaDireCli;
    }

    /**
     * Devuelve un String para la localidad del cliente del contrato
     * @return
     */
    public String getLocalidadCli() {
        return localidadCli;
    }

    /**
     * Llena el campo localidadCli mediante un argumento String que se pasa
     * @param localidadCli este es el argumento que se pasa para rellenar el campo localidadCli
     */
    public void setLocalidadCli(String localidadCli) {
        this.localidadCli = localidadCli;
    }

    /**
     * Devuelve un String para la provincia del cliente del contrato
     * @return
     */
    public String getProvinciaCli() {
        return provinciaCli;
    }

    /**
     * Llena el campo provinciaCli mediante un argumento String que se pasa
     * @param provinciaCli este es el argumento que se pasa para rellenar el campo provinciaCli
     */
    public void setProvinciaCli(String provinciaCli) {
        this.provinciaCli = provinciaCli;
    }

    /**
     * Devuelve un String para el codigo postal del cliente del contrato
     * @return
     */
    public String getCPCli() {
        return CPCli;
    }

    /**
     * Llena el campo CPCli mediante un argumento String que se pasa
     * @param CPCli este es el argumento que se pasa para rellenar el campo CPCli
     */
    public void setCPCli(String CPCli) {
        this.CPCli = CPCli;
    }

    /**
     * Devuelve un String para el representate del cliente del contrato
     * @return
     */
    public String getRepresentanteCli() {
        return representanteCli;
    }

    /**
     * Llena el campo respresentanteCli mediante un argumento String que se pasa
     * @param representanteCli este es el argumento que se pasa para rellenar el campo respresentanteCli
     */
    public void setRepresentanteCli(String representanteCli) {
        this.representanteCli = representanteCli;
    }

    /**
     * Devuelve un String para el NIF del representate del cliente del contrato
     * @return
     */
    public String getNIFRepresentanteCli() {
        return NIFRepresentanteCli;
    }

    /**
     * Llena el campo NIFrespresentanteCli mediante un argumento String que se pasa
     * @param NIFRepresentanteCli este es el argumento que se pasa para rellenar el campo NIFrespresentanteCli
     */
    public void setNIFRepresentanteCli(String NIFRepresentanteCli) {
        this.NIFRepresentanteCli = NIFRepresentanteCli;
    }

    /**
     * Devuelve un String para la dirección del punto de suministro del contrato
     * @return
     */
    public String getDireccionSumi() {
        return direccionSumi;
    }

    /**
     * Llena el campo direccionSumi mediante un argumento String que se pasa
     * @param direccionSumi este es el argumento que se pasa para rellenar el campo direccionSumi
     */
    public void setDireccionSumi(String direccionSumi) {
        this.direccionSumi = direccionSumi;
    }

    /**
     * Devuelve un String para el numero del portal del punto de suministro del contrato
     * @return
     */
    public String getNumeroDireSumi() {
        return numeroDireSumi;
    }

    /**
     * Llena el campo numeroDireSumi mediante un argumento String que se pasa
     * @param numeroDireSumi este es el argumento que se pasa para rellenar el campo numeroDireSumi
     */
    public void setNumeroDireSumi(String numeroDireSumi) {
        this.numeroDireSumi = numeroDireSumi;
    }

    /**
     * Devuelve un String para el piso del punto de suministro del contrato
     * @return
     */
    public String getPisoDireSumi() {
        return pisoDireSumi;
    }

    /**
     * Llena el campo pisoDireSumi mediante un argumento String que se pasa
     * @param pisoDireSumi este es el argumento que se pasa para rellenar el campo pisoDireSumi
     */
    public void setPisoDireSumi(String pisoDireSumi) {
        this.pisoDireSumi = pisoDireSumi;
    }

    /**
     * Devuelve un String para el piso del punto de suministro del contrato
     * @return
     */
    public String getPuertaDireSumi() {
        return puertaDireSumi;
    }

    /**
     * Llena el campo puertaDireSumi mediante un argumento String que se pasa
     * @param puertaDireSumi este es el argumento que se pasa para rellenar el campo puertaDireSumi
     */
    public void setPuertaDireSumi(String puertaDireSumi) {
        this.puertaDireSumi = puertaDireSumi;
    }

    /**
     * Devuelve un String para la localidad del punto de suministro del contrato
     * @return
     */
    public String getLocalidadSumi() {
        return localidadSumi;
    }

    /**
     * Llena el campo localidadSumi mediante un argumento String que se pasa
     * @param localidadSumi este es el argumento que se pasa para rellenar el campo localidadSumi
     */
    public void setLocalidadSumi(String localidadSumi) {
        this.localidadSumi = localidadSumi;
    }

    /**
     * Devuelve un String para la provincia del punto de suministro del contrato
     * @return
     */
    public String getProvinciaSumi() {
        return provinciaSumi;
    }

    /**
     * Llena el campo provinciaSumi mediante un argumento String que se pasa
     * @param provinciaSumi este es el argumento que se pasa para rellenar el campo provinciaSumi
     */
    public void setProvinciaSumi(String provinciaSumi) {
        this.provinciaSumi = provinciaSumi;
    }

    /**
     * Devuelve un String para el codigo postal del punto de suministro del contrato
     * @return
     */
    public String getCPSumi() {
        return CPSumi;
    }

    /**
     * Llena el campo CPSumi mediante un argumento String que se pasa
     * @param CPSumi este es el argumento que se pasa para rellenar el campo CPSumi
     */
    public void setCPSumi(String CPSumi) {
        this.CPSumi = CPSumi;
    }

    /**
     * Devuelve un String para la distribuidora del punto de suministro del contrato
     * @return
     */
    public String getDistribuidoraSumi() {
        return distribuidoraSumi;
    }

    /**
     * Llena el campo distribuidoraSumi mediante un argumento String que se pasa
     * @param distribuidoraSumi este es el argumento que se pasa para rellenar el campo distribuidoraSumi
     */
    public void setDistribuidoraSumi(String distribuidoraSumi) {
        this.distribuidoraSumi = distribuidoraSumi;
    }

    /**
     * Devuelve un String para el CUPS del punto de suministro del contrato
     * @return
     */
    public String getCUPSSumi() {
        return CUPSSumi;
    }

    /**
     * Llena el campo CUPSSumi mediante un argumento String que se pasa
     * @param CUPSSumi este es el argumento que se pasa para rellenar el campo CUPSSumi
     */
    public void setCUPSSumi(String CUPSSumi) {
        this.CUPSSumi = CUPSSumi;
    }

    /**
     * Devuelve un String para el CNAE del punto de suministro del contrato
     * @return
     */
    public String getCNAESumi() {
        return CNAESumi;
    }

    /**
     * Llena el campo CNAESumi mediante un argumento String que se pasa
     * @param CNAESumi este es el argumento que se pasa para rellenar el campo CNAESumi
     */
    public void setCNAESumi(String CNAESumi) {
        this.CNAESumi = CNAESumi;
    }

    /**
     * Devuelve un double para el cosumoAnual del punto de suministro del contrato
     * @return
     */
    public double getConsumoAnualSumi() {
        return ConsumoAnualSumi;
    }

    /**
     * Llena el campo consumoAnualSumi mediante un argumento double que se pasa
     * @param consumoAnualSumi este es el argumento que se pasa para rellenar el campo consumoAnualSumi
     */
    public void setConsumoAnualSumi(double consumoAnualSumi) {
        ConsumoAnualSumi = consumoAnualSumi;
    }

    /**
     * Devuelve un String para la direccion del contacto de notificaciones del contrato
     * @return
     */
    public String getDireccionCon() {
        return direccionCon;
    }

    /**
     * Llena el campo direccionCon mediante un argumento String que se pasa
     * @param direccionCon este es el argumento que se pasa para rellenar el campo direccionCon
     */
    public void setDireccionCon(String direccionCon) {
        this.direccionCon = direccionCon;
    }

    /**
     * Devuelve un String para el numero del portal del contacto de notificaciones del contrato
     * @return
     */
    public String getNumeroDireCon() {
        return numeroDireCon;
    }

    /**
     * Llena el campo numeroDireCon mediante un argumento String que se pasa
     * @param numeroDireCon este es el argumento que se pasa para rellenar el campo numeroDireCon
     */
    public void setNumeroDireCon(String numeroDireCon) {
        this.numeroDireCon = numeroDireCon;
    }

    /**
     * Devuelve un String para el numero del portal del contacto de notificaciones del contrato
     * @return
     */
    public String getPisoDireCon() {
        return pisoDireCon;
    }

    /**
     * Llena el campo numeroDireCon mediante un argumento String que se pasa
     * @param pisoDireCon este es el argumento que se pasa para rellenar el campo numeroDireCon
     */
    public void setPisoDireCon(String pisoDireCon) {
        this.pisoDireCon = pisoDireCon;
    }

    /**
     * Devuelve un String para el puerta del contacto de notificaciones del contrato
     * @return
     */
    public String getPuertaDireCon() {
        return puertaDireCon;
    }

    /**
     * Llena el campo puertaDireCon mediante un argumento String que se pasa
     * @param puertaDireCon este es el argumento que se pasa para rellenar el campo puertaDireCon
     */
    public void setPuertaDireCon(String puertaDireCon) {
        this.puertaDireCon = puertaDireCon;
    }

    /**
     * Devuelve un String para la localidad del contacto de notificaciones del contrato
     * @return
     */
    public String getLocalidadCon() {
        return localidadCon;
    }

    /**
     * Llena el campo localidadCon mediante un argumento String que se pasa
     * @param localidadCon este es el argumento que se pasa para rellenar el campo localidadCon
     */
    public void setLocalidadCon(String localidadCon) {
        this.localidadCon = localidadCon;
    }

    /**
     * Devuelve un String para la provincia del contacto de notificaciones del contrato
     * @return
     */
    public String getProvinciaCon() {
        return provinciaCon;
    }

    /**
     * Llena el campo provinciaCon mediante un argumento String que se pasa
     * @param provinciaCon este es el argumento que se pasa para rellenar el campo provinciaCon
     */
    public void setProvinciaCon(String provinciaCon) {
        this.provinciaCon = provinciaCon;
    }

    /**
     * Devuelve un String para el codigo postal del contacto de notificaciones del contrato
     * @return
     */
    public String getCPCon() {
        return CPCon;
    }

    /**
     * Llena el campo provinciaCon mediante un argumento String que se pasa
     * @param CPCon este es el argumento que se pasa para rellenar el campo provinciaCon
     */
    public void setCPCon(String CPCon) {
        this.CPCon = CPCon;
    }

    /**
     * Devuelve un double para la primera potencia del producto de contratación del contrato
     * @return
     */
    public double getP1Con() {
        return p1Con;
    }

    /**
     * Llena el campo p1Con mediante un argumento String que se pasa
     * @param p1Con este es el argumento que se pasa para rellenar el campo p1Con
     */
    public void setP1Con(double p1Con) {
        this.p1Con = p1Con;
    }

    /**
     * Devuelve un double para la segunda potencia del producto de contratación del contrato
     * @return
     */
    public double getP2Con() {
        return p2Con;
    }

    /**
     * Llena el campo p2Con mediante un argumento String que se pasa
     * @param p2Con este es el argumento que se pasa para rellenar el campo p2Con
     */
    public void setP2Con(double p2Con) {
        this.p2Con = p2Con;
    }

    /**
     * Devuelve un double para la tercera potencia del producto de contratación del contrato
     * @return
     */
    public double getP3Con() {
        return p3Con;
    }

    /**
     * Llena el campo p3Con mediante un argumento String que se pasa
     * @param p3Con este es el argumento que se pasa para rellenar el campo p3Con
     */
    public void setP3Con(double p3Con) {
        this.p3Con = p3Con;
    }

    /**
     * Devuelve un double para la cuarta potencia del producto de contratación del contrato
     * @return
     */
    public double getP4Con() {
        return p4Con;
    }

    /**
     * Llena el campo p4Con mediante un argumento String que se pasa
     * @param p4Con este es el argumento que se pasa para rellenar el campo p4Con
     */
    public void setP4Con(double p4Con) {
        this.p4Con = p4Con;
    }

    /**
     * Devuelve un double para la quinta potencia del producto de contratación del contrato
     * @return
     */
    public double getP5Con() {
        return p5Con;
    }

    /**
     * Llena el campo p5Con mediante un argumento String que se pasa
     * @param p5Con este es el argumento que se pasa para rellenar el campo p5Con
     */
    public void setP5Con(double p5Con) {
        this.p5Con = p5Con;
    }

    /**
     * Devuelve un double para la sexta potencia del producto de contratación del contrato
     * @return
     */
    public double getP6Con() {
        return p6Con;
    }

    /**
     * Llena el campo p6Con mediante un argumento String que se pasa
     * @param p6Con este es el argumento que se pasa para rellenar el campo p6Con
     */
    public void setP6Con(double p6Con) {
        this.p6Con = p6Con;
    }

    /**
     * Devuelve un boolean para la garantia de origen del producto de contratación del contrato
     * @return
     */
    public boolean isGarantiaDeOrigen() {
        return garantiaDeOrigen;
    }

    /**
     * Llena el campo garantiaDeOrigen mediante un argumento boolean que se pasa
     * @param garantiaDeOrigen este es el argumento que se pasa para rellenar el campo garantiaDeOrigen
     */
    public void setGarantiaDeOrigen(boolean garantiaDeOrigen) {
        this.garantiaDeOrigen = garantiaDeOrigen;
    }

    /**
     * Devuelve un String para la fecha de inicio del contrato del producto de contratación del contrato
     * @return
     */
    public String getFechaInicioContrato() {
        return fechaInicioContrato;
    }

    /**
     * Llena el campo fechaInicioContrato mediante un argumento String que se pasa
     * @param fechaInicioContrato este es el argumento que se pasa para rellenar el campo fechaInicioContrato
     */
    public void setFechaInicioContrato(String fechaInicioContrato) {
        this.fechaInicioContrato = fechaInicioContrato;
    }

    /**
     * Devuelve un String para la duracion del contrato del producto de contratación del contrato
     * @return
     */
    public String getDuracionContrato() {
        return duracionContrato;
    }

    /**
     * Llena el campo duracionContrato mediante un argumento String que se pasa
     * @param duracionContrato este es el argumento que se pasa para rellenar el campo duracionContrato
     */
    public void setDuracionContrato(String duracionContrato) {
        this.duracionContrato = duracionContrato;
    }

    /**
     * Devuelve un String para el NIF, CIF o NIE del deudor del contrato
     * @return
     */
    public String getNifCifNieBan() {
        return nifCifNieBan;
    }

    /**
     * Llena el campo nifCIfNieBan mediante un argumento String que se pasa
     * @param nifCifNieBan este es el argumento que se pasa para rellenar el campo nifCIfNieBan
     */
    public void setNifCifNieBan(String nifCifNieBan) {
        this.nifCifNieBan = nifCifNieBan;
    }

    /**
     * Devuelve un String para el nombre del deudor del contrato
     * @return
     */
    public String getNombreBan() {
        return nombreBan;
    }

    /**
     * Llena el campo nombreBan mediante un argumento String que se pasa
     * @param nombreBan este es el argumento que se pasa para rellenar el campo nombreBan
     */
    public void setNombreBan(String nombreBan) {
        this.nombreBan = nombreBan;
    }

    /**
     * Devuelve un String para el IBAN del deudor del contrato
     * @return
     */
    public String getIBAN() {
        return IBAN;
    }

    /**
     * Llena el campo IBAN mediante un argumento String que se pasa
     * @param IBAN este es el argumento que se pasa para rellenar el campo IBAN
     */
    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    //endregion

}
