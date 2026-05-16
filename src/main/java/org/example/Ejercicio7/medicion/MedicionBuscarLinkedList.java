package org.example.Ejercicio7.medicion;

import org.example.medible.lib.Medible;

import java.util.LinkedList;
import java.util.List;

public class MedicionBuscarLinkedList extends Medible<List<String>> {

    private final LinkedList<String> linkedList;
    private int checksum;

    public MedicionBuscarLinkedList(LinkedList<String> linkedList) {
        this.linkedList = linkedList;
    }

    @Override
    public void ejecutar(int repeticiones, List<String> palabras) {
        checksum = 0;
        for (int i = 0; i < repeticiones; i++) {
            for (String palabra : palabras) {
                if (linkedList.contains(palabra)) {
                    checksum++;
                }
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return linkedList;
    }
}
