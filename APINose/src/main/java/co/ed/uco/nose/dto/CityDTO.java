package co.ed.uco.nose.dto;

import java.util.UUID;

public class CityDTO {

    private UUID id;
    private StateDTO department;
    private String name;

    // Default constructor
    public CityDTO() {
        // Optional initial values
    }

    // Complete constructor
    public CityDTO(final UUID id, final StateDTO department, final String name) {
        this.id = id;
        this.department = department;
        this.name = name;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public StateDTO getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    // Setters (optional)
    public void setId(final UUID id) {
        this.id = id;
    }

    public void setDepartment(final StateDTO department) {
        this.department = department;
    }

    public void setName(final String name) {
        this.name = name;
    }
}