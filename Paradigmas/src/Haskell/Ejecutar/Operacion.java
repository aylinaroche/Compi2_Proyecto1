package Haskell.Ejecutar;

public class Operacion {

    public static boolean concatenar;
    public static Double var1;
    public static Double var2;

    public static String resolverOperacion(Nodo nodo) {
        concatenar = false;
        String resultado = expresion(nodo);
        System.out.println("El resultado es: " + resultado);
        return resultado;
    }

    private static String expresion(Nodo nodo) {

        switch (nodo.cantidadHijos) {
            case 1:
                String dato = nodo.hijos[0].texto;

                if (dato.equals("INSTANCIA") || dato.equals("FuncionSTRING") || dato.equals("PARSEAR")) {
                    RecorridoHK r = new RecorridoHK();
                    String result = r.Recorrido(nodo.hijos[0]);
                    return result;
                } else {
                    String tipo = nodo.hijos[0].tipo;
                    //    System.out.println("TIPO = "+tipo);  
                    if (tipo.equals("cadena")) {
                        concatenar = true;
                        return dato;
                    } else if (tipo.equals("num")) {
                        concatenar = false;
                        return dato;
                    } else if (tipo.equals("id")) {
//                        if (s != null) {
//                            if ("string".equals(s.tipo) || "char".equals(s.tipo) || "bool".equals(s.tipo)) {
//                                concatenar = true;
//                            }
//                            return s.valor;
//                        } else {
//                            System.out.println("ERROR"); //No encuentra el id
//                       //     Errores.agregarError(dato, "Error Semantico", "No se encontro el id", 0, 0);
//                            concatenar = true;
//                            return "";
//                        }

                    } else {
                        concatenar = true;
                        return "";
                    }
                }

            case 2:
                if (nodo.hijos[1].texto.equals("++")) {
                    try {
                        String E1 = expresion(nodo.hijos[0]);
                        int v1 = Integer.parseInt(E1) + 1;
                        String r = String.valueOf(v1);
                        return r;
                    } catch (Exception e) {
                        System.out.println("ERROR");
                    }
                } else if (nodo.hijos[1].texto.equals("--")) {
                    try {
                        String E1 = expresion(nodo.hijos[0]);
                        int v1 = Integer.parseInt(E1) - 1;
                        String r = String.valueOf(v1);
                        return r;
                    } catch (Exception e) {
                        System.out.println("ERROR");
                    }
                } else if (nodo.hijos[0].texto.equals("!!") || nodo.hijos[0].texto.equals("!")) {
                    try {
                        String E1 = expresion(nodo.hijos[1]);
                        if (E1.equals("true")) {
                            return "false";
                        } else {
                            return "true";
                        }
                    } catch (Exception e) {
                        System.out.println("ERROR");
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
                        Boolean c1 = concatenar;
                        E2 = expresion(nodo.hijos[2]);
                        Boolean c2 = concatenar;
                        if (c1 == true || c2 == true) {
                            resultado = E1 + E2;
                            concatenar = true;
                            return resultado;
                        } else {
                            try {
                                Double v1 = Double.parseDouble(E2);
                                Double v2 = Double.parseDouble(E2);
                                Double r = v1 + v2;
                                resultado = String.valueOf(r);
                                return resultado;

                            } catch (Exception e) {
                                System.out.println("E");
                                return "";
                            }
                        }
                    case "-": //E-E
                        E1 = expresion(nodo.hijos[0]);
                        E2 = expresion(nodo.hijos[2]);
                        try {
                            Double r = Double.parseDouble(E1) - Double.parseDouble(E2);
                            resultado = String.valueOf(r);
                            return resultado;

                        } catch (Exception e) {
                            System.out.println("E");
                            return "";
                        }
                    case "/": //E/E
                        E1 = expresion(nodo.hijos[0]);
                        E2 = expresion(nodo.hijos[2]);
                        try {
                            Double r = Double.parseDouble(E1) / Double.parseDouble(E2);
                            resultado = String.valueOf(r);
                            return resultado;

                        } catch (Exception e) {
                            System.out.println("E");
                            return "";
                        }
                    case "*": //E*E
                        E1 = expresion(nodo.hijos[0]);
                        E2 = expresion(nodo.hijos[2]);
                        try {
                            Double r = Double.parseDouble(E1) * Double.parseDouble(E2);
                            resultado = String.valueOf(r);
                            return resultado;

                        } catch (Exception e) {
                            System.out.println("E");
                            return "";
                        }
                    case ">":
                        try {
                            E1 = expresion(nodo.hijos[0]);
                            E2 = expresion(nodo.hijos[2]);
                            var1 = Double.parseDouble(E1);
                            var2 = Double.parseDouble(E2);

                            if (var1 > var2) {
                                return "true";
                            } else {
                                return "false";
                            }
                        } catch (Exception e) {
                            return "error";
                        }

                    case "<":
                        try {
                            var1 = Double.parseDouble(expresion(nodo.hijos[0]));
                            var2 = Double.parseDouble(expresion(nodo.hijos[2]));

                            if (var1 < var2) {
                                return "true";
                            } else {
                                return "false";
                            }
                        } catch (Exception e) {
                            return "error";
                        }
                    case ">=":
                        try {
                            var1 = Double.parseDouble(expresion(nodo.hijos[0]));
                            var2 = Double.parseDouble(expresion(nodo.hijos[2]));

                            if (var1 >= var2) {
                                return "true";
                            } else {
                                return "false";
                            }
                        } catch (Exception e) {
                            return "error";
                        }
                    case "<=":
                        try {
                            var1 = Double.parseDouble(expresion(nodo.hijos[0]));
                            var2 = Double.parseDouble(expresion(nodo.hijos[2]));

                            if (var1 <= var2) {
                                return "true";
                            } else {
                                return "false";
                            }
                        } catch (Exception e) {
                            return "error";
                        }
                    case "==":
                        try {
                            var1 = Double.parseDouble(expresion(nodo.hijos[0]));
                            var2 = Double.parseDouble(expresion(nodo.hijos[2]));

                            if (var1 == var2) {
                                return "true";
                            } else {
                                return "false";
                            }
                        } catch (Exception e) {
                            return "error";
                        }
                    case "!=":
                        try {
                            var1 = Double.parseDouble(expresion(nodo.hijos[0]));
                            var2 = Double.parseDouble(expresion(nodo.hijos[2]));

                            if (var1 != var2) {
                                return "true";
                            } else {
                                return "false";
                            }
                        } catch (Exception e) {
                            return "error";
                        }
                    case "&&":
                        String v1 = expresion(nodo.hijos[0]);
                        String v2 = expresion(nodo.hijos[2]);
                        if ("true".equals(v1) && "true".equals(v2) || "false".equals(v1) && "false".equals(v2)) {
                            return "true";
                        } else {
                            return "false";
                        }

                    case "||":
                        String va1 = expresion(nodo.hijos[0]);
                        String va2 = expresion(nodo.hijos[2]);
                        if ("true".equals(va1) || "true".equals(va2)) {
                            return "true";
                        } else {
                            return "false";
                        }

                    case "??":
                        va1 = expresion(nodo.hijos[0]);
                        va2 = expresion(nodo.hijos[2]);
                        if (va1 == va2) {
                            return "false";
                        } else {
                            return "true";
                        }

                    default: //(E)
                        return expresion(nodo.hijos[1]);
                }

            case 6:
                if (nodo.hijos[0].texto.equals("raiz")) {
                    E1 = expresion(nodo.hijos[2]);
                    E2 = expresion(nodo.hijos[4]);
                    try {
                        var1 = Double.parseDouble(E1);
                        var2 = Double.parseDouble(E2);
                        Double ex = (1 / var2);
                        Double res = Math.pow(var1, ex);
                        String r = String.valueOf(res);
                        return r;

                    } catch (Exception e) {
                        System.out.println("ERROR raiz " + e);
                    }
                } else if (nodo.hijos[0].texto.equals("potencia")) {
                    E1 = expresion(nodo.hijos[2]);
                    E2 = expresion(nodo.hijos[4]);
                    try {
                        var1 = Double.parseDouble(E1);
                        var2 = Double.parseDouble(E2);
                        Double res = Math.pow(var1, var2);
                        String r = String.valueOf(res);
                        return r;
                    } catch (Exception e) {
                        System.out.println("ERROR raiz " + e);
                    }
                }
        }
        return "";
    }

}
