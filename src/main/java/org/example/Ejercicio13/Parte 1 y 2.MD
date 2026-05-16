## Ejercicio13 - Parte1

La funcion que tiene el metodo hashCode() es la de devolver un numero entero que represente al objeto.

La implementación de hashCode en Object genera un numero entero basado en la ubicacion del objeto en la memoria, no tomando
el contenido del objeto en si (Depende de la JVM - Java Virtual Machine).
Si por ejemplo tenemos dos objetos  [ persona1  = new Object () y persona2  = new Object () ] por más que sean identicos
y tengan los mismos datos van a tener codigos distintos ya que están ubicados en lugares diferentes en la memoria


En el caso de Interger es diferente. El hashCode de un Interger es el valor que contiene. Por ejemplo
Si tenemos un Integer valor 23 su hashCode va a ser 23.

En el caso de objeto String el metodo usa una formula matematica que recorre cada caracter de la cadena; de cada valor 
toma el valor numerico del caracter en la tabla ASCII; a ese valor se lo multiplica por 31 elevado a la cantidad de 
letras - el valor donde esta ubicada la letra, y luego cada valor los va sumando. Luego los multiplica por el 31. 
Si en dos String, la cadena de texto tiene lo mismo el valor del hashCode va a ser el mismo sin importan en qué parte de
la memoria estén ubicados.

- https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#hashCode--
- https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html#hashCode--
- https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#hashCode--

## Ejercicio13 - Parte2

Tenemos cuatro String. Si queremos tener un factor de sobrecarga del 90% lo ideal seria tener un arreglo de tamaño 7

7 x 0,9 = 6,3 (Puede albergar 6 elementos este arreglo)


### Arreglo (tamaño 7):

[0] - [1] - [2] - [3] - [4] - [5] - [6]

### Palabras:
- Hola
- HolaMundo
- HashMap
- Colecciones

Primero lo que tenemos que ver en cada palabra es el valor de la tabla ASCII de cada caracter y sumarlos


- Hola - [H = 72, o = 111, l = 108, a = 97]
- HolaMundo -  [H = 72, o = 111, l = 108, a = 97, M = 77, u = 117, n = 110, d = 100, o = 111]
- HashMap - [H = 72, a = 97, s = 115, h = 104, M = 77, a = 97, p = 112]
- Colecciones - [C = 67, o = 111, l = 108 , e = 101, c = 99, c = 99, i = 105, o = 111, n = 110 , e = 101, s = 115]

Valor palabra "Hola" = [72 x 31^(4-1)] + [111 x 31^(4-2)] + [108 x 31^(4-3)] + [97 x 31^(4-4)] = 2255068

Valor palabra "HolaMundo" = [72 x 31^(9-1)] + [111 x 31^(9-2)] + [108 x 31^(9-3)] + [97 x 31^(9-4)] + [77 x 31^(9-5)] + 
[117 x 31^(9-6)] + [110 x 31^(9-7)] + [100 x 31^(9-8)] + [111 x 31^(9-9)] = -1191400619 (overflow o desborde de int)

Valor palabra "HashMap" = [72 x 31^(7-1)] + [97 x 31^(7-2)] + [115 x 31^(7-3)] + [104 x 31^(7-4)] + [77 x 31^(7-5)] + 
[97 x 31^(7-6)] + [112 x 31^(7-7)] = -1932803762 (overflow o desborde de int)
 
Valor palabra "Colecciones"= [67 x 31^(11-1)] + [111 x 31^(11-2)] + [108 x 31^(11-3)] + [101 x 31^(11-4)] + 
[99 x 31^(11-5)] + [99 x 31^(11-6)] + [105 x 31^(11-7)] + [111 x 31^(11-8)] + [110 x 31^(11-9)] + [101 x 31^(11-10)] + 
[115 x 31^(11-11)] = -1872965711 (overflow o desborde de int)


- Hola: 2255068 (Mod 7) = 4
- HolaMundo: 1191400619 (Mod 7) = 3
- HashMap: 1932803762 (Mod 7) = 1
- Colecciones: 1872965711 (Mod 7) = 1

[0] - [1] - [2] - [3] - [4] - [5] - [6]

- [0] = null
- [1] = ["HashMap"] - ["Colecciones"]
- [2] = null
- [3] = "HolaMundo"
- [4] = "Hola"
- [5] = null
- [6] = null

## A tener en cuenta.

En el ejercicio lo que hicimos fue, de los valores negativos tomar el valor absoluto de los mismos.

Java lo que hace con un valor negativo es hacer un AND a nivel de bits con el número 0x7FFFFFFF (que representa el 
número máximo entero positivo en hexadecimal). Esta operación lo que hace es "apagar" el bit de signo negativo 
(fuerza a que el primer bit sea 0 - positivo en vez de 1 - negativo) y lo transforma en un número positivo de forma 
directa, evitando los problemas de desbordamiento propios de la representación en complemento a dos.