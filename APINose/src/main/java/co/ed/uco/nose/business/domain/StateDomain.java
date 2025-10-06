package co.ed.uco.nose.business.domain;

import java.util.UUID;

import co.ed.uco.nose.crosscuting.helper.ObjectHelper;
import co.ed.uco.nose.crosscuting.helper.TextHelper;
import co.ed.uco.nose.crosscuting.helper.UUIDHelper;

public final class StateDomain extends Domain {

    // Atributos
    private String name;
    private CountryDomain country;

    // Constructor que asigna un ID y valores por defecto
    public StateDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault()); // Uso de la instancia singleton
        setName(TextHelper.getDefault());
        setCountry(new CountryDomain()); // País por defecto
    }

    // Constructor que asigna un ID por defecto y un nombre
    public StateDomain(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
        setCountry(new CountryDomain());
    }

    // Constructor que asigna un ID, un nombre y un país
    public StateDomain(final UUID id, final String name, final CountryDomain country) {
        super(id);
        setName(name);
        setCountry(country);
    }

    // Getter para el nombre
    public String getName() {
        return name;
    }

    // Setter para el nombre, usando TextHelper para manejar nulos y espacios
    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    // Getter para el país
    public CountryDomain getCountry() {
        return country;
    }

    // Setter para el país, asegurando que no sea nulo
    public void setCountry(final CountryDomain country) {
        this.country = ObjectHelper.getDefaultIfNull(country, new CountryDomain());
    }
}