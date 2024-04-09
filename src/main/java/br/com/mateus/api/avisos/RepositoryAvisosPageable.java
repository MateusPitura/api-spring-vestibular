package br.com.mateus.api.avisos;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface RepositoryAvisosPageable extends PagingAndSortingRepository<Avisos, Long>{
    
}
