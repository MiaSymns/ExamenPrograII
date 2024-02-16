/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaprogra2;

/**
 *
 * @author Mia Symns
 */
public final class BarcoPesquero extends Barco {
   private int pecesCapturados;
    private TipoPesquero  tipoPesquero;

    public BarcoPesquero(String nombre, TipoPesquero tipoPesquero) {
        super(nombre);
        this.pecesCapturados = 0;
        this.tipoPesquero=tipoPesquero;
    }

    @Override
    public void agregarElemento() {
        this.pecesCapturados++;
    }

    @Override
    public double vaciarCobrar() {
        double total = this.pecesCapturados * this.tipoPesquero.price;
        this.pecesCapturados = 0;
        return total;
    }

    @Override
    public double precioElemento() {
        return this.tipoPesquero.price;
    }

    @Override
    public String toString() {
        return "BarcoPesquero{" + "nombre=" + this.getNombre() + ", tipoPesquero=" + this.tipoPesquero + ", pecesCapturados=" + this.pecesCapturados + '}';
    } 
}
