/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaprogra2;

import javax.swing.JOptionPane;

/**
 *
 * @author Mia Symns
 */
    public class JuegoAhorcadoAzar extends JuegoAhorcadoBase {
    private final char[] Palabra;
    
    public JuegoAhorcadoAzar(AdminPalabrasSecretas PalabrasRandom){
        Palabra = new char[palabrasecreta.length()];
        palabrasecreta = PalabrasRandom.getPalabraAlAzar();
    }
    
    @Override
    void actualizarPalabraActual(char letra) {
        palabraactual = "";
        for (int Pos = 0; Pos < Palabra.length; Pos++){
            if (this.palabrasecreta.charAt(Pos) == letra){
                Palabra[Pos] = letra;
                palabraactual += Palabra[Pos];
            }
        }
    }

    @Override
    boolean verificarLetra(char letra) {
        return (palabrasecreta.contains(String.valueOf(letra)));
    }

    @Override
    boolean hasGanado() {
        return (palabrasecreta.equals(palabraactual));
    }

    @Override
    public void inicializarPalabraSecreta() {
        for (int Pos = 0; Pos < Palabra.length; Pos++){
            Palabra[Pos] = ' ';
        }
    }

    @Override
    public void Jugar() {
        this.intentos = 9;
        while (intentos > 0 || !hasGanado()){
            String PalabraIngresada = "";
            do {
                try {
                    PalabraIngresada = JOptionPane.showInputDialog(null, "Caracteres encontrados: " + this.palabraactual + "\nIngrese un caracter: ");
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un caracter!");
                }
                if (PalabraIngresada.length() != 1) JOptionPane.showMessageDialog(null, "Por favor limitese a un solo caracter");
            } while (PalabraIngresada.isBlank() || PalabraIngresada.length() != 1);
            if (this.verificarLetra(PalabraIngresada.charAt(0))){
                actualizarPalabraActual(PalabraIngresada.charAt(0));
                JOptionPane.showMessageDialog(null,"Ha acertado un caracter!");
            } else {
                intentos--;
                JOptionPane.showMessageDialog(null, "No le ha acertado!");
            }
        }
        if (hasGanado()){
            JOptionPane.showMessageDialog(null, "Ha gando, la palabra era: "+this.palabraactual);
        } else JOptionPane.showMessageDialog(null, "Ha perdido, la palabra era: "+this.palabrasecreta);
    }
}
