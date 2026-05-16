package Ejercicio13;
import java.util.Objects;

public class Alumno {

    private int Id;
    private String nombreCompleto;
    private String email;

    public Alumno(int Id, String nombreCompleto, String email) {
        this.Id = Id;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setId(int Id) {
        this.Id = Id;
    }

    public String getEmail() {
        return email;
    }


    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        Alumno alumno = (Alumno) o;
        return this.Id == alumno.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}

