package Haskell.Ejecutar;

import Haskell.Metodo_FuncionHK;

public class RecorridoHK {

    public static String valorSwitch = "";
    public static String lista = "";
    public static String ultimoValor = "";
    public static String caso = "";
    public static Boolean boolLista = false;

    public String Recorrido(Nodo raiz) {
        String result = null;
        // Nodo nodo = null;
        if (raiz != null) {
            switch (raiz.texto) {
                case "INICIO":
                    result = Recorrido(raiz.hijos[0]);
                    System.out.println("IMPRIMIR:");
                    System.out.println(ultimoValor);
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
                case "INSTRUCCION":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            result = Recorrido(raiz.hijos[0]);
                            if (result != null) {
                                System.out.println(" * " + result);
                                ultimoValor = result;
                            }
                            break;
                    }
                    result = ultimoValor;
                    break;
                case "LISTA":
                    switch (raiz.cantidadHijos) {
                        case 4:
                            result = Recorrido(raiz.hijos[3]);
                            if (result == null) {
                                result = "";
                            }
                            MatrizHK.crearMatriz(raiz.hijos[1].texto, result);
                            break;
                    }
                    break;
                case "MATRIZ":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            result = Recorrido(raiz.hijos[0]);
                            break;
                        case 3:
                            if (raiz.hijos[0].texto.equals("MATRIZ")) {
                                String Dim1 = Recorrido(raiz.hijos[0]);
                                String Dim2 = Recorrido(raiz.hijos[2]);
                                result = Dim1 + ";" + Dim2;
                            } else {
                                result = Recorrido(raiz.hijos[1]);
                            }
                            break;
                    }
                    break;
                case "ELEMENTO":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            lista = Recorrido(raiz.hijos[0]) + ",";
                            result = lista;
                            break;
                        case 2:
                            Recorrido(raiz.hijos[0]);
                            lista += Recorrido(raiz.hijos[1]) + ",";
                            result = lista;
                            break;
                    }
                    break;
                case "PARAMETRO":
                    switch (raiz.cantidadHijos) {
                        case 1:
                            result = Recorrido(raiz.hijos[0]);
                            break;
                        case 3:
                            if (raiz.hijos[0].texto.equals("PARAMETRO")) {
                                String Dim1 = Recorrido(raiz.hijos[0]);
                                String Dim2 = Recorrido(raiz.hijos[2]);
                                result = Dim1 + ";" + Dim2;
                            } else {
                                result = Recorrido(raiz.hijos[1]) + "/";
                                boolLista = true;
                            }
                            break;
                    }
                    break;
                case "LLAMADA":
                    switch (raiz.cantidadHijos) {
                        case 2:
                            result = Recorrido(raiz.hijos[1]);
                            System.out.println("RESULT");
                            System.out.println(result);
                            System.out.println(Operacion.tipo);
                            String dato[] = result.split(",");
                            for (int i = 0; i < dato.length; i++) {
                                Metodo_FuncionHK.agregarParametro(dato[i], "");
                            }
                            result = Haskell.Metodo_FuncionHK.buscarMetodo(raiz.hijos[0].texto, Metodo_FuncionHK.parametros);
                            Metodo_FuncionHK.parametros.clear();
                            break;
                        case 4:
                            result = Recorrido(raiz.hijos[2]);
                            dato = result.split(",");
                            for (int i = 0; i < dato.length; i++) {
                                Metodo_FuncionHK.agregarParametro(dato[i], "");
                            }
                            result = Haskell.Metodo_FuncionHK.buscarMetodo(raiz.hijos[0].texto, Metodo_FuncionHK.parametros);
                            Metodo_FuncionHK.parametros.clear();
                            break;
                    }

                    break;
                case "CALCULAR":
                    result = Recorrido(raiz.hijos[1]);
                    break;
                case "OPERACION_LISTA":
                    switch (raiz.cantidadHijos) {
                        case 2:
                            if (raiz.hijos[0].texto.equals("NOMBRE_OP")) {
                                String ope = Recorrido(raiz.hijos[0]);
                                String m = Recorrido(raiz.hijos[1]);
                                result = MatrizHK.operacionMatriz(ope, m, "");
                            }
                            break;
                    }
                    break;
                case "NOMBRE_OP":
                    result = raiz.hijos[0].texto;
                    break;
                case "POSICION_LISTA":
                    switch (raiz.cantidadHijos) {
                        case 2:
                            String m = Recorrido(raiz.hijos[1]);
                            result = MatrizHK.posicion(raiz.hijos[0].texto, m);
                            break;
                    }
                    break;
                case "POSICION":
                    switch (raiz.cantidadHijos) {
                        case 2:
                            lista = Recorrido(raiz.hijos[1]);
                            result = lista += "!";
                            break;
                        case 3:
                            Recorrido(raiz.hijos[0]);
                            lista += Recorrido(raiz.hijos[2]);
                            result = lista;
                            break;
                    }
                    break;
                case "IF":
                    String condicion = "";
                    switch (raiz.cantidadHijos) {
                        case 7:
                            VariableHK.pilaAmbito.push("If");
                            VariableHK.nivelAmbito++;
                            condicion = Recorrido(raiz.hijos[1]);
                            if (condicion.equals("true")) { //Si es true, hacer istruccion
                                result = Recorrido(raiz.hijos[3]);
                            } else {
                                result = Recorrido(raiz.hijos[5]);
                            }
                            VariableHK.eliminarVariable();
                            VariableHK.nivelAmbito--;
                            VariableHK.pilaAmbito.pop();
                            break;
                    }
                    break;
                case "SWITCH":
                    switch (raiz.cantidadHijos) {
                        case 4:
                            VariableHK.pilaAmbito.push("Switch");
                            VariableHK.nivelAmbito++;
                            valorSwitch = Recorrido(raiz.hijos[1]);
                            result = Recorrido(raiz.hijos[2]);
                            if ("false".equals(caso)) {
                                try {
                                    int v = Integer.parseInt(valorSwitch);
                                    result = "0";
                                } catch (Exception e) {
                                    result = "";
                                }
                            }
                            VariableHK.eliminarVariable();
                            VariableHK.nivelAmbito--;
                            VariableHK.pilaAmbito.pop();
                            break;
                    }
                    break;
                case "CASO":
                    switch (raiz.cantidadHijos) {
                        case 4:
                            caso = "false";
                            String val = Recorrido(raiz.hijos[0]);
                            if (val.equals(valorSwitch)) {
                                result = Recorrido(raiz.hijos[2]);
                                caso = "true";
                            }
                            break;
                        case 5:
                            result = Recorrido(raiz.hijos[0]);
                            if (caso.equals("false")) {
                                val = Recorrido(raiz.hijos[1]);
                                if (val.equals(valorSwitch)) {
                                    result = Recorrido(raiz.hijos[3]);
                                    caso = "true";
                                }
                            }
                            break;
                    }
                    break;
                case "VALOR_PUNTUAL":
                    if (raiz.hijos[0].tipo.equals("numero")) {
                        result = raiz.hijos[0].texto;
                    } else {
                        result = VariableHK.obtenerValor(raiz.hijos[0].texto);
                    }
                    break;
                case "OP":
                    result = Recorrido(raiz.hijos[0]);
                    break;
                case "E":
                    result = Operacion.resolverOperacion(raiz);
                    break;

                case "EXTRAS":
                    result = Operacion.resolverExtras(raiz);
                    break;
            }
        }
        return result;
    }

}
