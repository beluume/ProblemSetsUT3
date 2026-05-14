Ejercicio 5
-
Describir en lenguaje natural, pre y post condiciones, seudocódigo de las operaciones y análisis
de ordenes de las siguientes operaciones del Trie y NodoTrie:


1. Operación buscar palabra completa.

Lenguaje natural:

Para buscar la palabra completa en un Trie, se inicia desde la raíz y se recorre cada caractér de la palabra. Si en algun caso, el hijo no existe, la pablabra no está en el Trie. 
En caso de que se pueda recorrer toda la palabra, hay que verificar que el último nodo esté marcado como el fin de la palabra.

Precondiciones:
* El trie quedó bien armado

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
* El trie quedó bien armado
* El prefijo dado no es null

Postcondiciones:
* Devuelve una lista con todas las palabras que inician con ese prefijo
* Si no hya palabras, devuelve una lista vacía

Seudocódigo:

Análisis de orden:

3. Insertar una palabra con un dato asociado.

Lenguaje natural:

Para insertar una palabra, se inicia desde la raiz y se recorre cada caractér. Si el hijo que corresponde a un caracter no existe, se crea un nuevo nodo.
Despues avanza al nodo hijo. Una vez que termina la palabra, se marca el último nodo como el fin de la palabra y se guarda el dato. 

Precondiciones:
* La palabra dada no es null

Postcondiciones:
* La palabra queda guardada en el Trie
* El último nodo queda marcado como fin de palabra

Seudocódigo:

Análisis de orden:

4. Eliminar una palabra del Trie.

Lenguaje natural:

Para eliminar una palabra primero se debe buscar el camino completo. Si la palabra no existe, no se elimina nada. 
Si existe, se le saca la marca al último nodo y se elimina el dato. 

Precondiciones:
* La palabra no puede ser null
* La palabra puede o no existir en el Trie

Postcondiciones:
* Si algunos nodos quedan sin uso se eliminan

Seudocódigo:

Análisis de orden: