package co.ed.uco.nose.crosscuting.messagescatalog;

import co.ed.uco.nose.crosscuting.helper.TextHelper;

/**
 * Enum que centraliza mensajes estandarizados para errores comunes en operaciones de conexión y transacciones SQL.
 * Agrupados por categoría para mayor organización: conexión (validaciones básicas) y transacciones (manejo de estado y errores SQLException).
 * Cada entrada incluye un título (para logs/títulos de error) y contenido (descripción detallada).
 */
public enum MessagesEnum {
    
    // --- Mensajes para Validaciones de Conexión ---
    USER_ERROR_SQL_CONNECTION_IS_EMPTY(
        "CONEXIÓN CONTRA LA FUENTE DE INFORMACIÓN DESEADA VACÍA",
        "La conexión requerida para llevar a cabo la operación contra la fuente de información deseada está vacía. Por favor, intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."
    ),
    
    TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY(
        "CONEXIÓN CONTRA LA FUENTE DE INFORMACIÓN DESEADA NULA",
        "La conexión requerida para llevar a cabo la operación contra la base de datos llegó nula."
    ),
    
    USER_ERROR_SQL_CONNECTION_IS_CLOSED(
        "CONEXIÓN CONTRA LA FUENTE DE DATOS DESEADA CERRADA",
        "La conexión requerida para llevar a cabo la operación contra la fuente de datos deseada llegó cerrada. Por favor, intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."
    ),
    
    TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED(
        "CONEXIÓN CONTRA LA FUENTE DE DATOS DESEADA CERRADA",
        "La conexión requerida para llevar a cabo la operación contra la fuente de datos deseada llegó cerrada."
    ),
    
    USER_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS(
        "PROBLEMA INESPERADO VALIDANDO LA CONEXIÓN CONTRA LA FUENTE DE DATOS DESEADA",
        "Se ha presentado un problema inesperado tratando de validar el estado de la conexión requerida. Por favor, intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."
    ),
    
    TECHNICAL_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS(
        "ERROR INESPERADO VALIDANDO SI LA CONEXIÓN CONTRA LA BASE DE DATOS ESTÁ ABIERTA",
        "Se presentó un error de tipo SQLException al validar si la conexión contra la base de datos estaba o no abierta. Por favor, valide la consola de errores para revisar con detalle el problema presentado."
    ),
    
    // --- Mensajes para Validaciones y Manejo de Transacciones ---
    USER_ERROR_TRANSACTION_NOT_INITIATED(
        "TRANSACCIÓN NO INICIADA PARA LA OPERACIÓN DESEADA",
        "La transacción no ha sido iniciada previamente para llevar a cabo la operación deseada (por ejemplo, INSERT, UPDATE o DELETE). Por favor, inicie la transacción antes de proceder."
    ),
    
    TECHNICAL_ERROR_TRANSACTION_NOT_INITIATED(
        "TRANSACCIÓN NO INICIADA EN LA BASE DE DATOS SQL DESEADA",
        "La transacción no ha sido iniciada (autoCommit sigue en true) para realizar la operación en la base de datos SQL deseada."
    ),
    
    USER_ERROR_TRANSACTION_ALREADY_INITIATED(
        "TRANSACCIÓN YA INICIADA PARA LA OPERACIÓN DESEADA",
        "La transacción ya ha sido iniciada previamente. No es posible iniciarla nuevamente para la operación deseada."
    ),
    
    TECHNICAL_ERROR_TRANSACTION_ALREADY_INITIATED(
        "TRANSACCIÓN YA INICIADA EN LA BASE DE DATOS SQL DESEADA",
        "La transacción ya ha sido iniciada (autoCommit en false) en la base de datos SQL deseada."
    ),
    
    USER_ERROR_TRANSACTION_COMMIT_FAILED(
        "ERROR AL CONFIRMAR LA TRANSACCIÓN DESEADA",
        "Se ha presentado un problema inesperado al confirmar la transacción. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    
    TECHNICAL_ERROR_TRANSACTION_COMMIT_FAILED(
        "SQLException AL CONFIRMAR LA TRANSACCIÓN EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al confirmar la transacción en la base de datos SQL deseada."
    ),
    
    USER_ERROR_TRANSACTION_ROLLBACK_FAILED(
        "ERROR AL CANCELAR LA TRANSACCIÓN DESEADA",
        "Se ha presentado un problema inesperado al cancelar la transacción. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    
    TECHNICAL_ERROR_TRANSACTION_ROLLBACK_FAILED(
        "SQLException AL CANCELAR LA TRANSACCIÓN EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al cancelar la transacción en la base de datos SQL deseada."
    ),
    
    USER_ERROR_CONNECTION_CLOSE_FAILED(
        "ERROR AL CERRAR LA CONEXIÓN DESEADA",
        "Se ha presentado un problema inesperado al cerrar la conexión. Por favor, intente de nuevo."
    ),
    
    TECHNICAL_ERROR_CONNECTION_CLOSE_FAILED(
        "SQLException AL CERRAR LA CONEXIÓN EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al cerrar la conexión a la base de datos SQL deseada."
    ),
    
    // --- Mensajes para Errores SQLException en Apertura/Iniciación ---
    USER_ERROR_CONNECTION_OPEN_FAILED(
        "ERROR AL ABRIR LA CONEXIÓN DESEADA",
        "Se ha presentado un problema inesperado al abrir la conexión a la fuente de datos. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    
    TECHNICAL_ERROR_CONNECTION_OPEN_FAILED(
        "SQLException AL ABRIR LA CONEXIÓN EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al obtener la conexión a la base de datos SQL deseada."
    ),
    
    USER_ERROR_TRANSACTION_INIT_FAILED(
        "ERROR AL INICIAR LA TRANSACCIÓN DESEADA",
        "Se ha presentado un problema inesperado al iniciar la transacción. Por favor, intente de nuevo."
    ),
    
    TECHNICAL_ERROR_TRANSACTION_INIT_FAILED(
        "SQLException AL INICIAR LA TRANSACCIÓN EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al iniciar la transacción en la base de datos SQL deseada."
    ),
    
 // --- User: Creación ---
    USER_ERROR_USER_CREATE(
        "ERROR AL CREAR EL USUARIO DESEADO",
        "Se ha presentado un problema inesperado al crear el usuario. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_USER_CREATE(
        "SQLException AL CREAR EL USUARIO EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al crear el usuario en la base de datos SQL deseada."
    ),
    USER_ERROR_USER_CREATE_UNEXPECTED(
        "ERROR INESPERADO AL CREAR EL USUARIO DESEADO",
        "Se ha presentado un problema inesperado al crear el usuario. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_USER_CREATE_UNEXPECTED(
        "EXCEPCIÓN INESPERADA AL CREAR EL USUARIO EN LA BASE DE DATOS SQL",
        "Se presentó una excepción inesperada al crear el usuario en la base de datos SQL deseada."
    ),

    // --- User: Consulta Todos ---
    USER_ERROR_USER_FIND_ALL(
        "ERROR AL CONSULTAR LOS USUARIOS",
        "Se ha presentado un problema inesperado al consultar los usuarios. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_USER_FIND_ALL(
        "SQLException AL CONSULTAR LOS USUARIOS EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al consultar los usuarios en la base de datos SQL deseada."
    ),
    USER_ERROR_USER_FIND_ALL_UNEXPECTED(
        "ERROR INESPERADO AL CONSULTAR LOS USUARIOS",
        "Se ha presentado un problema inesperado al consultar los usuarios. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_USER_FIND_ALL_UNEXPECTED(
        "EXCEPCIÓN INESPERADA AL CONSULTAR LOS USUARIOS EN LA BASE DE DATOS SQL",
        "Se presentó una excepción inesperada al consultar los usuarios en la base de datos SQL deseada."
    ),

    // --- User: Consulta por Filtro ---
    USER_ERROR_USER_FIND_BY_FILTER(
        "ERROR AL CONSULTAR LOS USUARIOS SEGÚN EL FILTRO",
        "Se ha presentado un problema inesperado al consultar los usuarios según el filtro. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_USER_FIND_BY_FILTER(
        "SQLException AL CONSULTAR LOS USUARIOS SEGÚN EL FILTRO EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al consultar los usuarios según el filtro en la base de datos SQL deseada."
    ),
    USER_ERROR_USER_FIND_BY_FILTER_UNEXPECTED(
        "ERROR INESPERADO AL CONSULTAR LOS USUARIOS SEGÚN EL FILTRO",
        "Se ha presentado un problema inesperado al consultar los usuarios según el filtro. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_USER_FIND_BY_FILTER_UNEXPECTED(
        "EXCEPCIÓN INESPERADA AL CONSULTAR LOS USUARIOS SEGÚN EL FILTRO EN LA BASE DE DATOS SQL",
        "Se presentó una excepción inesperada al consultar los usuarios según el filtro en la base de datos SQL deseada."
    ),

    // --- User: Consulta por ID ---
    USER_ERROR_USER_FIND_BY_ID(
        "ERROR AL CONSULTAR EL USUARIO POR ID",
        "Se ha presentado un problema inesperado al consultar el usuario por ID. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_USER_FIND_BY_ID(
        "SQLException AL CONSULTAR EL USUARIO POR ID EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al consultar el usuario por ID en la base de datos SQL deseada."
    ),
    USER_ERROR_USER_FIND_BY_ID_UNEXPECTED(
        "ERROR INESPERADO AL CONSULTAR EL USUARIO POR ID",
        "Se ha presentado un problema inesperado al consultar el usuario por ID. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_USER_FIND_BY_ID_UNEXPECTED(
        "EXCEPCIÓN INESPERADA AL CONSULTAR EL USUARIO POR ID EN LA BASE DE DATOS SQL",
        "Se presentó una excepción inesperada al consultar el usuario por ID en la base de datos SQL deseada."
    ),

    // --- User: Actualización ---
    USER_ERROR_USER_UPDATE(
        "ERROR AL ACTUALIZAR EL USUARIO DESEADO",
        "Se ha presentado un problema inesperado al actualizar el usuario. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_USER_UPDATE(
        "SQLException AL ACTUALIZAR EL USUARIO EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al actualizar el usuario en la base de datos SQL deseada."
    ),
    USER_ERROR_USER_UPDATE_UNEXPECTED(
        "ERROR INESPERADO AL ACTUALIZAR EL USUARIO DESEADO",
        "Se ha presentado un problema inesperado al actualizar el usuario. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_USER_UPDATE_UNEXPECTED(
        "EXCEPCIÓN INESPERADA AL ACTUALIZAR EL USUARIO EN LA BASE DE DATOS SQL",
        "Se presentó una excepción inesperada al actualizar el usuario en la base de datos SQL deseada."
    ),

    // --- User: Eliminación ---
    USER_ERROR_USER_DELETE(
        "ERROR AL ELIMINAR EL USUARIO DESEADO",
        "Se ha presentado un problema inesperado al eliminar el usuario. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_USER_DELETE(
        "SQLException AL ELIMINAR EL USUARIO EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al eliminar el usuario en la base de datos SQL deseada."
    ),
    USER_ERROR_USER_DELETE_UNEXPECTED(
        "ERROR INESPERADO AL ELIMINAR EL USUARIO DESEADO",
        "Se ha presentado un problema inesperado al eliminar el usuario. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_USER_DELETE_UNEXPECTED(
        "EXCEPCIÓN INESPERADA AL ELIMINAR EL USUARIO EN LA BASE DE DATOS SQL",
        "Se presentó una excepción inesperada al eliminar el usuario en la base de datos SQL deseada."
    ),

    // --- User: UUID Inválido ---
    USER_ERROR_USER_INVALID_UUID(
        "UUID INVÁLIDO EN DATOS DE USUARIO",
        "Se ha presentado un problema con un UUID inválido en los datos del usuario. Por favor, verifique los datos e intente de nuevo."
    ),
    TECHNICAL_ERROR_USER_INVALID_UUID(
        "FORMATO UUID INVÁLIDO EN CONSULTA DE USUARIO",
        "Se presentó una excepción de tipo IllegalArgumentException al parsear un UUID en la consulta de usuario."
    ),

    // --- Country: Consulta Todos ---
    USER_ERROR_COUNTRY_FIND_ALL(
        "ERROR AL CONSULTAR LOS PAÍSES",
        "Se ha presentado un problema inesperado al consultar los países. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_COUNTRY_FIND_ALL(
        "SQLException AL CONSULTAR LOS PAÍSES EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al consultar los países en la base de datos SQL deseada."
    ),
    USER_ERROR_COUNTRY_FIND_ALL_UNEXPECTED(
        "ERROR INESPERADO AL CONSULTAR LOS PAÍSES",
        "Se ha presentado un problema inesperado al consultar los países. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_COUNTRY_FIND_ALL_UNEXPECTED(
        "EXCEPCIÓN INESPERADA AL CONSULTAR LOS PAÍSES EN LA BASE DE DATOS SQL",
        "Se presentó una excepción inesperada al consultar los países en la base de datos SQL deseada."
    ),

    // --- Country: Consulta por Filtro ---
    USER_ERROR_COUNTRY_FIND_BY_FILTER(
        "ERROR AL CONSULTAR LOS PAÍSES SEGÚN EL FILTRO",
        "Se ha presentado un problema inesperado al consultar los países según el filtro. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_COUNTRY_FIND_BY_FILTER(
        "SQLException AL CONSULTAR LOS PAÍSES SEGÚN EL FILTRO EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al consultar los países según el filtro en la base de datos SQL deseada."
    ),
    USER_ERROR_COUNTRY_FIND_BY_FILTER_UNEXPECTED(
        "ERROR INESPERADO AL CONSULTAR LOS PAÍSES SEGÚN EL FILTRO",
        "Se ha presentado un problema inesperado al consultar los países según el filtro. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_COUNTRY_FIND_BY_FILTER_UNEXPECTED(
        "EXCEPCIÓN INESPERADA AL CONSULTAR LOS PAÍSES SEGÚN EL FILTRO EN LA BASE DE DATOS SQL",
        "Se presentó una excepción inesperada al consultar los países según el filtro en la base de datos SQL deseada."
    ),

    // --- Country: Consulta por ID ---
    USER_ERROR_COUNTRY_FIND_BY_ID(
        "ERROR AL CONSULTAR EL PAÍS POR ID",
        "Se ha presentado un problema inesperado al consultar el país por ID. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_COUNTRY_FIND_BY_ID(
        "SQLException AL CONSULTAR EL PAÍS POR ID EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al consultar el país por ID en la base de datos SQL deseada."
    ),
    USER_ERROR_COUNTRY_FIND_BY_ID_UNEXPECTED(
        "ERROR INESPERADO AL CONSULTAR EL PAÍS POR ID",
        "Se ha presentado un problema inesperado al consultar el país por ID. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_COUNTRY_FIND_BY_ID_UNEXPECTED(
        "EXCEPCIÓN INESPERADA AL CONSULTAR EL PAÍS POR ID EN LA BASE DE DATOS SQL",
        "Se presentó una excepción inesperada al consultar el país por ID en la base de datos SQL deseada."
    ),

    // --- State: Consulta Todos ---
    USER_ERROR_STATE_FIND_ALL(
        "ERROR AL CONSULTAR LOS DEPARTAMENTOS",
        "Se ha presentado un problema inesperado al consultar los departamentos. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_STATE_FIND_ALL(
        "SQLException AL CONSULTAR LOS DEPARTAMENTOS EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al consultar los departamentos en la base de datos SQL deseada."
    ),
    USER_ERROR_STATE_FIND_ALL_UNEXPECTED(
        "ERROR INESPERADO AL CONSULTAR LOS DEPARTAMENTOS",
        "Se ha presentado un problema inesperado al consultar los departamentos. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_STATE_FIND_ALL_UNEXPECTED(
        "EXCEPCIÓN INESPERADA AL CONSULTAR LOS DEPARTAMENTOS EN LA BASE DE DATOS SQL",
        "Se presentó una excepción inesperada al consultar los departamentos en la base de datos SQL deseada."
    ),

    // --- State: Consulta por Filtro ---
    USER_ERROR_STATE_FIND_BY_FILTER(
        "ERROR AL CONSULTAR LOS DEPARTAMENTOS SEGÚN EL FILTRO",
        "Se ha presentado un problema inesperado al consultar los departamentos según el filtro. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_STATE_FIND_BY_FILTER(
        "SQLException AL CONSULTAR LOS DEPARTAMENTOS SEGÚN EL FILTRO EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al consultar los departamentos según el filtro en la base de datos SQL deseada."
    ),
    USER_ERROR_STATE_FIND_BY_FILTER_UNEXPECTED(
        "ERROR INESPERADO AL CONSULTAR LOS DEPARTAMENTOS SEGÚN EL FILTRO",
        "Se ha presentado un problema inesperado al consultar los departamentos según el filtro. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_STATE_FIND_BY_FILTER_UNEXPECTED(
        "EXCEPCIÓN INESPERADA AL CONSULTAR LOS DEPARTAMENTOS SEGÚN EL FILTRO EN LA BASE DE DATOS SQL",
        "Se presentó una excepción inesperada al consultar los departamentos según el filtro en la base de datos SQL deseada."
    ),

    // --- State: Consulta por ID ---
    USER_ERROR_STATE_FIND_BY_ID(
        "ERROR AL CONSULTAR EL DEPARTAMENTO POR ID",
        "Se ha presentado un problema inesperado al consultar el departamento por ID. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_STATE_FIND_BY_ID(
        "SQLException AL CONSULTAR EL DEPARTAMENTO POR ID EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al consultar el departamento por ID en la base de datos SQL deseada."
    ),
    USER_ERROR_STATE_FIND_BY_ID_UNEXPECTED(
        "ERROR INESPERADO AL CONSULTAR EL DEPARTAMENTO POR ID",
        "Se ha presentado un problema inesperado al consultar el departamento por ID. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_STATE_FIND_BY_ID_UNEXPECTED(
        "EXCEPCIÓN INESPERADA AL CONSULTAR EL DEPARTAMENTO POR ID EN LA BASE DE DATOS SQL",
        "Se presentó una excepción inesperada al consultar el departamento por ID en la base de datos SQL deseada."
    ),

    // --- City: Consulta Todos ---
    USER_ERROR_CITY_FIND_ALL(
        "ERROR AL CONSULTAR LAS CIUDADES",
        "Se ha presentado un problema inesperado al consultar las ciudades. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_CITY_FIND_ALL(
        "SQLException AL CONSULTAR LAS CIUDADES EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al consultar las ciudades en la base de datos SQL deseada."
    ),
    USER_ERROR_CITY_FIND_ALL_UNEXPECTED(
        "ERROR INESPERADO AL CONSULTAR LAS CIUDADES",
        "Se ha presentado un problema inesperado al consultar las ciudades. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_CITY_FIND_ALL_UNEXPECTED(
        "EXCEPCIÓN INESPERADA AL CONSULTAR LAS CIUDADES EN LA BASE DE DATOS SQL",
        "Se presentó una excepción inesperada al consultar las ciudades en la base de datos SQL deseada."
    ),

    // --- City: Consulta por Filtro ---
    USER_ERROR_CITY_FIND_BY_FILTER(
        "ERROR AL CONSULTAR LAS CIUDADES SEGÚN EL FILTRO",
        "Se ha presentado un problema inesperado al consultar las ciudades según el filtro. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_CITY_FIND_BY_FILTER(
        "SQLException AL CONSULTAR LAS CIUDADES SEGÚN EL FILTRO EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al consultar las ciudades según el filtro en la base de datos SQL deseada."
    ),
    USER_ERROR_CITY_FIND_BY_FILTER_UNEXPECTED(
        "ERROR INESPERADO AL CONSULTAR LAS CIUDADES SEGÚN EL FILTRO",
        "Se ha presentado un problema inesperado al consultar las ciudades según el filtro. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_CITY_FIND_BY_FILTER_UNEXPECTED(
        "EXCEPCIÓN INESPERADA AL CONSULTAR LAS CIUDADES SEGÚN EL FILTRO EN LA BASE DE DATOS SQL",
        "Se presentó una excepción inesperada al consultar las ciudades según el filtro en la base de datos SQL deseada."
    ),

    // --- City: Consulta por ID ---
    USER_ERROR_CITY_FIND_BY_ID(
        "ERROR AL CONSULTAR LA CIUDAD POR ID",
        "Se ha presentado un problema inesperado al consultar la ciudad por ID. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_CITY_FIND_BY_ID(
        "SQLException AL CONSULTAR LA CIUDAD POR ID EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al consultar la ciudad por ID en la base de datos SQL deseada."
    ),
    USER_ERROR_CITY_FIND_BY_ID_UNEXPECTED(
        "ERROR INESPERADO AL CONSULTAR LA CIUDAD POR ID",
        "Se ha presentado un problema inesperado al consultar la ciudad por ID. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_CITY_FIND_BY_ID_UNEXPECTED(
        "EXCEPCIÓN INESPERADA AL CONSULTAR LA CIUDAD POR ID EN LA BASE DE DATOS SQL",
        "Se presentó una excepción inesperada al consultar la ciudad por ID en la base de datos SQL deseada."
    ),

    // --- DocumentType: Consulta Todos ---
    USER_ERROR_DOCUMENT_TYPE_FIND_ALL(
        "ERROR AL CONSULTAR LOS TIPOS DE IDENTIFICACIÓN",
        "Se ha presentado un problema inesperado al consultar los tipos de identificación. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_DOCUMENT_TYPE_FIND_ALL(
        "SQLException AL CONSULTAR LOS TIPOS DE IDENTIFICACIÓN EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al consultar los tipos de identificación en la base de datos SQL deseada."
    ),
    USER_ERROR_DOCUMENT_TYPE_FIND_ALL_UNEXPECTED(
        "ERROR INESPERADO AL CONSULTAR LOS TIPOS DE IDENTIFICACIÓN",
        "Se ha presentado un problema inesperado al consultar los tipos de identificación. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_DOCUMENT_TYPE_FIND_ALL_UNEXPECTED(
        "EXCEPCIÓN INESPERADA AL CONSULTAR LOS TIPOS DE IDENTIFICACIÓN EN LA BASE DE DATOS SQL",
        "Se presentó una excepción inesperada al consultar los tipos de identificación en la base de datos SQL deseada."
    ),

    // --- DocumentType: Consulta por Filtro ---
    USER_ERROR_DOCUMENT_TYPE_FIND_BY_FILTER(
        "ERROR AL CONSULTAR LOS TIPOS DE IDENTIFICACIÓN SEGÚN EL FILTRO",
        "Se ha presentado un problema inesperado al consultar los tipos de identificación según el filtro. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_DOCUMENT_TYPE_FIND_BY_FILTER(
        "SQLException AL CONSULTAR LOS TIPOS DE IDENTIFICACIÓN SEGÚN EL FILTRO EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al consultar los tipos de identificación según el filtro en la base de datos SQL deseada."
    ),
    USER_ERROR_DOCUMENT_TYPE_FIND_BY_FILTER_UNEXPECTED(
        "ERROR INESPERADO AL CONSULTAR LOS TIPOS DE IDENTIFICACIÓN SEGÚN EL FILTRO",
        "Se ha presentado un problema inesperado al consultar los tipos de identificación según el filtro. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_DOCUMENT_TYPE_FIND_BY_FILTER_UNEXPECTED(
        "EXCEPCIÓN INESPERADA AL CONSULTAR LOS TIPOS DE IDENTIFICACIÓN SEGÚN EL FILTRO EN LA BASE DE DATOS SQL",
        "Se presentó una excepción inesperada al consultar los tipos de identificación según el filtro en la base de datos SQL deseada."
    ),

    // --- DocumentType: Consulta por ID ---
    USER_ERROR_DOCUMENT_TYPE_FIND_BY_ID(
        "ERROR AL CONSULTAR EL TIPO DE IDENTIFICACIÓN POR ID",
        "Se ha presentado un problema inesperado al consultar el tipo de identificación por ID. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_DOCUMENT_TYPE_FIND_BY_ID(
        "SQLException AL CONSULTAR EL TIPO DE IDENTIFICACIÓN POR ID EN LA BASE DE DATOS SQL",
        "Se presentó una excepción de tipo SQLException al consultar el tipo de identificación por ID en la base de datos SQL deseada."
    ),
    USER_ERROR_DOCUMENT_TYPE_FIND_BY_ID_UNEXPECTED(
        "ERROR INESPERADO AL CONSULTAR EL TIPO DE IDENTIFICACIÓN POR ID",
        "Se ha presentado un problema inesperado al consultar el tipo de identificación por ID. Por favor, intente de nuevo y contacte al administrador si persiste."
    ),
    TECHNICAL_ERROR_DOCUMENT_TYPE_FIND_BY_ID_UNEXPECTED(
        "EXCEPCIÓN INESPERADA AL CONSULTAR EL TIPO DE IDENTIFICACIÓN POR ID EN LA BASE DE DATOS SQL",
        "Se presentó una excepción inesperada al consultar el tipo de identificación por ID en la base de datos SQL deseada."
    ),

    // --- UUID Inválido (Genérico) ---
    USER_ERROR_INVALID_UUID(
        "UUID INVÁLIDO EN DATOS",
        "Se ha presentado un problema con un UUID inválido en los datos. Por favor, verifique los datos e intente de nuevo."
    ),
    TECHNICAL_ERROR_INVALID_UUID(
        "FORMATO UUID INVÁLIDO EN CONSULTA",
        "Se presentó una excepción de tipo IllegalArgumentException al parsear un UUID en la consulta."
    );
    
    private final String title;
    private final String content;
    
    private MessagesEnum(final String title, final String content) {
        this.title = TextHelper.getDefaultWithTrim(title);
        this.content = TextHelper.getDefaultWithTrim(content);
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}