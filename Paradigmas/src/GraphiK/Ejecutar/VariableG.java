package Graphik.Ejecutar;

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
    public static int nivelALS = 0;

    public static void crearVariable(String tipo, String nombre, Object valor, String visib) {
        if (verificarTipo(tipo) == false) {
            return;
        }
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nombre.equals(nombre) && s.ambito.equals(pilaAmbito.peek()) && s.nivel == nivelAmbito && s.als.equals(nombreALS.peek())) {
                paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "La variable " + nombre + " ya existe", 0, 0);
                return;
            }
        }
        if (valor instanceof ObjetoALS) {
            igualarALS(nombre, valor);
            ObjetoALS obj = (ObjetoALS) valor;
            obj.nombre = nombre;
            valor = obj;
        }
        Variable v = new Variable();
        v.nombre = nombre;
        v.tipo = tipo;
        v.valor = valor;
        v.visibilidad = visib;
        v.nivel = nivelAmbito;
        v.ambito = pilaAmbito.peek();
        v.als = nombreALS.peek();
        v.aux = nombre();
        listaVariables.add(v);

        paradigmas.Atributos.crearSimboloGraphik(nombre, tipo, "Variable", v.ambito, "0");
    }

    public static void crearVariable(String tipo, String nombre, Object valor, String visib, int tamanio[]) {
        if (verificarTipo(tipo) == false) {
            return;
        }
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nombre.equals(nombre) && s.ambito.equals(pilaAmbito.peek()) && s.nivel == nivelAmbito && s.als.equals(nombreALS.peek())) {
                paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "La variable " + nombre + " ya existe", 0, 0);
                return;
            }
        }
        ArrayList valores = (ArrayList) valor;
        if (valores.isEmpty()) {
            int tam = 1;
            for (int i = 0; i < tamanio.length; i++) {
                int j = tamanio[i];
                if (j != 0) {
                    tam *= j;
                    //       System.out.println(i+":"+tam);
                }
            }
            ArrayList lista = new ArrayList();
            for (int i = 0; i < tam; i++) {
                lista.add("");
            }
            valor = lista;
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
        v.aux = nombre();
        listaVariables.add(v);
        ArrayList val = (ArrayList) valor;
        paradigmas.Atributos.crearSimboloGraphik(nombre, tipo, "Arreglo", v.ambito, String.valueOf(val.size()));
    }

    public static void asignarValor(String nombre, Object valor) {
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nombre.equals(nombre) && s.als.equals(nombreALS.peek())) {
                s.valor = valor;
                return;
            }
        }
        paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "No existe la variable " + nombre, 0, 0);
    }

    public static void eliminarVariable() {
        for (int i = listaVariables.size() - 1; i >= 0; i--) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nivel == nivelAmbito && !"Global".equals(s.ambito)) {
                listaVariables.remove(i);
                //              return;
            }
        }
    }

    public static Object obtenerVariable(String nombre, String als) {
        Variable s = null;
        for (int i = listaVariables.size() - 1; i >= 0; i--) {
            Variable sim = (Variable) listaVariables.get(i);
            String nom = nombre();
            if (sim.nombre.equals(nombre) && sim.als.equals(als) && sim.aux.equals(nom)) {
                Object valor = sim.valor;
                RecorridoEjecutar.tipoAux = sim.tipo;
                return valor;
            }
        }
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
    public static Boolean verificarTipo(String tipo) {
        if (tipo.equals("entero") || tipo.equals("decimal") || tipo.equals("cadena") || tipo.equals("caracter") || tipo.equals("bool")) {
            return true;
        } else {
            for (int i = 0; i < listaALS.size(); i++) {
                ObjetoALS obj = (ObjetoALS) listaALS.get(i);
                if (obj.nombre.equals(tipo)) {
                    return true;
                }
            }
        }
        paradigmas.ReporteError.agregarErrorGK(tipo, "Error Semantico", "El tipo no existe", 0, 0);
        return false;
    }

    public static void crearVariableALS(String tipo, String nombre) {
        ObjetoALS ins = new ObjetoALS();
        ins.als = tipo;
        ins.nombre = nombre;
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable v = (Variable) listaVariables.get(i);
            if (v.nombre.equals(nombre) && v.valor instanceof ObjetoALS) {
                paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "Ya existe la variable " + nombre, 0, 0);
                return;
            }
        }
        Variable v1 = new Variable();
        v1.nombre = nombre;
        v1.tipo = tipo;
        v1.valor = ins;
        v1.nivel = nivelALS;
        v1.ambito = pilaAmbito.peek();
        v1.als = nombreALS.peek();
        v1.aux = nombreALS.peek();
        listaVariables.add(v1);
        nombreALS.push(nombre);
        nivelALS++;
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
                    v.aux = nombre();
                    listaVariables.add(v);
                    paradigmas.Atributos.crearSimboloGraphik(nombre, tipo, "Variable", v.ambito, "0");
                }
                for (int j = 0; j < obj.metodos.size(); j++) {
                    MF var = (MF) obj.metodos.get(j);

                    Metodo_FuncionG.agregarMF(var.nombre, var.tipo, var.nodo, var.visibilidad, var.parametro);
                }
                nombreALS.pop();
                nivelALS--;
                return;
            }
            // nombreALS.pop();
        }

        paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "No se ha encontrado el objeto: " + tipo, 0, 0);

    }

    public static void imprimir() {
        System.out.println("********** IMPRIMIR ***********");
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable v = (Variable) listaVariables.get(i);
            System.out.println(v.nombre + "  -  " + v.tipo + "  -  " + v.als + "  -  " + v.ambito + "  -  " + v.valor + "  -  " + v.aux);
            // return;
        }
        System.out.println("*******************************");
    }

    public static Boolean existeVariable(String nombre, String als) {
        Variable s = null;
        for (int i = listaVariables.size() - 1; i >= 0; i--) {
            Variable sim = (Variable) listaVariables.get(i);
            if (sim.nombre.equals(nombre) && sim.tipo.equals(als)) {
                return true;
            }
        }
        paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "No existe la variable", 0, 0);
        return false;
    }

    public static String nombre() {
        String dato = nombreALS.peek();
        Stack<String> nombre = (Stack<String>) nombreALS.clone();

        //if (nombre.size() > nivelALS) {
        for (int i = 0; i < nivelALS - 1; i++) {
            nombre.pop();
            dato = nombre.peek() + "." + dato;
        }
        //}
        return dato;
    }

    public static void asignarValorALS(String nombre, Object valor) {
        //    nombre = nombre + ".";
        String n[] = nombre.split(",");
        String aux = nombre();

        for (int i = 0; i < n.length - 1; i++) {
            aux += "." + n[i];
        }
        if (n.length > 1) {
            nombre = n[n.length - 1];
        }
        for (int i = 0; i < listaVariables.size(); i++) {
            Variable s = (Variable) listaVariables.get(i);
            if (s.nombre.equals(nombre) && s.aux.equals(aux)) {
                s.valor = valor;
                return;
            }
        }
        paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "No existe la variable " + nombre, 0, 0);
    }

    public static Object verificarTipoHaskell(String resultado) {
        if ("true".equals(resultado)) {
            return true;
        } else if ("false".equals(resultado)) {
            return false;
        } else {
            try {
                double d = Double.parseDouble(resultado);
                return d;
            } catch (Exception e) {
                return resultado;
            }
        }
    }

    public static void igualarALS(String nombre, Object valor) {
        ObjetoALS obj = (ObjetoALS) valor;

        for (int i = 0; i < listaVariables.size(); i++) {
            Variable var = (Variable) listaVariables.get(i);

            if (var.als.equals(obj.nombre)) {
                Variable v = new Variable();
                v.nombre = var.nombre;
                v.tipo = var.tipo;
                v.valor = var.valor;
                v.visibilidad = var.visibilidad;
                v.nivel = nivelAmbito;
                v.ambito = pilaAmbito.peek();
                v.als = nombre;
                v.aux = nombre() + "." + nombre;
                listaVariables.add(v);
            }
        }
    }
}
