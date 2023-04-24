package com.alumno.simulacionims.models;


import java.util.Date;

public class ClaseSips {
    public String CodigoCUPS ;
    public String FechaInicio ;
    public String FechaFin ;
    public String CodigoTarifaATR ;
    public float Activa1 ;
    public float Activa2 ;
    public float Activa3 ;
    public float Activa4 ;
    public float Activa5 ;
    public float Activa6 ;
    public float Reactiva1 ;
    public float Reactiva2 ;
    public float Reactiva3 ;
    public float Reactiva4 ;
    public float Reactiva5 ;
    public float Reactiva6 ;
    public float Potencia1 ;
    public float Potencia2 ;
    public float Potencia3 ;
    public float Potencia4 ;
    public float Potencia5 ;
    public float Potencia6 ;
    public Object CodigoDHEquipoDeMedida ;
    public Object CodigoTipoLectura ;
    public Object FechaInicioMesConsumo ;
    public Object FechaFinMesConsumo ;
    public Object CodigoTarifaPeaje ;
    public Object ConsumoEnWhP1 ;
    public Object ConsumoEnWhP2 ;
    public Object CaudalMedioEnWhDia ;
    public Object CaudalMinimoDiario ;
    public Object CaudalMaximoDiario ;
    public Object PorcentajeConsumoNocturno;


    //Constructores

    public ClaseSips() {

    }

    public ClaseSips(String codigoCUPS, String fechaInicio, String fechaFin, String codigoTarifaATR, float activa1, float activa2, float activa3, float activa4, float activa5, float activa6, float reactiva1, float reactiva2, float reactiva3, float reactiva4, float reactiva5, float reactiva6, float potencia1, float potencia2, float potencia3, float potencia4, float potencia5, float potencia6, Object codigoDHEquipoDeMedida, Object codigoTipoLectura, Object fechaInicioMesConsumo, Object fechaFinMesConsumo, Object codigoTarifaPeaje, Object consumoEnWhP1, Object consumoEnWhP2, Object caudalMedioEnWhDia, Object caudalMinimoDiario, Object caudalMaximoDiario, Object porcentajeConsumoNocturno) {
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
    public String getCodigoCUPS() {
        return CodigoCUPS;
    }

    public void setCodigoCUPS(String codigoCUPS) {
        CodigoCUPS = codigoCUPS;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String fechaFin) {
        FechaFin = fechaFin;
    }

    public String getCodigoTarifaATR() {
        return CodigoTarifaATR;
    }

    public void setCodigoTarifaATR(String codigoTarifaATR) {
        CodigoTarifaATR = codigoTarifaATR;
    }

    public float getActiva1() {
        return Activa1;
    }

    public void setActiva1(float activa1) {
        Activa1 = activa1;
    }

    public float getActiva2() {
        return Activa2;
    }

    public void setActiva2(float activa2) {
        Activa2 = activa2;
    }

    public float getActiva3() {
        return Activa3;
    }

    public void setActiva3(float activa3) {
        Activa3 = activa3;
    }

    public float getActiva4() {
        return Activa4;
    }

    public void setActiva4(float activa4) {
        Activa4 = activa4;
    }

    public float getActiva5() {
        return Activa5;
    }

    public void setActiva5(float activa5) {
        Activa5 = activa5;
    }

    public float getActiva6() {
        return Activa6;
    }

    public void setActiva6(float activa6) {
        Activa6 = activa6;
    }

    public float getReactiva1() {
        return Reactiva1;
    }

    public void setReactiva1(float reactiva1) {
        Reactiva1 = reactiva1;
    }

    public float getReactiva2() {
        return Reactiva2;
    }

    public void setReactiva2(float reactiva2) {
        Reactiva2 = reactiva2;
    }

    public float getReactiva3() {
        return Reactiva3;
    }

    public void setReactiva3(float reactiva3) {
        Reactiva3 = reactiva3;
    }

    public float getReactiva4() {
        return Reactiva4;
    }

    public void setReactiva4(float reactiva4) {
        Reactiva4 = reactiva4;
    }

    public float getReactiva5() {
        return Reactiva5;
    }

    public void setReactiva5(float reactiva5) {
        Reactiva5 = reactiva5;
    }

    public float getReactiva6() {
        return Reactiva6;
    }

    public void setReactiva6(float reactiva6) {
        Reactiva6 = reactiva6;
    }

    public float getPotencia1() {
        return Potencia1;
    }

    public void setPotencia1(float potencia1) {
        Potencia1 = potencia1;
    }

    public float getPotencia2() {
        return Potencia2;
    }

    public void setPotencia2(float potencia2) {
        Potencia2 = potencia2;
    }

    public float getPotencia3() {
        return Potencia3;
    }

    public void setPotencia3(float potencia3) {
        Potencia3 = potencia3;
    }

    public float getPotencia4() {
        return Potencia4;
    }

    public void setPotencia4(float potencia4) {
        Potencia4 = potencia4;
    }

    public float getPotencia5() {
        return Potencia5;
    }

    public void setPotencia5(float potencia5) {
        Potencia5 = potencia5;
    }

    public float getPotencia6() {
        return Potencia6;
    }

    public void setPotencia6(float potencia6) {
        Potencia6 = potencia6;
    }

    public Object getCodigoDHEquipoDeMedida() {
        return CodigoDHEquipoDeMedida;
    }

    public void setCodigoDHEquipoDeMedida(Object codigoDHEquipoDeMedida) {
        CodigoDHEquipoDeMedida = codigoDHEquipoDeMedida;
    }

    public Object getCodigoTipoLectura() {
        return CodigoTipoLectura;
    }

    public void setCodigoTipoLectura(Object codigoTipoLectura) {
        CodigoTipoLectura = codigoTipoLectura;
    }

    public Object getFechaInicioMesConsumo() {
        return FechaInicioMesConsumo;
    }

    public void setFechaInicioMesConsumo(Object fechaInicioMesConsumo) {
        FechaInicioMesConsumo = fechaInicioMesConsumo;
    }

    public Object getFechaFinMesConsumo() {
        return FechaFinMesConsumo;
    }

    public void setFechaFinMesConsumo(Object fechaFinMesConsumo) {
        FechaFinMesConsumo = fechaFinMesConsumo;
    }

    public Object getCodigoTarifaPeaje() {
        return CodigoTarifaPeaje;
    }

    public void setCodigoTarifaPeaje(Object codigoTarifaPeaje) {
        CodigoTarifaPeaje = codigoTarifaPeaje;
    }

    public Object getConsumoEnWhP1() {
        return ConsumoEnWhP1;
    }

    public void setConsumoEnWhP1(Object consumoEnWhP1) {
        ConsumoEnWhP1 = consumoEnWhP1;
    }

    public Object getConsumoEnWhP2() {
        return ConsumoEnWhP2;
    }

    public void setConsumoEnWhP2(Object consumoEnWhP2) {
        ConsumoEnWhP2 = consumoEnWhP2;
    }

    public Object getCaudalMedioEnWhDia() {
        return CaudalMedioEnWhDia;
    }

    public void setCaudalMedioEnWhDia(Object caudalMedioEnWhDia) {
        CaudalMedioEnWhDia = caudalMedioEnWhDia;
    }

    public Object getCaudalMinimoDiario() {
        return CaudalMinimoDiario;
    }

    public void setCaudalMinimoDiario(Object caudalMinimoDiario) {
        CaudalMinimoDiario = caudalMinimoDiario;
    }

    public Object getCaudalMaximoDiario() {
        return CaudalMaximoDiario;
    }

    public void setCaudalMaximoDiario(Object caudalMaximoDiario) {
        CaudalMaximoDiario = caudalMaximoDiario;
    }

    public Object getPorcentajeConsumoNocturno() {
        return PorcentajeConsumoNocturno;
    }

    public void setPorcentajeConsumoNocturno(Object porcentajeConsumoNocturno) {
        PorcentajeConsumoNocturno = porcentajeConsumoNocturno;
    }

    @Override
    public String toString() {
        return "ClaseSips{" +
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
                ", FechaInicioMesConsumo=" + FechaInicioMesConsumo +
                ", FechaFinMesConsumo=" + FechaFinMesConsumo +
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