package br.com.mateus.api.avisos;

import java.util.Date;
import br.com.mateus.api.universidades.Universidades;
import jakarta.persistence.*;

@Entity
@Table(name = "avisos")
public class Avisos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "avisos_seq")
    @SequenceGenerator(name="avisos_seq", sequenceName = "avisos_seq", initialValue = 1, allocationSize = 1)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data = new Date();
    private String title;
    private String descricao;
    private String url;
    @ManyToOne
    private Universidades universidade;

    public Avisos() {

    }

    public Avisos(String title, String descricao, String url, Universidades universidade) {
        this.title = title;
        this.descricao = descricao;
        this.url = url;
        this.universidade = universidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getUniversidade() {
        return universidade.getId();
    }

    public String getUniversidadeImage() {
        return universidade.getUrlImage();
    }

    public void setUniversidade(Universidades universidade) {
        this.universidade = universidade;
    }
}
