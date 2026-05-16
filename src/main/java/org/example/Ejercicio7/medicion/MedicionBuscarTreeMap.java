package org.example.Ejercicio7.medicion;

import org.example.medible.lib.Medible;

import java.util.List;
import java.util.Map;

public class MedicionBuscarTreeMap extends Medible<List<String>> {

    private final Map<String, String> treeMap;
    private int checksum;

    public MedicionBuscarTreeMap(Map<String, String> treeMap) {
        this.treeMap = treeMap;
    }

    @Override
    public void ejecutar(int repeticiones, List<String> palabras) {
        checksum = 0;
        for (int i = 0; i < repeticiones; i++) {
            for (String palabra : palabras) {
                if (treeMap.containsKey(palabra)) {
                    checksum++;
                }
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return treeMap;
    }
}
