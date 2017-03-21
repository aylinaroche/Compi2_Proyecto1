package Haskell.Ejecutar;

import java.util.Objects;

public class Operacion {

    public static String tipo;
    public static Double var1;
    public static Double var2;

    public static String resolverOperacion(Nodo nodo) {
        tipo = "variable";
        String resultado = expresion(nodo);
        //     System.out.println("El resultado es: " + resultado);
        return resultado;
    }

    private static String expresion(Nodo nodo) {

        switch (nodo.cantidadHijos) {
            case 1:
                String dato = nodo.hijos[0].texto;

                switch (dato) {
                    case "OPCION":
                    case "LLAMADA":
                    case "EXTRAS":
                    case "OPERACION_LISTA":
                    case "CALCULAR":
                    case "POSICION_LISTA":
                    case "MATRIZ":
                    case "MATRIZZ":
                    case "E":
                        RecorridoHK r = new RecorridoHK();
                        String result = r.Recorrido(nodo.hijos[0]);
                        return result;
                    case "%":
                        return RecorridoHK.ultimoValor;
                    default:
                        String tipoDato = nodo.hijos[0].tipo;
                        switch (tipoDato) {
                            case "cadena":
                                Operacion.tipo = "lista";
                                String cadena = "";
                                for (int i = 0; i < dato.length() - 1; i++) {
                                    char c = dato.charAt(i);
                                    cadena += c + ",";
                                }
                                RecorridoHK.tipo.add("Lista");
                                cadena = ";" + cadena + dato.charAt(dato.length() - 1);
                                RecorridoHK.boolLista = true;
                                return cadena;
                            case "caracter":
                                Operacion.tipo = "lista";
                                return dato;
                            case "numero":
                                Operacion.tipo = "variable";
                                return dato;
                            case "id":
                                Variable s = VariableHK.obtenerVariable(dato);
                                if (s != null) {
                                    Operacion.tipo = "variable";
                                    return s.valor;
                                } else { //Buscar en lista
                                    Matriz m = MatrizHK.obtenerMatriz(dato);
                                    if (m != null) {
                                        Operacion.tipo = "lista";
                                        RecorridoHK.tipo.add("Lista");
                                        if (m.dim2.isEmpty() || m.dim2 == null || "".equals(m.dim2)) {
                                            if (m.dim1.length() > 1) {
                                                if (m.dim1.substring(m.dim1.length() - 1, m.dim1.length()).equals(",")) {
                                                    m.dim1 = m.dim1.substring(0, m.dim1.length() - 1);
                                                }
                                            }
                                            //String sub = m.dim1.substring(0, m.dim1.length() - 1) + ";";
                                            String sub = m.dim1 + ";";
                                            return sub;
                                        } else {
                                            return m.dim1 + ";" + m.dim2;
                                        }
                                    }
                                    paradigmas.ReporteError.agregarError(dato, "Error Semantico", "No se encontro el id", 0, 0);
                                    Operacion.tipo = "variable";
                                    return "";
                                }
                            case "bool":
                                Operacion.tipo = "variable";
                                break;
                            default:
                                Operacion.tipo = "variable";
                                return "";
                        }
                }

            case 2:
                if (nodo.hijos[0].texto.equals("-")) {
                    try {
                        String E1 = expresion(nodo.hijos[1]);
                        Double n = Double.parseDouble(E1) * (-1);
                        return n.toString();
                    } catch (Exception e) {
                        System.out.println("E-()");
                    }
                } else {
                    return "";
                }

            case 3: //Nodo binario
                String resultado = "";
                String E1 = "";
                String E2 = "";
                switch (nodo.hijos[1].texto) {

                    case "+": //E+E
                        E1 = expresion(nodo.hijos[0]);
                        String c1 = tipo;
                        E2 = expresion(nodo.hijos[2]);
                        String c2 = tipo;
                        if ("variable".equals(c1) && "variable".equals(c2)) {
                            try {
                                Double v1 = Double.parseDouble(E1);
                                Double v2 = Double.parseDouble(E2);
                                Double r = v1 + v2;
                                resultado = String.valueOf(r);
                                return resultado;
                            } catch (Exception e) {
                                System.out.println("E+");
                                return "";
                            }
                        }
                        break;
                    case "-": //E-E
                        E1 = expresion(nodo.hijos[0]);
                        c1 = tipo;
                        E2 = expresion(nodo.hijos[2]);
                        c2 = tipo;
                        if ("variable".equals(c1) && "variable".equals(c2)) {
                            try {
                                Double r = Double.parseDouble(E1) - Double.parseDouble(E2);
                                resultado = String.valueOf(r);
                                return resultado;

                            } catch (Exception e) {
                                System.out.println("E-");
                                return "";
                            }
                        }
                        break;
                    case "/": //E/E
                        E1 = expresion(nodo.hijos[0]);
                        c1 = tipo;
                        E2 = expresion(nodo.hijos[2]);
                        c2 = tipo;
                        if ("variable".equals(c1) && "variable".equals(c2)) {
                            try {
                                Double r = Double.parseDouble(E1) / Double.parseDouble(E2);
                                resultado = String.valueOf(r);
                                return resultado;

                            } catch (Exception e) {
                                System.out.println("E");
                                return "";
                            }
                        }
                        break;
                    case "*": //E*E
                        E1 = expresion(nodo.hijos[0]);
                        c1 = tipo;
                        E2 = expresion(nodo.hijos[2]);
                        c2 = tipo;
                        if ("variable".equals(c1) && "variable".equals(c2)) {
                            try {
                                Double r = Double.parseDouble(E1) * Double.parseDouble(E2);
                                resultado = String.valueOf(r);
                                return resultado;

                            } catch (Exception e) {
                                System.out.println("E");
                                return "";
                            }
                        }
                        break;
                    case "'mod'": //E*E
                        E1 = expresion(nodo.hijos[0]);
                        c1 = tipo;
                        E2 = expresion(nodo.hijos[2]);
                        c2 = tipo;
                        if ("variable".equals(c1) && "variable".equals(c2)) {
                            try {
                                Double r = Double.parseDouble(E1) % Double.parseDouble(E2);
                                resultado = String.valueOf(r);
                                return resultado;

                            } catch (Exception e) {
                                System.out.println("E%");
                                return "";
                            }
                        }
                        break;
                    case "'pot'": //E*E
                        E1 = expresion(nodo.hijos[0]);
                        c1 = tipo;
                        E2 = expresion(nodo.hijos[2]);
                        c2 = tipo;
                        if ("variable".equals(c1) && "variable".equals(c2)) {
                            try {
                                Double r = Math.pow(Double.parseDouble(E1), Double.parseDouble(E2));
                                resultado = String.valueOf(r);
                                return resultado;

                            } catch (Exception e) {
                                System.out.println("E^");
                                return "";
                            }
                        }
                        break;
                    case "'sqrt'": //E*E
                        E1 = expresion(nodo.hijos[0]);
                        c1 = tipo;
                        E2 = expresion(nodo.hijos[2]);
                        c2 = tipo;
                        if ("variable".equals(c1) && "variable".equals(c2)) {
                            try {
                                Double r = Math.pow(Double.parseDouble(E1), 1 / Double.parseDouble(E2));
                                resultado = String.valueOf(r);
                                return resultado;

                            } catch (Exception e) {
                                System.out.println("E/^");
                                return "";
                            }
                        }
                        break;
                    case ">":
                        try {
                            E1 = expresion(nodo.hijos[0]);
                            c1 = tipo;
                            E2 = expresion(nodo.hijos[2]);
                            c2 = tipo;
                            if ("variable".equals(c1) && "variable".equals(c2)) {
                                var1 = Double.parseDouble(E1);
                                var2 = Double.parseDouble(E2);

                                if (var1 > var2) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            } else {
                                String r = MatrizHK.mayorMenor(E1 + ",", E2 + ",");
                                if (r.equals("true")) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("E>");
                            return "";
                        }
//  break;
                    case "<":
                        try {
                            E1 = expresion(nodo.hijos[0]);
                            c1 = tipo;
                            E2 = expresion(nodo.hijos[2]);
                            c2 = tipo;
                            if ("variable".equals(c1) && "variable".equals(c2)) {
                                var1 = Double.parseDouble(E1);
                                var2 = Double.parseDouble(E2);

                                if (var1 < var2) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            } else {
                                String r = MatrizHK.mayorMenor(E1 + ",", E2 + ",");
                                if (r.equals("true")) {
                                    return "false";
                                } else if (r.equals("false")) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("E<");
                            return "";
                        }
                    //  break;
                    case ">=":
                        try {
                            E1 = expresion(nodo.hijos[0]);
                            c1 = tipo;
                            E2 = expresion(nodo.hijos[2]);
                            c2 = tipo;
                            if ("variable".equals(c1) && "variable".equals(c2)) {
                                var1 = Double.parseDouble(E1);
                                var2 = Double.parseDouble(E2);

                                if (var1 >= var2) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            } else {
                                String r = MatrizHK.mayorMenor(E1 + ",", E2 + ",");
                                if (r.equals("true")) {
                                    return "true";
                                } else {
                                    return MatrizHK.igual(E1 + ",", E2 + ",");
                                }
                            }
                        } catch (Exception e) {
                            System.out.println(">=");
                            return "";
                        }
                    //   break;
                    case "<=":
                        try {
                            E1 = expresion(nodo.hijos[0]);
                            c1 = tipo;
                            E2 = expresion(nodo.hijos[2]);
                            c2 = tipo;
                            if ("variable".equals(c1) && "variable".equals(c2)) {
                                var1 = Double.parseDouble(E1);
                                var2 = Double.parseDouble(E2);

                                if (var1 <= var2) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            } else {
                                String r = MatrizHK.mayorMenor(E1 + ",", E2 + ",");
                                if (r.equals("false")) {
                                    return "true";
                                } else if (r.equals("igual")) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("<=");
                            return "";
                        }
                    //break;
                    case "==":
                        try {
                            E1 = expresion(nodo.hijos[0]);
                            c1 = tipo;
                            E2 = expresion(nodo.hijos[2]);
                            c2 = tipo;
                            if ("variable".equals(c1) && "variable".equals(c2)) {
                                var1 = Double.parseDouble(E1);
                                var2 = Double.parseDouble(E2);

                                if (Objects.equals(var1, var2)) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            } else {
                                return MatrizHK.igual(E1 + ",", E2 + ",");
                            }
                        } catch (Exception e) {
                            System.out.println("E==");
                            return "";
                        }
                    //  break;
                    case "!=":
                        try {
                            E1 = expresion(nodo.hijos[0]);
                            c1 = tipo;
                            E2 = expresion(nodo.hijos[2]);
                            c2 = tipo;
                            if ("variable".equals(c1) && "variable".equals(c2)) {
                                var1 = Double.parseDouble(E1);
                                var2 = Double.parseDouble(E2);

                                if (var1 != var2) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            } else {
                                String r = MatrizHK.igual(E1 + ",", E2 + ",");
                                if (r.equals("true")) {
                                    return "false";
                                } else {
                                    return "true";
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("E!=");
                            return "";
                        }
                    //break;
                    case "&&":
                        E1 = expresion(nodo.hijos[0]);
                        c1 = tipo;
                        E2 = expresion(nodo.hijos[2]);
                        c2 = tipo;
                        if ("variable".equals(c1) && "variable".equals(c2)) {

                            String v1 = expresion(nodo.hijos[0]);
                            String v2 = expresion(nodo.hijos[2]);
                            if ("true".equals(v1) && "true".equals(v2) || "false".equals(v1) && "false".equals(v2)) {
                                return "true";
                            } else {
                                return "false";
                            }
                        }
                        break;

                    case "||":
                        E1 = expresion(nodo.hijos[0]);
                        c1 = tipo;
                        E2 = expresion(nodo.hijos[2]);
                        c2 = tipo;
                        if ("variable".equals(c1) && "variable".equals(c2)) {

                            String va1 = expresion(nodo.hijos[0]);
                            String va2 = expresion(nodo.hijos[2]);
                            if ("true".equals(va1) || "true".equals(va2)) {
                                return "true";
                            } else {
                                return "false";
                            }
                        }
                        break;

                    default: //(E)
                        return expresion(nodo.hijos[1]);
                }
        }

        return "";
    }

    public static String resolverExtras(Nodo nodo) {
        tipo = "variable";
        String resultado = expresionExtra(nodo);
        //     System.out.println("El resultado x es: " + resultado);
        return resultado;
    }

    private static String expresionExtra(Nodo nodo) {

        switch (nodo.cantidadHijos) {
            case 2:
                String dato = nodo.hijos[1].texto;

                switch (dato) {
                    case "E":
                        if (nodo.hijos[0].texto.equals("Succ")) {
                            RecorridoHK r = new RecorridoHK();
                            String result = r.Recorrido(nodo.hijos[1]);
                            try {
                                Double res = Double.parseDouble(result) + 1;
                                return res.toString();
                            } catch (Exception e) {
                                System.out.println("Error en Succ");
                                return "0";
                            }
                        } else {
                            RecorridoHK r = new RecorridoHK();
                            String result = r.Recorrido(nodo.hijos[1]);
                            try {
                                Double res = Double.parseDouble(result) - 1;
                                return res.toString();
                            } catch (Exception e) {
                                System.out.println("Error en Decc");
                                return "0";
                            }
                        }

                    case "ELEMENTO":
                        RecorridoHK r = new RecorridoHK();
                        String result = r.Recorrido(nodo.hijos[1]);

                        if (nodo.hijos[0].texto.equals("Min")) {
                            result = MatrizHK.minimo(result);
                            return result;
                        } else {
                            result = MatrizHK.maximo(result);
                            return result;
                        }
                    //  break;
                    default:
                        break;
                }
                return "";
            case 3: //concatenar
                if (nodo.hijos[1].texto.equals("++")) {
                    try {
                        String E1 = expresion(nodo.hijos[0]);
                        String E2 = expresion(nodo.hijos[2]);
                        String E = E1 + "," + E2;
                        String datos[] = E.split(";");
                        E = "";
                        for (int i = 0; i < datos.length; i++) {
                            E += datos[i];
                        }
                        return E;
                    } catch (Exception e) {
                        System.out.println("E-()");
                    }
                } else {
                    return "";
                }

            case 4: //Nodo binario
                if (nodo.hijos[0].texto.equals("Min")) {

                } else {

                }
                break;
            default:
                return "";

        }
        return "";
    }

}
