package co.ed.uco.nose.business.assembler.entity.impl;
import static co.ed.uco.nose.business.assembler.entity.impl.StateEntityAssembler.getStateEntityAssembler;

import java.util.List;

import co.ed.uco.nose.business.assembler.entity.EntityAssembler;
import co.ed.uco.nose.business.domain.CityDomain;
import co.ed.uco.nose.crosscuting.helper.ObjectHelper;
import co.ed.uco.nose.crosscuting.helper.UUIDHelper;
import co.ed.uco.nose.entity.CityEntity;

public final class CityEntityAssembler implements EntityAssembler<CityEntity, CityDomain> {
	
	private static final EntityAssembler<CityEntity, CityDomain> INSTANCE = new CityEntityAssembler();
	
	private CityEntityAssembler() {	
	}
	
	public static EntityAssembler<CityEntity, CityDomain> getCityEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public CityEntity toEntityFromDomain(CityDomain domain) {
		var DomainTmp = ObjectHelper.getDefault(domain, new CityDomain(UUIDHelper.getDefault()));
		var stateEntityTmp = getStateEntityAssembler().toEntityFromDomain(DomainTmp.getState());
		return new CityEntity(DomainTmp.getId(), stateEntityTmp , DomainTmp.getName());
	}

	@Override
	public CityDomain toDomainFromEntity(CityEntity Entity) {
		var EntityTmp = ObjectHelper.getDefault(Entity, new CityEntity());
		var stateDomainTmp = getStateEntityAssembler().toDomainFromEntity(EntityTmp.getState());
		return new CityDomain(EntityTmp.getId(), EntityTmp.getName(), stateDomainTmp);
	}

	@Override
	public List<CityEntity> toEntityListFromDomainList(List<CityDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
}