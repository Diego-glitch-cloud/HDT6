# HDT6
Hoja de trabajo No. 6 - CC2016 – Algoritmos y Estructura de Datos 

Diagrama de secuencia: 
![diagrama_secuencia](https://github.com/user-attachments/assets/e1ff50b5-df82-4bf4-ad39-eb1cd418e7ec)

Explicación de la colección JCF seleccionada para almacenar los pokemon
El motivo por el cual escogí almacenarlos en un TreeSet es por la característica de que el TreeSet es capaz de ordenar los elementos de forma natural dependiendo del método compareTo implementado en los objetos a almacenar (en este caso en la clase Pokemon). Cuando nosotros declaramos el método compareTo, el TreeSet sabe que debe almacenar los datos en orden alfabético del type1, ahorrándonos mucho trabajo y evitando el uso de un algoritmo externo para ordenar los datos. 

El TreeSet se basa en la estructura Set, que evita elementos repetidos, e internamente cuenta con una estructura de arbol rojo-negro, que mantiene las operaciones a un tiempo logarítmico.
![image](https://github.com/user-attachments/assets/38d0415c-e595-4712-a1c7-d4303481061e)

Test Unitarios Superados:

![image](https://github.com/user-attachments/assets/02a0ca90-0c87-4864-94f3-78e7947f1df8)

# Análisis de Complejidad - Operación #4

Análisis de la complejidad para mostrar todos los pokémon ordenados por tipo1 según la implementación del Map utilizada.

## HashMap
**Complejidad: O(n log n)**
- Acceder a los elementos: O(n)
- Convertir a lista para ordenar: O(n)
- Ordenar por tipo: O(n log n) usando Comparator
- *No mantiene orden natural, requiere ordenamiento explícito*

## TreeMap
**Complejidad: O(n)**
- Ya mantiene elementos ordenados por clave (nombre)
- Recorrer todos los elementos: O(n)
- Ordenar por tipo1 requiere conversión a lista: O(n log n)
- *No ordena directamente por tipo1 sino por clave*

## LinkedHashMap
**Complejidad: O(n log n)**
- Mantiene orden de inserción, no ordenamiento natural
- Similar a HashMap, requiere convertir a lista
- Ordenamiento: O(n log n)

## Implementación más eficiente
Usar directamente el TreeSet en PokemonManager es más eficiente (**O(n)**) ya que los elementos ya están ordenados por type1 gracias al método `compareTo` implementado en la clase Pokemon.
