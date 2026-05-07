package org.example.tda.trie;

import java.util.List;
import java.util.function.Consumer;

public class Trie<T> implements TTrie<T>{

    private NodoTrie<T> actual = raiz;

    public Trie() {
        this.raiz = new NodoTrie<>();
    }
    public void recorrer(Consumer<Entry<T>> consumer){

    }

    public Entry<T> buscar(String palabra) {
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);

            if (actual.hijos[letra] == null) {
                return null;
            } else {
                actual = actual.hijos[letra];
            }
        }

    }

    public boolean insertar(String palabra, T dato){

    }

    public List<Entry<T>> predecir(String prefijo){

    }

}
