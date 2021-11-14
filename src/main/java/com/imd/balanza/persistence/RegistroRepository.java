package com.imd.balanza.persistence;

import com.imd.balanza.persistence.crud.RegistroCrudRepository;
import com.imd.balanza.persistence.entity.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RegistroRepository {

    @Autowired
    private RegistroCrudRepository registroCrudRepository;

    public List<Registro> getAll() {
        return (List<Registro>) registroCrudRepository.findAll();
    }

    public List<Registro> getById(int id) {
        return registroCrudRepository.findByIdOrderByNombreAsc(id);
    }

    public Optional<Registro> getRegistro(int id) {
        return registroCrudRepository.findById(id);
    }

    public Registro save(Registro registro) {
        return registroCrudRepository.save(registro);
    }

    public List<Registro> getLastRegister() {
        return registroCrudRepository.ultimoRegistro();
    }

    public boolean delete(int id) {
        if(getRegistro(id).isPresent()) {
            registroCrudRepository.deleteById(id);
            return  true;
        } else {
            return false;
        }
    }
}
