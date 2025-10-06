package co.ed.uco.nose.business.domain;

import java.util.UUID;

import co.ed.uco.nose.crosscuting.helper.ObjectHelper;
import co.ed.uco.nose.crosscuting.helper.TextHelper;
import co.ed.uco.nose.crosscuting.helper.UUIDHelper;

public final class CityDomain extends Domain {

    // Atributos
    private String name;
    private StateDomain department; // Referencia al DepartmentDomain asociado

    // Constructor que asigna un ID y valores por defecto
    public CityDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setDepartment(new StateDomain()); // Departamento por defecto
    }

    // Constructor que asigna un ID por defecto y un nombre
    public CityDomain(final UUID id) {
        super(id);
        setName(TextHelper.getDefault());
        setDepartment(new StateDomain()); // Departamento por defecto
    }

    // Constructor que asigna un ID, un nombre y un departamento
    public CityDomain(final UUID id, final String name, final StateDomain department) {
        super(id);
        setName(name);
        setDepartment(department);
    }

    // Getter para el nombre
    public String getName() {
        return name;
    }

    // Setter para el nombre, usando TextHelper para manejar nulos y espacios
    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    // Getter para el departamento
    public StateDomain getDepartment() {
        return department;
    }

    // Setter para el departamento, asegurando que no sea nulo
    public void setDepartment(final StateDomain department) {
        this.department = ObjectHelper.getDefaultIfNull(department, new StateDomain());
    }
}