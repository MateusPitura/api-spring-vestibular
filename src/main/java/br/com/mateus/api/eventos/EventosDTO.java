package br.com.mateus.api.eventos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.mateus.api.universidades.Universidades;

public record EventosDTO(
    LocalDate data,
    String descricao,
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Universidades universidades
) {
}
