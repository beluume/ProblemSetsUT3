package org.example.Ejercicio16;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio16Main {

    private static final String RUTA_SALIDA = "salidas\\Ejercicio16\\resultados_ejercicio16.txt";

    public static void main(String[] args) throws IOException {
        ArbolGenealogico arbol = crearArbolEjemplo();
        List<String> lineas = generarSalida(arbol);
        guardarSalida(lineas);

        for (String linea : lineas) {
            System.out.println(linea);
        }
        System.out.println("Salida guardada en: " + RUTA_SALIDA);
    }

    private static ArbolGenealogico crearArbolEjemplo() {
        NodoArbol abuela = new NodoArbol(new Persona("Abuela Rosa", 1940));

        NodoArbol hijo1 = new NodoArbol(new Persona("Tio Carlos", 1965));
        NodoArbol hijo2 = new NodoArbol(new Persona("Mama Laura", 1968));
        NodoArbol hijo3 = new NodoArbol(new Persona("Tia Marta", 1972));

        NodoArbol nieto1 = new NodoArbol(new Persona("Pedro", 1990));
        NodoArbol nieto2 = new NodoArbol(new Persona("Ana", 1993));
        NodoArbol nieto3 = new NodoArbol(new Persona("Luis", 1995));
        NodoArbol nieto4 = new NodoArbol(new Persona("Sofia", 1997));
        NodoArbol nieto5 = new NodoArbol(new Persona("Martina", 1999));

        NodoArbol bisnieto1 = new NodoArbol(new Persona("Tomas", 2015));
        NodoArbol bisnieto2 = new NodoArbol(new Persona("Juani", 2018));

        abuela.agregarHijo(hijo1);
        abuela.agregarHijo(hijo2);
        abuela.agregarHijo(hijo3);

        hijo1.agregarHijo(nieto1);
        hijo1.agregarHijo(nieto2);
        hijo2.agregarHijo(nieto3);
        hijo2.agregarHijo(nieto4);
        hijo3.agregarHijo(nieto5);

        nieto1.agregarHijo(bisnieto1);
        nieto1.agregarHijo(bisnieto2);

        return new ArbolGenealogico(abuela);
    }

    private static List<String> generarSalida(ArbolGenealogico arbol) {
        List<String> salida = new ArrayList<>();
        salida.add("=== Ejercicio 16 - Arbol genealogico ===");
        salida.add("Descendientes de Tio Carlos: " + personasAString(arbol.listarDescendientes("Tio Carlos")));
        salida.add("Altura del arbol: " + arbol.calcularAltura());
        salida.add("Cantidad total de personas: " + arbol.contarPersonas());
        salida.add("Generacion 0: " + personasAString(arbol.obtenerPersonasGeneracion(0)));
        salida.add("Generacion 1: " + personasAString(arbol.obtenerPersonasGeneracion(1)));
        salida.add("Generacion 2: " + personasAString(arbol.obtenerPersonasGeneracion(2)));
        salida.add("Generacion 3: " + personasAString(arbol.obtenerPersonasGeneracion(3)));

        Persona ancestro1 = arbol.ancestroComunMasCercano("Sofia", "Martina");
        Persona ancestro2 = arbol.ancestroComunMasCercano("Tomas", "Juani");

        salida.add("Ancestro comun (Sofia, Martina): " + (ancestro1 != null ? ancestro1 : "No encontrado"));
        salida.add("Ancestro comun (Tomas, Juani): " + (ancestro2 != null ? ancestro2 : "No encontrado"));
        salida.add("Es Tomas descendiente de Abuela Rosa: " + arbol.esDescendiente("Abuela Rosa", "Tomas"));
        salida.add("Es Tomas descendiente de Tio Carlos: " + arbol.esDescendiente("Tio Carlos", "Tomas"));
        salida.add("Es Sofia descendiente de Tio Carlos: " + arbol.esDescendiente("Tio Carlos", "Sofia"));
        return salida;
    }

    private static String personasAString(List<Persona> personas) {
        if (personas.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < personas.size(); i++) {
            sb.append(personas.get(i).toString());
            if (i < personas.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static void guardarSalida(List<String> lineas) throws IOException {
        Path ruta = Paths.get(RUTA_SALIDA);
        Files.createDirectories(ruta.getParent());
        Files.write(ruta, lineas, StandardCharsets.UTF_8);
    }
}
