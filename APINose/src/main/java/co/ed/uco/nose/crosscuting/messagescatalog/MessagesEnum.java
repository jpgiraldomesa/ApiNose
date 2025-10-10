package co.ed.uco.nose.crosscuting.messagescatalog;

import co.ed.uco.nose.crosscuting.helper.TextHelper;

/**
 * Enum que centraliza mensajes estandarizados para errores comunes en operaciones de conexión SQL.
 * Cada entrada incluye un título (para logs/títulos de error) y contenido (descripción detallada).
 */
public enum MessagesEnum {
    
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
    );
    
    private String title;
    private String content;
    
    private MessagesEnum(final String title, final String content) {
        setTitle(title);
        setContent(content);
    }

    public String getTitle() {
        return title;
    }
    
    private void setTitle(final String title) {
		this.title = TextHelper.getDefaultWithTrim(title);
	}

    public String getContent() {
        return content;
    }
    
    private void setContent(final String content) {
    	this.content = TextHelper.getDefaultWithTrim(content);
    }
}