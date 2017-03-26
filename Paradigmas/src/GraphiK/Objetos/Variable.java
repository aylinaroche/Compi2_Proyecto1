package Graphik.Objetos;

import java.util.ArrayList;

public class Variable implements Cloneable{

    public String ambito;
    public int nivel;

    public String nombre;
    public Object valor;
    public String tipo;
    public String visibilidad;
    public ArrayList valores = new ArrayList();
    public int tamanio[];
    public String als;
}
