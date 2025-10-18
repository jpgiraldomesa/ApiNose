package co.ed.uco.nose.business.assembler.entity.impl;

import java.util.List;

import co.ed.uco.nose.business.assembler.entity.EntityAssembler;
import co.ed.uco.nose.business.domain.DocumentTypeDomain;
import co.ed.uco.nose.crosscuting.helper.ObjectHelper;
import co.ed.uco.nose.crosscuting.helper.UUIDHelper;
import co.ed.uco.nose.entity.DocumentTypeEntity;

public final class DocumentTypeEntityAssembler implements EntityAssembler<DocumentTypeEntity, DocumentTypeDomain> {

	private static final EntityAssembler<DocumentTypeEntity, DocumentTypeDomain> INSTANCE = new DocumentTypeEntityAssembler();
	
	private DocumentTypeEntityAssembler() {	
	}
	
	public static EntityAssembler<DocumentTypeEntity, DocumentTypeDomain> getDocumentTypeEntityAssembler() {
		return INSTANCE;
	}
	
	@Override
	public DocumentTypeEntity toEntityFromDomain(DocumentTypeDomain domain) {
		var domainTmp = ObjectHelper.getDefaultIfNull(domain, new DocumentTypeDomain(UUIDHelper.getDefault()));
		return new DocumentTypeEntity(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public DocumentTypeDomain toDomainFromEntity(DocumentTypeEntity Entity) {
		var entityTmp = ObjectHelper.getDefaultIfNull(Entity, new DocumentTypeEntity());
		return new DocumentTypeDomain(entityTmp.getId(), entityTmp.getName());
	}

	@Override
	public List<DocumentTypeEntity> toEntityListFromDomainList(List<DocumentTypeDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}