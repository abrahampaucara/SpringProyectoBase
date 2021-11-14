package com.imd.balanza.domain.service;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

import com.imd.balanza.persistence.entity.Registro;
import com.imd.balanza.web.controller.HolaMundoController;
import gnu.io.CommPort;
import gnu.io.SerialPort;
import gnu.io.CommPortIdentifier;

public class PuertoController {
    public void connect(final String portName) throws Exception {
        final CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        if (portIdentifier.isCurrentlyOwned()) {
            System.out.println("Error: El puerto se encunetra en uso.");
        }
        else {
            final CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);
            if (commPort instanceof SerialPort) {
                System.out.println("Se conecto al puerto: ");
                final SerialPort serialPort = (SerialPort)commPort;
                serialPort.setSerialPortParams(9600, 8, 1, 0);
                final InputStream in = serialPort.getInputStream();
                final OutputStream out = serialPort.getOutputStream();
                new Thread(new SerialReader(in)).start();
            }
            else {
                System.out.println("Error: Solo puertos seriales son aceptados.");
            }
        }
    }

    public static class Conectar implements Runnable {
        @Override
        public void run() {
            try {
                new PuertoController().connect("COM1");
            }
           catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*
    //public static void main(final String[] args) throws IOException {
    public static void lector() throws IOException {
        try {
            new PuertoController().connect("COM1");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
     */

    public static class SerialReader implements Runnable
    {
        InputStream in;
        public SerialReader(final InputStream in) {
            this.in = in;
        }

        @Override
        public void run() {
            final byte[] buffer = new byte[64];
            int len = -1;
            try {
                while ((len = this.in.read(buffer)) > -1) {
                    final String datos = new String(buffer, 0, len);
                    System.out.println(datos);
                    new CloneRegistro().setNombre(datos);
                    System.out.println("datos.... desde puerto controller...");
                    Thread.sleep(100L);
                }
            }
            catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    private String mensaje="hola ab";
    public String enviandoDatos(){
        return this.getMensaje();
    }
}
