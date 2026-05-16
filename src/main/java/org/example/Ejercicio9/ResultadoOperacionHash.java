package org.example.Ejercicio9;

public class ResultadoOperacionHash {
    private final boolean exito;
    private final int comparaciones;

    public ResultadoOperacionHash(boolean exito, int comparaciones) {
        this.exito = exito;
        this.comparaciones = comparaciones;
    }

    public boolean isExito() {
        return exito;
    }

    public int getComparaciones() {
        return comparaciones;
    }
}
