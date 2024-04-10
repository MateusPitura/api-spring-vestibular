package br.com.mateus.api.avisos;

import java.util.Date;

public interface ReadAvisosDTO {
    Long getId();
    Date getData();
    String getTitle();
    String getDescricao();
    String getUrl();    
    Long getUniversidade();
    String getUniversidadeImage();
}
