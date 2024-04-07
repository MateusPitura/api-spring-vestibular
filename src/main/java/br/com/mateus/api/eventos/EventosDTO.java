package br.com.mateus.api.eventos;

import java.util.Date;

public record EventosDTO(
    Date data,
    String descricao,
    Long universidadeId
){

    // public EventosDTO(Date data, String descricao, Long universidadeId) {
    //     this.data = data;
    //     this.descricao = descricao;
    //     this.universidadeId = universidadeId;
    // }

    // public Date getData() {
    //     return data;
    // }

    // public void setData(Date data) {
    //     this.data = data;
    // }

    // public String getDescricao() {
    //     return descricao;
    // }

    // public void setDescricao(String descricao) {
    //     this.descricao = descricao;
    // }

    // public Long getUniversidadeId() {
    //     return universidadeId;
    // }

    // public void setUniversidadeId(Long universidadeId) {
    //     this.universidadeId = universidadeId;
    // }
}
