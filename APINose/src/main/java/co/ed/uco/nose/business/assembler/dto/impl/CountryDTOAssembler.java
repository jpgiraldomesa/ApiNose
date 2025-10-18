package co.ed.uco.nose.business.assembler.dto.impl;

import java.util.List;

import co.ed.uco.nose.business.assembler.dto.DTOAssembler;
import co.ed.uco.nose.business.domain.CountryDomain;
import co.ed.uco.nose.crosscuting.helper.ObjectHelper;
import co.ed.uco.nose.crosscuting.helper.UUIDHelper;
import co.ed.uco.nose.dto.CountryDTO;

public final class CountryDTOAssembler implements DTOAssembler<CountryDTO, CountryDomain> {

	private static final DTOAssembler<CountryDTO, CountryDomain> INSTANCE = new CountryDTOAssembler();
	
	private CountryDTOAssembler() {	
	}
	
	public static DTOAssembler<CountryDTO, CountryDomain> getCoutryDTOAssembler() {
		return INSTANCE;
	}
	
	@Override
	public CountryDTO toDTOFromDomain(CountryDomain domain) {
		var domainTmp = ObjectHelper.getDefaultIfNull(domain, new CountryDomain(UUIDHelper.getDefault()));
		return new CountryDTO(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public CountryDomain toDomainFromDTO(CountryDTO dto) {
		var dtoTmp = ObjectHelper.getDefaultIfNull(dto, new CountryDTO());
		return new CountryDomain(dtoTmp.getId(), dtoTmp.getName());
	}

	@Override
	public List<CountryDTO> toDTOListFromDomainList(List<CountryDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}