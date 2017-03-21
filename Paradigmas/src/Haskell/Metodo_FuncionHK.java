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
        //      System.out.println("P = " + n);
        if (n.length() > 1) {
            if (n.substring(n.length() - 1, n.length()).equals(",")) {
                n = n.substring(0, n.length() - 1);
            }
        }
        Parametro p = new Parametro();
        p.valor = n;
        p.tipo = t;
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
                    VariableHK.nivelAmbito--;
                    VariableHK.pilaAmbito.pop();
                    return retorno;
                }
                if (parametro.size() == mf.parametro.size()) {
                    for (int j = 0; j < parametro.size(); j++) {
                        String p = (String) mf.parametro.get(j);
                        Parametro p2 = (Parametro) parametro.get(j);
                        String dato[] = p2.valor.split(",");
                        if (dato.length > 1) {
                            MatrizHK.crearMatriz(p, p2.valor);
                        } else {
                            VariableHK.crearVariable(p, p2.valor, p2.tipo);
                        }
                    }
                    parametro.clear();
                    RecorridoHK r = new RecorridoHK();
                    retorno = r.Recorrido(mf.nodo);
                    VariableHK.eliminarVariable();
                    VariableHK.nivelAmbito--;
                    VariableHK.pilaAmbito.pop();
                    return retorno;
                }

                VariableHK.nivelAmbito--;
                VariableHK.pilaAmbito.pop();

            }
        }
        paradigmas.ReporteError.agregarError(id, "Error Semantico", "No se ha encontrado el metodo", 0, 0);

        return "";
    }

    public static void agregarMatriz(String valor, ArrayList tipo, int cantidad) {
        //  System.out.println(valor);
        if (valor.substring(0, 1).equals(";")) {
            valor = valor.substring(1, valor.length());
        }
        String lista[] = valor.split(";");
        if (tipo.isEmpty()) {
            String dato[] = valor.split(",");
            for (int i = 0; i < dato.length; i++) {
                agregarParametro(dato[i], "");
            }
        } else if (lista.length == 0 && tipo.size() == 1) {
            agregarParametro(valor, "");
        } else if (lista.length <= tipo.size()) {
            agregarParametro(valor, "");
        } else if (lista.length > tipo.size()) {
            int i = 0;
            for (i = 0; i < tipo.size(); i++) {
                String v = lista[i];
                agregarParametro(v, "");
                cantidad--;
            }
            if (cantidad == 1) {
                agregarParametro(lista[i], "");
                return;
            }
            String dato[] = lista[i].split(",");
            for (i = 0; i < dato.length; i++) {
                agregarParametro(dato[i], "");
            }
        }
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
