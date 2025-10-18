package co.ed.uco.nose.entity;

import java.util.UUID;
import java.util.Objects;

public class CityEntity {
    private UUID id;
    private StateEntity state; // FK NOT NULL
    private String name; // NVARCHAR(50) NOT NULL

    // Constructor vacío
    public CityEntity() {}

    public CityEntity(UUID id, StateEntity state, String name) {
        this.id = id;
        this.state = state;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public StateEntity getState() {
        return state;
    }

    public void setState(StateEntity state) {
        this.state = state;
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
        CityEntity that = (CityEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}