package org.example.Ejercicio7.medicion;

import org.example.medible.lib.Medible;

import java.util.List;
import java.util.Map;

public class MedicionBuscarHashMap extends Medible<List<String>> {

    private final Map<String, String> hashMap;
    private int checksum;

    public MedicionBuscarHashMap(Map<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public void ejecutar(int repeticiones, List<String> palabras) {
        checksum = 0;
        for (int i = 0; i < repeticiones; i++) {
            for (String palabra : palabras) {
                if (hashMap.containsKey(palabra)) {
                    checksum++;
                }
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return hashMap;
    }
}
