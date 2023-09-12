package com.example.cadastrolivros.model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
@Getter
@Setter
@Entity
public class Livros {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long code;
    private String Autor;
    private String Titulo;
    private String Genero;
    
    @ManyToOne
    private Autor Autor;


    @ManyToOne
    private Genero Genero;


    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }


    
}
