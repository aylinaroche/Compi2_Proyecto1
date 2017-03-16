package Haskell;

import Haskell.Ejecutar.*;
import java.util.ArrayList;

public class Metodo_FuncionHK {

    public static ArrayList metodoFuncionHK = new ArrayList();
    public static ArrayList parametros = new ArrayList();

    public static void agregarMF(String n, Nodo nodo, ArrayList parametro) {
        MF mf = new MF();
        mf.nombre = n;
        mf.nodo = nodo;
        mf.parametro = (ArrayList) parametro.clone();
        metodoFuncionHK.add(mf);
    }

    public static void agregarParametro(String n, String t) {
        Parametro p = new Parametro();
        p.valor = n;
        p.tipo = t;
        //p.nombre
        parametros.add(p);
    }

    public static String buscarMetodo(String id, ArrayList parametro) {
        String retorno = "";
        for (int i = 0; i < metodoFuncionHK.size(); i++) {
            MF mf = (MF) metodoFuncionHK.get(i);

            if (mf.nombre.equals(id)) {
                VariableHK.pilaAmbito.push(id);
                VariableHK.nivelAmbito++;
                if (parametro.isEmpty() && mf.parametro.isEmpty()) {
                    parametro.clear();
                    RecorridoHK r = new RecorridoHK();
                    retorno = r.Recorrido(mf.nodo);
                    return retorno;
                }
                if (parametro.size() == mf.parametro.size()) {
                    for (int j = 0; j < parametro.size(); j++) {
                        String p = (String) mf.parametro.get(j);
                        Parametro p2 = (Parametro) parametro.get(j);
                        VariableHK.crearVariable(p, p2.valor, p2.tipo);
                    }
                    parametro.clear();
                    RecorridoHK r = new RecorridoHK();
                    retorno = r.Recorrido(mf.nodo);
                    VariableHK.eliminarVariable();
                    return retorno;
                }
                VariableHK.nivelAmbito--;
                VariableHK.pilaAmbito.pop();
            }
        }
        paradigmas.ReporteError.agregarError(id, "Error Semantico", "No se ha encontrado el metodo", 0, 0);

        return "";
    }
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
    public String valor;
}
