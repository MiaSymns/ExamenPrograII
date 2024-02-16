/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaprogra2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author Mia Symns
 */
public class Muelle {
    private ArrayList<Barco> barcos;

    public Muelle() {
        barcos = new ArrayList<>();
    }
    
    public void agregarBarco(String tipo) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del barco: ");
        String nombre = scanner.nextLine();
        if (barcos.contains(nombre)) {
            System.out.println("Ya existe un barco con ese nombre.");
            return;
        }
        if (tipo.equalsIgnoreCase("PESQUERO")) {
            BarcoPesquero barcoPesquero = new BarcoPesquero(nombre, TipoPesquero.CAMARON);
            barcos.add(barcoPesquero);
        } else if (tipo.equalsIgnoreCase("PASAJERO")) {
            // System.out.print("Ingrese la fecha de circulaciÃ³n (formato dd-mm-yyyy): ");
            // String fecha = scanner.nextLine();
            System.out.print("Ingrese el precio del boleto: ");
            double precioBoleto = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            System.out.print("Ingrese la capacidad: ");
            int capacidad = scanner.nextInt();
            scanner.nextLine(); // consume newline
            BarcoPasajero barcoPasajero = new BarcoPasajero(nombre, capacidad, precioBoleto);
            barcos.add(barcoPasajero);
        } else {
            System.out.println("Tipo de barco invÃ¡lido.");
        }
    }
    
    public void agregarElemento(String nombre) {
        for (Barco barco : barcos) {
            if (barco.getNombre().equals(nombre)) {
                barco.agregarElemento();
                return;
            }
        }
        System.out.println("No existe un barco con ese nombre.");
    }
    
    public double vaciarBarco(String nombre) {
        for (Barco barco : barcos) {
            if (barco.getNombre().equals(nombre)) {
                if (barco instanceof BarcoPasajero) {
                    BarcoPasajero barcoPasajero = (BarcoPasajero) barco;
                    double total = barcoPasajero.vaciarCobrar();
                    JOptionPane.showMessageDialog(null, "Barco " + nombre + " vaciado. Total generado: " + total);
                    barcoPasajero.listarPasajeros();
                    return total;
                } else if (barco instanceof BarcoPesquero) {
                    double total = barco.vaciarCobrar();
                    JOptionPane.showMessageDialog(null, "Barco " + nombre + " vaciado. Total generado: " + total);
                    return total;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "No existe un barco con ese nombre.");
        return 0;
    }
    
    public void barcosDesde(int year) {
        String message = "";
        for (Barco barco : barcos) {
            Date fecha = barco.getFechaPuestaEnCirculacion();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha);
            int barcoYear = calendar.get(Calendar.YEAR);
            if (barcoYear >= year) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                message += barco.getNombre() + " " + sdf.format(fecha) + "\n";
            }
        }
        if (!message.isEmpty()) {
            JOptionPane.showMessageDialog(null, message);
        } else {
            JOptionPane.showMessageDialog(null, "No hay barcos con fecha de circulaciÃ³n desde " + year);
        }
    }
    
    public static void main(String[] args) {
        Muelle muelle = new Muelle();
        String[] opciones = {"Agregar Barco", "Agregar Elemento", "Vaciar Barco", "Barcos Desde", "Salir"};
        int opcionSeleccionada;
        do {
            opcionSeleccionada = JOptionPane.showOptionDialog(null,
                    "Seleccione una opciÃ³n:",
                    "Muelle",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);
            switch (opcionSeleccionada) {
                case 0:
                    String[] tipos = {"Pesquero", "Pasajero"};
                    int tipoSeleccionado = JOptionPane.showOptionDialog(null,
                            "Seleccione el tipo de barco:",
                            "Muelle",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            tipos,
                            tipos[0]);
                    muelle.agregarBarco(tipos[tipoSeleccionado]);
                    break;
                case 1:
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del barco:");
                    muelle.agregarElemento(nombre);
                    break;
                case 2:
                    nombre = JOptionPane.showInputDialog("Ingrese el nombre del barco:");
                    muelle.vaciarBarco(nombre);
                    break;
                case 3:
                    String input = JOptionPane.showInputDialog("Ingrese el aÃ±o:");
                    int year = Integer.parseInt(input);
                    muelle.barcosDesde(year);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "OpciÃ³n invÃ¡lida.");
            }
        } while (opcionSeleccionada != 4);
    }
}
