package br.com.mateus.api.avisos;

public record UpdateAvisosDTO(
    String title,
    String descricao,
    String url,
    Long universidadeId
) {
}
