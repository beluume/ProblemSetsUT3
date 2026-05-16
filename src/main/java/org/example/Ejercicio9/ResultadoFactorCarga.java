package org.example.Ejercicio9;

public class ResultadoFactorCarga {
    private final int factorCargaPorcentaje;
    private final double promedioInsercion;
    private final double promedioBusquedaExitosa;
    private final double promedioBusquedaSinExito;

    public ResultadoFactorCarga(
            int factorCargaPorcentaje,
            double promedioInsercion,
            double promedioBusquedaExitosa,
            double promedioBusquedaSinExito
    ) {
        this.factorCargaPorcentaje = factorCargaPorcentaje;
        this.promedioInsercion = promedioInsercion;
        this.promedioBusquedaExitosa = promedioBusquedaExitosa;
        this.promedioBusquedaSinExito = promedioBusquedaSinExito;
    }

    public int getFactorCargaPorcentaje() {
        return factorCargaPorcentaje;
    }

    public double getPromedioInsercion() {
        return promedioInsercion;
    }

    public double getPromedioBusquedaExitosa() {
        return promedioBusquedaExitosa;
    }

    public double getPromedioBusquedaSinExito() {
        return promedioBusquedaSinExito;
    }
}
