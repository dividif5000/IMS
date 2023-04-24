package com.alumno.simulacionims.models;

/**
 * @author David Ruiz Garcia
 * Objeto Molde para hacer uso de los datos de los ClintesSips
 * Todos los datos que se obtengas con esta clase se obtiene gracias a la libreria de API OkHTTP
 */
public class ClientesSips {

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
     *
     * @return
     */
    public Object getInformacionImpagos() {
        return InformacionImpagos;
    }

    /**
     *
     * @param informacionImpagos
     */
    public void setInformacionImpagos(Object informacionImpagos) {
        InformacionImpagos = informacionImpagos;
    }

    /**
     *
     * @return
     */
    public Object getImporteDepositoGarantiaEuros() {
        return ImporteDepositoGarantiaEuros;
    }

    /**
     *
     * @param importeDepositoGarantiaEuros
     */
    public void setImporteDepositoGarantiaEuros(Object importeDepositoGarantiaEuros) {
        ImporteDepositoGarantiaEuros = importeDepositoGarantiaEuros;
    }

    /**
     *
     * @return
     */
    public String getTipoIdTitular() {
        return TipoIdTitular;
    }

    /**
     *
     * @param tipoIdTitular
     */
    public void setTipoIdTitular(String tipoIdTitular) {
        TipoIdTitular = tipoIdTitular;
    }

    /**
     *
     * @return
     */
    public String getEsViviendaHabitual() {
        return EsViviendaHabitual;
    }

    /**
     *
     * @param esViviendaHabitual
     */
    public void setEsViviendaHabitual(String esViviendaHabitual) {
        EsViviendaHabitual = esViviendaHabitual;
    }

    /**
     *
     * @return
     */
    public Object getCodigoComercializadora() {
        return CodigoComercializadora;
    }

    /**
     *
     * @param codigoComercializadora
     */
    public void setCodigoComercializadora(Object codigoComercializadora) {
        CodigoComercializadora = codigoComercializadora;
    }

    /**
     *
     * @return
     */
    public String getCodigoTelegestion() {
        return CodigoTelegestion;
    }

    /**
     *
     * @param codigoTelegestion
     */
    public void setCodigoTelegestion(String codigoTelegestion) {
        CodigoTelegestion = codigoTelegestion;
    }

    /**
     *
     * @return
     */
    public String getCodigoFasesEquipoMedida() {
        return CodigoFasesEquipoMedida;
    }

    /**
     *
     * @param codigoFasesEquipoMedida
     */
    public void setCodigoFasesEquipoMedida(String codigoFasesEquipoMedida) {
        CodigoFasesEquipoMedida = codigoFasesEquipoMedida;
    }

    /**
     *
     * @return
     */
    public String getCodigoAutoconsumo() {
        return CodigoAutoconsumo;
    }

    /**
     *
     * @param codigoAutoconsumo
     */
    public void setCodigoAutoconsumo(String codigoAutoconsumo) {
        CodigoAutoconsumo = codigoAutoconsumo;
    }

    /**
     *
     * @return
     */
    public Object getCodigoTipoContrato() {
        return CodigoTipoContrato;
    }

    /**
     *
     * @param codigoTipoContrato
     */
    public void setCodigoTipoContrato(Object codigoTipoContrato) {
        CodigoTipoContrato = codigoTipoContrato;
    }

    /**
     *
     * @return
     */
    public Object getCodigoPeriodicidadFacturacion() {
        return CodigoPeriodicidadFacturacion;
    }

    /**
     *
     * @param codigoPeriodicidadFacturacion
     */
    public void setCodigoPeriodicidadFacturacion(Object codigoPeriodicidadFacturacion) {
        CodigoPeriodicidadFacturacion = codigoPeriodicidadFacturacion;
    }

    /**
     *
     * @return
     */
    public Object getCodigoBIE() {
        return CodigoBIE;
    }

    /**
     *
     * @param codigoBIE
     */
    public void setCodigoBIE(Object codigoBIE) {
        CodigoBIE = codigoBIE;
    }

    /**
     *
     * @return
     */
    public Object getFechaEmisionBIE() {
        return FechaEmisionBIE;
    }

    /**
     *
     * @param fechaEmisionBIE
     */
    public void setFechaEmisionBIE(Object fechaEmisionBIE) {
        FechaEmisionBIE = fechaEmisionBIE;
    }

    /**
     *
     * @return
     */
    public Object getFechaCaducidadBIE() {
        return FechaCaducidadBIE;
    }

    /**
     *
     * @param fechaCaducidadBIE
     */
    public void setFechaCaducidadBIE(Object fechaCaducidadBIE) {
        FechaCaducidadBIE = fechaCaducidadBIE;
    }

    /**
     *
     * @return
     */
    public Object getCodigoAPM() {
        return CodigoAPM;
    }

    /**
     *
     * @param codigoAPM
     */
    public void setCodigoAPM(Object codigoAPM) {
        CodigoAPM = codigoAPM;
    }

    /**
     *
     * @return
     */
    public Object getFechaEmisionAPM() {
        return FechaEmisionAPM;
    }

    /**
     *
     * @param fechaEmisionAPM
     */
    public void setFechaEmisionAPM(Object fechaEmisionAPM) {
        FechaEmisionAPM = fechaEmisionAPM;
    }

    /**
     *
     * @return
     */
    public Object getFechaCaducidadAPM() {
        return FechaCaducidadAPM;
    }

    public void setFechaCaducidadAPM(Object fechaCaducidadAPM) {
        FechaCaducidadAPM = fechaCaducidadAPM;
    }

    /**
     *
     * @return
     */
    public Object getRelacionTransformacionIntensidad() {
        return RelacionTransformacionIntensidad;
    }

    /**
     *
     * @param relacionTransformacionIntensidad
     */
    public void setRelacionTransformacionIntensidad(Object relacionTransformacionIntensidad) {
        RelacionTransformacionIntensidad = relacionTransformacionIntensidad;
    }

    /**
     *
     * @return
     */
    public String getCnae() {
        return Cnae;
    }

    /**
     *
     * @param cnae
     */
    public void setCnae(String cnae) {
        Cnae = cnae;
    }

    /**
     *
     * @return
     */
    public String getCodigoModoControlPotencia() {
        return CodigoModoControlPotencia;
    }

    /**
     *
     * @param codigoModoControlPotencia
     */
    public void setCodigoModoControlPotencia(String codigoModoControlPotencia) {
        CodigoModoControlPotencia = codigoModoControlPotencia;
    }

    /**
     *
     * @return
     */
    public Object getPotenciaCGPW() {
        return PotenciaCGPW;
    }

    /**
     *
     * @param potenciaCGPW
     */
    public void setPotenciaCGPW(Object potenciaCGPW) {
        PotenciaCGPW = potenciaCGPW;
    }

    /**
     *
     * @return
     */
    public Object getCodigoDHEquipoDeMedida() {
        return CodigoDHEquipoDeMedida;
    }

    /**
     *
     * @param codigoDHEquipoDeMedida
     */
    public void setCodigoDHEquipoDeMedida(Object codigoDHEquipoDeMedida) {
        CodigoDHEquipoDeMedida = codigoDHEquipoDeMedida;
    }

    /**
     *
     * @return
     */
    public Object getCodigoAccesibilidadContador() {
        return CodigoAccesibilidadContador;
    }

    /**
     *
     * @param codigoAccesibilidadContador
     */
    public void setCodigoAccesibilidadContador(Object codigoAccesibilidadContador) {
        CodigoAccesibilidadContador = codigoAccesibilidadContador;
    }

    /**
     *
     * @return
     */
    public String getCodigoPSContratable() {
        return CodigoPSContratable;
    }

    /**
     *
     * @param codigoPSContratable
     */
    public void setCodigoPSContratable(String codigoPSContratable) {
        CodigoPSContratable = codigoPSContratable;
    }

    /**
     *
     * @return
     */
    public Object getMotivoEstadoNoContratable() {
        return MotivoEstadoNoContratable;
    }

    /**
     *
     * @param motivoEstadoNoContratable
     */
    public void setMotivoEstadoNoContratable(Object motivoEstadoNoContratable) {
        MotivoEstadoNoContratable = motivoEstadoNoContratable;
    }

    /**
     *
     * @return
     */
    public Object getCodigoTensionMedida() {
        return CodigoTensionMedida;
    }

    /**
     *
     * @param codigoTensionMedida
     */
    public void setCodigoTensionMedida(Object codigoTensionMedida) {
        CodigoTensionMedida = codigoTensionMedida;
    }

    /**
     *
     * @return
     */
    public Object getCodigoClaseExpediente() {
        return CodigoClaseExpediente;
    }

    /**
     *
     * @param codigoClaseExpediente
     */
    public void setCodigoClaseExpediente(Object codigoClaseExpediente) {
        CodigoClaseExpediente = codigoClaseExpediente;
    }

    /**
     *
     * @return
     */
    public Object getCodigoMotivoExpediente() {
        return CodigoMotivoExpediente;
    }

    /**
     *
     * @param codigoMotivoExpediente
     */
    public void setCodigoMotivoExpediente(Object codigoMotivoExpediente) {
        CodigoMotivoExpediente = codigoMotivoExpediente;
    }

    /**
     *
     * @return
     */
    public Object getCodigoTipoSuministro() {
        return CodigoTipoSuministro;
    }

    /**
     *
     * @param codigoTipoSuministro
     */
    public void setCodigoTipoSuministro(Object codigoTipoSuministro) {
        CodigoTipoSuministro = codigoTipoSuministro;
    }

    /**
     *
     * @return
     */
    public String getAplicacionBonoSocial() {
        return AplicacionBonoSocial;
    }

    /**
     *
     * @param aplicacionBonoSocial
     */
    public void setAplicacionBonoSocial(String aplicacionBonoSocial) {
        AplicacionBonoSocial = aplicacionBonoSocial;
    }

    /**
     *
     * @return
     */
    public String getDesProvinciaPS() {
        return DesProvinciaPS;
    }

    /**
     *
     * @param desProvinciaPS
     */
    public void setDesProvinciaPS(String desProvinciaPS) {
        DesProvinciaPS = desProvinciaPS;
    }

    /**
     *
     * @return
     */
    public String getDesMunicipioPS() {
        return DesMunicipioPS;
    }

    /**
     *
     * @param desMunicipioPS
     */
    public void setDesMunicipioPS(String desMunicipioPS) {
        DesMunicipioPS = desMunicipioPS;
    }

    /**
     *
     * @return
     */
    public Object getTipoViaPS() {
        return TipoViaPS;
    }

    /**
     *
     * @param tipoViaPS
     */
    public void setTipoViaPS(Object tipoViaPS) {
        TipoViaPS = tipoViaPS;
    }

    /**
     *
     * @return
     */
    public Object getViaPS() {
        return ViaPS;
    }

    /**
     *
     * @param viaPS
     */
    public void setViaPS(Object viaPS) {
        ViaPS = viaPS;
    }

    /**
     *
     * @return
     */
    public Object getNumFincaPS() {
        return NumFincaPS;
    }

    /**
     *
     * @param numFincaPS
     */
    public void setNumFincaPS(Object numFincaPS) {
        NumFincaPS = numFincaPS;
    }

    /**
     *
     * @return
     */
    public Object getPortalPS() {
        return PortalPS;
    }

    /**
     *
     * @param portalPS
     */
    public void setPortalPS(Object portalPS) {
        PortalPS = portalPS;
    }

    /**
     *
     * @return
     */
    public Object getEscaleraPS() {
        return EscaleraPS;
    }

    /**
     *
     * @param escaleraPS
     */
    public void setEscaleraPS(Object escaleraPS) {
        EscaleraPS = escaleraPS;
    }

    /**
     *
     * @return
     */
    public Object getPisoPS() {
        return PisoPS;
    }

    /**
     *
     * @param pisoPS
     */
    public void setPisoPS(Object pisoPS) {
        PisoPS = pisoPS;
    }

    /**
     *
     * @return
     */
    public Object getPuertaPS() {
        return PuertaPS;
    }

    /**
     *
     * @param puertaPS
     */
    public void setPuertaPS(Object puertaPS) {
        PuertaPS = puertaPS;
    }

    /**
     *
     * @return
     */
    public Object getCodigoPresion() {
        return CodigoPresion;
    }

    /**
     *
     * @param codigoPresion
     */
    public void setCodigoPresion(Object codigoPresion) {
        CodigoPresion = codigoPresion;
    }

    /**
     *
     * @return
     */
    public Object getCodigoPeajeEnVigor() {
        return CodigoPeajeEnVigor;
    }

    /**
     *
     * @param codigoPeajeEnVigor
     */
    public void setCodigoPeajeEnVigor(Object codigoPeajeEnVigor) {
        CodigoPeajeEnVigor = codigoPeajeEnVigor;
    }

    /**
     *
     * @return
     */
    public Object getCaudalMaximoDiarioEnWh() {
        return CaudalMaximoDiarioEnWh;
    }

    /**
     *
     * @param caudalMaximoDiarioEnWh
     */
    public void setCaudalMaximoDiarioEnWh(Object caudalMaximoDiarioEnWh) {
        CaudalMaximoDiarioEnWh = caudalMaximoDiarioEnWh;
    }

    /**
     *
     * @return
     */
    public Object getCaudalHorarioEnWh() {
        return CaudalHorarioEnWh;
    }

    /**
     *
     * @param caudalHorarioEnWh
     */
    public void setCaudalHorarioEnWh(Object caudalHorarioEnWh) {
        CaudalHorarioEnWh = caudalHorarioEnWh;
    }

    /**
     *
     * @return
     */
    public Object getDerechoTUR() {
        return DerechoTUR;
    }

    /**
     *
     * @param derechoTUR
     */
    public void setDerechoTUR(Object derechoTUR) {
        DerechoTUR = derechoTUR;
    }

    /**
     *
     * @return
     */
    public Object getFechaUltimaInspeccion() {
        return FechaUltimaInspeccion;
    }

    /**
     *
     * @param fechaUltimaInspeccion
     */
    public void setFechaUltimaInspeccion(Object fechaUltimaInspeccion) {
        FechaUltimaInspeccion = fechaUltimaInspeccion;
    }

    /**
     *
     * @return
     */
    public Object getCodigoResultadoInspeccion() {
        return CodigoResultadoInspeccion;
    }

    /**
     *
     * @param codigoResultadoInspeccion
     */
    public void setCodigoResultadoInspeccion(Object codigoResultadoInspeccion) {
        CodigoResultadoInspeccion = codigoResultadoInspeccion;
    }

    /**
     *
     * @return
     */
    public Object getCodigoContador() {
        return CodigoContador;
    }

    /**
     *
     * @param codigoContador
     */
    public void setCodigoContador(Object codigoContador) {
        CodigoContador = codigoContador;
    }

    /**
     *
     * @return
     */
    public Object getCalibreContador() {
        return CalibreContador;
    }

    /**
     *
     * @param calibreContador
     */
    public void setCalibreContador(Object calibreContador) {
        CalibreContador = calibreContador;
    }

    /**
     *
     * @return
     */
    public Object getTipoContador() {
        return TipoContador;
    }

    /**
     *
     * @param tipoContador
     */
    public void setTipoContador(Object tipoContador) {
        TipoContador = tipoContador;
    }

    /**
     *
     * @return
     */
    public Object getPropiedadEquipoMedida() {
        return PropiedadEquipoMedida;
    }

    /**
     *
     * @param propiedadEquipoMedida
     */
    public void setPropiedadEquipoMedida(Object propiedadEquipoMedida) {
        PropiedadEquipoMedida = propiedadEquipoMedida;
    }

    /**
     *
     * @return
     */
    public Object getCodigoTelemedida() {
        return CodigoTelemedida;
    }

    /**
     *
     * @param codigoTelemedida
     */
    public void setCodigoTelemedida(Object codigoTelemedida) {
        CodigoTelemedida = codigoTelemedida;
    }

    /**
     *
     * @return
     */
    public Object getIdTipoTitular() {
        return IdTipoTitular;
    }

    /**
     *
     * @param idTipoTitular
     */
    public void setIdTipoTitular(Object idTipoTitular) {
        IdTipoTitular = idTipoTitular;
    }

    /**
     *
     * @return
     */
    public Object getIdTitular() {
        return IdTitular;
    }

    /**
     *
     * @param idTitular
     */
    public void setIdTitular(Object idTitular) {
        IdTitular = idTitular;
    }

    /**
     *
     * @return
     */
    public Object getNombreTitular() {
        return NombreTitular;
    }

    /**
     *
     * @param nombreTitular
     */
    public void setNombreTitular(Object nombreTitular) {
        NombreTitular = nombreTitular;
    }

    /**
     *
     * @return
     */
    public Object getApellido1Titular() {
        return Apellido1Titular;
    }

    /**
     *
     * @param apellido1Titular
     */
    public void setApellido1Titular(Object apellido1Titular) {
        Apellido1Titular = apellido1Titular;
    }

    /**
     *
     * @return
     */
    public Object getApellido2Titular() {
        return Apellido2Titular;
    }

    /**
     *
     * @param apellido2Titular
     */
    public void setApellido2Titular(Object apellido2Titular) {
        Apellido2Titular = apellido2Titular;
    }

    /**
     *
     * @return
     */
    public Object getCodigoProvinciaTitular() {
        return CodigoProvinciaTitular;
    }

    /**
     *
     * @param codigoProvinciaTitular
     */
    public void setCodigoProvinciaTitular(Object codigoProvinciaTitular) {
        CodigoProvinciaTitular = codigoProvinciaTitular;
    }

    /**
     *
     * @return
     */
    public Object getDesProvinciaTitular() {
        return DesProvinciaTitular;
    }

    /**
     *
     * @param desProvinciaTitular
     */
    public void setDesProvinciaTitular(Object desProvinciaTitular) {
        DesProvinciaTitular = desProvinciaTitular;
    }

    /**
     *
     * @return
     */
    public Object getCodigoPostalTitular() {
        return CodigoPostalTitular;
    }

    /**
     *
     * @param codigoPostalTitular
     */
    public void setCodigoPostalTitular(Object codigoPostalTitular) {
        CodigoPostalTitular = codigoPostalTitular;
    }

    /**
     *
     * @return
     */
    public Object getMunicipioTitular() {
        return MunicipioTitular;
    }

    /**
     *
     * @param municipioTitular
     */
    public void setMunicipioTitular(Object municipioTitular) {
        MunicipioTitular = municipioTitular;
    }

    /**
     *
     * @return
     */
    public Object getDesMunicipioTitular() {
        return DesMunicipioTitular;
    }

    /**
     *
     * @param desMunicipioTitular
     */
    public void setDesMunicipioTitular(Object desMunicipioTitular) {
        DesMunicipioTitular = desMunicipioTitular;
    }

    /**
     *
     * @return
     */
    public Object getTipoViaTitular() {
        return TipoViaTitular;
    }

    /**
     *
     * @param tipoViaTitular
     */
    public void setTipoViaTitular(Object tipoViaTitular) {
        TipoViaTitular = tipoViaTitular;
    }

    /**
     *
     * @return
     */
    public Object getViaTitular() {
        return ViaTitular;
    }

    /**
     *
     * @param viaTitular
     */
    public void setViaTitular(Object viaTitular) {
        ViaTitular = viaTitular;
    }

    /**
     *
     * @return
     */
    public Object getNumFincaTitular() {
        return NumFincaTitular;
    }

    /**
     *
     * @param numFincaTitular
     */
    public void setNumFincaTitular(Object numFincaTitular) {
        NumFincaTitular = numFincaTitular;
    }

    /**
     *
     * @return
     */
    public Object getPortalTitular() {
        return PortalTitular;
    }

    /**
     *
     * @param portalTitular
     */
    public void setPortalTitular(Object portalTitular) {
        PortalTitular = portalTitular;
    }

    /**
     *
     * @return
     */
    public Object getEscaleraTitular() {
        return EscaleraTitular;
    }

    /**
     *
     * @param escaleraTitular
     */
    public void setEscaleraTitular(Object escaleraTitular) {
        EscaleraTitular = escaleraTitular;
    }

    /**
     *
     * @return
     */
    public Object getPisoTitular() {
        return PisoTitular;
    }

    /**
     *
     * @param pisoTitular
     */
    public void setPisoTitular(Object pisoTitular) {
        PisoTitular = pisoTitular;
    }

    /**
     *
     * @return
     */
    public Object getPuertaTitular() {
        return PuertaTitular;
    }

    /**
     *
     * @param puertaTitular
     */
    public void setPuertaTitular(Object puertaTitular) {
        PuertaTitular = puertaTitular;
    }

    /**
     *
     * @return
     */
    public Object getTipoCorrector() {
        return TipoCorrector;
    }

    /**
     *
     * @param tipoCorrector
     */
    public void setTipoCorrector(Object tipoCorrector) {
        TipoCorrector = tipoCorrector;
    }

    /**
     *
     * @return
     */
    public Object getConectadoPlantaSatelite() {
        return ConectadoPlantaSatelite;
    }

    /**
     *
     * @param conectadoPlantaSatelite
     */
    public void setConectadoPlantaSatelite(Object conectadoPlantaSatelite) {
        ConectadoPlantaSatelite = conectadoPlantaSatelite;
    }

    /**
     *
     * @return
     */
    public Object getPctd() {
        return Pctd;
    }

    /**
     *
     * @param pctd
     */
    public void setPctd(Object pctd) {
        Pctd = pctd;
    }

    /**
     *
     * @return
     */
    public Object getPresionMedida() {
        return PresionMedida;
    }

    /**
     *
     * @param presionMedida
     */
    public void setPresionMedida(Object presionMedida) {
        PresionMedida = presionMedida;
    }

    /**
     *
     * @return
     */
    public String getDistriTarifaCP() {
        return DistriTarifaCP;
    }

    /**
     *
     * @param distriTarifaCP
     */
    public void setDistriTarifaCP(String distriTarifaCP) {
        DistriTarifaCP = distriTarifaCP;
    }

    /**
     *
     * @return
     */
    public String getDistriTarifa() {
        return DistriTarifa;
    }

    /**
     *
     * @param distriTarifa
     */
    public void setDistriTarifa(String distriTarifa) {
        DistriTarifa = distriTarifa;
    }

    /**
     *
     * @return
     */
    public String getDistriCP() {
        return DistriCP;
    }

    /**
     *
     * @param distriCP
     */
    public void setDistriCP(String distriCP) {
        DistriCP = distriCP;
    }

    /**
     *
     * @return
     */
    public String getTarifaCP() {
        return TarifaCP;
    }

    /**
     *
     * @param tarifaCP
     */
    public void setTarifaCP(String tarifaCP) {
        TarifaCP = tarifaCP;
    }

    /**
     *
     * @return
     */
    public String getDistriCiudad() {
        return DistriCiudad;
    }

    /**
     *
     * @param distriCiudad
     */
    public void setDistriCiudad(String distriCiudad) {
        DistriCiudad = distriCiudad;
    }

    /**
     *
     * @return
     */
    public String getTarifaCiudad() {
        return TarifaCiudad;
    }

    /**
     *
     * @param tarifaCiudad
     */
    public void setTarifaCiudad(String tarifaCiudad) {
        TarifaCiudad = tarifaCiudad;
    }

    /**
     *
     * @return
     */
    public String getCpCiudad() {
        return CpCiudad;
    }

    /**
     *
     * @param cpCiudad
     */
    public void setCpCiudad(String cpCiudad) {
        CpCiudad = cpCiudad;
    }

    /**
     *
     * @return
     */
    public String getDistriProvincia() {
        return DistriProvincia;
    }

    /**
     *
     * @param distriProvincia
     */
    public void setDistriProvincia(String distriProvincia) {
        DistriProvincia = distriProvincia;
    }

    /**
     *
     * @return
     */
    public String getTarifaProvincia() {
        return TarifaProvincia;
    }

    /**
     *
     * @param tarifaProvincia
     */
    public void setTarifaProvincia(String tarifaProvincia) {
        TarifaProvincia = tarifaProvincia;
    }

    /**
     *
     * @return
     */
    public String getCpProvincia() {
        return CpProvincia;
    }

    /**
     *
     * @param cpProvincia
     */
    public void setCpProvincia(String cpProvincia) {
        CpProvincia = cpProvincia;
    }

    /**
     *
     * @return
     */
    public Object getDistriNombre() {
        return DistriNombre;
    }

    /**
     *
     * @param distriNombre
     */
    public void setDistriNombre(Object distriNombre) {
        DistriNombre = distriNombre;
    }

    /**
     *
     * @return
     */
    public Object getTarifaNombre() {
        return TarifaNombre;
    }

    /**
     *
     * @param tarifaNombre
     */
    public void setTarifaNombre(Object tarifaNombre) {
        TarifaNombre = tarifaNombre;
    }

    /**
     *
     * @return
     */
    public Object getCpNombre() {
        return CpNombre;
    }

    /**
     *
     * @param cpNombre
     */
    public void setCpNombre(Object cpNombre) {
        CpNombre = cpNombre;
    }

    /**
     *
     * @return
     */
    public Object getNombreCompletoTitular() {
        return NombreCompletoTitular;
    }

    /**
     *
     * @param nombreCompletoTitular
     */
    public void setNombreCompletoTitular(Object nombreCompletoTitular) {
        NombreCompletoTitular = nombreCompletoTitular;
    }

    /**
     *
     * @return
     */
    public String getCiudadNombre() {
        return CiudadNombre;
    }

    /**
     *
     * @param ciudadNombre
     */
    public void setCiudadNombre(String ciudadNombre) {
        CiudadNombre = ciudadNombre;
    }

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
}

