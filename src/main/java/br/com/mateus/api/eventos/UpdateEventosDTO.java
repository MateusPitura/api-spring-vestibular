package br.com.mateus.api.eventos;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public record UpdateEventosDTO(
    Date data,
    @Pattern(regexp = "^(?!\\s*$).*", message = "O nome da universidade não pode ser vazio")
    String descricao,
    @Min(0)
    Long universidadeId
) {
    
}
