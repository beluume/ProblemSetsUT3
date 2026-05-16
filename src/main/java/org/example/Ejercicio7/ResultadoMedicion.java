package org.example.Ejercicio7;

public class ResultadoMedicion {

    private final String estructura;
    private final double memoriaMB;
    private final double tiempoMS;

    public ResultadoMedicion(String estructura, double memoriaMB, double tiempoMS) {
        this.estructura = estructura;
        this.memoriaMB = memoriaMB;
        this.tiempoMS = tiempoMS;
    }

    public String getEstructura() {
        return estructura;
    }

    public double getMemoriaMB() {
        return memoriaMB;
    }

    public double getTiempoMS() {
        return tiempoMS;
    }
}
