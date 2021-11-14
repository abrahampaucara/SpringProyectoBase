package com.imd.balanza.web.controller;

import com.imd.balanza.domain.service.CloneRegistro;
import com.imd.balanza.domain.service.PuertoController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")

public class HolaMundoController {

    private String datos;

    @GetMapping("/hola")
    public String saludar(){
        System.out.println("Datos enviado al API: ");
        return new CloneRegistro().getNombre();

    }

    public String getDatos() {
        System.out.println("metodo setSetSetSetSetDatos: "+ this.datos);
        return this.datos;
    }

    public void setDatos(String datos) {
        System.out.println("metodo getDatos: "+ datos);
        this.datos = datos;
    }

}
