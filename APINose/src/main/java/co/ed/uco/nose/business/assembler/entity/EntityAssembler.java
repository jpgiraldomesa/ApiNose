package co.ed.uco.nose.business.assembler.entity;

import java.util.List;

public interface EntityAssembler<E, D> {
	E toEntityFromDomain(D domain);
	
	D toDomainFromEntity(E entity);

	List<E> toEntityListFromDomainList(List<D> domainList);
}
