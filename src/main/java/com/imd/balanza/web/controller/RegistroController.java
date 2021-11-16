package com.imd.balanza.web.controller;

import com.imd.balanza.domain.service.RegistroService;
import com.imd.balanza.persistence.entity.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registros")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @GetMapping("/all")
    public List<Registro> getAll() {
        return registroService.getAll();
    }


    @GetMapping("/{id}")
    public List<Registro> getById(@PathVariable("id") int id) {
        return registroService.getById(id);
    }

    @GetMapping("/reg/{idReg}")
    public Optional<Registro> getRegistro(@PathVariable("idReg") int id) {
        return registroService.getRegistro(id);
    }

    @PostMapping("/save")
    public Registro save(@RequestBody Registro registro) {
        return registroService.save(registro);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        registroService.delete(id);
    }

    @GetMapping("/last")
    public List<Registro> getRegister() {
        return registroService.getLastRegister();
    }

    @GetMapping("/txt")
    public String txt() {
        return "Saludos AB";
    }
}
