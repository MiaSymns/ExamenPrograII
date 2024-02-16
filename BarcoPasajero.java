/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaprogra2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Mia Symns
 */
public class BarcoPasajero extends Barco  {
    private String[] pasajeros;
    private double precioBoleto;
    private int contadorPasajeros;
    private int capacidad;

    public BarcoPasajero(String nombre, int capacidad, double precioBoleto) {
        super(nombre);
        this.pasajeros = new String[capacidad];
        this.precioBoleto = precioBoleto;
        this.contadorPasajeros = 0;
        this.capacidad=capacidad;
    }

    @Override
    public void agregarElemento() {
        if (contadorPasajeros < capacidad) {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 100);
            frame.setLayout(new FlowLayout());
            JLabel label = new JLabel("Ingrese el nombre del pasajero: ");
            JTextField textField = new JTextField(20);
            JButton button = new JButton("Agregar");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nombrePasajero = textField.getText();
                    if (!nombrePasajero.isEmpty()) {
                        pasajeros[contadorPasajeros] = nombrePasajero;
                        contadorPasajeros++;
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(frame, "El nombre no puede estar vacÃ­o.");
                    }
                }
            });
            frame.add(label);
            frame.add(textField);
            frame.add(button);
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio en el barco.");
        }
    }

    @Override
    public double vaciarCobrar() {
        double total = contadorPasajeros * precioBoleto;
        contadorPasajeros = 0;
        return total;
    }

    @Override
    public double precioElemento() {
        return precioBoleto;
    }

    @Override
    public String toString() {
        return super.toString() + " Cantidad de Pasajeros que compraron boleto: " + contadorPasajeros;
    }

    public void listarPasajeros() {
        if (contadorPasajeros > 0) {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.setLayout(new FlowLayout());
            JLabel label = new JLabel("Pasajeros que compraron boleto: ");
            JTextArea textArea = new JTextArea(contadorPasajeros + "\n", 5, 20);
            for (int i = 0; i < contadorPasajeros; i++) {
                textArea.append((i + 1) + ". " + pasajeros[i] + "\n");
            }
            frame.add(label);
            frame.add(new JScrollPane(textArea));
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No hay pasajeros en el barco.");
        }
    }

}
