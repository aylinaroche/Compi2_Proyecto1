package Haskell.Ejecutar;

import static Haskell.Ejecutar.VariableHK.pilaAmbito;
import java.util.ArrayList;

public class MatrizHK {

    public static ArrayList listaMatriz = new ArrayList();
    public static String tipo = "";

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
        if (dato.length > 1) {
            m.dim1 = dato[0];
            m.dim2 = dato[1];
            if (dato.length > 2) {
                paradigmas.ReporteError.agregarError(nombre, "Error Semantico", "La lista " + nombre + " exede el limite", 0, 0);
            }
        } else {
            m.dim1 = valor;
            m.dim2 = "";
        }
        m.nombre = nombre;
        m.ambito = pilaAmbito.peek();
        m.tipo = "Lista";
        listaMatriz.add(m);
    }

    public static Matriz obtenerMatriz(String nombre) {
        Matriz s = null;
        for (int i = 0; i < listaMatriz.size(); i++) {
            Matriz sim = (Matriz) listaMatriz.get(i);
            if (sim.nombre.equals(nombre)) {
                return sim;
            }
        }
        return s;
    }

    public static String operacionMatriz(String nombre, String matriz, String tipo) {
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
        String m = matriz.replace(";", "");
        System.out.println("IMP = " + m);
        return m;
    }

    public static String sumar(String matriz) {
        int numero = 0;
        matriz = matriz.replace(";", "");
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
        int numero = 0;
        matriz = matriz.replace(";", "");
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
        for (int i = dato.length; i > 1; i--) {
            r += dato[i] + ",";

        }
        return r;
    }

    public static String ascendente(String matriz) {
        String r = "";
        String m = matriz.replace(";", "");
        String[] dato = m.split(",");
        int[] arreglo = null;

        if (tipo.equals("numero")) {
            for (int i = 0; i < dato.length; i++) {
                arreglo[i] = Integer.parseInt(dato[i]);
            }
        } else {
            for (int i = 0; i < dato.length; i++) {
                arreglo[i] = dato[i].codePointAt(i);
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

        for (int i = 0; i < arreglo.length; i++) {
            r += arreglo[i] + ",";
        }

        return r;
    }

    public static String descendente(String matriz) {
        String r = "";
        String m = matriz.replace(";", "");
        String[] dato = m.split(",");
        int[] arreglo = null;

        if (tipo.equals("numero")) {
            for (int i = 0; i < dato.length; i++) {
                arreglo[i] = Integer.parseInt(dato[i]);
            }
        } else {
            for (int i = 0; i < dato.length; i++) {
                arreglo[i] = dato[i].codePointAt(i);
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
        for (int i = 0; i < arreglo.length; i++) {
            r += arreglo[i] + ",";
        }
        return r;
    }

    public static String par(String matriz) {
        String r = "";
        String m = matriz.replace(";", "");
        String[] dato = m.split(",");

        if (tipo.equals("numero")) {

            for (int i = 0; i < dato.length; i++) {
                int numero = Integer.parseInt(dato[i]);
                if (numero % 2 == 0) {
                    r += numero + ",";
                }
            }
        }else{

            for (int i = 0; i < dato.length; i++) {
                int numero = dato[i].codePointAt(i);
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
}

class Matriz {

    public String ambito;
    public String nombre;
    public String dim1;
    public String dim2;
    public int tamanio;
    public String tipo; //Variable o lista
}
