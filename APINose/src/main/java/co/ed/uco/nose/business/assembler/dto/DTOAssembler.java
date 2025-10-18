package co.ed.uco.nose.business.assembler.dto;

import java.util.List;

public interface DTOAssembler<T, D> {
	T toDTOFromDomain(D domain);
	
	D toDomainFromDTO(T dto);
	
	List<T> toDTOListFromDomainList(List<D> domainList);

}
