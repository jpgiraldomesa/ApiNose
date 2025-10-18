package co.ed.uco.nose.entity;

import java.util.UUID;
import java.util.Objects;

public class CountryEntity {
    private UUID id;
    private String name; // NVARCHAR(50) NOT NULL

    // Constructor vacío para mapeo
    public CountryEntity() {}

    public CountryEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
        CountryEntity that = (CountryEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}