package org.example.Ejercicio7;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleTrie<T> implements Serializable {

    private final TrieNode<T> root = new TrieNode<>();

    public void insertar(String palabra, T dato) {
        if (palabra == null || palabra.isEmpty()) {
            return;
        }
        TrieNode<T> actual = root;
        for (char caracter : palabra.toCharArray()) {
            actual = actual.hijos.computeIfAbsent(caracter, c -> new TrieNode<>());
        }
        actual.esPalabra = true;
        actual.dato = dato;
    }

    public boolean contiene(String palabra) {
        TrieNode<T> nodo = buscarNodo(palabra);
        return nodo != null && nodo.esPalabra;
    }

    public List<String> predecir(String prefijo) {
        List<String> resultado = new ArrayList<>();
        TrieNode<T> inicio = buscarNodo(prefijo);
        if (inicio == null) {
            return resultado;
        }
        StringBuilder acumulado = new StringBuilder(prefijo);
        recolectar(inicio, acumulado, resultado);
        return resultado;
    }

    private TrieNode<T> buscarNodo(String texto) {
        if (texto == null) {
            return null;
        }
        TrieNode<T> actual = root;
        for (char caracter : texto.toCharArray()) {
            actual = actual.hijos.get(caracter);
            if (actual == null) {
                return null;
            }
        }
        return actual;
    }

    private void recolectar(TrieNode<T> nodo, StringBuilder acumulado, List<String> resultado) {
        if (nodo.esPalabra) {
            resultado.add(acumulado.toString());
        }
        for (Map.Entry<Character, TrieNode<T>> hijo : nodo.hijos.entrySet()) {
            acumulado.append(hijo.getKey());
            recolectar(hijo.getValue(), acumulado, resultado);
            acumulado.deleteCharAt(acumulado.length() - 1);
        }
    }

    private static class TrieNode<T> implements Serializable {
        private final Map<Character, TrieNode<T>> hijos = new HashMap<>();
        private boolean esPalabra;
        private T dato;
    }
}
