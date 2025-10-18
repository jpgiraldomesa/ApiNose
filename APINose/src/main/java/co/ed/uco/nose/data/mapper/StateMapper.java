package co.ed.uco.nose.data.mapper;

import co.ed.uco.nose.entity.StateEntity;
import co.ed.uco.nose.business.domain.StateDomain;

public final class StateMapper {

    private StateMapper() {}

    public static StateEntity toEntity(StateDomain domain) {
        if (domain == null) return new StateEntity();
        StateEntity entity = new StateEntity();
        entity.setId(domain.getId());
        entity.setCountry(CountryMapper.toEntity(domain.getCountry()));
        entity.setName(domain.getName());
        return entity;
    }

    public static StateDomain toDomain(StateEntity entity) {
        if (entity == null) return new StateDomain();
        return new StateDomain(entity.getId(),entity.getName(),CountryMapper.toDomain(entity.getCountry()));
    }
}