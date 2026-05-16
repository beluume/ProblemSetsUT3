package org.example.Ejercicio16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodoArbol {
    private final Persona persona;
    private final List<NodoArbol> hijos;

    public NodoArbol(Persona persona) {
        this.persona = persona;
        this.hijos = new ArrayList<>();
    }

    public Persona getPersona() {
        return persona;
    }

    public List<NodoArbol> getHijos() {
        return Collections.unmodifiableList(hijos);
    }

    public void agregarHijo(NodoArbol hijo) {
        if (hijo != null) {
            hijos.add(hijo);
        }
    }
}