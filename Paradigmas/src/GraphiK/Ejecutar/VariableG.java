package Graphik.Ejecutar;

import java.util.ArrayList;
import java.util.Stack;

public class VariableG {

    public static String ultimoValor = "";
    public static boolean romper = false;
    public static Stack<String> pilaAmbito = new Stack<>();
    public static int nivelAmbito = 0;
    public static ArrayList listaVariables = new ArrayList();
    public static ArrayList<NodoG> variableGlobal = new ArrayList();

    public static void crearVariable(String tipo, String nombre, Object valor, String visib) {
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nombre.equals(nombre) && s.ambito.equals(pilaAmbito.peek()) && s.nivel == nivelAmbito) {
                paradigmas.ReporteError.agregarError(nombre, "Error Semantico", "La variable " + nombre + " ya existe", 0, 0);
                return;
            }
        }
        Variable v = new Variable();
        v.nombre = nombre;
        v.tipo = tipo;
        v.valor = valor;
        v.visibilidad = visib;
        v.nivel = nivelAmbito;
        v.ambito = pilaAmbito.peek();
        listaVariables.add(v);
    }
  public static void crearVariable(String tipo, String nombre, Object valor, String visib, String tamanio) {
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nombre.equals(nombre) && s.ambito.equals(pilaAmbito.peek()) && s.nivel == nivelAmbito) {
                paradigmas.ReporteError.agregarError(nombre, "Error Semantico", "La variable " + nombre + " ya existe", 0, 0);
                return;
            }
        }
        Variable v = new Variable();
        v.nombre = nombre;
        v.tipo = tipo;
        v.valor = valor;
        v.visibilidad = visib;
        v.nivel = nivelAmbito;
        v.ambito = pilaAmbito.peek();
        listaVariables.add(v);
    }

    public static void asignarValor(String nombre, Object valor) {
        boolean existe = false;
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nombre.equals(nombre)) {
                s.valor = valor;
                existe = true;
            }
        }
        if (existe == false) {
            paradigmas.ReporteError.agregarError(nombre, "Error Semantico", "No existe la variable "+nombre, 0, 0);
        }
    }

    public static void eliminarVariable() {
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nivel == nivelAmbito) {
                listaVariables.remove(i);
                return;
            }
        }
//        for (int i = 0; i < MatrizHK.listaMatriz.size(); i++) {
//            Matriz s = (Matriz) MatrizHK.listaMatriz.get(i);
//            if (s.nivel == nivelAmbito) {
//                MatrizHK.listaMatriz.remove(i);
//                return;
//            }
//        }
    }

    public static Object obtenerValor(String nombre) {
        
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

    public static Object obtenerVariable(String nombre) {
        Variable s = null;
        for (int i = listaVariables.size() - 1; i >= 0; i--) {
            Variable sim = (Variable) listaVariables.get(i);
            if (sim.nombre.equals(nombre)) {
                return sim.valor;
            }
        }
        return s;
    }

}

class Variable {

    public String ambito;
    public int nivel;

    public String nombre;
    public Object valor;
    public String tipo;
    public String visibilidad;
    public ArrayList valores= new ArrayList();
    public int tamanio;
}
