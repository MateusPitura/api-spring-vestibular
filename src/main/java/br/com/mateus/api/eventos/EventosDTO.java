package br.com.mateus.api.eventos;

import java.util.Date;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EventosDTO(
    @NotNull(message = "A data não pode ser vazia")
    Date data,
    @NotBlank(message = "A descrição não poder ser vazia")
    String descricao,
    @NotNull(message = "O id da universidade não poder ser vazio")
    @Min(0)
    Long universidadeId
){
    public EventosDTO(Eventos eventos){
        this(eventos.getData(), eventos.getDescricao(), eventos.getUniversidade());
    }
}