Ejercicio 5
-
Describir en lenguaje natural, pre y post condiciones, seudocódigo de las operaciones y análisis
de ordenes de las siguientes operaciones del Trie y NodoTrie:


1. Operación buscar palabra completa.

Lenguaje natural:

Para buscar la palabra completa en un Trie, se inicia desde la raíz y se recorre cada caractér de la palabra. Si en algun caso, el hijo no existe, la pablabra no está en el Trie. 
En caso de que se pueda recorrer toda la palabra, hay que verificar que el último nodo esté marcado como el fin de la palabra.

Precondiciones:
* El trie qudó bien armado

Postcondiciones:
* Si la palabra existe devuelve verdadero
* Si la palabra no existe devuelve falso

Seudocódigo:

Análisis de orden:




2. Obtener la lista de palabras por un prefijo dado.

Lenguaje natural:

Para buscar todas las palabras que inician con un prefijo dado, primero se recorre el Trie siguiendo cada uno de los caracteres. 
Si no existe camino en alguna parte, entonces no hay palabras con ese prefijo dado. 
Si se llega al nodo final, se recorren todos los subárboles y se van contando las palabras marcadas como completas.

Precondiciones:
* El trie qudó bien armado
* El prefijo dado no es null

Postcondiciones:
*

3. Insertar una palabra con un dato asociado.
4. Eliminar una palabra del Trie.