package com.aluradesafio2.literalura.models;

public class Autor {

    private String nombre;
    private Integer anioNacimiento;
    private Integer anioFallecimiento;

    public Autor(DatosAutor datosAutor){
        this.nombre = datosAutor.nombre();
        this.anioNacimiento = datosAutor.anioNaciento();
        this.anioFallecimiento = datosAutor.anioFallecimiento();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(Integer anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public Integer getAnioFallecimiento() {
        return anioFallecimiento;
    }

    public void setAnioFallecimiento(Integer anioFallecimiento) {
        this.anioFallecimiento = anioFallecimiento;
    }

    @Override
    public String toString() {
        return "---------Autor---------\n" +
                "Nombre: " + nombre +
                "\nAnio Nacimiento: " + anioNacimiento +
                "\nAnio Fallecimiento: " + anioFallecimiento;
    }
}
