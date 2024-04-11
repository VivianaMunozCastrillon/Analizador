package analizadorLexico;
import java.io.*;
import java.util.*;

public class AnalizadorLexico {
    public static int linea = 1;
    char preanalisis = ' ';
    Hashtable<String, Palabra> palabras = new Hashtable<>();
    
    // Constructor del analizador léxico
    public AnalizadorLexico() {
        // Inicializar las palabras clave
        reservar(new Palabra("if", Etiqueta.IF));
        reservar(new Palabra("else", Etiqueta.ELSE));
        reservar(new Palabra("while", Etiqueta.WHILE));
        reservar(new Palabra("true", Etiqueta.TRUE));
        reservar(new Palabra("break", Etiqueta.BREAK));
        reservar(new Palabra("do", Etiqueta.DO));
        reservar(new Palabra("false", Etiqueta.FALSE));
        reservar(new Palabra("minus", Etiqueta.MINUS));
        reservar(new Palabra("index", Etiqueta.INDEX));
        

        // Añadir más palabras clave según sea necesario
    }
    
    void reservar(Palabra w) { palabras.put(w.lexema, w); }
    
    void readch() throws IOException { 
        preanalisis = (char) System.in.read(); 
    }
    
    boolean readch(char c) throws IOException {
        readch();
        if( preanalisis != c ) return false;
        preanalisis = ' ';
        return true;
    }

    public Token explorar() throws IOException {
        for( ; ; readch() ) {
            if( preanalisis == ' ' || preanalisis == '\t' ) 
                continue;
            else if( preanalisis == '\n' ) 
                linea = linea + 1;
            else 
                break;
        }
        
        switch( preanalisis ) {
            case '&':
                if( readch('&') ) 
                    return Palabra.and; 
                else 
                    return new Token('&');
            case '|':
                if( readch('|') ) 
                    return Palabra.or; 
                else 
                    return new Token('|');
            case '=':
                if( readch('=') ) 
                    return Palabra.eq; 
                else 
                    return new Token('=');
            case '!':
                if( readch('=') ) 
                    return Palabra.ne; 
                else 
                    return new Token('!');
            case '<':
                if( readch('=') ) 
                    return Palabra.le; 
                else 
                    return new Token('<');
            case '>':
                if( readch('=') ) 
                    return Palabra.ge; 
                else 
                    return new Token('>');
        }
        
        if( Character.isDigit(preanalisis) ) {
            int v = 0;
            do {
                v = 10 * v + Character.digit(preanalisis, 10); 
                readch();
            } while ( Character.isDigit(preanalisis) );
            
            if( preanalisis != '.') 
                return new Num(v);
            
            float x = (float)v; 
            float d = 10;
            
            for(;;) {
                readch();
                if( ! Character.isDigit(preanalisis) ) 
                    break;
                x = x + Character.digit(preanalisis, 10) / d; 
                d = d * 10;
            }
            
            return new Real(x);
        }
        
        if (Character.isLetter(preanalisis)) {
            StringBuffer b = new StringBuffer();
            do {
                b.append(preanalisis); 
                readch();
            } while (Character.isLetterOrDigit(preanalisis));
            
            String s = b.toString();
            // Comprobar si la cadena es una palabra clave
            if (palabras.containsKey(s)) {
                return palabras.get(s); // Devolver el token correspondiente a la palabra clave
            } else {
                Palabra w = new Palabra(s, Etiqueta.ID); // Tratar la cadena como un identificador
                palabras.put(s, w);
                return w;
            }
        }
        
        Token tok = new Token(preanalisis); 
        preanalisis = ' ';
        return tok;
    }
}
