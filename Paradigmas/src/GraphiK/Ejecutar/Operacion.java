package Graphik.Ejecutar;

import java.util.Objects;

public class Operacion {

    public static String tipo;
    public static Double var1;
    public static Double var2;

    public static Object resolverOperacion(NodoG nodo) {
        tipo = "variable";
        Object resultado = expresion(nodo);
        return resultado;
    }

    private static Object expresion(NodoG nodo) {

        switch (nodo.cantidadHijos) {
            case 1:
                String dato = nodo.hijos[0].texto;

                switch (dato) {
                    case "ARREGLO":
                    case "INSTANCIA":
                    case "AccesoASL":
                    case "E":
                        RecorridoG r = new RecorridoG();
                        String result = r.Recorrido(nodo.hijos[0]).toString();
                        return result;
                    default:
                        String tipoDato = nodo.hijos[0].tipo;
                        switch (tipoDato) {
                            case "cadena":
                                return dato;
                            case "caracter":
                                char caracter = (char) dato.charAt(0);
                                return caracter;
                            case "numero":
                                Double num = Double.parseDouble(dato);
                                return num;
                            case "id":
                                Object s = VariableG.obtenerVariable(dato);
                                if (s != null) {
                                    return s;
                                } else { //Buscar en lista
                                    paradigmas.ReporteError.agregarError(dato, "Error Semantico", "No se encontro el id", 0, 0);
                                    return "";
                                }
                            case "bool":
                                return dato;

                            default:
                                return "";
                        }
                }

            case 2:
                if (nodo.hijos[0].texto.equals("-")) {
                    try {
                        String E1 = expresion(nodo.hijos[1]).toString();
                        Double n = Double.parseDouble(E1) * (-1);
                        return n;
                    } catch (Exception e) {
                        System.out.println("E-()");
                    }
                } else if (nodo.hijos[1].texto.equals("++")) {
                    try {
                        String E1 = expresion(nodo.hijos[0]).toString();
                        Double n = Double.parseDouble(E1) + 1;
                        VariableG.asignarValor(nodo.hijos[0].hijos[0].texto, n);
                        return n;
                    } catch (Exception e) {
                        System.out.println("0");
                    }
                } else if (nodo.hijos[1].texto.equals("--")) {
                    try {
                        String E1 = expresion(nodo.hijos[0]).toString();
                        Double n = Double.parseDouble(E1) - 1;
                        VariableG.asignarValor(nodo.hijos[0].hijos[0].texto, n);
                        return n;
                    } catch (Exception e) {
                        System.out.println("0");
                    }
                } else {
                    return "";
                }

            case 3: //Nodo binario
                Object E1 = "";
                Object E2 = "";
                switch (nodo.hijos[1].texto) {

                    case "+": //E+E
                        E1 = expresion(nodo.hijos[0]);
                        E2 = expresion(nodo.hijos[2]);

                        if (E1 instanceof Double && E2 instanceof Double) {
                            try {
                                Double v1 = (Double) E1;
                                Double v2 = (Double) E2;
                                Double r = v1 + v2;
                                return r;
                            } catch (Exception e) {
                                System.out.println("E+");
                                return "";
                            }
                        } else if (E1 instanceof String || E2 instanceof String) {
                            String v1 = String.valueOf(E1);
                            String v2 = (String.valueOf(E2));
                            String r = v1 + v2;
                            return r;
                        }
                        break;
                    case "-": //E-E
                        E1 = expresion(nodo.hijos[0]);
                        E2 = expresion(nodo.hijos[2]);

                        if (E1 instanceof Double && E2 instanceof Double) {
                            try {
                                Double r = (Double) (E1) - (Double) (E2);
                                return r;
                            } catch (Exception e) {
                                System.out.println("E-");
                                return "";
                            }
                        }
                        break;
                    case "/": //E/E
                        E1 = expresion(nodo.hijos[0]);
                        E2 = expresion(nodo.hijos[2]);

                        if (E1 instanceof Double && E2 instanceof Double) {
                            try {
                                Double r = (Double) (E1) / (Double) (E2);
                                return r;

                            } catch (Exception e) {
                                System.out.println("E");
                                return "";
                            }
                        }
                        break;
                    case "*": //E*E
                        E1 = expresion(nodo.hijos[0]);
                        E2 = expresion(nodo.hijos[2]);

                        if (E1 instanceof Double && E2 instanceof Double) {
                            try {
                                Double r = (Double) (E1) * (Double) (E2);
                                return r;

                            } catch (Exception e) {
                                System.out.println("E");
                                return "";
                            }
                        }
                        break;
                    case "'mod'": //E*E
                        E1 = expresion(nodo.hijos[0]);
                        E2 = expresion(nodo.hijos[2]);

                        if (E1 instanceof Double && E2 instanceof Double) {
                            try {
                                Double r = (Double) (E1) % (Double) (E2);
                                return r;
                            } catch (Exception e) {
                                System.out.println("E%");
                                return "";
                            }
                        }
                        break;
                    case "'pot'": //E*E
                        E1 = expresion(nodo.hijos[0]);
                        E2 = expresion(nodo.hijos[2]);

                        if (E1 instanceof Double && E2 instanceof Double) {
                            try {
                                Double r = Math.pow((Double) (E1), (Double) (E2));
                                return r;

                            } catch (Exception e) {
                                System.out.println("E^");
                                return "";
                            }
                        }
                        break;
                    case "'sqrt'": //E*E
                        E1 = expresion(nodo.hijos[0]);
                        E2 = expresion(nodo.hijos[2]);

                        if (E1 instanceof Double && E2 instanceof Double) {
                            try {
                                Double r = Math.pow((Double) (E1), 1 / (Double) (E2));
                                return r;

                            } catch (Exception e) {
                                System.out.println("E/^");
                                return "";
                            }
                        }
                        break;
                    case ">":
                        try {
                            E1 = expresion(nodo.hijos[0]);
                            E2 = expresion(nodo.hijos[2]);

                            if (E1 instanceof Double && E2 instanceof Double) {
                                var1 = (Double) (E1);
                                var2 = (Double) (E2);

                                if (var1 > var2) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            } else {
//                                String r = MatrizG.mayorMenor(E1 + ",", E2 + ",");
//                                if (r.equals("true")) {
//                                    return "true";
//                                } else {
//                                    return "false";
//                                }
                            }
                        } catch (Exception e) {
                            System.out.println("E>");
                            return "";
                        }
//  break;
                    case "<":
                        try {
                            E1 = expresion(nodo.hijos[0]);
                            E2 = expresion(nodo.hijos[2]);

                            if (E1 instanceof Double && E2 instanceof Double) {
                                var1 = (Double) (E1);
                                var2 = (Double) (E2);

                                if (var1 < var2) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            } else {
//                                String r = MatrizG.mayorMenor(E1 + ",", E2 + ",");
//                                if (r.equals("true")) {
//                                    return "false";
//                                } else if (r.equals("false")) {
//                                    return "true";
//                                } else {
//                                    return "false";
//                                }
                            }
                        } catch (Exception e) {
                            System.out.println("E<");
                            return "";
                        }
                    //  break;
                    case ">=":
                        try {
                            E1 = expresion(nodo.hijos[0]);
                            E2 = expresion(nodo.hijos[2]);

                            if (E1 instanceof Double && E2 instanceof Double) {
                                var1 = (Double) (E1);
                                var2 = (Double) (E2);

                                if (var1 >= var2) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            } else {
//                                String r = MatrizG.mayorMenor(E1 + ",", E2 + ",");
//                                if (r.equals("true")) {
//                                    return "true";
//                                } else {
//                                    return MatrizG.igual(E1 + ",", E2 + ",");
//                                }
                            }
                        } catch (Exception e) {
                            System.out.println(">=");
                            return "";
                        }
                    //   break;
                    case "<=":
                        try {
                            E1 = expresion(nodo.hijos[0]);
                            E2 = expresion(nodo.hijos[2]);

                            if (E1 instanceof Double && E2 instanceof Double) {
                                var1 = (Double) (E1);
                                var2 = (Double) (E2);

                                if (var1 <= var2) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            } else {
//                                String r = MatrizG.mayorMenor(E1 + ",", E2 + ",");
//                                if (r.equals("false")) {
//                                    return "true";
//                                } else if (r.equals("igual")) {
//                                    return "true";
//                                } else {
//                                    return "false";
//                                }
                            }
                        } catch (Exception e) {
                            System.out.println("<=");
                            return "";
                        }
                        break;
                    case "==":
                        try {
                            E1 = expresion(nodo.hijos[0]);
                            E2 = expresion(nodo.hijos[2]);

                            if (E1 instanceof Double && E2 instanceof Double) {
                                var1 = (Double) (E1);
                                var2 = (Double) (E2);

                                if (Objects.equals(var1, var2)) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            } else {
//                                return MatrizG.igual(E1 + ",", E2 + ",");
                            }
                        } catch (Exception e) {
                            System.out.println("E==");
                            return "";
                        }
                    //  break;
                    case "!=":
                        try {
                            E1 = expresion(nodo.hijos[0]);
                            E2 = expresion(nodo.hijos[2]);

                            if (E1 instanceof Double && E2 instanceof Double) {
                                var1 = (Double) (E1);
                                var2 = (Double) (E2);

                                if (var1 != var2) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            } else {
//                                String r = MatrizG.igual(E1 + ",", E2 + ",");
//                                if (r.equals("true")) {
//                                    return "false";
//                                } else {
//                                    return "true";
//                                }
                            }
                        } catch (Exception e) {
                            System.out.println("E!=");
                            return "";
                        }
                    //break;
                    case "&&":
                        E1 = expresion(nodo.hijos[0]);
                        E2 = expresion(nodo.hijos[2]);

                        if (E1 instanceof String && E2 instanceof String) {
                            String v1 = (String) expresion(nodo.hijos[0]);
                            String v2 = (String) expresion(nodo.hijos[2]);
                            if ("true".equals(v1) && "true".equals(v2) || "false".equals(v1) && "false".equals(v2)) {
                                return "true";
                            } else {
                                return "false";
                            }
                        }
                        break;

                    case "||":
                        E1 = expresion(nodo.hijos[0]);
                        E2 = expresion(nodo.hijos[2]);

                        if (E1 instanceof String && E2 instanceof String) {

                            String va1 = (String) expresion(nodo.hijos[0]);
                            String va2 = (String) expresion(nodo.hijos[2]);
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

}
