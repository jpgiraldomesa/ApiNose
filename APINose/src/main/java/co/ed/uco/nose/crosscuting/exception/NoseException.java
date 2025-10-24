package co.ed.uco.nose.crosscuting.exception;

import co.ed.uco.nose.crosscuting.helper.ObjectHelper;
import co.ed.uco.nose.crosscuting.helper.TextHelper;

/**
 * Excepción personalizada para el proyecto Nose, extensible con mensajes de usuario y técnicos.
 * Diseñada para inmutabilidad y manejo de root cause.
 */
public final class NoseException extends RuntimeException {

    /**
     * Serial version UID para serialización.
     */
    private static final long serialVersionUID = 6619379739460519543L;

    private final Throwable rootException;
    private final String userMessage;
    private final String technicalMessage;

    private NoseException(final Throwable rootException, final String userMessage, final String technicalMessage) {
        super(TextHelper.getDefaultWithTrim(technicalMessage), ObjectHelper.getDefault(rootException, new Exception()));
        this.rootException = ObjectHelper.getDefault(rootException, new Exception());
        this.userMessage = TextHelper.getDefaultWithTrim(userMessage);
        this.technicalMessage = TextHelper.getDefaultWithTrim(technicalMessage);
    }

    // Fábricas estáticas para creación
    public static NoseException create(final String userMessage) {
        return new NoseException(new Exception(), userMessage, userMessage);
    }

    public static NoseException create(final String userMessage, final String technicalMessage) {
        return new NoseException(new Exception(), userMessage, technicalMessage);
    }

    public static NoseException create(final Throwable rootException, final String userMessage, final String technicalMessage) {
        return new NoseException(rootException, userMessage, technicalMessage);
    }

    public String getUserMessage() {
        return userMessage;
    }

    public String getTechnicalMessage() {
        return technicalMessage;
    }
}