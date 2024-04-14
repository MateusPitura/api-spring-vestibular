package br.com.mateus.api.eventos;

import java.util.Date;

public interface ReadEventosDTO {
    Long getId();
    Date getData();
    String getDescricao();
    Long getUniversidade();
    String getUniversidadeSigla();
}
