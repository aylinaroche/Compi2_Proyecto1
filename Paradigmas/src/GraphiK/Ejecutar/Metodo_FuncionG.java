package Graphik.Ejecutar;

import java.util.ArrayList;

public class Metodo_FuncionG {

    public static ArrayList metodoFuncionG = new ArrayList();
    public static ArrayList parametros = new ArrayList();

    public static void agregarMF(String n, NodoG nodo, ArrayList parametro) {
        MF mf = new MF();
        mf.nombre = n;
        mf.nodo = nodo;
        mf.parametro = (ArrayList) parametro.clone();
        metodoFuncionG.add(mf);
    }

    public static void agregarParametro(String t, String n) {
        Parametro p = new Parametro();
        p.tipo = t;
        p.nombre = n;
        parametros.add(p);
    }

    public static Object buscarMetodo(String id, ArrayList parametro) {
        Object retorno = "";
        for (int i = 0; i < metodoFuncionG.size(); i++) {
            MF mf = (MF) metodoFuncionG.get(i);

            if (mf.nombre.equals(id)) {
                VariableG.pilaAmbito.push(id);
                VariableG.nivelAmbito++;
                if (parametro.isEmpty() && mf.parametro.isEmpty()) {
                    parametro.clear();
                    RecorridoG r = new RecorridoG();
                    retorno = r.Recorrido(mf.nodo);

                    VariableG.nivelAmbito--;
                    VariableG.pilaAmbito.pop();
                    return retorno;
                }
                if (parametro.size() == mf.parametro.size()) {
                    for (int j = 0; j < parametro.size(); j++) {
                        Parametro p = (Parametro) mf.parametro.get(j);
                        String p2 = (String) parametro.get(j);
                        VariableG.crearVariable(p.tipo, p.nombre, p2, "public");
                    }
                    parametro.clear();
                    RecorridoG r = new RecorridoG();
                    retorno = r.Recorrido(mf.nodo);
                    VariableG.eliminarVariable();
                    VariableG.nivelAmbito--;
                    VariableG.pilaAmbito.pop();

                    return retorno;
                }

            }
        }
        paradigmas.ReporteError.agregarError(id, "Error Semantico", "No se ha encontrado el metodo", 0, 0);

        return "";
    }

    public static String buscarMain() {
        Object retorno = "";
        for (int i = 0; i < metodoFuncionG.size(); i++) {
            MF mf = (MF) metodoFuncionG.get(i);

            if (mf.nombre.equals("inicio")) {
                VariableG.pilaAmbito.push("inicio");
                VariableG.nivelAmbito++;
                RecorridoG r = new RecorridoG();
                retorno = r.Recorrido(mf.nodo);
                VariableG.nivelAmbito--;
                VariableG.pilaAmbito.pop();
                return "";
            }
        }
        paradigmas.ReporteError.agregarError("inicio", "Error Semantico", "No se ha encontrado el metodo principal", 0, 0);

        return "";
    }
}

class MF {

    public String nombre;
    public String tipo;
    public String retorno;
    public NodoG nodo;
    public ArrayList parametro;
}

class Parametro {

    public String nombre;
    public String tipo;
    public String valor;
}
