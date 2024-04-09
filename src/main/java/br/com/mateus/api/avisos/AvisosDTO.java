package br.com.mateus.api.avisos;

public record AvisosDTO(
    String title,
    String descricao,
    String url,
    Long universidadeId
) {
    public AvisosDTO(Avisos avisos){
        this(avisos.getTitle(), avisos.getDescricao(), avisos.getUrl(), avisos.getUniversidade());
    }
}
