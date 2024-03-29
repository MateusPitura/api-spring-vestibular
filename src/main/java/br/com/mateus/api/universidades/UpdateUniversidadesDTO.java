package br.com.mateus.api.universidades;

import org.hibernate.validator.constraints.URL;
import jakarta.validation.constraints.Pattern;

public record UpdateUniversidadesDTO(
    @Pattern(regexp = "^(?!\\s*$).*", message = "O nome da universidade não pode ser vazio")
    String nome,
    @Pattern(regexp = "^(?!\\s*$).*", message = "A sigla da universidade não pode ser vazia")
    String sigla,
    @Pattern(regexp = "^(?!\\s*$).*", message = "A urlImage da universidade não pode ser vazia")
    @URL(message = "A urlImage da universidade deve ser uma URL valida")
    String urlImage
) {
    public UpdateUniversidadesDTO(Universidades universidades){
        this(universidades.getNome(), universidades.getSigla(), universidades.getUrlImage());
    }
}
