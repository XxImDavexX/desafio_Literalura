package com.aluradesafio2.literalura.principal;

import com.aluradesafio2.literalura.service.ConeccionAPI;

public class Principal {
    private ConeccionAPI coneccionAPI = new ConeccionAPI();
    private final String URL_BASE = "https://gutendex.com/";
    private final String BUSQUEDA_LIBRO_Y_AUTOR = "books/?search=";

    public void runApplication(){
        var json = coneccionAPI.obtenerDatos(URL_BASE + BUSQUEDA_LIBRO_Y_AUTOR + "don%20quijote");
        System.out.println(json);
    }
}
