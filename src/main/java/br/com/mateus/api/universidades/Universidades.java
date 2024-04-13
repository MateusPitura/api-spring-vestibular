package br.com.mateus.api.universidades;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "universidades")
public class Universidades implements Serializable {
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

    public Universidades(UniversidadesDTO dto){
        this.nome=dto.nome();
        this.sigla=dto.sigla();
        this.urlImage=dto.urlImage();
    }

    public void update(UpdateUniversidadesDTO dto) {
        if(dto.nome() != null){
            this.nome = dto.nome();
        }
        if(dto.sigla() != null){
            this.sigla = dto.sigla();
        }
        if(dto.urlImage() != null){
            this.urlImage = dto.urlImage();
        }
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
