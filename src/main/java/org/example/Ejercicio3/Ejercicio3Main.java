package org.example.Ejercicio3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio3Main {

    private static final String RUTA_SALIDA = "salidas\\Ejercicio3\\resultado_casos_prueba.txt";

    public static void main(String[] args) throws IOException {
        TrieIndice trie = new TrieIndice();
        cargarDatosDemo(trie);

        List<String> resultados = ejecutarCasosPrueba(trie);
        guardarResultados(resultados);

        for (String linea : resultados) {
            System.out.println(linea);
        }
        System.out.println("Salida guardada en: " + RUTA_SALIDA);
    }

    private static void cargarDatosDemo(TrieIndice trie) {
        trie.insertar("Casa", "texto1.txt:1");
        trie.insertar("Casa", "texto1.txt:8");
        trie.insertar("Casamiento", "texto2.txt:4");
        trie.insertar("Caso", "texto3.txt:7");
        trie.insertar("Perro", "texto1.txt:3");
        trie.insertar("Programa", "texto4.txt:2");
    }

    private static List<String> ejecutarCasosPrueba(TrieIndice trie) {
        List<String> salida = new ArrayList<>();
        salida.add("=== Ejercicio 3 - Casos de prueba ===");
        salida.add("Caso 1 - buscar palabra existente (casa)");
        salida.add("Esperado: [texto1.txt:1, texto1.txt:8]");
        salida.add("Obtenido: " + trie.buscar("casa"));
        salida.add("Resultado: " + (trie.buscar("casa").size() == 2 ? "OK" : "ERROR"));
        salida.add("");

        salida.add("Caso 2 - buscar palabra existente con una ocurrencia (caso)");
        salida.add("Esperado: [texto3.txt:7]");
        salida.add("Obtenido: " + trie.buscar("caso"));
        salida.add("Resultado: " + (trie.buscar("caso").size() == 1 ? "OK" : "ERROR"));
        salida.add("");

        salida.add("Caso 3 - buscar palabra inexistente (gato)");
        salida.add("Esperado: []");
        salida.add("Obtenido: " + trie.buscar("gato"));
        salida.add("Resultado: " + (trie.buscar("gato").isEmpty() ? "OK" : "ERROR"));
        salida.add("");

        salida.add("Caso 4 - insertar una palabra nueva");
        boolean insertoNueva = trie.insertar("Gato", "texto9.txt:1");
        salida.add("Esperado: true");
        salida.add("Obtenido: " + insertoNueva);
        salida.add("Resultado: " + (insertoNueva ? "OK" : "ERROR"));
        salida.add("");

        salida.add("Caso 5 - insertar palabra repetida (agrega ocurrencia)");
        boolean insertoRepetida = trie.insertar("Gato", "texto9.txt:5");
        int ocurrenciasGato = trie.buscar("gato").size();
        salida.add("Esperado: insertar=false y ocurrencias=2");
        salida.add("Obtenido: insertar=" + insertoRepetida + ", ocurrencias=" + ocurrenciasGato);
        salida.add("Resultado: " + (!insertoRepetida && ocurrenciasGato == 2 ? "OK" : "ERROR"));
        return salida;
    }

    private static void guardarResultados(List<String> lineas) throws IOException {
        Path ruta = Paths.get(RUTA_SALIDA);
        Files.createDirectories(ruta.getParent());
        Files.write(ruta, lineas, StandardCharsets.UTF_8);
    }
}
