package br.com.mateus.api.universidades;

import jakarta.persistence.*;

@Entity
@Table(name = "universidades")
public class Universidades {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "universidades_seq")
    @SequenceGenerator(name="universidades_seq", sequenceName = "universidades_seq", initialValue = 1, allocationSize = 1)
    private Long id;
    private String nome;
    private String sigla;
    @Column(name = "url_image")
    private String urlImage;

    public Universidades(){}

    public Universidades(String nome, String sigla, String urlImage){
        this.nome=nome;
        this.sigla=sigla;
        this.urlImage=urlImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
