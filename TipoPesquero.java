/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pruebaprogra2;

/**
 *
 * @author Mia Symns
 */
public enum TipoPesquero {
    PEZ(15.0),
    CAMARON(30.0),
    LANGOSTA(50.0);

    public final double price;

    TipoPesquero(double price) {
        this.price = price;
    }
}
