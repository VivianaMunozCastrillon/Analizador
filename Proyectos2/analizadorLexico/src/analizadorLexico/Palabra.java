package analizadorLexico;

public class Palabra extends Token {
    public String lexema = "";
    public Palabra(String s, int etiqueta) { super(etiqueta); lexema = s; }
    public String toString() { return lexema;}
    public static final Palabra
        and = new Palabra( "&&", Etiqueta.AND ), or = new Palabra( "||", Etiqueta.OR ),
        eq = new Palabra( "==", Etiqueta.EQ ), ne = new Palabra( "!=", Etiqueta.NE ),
        le = new Palabra( "<=", Etiqueta.LE ), ge = new Palabra( ">=", Etiqueta.GE ),
        temp = new Palabra( "t", Etiqueta.TEMP );
        
       
        
    
}