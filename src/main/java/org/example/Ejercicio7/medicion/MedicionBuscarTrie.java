package org.example.Ejercicio7.medicion;

import org.example.Ejercicio7.SimpleTrie;
import org.example.medible.lib.Medible;

import java.util.List;

public class MedicionBuscarTrie extends Medible<List<String>> {

    private final SimpleTrie<String> trie;
    private int checksum;

    public MedicionBuscarTrie(SimpleTrie<String> trie) {
        this.trie = trie;
    }

    @Override
    public void ejecutar(int repeticiones, List<String> palabras) {
        checksum = 0;
        for (int i = 0; i < repeticiones; i++) {
            for (String palabra : palabras) {
                if (trie.contiene(palabra)) {
                    checksum++;
                }
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return trie;
    }
}
