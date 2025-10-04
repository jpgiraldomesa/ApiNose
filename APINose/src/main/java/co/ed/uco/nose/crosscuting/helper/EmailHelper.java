package co.ed.uco.nose.crosscuting.helper;

public final class EmailHelper {

    // Valor por defecto
    private static final String DEFAULT_EMAIL = "default@example.com";

    // Constructor privado
    private EmailHelper() {
    }

    // Retorna el valor por defecto
    public static String getDefault() {
        return DEFAULT_EMAIL;
    }

    // Retorna el valor por defecto si es nulo, vacío o inválido, utilizando TextHelper para trim
    public static String getDefaultWhithValidation(final String email) {
        String trimmedEmail = TextHelper.getDefaultWhithTrim(email);
        return (TextHelper.isNullOrWhitespace(trimmedEmail) || !isValidEmail(trimmedEmail)) ? getDefault() : trimmedEmail;
    }

    // Validación básica de formato de correo electrónico
    private static boolean isValidEmail(final String email) {
        // Expresión regular básica para validar correos
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email != null && email.matches(emailRegex);
    }
}