package co.ed.uco.nose.dto;

import java.util.UUID;

public class DocumentTypeDTO {

    private UUID id;
    private String name;

    // Default constructor
    public DocumentTypeDTO() {
        // Optional initial values
    }

    // Complete constructor
    public DocumentTypeDTO(final UUID id, final String name) {
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

    // Setters (optional)
    public void setId(final UUID id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }
}