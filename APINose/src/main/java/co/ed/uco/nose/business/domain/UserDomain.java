package co.ed.uco.nose.business.domain;

import java.util.UUID;

import co.ed.uco.nose.crosscuting.helper.EmailHelper;
import co.ed.uco.nose.crosscuting.helper.ObjectHelper;
import co.ed.uco.nose.crosscuting.helper.PhoneHelper;
import co.ed.uco.nose.crosscuting.helper.TextHelper;
import co.ed.uco.nose.crosscuting.helper.UUIDHelper;

public final class UserDomain extends Domain {
	
	// Atributos
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;
	private String email;
	private DocumentTypeDomain documentType;
	private String documentNumber;
	private CityDomain residenceCity;
	private String mobilePhoneNumber;
	private boolean emailConfirmed;
	private boolean mobilePhoneNumberConfirmed;
			
	// Constructor que asigna un ID y valores por defecto
	public UserDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setFirstName(TextHelper.getDefault());
		setSecondName(TextHelper.getDefault());
		setFirstSurname(TextHelper.getDefault());
		setSecondSurname(TextHelper.getDefault());
		setEmail(EmailHelper.getDefault());
		setDocumentType(new DocumentTypeDomain());
		setDocumentNumber(TextHelper.getDefault());
		setResidenceCity(new CityDomain());
		setMobilePhoneNumber(PhoneHelper.getDefault());
		setEmailConfirmed(false);
		setMobilePhoneNumberConfirmed(false);
	}
			
	// Constructor que asigna un ID y valores por defecto
	public UserDomain(final UUID id) {
		super(id);
		setFirstName(TextHelper.getDefault());
		setSecondName(TextHelper.getDefault());
		setFirstSurname(TextHelper.getDefault());
		setSecondSurname(TextHelper.getDefault());
		setEmail(EmailHelper.getDefault());
		setDocumentType(new DocumentTypeDomain());
		setDocumentNumber(TextHelper.getDefault());
		setResidenceCity(new CityDomain());
		setMobilePhoneNumber(PhoneHelper.getDefault());
		setEmailConfirmed(false);
		setMobilePhoneNumberConfirmed(false);
	}
			
	// Constructor que asigna un ID y todos los valores
	public UserDomain(final UUID id, final String firstName, final String secondName, final String firstSurname,
			final String secondSurname, final String email, final DocumentTypeDomain documentType,
			final String documentNumber, final CityDomain residenceCity, final String mobilePhoneNumber,
			final boolean emailConfirmed, final boolean mobilePhoneNumberConfirmed) {
		super(id);
		setFirstName(firstName);
		setSecondName(secondName);
		setFirstSurname(firstSurname);
		setSecondSurname(secondSurname);
		setEmail(email);
		setDocumentType(documentType);
		setDocumentNumber(documentNumber);
		setResidenceCity(residenceCity);
		setMobilePhoneNumber(mobilePhoneNumber);
		setEmailConfirmed(emailConfirmed);
		setMobilePhoneNumberConfirmed(mobilePhoneNumberConfirmed);
	}
	
	// Getters
	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public String getFirstSurname() {
		return firstSurname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public String getEmail() {
		return email;
	}

	public DocumentTypeDomain getDocumentType() {
		return documentType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public CityDomain getResidenceCity() {
		return residenceCity;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}

	public boolean isMobilePhoneNumberConfirmed() {
		return mobilePhoneNumberConfirmed;
	}

	// Setters
	// Si el primer nombre es nulo, le asigna un valor por defecto y le quita los espacios en blanco al inicio y al final
	public void setFirstName(final String firstName) {
		this.firstName = TextHelper.getDefaultWithTrim(firstName);
	}

	// Si el segundo nombre es nulo, le asigna un valor por defecto y le quita los espacios en blanco al inicio y al final
	public void setSecondName(final String secondName) {
		this.secondName = TextHelper.getDefaultWithTrim(secondName);
	}

	// Si el primer apellido es nulo, le asigna un valor por defecto y le quita los espacios en blanco al inicio y al final
	public void setFirstSurname(final String firstSurname) {
		this.firstSurname = TextHelper.getDefaultWithTrim(firstSurname);
	}

	// Si el segundo apellido es nulo, le asigna un valor por defecto y le quita los espacios en blanco al inicio y al final
	public void setSecondSurname(final String secondSurname) {
		this.secondSurname = TextHelper.getDefaultWithTrim(secondSurname);
	}

	// Si el email es nulo o inválido, le asigna un valor por defecto con validación
	public void setEmail(final String email) {
		this.email = EmailHelper.getDefaultWithValidation(email);
	}

	// Si el tipo de documento es nulo, le asigna un valor por defecto
	public void setDocumentType(final DocumentTypeDomain documentType) {
		this.documentType = ObjectHelper.getDefaultIfNull(documentType, new DocumentTypeDomain());
	}

	// Si el número de documento es nulo, le asigna un valor por defecto y le quita los espacios en blanco al inicio y al final
	public void setDocumentNumber(final String documentNumber) {
		this.documentNumber = TextHelper.getDefaultWithTrim(documentNumber);
	}

	// Si la ciudad de residencia es nula, le asigna un valor por defecto
	public void setResidenceCity(final CityDomain residenceCity) {
		this.residenceCity = ObjectHelper.getDefaultIfNull(residenceCity, new CityDomain());
	}

	// Si el número de teléfono móvil es nulo o inválido, le asigna un valor por defecto con validación
	public void setMobilePhoneNumber(final String mobilePhoneNumber) {
		this.mobilePhoneNumber = PhoneHelper.getDefaultWithValidation(mobilePhoneNumber);
	}

	// Setter para el estado de confirmación del email
	public void setEmailConfirmed(final boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	// Setter para el estado de confirmación del número de teléfono móvil
	public void setMobilePhoneNumberConfirmed(final boolean mobilePhoneNumberConfirmed) {
		this.mobilePhoneNumberConfirmed = mobilePhoneNumberConfirmed;
	}
}