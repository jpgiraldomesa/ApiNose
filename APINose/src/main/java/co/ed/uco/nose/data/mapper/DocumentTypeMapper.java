package co.ed.uco.nose.data.mapper;

import co.ed.uco.nose.entity.DocumentTypeEntity;
import co.ed.uco.nose.business.domain.DocumentTypeDomain;

public final class DocumentTypeMapper {

    private DocumentTypeMapper() {}

    public static DocumentTypeEntity toEntity(DocumentTypeDomain domain) {
        if (domain == null) return new DocumentTypeEntity();
        DocumentTypeEntity entity = new DocumentTypeEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        return entity;
    }

    public static DocumentTypeDomain toDomain(DocumentTypeEntity entity) {
        if (entity == null) return new DocumentTypeDomain();
        return new DocumentTypeDomain(entity.getId(), entity.getName());
    }
}