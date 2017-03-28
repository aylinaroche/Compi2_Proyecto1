package Graphik.Ejecutar;

import java.util.ArrayList;

public class RecorridoGuardar {

    public static ArrayList parametros = new ArrayList();

    public Object Recorrido(NodoG raiz) {
        Object result = null;
        // Nodo nodo = null;
        if (raiz != null) {
            switch (raiz.texto) {
                case "INICIO":
                    result = Recorrido(raiz.hijos[0]);
                    break;
                case "INSTRUCCIONES":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            result = Recorrido(raiz.hijos[0]);
                            break;
                        case 2:
                            result = Recorrido(raiz.hijos[0]);
                            result = Recorrido(raiz.hijos[1]);
                            break;
                    }
                    break;
                case "GLOBAL":
                    result = Recorrido(raiz.hijos[0]);
                    break;
                case "PRINCIPAL":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            Metodo_FuncionG.agregarMF("inicio", "vacio", raiz.hijos[0], "publico", parametros);
                            break;
                    }
                    break;
                case "METODO":
                    RecorridoEjecutar e = new RecorridoEjecutar();
                    String tipo = e.Recorrido(raiz.hijos[0]).toString();
                    String id = raiz.hijos[1].texto;
                    String visible = "";
                    switch (raiz.cantidadHijos) {
                        case 8:
                            Object v = e.Recorrido(raiz.hijos[4]);
                            visible = v.toString();
                            Metodo_FuncionG.agregarMF(id, tipo, raiz.hijos[6], raiz.hijos[4].texto, Metodo_FuncionG.parametros);
                            break;
                        case 9:
                            v = e.Recorrido(raiz.hijos[5]);
                            visible = v.toString();
                            Recorrido(raiz.hijos[3]);
                            Metodo_FuncionG.agregarMF(id, tipo, raiz.hijos[7], raiz.hijos[5].texto, Metodo_FuncionG.parametros);
                            break;
                    }
                    Metodo_FuncionG.parametros.clear();

                    break;
                case "PARAMETROS":
                    RecorridoEjecutar c = new RecorridoEjecutar();
                    
                    switch (raiz.cantidadHijos) {
                        case 2:
                            tipo = c.Recorrido(raiz.hijos[0]).toString();
                            Metodo_FuncionG.agregarParametro(tipo, raiz.hijos[1].texto);
                            break;
                        case 3:
                            Recorrido(raiz.hijos[0]);
                            tipo = c.Recorrido(raiz.hijos[1]).toString();
                            Metodo_FuncionG.agregarParametro(tipo, raiz.hijos[2].texto);
                            break;
                    }
                    break;
                case "VARIABLE":
                    switch (raiz.cantidadHijos) {
                        case 4:
                            VariableG.pilaAmbito.push("Global");
                            RecorridoEjecutar r = new RecorridoEjecutar();
                            r.Recorrido(raiz);
                            VariableG.pilaAmbito.pop();
                            break;
                    }
                    break;
                case "DATOS":
                    switch (raiz.cantidadHijos) {
                        case 2:
                            Metodo_FuncionG.agregarMF("datos", "vacio", raiz.hijos[1], "publico", parametros);
                            break;
                    }
                    break;
            }
        }
        return result;
    }

}
