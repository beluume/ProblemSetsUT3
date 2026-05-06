package org.example.tda.trie;

import java.util.List;
import java.util.function.Consumer;

public class Nodo<T> implements TNodoTrie<T>{

    private static int cantidadLetras = 27;
    private T dato;
    private Nodo<T>[] hijos;
    public boolean palabra;

    public Nodo () {
        hijos = new Nodo[cantidadLetras];
        palabra = false;
        dato = null;
    }


    @Override
    public void recorrer(Consumer<Entry<T>> consumer) {

        recorerRecursivo("",consumer);

    }

    @Override
    public Entry<T> buscar(String palabra) {
        return null;
    }

    @Override
    public boolean insertar(String palabra, T dato) {
        Nodo<T> nodoActual = this; //raíz del trie
        palabra = palabra.toLowerCase() //toda la palabra a minúscula y se van eliminando los tíldes
                .replace("á", "a")
                .replace("é", "e")
                .replace("í", "i")
                .replace("ó", "o")
                .replace("ú", "u");

        for (int i = 0; i < palabra.length(); i++) { //se recorre letra por letra
            char c = palabra.charAt(i); //se obtiene la letra actual
            int indice = c - 'a';

            if (nodoActual.hijos[indice] == null) { //si el nodo hijo no existe, se crea
                nodoActual.hijos[indice] = new Nodo<>();
            }
            nodoActual = nodoActual.hijos[indice]; // se avanza al siguiente nodo
        }
        if (nodoActual.palabra) {
            return false;
        }
        nodoActual.palabra = true; //se marca el nodo como el fin de la palabra
        nodoActual.dato = dato; //se guarda el dato 
        return true;
    }

    @Override
    public List<Entry<T>> predecir(String prefijo) {
        return List.of();
    }

    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public boolean esPalabra() {
        return palabra;
    }

    public void recorerRecursivo(String palabraAcumulada, Consumer<Entry<T>> consumer) {

        if (this.palabra)
        {
            Entry<T> nuevaEntrada = new Entry<>(this.dato, true, palabraAcumulada)
            consumer.accept(nuevaEntrada);

            for(int i = 0; i < palabraAcumulada.length(); i++) {
                if(hijos[i] == null)
                {
                    char letraHijo = (char) ('a' + i);
                    hijos[i].recorerRecursivo(palabraAcumulada +  letraHijo, consumer);
                }
            }
        }

    }
}
