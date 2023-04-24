package com.alumno.simulacionims.models;

/**
 * @author David Ruiz Garcia
 * Objeto Molde para hacer uso de los datos de los ConsumosSips
 * Todos los datos que se obtengas con esta clase se obtiene gracias a la libreria de API OkHTTP
 */
public class ConsumosSips {

    /**
     * Atributo de tipo String el cual recoge el Codigo Cups
     */
    public String CodigoCUPS;

    /**
     * Atributo de tipo String el cual recoge la Fecha Inicio
     */
    public String FechaInicio;

    /**
     * Atributo de tipo String el cual recoge la Fecha Fin
     */
    public String FechaFin;

    /**
     * Atributo de tipo String el cual recoge el Codigo Tarifa ATR
     */
    public String CodigoTarifaATR;

    /**
     * Atributo de tipo double el cual recoge la Activa1
     */
    public double Activa1;

    /**
     * Atributo de tipo double el cual recoge la Activa2
     */
    public double Activa2;

    /**
     * Atributo de tipo double el cual recoge la Activa3
     */
    public double Activa3;

    /**
     * Atributo de tipo double el cual recoge la Activa4
     */
    public double Activa4;

    /**
     * Atributo de tipo double el cual recoge la Activa5
     */
    public double Activa5;

    /**
     * Atributo de tipo double el cual recoge la Activa6
     */
    public double Activa6;

    /**
     * Atributo de tipo double el cual recoge la Reactiva1
     */
    public double Reactiva1;

    /**
     * Atributo de tipo double el cual recoge la Reactiva2
     */
    public double Reactiva2;

    /**
     * Atributo de tipo double el cual recoge la Reactiva3
     */
    public double Reactiva3;

    /**
     * Atributo de tipo double el cual recoge la Reactiva4
     */
    public double Reactiva4;

    /**
     * Atributo de tipo double el cual recoge la Reactiva5
     */
    public double Reactiva5;

    /**
     * Atributo de tipo double el cual recoge la Reactiva6
     */
    public double Reactiva6;

    /**
     * Atributo de tipo double el cual recoge la Potencia1
     */
    public double Potencia1;

    /**
     * Atributo de tipo double el cual recoge la Potencia2
     */
    public double Potencia2;

    /**
     * Atributo de tipo double el cual recoge la Potencia3
     */
    public double Potencia3;

    /**
     * Atributo de tipo double el cual recoge la Potencia4
     */
    public double Potencia4;

    /**
     * Atributo de tipo double el cual recoge la Potencia5
     */
    public double Potencia5;

    /**
     * Atributo de tipo double el cual recoge la Potencia6
     */
    public double Potencia6;

    /**
     * Atributo de tipo Object el cual recoge el Codigo DH Equipo De Medida
     */
    public Object CodigoDHEquipoDeMedida;

    /**
     * Atributo de tipo Object el cual recoge el Codigo Tipo Lectura
     */
    public Object CodigoTipoLectura;

    /**
     * Atributo de tipo String el cual recoge el Fecha Inicio Mes Consumo
     */
    public String FechaInicioMesConsumo;

    /**
     * Atributo de tipo String el cual recoge el Fecha Fin Mes Consumo
     */
    public String FechaFinMesConsumo;

    /**
     * Atributo de tipo Object el cual recoge el Codigo Tarifa Peaje
     */
    public Object CodigoTarifaPeaje;

    /**
     * Atributo de tipo double el cual recoge el Consumo en Wh P1
     */
    public double ConsumoEnWhP1;

    /**
     * Atributo de tipo double el cual recoge el Consumo en Wh P2
     */
    public double ConsumoEnWhP2;

    /**
     * Atributo de tipo Object el cual recoge el Caudal Medio En Wh Dia
     */
    public Object CaudalMedioEnWhDia;

    /**
     * Atributo de tipo Object el cual recoge el Caudal Minimo Diario
     */
    public Object CaudalMinimoDiario;

    /**
     * Atributo de tipo Object el cual recoge el Caudal Maximo Diario
     */
    public Object CaudalMaximoDiario;

    /**
     * Atributo de tipo Object el cual recoge el Porcentaje Consumo Nocturno
     */
    public Object PorcentajeConsumoNocturno;

    //Constructores

    /**
     * Constructor sin ningun tipo de dato o por defecto
     */
    public ConsumosSips() {
    }

    /**
     * Este constructor contiene todos los atributos es decir este constructor es el mas completo de todos
     *
     * @param codigoCUPS                dato tipo String
     * @param fechaInicio               dato tipo String
     * @param fechaFin                  dato tipo String
     * @param codigoTarifaATR           dato tipo String
     * @param activa1                   dato tipo double
     * @param activa2                   dato tipo double
     * @param activa3                   dato tipo double
     * @param activa4                   dato tipo double
     * @param activa5                   dato tipo double
     * @param activa6                   dato tipo double
     * @param reactiva1                 dato tipo double
     * @param reactiva2                 dato tipo double
     * @param reactiva3                 dato tipo double
     * @param reactiva4                 dato tipo double
     * @param reactiva5                 dato tipo double
     * @param reactiva6                 dato tipo double
     * @param potencia1                 dato tipo double
     * @param potencia2                 dato tipo double
     * @param potencia3                 dato tipo double
     * @param potencia4                 dato tipo double
     * @param potencia5                 dato tipo double
     * @param potencia6                 dato tipo double
     * @param codigoDHEquipoDeMedida    dato tipo Object
     * @param codigoTipoLectura         dato tipo Object
     * @param fechaInicioMesConsumo     dato tipo String
     * @param fechaFinMesConsumo        dato tipo String
     * @param codigoTarifaPeaje         dato tipo Object
     * @param consumoEnWhP1             dato tipo double
     * @param consumoEnWhP2             dato tipo double
     * @param caudalMedioEnWhDia        dato tipo Object
     * @param caudalMinimoDiario        dato tipo Object
     * @param caudalMaximoDiario        dato tipo Object
     * @param porcentajeConsumoNocturno dato tipo Object
     */
    public ConsumosSips(String codigoCUPS, String fechaInicio, String fechaFin, String codigoTarifaATR, double activa1, double activa2, double activa3, double activa4, double activa5, double activa6, double reactiva1, double reactiva2, double reactiva3, double reactiva4, double reactiva5, double reactiva6, double potencia1, double potencia2, double potencia3, double potencia4, double potencia5, double potencia6, Object codigoDHEquipoDeMedida, Object codigoTipoLectura, String fechaInicioMesConsumo, String fechaFinMesConsumo, Object codigoTarifaPeaje, double consumoEnWhP1, double consumoEnWhP2, Object caudalMedioEnWhDia, Object caudalMinimoDiario, Object caudalMaximoDiario, Object porcentajeConsumoNocturno) {
        CodigoCUPS = codigoCUPS;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        CodigoTarifaATR = codigoTarifaATR;
        Activa1 = activa1;
        Activa2 = activa2;
        Activa3 = activa3;
        Activa4 = activa4;
        Activa5 = activa5;
        Activa6 = activa6;
        Reactiva1 = reactiva1;
        Reactiva2 = reactiva2;
        Reactiva3 = reactiva3;
        Reactiva4 = reactiva4;
        Reactiva5 = reactiva5;
        Reactiva6 = reactiva6;
        Potencia1 = potencia1;
        Potencia2 = potencia2;
        Potencia3 = potencia3;
        Potencia4 = potencia4;
        Potencia5 = potencia5;
        Potencia6 = potencia6;
        CodigoDHEquipoDeMedida = codigoDHEquipoDeMedida;
        CodigoTipoLectura = codigoTipoLectura;
        FechaInicioMesConsumo = fechaInicioMesConsumo;
        FechaFinMesConsumo = fechaFinMesConsumo;
        CodigoTarifaPeaje = codigoTarifaPeaje;
        ConsumoEnWhP1 = consumoEnWhP1;
        ConsumoEnWhP2 = consumoEnWhP2;
        CaudalMedioEnWhDia = caudalMedioEnWhDia;
        CaudalMinimoDiario = caudalMinimoDiario;
        CaudalMaximoDiario = caudalMaximoDiario;
        PorcentajeConsumoNocturno = porcentajeConsumoNocturno;
    }

    //Getters y Setters

    /**
     * Devuelve un String para el codigo cups de los consumos sips
     *
     * @return
     */
    public String getCodigoCUPS() {
        return CodigoCUPS;
    }

    /**
     * Llena el campo codigoCUPS mediante un argumento String que se pasa
     *
     * @param codigoCUPS este es el argumento que se pasa para rellenar el campo codigoCUPS
     */
    public void setCodigoCUPS(String codigoCUPS) {
        CodigoCUPS = codigoCUPS;
    }

    /**
     * Devuelve un String para la fecha de inicio de los consumos sips
     *
     * @return
     */
    public String getFechaInicio() {
        return FechaInicio;
    }

    /**
     * Llena el campo fechaInicio mediante un argumento String que se pasa
     *
     * @param fechaInicio este es el argumento que se pasa para rellenar el campo fechaIinicio
     */
    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    /**
     * Devuelve un String para la fecha de fin de los consumos sips
     *
     * @return
     */
    public String getFechaFin() {
        return FechaFin;
    }

    /**
     * Llena el campo fechaFin mediante un argumento String que se pasa
     *
     * @param fechaFin este es el argumento que se pasa para rellenar el campo fechaFin
     */
    public void setFechaFin(String fechaFin) {
        FechaFin = fechaFin;
    }

    /**
     * Devuelve un String para el codigo de tarifa TAR de los consumos sips
     *
     * @return
     */
    public String getCodigoTarifaATR() {
        return CodigoTarifaATR;
    }

    /**
     * Llena el campo codigoTarifaTAR mediante un argumento String que se pasa
     *
     * @param codigoTarifaATR este es el argumento que se pasa para rellenar el campo codigoTarifaTAR
     */
    public void setCodigoTarifaATR(String codigoTarifaATR) {
        CodigoTarifaATR = codigoTarifaATR;
    }

    /**
     * Devuelve un double para la activa 1 de los consumos sips
     *
     * @return
     */
    public double getActiva1() {
        return Activa1;
    }

    /**
     * Llena el campo activa 1 mediante un argumento double que se pasa
     *
     * @param activa1 este es el argumento que se pasa para rellenar el campo activa 1
     */
    public void setActiva1(double activa1) {
        Activa1 = activa1;
    }

    /**
     * Devuelve un double para la activa 2 de los consumos sips
     *
     * @return
     */
    public double getActiva2() {
        return Activa2;
    }

    /**
     * Llena el campo activa 2 mediante un argumento double que se pasa
     *
     * @param activa2 este es el argumento que se pasa para rellenar el campo activa 2
     */
    public void setActiva2(double activa2) {
        Activa2 = activa2;
    }

    /**
     * Devuelve un double para la activa 3 de los consumos sips
     *
     * @return
     */
    public double getActiva3() {
        return Activa3;
    }

    /**
     * Llena el campo activa 3 mediante un argumento double que se pasa
     *
     * @param activa3 este es el argumento que se pasa para rellenar el campo activa 3
     */
    public void setActiva3(double activa3) {
        Activa3 = activa3;
    }

    /**
     * Devuelve un double para la activa 4 de los consumos sips
     *
     * @return
     */
    public double getActiva4() {
        return Activa4;
    }

    /**
     * Llena el campo activa 4 mediante un argumento double que se pasa
     *
     * @param activa4 este es el argumento que se pasa para rellenar el campo activa 4
     */
    public void setActiva4(double activa4) {
        Activa4 = activa4;
    }

    /**
     * Devuelve un double para la activa 5 de los consumos sips
     *
     * @return
     */
    public double getActiva5() {
        return Activa5;
    }

    /**
     * Llena el campo activa 5 mediante un argumento double que se pasa
     *
     * @param activa5 este es el argumento que se pasa para rellenar el campo activa 5
     */
    public void setActiva5(double activa5) {
        Activa5 = activa5;
    }

    /**
     * Devuelve un double para la activa 6 de los consumos sips
     *
     * @return
     */
    public double getActiva6() {
        return Activa6;
    }

    /**
     * Llena el campo activa 6 mediante un argumento double que se pasa
     *
     * @param activa6 este es el argumento que se pasa para rellenar el campo activa 6
     */
    public void setActiva6(double activa6) {
        Activa6 = activa6;
    }

    /**
     * Devuelve un double para la reactiva 1 de los consumos sips
     *
     * @return
     */
    public double getReactiva1() {
        return Reactiva1;
    }

    /**
     * Llena el campo reactiva 1 mediante un argumento double que se pasa
     *
     * @param reactiva1 este es el argumento que se pasa para rellenar el campo reactiva 1
     */
    public void setReactiva1(double reactiva1) {
        Reactiva1 = reactiva1;
    }

    /**
     * Devuelve un double para la reactiva 2 de los consumos sips
     *
     * @return
     */
    public double getReactiva2() {
        return Reactiva2;
    }

    /**
     * Llena el campo reactiva 2 mediante un argumento double que se pasa
     *
     * @param reactiva2 este es el argumento que se pasa para rellenar el campo reactiva 2
     */
    public void setReactiva2(double reactiva2) {
        Reactiva2 = reactiva2;
    }

    /**
     * Devuelve un double para la reactiva 3 de los consumos sips
     *
     * @return
     */
    public double getReactiva3() {
        return Reactiva3;
    }

    /**
     * Llena el campo reactiva 3 mediante un argumento double que se pasa
     *
     * @param reactiva3 este es el argumento que se pasa para rellenar el campo reactiva 3
     */
    public void setReactiva3(double reactiva3) {
        Reactiva3 = reactiva3;
    }

    /**
     * Devuelve un double para la reactiva 4 de los consumos sips
     *
     * @return
     */
    public double getReactiva4() {
        return Reactiva4;
    }

    /**
     * Llena el campo reactiva 4 mediante un argumento double que se pasa
     *
     * @param reactiva4 este es el argumento que se pasa para rellenar el campo reactiva 4
     */
    public void setReactiva4(double reactiva4) {
        Reactiva4 = reactiva4;
    }

    /**
     * Devuelve un double para la reactiva 5 de los consumos sips
     *
     * @return
     */
    public double getReactiva5() {
        return Reactiva5;
    }

    /**
     * Llena el campo reactiva 5 mediante un argumento double que se pasa
     *
     * @param reactiva5 este es el argumento que se pasa para rellenar el campo reactiva 5
     */
    public void setReactiva5(double reactiva5) {
        Reactiva5 = reactiva5;
    }

    /**
     * Devuelve un double para la reactiva 6 de los consumos sips
     *
     * @return
     */
    public double getReactiva6() {
        return Reactiva6;
    }

    /**
     * Llena el campo reactiva 6 mediante un argumento double que se pasa
     *
     * @param reactiva6 este es el argumento que se pasa para rellenar el campo reactiva 6
     */
    public void setReactiva6(double reactiva6) {
        Reactiva6 = reactiva6;
    }

    /**
     * Devuelve un double para la potencia 1 de los consumos sips
     *
     * @return
     */
    public double getPotencia1() {
        return Potencia1;
    }

    /**
     * Llena el campo potencia 1 mediante un argumento double que se pasa
     *
     * @param potencia1 este es el argumento que se pasa para rellenar el campo potencia 1
     */
    public void setPotencia1(double potencia1) {
        Potencia1 = potencia1;
    }

    /**
     * Devuelve un double para la potencia 2 de los consumos sips
     *
     * @return
     */
    public double getPotencia2() {
        return Potencia2;
    }

    /**
     * Llena el campo potencia 2 mediante un argumento double que se pasa
     *
     * @param potencia2 este es el argumento que se pasa para rellenar el campo potencia 2
     */
    public void setPotencia2(double potencia2) {
        Potencia2 = potencia2;
    }

    /**
     * Devuelve un double para la potencia 3 de los consumos sips
     *
     * @return
     */
    public double getPotencia3() {
        return Potencia3;
    }

    /**
     * Llena el campo potencia 3 mediante un argumento double que se pasa
     *
     * @param potencia3 este es el argumento que se pasa para rellenar el campo potencia 3
     */
    public void setPotencia3(double potencia3) {
        Potencia3 = potencia3;
    }

    /**
     * Devuelve un double para la potencia 4 de los consumos sips
     *
     * @return
     */
    public double getPotencia4() {
        return Potencia4;
    }

    /**
     * Llena el campo potencia 4 mediante un argumento double que se pasa
     *
     * @param potencia4 este es el argumento que se pasa para rellenar el campo potencia 4
     */
    public void setPotencia4(double potencia4) {
        Potencia4 = potencia4;
    }

    /**
     * Devuelve un double para la potencia 5 de los consumos sips
     *
     * @return
     */
    public double getPotencia5() {
        return Potencia5;
    }

    /**
     * Llena el campo potencia 5 mediante un argumento double que se pasa
     *
     * @param potencia5 este es el argumento que se pasa para rellenar el campo potencia 5
     */
    public void setPotencia5(double potencia5) {
        Potencia5 = potencia5;
    }

    /**
     * Devuelve un double para la potencia 6 de los consumos sips
     *
     * @return
     */
    public double getPotencia6() {
        return Potencia6;
    }

    /**
     * Llena el campo potencia 6 mediante un argumento double que se pasa
     *
     * @param potencia6 este es el argumento que se pasa para rellenar el campo potencia 6
     */
    public void setPotencia6(double potencia6) {
        Potencia6 = potencia6;
    }

    /**
     * Devuelve un Object para el codigoDH de equipo de medida de los consumos sips
     *
     * @return
     */
    public Object getCodigoDHEquipoDeMedida() {
        return CodigoDHEquipoDeMedida;
    }

    /**
     * Llena el campo codigoDH de equipo de medida mediante un argumento Object que se pasa
     *
     * @param codigoDHEquipoDeMedida este es el argumento que se pasa para rellenar el campo codigoDH de equipo de medida
     */
    public void setCodigoDHEquipoDeMedida(Object codigoDHEquipoDeMedida) {
        CodigoDHEquipoDeMedida = codigoDHEquipoDeMedida;
    }

    /**
     * Devuelve un Object para el codigo de tipo lectura de los consumos sips
     *
     * @return
     */
    public Object getCodigoTipoLectura() {
        return CodigoTipoLectura;
    }

    /**
     * Llena el campo codigo de tipo lectura mediante un argumento Object que se pasa
     *
     * @param codigoTipoLectura este es el argumento que se pasa para rellenar el campo codigo de tipo lectura
     */
    public void setCodigoTipoLectura(Object codigoTipoLectura) {
        CodigoTipoLectura = codigoTipoLectura;
    }

    /**
     * Devuelve un String para la fecha de inicio de mes del consumo de los consumos sips
     *
     * @return
     */
    public String getFechaInicioMesConsumo() {
        return FechaInicioMesConsumo;
    }

    /**
     * Llena el campo fecha de inicio de mes del consumo mediante un argumento String que se pasa
     *
     * @param fechaInicioMesConsumo este es el argumento que se pasa para rellenar el campo fecha de inicio de mes del consumo
     */
    public void setFechaInicioMesConsumo(String fechaInicioMesConsumo) {
        FechaInicioMesConsumo = fechaInicioMesConsumo;
    }

    /**
     * Devuelve un String para la fecha de fin de mes del consumo de los consumos sips
     *
     * @return
     */
    public String getFechaFinMesConsumo() {
        return FechaFinMesConsumo;
    }

    /**
     * Llena el campo fecha de fin de mes del consumo mediante un argumento String que se pasa
     *
     * @param fechaFinMesConsumo este es el argumento que se pasa para rellenar el campo fecha de fin de mes del consumo
     */
    public void setFechaFinMesConsumo(String fechaFinMesConsumo) {
        FechaFinMesConsumo = fechaFinMesConsumo;
    }

    /**
     * Devuelve un Object para el codigo tarifa de peaje  de los consumos sips
     *
     * @return
     */
    public Object getCodigoTarifaPeaje() {
        return CodigoTarifaPeaje;
    }

    /**
     * Llena el campo codigo tarifa de peaje mediante un argumento Object que se pasa
     *
     * @param codigoTarifaPeaje este es el argumento que se pasa para rellenar el campo codigo tarifa de peaje
     */
    public void setCodigoTarifaPeaje(Object codigoTarifaPeaje) {
        CodigoTarifaPeaje = codigoTarifaPeaje;
    }

    /**
     * Devuelve un double para el consumo en wh p1  de los consumos sips
     *
     * @return
     */
    public double getConsumoEnWhP1() {
        return ConsumoEnWhP1;
    }

    /**
     * Llena el campo consumo en wh p1 mediante un argumento double que se pasa
     *
     * @param consumoEnWhP1 este es el argumento que se pasa para rellenar el campo consumo en wh p1
     */
    public void setConsumoEnWhP1(double consumoEnWhP1) {
        ConsumoEnWhP1 = consumoEnWhP1;
    }

    /**
     * Devuelve un double para el consumo en wh p2  de los consumos sips
     *
     * @return
     */
    public double getConsumoEnWhP2() {
        return ConsumoEnWhP2;
    }

    /**
     * Llena el campo consumo en wh p2 mediante un argumento double que se pasa
     *
     * @param consumoEnWhP2 este es el argumento que se pasa para rellenar el campo consumo en wh p2
     */
    public void setConsumoEnWhP2(double consumoEnWhP2) {
        ConsumoEnWhP2 = consumoEnWhP2;
    }

    /**
     * Devuelve un Object para el caudal medio en WH/dia  de los consumos sips
     *
     * @return
     */
    public Object getCaudalMedioEnWhDia() {
        return CaudalMedioEnWhDia;
    }

    /**
     * Llena el campo caudal medio en WH/dia mediante un argumento Object que se pasa
     *
     * @param caudalMedioEnWhDia este es el argumento que se pasa para rellenar el campo caudal medio en WH/dia
     */
    public void setCaudalMedioEnWhDia(Object caudalMedioEnWhDia) {
        CaudalMedioEnWhDia = caudalMedioEnWhDia;
    }

    /**
     * Devuelve un Object para el caudal minimo diario  de los consumos sips
     *
     * @return
     */
    public Object getCaudalMinimoDiario() {
        return CaudalMinimoDiario;
    }

    /**
     * Llena el campo caudal minimo diario mediante un argumento Object que se pasa
     *
     * @param caudalMinimoDiario este es el argumento que se pasa para rellenar el caudal minimo diario
     */
    public void setCaudalMinimoDiario(Object caudalMinimoDiario) {
        CaudalMinimoDiario = caudalMinimoDiario;
    }

    /**
     * Devuelve un Object para el caudal maximo diario  de los consumos sips
     *
     * @return
     */
    public Object getCaudalMaximoDiario() {
        return CaudalMaximoDiario;
    }

    /**
     * Llena el campo caudal maximo diario mediante un argumento Object que se pasa
     *
     * @param caudalMaximoDiario este es el argumento que se pasa para rellenar el caudal maximo diario
     */
    public void setCaudalMaximoDiario(Object caudalMaximoDiario) {
        CaudalMaximoDiario = caudalMaximoDiario;
    }

    /**
     * Devuelve un Object para el porcentaje de consumo nocturno  de los consumos sips
     *
     * @return
     */
    public Object getPorcentajeConsumoNocturno() {
        return PorcentajeConsumoNocturno;
    }

    /**
     * Llena el campo porcentaje de consumo nocturno mediante un argumento Object que se pasa
     *
     * @param porcentajeConsumoNocturno este es el argumento que se pasa para rellenar el porcentaje de consumo nocturno
     */
    public void setPorcentajeConsumoNocturno(Object porcentajeConsumoNocturno) {
        PorcentajeConsumoNocturno = porcentajeConsumoNocturno;
    }

    /**
     * Devuelve un String con todos los atributos de la clase Molde ConsumosSips mediate el método toString()
     *
     * @return
     */
    @Override
    public String toString() {
        return "ConsumoSip{" +
                "CodigoCUPS='" + CodigoCUPS + '\'' +
                ", FechaInicio='" + FechaInicio + '\'' +
                ", FechaFin='" + FechaFin + '\'' +
                ", CodigoTarifaATR='" + CodigoTarifaATR + '\'' +
                ", Activa1=" + Activa1 +
                ", Activa2=" + Activa2 +
                ", Activa3=" + Activa3 +
                ", Activa4=" + Activa4 +
                ", Activa5=" + Activa5 +
                ", Activa6=" + Activa6 +
                ", Reactiva1=" + Reactiva1 +
                ", Reactiva2=" + Reactiva2 +
                ", Reactiva3=" + Reactiva3 +
                ", Reactiva4=" + Reactiva4 +
                ", Reactiva5=" + Reactiva5 +
                ", Reactiva6=" + Reactiva6 +
                ", Potencia1=" + Potencia1 +
                ", Potencia2=" + Potencia2 +
                ", Potencia3=" + Potencia3 +
                ", Potencia4=" + Potencia4 +
                ", Potencia5=" + Potencia5 +
                ", Potencia6=" + Potencia6 +
                ", CodigoDHEquipoDeMedida=" + CodigoDHEquipoDeMedida +
                ", CodigoTipoLectura=" + CodigoTipoLectura +
                ", FechaInicioMesConsumo='" + FechaInicioMesConsumo + '\'' +
                ", FechaFinMesConsumo='" + FechaFinMesConsumo + '\'' +
                ", CodigoTarifaPeaje=" + CodigoTarifaPeaje +
                ", ConsumoEnWhP1=" + ConsumoEnWhP1 +
                ", ConsumoEnWhP2=" + ConsumoEnWhP2 +
                ", CaudalMedioEnWhDia=" + CaudalMedioEnWhDia +
                ", CaudalMinimoDiario=" + CaudalMinimoDiario +
                ", CaudalMaximoDiario=" + CaudalMaximoDiario +
                ", PorcentajeConsumoNocturno=" + PorcentajeConsumoNocturno +
                '}';
    }
}
