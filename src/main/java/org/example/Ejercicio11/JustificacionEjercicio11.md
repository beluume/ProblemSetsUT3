Ejercicio 11
-
La estructura utilizada para este problema es HashMap <String, Integer> ya que

La consigna pide leer un libro, palabra por palabra y contar cuantas veces aparece cada una.
Cada vez que se encuentra una palabra, se debe verificar si ya aparecio antes, si es así se le suma 1 al contador.
Como hay millones de palabras, el HashMap permite hacerlo de manera instantánea.
Si lo hicieramos con una lista, cada vez que se encuentra la palabra habria que volver a recorrer toda la lista para verificar si ya está.

Resolución del ejercicio:
Se lee el archivo libro.txt palabr apor palabra con el scanner.
Cada palabra se pasa a minuscula y se eliminan puntos y comas. Despues se guarda en un HashMap.
Si la palabra exisye, se obtiene la cantidad actual y se suma 1, si no existe se agrega con valor 1.

Analisis orden:
El programa recorre cada palabra una vez sola, por lo que si sería O(x), siendo x la cantidad de palabras del archivo
