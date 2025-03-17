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
