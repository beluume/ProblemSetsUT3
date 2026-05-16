package Ejercicio15;

import java.util.Objects;

public class Libro {

    public String isbn;
    public String titulo;
    public String autor;
    public int anio;

    public Libro(String isbn, String titulo, String autor, int anio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    public String getIsbn() {
        return isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public int getAnio() {
        return anio;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public boolean equals(Object o) {
       if (this == o) return true;
       if (!(o instanceof Libro)) return false;
       Libro libro = (Libro) o;
       return this.getIsbn().equals(libro.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
