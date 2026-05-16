package org.example.Ejercicio16;

public class Persona {
    private final String nombre;
    private final int anioNacimiento;

    public Persona(String nombre, int anioNacimiento) {
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    @Override
    public String toString() {
        return nombre + " (" + anioNacimiento + ")";
    }
}