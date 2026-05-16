package org.example.Ejercicio16;

import java.util.ArrayList;
import java.util.List;

public class ArbolGenealogico {

    private final NodoArbol raiz;

    public ArbolGenealogico(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public List<Persona> listarDescendientes(String nombreBuscado) {
        List<Persona> resultado = new ArrayList<>();
        NodoArbol nodo = buscarNodo(raiz, nombreBuscado);
        if (nodo == null) {
            return resultado;
        }

        for (NodoArbol hijo : nodo.getHijos()) {
            recolectarSubarbol(hijo, resultado);
        }
        return resultado;
    }

    public int calcularAltura() {
        return calcularAltura(raiz);
    }

    public int contarPersonas() {
        return contarPersonas(raiz);
    }

    public List<Persona> obtenerPersonasGeneracion(int generacionBuscada) {
        List<Persona> resultado = new ArrayList<>();
        if (generacionBuscada < 0) {
            return resultado;
        }
        listarGeneracion(raiz, generacionBuscada, 0, resultado);
        return resultado;
    }

    public Persona ancestroComunMasCercano(String nombre1, String nombre2) {
        List<NodoArbol> ruta1 = new ArrayList<>();
        List<NodoArbol> ruta2 = new ArrayList<>();

        boolean existe1 = encontrarRuta(raiz, nombre1, ruta1);
        boolean existe2 = encontrarRuta(raiz, nombre2, ruta2);
        if (!existe1 || !existe2) {
            return null;
        }

        NodoArbol ultimoComun = null;
        int minimo = Math.min(ruta1.size(), ruta2.size());
        for (int i = 0; i < minimo; i++) {
            if (ruta1.get(i) == ruta2.get(i)) {
                ultimoComun = ruta1.get(i);
            } else {
                break;
            }
        }

        return ultimoComun == null ? null : ultimoComun.getPersona();
    }

    public boolean esDescendiente(String nombreAncestro, String nombreDescendiente) {
        NodoArbol ancestro = buscarNodo(raiz, nombreAncestro);
        if (ancestro == null) {
            return false;
        }
        for (NodoArbol hijo : ancestro.getHijos()) {
            if (contieneNombre(hijo, nombreDescendiente)) {
                return true;
            }
        }
        return false;
    }

    private void recolectarSubarbol(NodoArbol nodo, List<Persona> resultado) {
        resultado.add(nodo.getPersona());
        for (NodoArbol hijo : nodo.getHijos()) {
            recolectarSubarbol(hijo, resultado);
        }
    }

    private int calcularAltura(NodoArbol nodo) {
        if (nodo == null || nodo.getHijos().isEmpty()) {
            return 0;
        }

        int maxAltura = 0;
        for (NodoArbol hijo : nodo.getHijos()) {
            int altura = calcularAltura(hijo);
            if (altura > maxAltura) {
                maxAltura = altura;
            }
        }
        return maxAltura + 1;
    }

    private int contarPersonas(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        int total = 1;
        for (NodoArbol hijo : nodo.getHijos()) {
            total += contarPersonas(hijo);
        }
        return total;
    }

    private void listarGeneracion(NodoArbol nodo, int generacionBuscada, int generacionActual, List<Persona> resultado) {
        if (nodo == null) {
            return;
        }
        if (generacionActual == generacionBuscada) {
            resultado.add(nodo.getPersona());
            return;
        }
        for (NodoArbol hijo : nodo.getHijos()) {
            listarGeneracion(hijo, generacionBuscada, generacionActual + 1, resultado);
        }
    }

    private NodoArbol buscarNodo(NodoArbol nodo, String nombreBuscado) {
        if (nodo == null || nombreBuscado == null) {
            return null;
        }
        if (nombreBuscado.equals(nodo.getPersona().getNombre())) {
            return nodo;
        }
        for (NodoArbol hijo : nodo.getHijos()) {
            NodoArbol encontrado = buscarNodo(hijo, nombreBuscado);
            if (encontrado != null) {
                return encontrado;
            }
        }
        return null;
    }

    private boolean contieneNombre(NodoArbol nodo, String nombreBuscado) {
        if (nodo == null) {
            return false;
        }
        if (nombreBuscado.equals(nodo.getPersona().getNombre())) {
            return true;
        }
        for (NodoArbol hijo : nodo.getHijos()) {
            if (contieneNombre(hijo, nombreBuscado)) {
                return true;
            }
        }
        return false;
    }

    private boolean encontrarRuta(NodoArbol nodo, String nombreBuscado, List<NodoArbol> ruta) {
        if (nodo == null) {
            return false;
        }
        ruta.add(nodo);
        if (nombreBuscado.equals(nodo.getPersona().getNombre())) {
            return true;
        }
        for (NodoArbol hijo : nodo.getHijos()) {
            if (encontrarRuta(hijo, nombreBuscado, ruta)) {
                return true;
            }
        }
        ruta.remove(ruta.size() - 1);
        return false;
    }
}