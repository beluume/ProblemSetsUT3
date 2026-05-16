package org.example;
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        IO.println(String.format("Hello and welcome!"));

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            IO.println("i = " + i);
        }
    }

    // EJERCICIO 12 
    
/*
    public static void main(String[] args) {

        TTrieHashMap triePalabras = new TTrieHashMap();

        triePalabras.insertar("casa");
        triePalabras.insertar("casamiento");
        triePalabras.insertar("casilla");
        triePalabras.insertar("casino");
        triePalabras.insertar("casco");
        triePalabras.insertar("caso");
        triePalabras.insertar("perro");
        triePalabras.insertar("perra");
        triePalabras.insertar("persona");
        triePalabras.insertar("pelo");
        triePalabras.insertar("peligro");
        triePalabras.insertar("sol");
        triePalabras.insertar("sola");
        triePalabras.insertar("solar");

        System.out.println("Busqueda exacta");
        System.out.println("Existe casa: " + triePalabras.buscar("casa"));
        System.out.println("Existe cas: " + triePalabras.buscar("cas"));
        System.out.println("Existe casino: " + triePalabras.buscar("casino"));
        System.out.println("Existe perrito: " + triePalabras.buscar("perrito"));

        System.out.println("\nBusqueda de prefijo");
        System.out.println("Hay palabras con cas: " + triePalabras.buscarPrefijo("cas"));
        System.out.println("Hay palabras con xyz: " + triePalabras.buscarPrefijo("xyz"));

        System.out.println("\nAutocompletar con prefijo cas");
        ArrayList<String> sugerencias1 = triePalabras.autocompletar("cas");
        for (String s : sugerencias1) {
            System.out.println(s);
        }

        System.out.println("\nAutocompletar con prefijo pe");
        ArrayList<String> sugerencias2 = triePalabras.autocompletar("pe");
        for (String s : sugerencias2) {
            System.out.println(s);
        }

        System.out.println("\nAutocompletar con prefijo sol");
        ArrayList<String> sugerencias3 = triePalabras.autocompletar("sol");
        for (String s : sugerencias3) {
            System.out.println(s);
        }

        System.out.println("\nAutocompletar con prefijo xyz");
        ArrayList<String> sugerencias4 = triePalabras.autocompletar("xyz");
        if (sugerencias4.isEmpty()) {
            System.out.println("No hay sugerencias");
        }

        String texto = "el perro de ana come con otro perro en el parque del perro";
        System.out.println("\nTexto: " + texto);

        TTrieHashMap triePatrones = new TTrieHashMap();

        ArrayList<Integer> posiciones1 = triePatrones.buscarPatron(texto, "perro");
        System.out.println("Posiciones de perro: " + posiciones1);

        ArrayList<Integer> posiciones2 = triePatrones.buscarPatron(texto, "el");
        System.out.println("Posiciones de el: " + posiciones2);

        ArrayList<Integer> posiciones3 = triePatrones.buscarPatron(texto, "gato");
        if (posiciones3.isEmpty()) {
            System.out.println("gato no fue encontrado");
        }

        String textoCorto = "banana";
        TTrieHashMap trieSufijos = new TTrieHashMap();
        trieSufijos.construirArbolDeSufijos(textoCorto);

        System.out.println("\nArbol de sufijos con texto: " + textoCorto);
        System.out.println("Contiene ana: " + trieSufijos.buscarPatronEnArbol("ana"));
        System.out.println("Contiene nan: " + trieSufijos.buscarPatronEnArbol("nan"));
        System.out.println("Contiene xyz: " + trieSufijos.buscarPatronEnArbol("xyz"));
        System.out.println("Contiene ban: " + trieSufijos.buscarPatronEnArbol("ban"));
    }*/

   //EJERCICIO 16

   /*public class Main {

    public static void main(String[] args) {

        NodoArbol abuela = new NodoArbol(new Persona("Abuela Rosa", 1940));

        NodoArbol hijo1 = new NodoArbol(new Persona("Tio Carlos", 1965));
        NodoArbol hijo2 = new NodoArbol(new Persona("Mama Laura", 1968));
        NodoArbol hijo3 = new NodoArbol(new Persona("Tia Marta", 1972));

        NodoArbol nieto1 = new NodoArbol(new Persona("Pedro",   1990));
        NodoArbol nieto2 = new NodoArbol(new Persona("Ana",     1993));
        NodoArbol nieto3 = new NodoArbol(new Persona("Luis",    1995));
        NodoArbol nieto4 = new NodoArbol(new Persona("Sofia",   1997));
        NodoArbol nieto5 = new NodoArbol(new Persona("Martina", 1999));

        NodoArbol bisnieto1 = new NodoArbol(new Persona("Tomas", 2015));
        NodoArbol bisnieto2 = new NodoArbol(new Persona("Juani", 2018));

        abuela.agregarHijo(hijo1);
        abuela.agregarHijo(hijo2);
        abuela.agregarHijo(hijo3);

        hijo1.agregarHijo(nieto1);
        hijo1.agregarHijo(nieto2);
        hijo2.agregarHijo(nieto3);
        hijo2.agregarHijo(nieto4);
        hijo3.agregarHijo(nieto5);

        nieto1.agregarHijo(bisnieto1);
        nieto1.agregarHijo(bisnieto2);

        ArbolGenealogico arbol = new ArbolGenealogico(abuela);

        System.out.println("Descendientes de Tio Carlos:");
        arbol.listarDescendientes(arbol.raiz, "Tio Carlos");

        System.out.println("\nAltura del arbol: " + arbol.calcularAltura(arbol.raiz));

        System.out.println("\nTotal de personas: " + arbol.contarPersonas(arbol.raiz));

        System.out.println("\nPersonas de la generacion 2:");
        arbol.listarGeneracion(arbol.raiz, 2, 0);

        System.out.println("\nAncestro comun entre Sofia y Martina:");
        NodoArbol ac = arbol.ancestroComun(arbol.raiz, "Sofia", "Martina");
        if (ac != null) {
            System.out.println(ac.persona.nombre);
        }

        System.out.println("\nEs Tomas descendiente de Abuela Rosa: " + arbol.esDescendiente(arbol.raiz, "Abuela Rosa", "Tomas"));
        System.out.println("Es Tomas descendiente de Tio Carlos: " + arbol.esDescendiente(arbol.raiz, "Tio Carlos", "Tomas"));
        System.out.println("Es Sofia descendiente de Tio Carlos: " + arbol.esDescendiente(arbol.raiz, "Tio Carlos", "Sofia"));
    }*/

}
