package Graphik.Ejecutar;

import Graphik.ALS;
import static Graphik.ALS.listaALS;
import Graphik.Objetos.MF;
import Graphik.Objetos.ObjetoALS;
import java.util.ArrayList;
import java.util.Stack;
import Graphik.Objetos.Variable;

public class VariableG {

    public static String ultimoValor = "";
    public static boolean romper = false;
    public static Stack<String> pilaAmbito = new Stack<>();
    public static int nivelAmbito = 0;
    public static ArrayList listaVariables = new ArrayList();
    public static ArrayList<NodoG> variableGlobal = new ArrayList();
    public static Stack<String> nombreALS = new Stack<>();

    public static void crearVariable(String tipo, String nombre, Object valor, String visib) {
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nombre.equals(nombre) && s.ambito.equals(pilaAmbito.peek()) && s.nivel == nivelAmbito && s.als.equals(nombreALS)) {
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
        v.als = nombreALS.peek();
        listaVariables.add(v);

        paradigmas.Atributos.crearSimboloGraphik(nombre, tipo, "Variable", v.ambito, "0");
    }

    public static void crearVariable(String tipo, String nombre, Object valor, String visib, int tamanio[]) {
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nombre.equals(nombre) && s.ambito.equals(pilaAmbito.peek()) && s.nivel == nivelAmbito && s.als.equals(nombreALS)) {
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
        v.als = nombreALS.peek();
        listaVariables.add(v);
        ArrayList val = (ArrayList) valor;
        paradigmas.Atributos.crearSimboloGraphik(nombre, tipo, "Arreglo", v.ambito, String.valueOf(val.size()));
    }

    public static void asignarValor(String nombre, Object valor) {
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nombre.equals(nombre) &&s.als.equals(nombreALS.peek())) {
                s.valor = valor;
                ALS.imprimir("Asig1");
                return;
            }
        }
//        for (int i = 0; i < ALS.variables.size(); i++) {
//            Variable s = (Variable) ALS.variables.get(i);
//            if (s.nombre.equals(nombre)) {
//                ALS.imprimir("Asi2");
//                s.valor = valor;
//                ALS.imprimir("Asi3");
//                return;
//            }
//        }
        paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "No existe la variable " + nombre, 0, 0);
    }

    public static void eliminarVariable() {
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nivel == nivelAmbito && !"Global".equals(s.ambito)) {
                listaVariables.remove(i);
                return;
            }
        }
    }

    public static Object obtenerVariable(String nombre, String als) {
        Variable s = null;
        for (int i = listaVariables.size() - 1; i >= 0; i--) {
            Variable sim = (Variable) listaVariables.get(i);
            if (sim.nombre.equals(nombre) && sim.als.equals(als)) {
                Object valor = sim.valor;
                return valor;
            }
        }
//        for (int i = ALS.variables.size() - 1; i >= 0; i--) {
//            Variable sim = (Variable) ALS.variables.get(i);
//            if (sim.nombre.equals(nombre)) {
//                 Object valor = sim.valor;
//                return valor;
//            }
//        }

        paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "No existe la variable", 0, 0);
        return "";
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

    ///////////////////////////
    public static void crearVariableALS(String tipo, String nombre) {
        ObjetoALS ins = new ObjetoALS();
        ins.als = tipo;
        ins.nombre = nombre;
        nombreALS.push(nombre);
        for (int i = 0; i < listaALS.size(); i++) {
            ObjetoALS obj = (ObjetoALS) listaALS.get(i);
            if (obj.nombre.equals(tipo)) {

                for (int j = 0; j < obj.variables.size(); j++) {
                    Variable var = (Variable) obj.variables.get(j);

                    Variable v = new Variable();
                    v.nombre = var.nombre;
                    v.tipo = var.tipo;
                    v.valor = var.valor;
                    v.nivel = var.nivel;
                    v.ambito = var.ambito;
                    v.als = nombre;
                    listaVariables.add(v);
                }
                for (int j = 0; j < obj.metodos.size(); j++) {
                    MF var = (MF) obj.metodos.get(j);

                    Metodo_FuncionG.agregarMF(var.nombre, var.tipo, var.nodo, var.visibilidad, var.parametro);
                }
                
            }
        }

        // paradigmas.Atributos.crearSimboloGraphik(nombre, tipo, "Variable", v.ambito, "0");
    }

    public static void imprimir() {
        System.out.println("********** IMPRIMIR ***********");
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable v = (Variable) listaVariables.get(i);
            System.out.println(v.nombre + "  -  " + v.tipo + "  -  " + v.als + "  -  " + v.ambito + "  -  " + v.valor);
            // return;
        }
    }
}
