package org.example.ejercicio12;

import java.util.HashMap;
import java.util.ArrayList;

public class TTrieHashMap {

    TNodoTrieHashMap raiz;

    public TTrieHashMap() {
        this.raiz = new TNodoTrieHashMap();
    }

    public void insertar(String palabra) {
        TNodoTrieHashMap actual = raiz;

        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);

            if (!actual.hijos.containsKey(c)) {
                actual.hijos.put(c, new TNodoTrieHashMap());
            }

            actual = actual.hijos.get(c);
        }

        actual.esFin = true;
    }

    public boolean buscar(String palabra) {
        TNodoTrieHashMap actual = raiz;

        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);

            if (!actual.hijos.containsKey(c)) {
                return false;
            }

            actual = actual.hijos.get(c);
        }

        return actual.esFin;
    }

    public boolean buscarPrefijo(String prefijo) {
        TNodoTrieHashMap actual = raiz;

        for (int i = 0; i < prefijo.length(); i++) {
            char c = prefijo.charAt(i);

            if (!actual.hijos.containsKey(c)) {
                return false;
            }

            actual = actual.hijos.get(c);
        }

        return true;
    }

    public ArrayList<String> autocompletar(String prefijo) {
        ArrayList<String> resultados = new ArrayList<String>();
        TNodoTrieHashMap actual = raiz;

        for (int i = 0; i < prefijo.length(); i++) {
            char c = prefijo.charAt(i);

            if (!actual.hijos.containsKey(c)) {
                return resultados;
            }

            actual = actual.hijos.get(c);
        }

        recolectarPalabras(actual, prefijo, resultados);

        return resultados;
    }

    private void recolectarPalabras(TNodoTrieHashMap nodo,
                                    String palabraActual,
                                    ArrayList<String> resultados) {

        if (nodo.esFin) {
            resultados.add(palabraActual);
        }

        for (char c : nodo.hijos.keySet()) {
            recolectarPalabras(
                    nodo.hijos.get(c),
                    palabraActual + c,
                    resultados
            );
        }
    }

    public ArrayList<Integer> buscarPatron(String texto, String patron) {
        ArrayList<Integer> posiciones = new ArrayList<Integer>();

        for (int i = 0; i <= texto.length() - patron.length(); i++) {

            String subcadena = texto.substring(i, i + patron.length());

            if (subcadena.equals(patron)) {
                posiciones.add(i);
            }
        }

        return posiciones;
    }

    public void construirArbolDeSufijos(String texto) {

        for (int i = 0; i < texto.length(); i++) {

            String sufijo = texto.substring(i);

            insertar(sufijo);
        }
    }

    public boolean buscarPatronEnArbol(String patron) {
        return buscarPrefijo(patron);
    }
}