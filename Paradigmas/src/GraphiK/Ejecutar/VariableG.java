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
                paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "La variable " + nombre + " ya existe", 0, 0);
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

        paradigmas.Atributos.crearSimboloGraphik(nombre, tipo, "Variable", v.ambito, "0");
    }

    public static void crearVariable(String tipo, String nombre, Object valor, String visib, int tamanio[]) {
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nombre.equals(nombre) && s.ambito.equals(pilaAmbito.peek()) && s.nivel == nivelAmbito) {
                paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "La variable " + nombre + " ya existe", 0, 0);
                return;
            }
        }
        Variable v = new Variable();
        v.nombre = nombre;
        v.tipo = tipo;
        v.valor = valor;
        v.visibilidad = visib;
        v.tamanio = tamanio;
        v.nivel = nivelAmbito;
        v.ambito = pilaAmbito.peek();
        listaVariables.add(v);
        ArrayList val = (ArrayList) valor;
        paradigmas.Atributos.crearSimboloGraphik(nombre, tipo, "Arreglo", v.ambito, String.valueOf(val.size()));
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
            paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "No existe la variable " + nombre, 0, 0);
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
    }

    public static Object obtenerValor(String nombre) {

        String valor = "";
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nombre.equals(nombre)) {
                return s.valor;
            }
        }
        paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "No existe la variable", 0, 0);
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

    public static Object obtenerValorArreglo(String nombre, ArrayList coord) {
        Boolean existe = false;
        ArrayList datos = new ArrayList();
        Variable var = new Variable();
        for (int i = 0; i < listaVariables.size(); i++) {
            var = (Variable) listaVariables.get(i);
            if (var.nombre.equals(nombre)) {
                datos = (ArrayList) var.valor;
                existe = true;
                break;
            }
        }
        if (existe == false) {
            paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "No existe la matriz " + nombre, 0, 0);
            return "";
        }
        int pos = posicion(coord.size(), coord, var.tamanio);
        Object dato = datos.get(pos);
        return dato;
    }

    public static void asignarValorArreglo(String nombre, ArrayList coord, Object valor) {
        Boolean existe = false;
        ArrayList datos = new ArrayList();
        Variable var = new Variable();
        for (int i = 0; i < listaVariables.size(); i++) {
            var = (Variable) listaVariables.get(i);
            if (var.nombre.equals(nombre)) {
                datos = (ArrayList) var.valor;
                existe = true;
                break;
            }
        }
        if (existe == false) {
            paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "No existe la matriz " + nombre, 0, 0);
            return;
        }
        int pos = posicion(coord.size(), coord, var.tamanio);

        datos.set(pos, valor);

    }

    public static int posicion(int cantidad, ArrayList coord, int tamanio[]) {

        if (cantidad == 1) {
            int i1 = (int) coord.get(cantidad - 1);
            return i1;
        } else {
            int i2 = (int) coord.get(cantidad - 1);
            int n2 = tamanio[cantidad - 1] + 1;
            int formula = (posicion(cantidad - 1, coord, tamanio)) * n2 + i2;
            return formula;
        }
    }

}

class Variable {

    public String ambito;
    public int nivel;

    public String nombre;
    public Object valor;
    public String tipo;
    public String visibilidad;
    public ArrayList valores = new ArrayList();
    public int tamanio[];
}
