package co.ed.uco.nose.business.assembler.dto.impl;
import static co.ed.uco.nose.business.assembler.dto.impl.StateDTOAssembler.getStateDTOAssembler;

import java.util.List;

import co.ed.uco.nose.business.assembler.dto.DTOAssembler;
import co.ed.uco.nose.business.domain.CityDomain;
import co.ed.uco.nose.crosscuting.helper.ObjectHelper;
import co.ed.uco.nose.crosscuting.helper.UUIDHelper;
import co.ed.uco.nose.dto.CityDTO;

public final class CityDTOAssembler implements DTOAssembler<CityDTO, CityDomain> {
	
	private static final DTOAssembler<CityDTO, CityDomain> INSTANCE = new CityDTOAssembler();
	
	private CityDTOAssembler() {	
	}
	
	public static DTOAssembler<CityDTO, CityDomain> getCityDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public CityDTO toDTOFromDomain(CityDomain domain) {
		var DomainTmp = ObjectHelper.getDefault(domain, new CityDomain(UUIDHelper.getDefault()));
		var stateDTOTmp = getStateDTOAssembler().toDTOFromDomain(DomainTmp.getState());
		return new CityDTO(DomainTmp.getId(), stateDTOTmp , DomainTmp.getName());
	}

	@Override
	public CityDomain toDomainFromDTO(CityDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new CityDTO());
		var stateDomainTmp = getStateDTOAssembler().toDomainFromDTO(dtoTmp.getState());
		return new CityDomain(dtoTmp.getId(), dtoTmp.getName(), stateDomainTmp);
	}

	@Override
	public List<CityDTO> toDTOListFromDomainList(List<CityDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
}