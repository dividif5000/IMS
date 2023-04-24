package com.alumno.simulacionims.models;

import java.util.List;

public class ClasesSipsExtensa {

    public List<com.alumno.simulacionims.models.ClientesSips> ClientesSips;
    public List<com.alumno.simulacionims.models.ConsumosSips> ConsumosSips;
    public Object DatosTitular;

    //Constructor

    public ClasesSipsExtensa() {
    }

    public ClasesSipsExtensa(List<com.alumno.simulacionims.models.ClientesSips> clientesSips, List<com.alumno.simulacionims.models.ConsumosSips> consumosSips, Object datosTitular) {
        ClientesSips = clientesSips;
        ConsumosSips = consumosSips;
        DatosTitular = datosTitular;
    }

    //Getters y Setters

    public List<com.alumno.simulacionims.models.ClientesSips> getClientesSips() {
        return ClientesSips;
    }

    public void setClientesSips(List<com.alumno.simulacionims.models.ClientesSips> clientesSips) {
        ClientesSips = clientesSips;
    }

    public List<com.alumno.simulacionims.models.ConsumosSips> getConsumosSips() {
        return ConsumosSips;
    }

    public void setConsumosSips(List<com.alumno.simulacionims.models.ConsumosSips> consumosSips) {
        ConsumosSips = consumosSips;
    }

    public Object getDatosTitular() {
        return DatosTitular;
    }

    public void setDatosTitular(Object datosTitular) {
        DatosTitular = datosTitular;
    }

    @Override
    public String toString() {
        return "ClasesSipsExtensa{" +
                "ClientesSips=" + ClientesSips +
                ", ConsumosSips=" + ConsumosSips +
                ", DatosTitular=" + DatosTitular +
                '}';
    }
}
