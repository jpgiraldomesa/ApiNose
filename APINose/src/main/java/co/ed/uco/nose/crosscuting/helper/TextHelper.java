package co.ed.uco.nose.crosscuting.helper;

public final class TextHelper {

	//Valor por defecto
	private static final String Empty = "";
	
	//Constructor privado
	private TextHelper() {
	}
	
	
	//Retorna el valor por defecto
	public static String getDefault() {
		return Empty;
	}
	
	//Si llega un valor nulo, retorna el valor por defecto
	public static String getDefault(final String value) {
		return ObjectHelper.getDefaultIfNull(value, getDefault());
	}
	
	//Si llega un valor nulo, retorna el valor por defecto y le quita los espacios en blanco al inicio y al final
	public static String getDefaultWhithTrim(final String value) {
		return getDefault(value).trim();
	}
	
	//Verifica si una cadena está vacía
	public static boolean isEmpty(final String value) {
		return Empty.equals(getDefault(value));
	}
}
