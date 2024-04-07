package br.com.mateus.api.eventos;

import java.util.Date;

public record EventosDTO(
    Date data,
    String descricao,
    Long universidadeId
){
}
