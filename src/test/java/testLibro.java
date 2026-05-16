package Ejercicio15;

import org.junit.jupiter.api.Test;

public class testLibro {

    @Test
    public void testIsbnConEquals() {

        Libro libro1 = new Libro("1234567", "Pateando Lunas", "Roy Berocay", 1992);
        Libro libro2 = new Libro("1234567", "La felicidad", "Gabriel Rolon", 2005);

        assertEquals(libro1, libro2);
    }

    public void testIsbnConHashCode() {

        Libro libro1 = new Libro("1234567", "Pateando Lunas", "Roy Berocay", 1992);
        Libro libro2 = new Libro("1234567", "La felicidad", "Gabriel Rolon", 2005);

        assertEquals(libro1.hashCode(), libro2.hashCode());
    }

    @Test
    public void testLibroConDistintoIsbn() {

        Libro libro1 = new Libro("1234567", "Pateando Lunas", "Roy Berocay", 1992);
        Libro libro2 = new Libro("89101112", "La felicidad", "Gabriel Rolon", 2005);

        assertNotEquals(libro1, libro2);
    }

}
