package Haskell;

import Haskell.Ejecutar.Nodo;
import java.util.ArrayList;

public class Metodo_FuncionHK {

    public static ArrayList metodoFuncionHK = new ArrayList();
    public static ArrayList parametros = new ArrayList();

    public static void agregarMF(String n,Nodo nodo, ArrayList parametro) {
        MF mf = new MF();
        mf.nombre = n;
        mf.nodo = nodo;
        mf.parametro = (ArrayList) parametro.clone();
        metodoFuncionHK.add(mf);      
    }

    public static void agregarParametro(String n) {
        Parametro p = new Parametro();
        p.nombre = n;
        //p.tipo = t;
        parametros.add(p);
    }
//
//    public static void parametroSimbolo(String ambito) {
//
//        for (int i = 0; i < parametros.size(); i++) {
//            Parametro p = (Parametro) parametros.get(i);
////            TablaDeSimbolos.agregarSimbolo(p.tipo, p.nombre, "", ambito, "parametro", "-", "-");
//
//        }
//    }    
}

class MF {

    public String nombre;
    public String tipo;
    public String retorno;
    public Nodo nodo;
    public ArrayList parametro;
}

class Parametro {

    public String nombre;
    public String tipo;

}
