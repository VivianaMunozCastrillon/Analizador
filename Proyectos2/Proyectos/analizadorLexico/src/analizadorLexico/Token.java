/*
    Esta clase representa un token, que es un elemento básico utilizado en el análisis léxico de un programa.
    Los tokens son unidades individuales de un lenguaje de programación, como palabras clave, identificadores, números, etc.
*/

package analizadorLexico; // La clase pertenece al paquete analizadorLexico

public class Token { // Definición de la clase Token

    public final int etiqueta; // Atributo para almacenar la etiqueta del token

    // Constructor de la clase Token que inicializa la etiqueta del token
    public Token(int t) {
        etiqueta = t;
    }

    // Método para obtener el valor asociado al token (si corresponde)
    public Object obtenerValor() {
        return null; // Por defecto, los tokens no tienen un valor asociado
    }

    // Método para convertir el token a una representación en cadena (String)
    public String toString() {
        // Obtiene el valor asociado al token (si lo hay)
        String valor = obtenerValor() != null ? obtenerValor().toString() : "";
        
        // Si el valor está vacío, devuelve solo la etiqueta del token entre paréntesis
        if (valor.equals("")) {
            return "(" + etiqueta + ")";
        } else { // Si hay un valor, devuelve el valor y la etiqueta entre paréntesis
            return "(" + valor + ", " + etiqueta + ")";
        }
    }

}



