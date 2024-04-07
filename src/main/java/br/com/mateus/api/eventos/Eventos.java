package br.com.mateus.api.eventos;

import java.util.Date;
import br.com.mateus.api.universidades.Universidades;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "eventos")
public class Eventos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    private String descricao;
    @ManyToOne
    private Universidades universidade;

    public Eventos() {
    }

    public Eventos(Date data, String descricao, Universidades universidades) {
        this.data = data;
        this.descricao = descricao;
        this.universidade = universidades;
    }

    public Eventos(EventosDTO dto, Universidades universidade){
        this.data = dto.data();
        this.descricao = dto.descricao();
        this.universidade = universidade;
    }

    public void update(EventosDTO dto, Universidades universidades){
        if(dto.data()!=null){
            this.data = dto.data();
        }
        if(dto.descricao()!=null){
            this.descricao = dto.descricao();
        }
        if(universidades != null){
            this.universidade = universidades;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getUniversidade() {
        return universidade.getId();
    }

    public void setUniversidade(Universidades universidade) {
        this.universidade = universidade;
    }
}
