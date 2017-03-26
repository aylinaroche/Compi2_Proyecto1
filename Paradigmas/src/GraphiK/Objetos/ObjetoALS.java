package Graphik.Objetos;

import java.util.ArrayList;

/**
 *
 * @author Aylin
 */
public class ObjetoALS implements Cloneable {

    public String nombre;
    public String visibilidad;
    public String als;
    public ArrayList variables;
    public ArrayList metodos;

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            // No deberia ocurrir
        }
        return clone;
    }
}
