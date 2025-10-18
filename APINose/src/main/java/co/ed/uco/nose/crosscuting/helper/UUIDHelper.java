package co.ed.uco.nose.crosscuting.helper;

import java.util.UUID;

// Singleton: uso de una sola instancia
public final class UUIDHelper {
	
	//Única instancia
	private static final UUIDHelper INSTANCE = new UUIDHelper();
	private static final String UUID_DEFAULT_AS_STRING = "00000000-0000-0000-0000-000000000000";
	
	//Constructor privado
	private UUIDHelper() {	
	}
	
	//Retorna la única instancia
	public static UUIDHelper getUUIDHelper() {
		return INSTANCE;
	}
	
	//Retorna el valor por defecto
	public static java.util.UUID getDefault() {
		return getFromString(UUID_DEFAULT_AS_STRING);
	}
	
	//Si el valor es nulo, retorna el valor por defecto
	public UUID getDefault(final UUID value) {
		return ObjectHelper.getDefaultIfNull(value, getDefault());
	}
	
	//Si la cadena no es un UUID válido, retorna el valor por defecto
	public static UUID getFromString(final String uuidAsString) {
		return (TextHelper.isEmpty(uuidAsString) ? getDefault() : UUID.fromString(uuidAsString));
	}
	
	public static UUID generateUUID() {
		return UUID.randomUUID();
	}
}
