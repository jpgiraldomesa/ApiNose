package co.ed.uco.nose.entity;

import java.util.UUID;
import java.util.Objects;

public class UserEntity {
    private UUID id;
    private DocumentTypeEntity documentType; // FK NOT NULL
    private String documentNumber; // NVARCHAR(25) NOT NULL
    private String firstName; // NVARCHAR(20) NOT NULL
    private String secondName; // NVARCHAR(20) NOT NULL
    private String firstSurname; // NVARCHAR(20) NOT NULL
    private String secondSurname; // NVARCHAR(20) NOT NULL
    private CityEntity residenceCity; // FK NOT NULL
    private String email; // NVARCHAR(250) NOT NULL
    private String mobilePhoneNumber; // NVARCHAR(20) NOT NULL
    private boolean emailConfirmed; // BIT NOT NULL
    private boolean mobilePhoneNumberConfirmed; // BIT NOT NULL

    // Constructor vacío
    public UserEntity() {}

    public UserEntity(UUID id, DocumentTypeEntity documentType, String documentNumber, String firstName, String secondName,
                      String firstSurname, String secondSurname, CityEntity residenceCity, String email,
                      String mobilePhoneNumber, boolean emailConfirmed, boolean mobilePhoneNumberConfirmed) {
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DocumentTypeEntity getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeEntity documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public CityEntity getResidenceCity() {
        return residenceCity;
    }

    public void setResidenceCity(CityEntity residenceCity) {
        this.residenceCity = residenceCity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public boolean isMobilePhoneNumberConfirmed() {
        return mobilePhoneNumberConfirmed;
    }

    public void setMobilePhoneNumberConfirmed(boolean mobilePhoneNumberConfirmed) {
        this.mobilePhoneNumberConfirmed = mobilePhoneNumberConfirmed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}