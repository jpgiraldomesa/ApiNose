package co.ed.uco.nose.business.assembler.dto.impl;
import static co.ed.uco.nose.business.assembler.dto.impl.CityDTOAssembler.getCityDTOAssembler;
import static co.ed.uco.nose.business.assembler.dto.impl.DocumentTypeDTOAssembler.getDocumentTypeDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.ed.uco.nose.business.assembler.dto.DTOAssembler;
import co.ed.uco.nose.business.domain.UserDomain;
import co.ed.uco.nose.crosscuting.helper.ObjectHelper;
import co.ed.uco.nose.crosscuting.helper.UUIDHelper;
import co.ed.uco.nose.dto.UserDTO;

public final class UserDTOAssembler implements DTOAssembler<UserDTO, UserDomain> {
	
	private static final DTOAssembler<UserDTO, UserDomain> INSTANCE = new UserDTOAssembler();
	
	private UserDTOAssembler() {	
	}
	
	public static DTOAssembler<UserDTO, UserDomain> getUserDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public UserDTO toDTOFromDomain(UserDomain domain) {
		var DomainTmp = ObjectHelper.getDefault(domain, new UserDomain(UUIDHelper.getDefault()));
		var cityDTOTmp = getCityDTOAssembler().toDTOFromDomain(DomainTmp.getResidenceCity());
		var documentTypeDTOTmp = getDocumentTypeDTOAssembler().toDTOFromDomain(DomainTmp.getDocumentType());
		return new UserDTO(DomainTmp.getId(), documentTypeDTOTmp, DomainTmp.getDocumentNumber(), DomainTmp.getFirstName(), DomainTmp.getSecondName(), DomainTmp.getFirstSurname(), 
				DomainTmp.getSecondSurname(),cityDTOTmp, DomainTmp.getEmail(), DomainTmp.getMobilePhoneNumber(), DomainTmp.isEmailConfirmed(), DomainTmp.isMobilePhoneNumberConfirmed());
		
	}

	@Override
	public UserDomain toDomainFromDTO(UserDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new UserDTO());
		var cityDomainTmp = getCityDTOAssembler().toDomainFromDTO(dtoTmp.getResidenceCity());
		var documentTypeDomainTmp = getDocumentTypeDTOAssembler().toDomainFromDTO(dtoTmp.getDocumentType());
		return new UserDomain(dtoTmp.getId(),  dtoTmp.getFirstName(), dtoTmp.getSecondName(), dtoTmp.getFirstSurname(), 
				dtoTmp.getSecondSurname(), dtoTmp.getEmail(), documentTypeDomainTmp, dtoTmp.getDocumentNumber(), cityDomainTmp, dtoTmp.getMobilePhoneNumber(), dtoTmp.isEmailConfirmed(), dtoTmp.isMobilePhoneNumberConfirmed());
	}

	@Override
	public List<UserDTO> toDTOListFromDomainList(List<UserDomain> domainList) {

		var userDTOList = new ArrayList<UserDTO>();
		
		for (var domain : domainList) {
			userDTOList.add(toDTOFromDomain(domain));
		}
		return userDTOList;
	}
}