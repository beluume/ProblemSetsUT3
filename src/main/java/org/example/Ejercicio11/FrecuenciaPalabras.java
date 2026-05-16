package org.example.Ejercicio11;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class FrecuenciaPalabras
{
    public static void main(String[] args)
    {
        HashMap<String, Integer> mapa = new HashMap<>();

        try {
            Scanner leer = new Scanner(new File("libro.txt"));

            while (leer.hasNext()) {
                String palabra = leer.next();
                palabra = palabra.toLowerCase();
                palabra = palabra.replace(".", "");
                palabra = palabra.replace(",", "");
                if (mapa.containsKey(palabra)) {
                    int cantidad = mapa.get(palabra);
                    mapa.put(palabra, cantidad + 1);
                }  else {
                    mapa.put(palabra, 1);
                    }
                }

            leer.close();
            System.out.println("Frecuencia palabras: ");
            for (String palabra : mapa.keySet()) {
                System.out.println(palabra + " - " + mapa.get(palabra));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }
}
