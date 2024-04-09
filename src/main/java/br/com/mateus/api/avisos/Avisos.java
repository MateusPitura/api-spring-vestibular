package br.com.mateus.api.avisos;

import java.util.Date;
import br.com.mateus.api.universidades.Universidades;
import jakarta.persistence.*;

@Entity
@Table(name = "avisos")
public class Avisos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data = new Date();
    private String title;
    private String descricao;
    private String url;
    @ManyToOne
    private Universidades universidades;

    public Avisos(){

    }

    public Avisos(String title, String descricao, String url, Universidades universidades) {
        this.title = title;
        this.descricao = descricao;
        this.url = url;
        this.universidades = universidades;
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

    public Universidades getUniversidades() {
        return universidades;
    }

    public void setUniversidades(Universidades universidades) {
        this.universidades = universidades;
    }
}
