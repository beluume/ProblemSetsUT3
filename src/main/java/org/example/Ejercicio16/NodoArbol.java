public class NodoArbol {
    Persona persona;
    NodoArbol[] hijos;
    int cantHijos;

    public NodoArbol(Persona persona) {
        this.persona = persona;
        this.hijos = new NodoArbol[10];
        this.cantHijos = 0;
    }

    public void agregarHijo(NodoArbol hijo) {
        this.hijos[cantHijos] = hijo;
        cantHijos++;
    }
}