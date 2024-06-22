package com.aluradesafio2.literalura.models;

import java.util.ArrayList;
import java.util.List;

public class Libro {
    private String titulo;
    private List<Autor> autores = new ArrayList<>();
    private String idiomas;
    private Integer numeroDescargas;
}
