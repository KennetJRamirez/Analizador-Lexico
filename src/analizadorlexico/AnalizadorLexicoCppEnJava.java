
package analizadorlexico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Joab Ramirez
 * 7690-21-2903
 */
public class AnalizadorLexicoCppEnJava {
  // Clase interna para representar los tipos de tokens
    public enum TipoToken {
        PALABRA_RESERVADA, IDENTIFICADOR, NUMERO_ENTERO, NUMERO_DECIMAL, CADENA, CARACTER,
        COMENTARIO, FIN_DE_LINEA, DELIMITADOR, OPERADOR, OTRO
    }

    public static class Token {

        public final TipoToken tipo;
        public final String lexema;

        // Constructor
        public Token(TipoToken tipo, String lexema) {
            this.tipo = tipo;
            this.lexema = lexema;
        }
    }

    // Método para analizar el código fuente y devolver un arreglo de tokens
    public static Token[] analizarCodigo(String codigo) {
        List<Token> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile(
                "(int|double|float|char|void|if|else|while|for|do|switch|case|break|continue|return|include)|[a-zA-Z_][a-zA-Z0-9_]*|\\d+(\\.\\d*)?|\"[^\"]*\"|'.'|(//.*|/\\*.*?\\*/)|([(){}\\[\\],;])|([#<>=!&|+\\-*/%=])|\\s");
        Matcher matcher = pattern.matcher(codigo);

        // Iterar sobre los tokens encontrados
        while (matcher.find()) {
            String token = matcher.group();
            TipoToken tipo = TipoToken.OTRO;

            // Determinar el tipo de token
            if (token.matches(
                    "int|double|float|char|void|if|else|while|for|do|switch|case|break|continue|return|include"))
                tipo = TipoToken.PALABRA_RESERVADA;
            else if (token.matches("[a-zA-Z_][a-zA-Z0-9_]*"))
                tipo = TipoToken.IDENTIFICADOR;
            else if (token.matches("\\d+(\\.\\d*)?"))
                tipo = token.contains(".") ? TipoToken.NUMERO_DECIMAL : TipoToken.NUMERO_ENTERO;
            else if (token.matches("\"[^\"]*\""))
                tipo = TipoToken.CADENA;
            else if (token.matches("'.'"))
                tipo = TipoToken.CARACTER;
            else if (token.matches("//.*|/\\*.*?\\*/"))
                tipo = TipoToken.COMENTARIO;
            else if (token.equals("\n"))
                tipo = TipoToken.FIN_DE_LINEA;
            else if (token.matches("[(){}\\[\\],;]"))
                tipo = TipoToken.DELIMITADOR;
            else if (token.matches("[#<>=!&|+\\-*/%=]"))
                tipo = TipoToken.OPERADOR;
            else if (token.matches("\\s"))
                continue;

            // Agregar el token a la lista
            tokens.add(new Token(tipo, token));
        }

        // Devolver el arreglo de tokens
        return tokens.toArray(new Token[0]);
    }

    // Método para analizar un archivo y devolver un arreglo de tokens
    public static Token[] analizarArchivo(String nombreArchivo) throws IOException {
        StringBuilder sb = new StringBuilder();
        String linea;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            while ((linea = br.readLine()) != null) {
                sb.append(linea).append(System.lineSeparator());
            }
        }

        // Devolver el arreglo de tokens
        return analizarCodigo(sb.toString());
    }

    public static void main(String[] args) {
        // Nombre del archivo a analizar
        String nombreArchivo = "src//analizadorlexico//main.cpp";

        try {
            // Analizar el archivo
            Token[] tokens = analizarArchivo(nombreArchivo);

            // Imprimir los tokens encontrados
            for (Token token : tokens) {
                System.out.println("lexema: " + token.lexema + "\ttoken: " + token.tipo);
            }
        } catch (IOException e) {
            // Imprimir el error
            System.err.println("Error al leer el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }
}
