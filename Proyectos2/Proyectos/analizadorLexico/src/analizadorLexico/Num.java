/*
    Esta clase representa un token para números enteros, que hereda de la clase Token.
    Cada instancia de esta clase tiene un valor asociado, que es el número entero que representa el token en el código fuente.
*/

package analizadorLexico; // La clase pertenece al paquete analizadorLexico

public class Num extends Token { // Definición de la clase Num, que hereda de Token

    public final int valor; // Atributo para almacenar el valor asociado al token

    // Constructor de la clase Num que inicializa la etiqueta y el valor del token
    public Num(int v) {
        super(Etiqueta.NUM); // Llama al constructor de la clase base Token para inicializar la etiqueta
        valor = v; // Asigna el valor proporcionado al atributo valor
    }

    // Método para convertir el token a una representación en cadena (String)
    public String toString() {
        // Devuelve una cadena que contiene el valor y la etiqueta del token entre paréntesis
        return "(" + valor + ", " + Etiqueta.NUM + ")";
    }

}
