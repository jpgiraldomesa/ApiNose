package co.ed.uco.nose.business.domain;

import java.util.UUID;

import co.ed.uco.nose.crosscuting.helper.UUIDHelper;

class Domain {
	
	private UUID id;
	//Constructor que asigna un ID por defecto
	protected Domain(final UUID id) {
		setId(id);
	}
	//Getter
	public UUID getId() {
		return id;
	}

	//Setter / Si el ID es nulo, le asigna un valor por defecto
	public void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
		
}
