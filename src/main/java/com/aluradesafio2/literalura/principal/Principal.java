package com.aluradesafio2.literalura.principal;

import com.aluradesafio2.literalura.models.DatosLibro;
import com.aluradesafio2.literalura.models.DatosResultado;
import com.aluradesafio2.literalura.service.ConeccionAPI;
import com.aluradesafio2.literalura.service.ConversionDatos;

import java.util.Scanner;

public class Principal {
    private Scanner keyboard = new Scanner(System.in);
    private ConeccionAPI coneccionAPI = new ConeccionAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private final String BUSQUEDA_LIBRO_Y_AUTOR = "?search=";
    private ConversionDatos conversionDatos = new ConversionDatos();
    private String tituloLibro;

    public void runApplication(){
        var opcion = -1;
        while(opcion != 0){
            var menu = """
                    1 - Buscar libro por titulo.
                    2 - Mostrar libros registrados.
                    3 - Mostrar autores registrados.
                    4 - Mostrar autoores vivos en determinadoo anio.
                    5 - Mostrar libros por idioma.
                    0 - Salir.
                    
                    """;
            System.out.println(menu);
            opcion = keyboard.nextInt();
            keyboard.nextLine();
            switch (opcion){
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 0:
                    System.out.println("--------- SALIENDO DE LA APLICACION. ---------");
                    break;
                default:
                    System.out.println("------ Esta opcion no existe dentro del menu. ------");
            }
        }


    }

    private void buscarLibroPorTitulo() {
        System.out.println("Ingresa el titulo del libro: ");
        var tituloLibro = keyboard.nextLine();
        var json = coneccionAPI.obtenerDatos(URL_BASE + BUSQUEDA_LIBRO_Y_AUTOR + tituloLibro.toLowerCase().replace(" ","%20"));
        System.out.println(json);
        var datosResultado = conversionDatos.obtenerDatos(json, DatosResultado.class);
        System.out.println(datosResultado);
    }
}
