package co.ed.uco.nose.business.assembler.dto.impl;

import java.util.List;

import co.ed.uco.nose.business.assembler.dto.DTOAssembler;
import co.ed.uco.nose.business.domain.DocumentTypeDomain;
import co.ed.uco.nose.crosscuting.helper.ObjectHelper;
import co.ed.uco.nose.crosscuting.helper.UUIDHelper;
import co.ed.uco.nose.dto.DocumentTypeDTO;

public final class DocumentTypeDTOAssembler implements DTOAssembler<DocumentTypeDTO, DocumentTypeDomain> {

	private static final DTOAssembler<DocumentTypeDTO, DocumentTypeDomain> INSTANCE = new DocumentTypeDTOAssembler();
	
	private DocumentTypeDTOAssembler() {	
	}
	
	public static DTOAssembler<DocumentTypeDTO, DocumentTypeDomain> getDocumentTypeDTOAssembler() {
		return INSTANCE;
	}
	
	@Override
	public DocumentTypeDTO toDTOFromDomain(DocumentTypeDomain domain) {
		var domainTmp = ObjectHelper.getDefaultIfNull(domain, new DocumentTypeDomain(UUIDHelper.getDefault()));
		return new DocumentTypeDTO(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public DocumentTypeDomain toDomainFromDTO(DocumentTypeDTO dto) {
		var dtoTmp = ObjectHelper.getDefaultIfNull(dto, new DocumentTypeDTO());
		return new DocumentTypeDomain(dtoTmp.getId(), dtoTmp.getName());
	}

	@Override
	public List<DocumentTypeDTO> toDTOListFromDomainList(List<DocumentTypeDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}