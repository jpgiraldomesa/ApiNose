package co.ed.uco.nose.crosscuting.helper;

public final class PhoneHelper {

    // Valor por defecto
    private static final String DEFAULT_PHONE = "+0000000000";

    // Constructor privado
    private PhoneHelper() {
    }

    // Retorna el valor por defecto
    public static String getDefault() {
        return DEFAULT_PHONE;
    }

    // Retorna el valor por defecto si es nulo o inválido, con validación de formato
    public static String getDefaultWithValidation(final String phone) {
        String trimmedPhone = ObjectHelper.getDefault(phone, "").trim();
        return (trimmedPhone.isEmpty() || !isValidPhone(trimmedPhone)) ? getDefault() : trimmedPhone;
    }

    // Validación básica de formato de número telefónico (ejemplo: +1234567890)
    private static boolean isValidPhone(final String phone) {
        // Expresión regular básica para validar números telefónicos (incluye + y al menos 10 dígitos)
        String phoneRegex = "^\\+[0-9]{10,}$";
        return phone != null && phone.matches(phoneRegex);
    }
}