package co.ed.uco.nose.crosscuting.helper;

public final class TextHelper {

    // Valor por defecto
    private static final String EMPTY = "";

    // Constructor privado para evitar instanciación
    private TextHelper() {
    }

    // Retorna el valor por defecto
    public static String getDefault() {
        return EMPTY;
    }

    // Retorna el valor por defecto si es nulo, con opción a trim
    public static String getDefault(final String value) {
        return ObjectHelper.getDefaultIfNull(value, getDefault());
    }

    // Retorna el valor por defecto si es nulo o solo espacios, y aplica trim
    public static String getDefaultWithTrim(final String value) {
        String trimmedValue = ObjectHelper.getDefaultIfNull(value, getDefault()).trim();
        return trimmedValue.isEmpty() ? getDefault() : trimmedValue;
    }

    // Verifica si una cadena está vacía o contiene solo espacios en blanco
    public static boolean isEmpty(final String value) {
        return ObjectHelper.getDefaultIfNull(value, getDefault()).trim().isEmpty();
    }

    // Verifica si una cadena es nula, vacía o contiene solo espacios en blanco
    public static boolean isNullOrWitespace(final String value) {
        return ObjectHelper.isNull(value) || value.trim().isEmpty();
    }
}