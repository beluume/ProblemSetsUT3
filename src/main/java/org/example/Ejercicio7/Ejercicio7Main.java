package org.example.Ejercicio7;

import org.example.Ejercicio7.medicion.MedicionBuscarArrayList;
import org.example.Ejercicio7.medicion.MedicionBuscarHashMap;
import org.example.Ejercicio7.medicion.MedicionBuscarLinkedList;
import org.example.Ejercicio7.medicion.MedicionBuscarTreeMap;
import org.example.Ejercicio7.medicion.MedicionBuscarTrie;
import org.example.Ejercicio7.medicion.MedicionPredecirHashMap;
import org.example.Ejercicio7.medicion.MedicionPredecirLinkedList;
import org.example.Ejercicio7.medicion.MedicionPredecirTrie;
import org.example.medible.lib.Medible;
import org.example.medible.lib.Medicion;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class Ejercicio7Main {

    private static final int REPETICIONES_BUSQUEDA = 20;
    private static final int MEDICIONES_PREDECIR = 20;
    private static final String PREFIJO_PREDECIR = "cas";

    private static final Path OUTPUT_DIR = Path.of("salidas", "Ejercicio7");

    public static void main(String[] args) {
        List<String> palabras = cargarPalabras("listado-general-desordenado.txt");
        List<String> palabrasBuscar = cargarPalabras("listado-general-palabrasBuscar.txt");

        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        SimpleTrie<String> trie = new SimpleTrie<>();
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> treeMap = new TreeMap<>();

        for (String palabra : palabras) {
            linkedList.add(palabra);
            arrayList.add(palabra);
            trie.insertar(palabra, palabra);
            hashMap.put(palabra, palabra);
            treeMap.put(palabra, palabra);
        }

        List<ResultadoMedicion> resultadosBusqueda = medirBusqueda(palabrasBuscar, linkedList, arrayList, trie, hashMap, treeMap);
        List<ResultadoMedicion> resultadosPredecir = medirPredecir(linkedList, trie, hashMap);

        String tablaBusqueda = aTablaMarkdown("Parte 4 - Busqueda 20 veces", resultadosBusqueda);
        String tablaPredecir = aTablaMarkdown("Parte 5 - Predecir prefijo \"" + PREFIJO_PREDECIR + "\"", resultadosPredecir);

        System.out.println(tablaBusqueda);
        System.out.println(tablaPredecir);

        guardarResultados(resultadosBusqueda, resultadosPredecir, tablaBusqueda, tablaPredecir);
    }

    private static List<ResultadoMedicion> medirBusqueda(List<String> palabrasBuscar,
                                                         LinkedList<String> linkedList,
                                                         ArrayList<String> arrayList,
                                                         SimpleTrie<String> trie,
                                                         Map<String, String> hashMap,
                                                         Map<String, String> treeMap) {
        List<Medible<List<String>>> medibles = List.of(
                new MedicionBuscarLinkedList(linkedList),
                new MedicionBuscarArrayList(arrayList),
                new MedicionBuscarTrie(trie),
                new MedicionBuscarHashMap(hashMap),
                new MedicionBuscarTreeMap(treeMap)
        );

        List<ResultadoMedicion> resultados = new ArrayList<>();
        for (Medible<List<String>> medible : medibles) {
            Medicion medicion = medible.medir(REPETICIONES_BUSQUEDA, palabrasBuscar);
            resultados.add(toResultado(medicion));
        }
        return resultados;
    }

    private static List<ResultadoMedicion> medirPredecir(LinkedList<String> linkedList,
                                                         SimpleTrie<String> trie,
                                                         Map<String, String> hashMap) {
        List<Medible<String>> medibles = List.of(
                new MedicionPredecirTrie(trie),
                new MedicionPredecirLinkedList(linkedList),
                new MedicionPredecirHashMap(hashMap)
        );

        List<ResultadoMedicion> resultados = new ArrayList<>();
        for (Medible<String> medible : medibles) {
            long acumuladoNanos = 0;
            long acumuladoMemoria = 0;
            for (int i = 0; i < MEDICIONES_PREDECIR; i++) {
                Medicion medicion = medible.medir(1, PREFIJO_PREDECIR);
                acumuladoNanos += medicion.getTiempoEjecucion();
                acumuladoMemoria += medicion.getMemoria();
            }
            String estructura = medible.getClass().getSimpleName();
            double tiempoPromedioMs = nanosAMilisegundos(acumuladoNanos / MEDICIONES_PREDECIR);
            double memoriaPromedioMb = bytesAMegabytes(acumuladoMemoria / MEDICIONES_PREDECIR);
            resultados.add(new ResultadoMedicion(estructura, memoriaPromedioMb, tiempoPromedioMs));
        }
        return resultados;
    }

    private static ResultadoMedicion toResultado(Medicion medicion) {
        return new ResultadoMedicion(
                medicion.getTexto(),
                bytesAMegabytes(medicion.getMemoria()),
                nanosAMilisegundos(medicion.getTiempoEjecucion())
        );
    }

    private static double bytesAMegabytes(long bytes) {
        return bytes / (1024d * 1024d);
    }

    private static double nanosAMilisegundos(long nanos) {
        return nanos / 1_000_000d;
    }

    private static String aTablaMarkdown(String titulo, List<ResultadoMedicion> resultados) {
        StringBuilder sb = new StringBuilder();
        sb.append("## ").append(titulo).append("\n\n");
        sb.append("| Estructura | Memoria (MB) | Tiempo (ms) |\n");
        sb.append("|---|---:|---:|\n");
        for (ResultadoMedicion resultado : resultados) {
            sb.append("| ")
                    .append(resultado.getEstructura())
                    .append(" | ")
                    .append(formatearDecimal(resultado.getMemoriaMB()))
                    .append(" | ")
                    .append(formatearDecimal(resultado.getTiempoMS()))
                    .append(" |\n");
        }
        return sb.toString();
    }

    private static String aCsv(String titulo, List<ResultadoMedicion> resultados) {
        StringBuilder sb = new StringBuilder();
        sb.append("titulo,estructura,memoria_mb,tiempo_ms\n");
        for (ResultadoMedicion resultado : resultados) {
            sb.append(titulo)
                    .append(",")
                    .append(resultado.getEstructura())
                    .append(",")
                    .append(formatearDecimal(resultado.getMemoriaMB()))
                    .append(",")
                    .append(formatearDecimal(resultado.getTiempoMS()))
                    .append("\n");
        }
        return sb.toString();
    }

    private static String formatearDecimal(double valor) {
        return String.format(Locale.US, "%.6f", valor);
    }

    private static void guardarResultados(List<ResultadoMedicion> resultadosBusqueda,
                                          List<ResultadoMedicion> resultadosPredecir,
                                          String tablaBusqueda,
                                          String tablaPredecir) {
        try {
            Files.createDirectories(OUTPUT_DIR);
            Files.writeString(
                    OUTPUT_DIR.resolve("resultados_busqueda.csv"),
                    aCsv("parte4_busqueda", resultadosBusqueda),
                    StandardCharsets.UTF_8
            );
            Files.writeString(
                    OUTPUT_DIR.resolve("resultados_predecir.csv"),
                    aCsv("parte5_predecir", resultadosPredecir),
                    StandardCharsets.UTF_8
            );
            Files.writeString(
                    OUTPUT_DIR.resolve("resultados_consolidados.md"),
                    tablaBusqueda + "\n\n" + tablaPredecir,
                    StandardCharsets.UTF_8
            );
        } catch (IOException e) {
            throw new IllegalStateException("No fue posible guardar los resultados del Ejercicio 7.", e);
        }
    }

    private static List<String> cargarPalabras(String nombreArchivo) {
        Path path = resolverRutaEntrada(nombreArchivo);
        try {
            List<String> lineas = Files.readAllLines(path, StandardCharsets.UTF_8);
            List<String> palabras = new ArrayList<>();
            for (String linea : lineas) {
                String limpia = linea.trim().toLowerCase(Locale.ROOT);
                if (!limpia.isEmpty()) {
                    palabras.add(limpia);
                }
            }
            return palabras;
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo leer el archivo de entrada: " + path, e);
        }
    }

    private static Path resolverRutaEntrada(String nombreArchivo) {
        List<Path> candidatas = List.of(
                Path.of("src", "main", "resources", "Ejercicio7", nombreArchivo),
                Path.of("ut03", nombreArchivo),
                Path.of(nombreArchivo)
        );
        for (Path candidata : candidatas) {
            if (Files.exists(candidata)) {
                return candidata;
            }
        }
        throw new IllegalStateException(
                "No se encontro " + nombreArchivo + ". Ubicalo en src/main/resources/Ejercicio7 o en ut03/."
        );
    }
}
