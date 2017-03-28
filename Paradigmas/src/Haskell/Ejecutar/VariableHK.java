package Haskell.Ejecutar;

import java.util.ArrayList;
import java.util.Stack;

public class VariableHK {

    public static String ultimoValor = "";
    public static boolean romper = false;
    public static Stack<String> pilaAmbito = new Stack<>();
    public static int nivelAmbito = 0;
    public static ArrayList listaVariables = new ArrayList();

    public static void crearVariable(String nombre, String valor, String tipo) {
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nombre.equals(nombre) && s.ambito.equals(pilaAmbito.peek()) && s.nivel == nivelAmbito) {
                paradigmas.ReporteError.agregarErrorHK(nombre, "Error Semantico", "La variable " + nombre + " ya existe", 0, 0);
                return;
            }
        }
        Variable v = new Variable();
        v.nombre = nombre;
        v.ambito = pilaAmbito.peek();
        v.tipo = tipo;
        v.valor = valor;
        v.nivel = nivelAmbito;
        listaVariables.add(v);
        paradigmas.Atributos.crearSimboloHaskell(nombre, " - ", "Variable", v.ambito, " - ");
    }

    public static void eliminarVariable() {
        for (int i =listaVariables.size()-1; i>=0;i--) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nivel == nivelAmbito) {
                listaVariables.remove(i);
             //   return;
            }
        }
       for (int i =MatrizHK.listaMatriz.size()-1; i>=0;i--) {
            Matriz s = (Matriz) MatrizHK.listaMatriz.get(i);
            if (s.nivel == nivelAmbito) {
                MatrizHK.listaMatriz.remove(i);
               // return;
            }
        }
    }

    public static String obtenerValor(String nombre) {
        String valor = "";
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nombre.equals(nombre)) {
                return s.valor;
            }
        }
        paradigmas.ReporteError.agregarErrorHK(nombre, "Error Semantico", "No existe la variable", 0, 0);
        return valor;
    }

    public static Variable obtenerVariable(String nombre) {
        Variable s = null;
        for (int i = listaVariables.size() - 1; i >= 0; i--) {
            Variable sim = (Variable) listaVariables.get(i);
            if (sim.nombre.equals(nombre)) {
                return sim;
            }
        }
        return s;
    }

}
 class Variable {

    public String ambito;
    public int nivel;
    public String nombre;
    public String valor;
    public int tamanio;
    public String tipo; //Variable o lista
}
