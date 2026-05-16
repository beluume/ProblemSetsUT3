package org.example.Ejercicio7.medicion;

import org.example.medible.lib.Medible;

import java.util.LinkedList;

public class MedicionPredecirLinkedList extends Medible<String> {

    private final LinkedList<String> linkedList;
    private int checksum;

    public MedicionPredecirLinkedList(LinkedList<String> linkedList) {
        this.linkedList = linkedList;
    }

    @Override
    public void ejecutar(int repeticiones, String prefijo) {
        checksum = 0;
        for (int i = 0; i < repeticiones; i++) {
            for (String palabra : linkedList) {
                if (palabra.startsWith(prefijo)) {
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
