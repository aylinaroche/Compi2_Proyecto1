package Haskell.Ejecutar;

import Haskell.Metodo_FuncionHK;
import java.util.Arrays;

public class RecorridoHK {
    
    public static int tam = 0;
    public static String valorSwitch = "";
    public static int dimension = 0;
    public static int DimY = 0;
    public static String lista = "";
    public static String imprimir = "";
    public static String ultimoValor = "";
    
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
                    break;
                case "LISTA":
                    switch (raiz.cantidadHijos) {
                        case 4:
                        case 6:
                            result = Recorrido(raiz.hijos[3]);
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
                                String Dim1 = Recorrido(raiz.hijos[1]);
                                String Dim2 = Recorrido(raiz.hijos[5]);
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
                            dimension = 0;
                            dimension++;
                            lista = Recorrido(raiz.hijos[0]) + ",";
                            result = lista;
                            break;
                        case 2:
                            Recorrido(raiz.hijos[0]);
                            lista += Recorrido(raiz.hijos[1]);
                            result = lista;
                            dimension++;
                            break;
                    }
                    break;
                case "LLAMADA":
                    switch (raiz.cantidadHijos) {
                        case 2:
                            result = Recorrido(raiz.hijos[1]);
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
                            } else {
                                Recorrido(raiz.hijos[1]);
                            }
                            
                            break;
                    }
                    break;
                case "NOMBRE_OP":
                    result = raiz.hijos[0].texto;
                    break;
                case "POSICION":
                    switch (raiz.cantidadHijos) {
                        case 2:
                            Recorrido(raiz.hijos[1]);
                            break;
                        case 3:
                            Recorrido(raiz.hijos[0]);
                            Recorrido(raiz.hijos[2]);
                            break;
                    }
                    break;
                case "IF":
                    String condicion = "";
                    switch (raiz.cantidadHijos) {
                        case 7:
                            VariableHK.pilaAmbito.push("If");
                            condicion = Recorrido(raiz.hijos[1]);
                            if (condicion.equals("true")) { //Si es true, hacer istruccion
                                Recorrido(raiz.hijos[3]);
                            } else {
                                Recorrido(raiz.hijos[5]);
                            }
                            VariableHK.pilaAmbito.pop();
                            break;
                    }
                    break;
                case "SWITCH":
                    switch (raiz.cantidadHijos) {
                        case 4:
                            VariableHK.pilaAmbito.push("Switch");
                            valorSwitch = Recorrido(raiz.hijos[1]);
                            Recorrido(raiz.hijos[2]);
                            VariableHK.pilaAmbito.pop();
                            break;
                    }
                    break;
                case "CASO":
                    switch (raiz.cantidadHijos) {
                        case 4:
                            String val = Recorrido(raiz.hijos[0]);
                            if (val.equals(valorSwitch)) {
                                Recorrido(raiz.hijos[2]);
                                result = "true";
                            }
                            result = "false";
                            break;
                        case 5:
                            result = Recorrido(raiz.hijos[0]);
                            if (result.equals("false")) {
                                val = Recorrido(raiz.hijos[1]);
                                if (val.equals(valorSwitch)) {
                                    Recorrido(raiz.hijos[3]);
                                    result = "true";
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
