/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaprogra2;

import java.util.Date;

/**
 *
 * @author Mia Symns
 */
public abstract class Barco {
  
    private final String nombre;
    private final Date fechaPuestaEnCirculacion;

    public Barco(String nombre) {
        this.nombre = nombre;
        this.fechaPuestaEnCirculacion = new Date();
    }

    public final String getNombre() {
        return nombre;
    }

    public final Date getFechaPuestaEnCirculacion() {
        return fechaPuestaEnCirculacion;
    }

    public abstract void agregarElemento();

    public abstract double vaciarCobrar();

    public abstract double precioElemento();

    @Override
    public String toString() {
        return "Nombre del barco: " + nombre;
    }
  
}
