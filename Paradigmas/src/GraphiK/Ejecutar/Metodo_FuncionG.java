package Graphik.Ejecutar;

import java.util.ArrayList;

public class Metodo_FuncionG {

    public static ArrayList metodoFuncionG = new ArrayList();
    public static ArrayList parametros = new ArrayList();

    public static void agregarMF(String nombre, String tipo, NodoG nodo, String visible, ArrayList parametro) {
        MF mf = new MF();
        mf.nombre = nombre;
        mf.tipo = tipo;
        mf.nodo = nodo;
        mf.ambito = VariableG.pilaAmbito.peek();
        mf.parametro = (ArrayList) parametro.clone();
        mf.visibilidad = visible;
        mf.als = VariableG.nombreALS.peek();
        metodoFuncionG.add(mf);
        paradigmas.Atributos.crearSimboloGraphik(nombre, tipo, "Metodo/Funcion", mf.ambito, " - ");
    }

    public static void agregarParametro(String t, String n) {
        Parametro p = new Parametro();
        p.tipo = t;
        p.nombre = n;
        parametros.add(p);
    }

    public static Object buscarMetodo(String id, ArrayList parametro, String als) {
        Object retorno = "";
        for (int i = 0; i < metodoFuncionG.size(); i++) {
            MF mf = (MF) metodoFuncionG.get(i);

            if (mf.nombre.equals(id) && mf.als.equals(als)) {
                VariableG.pilaAmbito.push(id);
                VariableG.nivelAmbito++;
                VariableG.nombreALS.push(als);
                if (parametro.isEmpty() && mf.parametro.isEmpty()) {
                    parametro.clear();
                    RecorridoEjecutar r = new RecorridoEjecutar();
                    retorno = r.Recorrido(mf.nodo);

                    VariableG.nivelAmbito--;
                    VariableG.pilaAmbito.pop();
                    return retorno;
                }
                if (parametro.size() == mf.parametro.size()) {
                    for (int j = 0; j < parametro.size(); j++) {
                        Parametro p = (Parametro) mf.parametro.get(j);
                        Object p2 = (Object) parametro.get(j);
                        VariableG.crearVariable(p.tipo, p.nombre, p2, "public");
                    }
                    parametro.clear();
                    RecorridoEjecutar r = new RecorridoEjecutar();
                    retorno = r.Recorrido(mf.nodo);
                    VariableG.eliminarVariable();
                    VariableG.nivelAmbito--;
                    VariableG.pilaAmbito.pop();
                    VariableG.nombreALS.pop();

                    return retorno;
                }
            }
        }
        paradigmas.ReporteError.agregarErrorGK(id, "Error Semantico", "No se ha encontrado el metodo", 0, 0);

        return "";
    }

    public static String buscarMain() {
        for (int i = 0; i < metodoFuncionG.size(); i++) {
            MF mf = (MF) metodoFuncionG.get(i);

            if (mf.nombre.equals("inicio")) {
                VariableG.pilaAmbito.push("inicio");
                VariableG.nivelAmbito++;
                RecorridoEjecutar r = new RecorridoEjecutar();
                r.Recorrido(mf.nodo);
                VariableG.nivelAmbito--;
                VariableG.pilaAmbito.pop();
                return "";
            }
        }
        paradigmas.ReporteError.agregarErrorGK("inicio", "Error Semantico", "No se ha encontrado el metodo principal", 0, 0);
        return "";
    }
}

class MF {

    public String nombre;
    public String tipo;
    public String ambito;
    public NodoG nodo;
    public ArrayList parametro;
    public String visibilidad;
    public String als;
}

class Parametro {

    public String nombre;
    public String tipo;
    public String valor;
}
