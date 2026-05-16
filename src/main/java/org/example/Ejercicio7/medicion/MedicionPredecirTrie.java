package org.example.Ejercicio7.medicion;

import org.example.Ejercicio7.SimpleTrie;
import org.example.medible.lib.Medible;

public class MedicionPredecirTrie extends Medible<String> {

    private final SimpleTrie<String> trie;
    private int checksum;

    public MedicionPredecirTrie(SimpleTrie<String> trie) {
        this.trie = trie;
    }

    @Override
    public void ejecutar(int repeticiones, String prefijo) {
        checksum = 0;
        for (int i = 0; i < repeticiones; i++) {
            checksum += trie.predecir(prefijo).size();
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return trie;
    }
}
