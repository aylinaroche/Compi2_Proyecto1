package Graphik.Ejecutar;

import java.util.ArrayList;

/**
 *
 * @author Aylin
 */
public class Datos {

    public static String[][] aDatos = new String[10][10];
    public static String[][] donde = new String[10][10];
    public static String[][] tabla = new String[10][10];
    public static String[] titulo = new String[2];
    public static ArrayList columnas = new ArrayList();
    public static int contadorDonde = 0;

    public static void main(String[] args) throws Exception {

        guardarDatos("[\"Departamento\"], [\"medida1\"], [\"medida2\"]\n"
                + "{\"Guatemala\"}, {15678}, {10264},\n"
                + "{\"El progreso\"}, {3196}, {2345},\n"
                + "{\"Guatemala\"}, {15}, {10}");

        Haskell.Haskell.Analizar(""
                + "sumar n,m = \n"
                + "	$Calcular n+m$\n"
                + "end");

        Graphik.Graphik.Analizar("incluir_HK sumar? #incluye la función de Haskell++\n"
                + ""
                + "ALS detalle:publico{"
                + ""
                + "     vacio inicio(){\n"
                + "         llamar Datos()?\n"
                + "     }\n"
                + "     vacio Datos(){\n"
                + "         Procesar = llamar sumar(columna(2), columna(3))?\n"
                //                + "       Donde(1) = \"Guatemala\"?\n"
                //                + "       DondeCada(1)?"
                + "         DondeTodo(1)?"
                + "}"
                + ""
                + "     vacio sumar(entero a, entero b){\n"
                + "        retornar a+b?\n"
                + "     }"
                + "}");

    }

    public static void guardarDatos(String texto) {
        String fila[] = texto.split("\n");

        for (int i = 0; i < fila.length; i++) {
            String datos = fila[i].replace("]", "").replace("[", "").replace("\"", "").replace(" ", "");

            String columna[] = datos.split(",");
            for (int j = 0; j < columna.length; j++) {
                String dato = columna[j].replace("{", "").replace("}", "").replace(" ", "");
                aDatos[i][j] = dato;
                //   System.out.println(i + "," + j + "=" + dato);
            }
        }
    }

    public static void recolectarDonde(Object obj, Object obj2) {
        int pos = 0;
        String cadena = "a";
        try {
            pos = (Integer) obj - 1;
            cadena = (String) obj2;
            cadena = cadena.replace(" ", "");
        } catch (Exception e) {
            System.out.println("Error al castear Donde");
        }
        int f = 0, c = 0;
        for (int j = 0; j < 10; j++) {
            //System.out.println("D= " + aDatos[j][pos]);
            if (aDatos[j][pos] != null) {
                String dato = aDatos[j][pos];
                if (dato.equals(cadena)) {
                    for (int i = 0; i < aDatos.length; i++) {
                        donde[f][i] = aDatos[j][i];
                        // System.out.println(f + "," + i + " = " + aDatos[j][i]);
                        tabla[f][0] = cadena;
                    }
                    f += 1;
                }
            }
        }
        contadorDonde = f;
    }

    public static void procesarDonde(String id, ArrayList columna, String tipo) {
        ArrayList parametro = new ArrayList();
        if (tipo.equals("HK")) {
            for (int j = 0; j < contadorDonde; j++) {
                for (int i = 0; i < columna.size(); i++) {
                    int c = (int) columna.get(i) - 1;
                    String p = donde[j][c];
                    System.out.println("0," + c + ":param = " + p);
                    Haskell.Metodo_FuncionHK.agregarParametro(p, "");
                }
                try {
                    String dato = Haskell.Metodo_FuncionHK.buscarMetodo(id, Haskell.Metodo_FuncionHK.parametros);
                    tabla[j][1] = dato;
                } catch (Exception e) {
                    System.out.println("Error al agregar a Tabla: " + e);
                }
            }
        } else if (tipo.equals("GK")) {
            for (int j = 0; j < contadorDonde; j++) {
                for (int i = 0; i < columna.size(); i++) {
                    int c = (int) columna.get(i) - 1;
                    String p = donde[j][c];
                    System.out.println("0," + c + ":param = " + p);
                    double num = 0;
                    try {
                        num = Double.parseDouble(p);
                    } catch (Exception e) {
                        System.out.println("Error al agregar a Tabla: " + e);
                    }
                    parametro.add(num);
                }
                try {
                    Object dato = Metodo_FuncionG.buscarMetodo(id, parametro, VariableG.nombreALS.peek());
                    if (dato != null) {
                        tabla[j][1] = String.valueOf(dato);
                    } else {
                        tabla[j][1] = "";
                    }
                } catch (Exception e) {
                    System.out.println("Error al agregar a Tabla: " + e);
                }
            }
        }
    }

    public static void procesarDondeCada(String id, ArrayList columna, String tipo, int pos) {
        ArrayList parametro = new ArrayList();
        Boolean nulo = false;
        if (tipo.equals("HK")) {
            for (int j = 0; j < 9; j++) {
                for (int i = 0; i < columna.size(); i++) {
                    int c = (int) columna.get(i) - 1;
                    String p = aDatos[j + 1][c];
                    System.out.println("0," + c + ":param = " + p);
                    if (p != null) {
                        Haskell.Metodo_FuncionHK.agregarParametro(p, "");
                    } else {
                        nulo = true;
                    }
                }
                if (nulo == false) {
                    try {
                        String dato = Haskell.Metodo_FuncionHK.buscarMetodo(id, Haskell.Metodo_FuncionHK.parametros);
                        tabla[j][1] = dato;
                        tabla[j][0] = aDatos[j + 1][pos - 1];
                    } catch (Exception e) {
                        System.out.println("Error al agregar a Tabla: " + e);
                    }
                }
                nulo = false;
            }
        } else if (tipo.equals("GK")) {
            for (int j = 0; j < 9; j++) {
                for (int i = 0; i < columna.size(); i++) {
                    int c = (int) columna.get(i) - 1;
                    String p = aDatos[j + 1][c];
                    System.out.println("0," + c + ":param = " + p);
                    double num = 0;
                    if (p != null) {
                        try {
                            num = Double.parseDouble(p);
                            parametro.add(num);
                        } catch (Exception e) {
                            System.out.println("Error al agregar Param: " + e);
                        }
                    } else {
                        nulo = true;
                    }
                }
                if (nulo == false) {
                    try {
                        Object dato = Metodo_FuncionG.buscarMetodo(id, parametro, VariableG.nombreALS.peek());
                        if (dato != null) {
                            tabla[j][1] = String.valueOf(dato);
                            tabla[j][0] = aDatos[j + 1][pos - 1];
                        } else {
                            tabla[j][1] = "";
                            tabla[j][0] = aDatos[j + 1][pos - 1];
                        }
                    } catch (Exception e) {
                        System.out.println("Error al agregar a Tabla: " + e);
                    }
                }
            }
        }
    }

    public static void procesarDondeTodo(String id, ArrayList columna, String tipo, int pos) {
        ArrayList parametro = new ArrayList();
     
        int suma = 0;
        if (tipo.equals("HK")) {
            for (int i = 0; i < columna.size(); i++) {
                int c = (int) columna.get(i) - 1;
                for (int j = 0; j < 9; j++) {
                    if (aDatos[j + 1][c] != null) {
                        System.out.println(aDatos[j + 1][c]);
                        suma += Integer.parseInt(aDatos[j + 1][c]);
                    }
                }
                System.out.println("0," + c + ":param = " + suma);
                Haskell.Metodo_FuncionHK.agregarParametro(String.valueOf(suma), "");
                suma = 0;
            }
            try {
                String dato = Haskell.Metodo_FuncionHK.buscarMetodo(id, Haskell.Metodo_FuncionHK.parametros);
                tabla[0][0] = "Todo";
                tabla[0][1] = String.valueOf(dato);
            } catch (Exception e) {
                System.out.println("Error al agregar a Tabla: " + e);
            }

        } else if (tipo.equals("GK")) {
            for (int i = 0; i < columna.size(); i++) {
                int c = (int) columna.get(i) - 1;
                for (int j = 0; j < 9; j++) {
                    if (aDatos[j + 1][c] != null) {
                        System.out.println(aDatos[j + 1][c]);
                        suma += Integer.parseInt(aDatos[j + 1][c]);
                    }
                }
                System.out.println("0," + c + ":param = " + suma);
                parametro.add(suma);
                suma = 0;
            }
            try {
                Object dato = Metodo_FuncionG.buscarMetodo(id, parametro, VariableG.nombreALS.peek());
                tabla[0][0] = "Todo";
                tabla[0][1] = String.valueOf(dato);
            } catch (Exception e) {
                System.out.println("Error al agregar a Tabla: " + e);
            }

        }
    }
}

