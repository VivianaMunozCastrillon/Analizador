package main;

import java.io.IOException;
import analizadorLexico.*;

public class Main {
    public static void main(String[] args) throws IOException {
        AnalizadorLexico lex = new AnalizadorLexico();
        
        // Bucle para leer continuamente tokens hasta que se alcance el final del archivo
        while (true) {
            Token token = lex.explorar();
            
            // Si el token es null, significa que se ha alcanzado el final del archivo
            if (token == null) {
                System.out.println("Fin del archivo.");
                break; // Salir del bucle
            }
            
            // Obtener la etiqueta asociada al token
            String etiqueta = obtenerEtiqueta(token);
            
            // Imprimir el token junto con su etiqueta
            System.out.print(token);
            if (!etiqueta.equals("Desconocido")) {
                System.out.println(" - Etiqueta: " + etiqueta);
            } else {
                System.out.println(" - Etiqueta: Desconocido - Valor ASCII: " + token.etiqueta);
            }
        }
    }
    
    // Método para obtener la etiqueta asociada a un token
    private static String obtenerEtiqueta(Token token) {
        switch (token.etiqueta) {
            case Etiqueta.AND:
                return "AND";
            case Etiqueta.BASIC:
                return "BASIC";
            case Etiqueta.BREAK:
                return "BREAK";
            case Etiqueta.DO:
                return "DO";
            case Etiqueta.ELSE:
                return "ELSE";
            case Etiqueta.EQ:
                return "EQ";
            case Etiqueta.FALSE:
                return "FALSE";
            case Etiqueta.GE:
                return "GE";
            case Etiqueta.ID:
                return "ID";
            case Etiqueta.IF:
                return "IF";
            case Etiqueta.INDEX:
                return "INDEX";
            case Etiqueta.LE:
                return "LE";
            case Etiqueta.MINUS:
                return "MINUS";
            case Etiqueta.NE:
                return "NE";
            case Etiqueta.NUM:
                return "NUM";
            case Etiqueta.OR:
                return "OR";
            case Etiqueta.REAL:
                return "REAL";
            case Etiqueta.TEMP:
                return "TEMP";
            case Etiqueta.TRUE:
                return "TRUE";
            case Etiqueta.WHILE:
                return "WHILE";
            default:
                return "Desconocido";
        }
    }
}






