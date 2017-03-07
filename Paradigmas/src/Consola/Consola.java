package Consola;

import Consola.*;
import java.io.File;
import java.io.StringReader;
import java_cup.runtime.Symbol;

/**
 *
 * @author Aylin
 */
public class Consola {

    public static void main(String[] args) throws Exception {
        String path_Lexico = System.getProperty("user.dir").replace("\\", "/") + "/src/Consola/Lexico.jflex";
//Genera el LEXICO
        File f = new File(path_Lexico);
        String[] Flex = new String[1];
        Flex[0] = System.getProperty("user.dir").replace("\\", "/") + "/src/Consola/Lexico.jflex";//Sustituí por la direccion de tu .flex 
        jflex.Main.main(Flex);
//Genera el SINTACTICO
        String Params[] = new String[5];

        Params[0] = "-destdir";//habilita destino
        Params[1] = System.getProperty("user.dir").replace("\\", "/") + "/src/Consola";//destino
        Params[2] = "-parser";//habilita nombre
        Params[3] = "Sintactico";//nombre
        Params[4] = System.getProperty("user.dir").replace("\\", "/") + "/src/Consola/Sintactico.cup";//loc de .cup//loc de .cup

        try {
            java_cup.Main.main(Params);
        } catch (Exception e) {
            System.out.println(e);
        }

        Analizar("let Lista1 = [ 1, $Calcular 4+2$, 5 ]\n"
                + "let lista2 = ['a','b','c','d']\n"
                + "let lista3 = [ [1,2],[3,4]]\n"
                + "let listadif = \"xyz\"\n"
                + "Calcular 5+3*7'pot'2 - 4'mod'02- 2'sqrt'9\n"
                + "Succ Val\n"
                + "Succ %\n"
                + "Decc $Calcular 65+10-5$\n"
                + "Min [$Calcular 54*3$ ,5,$Calcular 5'pot'9$]\n"
                + "\"hola\" ++ \"mundo\"\n"
                + "let lista = [9,4,5]\n"
                + "lista !!1 !!2\n"
                + "sum [ [1,2],[3,4]]\n"
                + "length lista2\n");

    }

    public static void Analizar(String texto) throws Exception {
        StringReader miReader = new StringReader(texto);
        Lexico miAnalizador = new Lexico(miReader);

        Sintactico parser = new Sintactico(miAnalizador);
        parser.parse();
        try {
            Symbol s;
            s = (Symbol) miAnalizador.next_token();
            int cont = 0;
            while (s.sym != 0) {
                System.out.println(cont + " Lexema " + s.value + "  Token " + s.sym + " Linea " + (s.right + 1) + " Columna " + (s.left + 2));
                s = (Symbol) miAnalizador.next_token();
                cont++;
            }

        } catch (Exception e) {

        }

    }
}
