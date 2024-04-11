/*
    Esta clase representa un token para números reales, que hereda de la clase Token.
    Cada instancia de esta clase tiene un valor asociado, que es el número real que representa el token en el código fuente.
*/

package analizadorLexico; // La clase pertenece al paquete analizadorLexico

public class Real extends Token { // Definición de la clase Real, que hereda de Token

    public final float valor; // Atributo para almacenar el valor asociado al token

    // Constructor de la clase Real que inicializa la etiqueta y el valor del token
    public Real(float v) {
        super(Etiqueta.REAL); // Llama al constructor de la clase base Token para inicializar la etiqueta
        valor = v; // Asigna el valor proporcionado al atributo valor
    }

    // Método para convertir el token a una representación en cadena (String)
    public String toString() {
        // Devuelve una cadena que contiene el valor y la etiqueta del token entre paréntesis
        return "(" + valor + ", " + Etiqueta.REAL + ")";
    }

}
