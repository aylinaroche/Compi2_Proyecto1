package Haskell;

import Haskell.Ejecutar.EjecutarHK;
import java.io.File;
import java.io.StringReader;
import java_cup.runtime.Symbol;

/**
 *
 * @author Aylin
 */
public class Haskell {

    public static void main(String[] args) throws Exception {
        //paradigmas.ReporteError.agregarError("",",","",0,0);

        String path_Lexico = System.getProperty("user.dir").replace("\\", "/") + "/src/Haskell/LexicoH.jflex";
//Genera el LEXICO
        File f = new File(path_Lexico);
        String[] Flex = new String[1];
        Flex[0] = System.getProperty("user.dir").replace("\\", "/") + "/src/Haskell/LexicoH.jflex";//Sustituí por la direccion de tu .flex 
        jflex.Main.main(Flex);
//Genera el SINTACTICO
        String Params[] = new String[5];

        Params[0] = "-destdir";//habilita destino
        Params[1] = System.getProperty("user.dir").replace("\\", "/") + "/src/Haskell";//destino
        Params[2] = "-parser";//habilita nombre
        Params[3] = "SintacticoH";//nombre
        Params[4] = System.getProperty("user.dir").replace("\\", "/") + "/src/Haskell/SintacticoH.cup";//loc de .cup//loc de .cup

        try {
            java_cup.Main.main(Params);
        } catch (Exception e) {
            System.out.println(e);
        }

        Analizar("IncrementaSegunN n,Val = if n<=$Calcular 1$ then\n"
                // + "	 let Lista1 = [[ $Calcular 6$,$Calcular 5$],[ $Calcular 4$,$Calcular 2$]]"
                + "		$Succ $Calcular 1$$\n"
                + "	else\n"
                + "		$Succ $IncrementaSegunN {$Calcular n-1 $,Val}$$\n"
                + "	end\n"
                + "end\n"
                + "\n"
                + "ConjuntoFuncPolinomial i,x = CASE i\n"
                + "		1: $Polinomial1 {x}$;\n"
                + "		2: $Polinomial2 {x}$;\n"
                + "		3: $Polinomial3 {x}$;\n"
                + "		4: $Polinomial4 {x}$;\n"
                + "	end\n"
                + "end\n"
                + "\n"
                + "Polinomial1 x = $Calcular 3 * x'pot'5 - x 'pot'2 + 7 * x -1$ \n"
                + "				end\n"
                + "Polinomial2 x = $Calcular 5 * x'pot'2 - x + 8 * x 'pot'(-1) -1$ \n"
                + "				end\n"
                + "Polinomial3 x = $Calcular x'pot'4 + x 'pot'2 + (9*3) * x +80$ \n"
                + "				end\n"
                + "Polinomial4 x = $Calcular x'pot'3 + x 'pot'2 - 4 * x -4 $ \n"
                + "				end\n"
                + "ObtenerModa LIST = $Max LIST$ \n"
                + "				   end\n"
                + "\n"
                + "ObtenerPromedio LIST = 	$Calcular $sum LIST$ / $length LIST$ $\n"
                + "					    end"
                + "");
        System.out.println("\n * * * ** * * ** * ** * * ** ** * ** * ** ** * *  * *\n");

        EjecutarHK.Analizar(""
                //                + "Calcular 75*3-20+3'pot'4\n"
                //                //  + ">286\n"
                //                + "ConjuntoFuncPolinomial 3,%\n"
                //                //+ ">6690675214\n"
                //                + "IncrementaSegunN 3,70-5+2\n"
                //                //                //+ ">70\n"
                //                + "ConjuntoFuncPolinomial 1,7\n"
                //                //                //+ ">50420\n"
                //                + "ConjuntoFuncPolinomial 2,-3\n"
                ////                //                // + ">44.33333\n"
                //                + "ConjuntoFuncPolinomial 4,5*4\n"
                //                //                //     + ">8316\n"
                + "ObtenerModa [$Calcular 5$,$Calcular 80*10$,$Calcular 700 $, $Calcular 230$ ,$Calcular 14$]\n"
                //   + ">700\n"
                + "let listaProm = [1,5,70,9,20,45,23,90]\n"
                + "ObtenerPromedio listaProm"
                + "");

    }

    public static void Analizar(String texto) throws Exception {
        StringReader miReader = new StringReader(texto);
        LexicoH miAnalizador = new LexicoH(miReader);
//        Atributos.analizador = miAnalizador;

        SintacticoH parser = new SintacticoH(miAnalizador);
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
