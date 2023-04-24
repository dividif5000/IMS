package com.alumno.simulacionims.models;

import java.util.List;

/**
 * @author David Ruiz Garcia
 * Objeto Molde para hacer uso de los datos de los ClasesSipsExternas
 * es un conjunto de la ClienteSips y ConsumoSips
 * Todos los datos que se obtengas con esta clase se obtiene gracias a la libreria de API OkHTTP
 */
public class ClasesSipsExtensa {
    //region Atributos
    //Atributos
    /**
     * Atributo tipo List de ClientesSpis el cual recoge una lista de clientes
     */
    public List<com.alumno.simulacionims.models.ClientesSips> ClientesSips;
    /**
     * Atributo tipo List de ConsumoSips el cual recoge una lista de consumos
     */
    public List<com.alumno.simulacionims.models.ConsumosSips> ConsumosSips;
    /**
     * Atributo tipo Object de Datos Titular el cal se recoge los datos del titular
     */
    public Object DatosTitular;
    //endregion
    //region COnsstructores
    //Constructor


    /**
     * Constructor sin ningun tipo de dato o por defecto
     */
    public ClasesSipsExtensa() {
    }

    /**
     * Este constructor contiene todos los atributos es decir este constructor es el mas completo de todos
     * @param clientesSips dato tipo List <ClientesSips>
     * @param consumosSips dato tipo List <ConsumoSips>
     * @param datosTitular dato tipo Object
     */
    public ClasesSipsExtensa(List<com.alumno.simulacionims.models.ClientesSips> clientesSips, List<com.alumno.simulacionims.models.ConsumosSips> consumosSips, Object datosTitular) {
        ClientesSips = clientesSips;
        ConsumosSips = consumosSips;
        DatosTitular = datosTitular;
    }
    //endregion
    //region Getter&Setter
    //Getters y Setters

    /**
     *  Devuelve un List para el los datos de los clientes de las clases sips externas
     * @return
     */
    public List<com.alumno.simulacionims.models.ClientesSips> getClientesSips() {
        return ClientesSips;
    }

    /**
     * Llena el campo id mediante un argumento int que se pasa
     * @param clientesSips este es el argumento que se pasa para rellenar el campo id
     */
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

    //endregion
    //region toString

    /**
     * Devuelve un String con todos los atributos de la clase Molde ClasesSipsExterna mediate el método toString()
     * @return
     */
    @Override
    public String toString() {
        return "ClasesSipsExtensa{" +
                "ClientesSips=" + ClientesSips +
                ", ConsumosSips=" + ConsumosSips +
                ", DatosTitular=" + DatosTitular +
                '}';
    }
    //endregion
}
