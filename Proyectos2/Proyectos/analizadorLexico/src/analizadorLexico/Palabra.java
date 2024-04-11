/*
    Esta clase representa un token para palabras clave, identificadores y operadores, que hereda de la clase Token.
    Cada instancia de esta clase tiene un lexema asociado, que es el texto que representa al token en el código fuente.
*/

package analizadorLexico; // La clase pertenece al paquete analizadorLexico

public class Palabra extends Token { // Definición de la clase Palabra, que hereda de Token

    public String lexema = ""; // Atributo para almacenar el lexema asociado al token

    // Constructor de la clase Palabra que inicializa la etiqueta y el lexema del token
    public Palabra(String s, int etiqueta) {
        super(etiqueta); // Llama al constructor de la clase base Token para inicializar la etiqueta
        lexema = s; // Asigna el lexema proporcionado al atributo lexema
    }

    // Método para convertir el token a una representación en cadena (String)
    public String toString() {
        // Utiliza un switch para determinar el formato de la representación en cadena según la etiqueta del token
        switch (etiqueta) {
            // Si la etiqueta del token corresponde a una palabra clave, un operador lógico o un operador relacional,
            // devuelve una cadena que contiene el lexema y la etiqueta del token entre paréntesis
            case Etiqueta.IF:
            case Etiqueta.ELSE:
            case Etiqueta.WHILE:
            case Etiqueta.TRUE:
            case Etiqueta.FALSE:
            case Etiqueta.BREAK:
            case Etiqueta.DO:
                return "(" + lexema + ", " + etiqueta + ")";
            // Si la etiqueta no corresponde a los casos anteriores, devuelve una cadena que contiene
            // el lexema y la etiqueta del token entre paréntesis
            default:
                return "(" + lexema + ", " + etiqueta + ")";
        }
    }

    // Definición de algunas constantes estáticas que representan palabras clave y operadores,
    // cada una con su lexema y etiqueta asociados
    public static final Palabra
        and = new Palabra( "&&", Etiqueta.AND ), // Operador lógico AND
        or = new Palabra( "||", Etiqueta.OR ), // Operador lógico OR
        eq = new Palabra( "==", Etiqueta.EQ ), // Operador de igualdad
        ne = new Palabra( "!=", Etiqueta.NE ), // Operador de desigualdad
        le = new Palabra( "<=", Etiqueta.LE ), // Operador menor o igual que
        ge = new Palabra( ">=", Etiqueta.GE ), // Operador mayor o igual que
        temp = new Palabra( "t", Etiqueta.TEMP ); // Valor temporal
    
}
