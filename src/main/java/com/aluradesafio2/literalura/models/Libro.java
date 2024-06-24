package com.aluradesafio2.literalura.models;

import java.util.ArrayList;
import java.util.List;

public class Libro {
    private String titulo;
    private String autores;
    private String idiomas;
    private Integer numeroDescargas;

    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.numeroDescargas = datosLibro.numeroDescargas();

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Integer numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    @Override
    public String toString() {
        return "----------Libro----------" +
                "\nTitulo: " + titulo +
                "\nAutores: " + autores +
                "\nIdiomas: " + idiomas +
                "\nNumero de descargas: " + numeroDescargas;
    }
}
