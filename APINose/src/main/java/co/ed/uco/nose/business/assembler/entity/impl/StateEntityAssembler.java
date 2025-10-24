package co.ed.uco.nose.business.assembler.entity.impl;
import static co.ed.uco.nose.business.assembler.entity.impl.CountryEntityAssembler.getCoutryEntityAssembler;

import java.util.List;

import co.ed.uco.nose.business.assembler.entity.EntityAssembler;
import co.ed.uco.nose.business.domain.StateDomain;
import co.ed.uco.nose.crosscuting.helper.ObjectHelper;
import co.ed.uco.nose.crosscuting.helper.UUIDHelper;
import co.ed.uco.nose.entity.StateEntity;

public final class StateEntityAssembler implements EntityAssembler<StateEntity, StateDomain> {
	
	private static final EntityAssembler<StateEntity, StateDomain> INSTANCE = new StateEntityAssembler();
	
	private StateEntityAssembler() {	
	}
	
	public static EntityAssembler<StateEntity, StateDomain> getStateEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public StateEntity toEntityFromDomain(StateDomain domain) {
		var DomainTmp = ObjectHelper.getDefault(domain, new StateDomain(UUIDHelper.getDefault()));
		var coutryEntityTmp = getCoutryEntityAssembler().toEntityFromDomain(DomainTmp.getCountry());
		return new StateEntity(DomainTmp.getId(), coutryEntityTmp, DomainTmp.getName());
	}

	@Override
	public StateDomain toDomainFromEntity(StateEntity Entity) {
		var EntityTmp = ObjectHelper.getDefault(Entity, new StateEntity());
		var coutryDomainTmp = getCoutryEntityAssembler().toDomainFromEntity(EntityTmp.getCountry()); 
		return new StateDomain(EntityTmp.getId(), EntityTmp.getName(), coutryDomainTmp);
	}

	@Override
	public List<StateEntity> toEntityListFromDomainList(List<StateDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}