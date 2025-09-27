package co.ed.uco.nose.business.domain;

import java.util.UUID;
import co.ed.uco.nose.crosscuting.helper.TextHelper;
import co.ed.uco.nose.crosscuting.helper.UUIDHelper;

public final class CountryDomain extends Domain{
	
	//Atributos
	private String name;
	
	//Constructor que asigna un ID y un nombre por defecto
	public CountryDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
	}
	
	//Constructor que asigna un ID por defecto y un nombre
	public CountryDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
	}
	
	//Constructor que asigna un ID y un nombre
	public CountryDomain(final UUID id, final String name) {
		super(id);
		setName(name);
	}
	
	//Getter
	public String getName() {
		return name;
	}

	//Setter /Si el nombre es nulo, le asigna un valor por defecto y le quita los espacios en blanco al inicio y al final
	public void setName(final String name) {
		this.name = TextHelper.getDefaultWhithTrim(name);
	}
	
}