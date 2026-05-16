## Ejercicio15

Se desea utilizar objetos de tipo Libro dentro de estructuras basadas en hashing, como HashSet
y HashMap.
Se pide:

1. Definir cuál o cuáles atributos deberían determinar la identidad lógica de un libro. Justificar
   la respuesta.
2. Implementar los métodos equals y hashCode respetando el contrato general de Java.
3. Explicar qué error conceptual aparece si equals compara libros usando isbn, pero hashCode
   se calcula usando titulo.
4. Construir un ejemplo en el que dos objetos Libro distintos representen el mismo libro y
   sean insertados en un HashSet.
5. Explicar qué debería ocurrir en ese HashSet si equals y hashCode están correctamente
   implementados.
6. Proponer casos de prueba para verificar que la implementación cumple el contrato de
   equals y hashCode.


1.  Por el ISBN. Es un identificador unico en los libros. Dos libros con el mismo ISBN representan la misma edicion del
del mismo libro.
El titulo, autor o año se opueden repertir en diferentes libros.
2. Implementacion en clase "Libros"
3. Se rompería el "contrato de Java". Si, segun el metodo equals, dos objetos son iguales, deben de tener el mismo 
hasCode.
Dos libros con el mismo ISBN pero diferente titulo generaria codigo hash diferentes.
Como resultado da un comportamiento incorrecto e inconsistente
4. Implementado en "Main"
5. Si hashCode e equals utilizan correctamente el ISBN a compararlos daria el resultado de true, ambos tendrian el mismo
hashCode y el HashSet detectaria los duplicados. Solo se almacenaria un libro.
6. Implementado en carpeta "Ejercicio15"