package com.aluradesafio2.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") Integer anioNaciento,
        @JsonAlias("death_year") Integer anioFallecimiento
) {
}
