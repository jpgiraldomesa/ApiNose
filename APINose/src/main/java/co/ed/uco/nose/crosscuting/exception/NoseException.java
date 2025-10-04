package co.ed.uco.nose.crosscuting.exception;

import co.ed.uco.nose.crosscuting.helper.ObjectHelper;
import co.ed.uco.nose.crosscuting.helper.TextHelper;

public final class NoseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6619379739460519543L;
	//
	private Throwable rootException;
	private String userMessage;
	private String technicalMessage;
	
	private NoseException(final Throwable rootException,final String userMessage,final String technicalMessage) {
		super(technicalMessage, rootException);
		setUserMessage(userMessage);
		setTechnicalMessage(technicalMessage);
		setRootException(rootException);
	}
	
	public static NoseException create(final String userMessage) {
		return new NoseException(new Exception(), userMessage, userMessage);
	}
	
	public static NoseException create(final String userMessage, final String technicalMessage) {
		return new NoseException(new Exception(), userMessage, technicalMessage);
	}
	
	public static NoseException create(final Throwable rootException, final String userMessage, final String technicalMessage) {
		return new NoseException(rootException, userMessage, technicalMessage);
	}
	
	private static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	private Throwable getRootException() {
		return rootException;
	}
	
	private void setRootException(final Throwable rootException) {
		this.rootException = ObjectHelper.getDefaultIfNull(rootException, new Exception());
	}
	public String getUserMessage() {
		return userMessage;
	}
	
	private void setUserMessage(final String userMessage) {
		this.userMessage = TextHelper.getDefaultWhithTrim(userMessage);
	}	
	public String getTechnicalMessage() {
		return technicalMessage;
	}
	
	private void setTechnicalMessage(final String technicalMessage) {
		this.technicalMessage = TextHelper.getDefaultWhithTrim(technicalMessage);
	}	

}
