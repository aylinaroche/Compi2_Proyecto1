package Haskell.Ejecutar;

import java.util.ArrayList;
import java.util.Stack;

public class VariableHK {

    public static String ultimoValor = "";
    public static boolean romper = false;
    public static Stack<String> pilaAmbito = new Stack<>();
    public static ArrayList listaVariables = new ArrayList();
    
    public static void crearVariable(String nombre, String valor, String tipo) {
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nombre.equals(nombre) && s.ambito.equals(pilaAmbito.peek())) {
                paradigmas.ReporteError.agregarError(nombre, "Error Semantico", "La variable " + nombre + " ya existe", 0, 0);
                return;
            }
        }
        Variable v = new Variable();
        v.nombre = nombre;
        v.ambito = pilaAmbito.peek();
        v.tipo = tipo;
        v.valor = valor;
        listaVariables.add(v);
    }

    public static void eliminarVariable() {
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.ambito.equals(pilaAmbito.peek())) {
                listaVariables.remove(i);
                return;
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
        paradigmas.ReporteError.agregarError(nombre, "Error Semantico", "No existe la variable", 0, 0);
        return valor;
    }

    public static String obtenerTamanio(String nombre) {
        boolean existe = false;
        String valor = "1";
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);

            if (s.nombre.equals(nombre)) {
                int val = s.valor.length();
                valor = String.valueOf(val);
                existe = true;
                return valor;
            }
        }
        if (existe == false) {
            paradigmas.ReporteError.agregarError(nombre, "Error Semantico", "No existe la variable", 0, 0);
        }
        return valor;
    }

    public static Variable obtenerVariable(String nombre) {
        Variable s = null;
        for (int i = 0; i < listaVariables.size(); i++) {
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
    public String nombre;
    public String valor;
    public int tamanio;
    public String tipo; //Variable o lista
}

