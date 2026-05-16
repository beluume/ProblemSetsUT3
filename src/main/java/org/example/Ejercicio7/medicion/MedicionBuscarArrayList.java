package org.example.Ejercicio7.medicion;

import org.example.medible.lib.Medible;

import java.util.ArrayList;
import java.util.List;

public class MedicionBuscarArrayList extends Medible<List<String>> {

    private final ArrayList<String> arrayList;
    private int checksum;

    public MedicionBuscarArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void ejecutar(int repeticiones, List<String> palabras) {
        checksum = 0;
        for (int i = 0; i < repeticiones; i++) {
            for (String palabra : palabras) {
                if (arrayList.contains(palabra)) {
                    checksum++;
                }
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return arrayList;
    }
}
