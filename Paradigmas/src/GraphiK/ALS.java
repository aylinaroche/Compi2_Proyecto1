package Graphik;

import Graphik.Objetos.MF;
import Graphik.Ejecutar.Metodo_FuncionG;
import Graphik.Ejecutar.NodoG;
import Graphik.Objetos.Parametro;
import Graphik.Ejecutar.RecorridoEjecutar;
import Graphik.Ejecutar.RecorridoGuardar;
import Graphik.Objetos.Variable;
import Graphik.Ejecutar.VariableG;
import static Graphik.Ejecutar.VariableG.listaVariables;
import static Graphik.Ejecutar.VariableG.nivelAmbito;
import static Graphik.Ejecutar.VariableG.nombreALS;
import static Graphik.Ejecutar.VariableG.pilaAmbito;
import Graphik.Objetos.ObjetoALS;
import java.util.ArrayList;

public class ALS {

    public static ArrayList listaALS = new ArrayList();
//    public static ArrayList listaAux = new ArrayList();
//     public static ArrayList<VariableALS> instanciaALS = new ArrayList();
//    public static ArrayList variables = new ArrayList();
//    public static ArrayList<MF> metodos = new ArrayList();

    public static void agregarALS(String nombre, NodoG nodo, String visible) {
        VariableG.pilaAmbito.push("Global");
        VariableG.nombreALS.push(nombre);
        RecorridoGuardar g = new RecorridoGuardar();
        g.Recorrido(nodo);
        ObjetoALS obj = new ObjetoALS();
        obj.nombre = nombre;
        obj.visibilidad = visible;
        ArrayList n = new ArrayList();
        n = (ArrayList) VariableG.listaVariables.clone();
        obj.variables = n;
        obj.metodos = (ArrayList) Metodo_FuncionG.listaMetodos.clone();
        listaALS.add(obj);
        paradigmas.Atributos.crearSimboloGraphik(nombre, "ALS", "Objeto ALS", "Clase", " - ");
        VariableG.listaVariables.clear();
        Metodo_FuncionG.listaMetodos.clear();
        VariableG.pilaAmbito.pop();
        VariableG.nombreALS.pop();
        // agregarALS2(nombre, nodo, visible);
    }

    public static void agregarALS2(String nombre, NodoG nodo, String visible) {
        VariableG.pilaAmbito.push("Global");
        VariableG.nombreALS.push(nombre);
        RecorridoGuardar g = new RecorridoGuardar();
        g.Recorrido(nodo);
        ObjetoALS obj = new ObjetoALS();
        obj.nombre = nombre;
        obj.visibilidad = visible;
        ArrayList n = new ArrayList();
        n = (ArrayList) VariableG.listaVariables.clone();
        obj.variables = (ArrayList) n.clone();
        obj.metodos = (ArrayList) Metodo_FuncionG.listaMetodos.clone();
        //listaAux.add(obj);
        paradigmas.Atributos.crearSimboloGraphik(nombre, "ALS", "Objeto ALS", "Clase", " - ");
        VariableG.listaVariables.clear();
        Metodo_FuncionG.listaMetodos.clear();
        VariableG.pilaAmbito.pop();
        VariableG.nombreALS.pop();
    }

    public static void crearVariableALS(String tipo, String nombre) {

        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = new Variable();
            s = (Variable) listaVariables.get(i);
            if (s.nombre.equals(nombre) && s.ambito.equals(pilaAmbito.peek()) && s.nivel == nivelAmbito && s.als.equals(nombreALS)) {
                paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "La variable " + nombre + " ya existe", 0, 0);
                return;
            }
        }
        ObjetoALS ins = new ObjetoALS();
        ins.als = tipo;
        ins.nombre = nombre;
        for (int i = 0; i < listaALS.size(); i++) {
            ObjetoALS obj = new ObjetoALS();
            obj = (ObjetoALS) listaALS.get(i);
            if (obj.nombre.equals(tipo)) {
                ArrayList n = new ArrayList();
                n = (ArrayList) obj.variables.clone();
                ins.variables = (ArrayList) n.clone();
                ins.metodos = (ArrayList) obj.metodos.clone();
            }
        }
        Variable v = new Variable();
        v.nombre = nombre;
        v.tipo = tipo;
        v.valor = ins;
        v.nivel = nivelAmbito;
        v.ambito = pilaAmbito.peek();
        v.als = "VariableALS";
        listaVariables.add(v);
        paradigmas.Atributos.crearSimboloGraphik(nombre, tipo, "Arreglo", v.ambito, " - ");
    }

    public static Object buscarALS(String nombre) {
        for (int i = 0; i < listaALS.size(); i++) {
            ObjetoALS obj = (ObjetoALS) listaALS.get(i);

            if (obj.nombre.equals(nombre)) {
                return obj;
            }
        }
        paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "No se ha encontrado el metodo", 0, 0);
        return "";
    }

    public static String tipoALS(String nombre) {
//        for (int i = 0; i < instanciaALS.size(); i++) {
//            VariableALS v = instanciaALS.get(i);
//            if (v.nombre.equals(nombre)) {
//                return v.als;
//            }
//        }
        //paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "No se ha encontrado el metodo", 0, 0);
        return "";
    }

    public static Object obtenerTipoALS(Object valor) {
        if (valor instanceof Double || valor instanceof Integer || valor instanceof Boolean || valor instanceof String || valor instanceof Character) {
            return valor;
        }
        return "";
    }

//    public static void asignarValorALS(ObjetoALS var) {
//        ArrayList l = new ArrayList();
//        l = (ArrayList) ALS.variables.clone();
//        var.variables = (ArrayList) l.clone();
//        var.metodos = (ArrayList) ALS.metodos.clone();
//        VariableG.asignarValor(var.nombre, var);
//    }
//
//    public static Object obtenerVariableALS(String nombre) {
//        Variable s = null;
//        for (int i = variables.size() - 1; i >= 0; i--) {
//            Variable sim = (Variable) variables.get(i);
//            if (sim.nombre.equals(nombre)) {
//                return sim.valor;
//            }
//        }
//        paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "No existe la variable", 0, 0);
//        return "";
//    }
//    public static Object buscarMetodo(String id, ArrayList parametro, String als) {
//        Object retorno = "";
//        for (int i = 0; i < metodos.size(); i++) {
//            MF mf = (MF) metodos.get(i);
//
//            if (mf.nombre.equals(id)) {
//                VariableG.pilaAmbito.push(id);
//                VariableG.nivelAmbito++;
//                VariableG.nombreALS.push(als);
//                if (parametro.isEmpty() && mf.parametro.isEmpty()) {
//                    parametro.clear();
//                    RecorridoEjecutar r = new RecorridoEjecutar();
//                    retorno = r.Recorrido(mf.nodo);
//
//                    VariableG.eliminarVariable();
//                    VariableG.nivelAmbito--;
//                    VariableG.pilaAmbito.pop();
//                    return retorno;
//                }
//                if (parametro.size() == mf.parametro.size()) {
//                    for (int j = 0; j < parametro.size(); j++) {
//                        Parametro p = (Parametro) mf.parametro.get(j);
//                        Object p2 = (Object) parametro.get(j);
//                        VariableG.crearVariable(p.tipo, p.nombre, p2, "public");
//                    }
//                    parametro.clear();
//                    RecorridoEjecutar r = new RecorridoEjecutar();
//                    retorno = r.Recorrido(mf.nodo);
//                    VariableG.eliminarVariable();
//                    VariableG.nivelAmbito--;
//                    VariableG.pilaAmbito.pop();
//                    VariableG.nombreALS.pop();
//
//                    return retorno;
//                }
//            }
//        }
//        paradigmas.ReporteError.agregarErrorGK(id, "Error Semantico", "No se ha encontrado el metodo", 0, 0);
//
//        return "";
//    }
    public static void imprimir(String lugar) {
        for (int i = listaALS.size() - 1; i >= 0; i--) {
            ObjetoALS sim = (ObjetoALS) ALS.listaALS.get(i);
            if (sim.nombre.equals("aritmetica")) {
                ArrayList a = (ArrayList) sim.variables.clone();
                for (int j = 0; j < a.size(); j++) {
                    Variable v = (Variable) a.get(j);
                    System.out.print(lugar + ":: " + v.nombre + " = " + v.valor + "             ");
                    // return;
                }
            }
        }
//        for (int i = listaAux.size() - 1; i >= 0; i--) {
//            ObjetoALS sim = (ObjetoALS) ALS.listaAux.get(i);
//            if (sim.nombre.equals("aritmetica")) {
//                ArrayList a = (ArrayList) sim.variables.clone();
//                for (int j = 0; j < a.size(); j++) {
//                    Variable v = (Variable) a.get(j);
//                    System.out.println(v.nombre + " = " + v.valor);
//                    return;
//                }
//            }
//        }
    }

//    public static void clonar() {
//        listaALS.clear();
//        ArrayList nueva = new ArrayList();
//        for (int i = 0; i < listaAux.size(); i++) {
//            nueva.add(listaAux.get(i));
//
//        }
//        for (int i = 0; i < listaAux.size(); i++) {
//            ObjetoALS o = new ObjetoALS();
//            o = (ObjetoALS) listaAux.get(i);
//            ObjetoALS obj = new ObjetoALS();
//            obj = (ObjetoALS) o.clone();
////            obj.nombre = o.nombre;
////            obj.visibilidad = o.visibilidad;
////            obj.variables = (ArrayList) o.variables.clone();
////            obj.metodos = (ArrayList) o.metodos.clone();
//            listaALS.add(obj);
//        }
//        listaAux.clear();
//
//        listaAux = (ArrayList) nueva.clone();
//
//    }
    
}
