package com.alumno.simulacionims.models;

/**
 * @author David Ruiz Garcia
 * Objeto Molde para hacer uso de los datos de los ClintesSips
 * Todos los datos que se obtengas con esta clase se obtiene gracias a la libreria de API OkHTTP
 */
public class ClientesSips {
    //region Atributos
    /**
     * Atributo tipo String el cual recoge el codigo CUPS
     */
    public String CodigoCUPS;

    /**
     * Atributo tipo String el cual recogecel el codigo de la empresa distribuidora
     */
    public String CodigoEmpresaDistribuidora;

    /**
     * Atributo tipo String el cual recoge el nombre de la empresa distribuidora
     */
    public String NombreEmpresaDistribuidora;

    /**
     * Atributo tipo String el cual recoge el codigo postal PS
     */
    public String CodigoPostalPS;

    /**
     * Atributo tipo String el cual recoge el municipio PS
     */
    public String MunicipioPS;

    /**
     * Atributo tipo String el cual recoge el codigo provincial PS
     */
    public String CodigoProvinciaPS;
    /**
     * Atributo tipo String el cual recoge la fecha de alta del suministro
     */
    public String FechaAltaSuministro;

    /**
     * Atributo tipo String el cual recoge el codigo de tarifa ATR en vigor
     */
    public String CodigoTarifaATREnVigor;

    /**
     * Atributo tipo String el cual recoge el codigo en tension V
     */
    public String CodigoTensionV;

    /**
     * Atributo tipo double el cual recoge la potencia maxima BIEW
     */
    public double PotenciaMaximaBIEW;

    /**
     * Atributo tipo double el cual recoge APMW
     */
    public double PotenciaMaximaAPMW;

    /**
     * Atributo tipo String el cual recoge el codigo de clasificacion PS
     */
    public String CodigoClasificacionPS;

    /**
     * Atributo tipo String el cual recoge el codigo  de disponibilidad ICP
     */
    public String CodigoDisponibilidadICP;

    /**
     * Atributo tipo String el cual recoge el tipo de perfil de consumo
     */
    public String TipoPerfilConsumo;

    /**
     * Atributo tipo String el cual recoge el valor de derechos de extension W
     */
    public String ValorDerechosExtensionW;

    /**
     * Atributo tipo String el cual recoge el valor de derechos de acceso W
     */
    public String ValorDerechosAccesoW;

    /**
     * Atributo tipo String el cual recoge el codigo de la media  de equipo en propiedad
     */
    public String CodigoPropiedadEquipoMedida;

    /**
     * Atributo tipo String el cual recoge el codigo de propiedad ICP
     */
    public String CodigoPropiedadICP;

    /**
     * Atributo tipo double el cual recoge las potencias contratadas en WP1
     */
    public double PotenciasContratadasEnWP1;

    /**
     * Atributo tipo double el cual recoge las potencias contratadas en WP2
     */
    public double PotenciasContratadasEnWP2;

    /**
     * Atributo tipo double el cual recoge las potencias contratadas en WP3
     */
    public double PotenciasContratadasEnWP3;

    /**
     * Atributo tipo double el cual recoge las potencias contratadas en WP4
     */
    public double PotenciasContratadasEnWP4;

    /**
     * Atributo tipo double el cual recoge las potencias contratadas en WP5
     */
    public double PotenciasContratadasEnWP5;

    /**
     * Atributo tipo double el cual recoge las potencias contratadas en WP6
     */
    public double PotenciasContratadasEnWP6;

    /**
     * Atributo tipo String el cual recoge la fecha del ultimo movimineto del contrato
     */
    public String FechaUltimoMovimientoContrato;

    /**
     * Atributo tipo String el cual recoge la fecha del ultimo cambio de comercializador
     */
    public String FechaUltimoCambioComercializador;

    /**
     * Atributo tipo String el cual recoge la fecha limite de derechos  reconocidos
     */
    public String FechaLimiteDerechosReconocidos;

    /**
     * Atributo tipo String el cual recoge la fecha de ultima lectura
     */
    public String FechaUltimaLectura;

    /**
     * Atributo tipo Object el cual recoge la informacion de impagos
     */
    public Object InformacionImpagos;

    /**
     * Atributo tipo Object el cual recoge el importe dl deposito de garantia en euros
     */
    public Object ImporteDepositoGarantiaEuros;

    /**
     * Atributo tipo String el cual recoge el tipo de id del titular
     */
    public String TipoIdTitular;

    /**
     * Atributo tipo String el cual recoge la vivienda habitual
     */
    public String EsViviendaHabitual;

    /**
     * Atributo tipo Object el cual recoge el codigo de comerlicializadora
     */
    public Object CodigoComercializadora;

    /**
     * Atributo tipo String el cual recoge el codigo de telegestion
     */
    public String CodigoTelegestion;

    /**
     * Atributo tipo String el cual recoge el codigo de la media de las fases de equipo
     */
    public String CodigoFasesEquipoMedida;

    /**
     * Atributo tipo String el cual recoge el codigo de autoconsumo
     */
    public String CodigoAutoconsumo;

    /**
     * Atributo tipo Object el cual recoge codigo de tipo de contrato
     */
    public Object CodigoTipoContrato;

    /**
     * Atributo tipo Object el cual recoge el codigo de periodicidad de facturacion
     */
    public Object CodigoPeriodicidadFacturacion;

    /**
     * Atributo tipo Object el cual recoge el codigo BIE
     */
    public Object CodigoBIE;

    /**
     * Atributo tipo Object el cual recoge la fecha de emision BIE
     */
    public Object FechaEmisionBIE;

    /**
     * Atributo tipo Object el cual recoge la fecha de caducidad BIE
     */
    public Object FechaCaducidadBIE;

    /**
     * Atributo tipo Object el cual recoge el codigo APM
     */
    public Object CodigoAPM;

    /**
     * Atributo tipo Object el cual recoge la fecha de emision APM
     */
    public Object FechaEmisionAPM;

    /**
     * Atributo tipo Object el cual recoge la fecha de caducidad APM
     */
    public Object FechaCaducidadAPM;

    /**
     * Atributo tipo Object el cual recoge la relacion de transformacion de la intensidad
     */
    public Object RelacionTransformacionIntensidad;

    /**
     * Atributo tipo String el cual recoge el cnae
     */
    public String Cnae;

    /**
     * Atributo tipo String el cual recoge el codigo de modo control de potencia
     */
    public String CodigoModoControlPotencia;

    /**
     * Atributo tipo Object el cual recoge la potencia CGPW
     */
    public Object PotenciaCGPW;

    /**
     * Atributo tipo Object el cual recoge el codigo DH de equipo de medida
     */
    public Object CodigoDHEquipoDeMedida;

    /**
     * Atributo tipo Object el cual recoge el codigo de contador de accesibilidad
     */
    public Object CodigoAccesibilidadContador;

    /**
     * Atributo tipo String el cual recoge el codigo PS contratable
     */
    public String CodigoPSContratable;

    /**
     * Atributo tipo Object el cual recoge el motivo de estado no contratable
     */
    public Object MotivoEstadoNoContratable;

    /**
     * Atributo tipo Object el cual recoge el codigo de medido de tension
     */
    public Object CodigoTensionMedida;

    /**
     * Atributo tipo Object el cual recoge el codigo de clase de expediente
     */
    public Object CodigoClaseExpediente;

    /**
     * Atributo tipo Object el cual recoge el codigo del motivo del expediente
     */
    public Object CodigoMotivoExpediente;

    /**
     * Atributo tipo Object el cual recoge el codigo de tipo de suministro
     */
    public Object CodigoTipoSuministro;

    /**
     * Atributo tipo String el cual recoge la aplicacion de bono social
     */
    public String AplicacionBonoSocial;

    /**
     * Atributo tipo String el cual recoge el des provinca PS
     */
    public String DesProvinciaPS;

    /**
     * Atributo tipo String el cual recoge el des minicipio PS
     */
    public String DesMunicipioPS;

    /**
     * Atributo tipo Object el cual recoge el tipo de via PS
     */
    public Object TipoViaPS;

    /**
     * Atributo tipo object el cual recoge la via PS
     */
    public Object ViaPS;

    /**
     * Atributo tipo Object el cual recoge el numero de finca PS
     */
    public Object NumFincaPS;

    /**
     * Atributo tipo Object el cual recoge el portal PS
     */
    public Object PortalPS;

    /**
     * Atributo tipo Object el cual recoge la escalera PS
     */
    public Object EscaleraPS;

    /**
     * Atributo tipo Object el cual recoge el piso PS
     */
    public Object PisoPS;

    /**
     * Atributo tipo Object el cual recoge la puesta PS
     */
    public Object PuertaPS;

    /**
     * Atributo tipo Object el cual recoge el codigo de presion
     */
    public Object CodigoPresion;

    /**
     * Atributo tipo Object el cual recoge el codigo de peaje en vigor
     */
    public Object CodigoPeajeEnVigor;

    /**
     * Atributo tipo Object el cual recoge el caudal maximo diario en Wh
     */
    public Object CaudalMaximoDiarioEnWh;

    /**
     * Atributo tipo Object el cual recoge el horario del caudal en Wh
     */
    public Object CaudalHorarioEnWh;

    /**
     * Atributo tipo Object el cual recoge el derecho TUR
     */
    public Object DerechoTUR;

    /**
     * Atributo tipo Object el cual recoge la fecha de la ultima inspeccion
     */
    public Object FechaUltimaInspeccion;

    /**
     * Atributo tipo Object el cual recoge el codigo de resultado de inspeccion
     */
    public Object CodigoResultadoInspeccion;

    /**
     * Atributo tipo Object el cual recoge el codigo del contador
     */
    public Object CodigoContador;

    /**
     * Atributo tipo Object el cual recoge el calibre del contador
     */
    public Object CalibreContador;

    /**
     * Atributo tipo Object el cual recoge el tipo de contador
     */
    public Object TipoContador;

    /**
     * Atributo tipo Object el cual recoge la propiedad del equipo medida
     */
    public Object PropiedadEquipoMedida;

    /**
     * Atributo tipo Object el cual recoge el codigo de telemedida
     */
    public Object CodigoTelemedida;

    /**
     * Atributo tipo Object el cual recoge el id del tipo de titular
     */
    public Object IdTipoTitular;

    /**
     * Atributo tipo Object el cual recoge el id del titular
     */
    public Object IdTitular;

    /**
     * Atributo tipo Object el cual recoge del nombre del titular
     */
    public Object NombreTitular;

    /**
     * Atributo tipo Object el cual recoge el primer apellido del titular
     */
    public Object Apellido1Titular;

    /**
     * Atributo tipo Object el cual recoge el segundo apellido del titular
     */
    public Object Apellido2Titular;

    /**
     * Atributo tipo Object el cual recoge el codigo de provincia del titular
     */
    public Object CodigoProvinciaTitular;

    /**
     * Atributo tipo Object el cual recoge el des de provincia del titular
     */
    public Object DesProvinciaTitular;

    /**
     * Atributo tipo Object el cual recoge el codigo postal del titular
     */
    public Object CodigoPostalTitular;

    /**
     * Atributo tipo Object el cual recoge el municipio del titular
     */
    public Object MunicipioTitular;

    /**
     * Atributo tipo Object el cual recoge el des de municipio del titular
     */
    public Object DesMunicipioTitular;

    /**
     * Atributo tipo Object el cual recoge el tipo de via del titular
     */
    public Object TipoViaTitular;

    /**
     * Atributo tipo Object el cual recoge la via del titular
     */
    public Object ViaTitular;

    /**
     * Atributo tipo Object el cual recoge el numero de finca del titular
     */
    public Object NumFincaTitular;

    /**
     * Atributo tipo Object el cual recoge el portal del titular
     */
    public Object PortalTitular;

    /**
     * Atributo tipo Object el cual recoge la escalera del titular
     */
    public Object EscaleraTitular;

    /**
     * Atributo tipo Object el cual recoge el piso del titular
     */
    public Object PisoTitular;

    /**
     * Atributo tipo v el cual recoge la puerta del titular
     */
    public Object PuertaTitular;

    /**
     * Atributo tipo Object el cual recoge el tipo de corrector
     */
    public Object TipoCorrector;

    /**
     * Atributo tipo Object el cual recoge el conectado de la plante de satelite
     */
    public Object ConectadoPlantaSatelite;

    /**
     * Atributo tipo Object el cual recoge el pctd
     */
    public Object Pctd;

    /**
     * Atributo tipo Object el cual recoge la medida de la presion
     */
    public Object PresionMedida;

    /**
     * Atributo tipo String el cual recoge el distri segun tarifa CP
     */
    public String DistriTarifaCP;

    /**
     * Atributo tipo String el cual recoge el distri segun tarifa
     */
    public String DistriTarifa;

    /**
     * Atributo tipo String el cual recoge el distri CP
     */
    public String DistriCP;

    /**
     * Atributo tipo String el cual recoge la tarifa CP
     */
    public String TarifaCP;

    /**
     * Atributo tipo String el cual recoge el distri segun ciudad
     */
    public String DistriCiudad;

    /**
     * Atributo tipo String el cual recoge la tarifa segun ciudad
     */
    public String TarifaCiudad;

    /**
     * Atributo tipo String el cual recoge el CP segun ciudad
     */
    public String CpCiudad;

    /**
     * Atributo tipo String el cual recoge el distri segun provincia
     */
    public String DistriProvincia;

    /**
     * Atributo tipo String el cual recoge la tarifa segun provincia
     */
    public String TarifaProvincia;

    /**
     * Atributo tipo String el cual recoge el CP segun provincia
     */
    public String CpProvincia;

    /**
     * Atributo tipo Object el cual recoge el distri segun nombre
     */
    public Object DistriNombre;

    /**
     * Atributo tipo Object el cual recoge tarifa segun nombre
     */
    public Object TarifaNombre;

    /**
     * Atributo tipo Object el cual recoge CP segun nombre
     */
    public Object CpNombre;

    /**
     * Atributo tipo Object el cual recoge el nombre del titular completo
     */
    public Object NombreCompletoTitular;

    /**
     * Atributo tipo String el cual recoge el nombre de la ciudad
     */
    public String CiudadNombre;
    //endregion
    //region Constructores
    //Constructores

    /**
     * Constructor sin ningun tipo de dato o por defecto
     */
    public ClientesSips() {
    }

    /**
     * Este constructor contiene todos los atributos es decir este constructor es el mas completo de todos
     * @param codigoCUPS dato tipo String
     * @param codigoEmpresaDistribuidora dato tipo String
     * @param nombreEmpresaDistribuidora dato tipo String
     * @param codigoPostalPS dato tipo String
     * @param municipioPS dato tipo String
     * @param codigoProvinciaPS dato tipo String
     * @param fechaAltaSuministro dato tipo String
     * @param codigoTarifaATREnVigor dato tipo String
     * @param codigoTensionV
     * @param potenciaMaximaBIEW dato tipo double
     * @param potenciaMaximaAPMW dato tipo double
     * @param codigoClasificacionPS dato tipo String
     * @param codigoDisponibilidadICP dato tipo String
     * @param tipoPerfilConsumo dato tipo String
     * @param valorDerechosExtensionW dato tipo String
     * @param valorDerechosAccesoW dato tipo String
     * @param codigoPropiedadEquipoMedida dato tipo String
     * @param codigoPropiedadICP dato tipo String
     * @param potenciasContratadasEnWP1 dato tipo double
     * @param potenciasContratadasEnWP2 dato tipo double
     * @param potenciasContratadasEnWP3 dato tipo double
     * @param potenciasContratadasEnWP4 dato tipo double
     * @param potenciasContratadasEnWP5 dato tipo double
     * @param potenciasContratadasEnWP6 dato tipo double
     * @param fechaUltimoMovimientoContrato dato tipo String
     * @param fechaUltimoCambioComercializador dato tipo String
     * @param fechaLimiteDerechosReconocidos dato tipo String
     * @param fechaUltimaLectura dato tipo String
     * @param informacionImpagos dato tipo Object
     * @param importeDepositoGarantiaEuros dato tipo Object
     * @param tipoIdTitular dato tipo String
     * @param esViviendaHabitual dato tipo String
     * @param codigoComercializadora dato tipo Object
     * @param codigoTelegestion dato tipo String
     * @param codigoFasesEquipoMedida dato tipo String
     * @param codigoAutoconsumo dato tipo String
     * @param codigoTipoContrato dato tipo Object
     * @param codigoPeriodicidadFacturacion dato tipo Object
     * @param codigoBIE dato tipo Object
     * @param fechaEmisionBIE dato tipo Object
     * @param fechaCaducidadBIE dato tipo Object
     * @param codigoAPM dato tipo Object
     * @param fechaEmisionAPM dato tipo Object
     * @param fechaCaducidadAPM dato tipo Object
     * @param relacionTransformacionIntensidad dato tipo Object
     * @param cnae dato tipo String
     * @param codigoModoControlPotencia dato tipo String
     * @param potenciaCGPW dato tipo Object
     * @param codigoDHEquipoDeMedida dato tipo Object
     * @param codigoAccesibilidadContador dato tipo Object
     * @param codigoPSContratable dato tipo String
     * @param motivoEstadoNoContratable dato tipo Object
     * @param codigoTensionMedida dato tipo Object
     * @param codigoClaseExpediente dato tipo Object
     * @param codigoMotivoExpediente dato tipo Object
     * @param codigoTipoSuministro dato tipo Object
     * @param aplicacionBonoSocial dato tipo String
     * @param desProvinciaPS dato tipo String
     * @param desMunicipioPS dato tipo String
     * @param tipoViaPS dato tipo Object
     * @param viaPS dato tipo Object
     * @param numFincaPS dato tipo Object
     * @param portalPS dato tipo Object
     * @param escaleraPS dato tipo Object
     * @param pisoPS dato tipo Object
     * @param puertaPS dato tipo Object
     * @param codigoPresion dato tipo Object
     * @param codigoPeajeEnVigor dato tipo Object
     * @param caudalMaximoDiarioEnWh dato tipo Object
     * @param caudalHorarioEnWh dato tipo Object
     * @param derechoTUR dato tipo Object
     * @param fechaUltimaInspeccion dato tipo Object
     * @param codigoResultadoInspeccion dato tipo Object
     * @param codigoContador dato tipo Object
     * @param calibreContador dato tipo Object
     * @param tipoContador dato tipo Object
     * @param propiedadEquipoMedida dato tipo Object
     * @param codigoTelemedida dato tipo Object
     * @param idTipoTitular dato tipo Object
     * @param idTitular dato tipo Object
     * @param nombreTitular dato tipo Object
     * @param apellido1Titular dato tipo Object
     * @param apellido2Titular dato tipo Object
     * @param codigoProvinciaTitular dato tipo Object
     * @param desProvinciaTitular dato tipo Object
     * @param codigoPostalTitular dato tipo Object
     * @param municipioTitular dato tipo Object
     * @param desMunicipioTitular dato tipo Object
     * @param tipoViaTitular dato tipo Object
     * @param viaTitular dato tipo Object
     * @param numFincaTitular dato tipo Object
     * @param portalTitular dato tipo Object
     * @param escaleraTitular dato tipo Object
     * @param pisoTitular dato tipo Object
     * @param puertaTitular dato tipo Object
     * @param tipoCorrector dato tipo Object
     * @param conectadoPlantaSatelite dato tipo Object
     * @param pctd dato tipo Object
     * @param presionMedida dato tipo Object
     * @param distriTarifaCP dato tipo String
     * @param distriTarifa dato tipo String
     * @param distriCP dato tipo String
     * @param tarifaCP dato tipo String
     * @param distriCiudad dato tipo String
     * @param tarifaCiudad dato tipo String
     * @param cpCiudad dato tipo String
     * @param distriProvincia dato tipo String
     * @param tarifaProvincia dato tipo String
     * @param cpProvincia dato tipo String
     * @param distriNombre dato tipo Object
     * @param tarifaNombre dato tipo Object
     * @param cpNombre dato tipo Object
     * @param nombreCompletoTitular dato tipo Object
     * @param ciudadNombre dato tipo String
     */
    public ClientesSips(String codigoCUPS, String codigoEmpresaDistribuidora, String nombreEmpresaDistribuidora, String codigoPostalPS, String municipioPS, String codigoProvinciaPS, String fechaAltaSuministro, String codigoTarifaATREnVigor, String codigoTensionV, double potenciaMaximaBIEW, double potenciaMaximaAPMW, String codigoClasificacionPS, String codigoDisponibilidadICP, String tipoPerfilConsumo, String valorDerechosExtensionW, String valorDerechosAccesoW, String codigoPropiedadEquipoMedida, String codigoPropiedadICP, double potenciasContratadasEnWP1, double potenciasContratadasEnWP2, double potenciasContratadasEnWP3, double potenciasContratadasEnWP4, double potenciasContratadasEnWP5, double potenciasContratadasEnWP6, String fechaUltimoMovimientoContrato, String fechaUltimoCambioComercializador, String fechaLimiteDerechosReconocidos, String fechaUltimaLectura, Object informacionImpagos, Object importeDepositoGarantiaEuros, String tipoIdTitular, String esViviendaHabitual, Object codigoComercializadora, String codigoTelegestion, String codigoFasesEquipoMedida, String codigoAutoconsumo, Object codigoTipoContrato, Object codigoPeriodicidadFacturacion, Object codigoBIE, Object fechaEmisionBIE, Object fechaCaducidadBIE, Object codigoAPM, Object fechaEmisionAPM, Object fechaCaducidadAPM, Object relacionTransformacionIntensidad, String cnae, String codigoModoControlPotencia, Object potenciaCGPW, Object codigoDHEquipoDeMedida, Object codigoAccesibilidadContador, String codigoPSContratable, Object motivoEstadoNoContratable, Object codigoTensionMedida, Object codigoClaseExpediente, Object codigoMotivoExpediente, Object codigoTipoSuministro, String aplicacionBonoSocial, String desProvinciaPS, String desMunicipioPS, Object tipoViaPS, Object viaPS, Object numFincaPS, Object portalPS, Object escaleraPS, Object pisoPS, Object puertaPS, Object codigoPresion, Object codigoPeajeEnVigor, Object caudalMaximoDiarioEnWh, Object caudalHorarioEnWh, Object derechoTUR, Object fechaUltimaInspeccion, Object codigoResultadoInspeccion, Object codigoContador, Object calibreContador, Object tipoContador, Object propiedadEquipoMedida, Object codigoTelemedida, Object idTipoTitular, Object idTitular, Object nombreTitular, Object apellido1Titular, Object apellido2Titular, Object codigoProvinciaTitular, Object desProvinciaTitular, Object codigoPostalTitular, Object municipioTitular, Object desMunicipioTitular, Object tipoViaTitular, Object viaTitular, Object numFincaTitular, Object portalTitular, Object escaleraTitular, Object pisoTitular, Object puertaTitular, Object tipoCorrector, Object conectadoPlantaSatelite, Object pctd, Object presionMedida, String distriTarifaCP, String distriTarifa, String distriCP, String tarifaCP, String distriCiudad, String tarifaCiudad, String cpCiudad, String distriProvincia, String tarifaProvincia, String cpProvincia, Object distriNombre, Object tarifaNombre, Object cpNombre, Object nombreCompletoTitular, String ciudadNombre) {
        CodigoCUPS = codigoCUPS;
        CodigoEmpresaDistribuidora = codigoEmpresaDistribuidora;
        NombreEmpresaDistribuidora = nombreEmpresaDistribuidora;
        CodigoPostalPS = codigoPostalPS;
        MunicipioPS = municipioPS;
        CodigoProvinciaPS = codigoProvinciaPS;
        FechaAltaSuministro = fechaAltaSuministro;
        CodigoTarifaATREnVigor = codigoTarifaATREnVigor;
        CodigoTensionV = codigoTensionV;
        PotenciaMaximaBIEW = potenciaMaximaBIEW;
        PotenciaMaximaAPMW = potenciaMaximaAPMW;
        CodigoClasificacionPS = codigoClasificacionPS;
        CodigoDisponibilidadICP = codigoDisponibilidadICP;
        TipoPerfilConsumo = tipoPerfilConsumo;
        ValorDerechosExtensionW = valorDerechosExtensionW;
        ValorDerechosAccesoW = valorDerechosAccesoW;
        CodigoPropiedadEquipoMedida = codigoPropiedadEquipoMedida;
        CodigoPropiedadICP = codigoPropiedadICP;
        PotenciasContratadasEnWP1 = potenciasContratadasEnWP1;
        PotenciasContratadasEnWP2 = potenciasContratadasEnWP2;
        PotenciasContratadasEnWP3 = potenciasContratadasEnWP3;
        PotenciasContratadasEnWP4 = potenciasContratadasEnWP4;
        PotenciasContratadasEnWP5 = potenciasContratadasEnWP5;
        PotenciasContratadasEnWP6 = potenciasContratadasEnWP6;
        FechaUltimoMovimientoContrato = fechaUltimoMovimientoContrato;
        FechaUltimoCambioComercializador = fechaUltimoCambioComercializador;
        FechaLimiteDerechosReconocidos = fechaLimiteDerechosReconocidos;
        FechaUltimaLectura = fechaUltimaLectura;
        InformacionImpagos = informacionImpagos;
        ImporteDepositoGarantiaEuros = importeDepositoGarantiaEuros;
        TipoIdTitular = tipoIdTitular;
        EsViviendaHabitual = esViviendaHabitual;
        CodigoComercializadora = codigoComercializadora;
        CodigoTelegestion = codigoTelegestion;
        CodigoFasesEquipoMedida = codigoFasesEquipoMedida;
        CodigoAutoconsumo = codigoAutoconsumo;
        CodigoTipoContrato = codigoTipoContrato;
        CodigoPeriodicidadFacturacion = codigoPeriodicidadFacturacion;
        CodigoBIE = codigoBIE;
        FechaEmisionBIE = fechaEmisionBIE;
        FechaCaducidadBIE = fechaCaducidadBIE;
        CodigoAPM = codigoAPM;
        FechaEmisionAPM = fechaEmisionAPM;
        FechaCaducidadAPM = fechaCaducidadAPM;
        RelacionTransformacionIntensidad = relacionTransformacionIntensidad;
        Cnae = cnae;
        CodigoModoControlPotencia = codigoModoControlPotencia;
        PotenciaCGPW = potenciaCGPW;
        CodigoDHEquipoDeMedida = codigoDHEquipoDeMedida;
        CodigoAccesibilidadContador = codigoAccesibilidadContador;
        CodigoPSContratable = codigoPSContratable;
        MotivoEstadoNoContratable = motivoEstadoNoContratable;
        CodigoTensionMedida = codigoTensionMedida;
        CodigoClaseExpediente = codigoClaseExpediente;
        CodigoMotivoExpediente = codigoMotivoExpediente;
        CodigoTipoSuministro = codigoTipoSuministro;
        AplicacionBonoSocial = aplicacionBonoSocial;
        DesProvinciaPS = desProvinciaPS;
        DesMunicipioPS = desMunicipioPS;
        TipoViaPS = tipoViaPS;
        ViaPS = viaPS;
        NumFincaPS = numFincaPS;
        PortalPS = portalPS;
        EscaleraPS = escaleraPS;
        PisoPS = pisoPS;
        PuertaPS = puertaPS;
        CodigoPresion = codigoPresion;
        CodigoPeajeEnVigor = codigoPeajeEnVigor;
        CaudalMaximoDiarioEnWh = caudalMaximoDiarioEnWh;
        CaudalHorarioEnWh = caudalHorarioEnWh;
        DerechoTUR = derechoTUR;
        FechaUltimaInspeccion = fechaUltimaInspeccion;
        CodigoResultadoInspeccion = codigoResultadoInspeccion;
        CodigoContador = codigoContador;
        CalibreContador = calibreContador;
        TipoContador = tipoContador;
        PropiedadEquipoMedida = propiedadEquipoMedida;
        CodigoTelemedida = codigoTelemedida;
        IdTipoTitular = idTipoTitular;
        IdTitular = idTitular;
        NombreTitular = nombreTitular;
        Apellido1Titular = apellido1Titular;
        Apellido2Titular = apellido2Titular;
        CodigoProvinciaTitular = codigoProvinciaTitular;
        DesProvinciaTitular = desProvinciaTitular;
        CodigoPostalTitular = codigoPostalTitular;
        MunicipioTitular = municipioTitular;
        DesMunicipioTitular = desMunicipioTitular;
        TipoViaTitular = tipoViaTitular;
        ViaTitular = viaTitular;
        NumFincaTitular = numFincaTitular;
        PortalTitular = portalTitular;
        EscaleraTitular = escaleraTitular;
        PisoTitular = pisoTitular;
        PuertaTitular = puertaTitular;
        TipoCorrector = tipoCorrector;
        ConectadoPlantaSatelite = conectadoPlantaSatelite;
        Pctd = pctd;
        PresionMedida = presionMedida;
        DistriTarifaCP = distriTarifaCP;
        DistriTarifa = distriTarifa;
        DistriCP = distriCP;
        TarifaCP = tarifaCP;
        DistriCiudad = distriCiudad;
        TarifaCiudad = tarifaCiudad;
        CpCiudad = cpCiudad;
        DistriProvincia = distriProvincia;
        TarifaProvincia = tarifaProvincia;
        CpProvincia = cpProvincia;
        DistriNombre = distriNombre;
        TarifaNombre = tarifaNombre;
        CpNombre = cpNombre;
        NombreCompletoTitular = nombreCompletoTitular;
        CiudadNombre = ciudadNombre;
    }
    //endregion
    //region Getter&Setter
    //Getters y Setters

    /**
     * Devuelve un String para el codigo cups de los clientes sips
     * @return
     */
    public String getCodigoCUPS() {
        return CodigoCUPS;
    }

    /**
     * Llena el campo codigo cups mediante un argumento String que se pasa
     * @param codigoCUPS este es el argumento que se pasa para rellenar el campo codigo cups
     */
    public void setCodigoCUPS(String codigoCUPS) {
        CodigoCUPS = codigoCUPS;
    }

    /**
     * Devuelve un String para el codigo de empresa distribuidora de los clientes sips
     * @return
     */
    public String getCodigoEmpresaDistribuidora() {
        return CodigoEmpresaDistribuidora;
    }

    /**
     * Llena el campo codigo de empresa distribuidora mediante un argumento String que se pasa
     * @param codigoEmpresaDistribuidora este es el argumento que se pasa para rellenar el campo codigo de empresa distibuidora
     */
    public void setCodigoEmpresaDistribuidora(String codigoEmpresaDistribuidora) {
        CodigoEmpresaDistribuidora = codigoEmpresaDistribuidora;
    }

    /**
     * Devuelve un String para el nombre de empresa distribuidora de los clientes sips
     * @return
     */
    public String getNombreEmpresaDistribuidora() {
        return NombreEmpresaDistribuidora;
    }

    /**
     * Llena el campo nombre de empresa distribuidora mediante un argumento String que se pasa
     * @param nombreEmpresaDistribuidora este es el argumento que se pasa para rellenar el campo nombre de empresa distibuidora
     */
    public void setNombreEmpresaDistribuidora(String nombreEmpresaDistribuidora) {
        NombreEmpresaDistribuidora = nombreEmpresaDistribuidora;
    }

    /**
     * Devuelve un String para el codigo postal PS de los clientes sips
     * @return
     */
    public String getCodigoPostalPS() {
        return CodigoPostalPS;
    }

    /**
     * Llena el campo codigo postal PS mediante un argumento String que se pasa
     * @param codigoPostalPS este es el argumento que se pasa para rellenar el campo codigo postal PS
     */
    public void setCodigoPostalPS(String codigoPostalPS) {
        CodigoPostalPS = codigoPostalPS;
    }

    /**
     * Devuelve un String para el municipio PS de los clientes sips
     * @return
     */
    public String getMunicipioPS() {
        return MunicipioPS;
    }

    /**
     * Llena el campo municipio PS mediante un argumento String que se pasa
     * @param municipioPS este es el argumento que se pasa para rellenar el campo municipio PS
     */
    public void setMunicipioPS(String municipioPS) {
        MunicipioPS = municipioPS;
    }

    /**
     * Devuelve un String para el codigo provincia PS de los clientes sips
     * @return
     */
    public String getCodigoProvinciaPS() {
        return CodigoProvinciaPS;
    }

    /**
     * Llena el campo codigo provincia PS mediante un argumento String que se pasa
     * @param codigoProvinciaPS este es el argumento que se pasa para rellenar el campo codigo provincia PS
     */
    public void setCodigoProvinciaPS(String codigoProvinciaPS) {
        CodigoProvinciaPS = codigoProvinciaPS;
    }

    /**
     * Devuelve un String para la fecha de alta de los suministros de los clientes sips
     * @return
     */
    public String getFechaAltaSuministro() {
        return FechaAltaSuministro;
    }

    /**
     * Llena el campo fecha de alta de los suministros mediante un argumento String que se pasa
     * @param fechaAltaSuministro este es el argumento que se pasa para rellenar el campo fecha de alta de los suministros
     */
    public void setFechaAltaSuministro(String fechaAltaSuministro) {
        FechaAltaSuministro = fechaAltaSuministro;
    }

    /**
     * Devuelve un String para el codigo de la tarifa ATR en vigor de los clientes sips
     * @return
     */
    public String getCodigoTarifaATREnVigor() {
        return CodigoTarifaATREnVigor;
    }

    /**
     * Llena el campo el codigo de la tarifa ATR en vigor mediante un argumento String que se pasa
     * @param codigoTarifaATREnVigor este es el argumento que se pasa para rellenar el campo codigo de la tarifa ATR en vigor
     */
    public void setCodigoTarifaATREnVigor(String codigoTarifaATREnVigor) {
        CodigoTarifaATREnVigor = codigoTarifaATREnVigor;
    }

    /**
     * Devuelve un String para el codigo de de tension V de los clientes sips
     * @return
     */
    public String getCodigoTensionV() {
        return CodigoTensionV;
    }

    /**
     * Llena el campo el codigo de de tension V mediante un argumento String que se pasa
     * @param codigoTensionV este es el argumento que se pasa para rellenar el campo codigo de de tension V
     */
    public void setCodigoTensionV(String codigoTensionV) {
        CodigoTensionV = codigoTensionV;
    }

    /**
     * Devuelve un double para la potencia maxima BIEW de los clientes sips
     * @return
     */
    public double getPotenciaMaximaBIEW() {
        return PotenciaMaximaBIEW;
    }

    /**
     * Llena el campo potencia maxima BIEW mediante un argumento double que se pasa
     * @param potenciaMaximaBIEW este es el argumento que se pasa para rellenar el campo potencia maxima BIEW
     */
    public void setPotenciaMaximaBIEW(double potenciaMaximaBIEW) {
        PotenciaMaximaBIEW = potenciaMaximaBIEW;
    }

    /**
     * Devuelve un double para la potencia maxima APMW de los clientes sips
     * @return
     */
    public double getPotenciaMaximaAPMW() {
        return PotenciaMaximaAPMW;
    }

    /**
     * Llena el campo potencia maxima AMPW mediante un argumento double que se pasa
     * @param potenciaMaximaAPMW este es el argumento que se pasa para rellenar el campo potencia maxima APMW
     */
    public void setPotenciaMaximaAPMW(double potenciaMaximaAPMW) {
        PotenciaMaximaAPMW = potenciaMaximaAPMW;
    }

    /**
     * Devuelve un String para el codigo de clasificacion PS de los clientes sips
     * @return
     */
    public String getCodigoClasificacionPS() {
        return CodigoClasificacionPS;
    }

    /**
     * Llena el campo codigo de clasificacion PS mediante un argumento String que se pasa
     * @param codigoClasificacionPS este es el argumento que se pasa para rellenar el campo codigo de clasificacion PS
     */
    public void setCodigoClasificacionPS(String codigoClasificacionPS) {
        CodigoClasificacionPS = codigoClasificacionPS;
    }

    /**
     * Devuelve un String para el codigo de disponibilidad ICP de los clientes sips
     * @return
     */
    public String getCodigoDisponibilidadICP() {
        return CodigoDisponibilidadICP;
    }

    /**
     * Llena el campo codigo de disponibilidad ICP mediante un argumento String que se pasa
     * @param codigoDisponibilidadICP este es el argumento que se pasa para rellenar el campo codigo de disponibilidad ICP
     */
    public void setCodigoDisponibilidadICP(String codigoDisponibilidadICP) {
        CodigoDisponibilidadICP = codigoDisponibilidadICP;
    }

    /**
     * Devuelve un String para el tipo de perfil de cosumo de los clientes sips
     * @return
     */
    public String getTipoPerfilConsumo() {
        return TipoPerfilConsumo;
    }

    /**
     * Llena el campo tipo de perfil de cosumo mediante un argumento String que se pasa
     * @param tipoPerfilConsumo este es el argumento que se pasa para rellenar el campo tipo de perfil de cosumo
     */
    public void setTipoPerfilConsumo(String tipoPerfilConsumo) {
        TipoPerfilConsumo = tipoPerfilConsumo;
    }

    /**
     * Devuelve un String para el valor de derechos de extension W de los clientes sips
     * @return
     */
    public String getValorDerechosExtensionW() {
        return ValorDerechosExtensionW;
    }

    /**
     * Llena el campo valor de derechos de extension W mediante un argumento String que se pasa
     * @param valorDerechosExtensionW este es el argumento que se pasa para rellenar el campo valor de derechos de extension W
     */
    public void setValorDerechosExtensionW(String valorDerechosExtensionW) {
        ValorDerechosExtensionW = valorDerechosExtensionW;
    }

    /**
     * Devuelve un String para el valor de derechos de acceso W de los clientes sips
     * @return
     */
    public String getValorDerechosAccesoW() {
        return ValorDerechosAccesoW;
    }

    /**
     * Llena el campo valor de derechos de acceso W mediante un argumento String que se pasa
     * @param valorDerechosAccesoW este es el argumento que se pasa para rellenar el campo valor de derechos de acceso W
     */
    public void setValorDerechosAccesoW(String valorDerechosAccesoW) {
        ValorDerechosAccesoW = valorDerechosAccesoW;
    }

    /**
     * Devuelve un String para el codigo de propiedad de equipo medida de los clientes sips
     * @return
     */
    public String getCodigoPropiedadEquipoMedida() {
        return CodigoPropiedadEquipoMedida;
    }

    /**
     * Llena el campo codigo de propiedad de equipo medida mediante un argumento String que se pasa
     * @param codigoPropiedadEquipoMedida este es el argumento que se pasa para rellenar el campo codigo de propiedad de equipo medida
     */
    public void setCodigoPropiedadEquipoMedida(String codigoPropiedadEquipoMedida) {
        CodigoPropiedadEquipoMedida = codigoPropiedadEquipoMedida;
    }

    /**
     * Devuelve un String para el codigo de propiedad ICP medida de los clientes sips
     * @return
     */
    public String getCodigoPropiedadICP() {
        return CodigoPropiedadICP;
    }

    /**
     * Llena el campo codigo de propiedad de equipo ICP mediante un argumento String que se pasa
     * @param codigoPropiedadICP este es el argumento que se pasa para rellenar el campo codigo de propiedad de equipo ICP
     */
    public void setCodigoPropiedadICP(String codigoPropiedadICP) {
        CodigoPropiedadICP = codigoPropiedadICP;
    }

    /**
     * Devuelve un double para las potencias contratadas en WP1 medida de los clientes sips
     * @return
     */
    public double getPotenciasContratadasEnWP1() {
        return PotenciasContratadasEnWP1;
    }

    /**
     * Llena el campo potencias contratadas en WP1 mediante un argumento double que se pasa
     * @param potenciasContratadasEnWP1 este es el argumento que se pasa para rellenar el campo potencias contratadas en WP1
     */
    public void setPotenciasContratadasEnWP1(double potenciasContratadasEnWP1) {
        PotenciasContratadasEnWP1 = potenciasContratadasEnWP1;
    }

    /**
     * Devuelve un double para las potencias contratadas en WP2 medida de los clientes sips
     * @return
     */
    public double getPotenciasContratadasEnWP2() {
        return PotenciasContratadasEnWP2;
    }

    /**
     * Llena el campo potencias contratadas en WP2 mediante un argumento double que se pasa
     * @param potenciasContratadasEnWP2 este es el argumento que se pasa para rellenar el campo potencias contratadas en WP2
     */
    public void setPotenciasContratadasEnWP2(double potenciasContratadasEnWP2) {
        PotenciasContratadasEnWP2 = potenciasContratadasEnWP2;
    }

    /**
     * Devuelve un double para las potencias contratadas en WP3 medida de los clientes sips
     * @return
     */
    public double getPotenciasContratadasEnWP3() {
        return PotenciasContratadasEnWP3;
    }

    /**
     * Llena el campo potencias contratadas en WP3 mediante un argumento double que se pasa
     * @param potenciasContratadasEnWP3 este es el argumento que se pasa para rellenar el campo potencias contratadas en WP3
     */
    public void setPotenciasContratadasEnWP3(double potenciasContratadasEnWP3) {
        PotenciasContratadasEnWP3 = potenciasContratadasEnWP3;
    }

    /**
     * Devuelve un double para las potencias contratadas en WP4 medida de los clientes sips
     * @return
     */
    public double getPotenciasContratadasEnWP4() {
        return PotenciasContratadasEnWP4;
    }

    /**
     * Llena el campo potencias contratadas en WP4 mediante un argumento double que se pasa
     * @param potenciasContratadasEnWP4 este es el argumento que se pasa para rellenar el campo potencias contratadas en WP4
     */
    public void setPotenciasContratadasEnWP4(double potenciasContratadasEnWP4) {
        PotenciasContratadasEnWP4 = potenciasContratadasEnWP4;
    }

    /**
     * Devuelve un double para las potencias contratadas en WP5 medida de los clientes sips
     * @return
     */
    public double getPotenciasContratadasEnWP5() {
        return PotenciasContratadasEnWP5;
    }

    /**
     * Llena el campo potencias contratadas en WP5 mediante un argumento double que se pasa
     * @param potenciasContratadasEnWP5 este es el argumento que se pasa para rellenar el campo potencias contratadas en WP5
     */
    public void setPotenciasContratadasEnWP5(double potenciasContratadasEnWP5) {
        PotenciasContratadasEnWP5 = potenciasContratadasEnWP5;
    }

    /**
     * Devuelve un double para las potencias contratadas en WP6 medida de los clientes sips
     * @return
     */
    public double getPotenciasContratadasEnWP6() {
        return PotenciasContratadasEnWP6;
    }

    /**
     * Llena el campo potencias contratadas en WP6 mediante un argumento double que se pasa
     * @param potenciasContratadasEnWP6 este es el argumento que se pasa para rellenar el campo potencias contratadas en WP6
     */
    public void setPotenciasContratadasEnWP6(double potenciasContratadasEnWP6) {
        PotenciasContratadasEnWP6 = potenciasContratadasEnWP6;
    }

    /**
     * Devuelve un String para la fecha del ultimo movimiento del contrato medida de los clientes sips
     * @return
     */
    public String getFechaUltimoMovimientoContrato() {
        return FechaUltimoMovimientoContrato;
    }

    /**
     * Llena el campo fecha del ultimo movimiento del contrato mediante un argumento String que se pasa
     * @param fechaUltimoMovimientoContrato este es el argumento que se pasa para rellenar el campo fecha del ultimo movimiento del contrato
     */
    public void setFechaUltimoMovimientoContrato(String fechaUltimoMovimientoContrato) {
        FechaUltimoMovimientoContrato = fechaUltimoMovimientoContrato;
    }

    /**
     * Devuelve un String para la fecha del ultimo cambio de comercializador del contrato medida de los clientes sips
     * @return
     */
    public String getFechaUltimoCambioComercializador() {
        return FechaUltimoCambioComercializador;
    }

    /**
     * Llena el campo fecha del ultimo cambio de comercializador del contrato mediante un argumento String que se pasa
     * @param fechaUltimoCambioComercializador este es el argumento que se pasa para rellenar el campo fecha del ultimo cambio de comercializador
     */
    public void setFechaUltimoCambioComercializador(String fechaUltimoCambioComercializador) {
        FechaUltimoCambioComercializador = fechaUltimoCambioComercializador;
    }

    /**
     * Devuelve un String para la fecha limite de derechos reconocidos de los clientes sips
     * @return
     */
    public String getFechaLimiteDerechosReconocidos() {
        return FechaLimiteDerechosReconocidos;
    }

    /**
     * Llena el campo fecha limite de derechos reconocidos mediante un argumento String que se pasa
     * @param fechaLimiteDerechosReconocidos este es el argumento que se pasa para rellenar el campo fecha limite de derechos reconocidos
     */
    public void setFechaLimiteDerechosReconocidos(String fechaLimiteDerechosReconocidos) {
        FechaLimiteDerechosReconocidos = fechaLimiteDerechosReconocidos;
    }

    /**
     * Devuelve un String para la fecha de ultima lectura de los clientes sips
     * @return
     */
    public String getFechaUltimaLectura() {
        return FechaUltimaLectura;
    }

    /**
     * Llena el campo fecha de ultima lectura mediante un argumento String que se pasa
     * @param fechaUltimaLectura este es el argumento que se pasa para rellenar el campo fecha del ultimo cambio de comercializador
     */
    public void setFechaUltimaLectura(String fechaUltimaLectura) {
        FechaUltimaLectura = fechaUltimaLectura;
    }

    /**
     * Devuelve un Object para la información de impagos de los clientes sips
     * @return
     */
    public Object getInformacionImpagos() {
        return InformacionImpagos;
    }

    /**
     * Llena el campo información de impagos mediante un argumento Object que se pasa
     * @param informacionImpagos este es el argumento que se pasa para rellenar el campo información de impagos
     */
    public void setInformacionImpagos(Object informacionImpagos) {
        InformacionImpagos = informacionImpagos;
    }

    /**
     * Devuelve un Object para el importe de deposito de garantía en euros de los clientes sips
     * @return
     */
    public Object getImporteDepositoGarantiaEuros() {
        return ImporteDepositoGarantiaEuros;
    }

    /**
     * Llena el campo importe de deposito de garantía en euros mediante un argumento Object que se pasa
     * @param importeDepositoGarantiaEuros este es el argumento que se pasa para rellenar el campo importe de deposito de garantía en euros
     */
    public void setImporteDepositoGarantiaEuros(Object importeDepositoGarantiaEuros) {
        ImporteDepositoGarantiaEuros = importeDepositoGarantiaEuros;
    }

    /**
     * Devuelve un String para el tipo de id del titular de los clientes sips
     * @return
     */
    public String getTipoIdTitular() {
        return TipoIdTitular;
    }

    /**
     * Llena el campo tipo de id del titular mediante un argumento String que se pasa
     * @param tipoIdTitular este es el argumento que se pasa para rellenar el campo tipo de id del titular
     */
    public void setTipoIdTitular(String tipoIdTitular) {
        TipoIdTitular = tipoIdTitular;
    }

    /**
     * Devuelve un String para el tipo de id del titular de los clientes sips
     * @return
     */
    public String getEsViviendaHabitual() {
        return EsViviendaHabitual;
    }

    /**
     * Llena el campo tipo de id del titular mediante un argumento String que se pasa
     * @param esViviendaHabitual este es el argumento que se pasa para rellenar el campo tipo de id del titular
     */
    public void setEsViviendaHabitual(String esViviendaHabitual) {
        EsViviendaHabitual = esViviendaHabitual;
    }

    /**
     * Devuelve un Object para el codigo de comercializador de los clientes sips
     * @return
     */
    public Object getCodigoComercializadora() {
        return CodigoComercializadora;
    }

    /**
     * Llena el campo codigo de comercializador mediante un argumento Object que se pasa
     * @param codigoComercializadora este es el argumento que se pasa para rellenar el campo codigo de comercializador
     */
    public void setCodigoComercializadora(Object codigoComercializadora) {
        CodigoComercializadora = codigoComercializadora;
    }

    /**
     * Devuelve un String para el codigo de telegestion de los clientes sips
     * @return
     */
    public String getCodigoTelegestion() {
        return CodigoTelegestion;
    }

    /**
     * Llena el campo codigo de telegestion mediante un argumento String que se pasa
     * @param codigoTelegestion este es el argumento que se pasa para rellenar el campo codigo de telegestion
     */
    public void setCodigoTelegestion(String codigoTelegestion) {
        CodigoTelegestion = codigoTelegestion;
    }

    /**
     * Devuelve un String para el codigo de la medida de fases de equipo de los clientes sips
     * @return
     */
    public String getCodigoFasesEquipoMedida() {
        return CodigoFasesEquipoMedida;
    }

    /**
     * Llena el campo codigo de la medida de fases de equipo un argumento String que se pasa
     * @param codigoFasesEquipoMedida este es el argumento que se pasa para rellenar el campo codigo de la medida de fases de equipo
     */
    public void setCodigoFasesEquipoMedida(String codigoFasesEquipoMedida) {
        CodigoFasesEquipoMedida = codigoFasesEquipoMedida;
    }

    /**
     * Devuelve un String para el codigo de autoconsumo de los clientes sips
     * @return
     */
    public String getCodigoAutoconsumo() {
        return CodigoAutoconsumo;
    }

    /**
     * Llena el campo codigo de autoconsumo un argumento String que se pasa
     * @param codigoAutoconsumo este es el argumento que se pasa para rellenar el campo codigo de autoconsumo
     */
    public void setCodigoAutoconsumo(String codigoAutoconsumo) {
        CodigoAutoconsumo = codigoAutoconsumo;
    }

    /**
     * Devuelve un Object para el codigo de tipo de contrato de los clientes sips
     * @return
     */
    public Object getCodigoTipoContrato() {
        return CodigoTipoContrato;
    }

    /**
     * Llena el campo codigo de tipo de contrato un argumento Object que se pasa
     * @param codigoTipoContrato este es el argumento que se pasa para rellenar el campo codigo de tipo de contrato
     */
    public void setCodigoTipoContrato(Object codigoTipoContrato) {
        CodigoTipoContrato = codigoTipoContrato;
    }

    /**
     * Devuelve un Object para el codigo de periodicidad de facturación de los clientes sips
     * @return
     */
    public Object getCodigoPeriodicidadFacturacion() {
        return CodigoPeriodicidadFacturacion;
    }

    /**
     * Llena el campo codigo de periodicidad de facturación un argumento Object que se pasa
     * @param codigoPeriodicidadFacturacion este es el argumento que se pasa para rellenar el campo codigo de periodicidad de facturación
     */
    public void setCodigoPeriodicidadFacturacion(Object codigoPeriodicidadFacturacion) {
        CodigoPeriodicidadFacturacion = codigoPeriodicidadFacturacion;
    }

    /**
     * Devuelve un Object para el codigo BIE de los clientes sips
     * @return
     */
    public Object getCodigoBIE() {
        return CodigoBIE;
    }

    /**
     * Llena el campo codigo BIE un argumento Object que se pasa
     * @param codigoBIE este es el argumento que se pasa para rellenar el campo codigo BIE
     */
    public void setCodigoBIE(Object codigoBIE) {
        CodigoBIE = codigoBIE;
    }

    /**
     * Devuelve un Object para la fecha de emisión BIE de los clientes sips
     * @return
     */
    public Object getFechaEmisionBIE() {
        return FechaEmisionBIE;
    }

    /**
     * Llena el campo fecha de emisión BIE un argumento Object que se pasa
     * @param fechaEmisionBIE este es el argumento que se pasa para rellenar el campo fecha de emisión BIE
     */
    public void setFechaEmisionBIE(Object fechaEmisionBIE) {
        FechaEmisionBIE = fechaEmisionBIE;
    }

    /**
     * Devuelve un Object para la fecha de caducidad BIE de los clientes sips
     * @return
     */
    public Object getFechaCaducidadBIE() {
        return FechaCaducidadBIE;
    }

    /**
     * Llena el campo fecha de caducidad BIE un argumento Object que se pasa
     * @param fechaCaducidadBIE este es el argumento que se pasa para rellenar el campo fecha de caducidad BIE
     */
    public void setFechaCaducidadBIE(Object fechaCaducidadBIE) {
        FechaCaducidadBIE = fechaCaducidadBIE;
    }

    /**
     * Devuelve un Object para el codigo AMP de los clientes sips
     * @return
     */
    public Object getCodigoAPM() {
        return CodigoAPM;
    }

    /**
     * Llena el campo codigo AMP un argumento Object que se pasa
     * @param codigoAPM este es el argumento que se pasa para rellenar el campo codigo AMP
     */
    public void setCodigoAPM(Object codigoAPM) {
        CodigoAPM = codigoAPM;
    }

    /**
     * Devuelve un Object para la fecha de emisión AMP de los clientes sips
     * @return
     */
    public Object getFechaEmisionAPM() {
        return FechaEmisionAPM;
    }

    /**
     * Llena el campo fecha de emisión AMP un argumento Object que se pasa
     * @param fechaEmisionAPM este es el argumento que se pasa para rellenar el campo fecha de emisión AMP
     */
    public void setFechaEmisionAPM(Object fechaEmisionAPM) {
        FechaEmisionAPM = fechaEmisionAPM;
    }

    /**
     * Devuelve un Object para la fecha de caducidad AMP de los clientes sips
     * @return
     */
    public Object getFechaCaducidadAPM() {
        return FechaCaducidadAPM;
    }

    /**
     * Llena el campo fecha de caducidad AMP un argumento Object que se pasa
     * @param fechaCaducidadAPM este es el argumento que se pasa para rellenar el campo fecha de caducidad AMP
     */
    public void setFechaCaducidadAPM(Object fechaCaducidadAPM) {
        FechaCaducidadAPM = fechaCaducidadAPM;
    }

    /**
     * Devuelve un Object para la relación de transformación de intensidad de los clientes sips
     * @return
     */
    public Object getRelacionTransformacionIntensidad() {
        return RelacionTransformacionIntensidad;
    }

    /**
     * Llena el campo relación de transformación de intensidad un argumento Object que se pasa
     * @param relacionTransformacionIntensidad este es el argumento que se pasa para rellenar el campo relación de transformación de intensidad
     */
    public void setRelacionTransformacionIntensidad(Object relacionTransformacionIntensidad) {
        RelacionTransformacionIntensidad = relacionTransformacionIntensidad;
    }

    /**
     * Devuelve un String para el Cnae de los clientes sips
     * @return
     */
    public String getCnae() {
        return Cnae;
    }

    /**
     * Llena el campo Cnae un argumento String que se pasa
     * @param cnae este es el argumento que se pasa para rellenar el campo Cnae
     */
    public void setCnae(String cnae) {
        Cnae = cnae;
    }

    /**
     * Devuelve un String para el codigo de modo de control de la potencia de los clientes sips
     * @return
     */
    public String getCodigoModoControlPotencia() {
        return CodigoModoControlPotencia;
    }

    /**
     * Llena el campo codigo de modo de control de la potencia un argumento String que se pasa
     * @param codigoModoControlPotencia este es el argumento que se pasa para rellenar el campo codigo de modo de control de la potencia
     */
    public void setCodigoModoControlPotencia(String codigoModoControlPotencia) {
        CodigoModoControlPotencia = codigoModoControlPotencia;
    }

    /**
     * Devuelve un Object para la potencia CGPW de los clientes sips
     * @return
     */
    public Object getPotenciaCGPW() {
        return PotenciaCGPW;
    }

    /**
     * Llena el campo potencia CGPW un argumento Object que se pasa
     * @param potenciaCGPW este es el argumento que se pasa para rellenar el campo potencia CGPW
     */
    public void setPotenciaCGPW(Object potenciaCGPW) {
        PotenciaCGPW = potenciaCGPW;
    }

    /**
     * Devuelve un Object para el codigo DH de medida del equipo de los clientes sips
     * @return
     */
    public Object getCodigoDHEquipoDeMedida() {
        return CodigoDHEquipoDeMedida;
    }

    /**
     * Llena el campo codigo DH de medida del equipo un argumento String que se pasa
     * @param codigoDHEquipoDeMedida este es el argumento que se pasa para rellenar el campo codigo DH de medida del equipo
     */
    public void setCodigoDHEquipoDeMedida(Object codigoDHEquipoDeMedida) {
        CodigoDHEquipoDeMedida = codigoDHEquipoDeMedida;
    }

    /**
     * Devuelve un Object para el codigo de accesibilidad del contador de los clientes sips
     * @return
     */
    public Object getCodigoAccesibilidadContador() {
        return CodigoAccesibilidadContador;
    }

    /**
     * Llena el campo codigo de accesibilidad del contador un argumento String que se pasa
     * @param codigoAccesibilidadContador este es el argumento que se pasa para rellenar el campo codigo de accesibilidad del contador
     */
    public void setCodigoAccesibilidadContador(Object codigoAccesibilidadContador) {
        CodigoAccesibilidadContador = codigoAccesibilidadContador;
    }

    /**
     * Devuelve un String para el codigo PS contratable de los clientes sips
     * @return
     */
    public String getCodigoPSContratable() {
        return CodigoPSContratable;
    }

    /**
     * Llena el campo codigo PS contratable un argumento String que se pasa
     * @param codigoPSContratable este es el argumento que se pasa para rellenar el campo codigo PS contratable
     */
    public void setCodigoPSContratable(String codigoPSContratable) {
        CodigoPSContratable = codigoPSContratable;
    }

    /**
     * Devuelve un Object para el motivo de estado no controlable de los clientes sips
     * @return
     */
    public Object getMotivoEstadoNoContratable() {
        return MotivoEstadoNoContratable;
    }

    /**
     * Llena el campo motivo de estado no controlable un argumento Object que se pasa
     * @param motivoEstadoNoContratable este es el argumento que se pasa para rellenar el campo motivo de estado no controlable
     */
    public void setMotivoEstadoNoContratable(Object motivoEstadoNoContratable) {
        MotivoEstadoNoContratable = motivoEstadoNoContratable;
    }

    /**
     * Devuelve un Object para el codigo de medida de tensión de los clientes sips
     * @return
     */
    public Object getCodigoTensionMedida() {
        return CodigoTensionMedida;
    }

    /**
     * Llena el campo codigo de medida de tensión un argumento Object que se pasa
     * @param codigoTensionMedida este es el argumento que se pasa para rellenar el campo codigo de medida de tensión
     */
    public void setCodigoTensionMedida(Object codigoTensionMedida) {
        CodigoTensionMedida = codigoTensionMedida;
    }

    /**
     * Devuelve un Object para el codigo de clase de expediente de los clientes sips
     * @return
     */
    public Object getCodigoClaseExpediente() {
        return CodigoClaseExpediente;
    }

    /**
     * Llena el campo codigo de clase de expediente un argumento Object que se pasa
     * @param codigoClaseExpediente este es el argumento que se pasa para rellenar el campo codigo de clase de expediente
     */
    public void setCodigoClaseExpediente(Object codigoClaseExpediente) {
        CodigoClaseExpediente = codigoClaseExpediente;
    }

    /**
     * Devuelve un Object para el codigo de motivo del expediente  de los clientes sips
     * @return
     */
    public Object getCodigoMotivoExpediente() {
        return CodigoMotivoExpediente;
    }

    /**
     * Llena el campo codigo de motivo del expediente un argumento Object que se pasa
     * @param codigoMotivoExpediente este es el argumento que se pasa para rellenar el campo codigo de motivo del expediente
     */
    public void setCodigoMotivoExpediente(Object codigoMotivoExpediente) {
        CodigoMotivoExpediente = codigoMotivoExpediente;
    }

    /**
     * Devuelve un Object para el codigo de tipo de suministro de los clientes sips
     * @return
     */
    public Object getCodigoTipoSuministro() {
        return CodigoTipoSuministro;
    }

    /**
     * Llena el campo codigo de tipo de suministro un argumento Object que se pasa
     * @param codigoTipoSuministro este es el argumento que se pasa para rellenar el campo codigo de tipo de suministro
     */
    public void setCodigoTipoSuministro(Object codigoTipoSuministro) {
        CodigoTipoSuministro = codigoTipoSuministro;
    }

    /**
     * Devuelve un String para la aplicación del bono social de los clientes sips
     * @return
     */
    public String getAplicacionBonoSocial() {
        return AplicacionBonoSocial;
    }

    /**
     * Llena el campo aplicación del bono social un argumento String que se pasa
     * @param aplicacionBonoSocial este es el argumento que se pasa para rellenar el campo aplicación del bono social
     */
    public void setAplicacionBonoSocial(String aplicacionBonoSocial) {
        AplicacionBonoSocial = aplicacionBonoSocial;
    }

    /**
     * Devuelve un String para el des de provincia PS de los clientes sips
     * @return
     */
    public String getDesProvinciaPS() {
        return DesProvinciaPS;
    }

    /**
     * Llena el campo des de provincia PS un argumento String que se pasa
     * @param desProvinciaPS este es el argumento que se pasa para rellenar el campo des de provincia PS
     */
    public void setDesProvinciaPS(String desProvinciaPS) {
        DesProvinciaPS = desProvinciaPS;
    }

    /**
     * Devuelve un String para el des de municipio PS de los clientes sips
     * @return
     */
    public String getDesMunicipioPS() {
        return DesMunicipioPS;
    }

    /**
     * Llena el campo des de municipio PS un argumento String que se pasa
     * @param desMunicipioPS este es el argumento que se pasa para rellenar el campo des de municipio PS
     */
    public void setDesMunicipioPS(String desMunicipioPS) {
        DesMunicipioPS = desMunicipioPS;
    }

    /**
     * Devuelve un Object para el tipo de via PS de los clientes sips
     * @return
     */
    public Object getTipoViaPS() {
        return TipoViaPS;
    }

    /**
     * Llena el campo tipo de via PS un argumento Object que se pasa
     * @param tipoViaPS este es el argumento que se pasa para rellenar el campo tipo de via PS
     */
    public void setTipoViaPS(Object tipoViaPS) {
        TipoViaPS = tipoViaPS;
    }

    /**
     * Devuelve un Object para la via PS de los clientes sips
     * @return
     */
    public Object getViaPS() {
        return ViaPS;
    }

    /**
     * Llena el campo via PS un argumento Object que se pasa
     * @param viaPS este es el argumento que se pasa para rellenar el campo via PS
     */
    public void setViaPS(Object viaPS) {
        ViaPS = viaPS;
    }

    /**
     * Devuelve un Object para el numero de finca PS de los clientes sips
     * @return
     */
    public Object getNumFincaPS() {
        return NumFincaPS;
    }

    /**
     * Llena el campo numero de finca PS un argumento Object que se pasa
     * @param numFincaPS este es el argumento que se pasa para rellenar el campo numero de finca PS
     */
    public void setNumFincaPS(Object numFincaPS) {
        NumFincaPS = numFincaPS;
    }

    /**
     * Devuelve un Object para el portal PS PS de los clientes sips
     * @return
     */
    public Object getPortalPS() {
        return PortalPS;
    }

    /**
     * Llena el campo portal PS un argumento Object que se pasa
     * @param portalPS este es el argumento que se pasa para rellenar el campo portal PS
     */
    public void setPortalPS(Object portalPS) {
        PortalPS = portalPS;
    }

    /**
     * Devuelve un Object para la escalera PS de los clientes sips
     * @return
     */
    public Object getEscaleraPS() {
        return EscaleraPS;
    }

    /**
     * Llena el campo escalera PS un argumento Object que se pasa
     * @param escaleraPS este es el argumento que se pasa para rellenar el campo escalera PS
     */
    public void setEscaleraPS(Object escaleraPS) {
        EscaleraPS = escaleraPS;
    }

    /**
     * Devuelve un Object para el piso PS de los clientes sips
     * @return
     */
    public Object getPisoPS() {
        return PisoPS;
    }

    /**
     * Llena el campo piso PS un argumento Object que se pasa
     * @param pisoPS este es el argumento que se pasa para rellenar el campo piso PS
     */
    public void setPisoPS(Object pisoPS) {
        PisoPS = pisoPS;
    }

    /**
     * Devuelve un Object para el puerta PS de los clientes sips
     * @return
     */
    public Object getPuertaPS() {
        return PuertaPS;
    }

    /**
     * Llena el campo puerta PS un argumento Object que se pasa
     * @param puertaPS este es el argumento que se pasa para rellenar el campo puerta PS
     */
    public void setPuertaPS(Object puertaPS) {
        PuertaPS = puertaPS;
    }

    /**
     * Devuelve un Object para el codigo de presión de los clientes sips
     * @return
     */
    public Object getCodigoPresion() {
        return CodigoPresion;
    }

    /**
     * Llena el campo puerta PS un argumento Object que se pasa
     * @param codigoPresion este es el argumento que se pasa para rellenar el campo puerta PS
     */
    public void setCodigoPresion(Object codigoPresion) {
        CodigoPresion = codigoPresion;
    }

    /**
     * Devuelve un Object para el codigo de presión de los clientes sips
     * @return
     */
    public Object getCodigoPeajeEnVigor() {
        return CodigoPeajeEnVigor;
    }

    /**
     * Llena el campo puerta PS un argumento Object que se pasa
     * @param codigoPeajeEnVigor este es el argumento que se pasa para rellenar el campo puerta PS
     */
    public void setCodigoPeajeEnVigor(Object codigoPeajeEnVigor) {
        CodigoPeajeEnVigor = codigoPeajeEnVigor;
    }

    /**
     * Devuelve un Object para el caudal máximo diario en Wh de los clientes sips
     * @return
     */
    public Object getCaudalMaximoDiarioEnWh() {
        return CaudalMaximoDiarioEnWh;
    }

    /**
     * Llena el campo caudal máximo diario en Wh un argumento Object que se pasa
     * @param caudalMaximoDiarioEnWh este es el argumento que se pasa para rellenar el campo caudal máximo diario en Wh
     */
    public void setCaudalMaximoDiarioEnWh(Object caudalMaximoDiarioEnWh) {
        CaudalMaximoDiarioEnWh = caudalMaximoDiarioEnWh;
    }

    /**
     * Devuelve un Object para el caudal horario en Wh de los clientes sips
     * @return
     */
    public Object getCaudalHorarioEnWh() {
        return CaudalHorarioEnWh;
    }

    /**
     * Llena el campo caudal horario en Wh un argumento Object que se pasa
     * @param caudalHorarioEnWh este es el argumento que se pasa para rellenar el campo caudal horario en Wh
     */
    public void setCaudalHorarioEnWh(Object caudalHorarioEnWh) {
        CaudalHorarioEnWh = caudalHorarioEnWh;
    }

    /**
     * Devuelve un Object para el derecho TUR de los clientes sips
     * @return
     */
    public Object getDerechoTUR() {
        return DerechoTUR;
    }

    /**
     * Llena el campo derecho TUR un argumento Object que se pasa
     * @param derechoTUR este es el argumento que se pasa para rellenar el campo derecho TUR
     */
    public void setDerechoTUR(Object derechoTUR) {
        DerechoTUR = derechoTUR;
    }

    /**
     * Devuelve un Object para la fecha de la última inspección de los clientes sips
     * @return
     */
    public Object getFechaUltimaInspeccion() {
        return FechaUltimaInspeccion;
    }

    /**
     * Llena el campo fecha de la última inspección un argumento Object que se pasa
     * @param fechaUltimaInspeccion este es el argumento que se pasa para rellenar el campo fecha de la última inspección
     */
    public void setFechaUltimaInspeccion(Object fechaUltimaInspeccion) {
        FechaUltimaInspeccion = fechaUltimaInspeccion;
    }

    /**
     * Devuelve un Object para el codigo de resultado de inspección de los clientes sips
     * @return
     */
    public Object getCodigoResultadoInspeccion() {
        return CodigoResultadoInspeccion;
    }

    /**
     * Llena el campo codigo de resultado de inspección un argumento Object que se pasa
     * @param codigoResultadoInspeccion este es el argumento que se pasa para rellenar el campo codigo de resultado de inspección
     */
    public void setCodigoResultadoInspeccion(Object codigoResultadoInspeccion) {
        CodigoResultadoInspeccion = codigoResultadoInspeccion;
    }

    /**
     * Devuelve un Object para el codigo de contador de los clientes sips
     * @return
     */
    public Object getCodigoContador() {
        return CodigoContador;
    }

    /**
     * Llena el campo codigo de contador un argumento Object que se pasa
     * @param codigoContador este es el argumento que se pasa para rellenar el campo codigo de contador
     */
    public void setCodigoContador(Object codigoContador) {
        CodigoContador = codigoContador;
    }

    /**
     * Devuelve un Object para el calibre de contador de los clientes sips
     * @return
     */
    public Object getCalibreContador() {
        return CalibreContador;
    }

    /**
     * Llena el campo calibre de contador un argumento Object que se pasa
     * @param calibreContador este es el argumento que se pasa para rellenar el campo calibre de contador
     */
    public void setCalibreContador(Object calibreContador) {
        CalibreContador = calibreContador;
    }

    /**
     * Devuelve un Object para el tipo de contador de los clientes sips
     * @return
     */
    public Object getTipoContador() {
        return TipoContador;
    }

    /**
     * Llena el campo tipo de contador un argumento Object que se pasa
     * @param tipoContador este es el argumento que se pasa para rellenar el campo tipo de contador
     */
    public void setTipoContador(Object tipoContador) {
        TipoContador = tipoContador;
    }

    /**
     * Devuelve un Object para la propiedad de medida de equipo de los clientes sips
     * @return
     */
    public Object getPropiedadEquipoMedida() {
        return PropiedadEquipoMedida;
    }

    /**
     * Llena el campo propiedad de medida de equipo un argumento Object que se pasa
     * @param propiedadEquipoMedida este es el argumento que se pasa para rellenar el campo propiedad de medida de equipo
     */
    public void setPropiedadEquipoMedida(Object propiedadEquipoMedida) {
        PropiedadEquipoMedida = propiedadEquipoMedida;
    }

    /**
     * Devuelve un Object para el codigo de telemedida de los clientes sips
     * @return
     */
    public Object getCodigoTelemedida() {
        return CodigoTelemedida;
    }

    /**
     * Llena el campo codigo de telemedida un argumento Object que se pasa
     * @param codigoTelemedida este es el argumento que se pasa para rellenar el campo codigo de telemedida
     */
    public void setCodigoTelemedida(Object codigoTelemedida) {
        CodigoTelemedida = codigoTelemedida;
    }

    /**
     * Devuelve un Object para el id del tipo del titular de los clientes sips
     * @return
     */
    public Object getIdTipoTitular() {
        return IdTipoTitular;
    }

    /**
     * Llena el campo id del tipo del titular un argumento Object que se pasa
     * @param idTipoTitular este es el argumento que se pasa para rellenar el campo id del tipo del titular
     */
    public void setIdTipoTitular(Object idTipoTitular) {
        IdTipoTitular = idTipoTitular;
    }

    /**
     * Devuelve un Object para el id del titular de los clientes sips
     * @return
     */
    public Object getIdTitular() {
        return IdTitular;
    }

    /**
     * Llena el campo id del titular un argumento Object que se pasa
     * @param idTitular este es el argumento que se pasa para rellenar el campo id del titular
     */
    public void setIdTitular(Object idTitular) {
        IdTitular = idTitular;
    }

    /**
     * Devuelve un Object para el nombre del titular de los clientes sips
     * @return
     */
    public Object getNombreTitular() {
        return NombreTitular;
    }

    /**
     * Llena el campo nombre del titular un argumento Object que se pasa
     * @param nombreTitular este es el argumento que se pasa para rellenar el campo nombre del titular
     */
    public void setNombreTitular(Object nombreTitular) {
        NombreTitular = nombreTitular;
    }

    /**
     * Devuelve un Object para el apellido del titular de los clientes sips
     * @return
     */
    public Object getApellido1Titular() {
        return Apellido1Titular;
    }

    /**
     * Llena el campo apellido del titular un argumento Object que se pasa
     * @param apellido1Titular este es el argumento que se pasa para rellenar el campo apellido del titular
     */
    public void setApellido1Titular(Object apellido1Titular) {
        Apellido1Titular = apellido1Titular;
    }

    /**
     * Devuelve un Object para el apellido2 del titular de los clientes sips
     * @return
     */
    public Object getApellido2Titular() {
        return Apellido2Titular;
    }

    /**
     * Llena el campo apellido2 del titular un argumento Object que se pasa
     * @param apellido2Titular este es el argumento que se pasa para rellenar el campo apellido2 del titular
     */
    public void setApellido2Titular(Object apellido2Titular) {
        Apellido2Titular = apellido2Titular;
    }

    /**
     * Devuelve un Object para el codigo de provincia del titular de los clientes sips
     * @return
     */
    public Object getCodigoProvinciaTitular() {
        return CodigoProvinciaTitular;
    }

    /**
     * Llena el campo codigo de provincia del titular un argumento Object que se pasa
     * @param codigoProvinciaTitular este es el argumento que se pasa para rellenar el campo codigo de provincia del titular
     */
    public void setCodigoProvinciaTitular(Object codigoProvinciaTitular) {
        CodigoProvinciaTitular = codigoProvinciaTitular;
    }

    /**
     * Devuelve un Object para el des de provincia del titular de los clientes sips
     * @return
     */
    public Object getDesProvinciaTitular() {
        return DesProvinciaTitular;
    }

    /**
     * Llena el campo des de provincia del titular un argumento Object que se pasa
     * @param desProvinciaTitular este es el argumento que se pasa para rellenar el campo des de provincia del titular
     */
    public void setDesProvinciaTitular(Object desProvinciaTitular) {
        DesProvinciaTitular = desProvinciaTitular;
    }

    /**
     * Devuelve un Object para el codigo postal del titular de los clientes sips
     * @return
     */
    public Object getCodigoPostalTitular() {
        return CodigoPostalTitular;
    }

    /**
     * Llena el campo codigo postal del titular un argumento Object que se pasa
     * @param codigoPostalTitular este es el argumento que se pasa para rellenar el campo codigo postal del titular
     */
    public void setCodigoPostalTitular(Object codigoPostalTitular) {
        CodigoPostalTitular = codigoPostalTitular;
    }

    /**
     * Devuelve un Object para el municipio del titular de los clientes sips
     * @return
     */
    public Object getMunicipioTitular() {
        return MunicipioTitular;
    }

    /**
     * Llena el campo municipio del titular un argumento Object que se pasa
     * @param municipioTitular este es el argumento que se pasa para rellenar el campo municipio del titular
     */
    public void setMunicipioTitular(Object municipioTitular) {
        MunicipioTitular = municipioTitular;
    }

    /**
     * Devuelve un Object para el des municipio del titular de los clientes sips
     * @return
     */
    public Object getDesMunicipioTitular() {
        return DesMunicipioTitular;
    }

    /**
     * Llena el campo des municipio del titular un argumento Object que se pasa
     * @param desMunicipioTitular este es el argumento que se pasa para rellenar el campo des municipio del titular
     */
    public void setDesMunicipioTitular(Object desMunicipioTitular) {
        DesMunicipioTitular = desMunicipioTitular;
    }

    /**
     * Devuelve un Object para el tipo de via del titular de los clientes sips
     * @return
     */
    public Object getTipoViaTitular() {
        return TipoViaTitular;
    }

    /**
     * Llena el campo tipo de via del titular un argumento Object que se pasa
     * @param tipoViaTitular este es el argumento que se pasa para rellenar el campo tipo de via del titular
     */
    public void setTipoViaTitular(Object tipoViaTitular) {
        TipoViaTitular = tipoViaTitular;
    }

    /**
     * Devuelve un Object para la via del titular de los clientes sips
     * @return
     */
    public Object getViaTitular() {
        return ViaTitular;
    }

    /**
     * Llena el campo via del titular un argumento Object que se pasa
     * @param viaTitular este es el argumento que se pasa para rellenar el campo via del titular
     */
    public void setViaTitular(Object viaTitular) {
        ViaTitular = viaTitular;
    }

    /**
     * Devuelve un Object para el numero de finca del titular de los clientes sips
     * @return
     */
    public Object getNumFincaTitular() {
        return NumFincaTitular;
    }

    /**
     * Llena el campo numero de finca del titular un argumento Object que se pasa
     * @param numFincaTitular este es el argumento que se pasa para rellenar el campo numero de finca del titular
     */
    public void setNumFincaTitular(Object numFincaTitular) {
        NumFincaTitular = numFincaTitular;
    }

    /**
     * Devuelve un Object para el portal del titular de los clientes sips
     * @return
     */
    public Object getPortalTitular() {
        return PortalTitular;
    }

    /**
     * Llena el campo portal del titular un argumento Object que se pasa
     * @param portalTitular este es el argumento que se pasa para rellenar el campo portal del titular
     */
    public void setPortalTitular(Object portalTitular) {
        PortalTitular = portalTitular;
    }

    /**
     * Devuelve un Object para la escalera del titular de los clientes sips
     * @return
     */
    public Object getEscaleraTitular() {
        return EscaleraTitular;
    }

    /**
     * Llena el campo escalera del titular un argumento Object que se pasa
     * @param escaleraTitular este es el argumento que se pasa para rellenar el campo escalera del titular
     */
    public void setEscaleraTitular(Object escaleraTitular) {
        EscaleraTitular = escaleraTitular;
    }

    /**
     * Devuelve un Object para el piso del titular de los clientes sips
     * @return
     */
    public Object getPisoTitular() {
        return PisoTitular;
    }

    /**
     * Llena el campo piso del titular un argumento Object que se pasa
     * @param pisoTitular este es el argumento que se pasa para rellenar el campo piso del titular
     */
    public void setPisoTitular(Object pisoTitular) {
        PisoTitular = pisoTitular;
    }

    /**
     * Devuelve un Object para la puerta del titular de los clientes sips
     * @return
     */
    public Object getPuertaTitular() {
        return PuertaTitular;
    }

    /**
     * Llena el campo puerta del titular un argumento Object que se pasa
     * @param puertaTitular este es el argumento que se pasa para rellenar el campo puerta del titular
     */
    public void setPuertaTitular(Object puertaTitular) {
        PuertaTitular = puertaTitular;
    }

    /**
     * Devuelve un Object para el tipo de corrector de los clientes sips
     * @return
     */
    public Object getTipoCorrector() {
        return TipoCorrector;
    }

    /**
     * Llena el campo tipo de corrector un argumento Object que se pasa
     * @param tipoCorrector este es el argumento que se pasa para rellenar el campo tipo de corrector
     */
    public void setTipoCorrector(Object tipoCorrector) {
        TipoCorrector = tipoCorrector;
    }

    /**
     * Devuelve un Object para los conectados de planta de sátelite de los clientes sips
     * @return
     */
    public Object getConectadoPlantaSatelite() {
        return ConectadoPlantaSatelite;
    }

    /**
     * Llena el campo conectado de planta de sátelite un argumento Object que se pasa
     * @param conectadoPlantaSatelite este es el argumento que se pasa para rellenar el campo conectado de planta de sátelite
     */
    public void setConectadoPlantaSatelite(Object conectadoPlantaSatelite) {
        ConectadoPlantaSatelite = conectadoPlantaSatelite;
    }

    /**
     * Devuelve un Object para el Pctd de los clientes sips
     * @return
     */
    public Object getPctd() {
        return Pctd;
    }

    /**
     * Llena el campo Pctd un argumento Object que se pasa
     * @param pctd este es el argumento que se pasa para rellenar el campo Pctd
     */
    public void setPctd(Object pctd) {
        Pctd = pctd;
    }

    /**
     * Devuelve un Object para la medida de presión de los clientes sips
     * @return
     */
    public Object getPresionMedida() {
        return PresionMedida;
    }

    /**
     * Llena el campo medida de presión un argumento Object que se pasa
     * @param presionMedida este es el argumento que se pasa para rellenar el campo medida de presión
     */
    public void setPresionMedida(Object presionMedida) {
        PresionMedida = presionMedida;
    }

    /**
     * Devuelve un String para el distri tarifa CP de los clientes sips
     * @return
     */
    public String getDistriTarifaCP() {
        return DistriTarifaCP;
    }

    /**
     * Llena el campo distri tarifa CP un argumento String que se pasa
     * @param distriTarifaCP este es el argumento que se pasa para rellenar el campo distri tarifa CP
     */
    public void setDistriTarifaCP(String distriTarifaCP) {
        DistriTarifaCP = distriTarifaCP;
    }

    /**
     * Devuelve un String para el distri tarifa CP de los clientes sips
     * @return
     */
    public String getDistriTarifa() {
        return DistriTarifa;
    }

    /**
     * Llena el campo distri tarifa CP un argumento String que se pasa
     * @param distriTarifa este es el argumento que se pasa para rellenar el campo distri tarifa CP
     */
    public void setDistriTarifa(String distriTarifa) {
        DistriTarifa = distriTarifa;
    }

    /**
     * Devuelve un String para el distri CP de los clientes sips
     * @return
     */
    public String getDistriCP() {
        return DistriCP;
    }

    /**
     * Llena el campo distri CP un argumento String que se pasa
     * @param distriCP este es el argumento que se pasa para rellenar el campo distri CP
     */
    public void setDistriCP(String distriCP) {
        DistriCP = distriCP;
    }

    /**
     * Devuelve un String para el tarifa CP de los clientes sips
     * @return
     */
    public String getTarifaCP() {
        return TarifaCP;
    }

    /**
     * Llena el campo tarifa CP un argumento String que se pasa
     * @param tarifaCP este es el argumento que se pasa para rellenar el campo tarifa CP
     */
    public void setTarifaCP(String tarifaCP) {
        TarifaCP = tarifaCP;
    }

    /**
     * Devuelve un String para el distri ciudad de los clientes sips
     * @return
     */
    public String getDistriCiudad() {
        return DistriCiudad;
    }

    /**
     * Llena el campo distri ciudad un argumento String que se pasa
     * @param distriCiudad este es el argumento que se pasa para rellenar el campo distri ciudad
     */
    public void setDistriCiudad(String distriCiudad) {
        DistriCiudad = distriCiudad;
    }

    /**
     * Devuelve un String para la tarifa ciudad de los clientes sips
     * @return
     */
    public String getTarifaCiudad() {
        return TarifaCiudad;
    }

    /**
     * Llena el campo tarifa ciudad un argumento String que se pasa
     * @param tarifaCiudad este es el argumento que se pasa para rellenar el campo tarifa ciudad
     */
    public void setTarifaCiudad(String tarifaCiudad) {
        TarifaCiudad = tarifaCiudad;
    }

    /**
     * Devuelve un String para el CP ciudad de los clientes sips
     * @return
     */
    public String getCpCiudad() {
        return CpCiudad;
    }

    /**
     * Llena el campo CP ciudad un argumento String que se pasa
     * @param cpCiudad este es el argumento que se pasa para rellenar el campo CP ciudad
     */
    public void setCpCiudad(String cpCiudad) {
        CpCiudad = cpCiudad;
    }

    /**
     * Devuelve un String para el distri provincia de los clientes sips
     * @return
     */
    public String getDistriProvincia() {
        return DistriProvincia;
    }

    /**
     * Llena el campo distri provincia un argumento String que se pasa
     * @param distriProvincia este es el argumento que se pasa para rellenar el campo distri provincia
     */
    public void setDistriProvincia(String distriProvincia) {
        DistriProvincia = distriProvincia;
    }

    /**
     * Devuelve un String para el tarifa provincia de los clientes sips
     * @return
     */
    public String getTarifaProvincia() {
        return TarifaProvincia;
    }

    /**
     * Llena el campo tarifa provincia un argumento String que se pasa
     * @param tarifaProvincia este es el argumento que se pasa para rellenar el campo tarifa provincia
     */
    public void setTarifaProvincia(String tarifaProvincia) {
        TarifaProvincia = tarifaProvincia;
    }

    /**
     * Devuelve un String para el CP provincia de los clientes sips
     * @return
     */
    public String getCpProvincia() {
        return CpProvincia;
    }

    /**
     * Llena el campo CP provincia un argumento String que se pasa
     * @param cpProvincia este es el argumento que se pasa para rellenar el campo CP provincia
     */
    public void setCpProvincia(String cpProvincia) {
        CpProvincia = cpProvincia;
    }

    /**
     * Devuelve un String para el distri nombre de los clientes sips
     * @return
     */
    public Object getDistriNombre() {
        return DistriNombre;
    }

    /**
     * Llena el campo distri nombre un argumento String que se pasa
     * @param distriNombre este es el argumento que se pasa para rellenar el campo distri nombre
     */
    public void setDistriNombre(Object distriNombre) {
        DistriNombre = distriNombre;
    }

    /**
     * Devuelve un String para el nombre de la tarifa de los clientes sips
     * @return
     */
    public Object getTarifaNombre() {
        return TarifaNombre;
    }

    /**
     * Llena el campo nombre de la tarifa un argumento String que se pasa
     * @param tarifaNombre este es el argumento que se pasa para rellenar el campo nombre de la tarifa
     */
    public void setTarifaNombre(Object tarifaNombre) {
        TarifaNombre = tarifaNombre;
    }

    /**
     * Devuelve un String para el CP del nombre de los clientes sips
     * @return
     */
    public Object getCpNombre() {
        return CpNombre;
    }

    /**
     * Llena el campo CP del nombre un argumento String que se pasa
     * @param cpNombre este es el argumento que se pasa para rellenar el campo CP del nombre
     */
    public void setCpNombre(Object cpNombre) {
        CpNombre = cpNombre;
    }

    /**
     * Devuelve un String para el nombre completo del titular de los clientes sips
     * @return
     */
    public Object getNombreCompletoTitular() {
        return NombreCompletoTitular;
    }

    /**
     * Llena el campo nombre completo del titular un argumento String que se pasa
     * @param nombreCompletoTitular este es el argumento que se pasa para rellenar el campo nombre completo del titular
     */
    public void setNombreCompletoTitular(Object nombreCompletoTitular) {
        NombreCompletoTitular = nombreCompletoTitular;
    }

    /**
     * Devuelve un String para el nombre de la ciudad de los clientes sips
     * @return
     */
    public String getCiudadNombre() {
        return CiudadNombre;
    }

    /**
     * Llena el campo nombre de la ciudad un argumento String que se pasa
     * @param ciudadNombre este es el argumento que se pasa para rellenar el campo nombre de la ciudad
     */
    public void setCiudadNombre(String ciudadNombre) {
        CiudadNombre = ciudadNombre;
    }
    //endregion
    //region toString
    /**
     * Devuelve un String con todos los atributos de la clase Molde CodigosPrecio mediate el método toString()
     * @return
     */
    @Override
    public String toString() {
        return "ClienteSip{" +
                "CodigoCUPS='" + CodigoCUPS + '\'' +
                ", CodigoEmpresaDistribuidora='" + CodigoEmpresaDistribuidora + '\'' +
                ", NombreEmpresaDistribuidora='" + NombreEmpresaDistribuidora + '\'' +
                ", CodigoPostalPS='" + CodigoPostalPS + '\'' +
                ", MunicipioPS='" + MunicipioPS + '\'' +
                ", CodigoProvinciaPS='" + CodigoProvinciaPS + '\'' +
                ", FechaAltaSuministro='" + FechaAltaSuministro + '\'' +
                ", CodigoTarifaATREnVigor='" + CodigoTarifaATREnVigor + '\'' +
                ", CodigoTensionV='" + CodigoTensionV + '\'' +
                ", PotenciaMaximaBIEW=" + PotenciaMaximaBIEW +
                ", PotenciaMaximaAPMW=" + PotenciaMaximaAPMW +
                ", CodigoClasificacionPS='" + CodigoClasificacionPS + '\'' +
                ", CodigoDisponibilidadICP='" + CodigoDisponibilidadICP + '\'' +
                ", TipoPerfilConsumo='" + TipoPerfilConsumo + '\'' +
                ", ValorDerechosExtensionW='" + ValorDerechosExtensionW + '\'' +
                ", ValorDerechosAccesoW='" + ValorDerechosAccesoW + '\'' +
                ", CodigoPropiedadEquipoMedida='" + CodigoPropiedadEquipoMedida + '\'' +
                ", CodigoPropiedadICP='" + CodigoPropiedadICP + '\'' +
                ", PotenciasContratadasEnWP1=" + PotenciasContratadasEnWP1 +
                ", PotenciasContratadasEnWP2=" + PotenciasContratadasEnWP2 +
                ", PotenciasContratadasEnWP3=" + PotenciasContratadasEnWP3 +
                ", PotenciasContratadasEnWP4=" + PotenciasContratadasEnWP4 +
                ", PotenciasContratadasEnWP5=" + PotenciasContratadasEnWP5 +
                ", PotenciasContratadasEnWP6=" + PotenciasContratadasEnWP6 +
                ", FechaUltimoMovimientoContrato='" + FechaUltimoMovimientoContrato + '\'' +
                ", FechaUltimoCambioComercializador='" + FechaUltimoCambioComercializador + '\'' +
                ", FechaLimiteDerechosReconocidos='" + FechaLimiteDerechosReconocidos + '\'' +
                ", FechaUltimaLectura='" + FechaUltimaLectura + '\'' +
                ", InformacionImpagos=" + InformacionImpagos +
                ", ImporteDepositoGarantiaEuros=" + ImporteDepositoGarantiaEuros +
                ", TipoIdTitular='" + TipoIdTitular + '\'' +
                ", EsViviendaHabitual='" + EsViviendaHabitual + '\'' +
                ", CodigoComercializadora=" + CodigoComercializadora +
                ", CodigoTelegestion='" + CodigoTelegestion + '\'' +
                ", CodigoFasesEquipoMedida='" + CodigoFasesEquipoMedida + '\'' +
                ", CodigoAutoconsumo='" + CodigoAutoconsumo + '\'' +
                ", CodigoTipoContrato=" + CodigoTipoContrato +
                ", CodigoPeriodicidadFacturacion=" + CodigoPeriodicidadFacturacion +
                ", CodigoBIE=" + CodigoBIE +
                ", FechaEmisionBIE=" + FechaEmisionBIE +
                ", FechaCaducidadBIE=" + FechaCaducidadBIE +
                ", CodigoAPM=" + CodigoAPM +
                ", FechaEmisionAPM=" + FechaEmisionAPM +
                ", FechaCaducidadAPM=" + FechaCaducidadAPM +
                ", RelacionTransformacionIntensidad=" + RelacionTransformacionIntensidad +
                ", Cnae='" + Cnae + '\'' +
                ", CodigoModoControlPotencia='" + CodigoModoControlPotencia + '\'' +
                ", PotenciaCGPW=" + PotenciaCGPW +
                ", CodigoDHEquipoDeMedida=" + CodigoDHEquipoDeMedida +
                ", CodigoAccesibilidadContador=" + CodigoAccesibilidadContador +
                ", CodigoPSContratable='" + CodigoPSContratable + '\'' +
                ", MotivoEstadoNoContratable=" + MotivoEstadoNoContratable +
                ", CodigoTensionMedida=" + CodigoTensionMedida +
                ", CodigoClaseExpediente=" + CodigoClaseExpediente +
                ", CodigoMotivoExpediente=" + CodigoMotivoExpediente +
                ", CodigoTipoSuministro=" + CodigoTipoSuministro +
                ", AplicacionBonoSocial='" + AplicacionBonoSocial + '\'' +
                ", DesProvinciaPS='" + DesProvinciaPS + '\'' +
                ", DesMunicipioPS='" + DesMunicipioPS + '\'' +
                ", TipoViaPS=" + TipoViaPS +
                ", ViaPS=" + ViaPS +
                ", NumFincaPS=" + NumFincaPS +
                ", PortalPS=" + PortalPS +
                ", EscaleraPS=" + EscaleraPS +
                ", PisoPS=" + PisoPS +
                ", PuertaPS=" + PuertaPS +
                ", CodigoPresion=" + CodigoPresion +
                ", CodigoPeajeEnVigor=" + CodigoPeajeEnVigor +
                ", CaudalMaximoDiarioEnWh=" + CaudalMaximoDiarioEnWh +
                ", CaudalHorarioEnWh=" + CaudalHorarioEnWh +
                ", DerechoTUR=" + DerechoTUR +
                ", FechaUltimaInspeccion=" + FechaUltimaInspeccion +
                ", CodigoResultadoInspeccion=" + CodigoResultadoInspeccion +
                ", CodigoContador=" + CodigoContador +
                ", CalibreContador=" + CalibreContador +
                ", TipoContador=" + TipoContador +
                ", PropiedadEquipoMedida=" + PropiedadEquipoMedida +
                ", CodigoTelemedida=" + CodigoTelemedida +
                ", IdTipoTitular=" + IdTipoTitular +
                ", IdTitular=" + IdTitular +
                ", NombreTitular=" + NombreTitular +
                ", Apellido1Titular=" + Apellido1Titular +
                ", Apellido2Titular=" + Apellido2Titular +
                ", CodigoProvinciaTitular=" + CodigoProvinciaTitular +
                ", DesProvinciaTitular=" + DesProvinciaTitular +
                ", CodigoPostalTitular=" + CodigoPostalTitular +
                ", MunicipioTitular=" + MunicipioTitular +
                ", DesMunicipioTitular=" + DesMunicipioTitular +
                ", TipoViaTitular=" + TipoViaTitular +
                ", ViaTitular=" + ViaTitular +
                ", NumFincaTitular=" + NumFincaTitular +
                ", PortalTitular=" + PortalTitular +
                ", EscaleraTitular=" + EscaleraTitular +
                ", PisoTitular=" + PisoTitular +
                ", PuertaTitular=" + PuertaTitular +
                ", TipoCorrector=" + TipoCorrector +
                ", ConectadoPlantaSatelite=" + ConectadoPlantaSatelite +
                ", Pctd=" + Pctd +
                ", PresionMedida=" + PresionMedida +
                ", DistriTarifaCP='" + DistriTarifaCP + '\'' +
                ", DistriTarifa='" + DistriTarifa + '\'' +
                ", DistriCP='" + DistriCP + '\'' +
                ", TarifaCP='" + TarifaCP + '\'' +
                ", DistriCiudad='" + DistriCiudad + '\'' +
                ", TarifaCiudad='" + TarifaCiudad + '\'' +
                ", CpCiudad='" + CpCiudad + '\'' +
                ", DistriProvincia='" + DistriProvincia + '\'' +
                ", TarifaProvincia='" + TarifaProvincia + '\'' +
                ", CpProvincia='" + CpProvincia + '\'' +
                ", DistriNombre=" + DistriNombre +
                ", TarifaNombre=" + TarifaNombre +
                ", CpNombre=" + CpNombre +
                ", NombreCompletoTitular=" + NombreCompletoTitular +
                ", CiudadNombre='" + CiudadNombre + '\'' +
                '}';
    }
    //endregion
}

