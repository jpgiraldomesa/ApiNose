package co.ed.uco.nose.data.mapper;

import co.ed.uco.nose.entity.UserEntity;
import co.ed.uco.nose.business.domain.UserDomain;

public final class UserMapper {

    private UserMapper() {}

    public static UserEntity toEntity(UserDomain domain) {
        if (domain == null) return new UserEntity();
        UserEntity entity = new UserEntity();
        entity.setId(domain.getId());
        entity.setDocumentType(DocumentTypeMapper.toEntity(domain.getDocumentType()));
        entity.setDocumentNumber(domain.getDocumentNumber());
        entity.setFirstName(domain.getFirstName());
        entity.setSecondName(domain.getSecondName());
        entity.setFirstSurname(domain.getFirstSurname());
        entity.setSecondSurname(domain.getSecondSurname());
        entity.setResidenceCity(CityMapper.toEntity(domain.getResidenceCity()));
        entity.setEmail(domain.getEmail());
        entity.setMobilePhoneNumber(domain.getMobilePhoneNumber());
        entity.setEmailConfirmed(domain.isEmailConfirmed());
        entity.setMobilePhoneNumberConfirmed(domain.isMobilePhoneNumberConfirmed());
        return entity;
    }

    public static UserDomain toDomain(UserEntity entity) {
        if (entity == null) return new UserDomain();
        return new UserDomain(entity.getId(),
        	entity.getFirstName(),
            entity.getSecondName(),
            entity.getFirstSurname(),
            entity.getSecondSurname(),
            entity.getEmail(),            
            DocumentTypeMapper.toDomain(entity.getDocumentType()),
            entity.getDocumentNumber(),
            CityMapper.toDomain(entity.getResidenceCity()),
            entity.getMobilePhoneNumber(),
            entity.isEmailConfirmed(),
            entity.isMobilePhoneNumberConfirmed());
    }
}