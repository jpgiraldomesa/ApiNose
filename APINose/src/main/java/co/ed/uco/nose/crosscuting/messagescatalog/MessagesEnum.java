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