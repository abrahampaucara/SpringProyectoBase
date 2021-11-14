package com.imd.balanza.domain.service;

import com.imd.balanza.web.controller.RegistroController;

public class CloneRegistro {

    private Integer id;
    private String nombre;
    private Double peso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        System.out.println("llego a CloneRegister: "+nombre);
        //new RegistroController().getRegister();
        this.nombre = nombre;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
