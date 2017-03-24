package Graphik.Ejecutar;

import Graphik.ALS;
import static Graphik.Ejecutar.VariableG.nivelAmbito;
import static Graphik.Ejecutar.VariableG.pilaAmbito;
import java.util.ArrayList;
import java.util.Arrays;

public class RecorridoEjecutar {

    public static String valorSwitch = "";
    public static String lista = "";
    public static ArrayList variables = new ArrayList();
    public static Boolean retornar = false, continuar = false, salir = false;
    public static Boolean asignarArreglo = false;
    public static int contador = 0;
    //
    //
    public static int tamanio[] = new int[10];
    public static ArrayList valores = new ArrayList();
    public static String visible = "";
    public static String tipo = "";
    public static String var = "";
    public static String[] vars;
    public static Object asignar = "";
    public static String tam = "";

    public Object Recorrido(NodoG raiz) {
        Object result = null;
        // Nodo nodo = null;
        if (raiz != null) {
            switch (raiz.texto) {
                case "INICIO":
                    result = Recorrido(raiz.hijos[0]).toString();
                    break;
                case "ENTRADA":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            result = Recorrido(raiz.hijos[0]).toString();
                            break;
                        case 2:
                            result = Recorrido(raiz.hijos[0]).toString();
                            result = Recorrido(raiz.hijos[1]).toString();
                            break;
                    }
                    break;
                case "IMPORT":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            result = Recorrido(raiz.hijos[0]).toString();
                            break;
                        case 2:
                            result = Recorrido(raiz.hijos[0]).toString();
                            result = Recorrido(raiz.hijos[1]).toString();

                            break;
                    }
                    break;
                case "INSTRUCCIONES":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            result = Recorrido(raiz.hijos[0]).toString();
                            break;
                        case 2:
                            result = Recorrido(raiz.hijos[0]).toString();
                            if (salir == false && continuar == false && retornar == false) {
                                result = Recorrido(raiz.hijos[1]);
                            }
                            break;
                    }
                    break;
                case "GLOBAL":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            result = Recorrido(raiz.hijos[0]);
                            break;
                    }
                    break;
                case "INSTRUCCION":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            result = Recorrido(raiz.hijos[0]);

                            break;
                        case 2:
                            result = Recorrido(raiz.hijos[0]);
                            if (salir == false && continuar == false && retornar == false) {
                                result = Recorrido(raiz.hijos[1]);
                            }
                            break;
                    }
                    break;
                case "OPCION":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            if (salir == false && continuar == false && retornar == false) {
                                result = Recorrido(raiz.hijos[0]);
                            }
                            break;
                        case 2:
                            switch (raiz.hijos[0].texto) {
                                case "INSTANCIA":
                                    result = Recorrido(raiz.hijos[0]).toString();
                                    break;
                                case "Continuar":
                                    continuar = true;
                                    break;
                                case "Salir":
                                    salir = true;
                                    break;
                                case "retornar":
                                    retornar = true;
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 3:
                            retornar = true;
                            result = Recorrido(raiz.hijos[1]);
                            break;
                    }
                    break;
                case "VISIBILIDAD":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            result = raiz.hijos[0].texto;
                            break;
                        case 2:
                            result = Recorrido(raiz.hijos[1]);
                            break;
                    }
                    break;
                case "TIPO":
                    result = raiz.hijos[0].texto;
                    break;
                case "VARIABLE":
                    //  System.out.println("Hola");
                    switch (raiz.cantidadHijos) {
                        case 4:
                            tipo = Recorrido(raiz.hijos[1]).toString();
                            Recorrido(raiz.hijos[2]);
                            if (raiz.hijos[2].texto.equals("MasVARIABLE")) {
                                for (int i = 0; i < variables.size(); i++) {
                                    Variable v = (Variable) variables.get(i);
                                    VariableG.crearVariable(tipo, v.nombre, v.valor, v.visibilidad);
                                }
                            } else {
                                for (int i = 0; i < variables.size(); i++) {
                                    Variable v = (Variable) variables.get(i);
                                    VariableG.crearVariable(tipo, v.nombre, v.valor, v.visibilidad, v.tamanio);
                                }
                            }
                            variables.clear();
                    }
                    break;

                case "MasVARIABLE":
                    switch (raiz.cantidadHijos) {
                        case 2:
                            Variable v1 = new Variable();
                            v1.nombre = raiz.hijos[0].texto;
                            v1.visibilidad = Recorrido(raiz.hijos[1]).toString();
                            variables.add(v1);
                            break;
                        case 3:
                            Variable v2 = new Variable();
                            v2.nombre = raiz.hijos[0].texto;
                            v2.valor = Recorrido(raiz.hijos[1]);
                            v2.visibilidad = Recorrido(raiz.hijos[2]).toString();
                            variables.add(v2);
                            break;
                        case 4:
                            Recorrido(raiz.hijos[0]);
                            Variable v3 = new Variable();
                            v3.nombre = raiz.hijos[2].texto;
                            v3.visibilidad = Recorrido(raiz.hijos[3]).toString();
                            variables.add(v3);
                            break;
                        case 5:
                            Recorrido(raiz.hijos[0]);
                            Variable v4 = new Variable();
                            v4.nombre = raiz.hijos[2].texto;
                            v4.valor = Recorrido(raiz.hijos[3]);
                            v4.visibilidad = Recorrido(raiz.hijos[4]).toString();
                            variables.add(v4);
                            break;
                    }
                    break;
                case "MasMATRIZ":
                    switch (raiz.cantidadHijos) {
                        case 3:
                            Variable v1 = new Variable();
                            v1.nombre = raiz.hijos[0].texto;
                            Recorrido(raiz.hijos[1]);
                            v1.tamanio = tamanio;
                            v1.visibilidad = Recorrido(raiz.hijos[2]).toString();
                            v1.valor = valores;
                            variables.add(v1);
                            break;
                        case 4:
                            Variable v2 = new Variable();
                            v2.nombre = raiz.hijos[0].texto;
                            Recorrido(raiz.hijos[1]);
                            v2.tamanio = tamanio;
                            v2.valor = Recorrido(raiz.hijos[2]);
                            v2.visibilidad = Recorrido(raiz.hijos[3]).toString();
                            variables.add(v2);
                            break;
                        case 5:
                            Recorrido(raiz.hijos[0]);
                            Variable v3 = new Variable();
                            v3.nombre = raiz.hijos[2].texto;
                            v3.tamanio = tamanio;
                            v3.visibilidad = Recorrido(raiz.hijos[4]).toString();
                            v3.valor = valores;
                            variables.add(v3);
                            break;
                        case 6:
                            Recorrido(raiz.hijos[0]);
                            Variable v4 = new Variable();
                            v4.nombre = raiz.hijos[2].texto;
                            v4.tamanio = tamanio;
                            v4.valor = Recorrido(raiz.hijos[4]);
                            v4.visibilidad = Recorrido(raiz.hijos[5]).toString();
                            variables.add(v4);
                            break;
                    }
                    tamanio = new int[10];
                    break;
                case "ASIGNACION":
                    switch (raiz.cantidadHijos) {
                        case 2:
                            String id = raiz.hijos[0].texto;
                            asignar = Recorrido(raiz.hijos[1]);
                            VariableG.asignarValor(id, asignar);
                            break;
                        case 4:
                            asignarArreglo = true;
                            ArrayList coordenada = (ArrayList) Recorrido(raiz.hijos[1]);
                            asignar = Recorrido(raiz.hijos[2]);
                            VariableG.asignarValorArreglo(raiz.hijos[0].texto, coordenada, asignar);
                            asignarArreglo = false;
                            break;
                    }
                    break;
                case "MATRIZ":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            contador = 0;
                            tamanio[contador] = 0;
                            result = tamanio;
                            contador++;
                            break;
                        case 2:
                            Recorrido(raiz.hijos[0]);
                            tamanio[contador] = 0;
                            contador++;
                            break;
                        case 3:
                            contador = 0;
                            result = Recorrido(raiz.hijos[1]);
                            int v = (Integer) result;
                            if (result instanceof Double) {
                                v = (int) ((Double) result).doubleValue();
                            }
                            tamanio[contador] = v;
                            contador++;
                            break;
                        case 4:
                            Recorrido(raiz.hijos[0]);
                            result = Recorrido(raiz.hijos[2]);
                            int val = (Integer) result;
                            if (result instanceof Double) {
                                val = (int) ((Double) result).doubleValue();
                            }
                            tamanio[contador] = val;
                            break;
                    }
                    break;
                case "ASIGNAR":
                    switch (raiz.cantidadHijos) {
                        case 2:
                            result = Recorrido(raiz.hijos[1]);
                            break;
                    }
                    break;
                case "ValorMATRIZ":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            result = Recorrido(raiz.hijos[0]);
                            break;
                        case 2:
                            result = Recorrido(raiz.hijos[0]);
                            ArrayList lista1 = (ArrayList) result;
                            result = Recorrido(raiz.hijos[1]);
                            ArrayList lista2 = (ArrayList) result;
                            for (int i = 0; i < lista2.size(); i++) {
                                lista1.add((Object) lista2.get(i));
                            }
                            result = lista1;
                            break;
                        case 3:
                            result = Recorrido(raiz.hijos[1]);
                            //result = valores;
                            break;
                    }
                    break;
                case "IF":
                    String condicion = "";
                    pilaAmbito.push("if");
                    nivelAmbito += 1;
                    switch (raiz.cantidadHijos) {
                        case 7:
                            condicion = Recorrido(raiz.hijos[2]).toString();
                            if (condicion.equals("true")) { //Si es true, hacer istruccion
                                Recorrido(raiz.hijos[5]);
                            }
                            break;
                        case 8:
                            condicion = Recorrido(raiz.hijos[2]).toString();
                            if (condicion.equals("true")) { //Si es true, hacer istruccion
                                Recorrido(raiz.hijos[5]);
                            } else {
                                Recorrido(raiz.hijos[7]);
                            }
                            break;
                    }
                    VariableG.eliminarVariable();
                    pilaAmbito.pop();
                    nivelAmbito -= 1;

                    break;
                case "ELSE":
                    switch (raiz.cantidadHijos) {
                        case 4:
                            Recorrido(raiz.hijos[2]);
                            break;
                    }
                    break;
                case "CICLO":
                    pilaAmbito.push("Ciclo");
                    nivelAmbito += 1;
                    switch (raiz.cantidadHijos) {
                        case 7:
                            boolean w = false;
                            result = Recorrido(raiz.hijos[2]);
                            w = result.toString().equals("true");
                            while (w) {
                                result = Recorrido(raiz.hijos[2]).toString();
                                if (result.toString().equals("true")) {
                                    Recorrido(raiz.hijos[5]);
                                    w = true;
                                } else {
                                    w = false;
                                    break;
                                }
                            }
                            break;
                        case 9:
                            Recorrido(raiz.hijos[2]);
                            result = Recorrido(raiz.hijos[6]).toString();
                            w = result.toString().equals("true");
                            //   w = true;
                            while (w) {
                                Recorrido(raiz.hijos[2]);
                                result = Recorrido(raiz.hijos[6]).toString();
                                if (result.toString().equals("true")) {
                                    w = true;
                                } else {
                                    w = false;
                                    break;
                                }
                            }
                            break;
                    }
                    pilaAmbito.pop();
                    VariableG.eliminarVariable();
                    nivelAmbito -= 1;

                    break;
                case "SWITCH":
                    pilaAmbito.push("switch");
                    nivelAmbito += 1;
                    switch (raiz.cantidadHijos) {
                        case 7:
                            valorSwitch = Recorrido(raiz.hijos[2]).toString();
                            Recorrido(raiz.hijos[5]);
                            break;
                        case 8:
                            valorSwitch = Recorrido(raiz.hijos[2]).toString();
                            result = Recorrido(raiz.hijos[5]).toString();
                            if (result.equals("false")) { //Si es true, hacer istruccion
                                Recorrido(raiz.hijos[6]);
                            }
                            break;
                    }
                    pilaAmbito.pop();
                    VariableG.eliminarVariable();
                    nivelAmbito -= 1;

                    break;
                case "CASO":
                    switch (raiz.cantidadHijos) {
                        case 4:
                            String val = Recorrido(raiz.hijos[1]).toString();
                            result = "false";
                            if (val.equals(valorSwitch)) {
                                Recorrido(raiz.hijos[3]);
                                result = "true";
                            }

                            break;
                        case 5:
                            result = Recorrido(raiz.hijos[0]).toString();
                            if (result.equals("false")) {
                                val = Recorrido(raiz.hijos[2]).toString();
                                if (val.equals(valorSwitch)) {
                                    Recorrido(raiz.hijos[4]);
                                    result = "true";
                                } else {
                                    try {
                                        double a = Double.parseDouble(val);
                                        double b = Double.parseDouble(valorSwitch);
                                        if (a == b) {
                                            Recorrido(raiz.hijos[4]);
                                            result = "true";
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Error ss = " + e);
                                    }
                                }
                            }
                            break;
                    }
                case "DEFECTO":
                    Recorrido(raiz.hijos[2]);
                    break;
                case "PARA": {
                    pilaAmbito.push("For");
                    nivelAmbito += 1;
                    Boolean f = false;
                    switch (raiz.cantidadHijos) {

                        case 11:
                            Recorrido(raiz.hijos[2]);
                            condicion = Recorrido(raiz.hijos[4]).toString();
                            f = "true".equals(condicion);
                            int limite = 0;
                            while (f) {
                                salir = false;
                                continuar = false;
                                Recorrido(raiz.hijos[9]);//accion
                                Recorrido(raiz.hijos[6]); //i++
                                condicion = Recorrido(raiz.hijos[4]).toString();
                                f = "true".equals(condicion);
                                limite += 1;
                                if (limite == 10000) {
                                    System.out.println("Limite!");
                                    break;
                                }
                                if (salir == true) {
                                    f = false;
                                }
                                VariableG.eliminarVariable();

                            }
                            salir = false;
                            continuar = false;
                            VariableG.eliminarVariable();
                            pilaAmbito.pop();
                            nivelAmbito -= 1;

                            break;
                        case 12:
                            VariableG.asignarValor(raiz.hijos[2].texto, Recorrido(raiz.hijos[3]));
                            condicion = Recorrido(raiz.hijos[5]).toString();
                            f = "true".equals(condicion);
                            limite = 0;
                            while (f) {
                                salir = false;
                                continuar = false;
                                Recorrido(raiz.hijos[10]);//accion
                                Recorrido(raiz.hijos[7]); //i++
                                condicion = Recorrido(raiz.hijos[5]).toString();
                                f = "true".equals(condicion);
                                limite += 1;
                                if (limite == 10000) {
                                    System.out.println("Limite!");
                                    break;
                                }
                                if (salir == true) {
                                    f = false;
                                }
                                VariableG.eliminarVariable();
                            }
                            salir = false;
                            continuar = false;
                            pilaAmbito.pop();
                            VariableG.eliminarVariable();
                            nivelAmbito -= 1;
                            break;

                    }
                    break;
                }
                case "INSTANCIA":
                    switch (raiz.cantidadHijos) {
                        case 4:
                            if ("llamar".equals(raiz.hijos[0].texto)) {
                                result = Metodo_FuncionG.buscarMetodo(raiz.hijos[1].texto, variables, VariableG.nombreALS.peek());
                            } else { //llamar HK
                                result = Haskell.Metodo_FuncionHK.buscarMetodo(raiz.hijos[1].texto, variables);
                            }
                            break;
                        case 5:
                            result = Recorrido(raiz.hijos[3]);
                            ArrayList parametro = (ArrayList) result;
                            if ("llamar".equals(raiz.hijos[0].texto)) {
                                result = Metodo_FuncionG.buscarMetodo(raiz.hijos[1].texto, parametro, VariableG.nombreALS.peek());
                            } else { //llamar HK
                                result = Haskell.Metodo_FuncionHK.buscarMetodo(raiz.hijos[1].texto, parametro);
                            }
                            parametro.clear();
                            break;
                        case 6:
                            String als = ALS.tipoALS(raiz.hijos[1].texto);
                            result = Metodo_FuncionG.buscarMetodo(raiz.hijos[3].texto, variables, als);
                            break;
                        case 7:
                            result = Recorrido(raiz.hijos[5]);
                            ArrayList parametro2 = (ArrayList) result;
                            als = ALS.tipoALS(raiz.hijos[1].texto);
                            result = Metodo_FuncionG.buscarMetodo(raiz.hijos[3].texto, parametro2, als);
                            parametro2.clear();
                            break;
                    }
                    retornar = false; //????????????????
                    salir = false;
                    variables.clear();
                    break;
                case "VALORES":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            result = (Recorrido(raiz.hijos[0]));
                            ArrayList valor = new ArrayList();
                            valor.add(result);
                            result = valor;
                            break;
                        case 3:
                            result = Recorrido(raiz.hijos[0]);
                            ArrayList valor2 = (ArrayList) result;
                            result = Recorrido(raiz.hijos[2]);
                            valor2.add(result);
                            result = valor2;
                            break;
                    }
                    break;
                case "ARREGLO":
                    switch (raiz.cantidadHijos) {
                        case 3:
                            ArrayList coord = new ArrayList();
                            coord.add(Recorrido(raiz.hijos[1]));
                            result = coord;
                            break;
                        case 4:
                            ArrayList coord2 = (ArrayList) Recorrido(raiz.hijos[0]);
                            coord2.add(Recorrido(raiz.hijos[2]));
                            result = coord2;
                            break;
                    }
                    break;
                case "CrearASL":
                    switch (raiz.cantidadHijos) {
                        case 8:
                            if (raiz.hijos[0].texto.equals(raiz.hijos[4].texto)) {
                                ALS.buscarALS(raiz.hijos[0].texto);
                                ALS.agregarVariableALS(raiz.hijos[0].texto, raiz.hijos[1].texto);
                            } else {
                                paradigmas.ReporteError.agregarErrorGK(raiz.hijos[0].texto, "Error Semantico", "Error de Sintaxis", 0, 0);
                            }
                            break;
                    }
                    break;
                case "AccesoASL":
                    switch (raiz.cantidadHijos) {
                        case 2:
                            result = (Recorrido(raiz.hijos[0]));
                            break;
                        case 3:
                            String als = ALS.tipoALS(raiz.hijos[0].texto);
                            result = VariableG.obtenerVariable(raiz.hijos[2].texto, als);
                            break;
                        case 5:
                            als = ALS.tipoALS(raiz.hijos[0].texto);
                            result = Metodo_FuncionG.buscarMetodo(raiz.hijos[2].texto, variables, als);
                            break;
                        case 7:
                            result = Recorrido(raiz.hijos[4]);
                            ArrayList parametro2 = (ArrayList) result;
                            als = ALS.tipoALS(raiz.hijos[0].texto);
                            result = Metodo_FuncionG.buscarMetodo(raiz.hijos[2].texto, parametro2, als);
                            parametro2.clear();
                    }
                    break;
                case "ATRIBUTO":
                    switch (raiz.cantidadHijos) {
                        case 2:
                            result = (Recorrido(raiz.hijos[0]));
                            break;
                        case 3:
                            String als = ALS.tipoALS(raiz.hijos[0].texto);
                            result = VariableG.obtenerVariable(raiz.hijos[2].texto, als);
                            break;
                        case 5:
                            als = ALS.tipoALS(raiz.hijos[0].texto);
                            result = Metodo_FuncionG.buscarMetodo(raiz.hijos[2].texto, variables, als);
                            break;
                        case 7:
                            result = Recorrido(raiz.hijos[4]);
                            ArrayList parametro2 = (ArrayList) result;
                            als = ALS.tipoALS(raiz.hijos[0].texto);
                            result = Metodo_FuncionG.buscarMetodo(raiz.hijos[2].texto, parametro2, als);
                            parametro2.clear();
                    }
                    break;
                case "IMPRIMIR":
                    result = Recorrido(raiz.hijos[2]);
                    String imp = result.toString();
                    if (imp != null) {
                        paradigmas.Atributos.imprimirGraphik.add(imp);
                        System.out.println(imp);
                    }
                    break;
                case "OP":
                    result = Recorrido(raiz.hijos[0]);
                    break;
                case "E":
                    result = Operacion.resolverOperacion(raiz);
                    break;
            }
        }
        return result;
    }

}
