package co.ed.uco.nose.dto;

import java.util.UUID;

public class CountryDTO {

    private UUID id;
    private String name;

    // Default constructor
    public CountryDTO() {
        // Optional initial values
    }

    // Complete constructor
    public CountryDTO(final UUID id, final String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setters (optional, for mutability)
    public void setId(final UUID id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }
}