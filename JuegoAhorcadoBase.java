/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaprogra2;

/**
 *
 * @author Mia Symns
 */
public abstract class JuegoAhorcadoBase implements JuegoAhorcado {
    protected String palabrasecreta, palabraactual;
    protected int intentos; 
    
    abstract void actualizarPalabraActual(char letra);
    
    abstract boolean verificarLetra(char letra);
    
    abstract boolean hasGanado();

    
}
