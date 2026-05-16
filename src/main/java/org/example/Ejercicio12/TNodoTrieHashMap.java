package org.example.ejercicio12;

import java.util.HashMap;

public class TNodoTrieHashMap {

    boolean esFin;
    HashMap<Character, TNodoTrieHashMap> hijos;

    public TNodoTrieHashMap() {

        this.esFin = false;

        this.hijos = new HashMap<Character, TNodoTrieHashMap>();
    }
}