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
                    String tipo = raiz.hijos[0].texto;
                    String id = raiz.hijos[1].texto;

                    switch (raiz.cantidadHijos) {
                        case 8:
                            Metodo_FuncionG.agregarMF(id, tipo, raiz.hijos[6], raiz.hijos[4].texto, Metodo_FuncionG.parametros);
                            Metodo_FuncionG.parametros.clear();
                            break;
                        case 9:
                            Metodo_FuncionG.agregarMF(id, tipo, raiz.hijos[7], raiz.hijos[5].texto, Metodo_FuncionG.parametros);
                            Metodo_FuncionG.parametros.clear();
                            break;
                    }
                    break;
                case "PARAMETROS":
                    switch (raiz.cantidadHijos) {
                        case 2:
                            Metodo_FuncionG.agregarParametro(raiz.hijos[0].texto, raiz.hijos[1].texto);
                            break;
                        case 3:
                            Recorrido(raiz.hijos[0]);
                            Metodo_FuncionG.agregarParametro(raiz.hijos[1].texto, raiz.hijos[2].texto);
                            break;
                    }
                    break;
                case "VARIABLE":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            VariableG.variableGlobal.add(raiz.hijos[0]);
                            break;
                    }
                    break;
                case "DATOS":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            Metodo_FuncionG.agregarMF("datos", "vacio", raiz.hijos[0], "publico", parametros);
                            break;
                    }
                    break;
            }
        }
        return result;
    }

}
