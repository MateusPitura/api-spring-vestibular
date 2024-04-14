package br.com.mateus.api.eventos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RepositoryEventos extends JpaRepository<Eventos, Long>{
    // "select a.id, a.data, a.title, a.descricao, a.url, a.universidade_id from avisos as a join universidades as u on a.universidade_id = u.id where a.universidade_id = 8;"
    @Query("select a.id as id, a.data as data, a.descricao as descricao, a.universidade.id as universidade, a.universidade.sigla as universidadeSigla from Eventos a join Universidades u on a.universidade.id = u.id where a.universidade.id in (:id) order by data")
    List<ReadEventosDTO> findAllById(List<String> id);   

    @Query("select a.id as id, a.data as data, a.descricao as descricao, a.universidade.id as universidade, a.universidade.sigla as universidadeSigla from Eventos a join Universidades u on a.universidade.id = u.id order by data")
    List<ReadEventosDTO> findAllItens(); 
}
