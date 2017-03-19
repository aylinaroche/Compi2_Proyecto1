package Haskell.Ejecutar;

import static Haskell.Ejecutar.VariableHK.pilaAmbito;
import java.util.ArrayList;

public class MatrizHK {

    public static ArrayList listaMatriz = new ArrayList();
    //  public static String tipo = "";

    public static void crearMatriz(String nombre, String valor) {
        for (int i = 0; i < listaMatriz.size(); i++) {
            Matriz s = (Matriz) listaMatriz.get(i);
            if (s.nombre.equals(nombre) && s.ambito.equals(pilaAmbito.peek())) {
                paradigmas.ReporteError.agregarError(nombre, "Error Semantico", "La lista " + nombre + " ya existe", 0, 0);
                return;
            }
        }
        Matriz m = new Matriz();
        String dato[] = valor.split(";");
        String tipo = obtenerTipo(valor);
        if (tipo.equals("error")) {
            return;
        }
        if (dato.length > 1) {
            if (dato.length > 2) {
                paradigmas.ReporteError.agregarError(nombre, "Error Semantico", "La lista " + nombre + " exede el limite", 0, 0);
            }
            m.dim1 = dato[0];
            m.dim2 = dato[1];
        } else {
            m.dim1 = valor;
            m.dim2 = "";
        }
        m.nombre = nombre;
        m.ambito = pilaAmbito.peek();
        m.nivel = VariableHK.nivelAmbito;
        m.tipo = "Lista";
        m.valorTipo = tipo;
        listaMatriz.add(m);
    }

    public static String obtenerTipo(String nombre) {
        nombre = nombre.replace(";", "");
        Boolean entero = false, caracter = false;
        String dato[] = nombre.split(",");
        for (int i = 0; i < dato.length; i++) {
            String d = dato[i];
            try {
                int num = Integer.parseInt(d);
                entero = true;
            } catch (Exception e) {
                caracter = true;
            }
        }
        if (entero == true && caracter == true) {
            paradigmas.ReporteError.agregarError(nombre, "Error Semantico", "La lista " + nombre + " no es el del mismo tipo", 0, 0);
            return "error";
        } else if (entero == true && caracter == false) {
            return "numero";
        } else {
            return "caracter";
        }
    }

    public static Matriz obtenerMatriz(String nombre) {
        Matriz s = null;
        for (int i = listaMatriz.size() - 1; i >= 0; i--) {
            Matriz sim = (Matriz) listaMatriz.get(i);
            if (sim.nombre.equals(nombre)) {
                return sim;
            }
        }
        return s;
    }

    public static String operacionMatriz(String nombre, String matriz, String tipo) {
        System.out.println(nombre.toUpperCase());
        switch (nombre.toLowerCase()) {
            case "sum":
                return sumar(matriz);
            case "product":
                return multiplicar(matriz);
            case "revers":
                return alreves(matriz);
            case "impr":
                return imprimir(matriz);
            case "asc":
                return ascendente(matriz);
            case "desc":
                return descendente(matriz);
            case "par":
                return par(matriz);
            case "length":
                return tamanio(matriz);
        }
        return "";
    }

    public static String imprimir(String matriz) {
        String m = matriz.replace(";", ",");
        paradigmas.Atributos.imprimirHaskell.add(m);
        return m;
    }

    public static String sumar(String matriz) {
        int numero = 0;
        matriz = matriz.replace(";", "");
        String tipo = obtenerTipo(matriz);
        if (tipo.equals("error")) {
            return "0";
        }
        if (tipo.equals("numero")) {

            String[] dato = matriz.split(",");
            for (int j = 0; j < dato.length; j++) {
                String num = dato[j];
                try {
                    numero += Integer.parseInt(num);
                } catch (Exception e) {
                    System.out.println("Error SUM");
                }
            }
        } else {
            String[] dato = matriz.split(",");
            for (int i = 0; i < dato.length; i++) {
                String caracter = dato[i];
                numero += caracter.codePointAt(0);
            }
        }
        String s = String.valueOf(numero);
        return s;
    }

    public static String multiplicar(String matriz) {
        int numero = 1;
        matriz = matriz.replace(";", "");
        String tipo = obtenerTipo(matriz);
        if (tipo.equals("error")) {
            return "0";
        }
        if (tipo.equals("numero")) {

            String[] dato = matriz.split(",");
            for (int j = 0; j < dato.length; j++) {
                String num = dato[j];
                try {
                    numero *= Integer.parseInt(num);
                } catch (Exception e) {
                    System.out.println("Error SUM");
                }
            }
        } else {
            String[] dato = matriz.split(",");
            for (int i = 0; i < dato.length; i++) {
                String caracter = dato[i];
                numero *= caracter.codePointAt(0);
            }
        }
        String s = String.valueOf(numero);
        return s;
    }

    public static String alreves(String matriz) {
        String r = "";
        String m = matriz.replace(";", "");
        String[] dato = m.split(",");
        for (int i = dato.length; i >= 1; i--) {
            r += dato[i - 1] + ",";
        }
        return r;
    }

    public static String ascendente(String matriz) {
        String r = "";
        String m = matriz.replace(";", "");
        String[] dato = m.split(",");
        int[] arreglo = new int[dato.length];
        String tipo = obtenerTipo(matriz);
        if (tipo.equals("error")) {
            return "0";
        }
        if (tipo.equals("numero")) {
            for (int i = 0; i < dato.length; i++) {
                try {
                    arreglo[i] = Integer.parseInt(dato[i]);
                } catch (Exception e) {
                    System.out.println("ERROR" + e);
                }

            }
        } else {
            for (int i = 0; i < dato.length; i++) {
                arreglo[i] = dato[i].codePointAt(0);
            }
        }
        for (int i = 0; i < arreglo.length - 1; i++) {
            int min = i;
            //buscamos el menor número
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[min]) {
                    min = j;    //encontramos el menor número
                }
            }
            if (i != min) {
                //permutamos los valores
                int aux = arreglo[i];
                arreglo[i] = arreglo[min];
                arreglo[min] = aux;
            }
        }
        if (tipo.equals("caracter")) {
            for (int i = 0; i < arreglo.length; i++) {
                char caracter = (char) arreglo[i];
                r += caracter + ",";
            }
        } else {
            for (int i = 0; i < arreglo.length; i++) {
                r += arreglo[i] + ",";
            }
        }
        return r;
    }

    public static String descendente(String matriz) {
        String r = "";
        String m = matriz.replace(";", "");
        String[] dato = m.split(",");
        int[] arreglo = new int[dato.length];
        String tipo = obtenerTipo(matriz);
        if (tipo.equals("error")) {
            return "0";
        }
        if (tipo.equals("numero")) {
            for (int i = 0; i < dato.length; i++) {
                arreglo[i] = Integer.parseInt(dato[i]);
            }
        } else {
            for (int i = 0; i < dato.length; i++) {
                arreglo[i] = dato[i].codePointAt(0);
            }
        }

        for (int i = 0; i < arreglo.length - 1; i++) {
            int max = i;

            //buscamos el mayor número
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[j] > arreglo[max]) {
                    max = j;    //encontramos el mayor número
                }
            }
            if (i != max) {
                //permutamos los valores
                int aux = arreglo[i];
                arreglo[i] = arreglo[max];
                arreglo[max] = aux;
            }
        }
        if (tipo.equals("caracter")) {
            for (int i = 0; i < arreglo.length; i++) {
                char caracter = (char) arreglo[i];
                r += caracter + ",";
            }
        } else {
            for (int i = 0; i < arreglo.length; i++) {
                r += arreglo[i] + ",";
            }
        }
        return r;
    }

    public static String par(String matriz) {
        String r = "";
        String m = matriz.replace(";", "");
        String[] dato = m.split(",");
        String tipo = obtenerTipo(matriz);
        if (tipo.equals("error")) {
            return "0";
        }
        if (tipo.equals("numero")) {

            for (int i = 0; i < dato.length; i++) {
                int numero = Integer.parseInt(dato[i]);
                if (numero % 2 == 0) {
                    r += numero + ",";
                }
            }
        } else {

            for (int i = 0; i < dato.length; i++) {
                int numero = dato[i].codePointAt(0);
                if (numero % 2 == 0) {
                    r += dato[i] + ",";
                }
            }
        }
        return r;
    }

    public static String tamanio(String matriz) {
        String r = "";
        String m = matriz.replace(";", "");
        String[] dato = m.split(",");
        r = String.valueOf(dato.length);
        return r;
    }

    public static String posicion(String id, String posicion) {
        Matriz m = obtenerMatriz(id);
        String dato[] = posicion.split("!");
        int pos1 = 0, pos2 = 0;
        try {
            pos1 = Integer.parseInt(dato[0]);
        } catch (Exception e) {
            paradigmas.ReporteError.agregarError(id, "Error Semantico", "La lista " + id + " tiene un indice incorrecto", 0, 0);
            return "0";
        }
        if (dato.length == 1) {
            String dato2[] = m.dim1.split(",");
            if (dato2.length > 0 && dato2.length > pos1) {
                String resultado = dato2[pos1];
                return resultado;
            } else {
                paradigmas.ReporteError.agregarError(id, "Error Semantico", "El indice de la lista " + id + " no existe", 0, 0);
                return "0";
            }
        } else {
            try {
                pos2 = Integer.parseInt(dato[1]);
            } catch (Exception e) {
                paradigmas.ReporteError.agregarError(id, "Error Semantico", "La lista " + id + " tiene un indice incorrecto", 0, 0);
            }

            switch (pos1) {
                case 0: {
                    String dato2[] = m.dim1.split(",");
                    if (dato2.length > 0 && dato2.length > pos1) {
                        String resultado = dato2[pos2];
                        return resultado;
                    } else {
                        paradigmas.ReporteError.agregarError(id, "Error Semantico", "El indice de la lista " + id + " no existe", 0, 0);
                        return "0";
                    }
                }
                case 1: {
                    String dato2[] = m.dim2.split(",");
                    if (dato2.length > 0) {
                        String resultado = dato2[pos2];
                        return resultado;
                    } else {
                        paradigmas.ReporteError.agregarError(id, "Error Semantico", "El indice de la lista " + id + " no existe", 0, 0);
                        return "0";
                    }
                }
                default:
                    paradigmas.ReporteError.agregarError(id, "Error Semantico", "El indice de la lista " + id + " no existe", 0, 0);
                    return "0";
            }
        }
    }

    public static String mayorMenor(String matriz1, String matriz2) {
        //String d = matriz1.dim1+","+matriz1.dim2
        String dato1[] = matriz1.replace(";", ",").split(",");
        String dato2[] = matriz2.replace(";", ",").split(",");

        int tamanio = dato1.length;
        if (tamanio > dato2.length) {
            return "true";
        } else if (tamanio < dato2.length) {
            return "false";
        }

        for (int i = 0; i < tamanio; i++) {
            int ascii1 = dato1[i].codePointAt(0);
            int ascii2 = dato2[i].codePointAt(0);
            if (ascii1 > ascii2) {
                return "true";
            } else if (ascii1 < ascii2) {
                return "false";
            }
        }
        return "igual";

    }

    public static String igual(String matriz1, String matriz2) {
        //String d = matriz1.dim1+","+matriz1.dim2
        String dato1[] = matriz1.replace(";", ",").split(",");
        String dato2[] = matriz2.replace(";", ",").split(",");

        int tamanio = dato1.length;
        if (tamanio > dato2.length || tamanio < dato2.length) {
            return "false";
        }
        for (int i = 0; i < tamanio; i++) {
            int ascii1 = dato1[i].codePointAt(0);
            int ascii2 = dato2[i].codePointAt(0);
            if (ascii1 != ascii2) {
                return "false";
            }
        }
        return "true";
    }

    public static String minimo(String matriz) {
        matriz = matriz.replace(";", ",");
        String dato[] = matriz.split(",");
        int iMenor = 0;
        for (int i = 1; i < dato.length; i++) {
            if (dato[i].codePointAt(0) < dato[iMenor].codePointAt(0)) {
                iMenor = i;
            }
        }
        return dato[iMenor];
    }

    public static String maximo(String matriz) {
        matriz = matriz.replace(";", ",");
        String dato[] = matriz.split(",");
        int iMenor = 0;
        for (int i = 1; i < dato.length; i++) {
            if (dato[i].codePointAt(0) > dato[iMenor].codePointAt(0)) {
                iMenor = i;
            }
        }
        return dato[iMenor];
    }
}

class Matriz {

    public String ambito;
    public String nombre;
    public String dim1;
    public String dim2="";
    public int tamanio;
    public String tipo; //Variable o lista
    public String valorTipo;
    public int nivel;
}
