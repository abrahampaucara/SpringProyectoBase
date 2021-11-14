package com.imd.balanza.domain.service;

import com.imd.balanza.persistence.RegistroRepository;
import com.imd.balanza.persistence.entity.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    public List<Registro> getAll() {
        return registroRepository.getAll();
    }

    public List<Registro> getById(int id) {
        return registroRepository.getById(id);
    }

    public Optional<Registro> getRegistro(int id) {
        return registroRepository.getRegistro(id);
    }

    public Registro save(Registro registro) {
        return registroRepository.save(registro);
    }

    public void delete(int id) {
        registroRepository.delete(id);
    }

    public List<Registro> getLastRegister() {
        return registroRepository.getLastRegister();
    }

}
