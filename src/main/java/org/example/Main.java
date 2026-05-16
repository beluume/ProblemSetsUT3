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

}
