package br.com.mateus.api.avisos;

import org.hibernate.validator.constraints.URL;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public record UpdateAvisosDTO(
    @Pattern(regexp = "^(?!\\s*$).*", message = "O titulo não pode ser vazio")
    String title,
    @Pattern(regexp = "^(?!\\s*$).*", message = "A descrição não pode ser vazia")
    String descricao,
    @Pattern(regexp = "^(?!\\s*$).*", message = "A URL não pode ser vazia")
    @URL
    String url,
    @Min(0)
    Long universidadeId
) {
}
