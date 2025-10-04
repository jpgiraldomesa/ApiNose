package co.ed.uco.nose.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import java.util.UUID;

@Entity
@Table(name = "country")
public class CountryEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    // Constructor por defecto
    public CountryEntity() {
    }

    // Constructor completo
    public CountryEntity(final UUID id, final String name) {
        this.id = id;
        this.name = name;
    }

    // Getters y Setters
    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}