package co.ed.uco.nose.crosscuting.messagescatalog;

import co.ed.uco.nose.crosscuting.helper.TextHelper;

public enum MessagesEnum {
	
	USER_ERROR_SQL_CONNECTION_IS_EMPTY("CONEXION CONTRA LA FUENTE DE INFORMACIÓN DESEADA VACÍA","la conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada esta vacia. Por favor intente de nuevo y si el probelam persiste, contacte al administrador de la aplicación."),
	TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY("CONEXION CONTRA LA FUENTE DE INFORMACION DE SEADA NULA","La conexion requerida para llevar a cabo la operacion contra la base de datos llegó nula."),
	USER_ERROR_SQL_CONNECTION_IS_CLOSED("CONEXION CONTRA LA FUENTE DE DATOS DESEADA CERRADA","La conexion requerida para llevar a cabo la operacion contra la fuente de datos deseada llego cerrada. Por favor intente de nuevo y si el probelam persiste, contacte al administrador de la aplicación."),
	TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED("CONEXION CONTRA LA FUENTE DE DATOS DESEADA CERRADA","La conexion requerida para llevar a cabo la operacion contra la fuente de datos deseada llego cerrada."),
	USER_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("PROBLEMA INESPERADO, VALIDANDO LA CONEXION CONTRA LA FUENTE DE DATOS DESEADA","Se ha presentado un problema inesperado tratando de validar el estado de la conexion requeridarada. Por favor intente de nuevo y si el probelam persiste, contacte al administrador de la aplicación."),
	TECHNICAL_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("ERROR INESPERADO, VALIDANDO SI LA CONEXION CONTRA LA BASE DE DATOS ESTABA ABIERTA","Se presento un error de tipo SQLException al validar si la conexion contra la base de datos estaba o no abierta. por favor valide la consola de errores para revisar con detalle el problema presentado"),
	
	;
	
	private String title;
	private String content;
	
	private MessagesEnum(final String title,final String content) {
		setTitle(title);
		setContent(content);
	}


	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public void setTitle(final String title) {
		this.title = TextHelper.getDefaultWhithTrim(title);
	}

	public void setContent(final String content) {
		this.content = TextHelper.getDefaultWhithTrim(content);
	}
	
	
	

	
}
