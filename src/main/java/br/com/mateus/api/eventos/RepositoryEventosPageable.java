package br.com.mateus.api.eventos;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface RepositoryEventosPageable extends PagingAndSortingRepository<Eventos, Long>{
}
