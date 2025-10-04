package co.ed.uco.nose.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import java.util.UUID;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type_id", nullable = false)
    private DocumentTypeEntity documentType;

    @Column(name = "document_number", nullable = false, length = 25)
    private String documentNumber;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "second_name", length = 20)
    private String secondName;

    @Column(name = "first_surname", nullable = false, length = 20)
    private String firstSurname;

    @Column(name = "second_surname", nullable = false, length = 20)
    private String secondSurname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "residence_city_id", nullable = false)
    private CityEntity residenceCity;

    @Column(name = "email", nullable = false, length = 250)
    private String email;

    @Column(name = "mobile_phone_number", nullable = false, length = 20)
    private String mobilePhoneNumber;

    @Column(name = "email_confirmed", nullable = false)
    private boolean emailConfirmed;

    @Column(name = "mobile_phone_number_confirmed", nullable = false)
    private boolean mobilePhoneNumberConfirmed;

    // Default constructor
    public UserEntity() {
    }

    // Complete constructor
    public UserEntity(final UUID id, final DocumentTypeEntity documentType, final String documentNumber,
                      final String firstName, final String secondName, final String firstSurname,
                      final String secondSurname, final CityEntity residenceCity, final String email,
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

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public DocumentTypeEntity getDocumentType() {
        return documentType;
    }

    public void setDocumentType(final DocumentTypeEntity documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(final String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(final String secondName) {
        this.secondName = secondName;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(final String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(final String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public CityEntity getResidenceCity() {
        return residenceCity;
    }

    public void setResidenceCity(final CityEntity residenceCity) {
        this.residenceCity = residenceCity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(final String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(final boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public boolean isMobilePhoneNumberConfirmed() {
        return mobilePhoneNumberConfirmed;
    }

    public void setMobilePhoneNumberConfirmed(final boolean mobilePhoneNumberConfirmed) {
        this.mobilePhoneNumberConfirmed = mobilePhoneNumberConfirmed;
    }
}