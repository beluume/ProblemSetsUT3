
public class ArbolGenealogico {

    NodoArbol raiz;

    public ArbolGenealogico(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public void listarDescendientes(NodoArbol nodo, String nombreBuscado) {
        if (nodo == null) return;

        if (nodo.persona.nombre.equals(nombreBuscado)) {
            System.out.println("Descendientes de " + nombreBuscado + ":");
            imprimirTodos(nodo);
            return;
        }

        for (int i = 0; i < nodo.cantHijos; i++) {
            listarDescendientes(nodo.hijos[i], nombreBuscado);
        }
    }

    private void imprimirTodos(NodoArbol nodo) {
        for (int i = 0; i < nodo.cantHijos; i++) {
            System.out.println(nodo.hijos[i].persona.nombre);
            imprimirTodos(nodo.hijos[i]);
        }
    }

    public int calcularAltura(NodoArbol nodo) {
        if (nodo == null) return 0;
        if (nodo.cantHijos == 0) return 0;

        int maxAltura = 0;
        for (int i = 0; i < nodo.cantHijos; i++) {
            int altura = calcularAltura(nodo.hijos[i]);
            if (altura > maxAltura) {
                maxAltura = altura;
            }
        }
        return maxAltura + 1;
    }

    public int contarPersonas(NodoArbol nodo) {
        if (nodo == null) return 0;

        int total = 1;
        for (int i = 0; i < nodo.cantHijos; i++) {
            total += contarPersonas(nodo.hijos[i]);
        }
        return total;
    }

    public void listarGeneracion(NodoArbol nodo, int generacionBuscada, int generacionActual) {
        if (nodo == null) return;

        if (generacionActual == generacionBuscada) {
            System.out.println(nodo.persona.nombre + " (" + nodo.persona.anioNacimiento + ")");
            return;
        }

        for (int i = 0; i < nodo.cantHijos; i++) {
            listarGeneracion(nodo.hijos[i], generacionBuscada, generacionActual + 1);
        }
    }

    public NodoArbol ancestroComun(NodoArbol nodo, String nombre1, String nombre2) {
        if (nodo == null) return null;

        if (nodo.persona.nombre.equals(nombre1) || nodo.persona.nombre.equals(nombre2)) {
            return nodo;
        }

        NodoArbol encontrado1 = null;
        NodoArbol encontrado2 = null;

        for (int i = 0; i < nodo.cantHijos; i++) {
            NodoArbol resultado = ancestroComun(nodo.hijos[i], nombre1, nombre2);
            if (resultado != null) {
                if (encontrado1 == null) {
                    encontrado1 = resultado;
                } else {
                    encontrado2 = resultado;
                }
            }
        }

        if (encontrado1 != null && encontrado2 != null) {
            return nodo;
        }

        if (encontrado1 != null) return encontrado1;
        return null;
    }

    public boolean esDescendiente(NodoArbol nodo, String nombreAncestro, String nombreDescendiente) {
        if (nodo == null) return false;

        if (nodo.persona.nombre.equals(nombreAncestro)) {
            return buscarEnSubarbol(nodo, nombreDescendiente);
        }

        for (int i = 0; i < nodo.cantHijos; i++) {
            if (esDescendiente(nodo.hijos[i], nombreAncestro, nombreDescendiente)) {
                return true;
            }
        }
        return false;
    }

    private boolean buscarEnSubarbol(NodoArbol nodo, String nombre) {
        if (nodo == null) return false;

        for (int i = 0; i < nodo.cantHijos; i++) {
            if (nodo.hijos[i].persona.nombre.equals(nombre)) {
                return true;
            }
            if (buscarEnSubarbol(nodo.hijos[i], nombre)) {
                return true;
            }
        }
        return false;
    }
}