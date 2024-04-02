package br.com.mateus.api.eventos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEventos extends JpaRepository<Eventos, Long>{
    
}
