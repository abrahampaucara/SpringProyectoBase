package com.imd.balanza.domain.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CloneRegistro {

    private Integer id;
    private String nombre;
    private String peso;


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
        this.nombre = nombre;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        System.out.println("Dato puerto Serial: "+peso);
        try {
            Thread.sleep(100L);
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:postgresql://localhost/bascula";
            Connection conn = null;
            conn = DriverManager.getConnection(myUrl, "postgres", "postgres");
            String query = " insert into registros (nombre, peso)" + " values (?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, "Sin nombre");
            preparedStmt.setString (2, peso);
            preparedStmt.execute();
            conn.close();
        }
        catch (InterruptedException | SQLException ex) {
            ex.printStackTrace();
        }
        this.peso = peso;
    }
}
