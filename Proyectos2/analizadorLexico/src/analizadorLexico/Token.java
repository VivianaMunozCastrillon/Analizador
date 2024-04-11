package analizadorLexico;

public class Token {
    public final int etiqueta;
    public Token(int t) {etiqueta = t;}

    
// Método para obtener el valor asociado al token (si corresponde)
public Object obtenerValor() {
    return null; // Por defecto, los tokens no tienen un valor asociado
}

public String toString() {
    String valor = obtenerValor() != null ? obtenerValor().toString() : "";
    return "(" + etiqueta + ", " + (char)etiqueta + ", " + valor + ")"; // Agregamos la etiqueta numérica al token en la salida
}

}


