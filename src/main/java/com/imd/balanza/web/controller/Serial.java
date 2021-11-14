package com.imd.balanza.web.controller;

import com.imd.balanza.domain.service.PuertoController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serial")
public class Serial {

    @GetMapping("/numero")
    public String Numero(){
        PuertoController.Conectar conectar = new PuertoController.Conectar();
        conectar.run();
        return "se inicio la coneccion al puerto serial...";
    }

}
