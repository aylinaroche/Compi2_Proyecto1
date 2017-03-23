package paradigmas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Atributos {

    public static String lenguaje = "";
    public static String nombreArchivo = "Global";
    public static ArrayList imprimirHaskell = new ArrayList();
    public static ArrayList imprimirGraphik = new ArrayList();
    public static ArrayList tablaSimboloHK = new ArrayList();
    public static ArrayList tablaSimboloGK = new ArrayList();

    public static void reporteSimbolo(ArrayList simbolos, String nombre) {
        File f;
        FileWriter escritorArchivo;

        if (simbolos.isEmpty()) {
            System.out.println("Esta vacio");
        }
        try {
            f = new File("C:\\Users\\Aylin\\Desktop\\TablaSimbolo" + nombre + ".html");
            escritorArchivo = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(escritorArchivo);
            try (PrintWriter salida = new PrintWriter(bw)) {
                salida.write("<html>");
                salida.write("<head><title>Tabla de Simbolos</title></head>");
                salida.write("<body bgcolor=\"black\">");
                salida.write("<h1><center><FONT COLOR=silver>PROYECTO 1<FONT></center></h1>\"");
                salida.write("<h1><center><FONT COLOR=81426E>  TABLA DE SIMBOLOS <FONT></center></h1>");
                salida.write("<br>");
                salida.write("<center>");
                salida.write("<table border= 1 width= 500>");
                salida.write("<tr>");
                salida.write("<th><font color=\"#24AAFF\" face=\"courier new\"> NOMBRE </font></th>");
                salida.write("<th><font color=\"#24AAFF\" face=\"courier new\"> TIPO </font></th>");
                salida.write("<th><font color=\"#24AAFF\" face=\"courier new\"> ROL </font></th>");
                salida.write("<th><font color=\"#24AAFF\" face=\"courier new\"> AMBITO </font></th>");
                salida.write("<th><font color=\"#24AAFF\" face=\"courier new\"> DIMENSIONES </font></th>");
                salida.write("</tr>");

                for (int i = 0; i < simbolos.size(); i++) {
                    Simbolo s = (Simbolo) simbolos.get(i);
                    salida.write("<tr>");
                    salida.write("<th><font color=\"white\">" + s.nombre + "</font></th>");
                    salida.write("<th><font color=\"white\">" + s.tipo + "</font></th>");
                    salida.write("<th><font color=\"white\">" + s.rol + "</font></th>");
                    salida.write("<th><font color=\"white\">" + s.ambito + "</font></th>");
                    salida.write("<th><font color=\"white\">" + s.tamanio + "</font></th>");
                }
                salida.write("</table><br>");
                salida.write("</body></html>");
            }
            System.out.println("El fichero se ha creado correctamente");
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
            System.out.println("No ha podido ser creado el fichero");
        }
    }

    public static void crearSimboloHaskell(String nombre, String tipo, String rol, String ambito, String tam) {
////        for (int i = 0; i < tablaSimboloHK.size(); i++) {
////            Simbolo sim = (Simbolo) tablaSimboloHK.get(i);
////            if(sim.nombre.equals(nombre)&&sim.ambito.equals(ambito)){   
////            }   
////        }
        Simbolo s = new Simbolo();
        s.nombre = nombre;
        s.tipo = tipo;
        s.rol = rol;
        s.ambito = ambito;
        s.tamanio = tam;
        tablaSimboloHK.add(s);
    }

    public static void crearSimboloGraphik(String nombre, String tipo, String rol, String ambito, String tam) {

        Simbolo s = new Simbolo();
        s.nombre = nombre;
        s.tipo = tipo;
        s.rol = rol;
        s.ambito = ambito;
        s.tamanio = tam;
        tablaSimboloGK.add(s);
    }
}

class Simbolo {

    String nombre;
    String tipo;
    String rol;
    String ambito;
    String tamanio;
}
