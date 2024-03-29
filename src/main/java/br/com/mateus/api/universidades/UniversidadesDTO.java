package br.com.mateus.api.universidades;

import org.hibernate.validator.constraints.URL;
import jakarta.validation.constraints.NotBlank;

public record UniversidadesDTO(
    @NotBlank(message = "O nome da universidade não pode ser vazio")
    String nome,
    @NotBlank(message = "A sigla da universidade não pode ser vazia")
    String sigla,
    @NotBlank(message = "A urlImage da universidade não pode ser vazia")
    @URL(message = "A urlImage da universidade deve ser uma URL valida")
    String urlImage
) {
    public UniversidadesDTO(Universidades universidades){
        this(universidades.getNome(), universidades.getSigla(), universidades.getUrlImage());
    }
}
