package co.ed.uco.nose.dto;

import java.util.UUID;


public final class UserDTO {

    private UUID id;
    private DocumentTypeDTO documentType;
    private String documentNumber;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private CityDTO residenceCity;
    private String email;
    private String mobilePhoneNumber;
    private boolean emailConfirmed;
    private boolean mobilePhoneNumberConfirmed;

    // Default constructor
    public UserDTO() {
        // Optional initial values
    }

    // Complete constructor
    public UserDTO(final UUID id, final DocumentTypeDTO documentType, final String documentNumber,
                   final String firstName, final String secondName, final String firstSurname,
                   final String secondSurname, final CityDTO residenceCity, final String email,
                   final String mobilePhoneNumber, final boolean emailConfirmed,
                   final boolean mobilePhoneNumberConfirmed) {
        this.id = id;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.residenceCity = residenceCity;
        this.email = email;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.emailConfirmed = emailConfirmed;
        this.mobilePhoneNumberConfirmed = mobilePhoneNumberConfirmed;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public DocumentTypeDTO getDocumentType() {
        return documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

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

    public CityDTO getResidenceCity() {
        return residenceCity;
    }

    public String getEmail() {
        return email;
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

    // Setters (optional, for mutability)
    public void setId(final UUID id) {
        this.id = id;
    }

    public void setDocumentType(final DocumentTypeDTO documentType) {
        this.documentType = documentType;
    }

    public void setDocumentNumber(final String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(final String secondName) {
        this.secondName = secondName;
    }

    public void setFirstSurname(final String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public void setSecondSurname(final String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public void setResidenceCity(final CityDTO residenceCity) {
        this.residenceCity = residenceCity;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setMobilePhoneNumber(final String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public void setEmailConfirmed(final boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public void setMobilePhoneNumberConfirmed(final boolean mobilePhoneNumberConfirmed) {
        this.mobilePhoneNumberConfirmed = mobilePhoneNumberConfirmed;
    }
}