package br.com.mateus.api.avisos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AvisosDTO(
    @NotBlank(message = "O titulo não pode ser vazio")
    String title,
    @NotBlank(message = "A descrição não pode ser vazia")
    String descricao,
    @NotBlank(message = "")
    String url,
    @NotNull(message = "O id da universidade não pode ser vazio")
    @Min(0)
    Long universidadeId
) {
    public AvisosDTO(Avisos avisos){
        this(avisos.getTitle(), avisos.getDescricao(), avisos.getUrl(), avisos.getUniversidade());
    }
}
