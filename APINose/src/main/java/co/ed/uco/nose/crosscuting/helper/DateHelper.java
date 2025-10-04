package co.ed.uco.nose.crosscuting.helper;

import java.util.Date;

public final class DateHelper {

    // Valor por defecto: fecha actual
    private static final Date DEFAULT_DATE = new Date();

    // Constructor privado para evitar instanciación
    private DateHelper() {
    }

    // Retorna el valor por defecto (fecha actual)
    public static Date getDefault() {
        return new Date(DEFAULT_DATE.getTime()); // Retorna una copia para evitar modificaciones
    }

    // Si llega un valor nulo, retorna el valor por defecto
    public static Date getDefault(final Date value) {
        return ObjectHelper.getDefaultIfNull(value, getDefault());
    }

    // Verifica si una fecha es nula o igual al valor por defecto
    public static boolean isDefault(final Date value) {
        return getDefault(value).equals(getDefault());
    }

    // Verifica si una fecha es anterior a la fecha actual
    public static boolean isBeforeNow(final Date value) {
        return getDefault(value).before(new Date());
    }

    // Verifica si una fecha es posterior a la fecha actual
    public static boolean isAfterNow(final Date value) {
        return getDefault(value).after(new Date());
    }

    // Retorna una copia segura de la fecha para evitar modificaciones externas
    public static Date getSafeCopy(final Date value) {
        return value != null ? new Date(value.getTime()) : getDefault();
    }
}