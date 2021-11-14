package com.imd.balanza.persistence.crud;

import com.imd.balanza.persistence.entity.Registro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RegistroCrudRepository extends CrudRepository<Registro, Integer> {

    //@Query(value = "select * from registros where id = ?", nativeQuery = true)
    List<Registro> findByIdOrderByNombreAsc(int id);

    @Query(value = "SELECT id, nombre, peso FROM registros ORDER BY id DESC LIMIT 1;", nativeQuery=true)
    List<Registro> ultimoRegistro();

    @Query(value = "INSERT INTO registros (nombre, peso) values ('Angel', ?);", nativeQuery = true)
    List<Registro> guardarSerial(Double peso);

}
