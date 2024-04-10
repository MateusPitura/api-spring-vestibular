package br.com.mateus.api.avisos;

public record OutputAvisosDTO(
    // @NotBlank(message = "O titulo não pode ser vazio")
    String title,
    // @NotBlank(message = "A descrição não pode ser vazia")
    String descricao,
    // @NotBlank(message = "A URL não pode ser vazia")
    String url,
    // @NotBlank(message = "A imagem da universidade não pode ser vazia")
    String universidadeImage
) {
    public OutputAvisosDTO(Avisos avisos){
        this(avisos.getTitle(), avisos.getDescricao(), avisos.getUrl(), avisos.getUniversidadeImage());
    }
}
