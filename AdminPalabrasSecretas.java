/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaprogra2;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mia Symns
 */
public class AdminPalabrasSecretas {
    private final ArrayList<String> PalabrasSecretas;
    private final Random Randy = new Random();
    
    public AdminPalabrasSecretas(){
        PalabrasSecretas = new ArrayList();
        PalabrasSecretas.add("Palindromo");
    }
    
    public void DeletePalabra(int Pos){
        PalabrasSecretas.remove(Pos);
    }
    
    public void AddPalabra(String Palabra){
        PalabrasSecretas.add(Palabra);
    }
    
    public String getPalabraAlAzar(){
        int Elegido = Randy.nextInt(PalabrasSecretas.size());
        return PalabrasSecretas.get(Elegido);
    }
}
