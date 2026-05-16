package org.example.Ejercicio7.medicion;

import org.example.medible.lib.Medible;

import java.util.Map;

public class MedicionPredecirHashMap extends Medible<String> {

    private final Map<String, String> hashMap;
    private int checksum;

    public MedicionPredecirHashMap(Map<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public void ejecutar(int repeticiones, String prefijo) {
        checksum = 0;
        for (int i = 0; i < repeticiones; i++) {
            for (String palabra : hashMap.keySet()) {
                if (palabra.startsWith(prefijo)) {
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
