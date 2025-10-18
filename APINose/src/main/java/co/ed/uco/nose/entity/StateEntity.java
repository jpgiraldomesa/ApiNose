package co.ed.uco.nose.entity;

import java.util.UUID;
import java.util.Objects;

public class StateEntity {
    private UUID id;
    private CountryEntity country; // FK NOT NULL
    private String name; // NVARCHAR(50) NOT NULL

    // Constructor vacío
    public StateEntity() {}

    public StateEntity(UUID id, CountryEntity country, String name) {
        this.id = id;
        this.country = country;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateEntity that = (StateEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}