package com.aluradesafio2.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosResultado(
        @JsonAlias("results") List<DatosLibro> libros
        ) {
}
