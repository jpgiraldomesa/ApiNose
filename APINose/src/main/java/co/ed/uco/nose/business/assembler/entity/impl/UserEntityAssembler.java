package co.ed.uco.nose.business.assembler.entity.impl;
import static co.ed.uco.nose.business.assembler.entity.impl.CityEntityAssembler.getCityEntityAssembler;
import static co.ed.uco.nose.business.assembler.entity.impl.DocumentTypeEntityAssembler.getDocumentTypeEntityAssembler;

import java.util.List;

import co.ed.uco.nose.business.assembler.entity.EntityAssembler;
import co.ed.uco.nose.business.domain.UserDomain;
import co.ed.uco.nose.crosscuting.helper.ObjectHelper;
import co.ed.uco.nose.crosscuting.helper.UUIDHelper;
import co.ed.uco.nose.entity.UserEntity;

public final class UserEntityAssembler implements EntityAssembler<UserEntity, UserDomain> {
	
	private static final EntityAssembler<UserEntity, UserDomain> INSTANCE = new UserEntityAssembler();
	
	private UserEntityAssembler() {	
	}
	
	public static EntityAssembler<UserEntity, UserDomain> getUserEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public UserEntity toEntityFromDomain(UserDomain domain) {
		var DomainTmp = ObjectHelper.getDefault(domain, new UserDomain(UUIDHelper.getDefault()));
		var cityEntityTmp = getCityEntityAssembler().toEntityFromDomain(DomainTmp.getResidenceCity());
		var documentTypeEntityTmp = getDocumentTypeEntityAssembler().toEntityFromDomain(DomainTmp.getDocumentType());
		return new UserEntity(DomainTmp.getId(), documentTypeEntityTmp, DomainTmp.getDocumentNumber(), DomainTmp.getFirstName(), DomainTmp.getSecondName(), DomainTmp.getFirstSurname(), 
				DomainTmp.getSecondSurname(),cityEntityTmp, DomainTmp.getEmail(), DomainTmp.getMobilePhoneNumber(), DomainTmp.isEmailConfirmed(), DomainTmp.isMobilePhoneNumberConfirmed());
		
	}

	@Override
	public UserDomain toDomainFromEntity(UserEntity Entity) {
		var EntityTmp = ObjectHelper.getDefault(Entity, new UserEntity());
		var cityDomainTmp = getCityEntityAssembler().toDomainFromEntity(EntityTmp.getResidenceCity());
		var documentTypeDomainTmp = getDocumentTypeEntityAssembler().toDomainFromEntity(EntityTmp.getDocumentType());
		return new UserDomain(EntityTmp.getId(),  EntityTmp.getFirstName(), EntityTmp.getSecondName(), EntityTmp.getFirstSurname(), 
				EntityTmp.getSecondSurname(), EntityTmp.getEmail(), documentTypeDomainTmp, EntityTmp.getDocumentNumber(), cityDomainTmp, EntityTmp.getMobilePhoneNumber(), EntityTmp.isEmailConfirmed(), EntityTmp.isMobilePhoneNumberConfirmed());
	}

	@Override
	public List<UserEntity> toEntityListFromDomainList(List<UserDomain> domainList) {
		
		return null;
	}
}