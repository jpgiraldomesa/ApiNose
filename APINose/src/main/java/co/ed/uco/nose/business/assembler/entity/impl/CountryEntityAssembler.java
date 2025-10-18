package co.ed.uco.nose.business.assembler.entity.impl;

import java.util.List;

import co.ed.uco.nose.business.assembler.entity.EntityAssembler;
import co.ed.uco.nose.business.domain.CountryDomain;
import co.ed.uco.nose.crosscuting.helper.ObjectHelper;
import co.ed.uco.nose.crosscuting.helper.UUIDHelper;
import co.ed.uco.nose.entity.CountryEntity;

public final class CountryEntityAssembler implements EntityAssembler<CountryEntity, CountryDomain> {

	private static final EntityAssembler<CountryEntity, CountryDomain> INSTANCE = new CountryEntityAssembler();
	
	private CountryEntityAssembler() {	
	}
	
	public static EntityAssembler<CountryEntity, CountryDomain> getCoutryEntityAssembler() {
		return INSTANCE;
	}
	
	@Override
	public CountryEntity toEntityFromDomain(CountryDomain domain) {
		var domainTmp = ObjectHelper.getDefaultIfNull(domain, new CountryDomain(UUIDHelper.getDefault()));
		return new CountryEntity(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public CountryDomain toDomainFromEntity(CountryEntity Entity) {
		var entityTmp = ObjectHelper.getDefaultIfNull(Entity, new CountryEntity());
		return new CountryDomain(entityTmp.getId(), entityTmp.getName());
	}

	@Override
	public List<CountryEntity> toEntityListFromDomainList(List<CountryDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}