package org.example.Ejercicio9;

public class TablaHashLineal {

    private final Integer[] tabla;
    private int cantidadElementos;

    public TablaHashLineal(int capacidad) {
        this.tabla = new Integer[capacidad];
    }

    public ResultadoOperacionHash insertar(int clave) {
        int comparaciones = 0;
        for (int i = 0; i < tabla.length; i++) {
            int indice = (funcionHash(clave) + i) % tabla.length;
            comparaciones++;

            Integer actual = tabla[indice];
            if (actual == null) {
                tabla[indice] = clave;
                cantidadElementos++;
                return new ResultadoOperacionHash(true, comparaciones);
            }
            if (actual == clave) {
                return new ResultadoOperacionHash(false, comparaciones);
            }
        }
        return new ResultadoOperacionHash(false, comparaciones);
    }

    public ResultadoOperacionHash buscar(int clave) {
        int comparaciones = 0;
        for (int i = 0; i < tabla.length; i++) {
            int indice = (funcionHash(clave) + i) % tabla.length;
            comparaciones++;

            Integer actual = tabla[indice];
            if (actual == null) {
                return new ResultadoOperacionHash(false, comparaciones);
            }
            if (actual == clave) {
                return new ResultadoOperacionHash(true, comparaciones);
            }
        }
        return new ResultadoOperacionHash(false, comparaciones);
    }

    public double getFactorCargaActual() {
        return (double) cantidadElementos / tabla.length;
    }

    private int funcionHash(int clave) {
        return Math.floorMod(clave, tabla.length);
    }
}
