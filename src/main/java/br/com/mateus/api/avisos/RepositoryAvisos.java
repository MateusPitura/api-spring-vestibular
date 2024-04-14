package br.com.mateus.api.avisos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryAvisos extends JpaRepository<Avisos, Long>{
    // "select a.id, a.data, a.title, a.descricao, a.url, a.universidade_id from avisos as a join universidades as u on a.universidade_id = u.id where a.universidade_id = 8;"
    @Query("select a.id as id, a.data as data, a.title as title, a.descricao as descricao, a.url as url, a.universidade.id as universidade, a.universidade.urlImage as universidadeImage from Avisos a join Universidades u on a.universidade.id = u.id where a.universidade.id in (:id) order by data desc")
    List<ReadAvisosDTO> findAllById(List<String> id);   

    @Query("select a.id as id, a.data as data, a.title as title, a.descricao as descricao, a.url as url, a.universidade.id as universidade, a.universidade.urlImage as universidadeImage from Avisos a join Universidades u on a.universidade.id = u.id order by data desc")
    List<ReadAvisosDTO> findAllItens(); 
}
