package br.com.mateus.api.avisos;

import org.hibernate.validator.constraints.URL;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AvisosDTO(
    @NotBlank(message = "O titulo não pode ser vazio")
    String title,
    @NotBlank(message = "A descrição não pode ser vazia")
    String descricao,
    @NotBlank(message = "A URL não pode ser vazia")
    @URL(message = "A URL do avisos deve ser uma URL valida")
    String url,
    @NotNull(message = "O id da universidade não pode ser vazio")
    @Min(0)
    Long universidadeId
) {
}
