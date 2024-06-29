package com.aluradesafio2.literalura.principal;

import com.aluradesafio2.literalura.models.*;
import com.aluradesafio2.literalura.repository.AutorRepository;
import com.aluradesafio2.literalura.repository.LibroRepository;
import com.aluradesafio2.literalura.service.ConeccionAPI;
import com.aluradesafio2.literalura.service.ConversionDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner keyboard = new Scanner(System.in);
    private ConeccionAPI coneccionAPI = new ConeccionAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private final String BUSQUEDA_LIBRO_Y_AUTOR = "?search=";
    private ConversionDatos conversionDatos = new ConversionDatos();
    private String tituloLibro;
    private List<Libro> libros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private LibroRepository repositoryL;
    private AutorRepository repositoryA;

    public Principal(LibroRepository repositoryL, AutorRepository repositoryA) {
        this.repositoryL = repositoryL;
        this.repositoryA = repositoryA;
    }
    public void runApplication(){
        var opcion = -1;
        while(opcion != 0){
            var menu = """
                    1 - Buscar libro por titulo.
                    2 - Mostrar libros registrados.
                    3 - Mostrar autores registrados.
                    4 - Mostrar autoores vivos en determinadoo anio.
                    5 - Mostrar cantidad de libros por idioma.
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
                    mostrarLibrosBuscados();
                    break;
                case 3:
                    mostrarAutoresRegistrados();
                    break;
                case 4:
                    mostrarAutoresVivos();
                    break;
                case 5:
                    mostrarCantidadLibrosPorIdioma();
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
        tituloLibro = keyboard.nextLine();
        var json = coneccionAPI.obtenerDatos(URL_BASE + BUSQUEDA_LIBRO_Y_AUTOR + tituloLibro.toLowerCase().replace(" ","%20"));
        var datosResultado = conversionDatos.obtenerDatos(json, DatosResultado.class);
        Optional<DatosLibro> libroBuscado = datosResultado.libros().stream()
                .filter(l -> l.titulo().toLowerCase().contains(tituloLibro.toLowerCase()))
                .findFirst();

        if (libroBuscado.isPresent()){
            DatosLibro datosLibro = new DatosLibro(libroBuscado.get().titulo(),libroBuscado.get().autores(),
                    libroBuscado.get().idiomas(),libroBuscado.get().numeroDescargas());
            System.out.println(datosLibro);
            List<DatosAutor> datosAutores = new ArrayList<>();
            for(int i = 0; i <= libroBuscado.get().autores().size()-1; i++){
                datosAutores.add(libroBuscado.get().autores().get(i));
            }
            List<Autor> autores = new ArrayList<>();
            for(int i = 0; i <= datosAutores.size()-1; i++){
                Autor autor = new Autor(datosAutores.get(i));
                autores.add(autor);
            }
            Libro libro = new Libro(datosLibro);
            libro.setAutores(autores);

            System.out.println(libro.toString());
            repositoryL.save(libro);
        }else{
            System.out.println("Libro no encontrado!");
        }
    }
    private void mostrarLibrosBuscados() {
        libros = repositoryL.findAll();

        libros.forEach(System.out::println);

    }

    private void mostrarAutoresRegistrados() {
        autores = repositoryA.findAll();

        autores.forEach(System.out::println);
    }
    private void mostrarAutoresVivos() {
        System.out.println("Inserta el anio para saber que autores estaban vivos: ");
        var anio = keyboard.nextInt();
        autores = repositoryA.autoresVivosEnElAnio(anio);
        System.out.println("Los autores vivos en el anio " + anio + "son: ");
        autores.forEach(System.out::println);
    }

    private void mostrarCantidadLibrosPorIdioma() {

        String idioma ="";
        System.out.println("Selecciona un idioma: ");
        System.out.println("""
                1.- Espanol(es).
                2.- Ingles(en).
                """);
        var opcion = keyboard.nextInt();
        switch (opcion){
            case 1:
                idioma = "es";
                break;
            case 2:
                idioma = "en";
                break;
            default:
                System.out.println("La opccion insertada no existe.");

        }
        libros = repositoryL.mostrasLibrosDelIdiomaX(idioma);
        long cantidadLibros = libros.stream().count();
        if(idioma == "es"){
            idioma = "Espanol";
        }else{
            idioma = "Ingles";
        }
        System.out.println("Existen " + cantidadLibros + " libros en el idioma " + idioma + " dentro de la base de datos");
        libros.forEach(System.out::println);

    }

}
