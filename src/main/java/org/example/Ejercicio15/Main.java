package Ejercicio15;

import java.util.HashSet;

public class Main {


    public static void main(String[] args) {


        Libro libro1 = new Libro(
                "1234567",
                "Pateando Lunas",
                "Roy Berocay",
                1992
        );

        Libro libro2 = new Libro(
                "1234567",  // mismo ISBN
                "La felicidad",
                "Gabriel Rolon",
                2005
        );

        HashSet<Libro> libros = new HashSet<>();

        libros.add(libro1);
        libros.add(libro2);

        System.out.println("Cantidad de libros: " + libros.size());
    }

}