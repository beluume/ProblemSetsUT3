package org.example.Ejercicio9;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

public class Ejercicio9Main {

    private static final int CAPACIDAD_TABLA = 1009;
    private static final int[] FACTORES_CARGA = {70, 75, 80, 85, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};

    private static final String RUTA_CSV = "salidas\\Ejercicio9\\resultados_factor_carga.csv";
    private static final String RUTA_TXT = "salidas\\Ejercicio9\\resultados_factor_carga.txt";

    public static void main(String[] args) throws IOException {
        int maxClaves = (CAPACIDAD_TABLA * 99) / 100;
        List<Integer> clavesInsertables = generarClavesUnicas(maxClaves, 2026);
        List<Integer> clavesNoExistentes = generarClavesNoExistentes(clavesInsertables);

        List<ResultadoFactorCarga> resultados = medirRendimiento(clavesInsertables, clavesNoExistentes);
        guardarResultados(resultados);

        System.out.println(generarTabla(resultados));
        System.out.println("Salidas guardadas en:");
        System.out.println(" - " + RUTA_CSV);
        System.out.println(" - " + RUTA_TXT);
    }

    private static List<ResultadoFactorCarga> medirRendimiento(
            List<Integer> clavesInsertables,
            List<Integer> clavesNoExistentes
    ) {
        List<ResultadoFactorCarga> resultados = new ArrayList<>();

        for (int factorCarga : FACTORES_CARGA) {
            int cantidad = (CAPACIDAD_TABLA * factorCarga) / 100;
            TablaHashLineal tabla = new TablaHashLineal(CAPACIDAD_TABLA);

            long comparacionesInsercion = 0;
            for (int i = 0; i < cantidad; i++) {
                ResultadoOperacionHash resultado = tabla.insertar(clavesInsertables.get(i));
                comparacionesInsercion += resultado.getComparaciones();
            }

            long comparacionesBusquedaExitosa = 0;
            for (int i = 0; i < cantidad; i++) {
                ResultadoOperacionHash resultado = tabla.buscar(clavesInsertables.get(i));
                comparacionesBusquedaExitosa += resultado.getComparaciones();
            }

            long comparacionesBusquedaSinExito = 0;
            for (int i = 0; i < cantidad; i++) {
                ResultadoOperacionHash resultado = tabla.buscar(clavesNoExistentes.get(i));
                comparacionesBusquedaSinExito += resultado.getComparaciones();
            }

            resultados.add(
                    new ResultadoFactorCarga(
                            factorCarga,
                            (double) comparacionesInsercion / cantidad,
                            (double) comparacionesBusquedaExitosa / cantidad,
                            (double) comparacionesBusquedaSinExito / cantidad
                    )
            );
        }
        return resultados;
    }

    private static List<Integer> generarClavesUnicas(int cantidad, int semilla) {
        Random random = new Random(semilla);
        Set<Integer> usadas = new HashSet<>();
        List<Integer> claves = new ArrayList<>();

        while (claves.size() < cantidad) {
            int clave = 100_000 + random.nextInt(9_000_000);
            if (usadas.add(clave)) {
                claves.add(clave);
            }
        }
        return claves;
    }

    private static List<Integer> generarClavesNoExistentes(List<Integer> clavesInsertables) {
        List<Integer> clavesNoExistentes = new ArrayList<>();
        for (Integer clave : clavesInsertables) {
            clavesNoExistentes.add(clave + 10_000_000);
        }
        return clavesNoExistentes;
    }

    private static void guardarResultados(List<ResultadoFactorCarga> resultados) throws IOException {
        Path rutaCsv = Paths.get(RUTA_CSV);
        Path rutaTxt = Paths.get(RUTA_TXT);
        Files.createDirectories(rutaCsv.getParent());

        Files.write(rutaCsv, generarCSV(resultados).getBytes(StandardCharsets.UTF_8));
        Files.write(rutaTxt, generarReporteTexto(resultados).getBytes(StandardCharsets.UTF_8));
    }

    private static String generarCSV(List<ResultadoFactorCarga> resultados) {
        StringBuilder sb = new StringBuilder();
        sb.append("Factor de carga (%),Prom. Comp. Insercion,Prom. Comp. Busqueda exitosa,Prom. Comp. Busqueda sin exito\n");
        for (ResultadoFactorCarga resultado : resultados) {
            sb.append(resultado.getFactorCargaPorcentaje()).append(",")
                    .append(formatear(resultado.getPromedioInsercion())).append(",")
                    .append(formatear(resultado.getPromedioBusquedaExitosa())).append(",")
                    .append(formatear(resultado.getPromedioBusquedaSinExito())).append("\n");
        }
        return sb.toString();
    }

    private static String generarTabla(List<ResultadoFactorCarga> resultados) {
        StringBuilder sb = new StringBuilder();
        sb.append("| Factor carga % | Prom. comp. insercion | Prom. comp. busqueda exitosa | Prom. comp. busqueda sin exito |\n");
        sb.append("|---|---:|---:|---:|\n");
        for (ResultadoFactorCarga resultado : resultados) {
            sb.append("| ").append(resultado.getFactorCargaPorcentaje()).append(" | ")
                    .append(formatear(resultado.getPromedioInsercion())).append(" | ")
                    .append(formatear(resultado.getPromedioBusquedaExitosa())).append(" | ")
                    .append(formatear(resultado.getPromedioBusquedaSinExito())).append(" |\n");
        }
        return sb.toString();
    }

    private static String generarReporteTexto(List<ResultadoFactorCarga> resultados) {
        StringBuilder sb = new StringBuilder();
        sb.append("Ejercicio 9 - Evolucion del rendimiento de tabla hash\n\n");
        sb.append("Tabla usada: direccionamiento abierto con sondeo lineal\n");
        sb.append("Capacidad fija: ").append(CAPACIDAD_TABLA).append("\n");
        sb.append("Se inserta desde 70% hasta 99% de factor de carga.\n\n");
        sb.append(generarTabla(resultados)).append("\n");

        sb.append("Comentario teorico:\n");
        sb.append("Cuando el factor de carga sube, tambien suben las comparaciones promedio.\n");
        sb.append("El aumento es mas fuerte en busquedas sin exito, porque hay que recorrer mas posiciones antes de encontrar un lote vacio.\n");
        sb.append("Esto coincide con lo visto en teoria para direccionamiento abierto lineal.\n");
        return sb.toString();
    }

    private static String formatear(double valor) {
        DecimalFormat formato = new DecimalFormat("0.000", DecimalFormatSymbols.getInstance(Locale.US));
        return formato.format(valor);
    }
}
