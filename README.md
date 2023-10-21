# Proyecto Analizador Lexico Para C++
### **Es una app en consola en la cual se define una ruta a un programa hecho en C++**
### **Este programa no usa librerias o aplicaciones externas como JFLEX, etc. Debido a que la mayoria de casos se manejaran por expresiones regulares y una clase enum que contendra cada token propio de c++, como lo son reservadas, ids,operadores, etc**
### 1. Creada con [Java](https://www.java.com/es/download/ie_manual.jsp) en su version 8 (1.8).

## :space_invader: Set Up
### Editar en su main la ruta hacia el archivo C++
```
String nombreArchivo = "tu/ruta/archivo.cpp";
```
### Y como paso final, correr la aplicacion , con eso ya funcionaria sin problemas
## :hammer_and_wrench:	Construido con
- Java

## 💻 Autor
- Kennet Joab Guzman Ramirez
- 7690-21-2903
- Universidad Mariano Galvez


# Analizador Léxico en Java 🖥️:

Este programa es un analizador léxico escrito en Java que analiza un código fuente en busca de tokens. Un token es una unidad léxica en un lenguaje de programación, como palabras reservadas, identificadores, números, cadenas, caracteres, comentarios, operadores, delimitadores, entre otros.

## Clases y Enumeraciones

El programa utiliza las siguientes clases y enumeraciones:

- `AnalizadorLexico`: La clase principal que contiene los métodos para analizar el código fuente y el archivo.
- `TipoToken`: Una enumeración que representa los tipos de tokens posibles, como palabras reservadas, identificadores, números, etc.
- `Token`: Una clase que representa un token con un tipo y un lexema.

## Método `analizarCodigo`

El método `analizarCodigo` toma una cadena de código fuente como entrada y devuelve un arreglo de tokens. Realiza lo siguiente:

- Define un patrón de expresión regular que coincide con diferentes tipos de tokens, como palabras reservadas, identificadores, números, cadenas, caracteres, comentarios, operadores, delimitadores y espacios en blanco.
- Utiliza un `Matcher` para encontrar coincidencias del patrón en el código fuente.
- Itera sobre las coincidencias y determina el tipo de token de acuerdo con las reglas definidas.
- Agrega cada token a una lista.
- Devuelve la lista de tokens como un arreglo.

## Método `analizarArchivo`

El método `analizarArchivo` toma el nombre de un archivo como entrada, lee el contenido del archivo y llama al método `analizarCodigo` para analizar el código fuente del archivo. Devuelve un arreglo de tokens.

## Método `main`

El método `main` es el punto de entrada del programa. Aquí se especifica el nombre del archivo que se va a analizar. Luego, llama a `analizarArchivo` y muestra los tokens encontrados en la salida estándar.

## Uso

Para usar este programa, simplemente ejecute la clase `AnalizadorLexico` y especifique el nombre del archivo que desea analizar. Los tokens encontrados se imprimirán en la consola.

## Limitaciones

Este analizador léxico es una implementación simplificada y puede no manejar todos los detalles de un lenguaje de programación completo. 

