package Haskell.Ejecutar;

import java.io.File;
import java.io.StringReader;
import java_cup.runtime.Symbol;

/**
 *
 * @author Aylin
 */
public class EjecutarHK {

    public static Nodo raiz = null;

    public static void main(String[] args) throws Exception {
        String path_Lexico = System.getProperty("user.dir").replace("\\", "/") + "/src/Haskell/Ejecutar/LexicoHK.jflex";
//Genera el LEXICO
        File f = new File(path_Lexico);
        String[] Flex = new String[1];
        Flex[0] = System.getProperty("user.dir").replace("\\", "/") + "/src/Haskell/Ejecutar/LexicoHK.jflex";//Sustituí por la direccion de tu .flex 
        jflex.Main.main(Flex);
//Genera el SINTACTICO
        String Params[] = new String[5];

        Params[0] = "-destdir";//habilita destino
        Params[1] = System.getProperty("user.dir").replace("\\", "/") + "/src/Haskell/Ejecutar";//destino
        Params[2] = "-parser";//habilita nombre
        Params[3] = "SintacticoHK";//nombre
        Params[4] = System.getProperty("user.dir").replace("\\", "/") + "/src/Haskell/Ejecutar/SintacticoHK.cup";//loc de .cup//loc de .cup

        try {
            java_cup.Main.main(Params);
        } catch (Exception e) {
            System.out.println(e);
        }
        Analizar("Calcular 75*3-20+3’pot’4\n"
              //  + ">286\n"
                + "ConjuntoFuncPolinomial 3,%\n"
                //+ ">6690675214\n"
                + "IncrementaSegunN 3,70-5+2\n"
                //+ ">70\n"
                + "ConjuntoFuncPolinomial 1,7\n"
                //+ ">50420\n"
                + "ConjuntoFuncPolinomial 2,-3\n"
               // + ">44.33333\n"
                + "ConjuntoFuncPolinomial 4,5*4\n"
           //     + ">8316\n"
                + "ObtenerModa [5,$Calcular %-80*10$,700,230,14]\n"
            //   + ">700\n"
                + "let listaProm = [1,5,70,9,20,45,23,90]\n"
            //    + ">[1,5,70,9,20,45,23,90]\n"
                + "ObtenerPromedio listaProm");
    }

    public static void Analizar(String texto) throws Exception {
        StringReader miReader = new StringReader(texto);
        LexicoHK miAnalizador = new LexicoHK(miReader);

        SintacticoHK parser = new SintacticoHK(miAnalizador);
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

        RecorridoHK r = new RecorridoHK();
        r.Recorrido(raiz);
    }
}
