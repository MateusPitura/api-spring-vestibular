package br.com.mateus.api.eventos;

import java.util.Date;

public record EventosDTO(
    Date data,
    String descricao,
    Long universidadeId
){
    public EventosDTO(Eventos eventos){
        this(eventos.getData(), eventos.getDescricao(), eventos.getUniversidade());
    }
}
