package co.ed.uco.nose.dto;

import java.util.UUID;

public class CityDTO {

    private UUID id;
    private StateDTO state;
    private String name;

    // Default constructor
    public CityDTO() {
        // Optional initial values
    }

    // Complete constructor
    public CityDTO(final UUID id, final StateDTO state, final String name) {
        this.id = id;
        this.state = state;
        this.name = name;
    }

    public CityDTO(UUID id) {
        this.id = id;
        this.state = new StateDTO();
        this.name = "";
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public StateDTO getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    // Setters (optional)
    public void setId(final UUID id) {
        this.id = id;
    }

    public void setDepartment(final StateDTO state) {
        this.state = state;
    }

    public void setName(final String name) {
        this.name = name;
    }
}