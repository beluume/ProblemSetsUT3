package org.example.Ejercicio3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieIndice {

    private final Nodo raiz = new Nodo();

    public boolean insertar(String palabra, String ocurrencia) {
        String limpia = normalizar(palabra);
        if (limpia == null) {
            return false;
        }

        Nodo actual = raiz;
        for (char caracter : limpia.toCharArray()) {
            actual = actual.hijos.computeIfAbsent(caracter, c -> new Nodo());
        }

        boolean eraNueva = !actual.esPalabra;
        actual.esPalabra = true;
        if (ocurrencia != null && !ocurrencia.trim().isEmpty()) {
            actual.ocurrencias.add(ocurrencia.trim());
        }
        return eraNueva;
    }

    public List<String> buscar(String palabra) {
        String limpia = normalizar(palabra);
        if (limpia == null) {
            return new ArrayList<>();
        }

        Nodo actual = raiz;
        for (char caracter : limpia.toCharArray()) {
            actual = actual.hijos.get(caracter);
            if (actual == null) {
                return new ArrayList<>();
            }
        }
        if (!actual.esPalabra) {
            return new ArrayList<>();
        }
        return new ArrayList<>(actual.ocurrencias);
    }

    private String normalizar(String texto) {
        if (texto == null) {
            return null;
        }
        String limpio = texto.trim().toLowerCase();
        if (limpio.isEmpty()) {
            return null;
        }
        return limpio;
    }

    private static class Nodo {
        private final Map<Character, Nodo> hijos = new HashMap<>();
        private final List<String> ocurrencias = new ArrayList<>();
        private boolean esPalabra;
    }
}
