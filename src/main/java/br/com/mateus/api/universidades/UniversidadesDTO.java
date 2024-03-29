package br.com.mateus.api.universidades;

public record UniversidadesDTO(
    String nome,
    String sigla,
    String urlImage
) {
    public UniversidadesDTO(Universidades universidades){
        this(universidades.getNome(), universidades.getSigla(), universidades.getUrlImage());
    }
}
