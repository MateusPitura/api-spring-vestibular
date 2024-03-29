package br.com.mateus.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "universidades")
public class Universidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
