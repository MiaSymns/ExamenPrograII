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
public class JuegoAhorcadoFijo extends JuegoAhorcadoBase {
    public JuegoAhorcadoFijo(String palabrasecreta) {
        this.palabrasecreta = palabrasecreta.toUpperCase();
        inicializarPalabraSecreta();
        intentos = 6;
    }

    @Override
    public void actualizarPalabraActual(char letra) {
        char[] palabrareemplazar = palabraactual.toCharArray();
        if (verificarLetra(letra)) {
            for (int i = 0; i < palabrasecreta.toCharArray().length; i++) {
                if (palabrasecreta.toCharArray()[i] == letra) {
                    palabrareemplazar[i] = letra;
                }
            }
            palabraactual = new String(palabrareemplazar);
        } else {
            intentos -= 1;
        }
    }

    @Override
    public boolean verificarLetra(char letra) {
        for (char letraverificar : palabrasecreta.toCharArray()) {
            if (letraverificar == letra) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void inicializarPalabraSecreta() {
        palabraactual = "";
        for (int i = 0; i < palabrasecreta.length(); i++) {
            palabraactual += "_";
        }
    }

    @Override
    public boolean hasGanado() {
        return palabraactual.equals(palabrasecreta);
    }
    @Override
    public void Jugar() {
        while (intentos > 0) {
            String palabraMutilada = "";
            for (int i = 0; i < palabraactual.length(); i++) {
                palabraMutilada += palabraactual.charAt(i) + " ";
            }
            String prueba;
            do {
                prueba = JOptionPane.showInputDialog(null,
                        "Ingrese la letra que intenta adivinar\nPista: " + palabraMutilada + "\nIntentos restantes: "
                                + intentos,
                        "Ahorcado Fijo", JOptionPane.INFORMATION_MESSAGE);
            } while (prueba == null);
            prueba = prueba.toUpperCase();
            if (!prueba.equals("")) {
                char letra = prueba.charAt(0);
                actualizarPalabraActual(letra);
                if (hasGanado() && intentos > 0) {
                    JOptionPane.showMessageDialog(null, "Felicidades, has acertado :3 ");
                    intentos = 0;
                } else if (intentos == 0) {
                    JOptionPane.showMessageDialog(null, "Mejor suerte a la próxima ;-;");
                }
            }
        }
    }
}
