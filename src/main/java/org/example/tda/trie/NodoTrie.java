package org.example.tda.trie;

import java.util.List;
import java.util.function.Consumer;

public class NodoTrie<T> implements TNodoTrie<T>{

    NodoTrie<T>[] hijos;

    public NodoTrie() {
        hijos = new NodoTrie[256];
    }

    public void recorrer(Consumer<Entry<T>> consumer){

    }

    public Entry<T> buscar(String palabra){
        nodoActual = this;
        for (int i = 0; i < palabra.length(); i++) {
            // char letra = palabra.charAt(i);
        }
    }

    public boolean insertar(String palabra, T dato){

    }

    public List<Entry<T>> predecir(String prefijo){

    }

    public T getDato(){

    }

    public boolean esPalabra(){

    }
}
