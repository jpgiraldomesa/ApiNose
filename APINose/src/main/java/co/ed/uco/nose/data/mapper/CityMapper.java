package co.ed.uco.nose.data.mapper;

import co.ed.uco.nose.entity.CityEntity;
import co.ed.uco.nose.business.domain.CityDomain;

public final class CityMapper {

    private CityMapper() {}

    public static CityEntity toEntity(CityDomain domain) {
        if (domain == null) return new CityEntity();
        CityEntity entity = new CityEntity();
        entity.setId(domain.getId());
        entity.setState(StateMapper.toEntity(domain.getState()));
        entity.setName(domain.getName());
        return entity;
    }

    public static CityDomain toDomain(CityEntity entity) {
        if (entity == null) return new CityDomain();
        return new CityDomain(entity.getId(), entity.getName(),StateMapper.toDomain(entity.getState()));
    }
}