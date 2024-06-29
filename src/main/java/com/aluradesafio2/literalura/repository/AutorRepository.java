package com.aluradesafio2.literalura.repository;

import com.aluradesafio2.literalura.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

//      List<Autor> findByAnioNacimientoGreaterThanEqualAndAnioFallecimientoLessThan(int anio);
    @Query("SELECT a FROM Autor a WHERE a.anioNacimiento <= :anio AND a.anioFallecimiento > :anio")
    List<Autor> autoresVivosEnElAnio(int anio);
}
