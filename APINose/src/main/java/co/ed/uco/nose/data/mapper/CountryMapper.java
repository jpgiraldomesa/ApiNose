package co.ed.uco.nose.data.mapper;

import co.ed.uco.nose.entity.CountryEntity;
import co.ed.uco.nose.business.domain.CountryDomain;

public final class CountryMapper {

    private CountryMapper() {}

    public static CountryEntity toEntity(CountryDomain domain) {
        if (domain == null) return new CountryEntity();
        CountryEntity entity = new CountryEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        return entity;
    }

    public static CountryDomain toDomain(CountryEntity entity) {
        if (entity == null) return new CountryDomain();
        return new CountryDomain(entity.getId(), entity.getName());
    }
}