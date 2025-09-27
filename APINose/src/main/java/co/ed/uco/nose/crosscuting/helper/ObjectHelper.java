package co.ed.uco.nose.crosscuting.helper;

public final class ObjectHelper {
	
	//Constructor privado
	private ObjectHelper() {
		
	}
	
	//Verifica si un objeto es nulo
	public static <O> boolean isNull(final O object) {
		return object == null;
	}
	
	//Si un objeto es nulo, retorna un valor por defecto
	public static <O> O getDefaultIfNull(final O object, final O DefaultValue) {
		return (isNull(object) ? DefaultValue : object);
	}	
}