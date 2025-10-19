package co.ed.uco.nose.business.assembler.dto.impl;
import static co.ed.uco.nose.business.assembler.dto.impl.CountryDTOAssembler.getCountryDTOAssembler;

import java.util.List;

import co.ed.uco.nose.business.assembler.dto.DTOAssembler;
import co.ed.uco.nose.business.domain.StateDomain;
import co.ed.uco.nose.crosscuting.helper.ObjectHelper;
import co.ed.uco.nose.crosscuting.helper.UUIDHelper;
import co.ed.uco.nose.dto.StateDTO;

public final class StateDTOAssembler implements DTOAssembler<StateDTO, StateDomain> {
	
	private static final DTOAssembler<StateDTO, StateDomain> INSTANCE = new StateDTOAssembler();
	
	private StateDTOAssembler() {	
	}
	
	public static DTOAssembler<StateDTO, StateDomain> getStateDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public StateDTO toDTOFromDomain(StateDomain domain) {
		var domainTmp = ObjectHelper.getDefaultIfNull(domain, new StateDomain(UUIDHelper.getDefault()));
		var coutryDTOTmp = getCountryDTOAssembler().toDTOFromDomain(domainTmp.getCountry());
		return new StateDTO(domainTmp.getId(), coutryDTOTmp, domainTmp.getName());
	}

	@Override
	public StateDomain toDomainFromDTO(StateDTO dto) {
		var dtoTmp = ObjectHelper.getDefaultIfNull(dto, new StateDTO());
		var coutryDomainTmp = getCountryDTOAssembler().toDomainFromDTO(dtoTmp.getCountry()); 
		return new StateDomain(dtoTmp.getId(), dtoTmp.getName(), coutryDomainTmp);
	}

	@Override
	public List<StateDTO> toDTOListFromDomainList(List<StateDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}