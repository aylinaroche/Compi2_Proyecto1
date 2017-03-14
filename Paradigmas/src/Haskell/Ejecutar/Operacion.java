package Haskell.Ejecutar;

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

                if (dato.equals("OPCION") || dato.equals("LLAMADA") || dato.equals("EXTRAS") || dato.equals("OPERACION_LISTA") || dato.equals("CALCULAR")) {
                    RecorridoHK r = new RecorridoHK();
                    String result = r.Recorrido(nodo.hijos[0]);
                    return result;
                } else if (dato.equals("%")) {
                    return RecorridoHK.ultimoValor;
                } else {
                    String tipoDato = nodo.hijos[0].tipo;
                    switch (tipoDato) {
                        case "cadena":
                            Operacion.tipo = "lista";
                            return dato;
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
                                    if ("lista".equals(m.tipo)) {
                                        Operacion.tipo = "lista";
                                    }
                                    return m.dim1 + ";" + m.dim2;
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
                            }
                        } catch (Exception e) {
                            System.out.println("E>");
                            return "";
                        }

                        break;
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
                            }
                        } catch (Exception e) {
                            System.out.println("E<");
                            return "";
                        }
                        break;
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
                            }
                        } catch (Exception e) {
                            System.out.println(">=");
                            return "";
                        }
                        break;
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
                            }
                        } catch (Exception e) {
                            System.out.println("<=");
                            return "";
                        }
                        break;
                    case "==":
                        try {
                            E1 = expresion(nodo.hijos[0]);
                            c1 = tipo;
                            E2 = expresion(nodo.hijos[2]);
                            c2 = tipo;
                            if ("variable".equals(c1) && "variable".equals(c2)) {
                                var1 = Double.parseDouble(E1);
                                var2 = Double.parseDouble(E2);

                                if (var1 == var2) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("E==");
                            return "";
                        }
                        break;
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
                            }
                        } catch (Exception e) {
                            System.out.println("E!=");
                            return "";
                        }
                        break;
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
                            Double res = Double.parseDouble(result) + 1;
                            return res.toString();
                        } else {
                            RecorridoHK r = new RecorridoHK();
                            String result = r.Recorrido(nodo.hijos[0]);
                            Double res = Double.parseDouble(result) - 1;
                            return res.toString();
                        }

                    case "%":
                        if (nodo.hijos[0].texto.equals("Succ")) {
                            try {
                                Double res = Double.parseDouble(VariableHK.ultimoValor) + 1;
                                return res.toString();
                            } catch (Exception e) {
                            }
                        } else {
                            try {
                                Double res = Double.parseDouble(VariableHK.ultimoValor) - 1;
                                return res.toString();
                            } catch (Exception e) {
                            }
                        }
                        break;
                    case "ELEMENTO":
                        if (nodo.hijos[0].texto.equals("Min")) {

                        } else {

                        }
                        break;
                    default:
                        break;
                }
                return "";
            case 3: //concatenar
                if (nodo.hijos[1].texto.equals("++")) {
                    try {
                        String E1 = expresion(nodo.hijos[0]);
                        String E2 = expresion(nodo.hijos[2]);

                        return E1 + E2;
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
