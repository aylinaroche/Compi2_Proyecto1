package Haskell;

import Haskell.Ejecutar.EjecutarHK;
import Haskell.Ejecutar.VariableHK;
import Haskell.Ejecutar.*;
import static Haskell.Ejecutar.VariableHK.listaVariables;
import static Haskell.Ejecutar.VariableHK.nivelAmbito;
import java.io.File;
import java.io.StringReader;
import java_cup.runtime.Symbol;
//import paradigmas.ReporteError.Errror;

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

//        Analizar("IncrementaSegunN n,Val = if n<=$Calcular 1$ then\n"
//                // + "	 let Lista1 = [[ $Calcular 6$,$Calcular 5$],[ $Calcular 4$,$Calcular 2$]]"
//                + "		$Succ $Calcular 1$$\n"
//                + "	else\n"
//                + "		$Succ $IncrementaSegunN {$Calcular n-1 $,Val}$$\n"
//                + "	end\n"
//                + "end\n"
//                + "\n"
//                + "ConjuntoFuncPolinomial i,x = CASE i\n"
//                + "		1: $Polinomial1 {x}$;\n"
//                + "		2: $Polinomial2 {x}$;\n"
//                + "		3: $Polinomial3 {x}$;\n"
//                + "		4: $Polinomial4 {x}$;\n"
//                + "	end\n"
//                + "end\n"
//                + "\n"
//                + "Polinomial1 x = $Calcular 3 * x'pot'5 - x 'pot'2 + 7 * x -1$ \n"
//                + "				end\n"
//                + "Polinomial2 x = $Calcular 5 * x'pot'2 - x + 8 * x 'pot'(-1) -1$ \n"
//                + "				end\n"
//                + "Polinomial3 x = $Calcular x'pot'4 + x 'pot'2 + (9*3) * x +80$ \n"
//                + "				end\n"
//                + "Polinomial4 x = $Calcular x'pot'3 + x 'pot'2 - 4 * x -4 $ \n"
//                + "				end\n"
//                + "ObtenerModa LIST = $Max LIST$ \n"
//                + "				   end\n"
//                + "\n"
//                + "ObtenerPromedio LIST = 	$Calcular $sum LIST$ / $length LIST$ $\n"
//                + "					    end"
//                + "");
        Analizar("IncrementaSegunN n,Val = \n"
                + "	if n<=$Calcular 1$ then\n"
                + "		$Succ $calcular 1$$\n"
                + "	else\n"
                + "		$Succ $IncrementaSegunN {$Calcular n-1 $,Val}$$\n"
                + "	end\n"
                + "end\n"
                + "\n"
                + "ConjuntoFuncPolinomial i,x = CASE i\n"
                + "		1: $Polinomial1 {x}$;\n"
                + "		2: $Polinomial2 {x}$;\n"
                + "		3: $Polinomial3 {x}$;\n"
                + "	end\n"
                + "end\n"
                + "\n"
                + "Polinomial1 x = $Calcular 3 * x'pot'5 - x 'pot'2 + 7 * x -1$ \n"
                + "				end\n"
                + "Polinomial2 x = $Calcular 5 * x'pot'2 - x + 8 * x 'pot'(-1) -1$ \n"
                + "				end\n"
                + "Polinomial3 x = $Calcular x'pot'4 + x 'pot'2 + (9*3) * x +80$ \n"
                + "				end\n"
                + "Polinomial4 x = $Calcular x'pot'3 + x 'pot'2 - 4 * x --4 $ \n"
                + "				end\n"
                + "\n"
                + "ObtenerModa LIST = $Max LIST$ \n"
                + "				   end\n"
                + "\n"
                + "ObtenerPromedio LIST = 	$Calcular $sum LIST$ / $length LIST$ $\n"
                + "					    end\n"
                + "\n"
                + "Factorial n = \n"
                + "    If n==$Calcular 0$ Then\n"
                + "        $Calcular 1$\n"
                + "    Else    \n"
                + "        $Calcular n * $Factorial{$Calcular n-1$}$$\n"
                + "  	End\n"
                + "End\n"
                + "\n"
                + "\n"
                + "Fibonacci n =\n"
                + "    If n==$Calcular 0$ || n==$Calcular 1$ Then\n"
                + "        $Calcular 1$\n"
                + "    Else\n"
                + "        $Calcular $Fibonacci{$Calcular n-1$}$ + $Fibonacci {$Calcular n-2$}$$\n"
                + "    End\n"
                + "End\n"
                + "\n"
                + "Operacion a,b, condicion =\n"
                + "	CASE condicion\n"
                + "		1: $Calcular a+b$;\n"
                + "		2: $Calcular a-b$;\n"
                + "		3: $Calcular a*b$;\n"
                + "		4: If b != $calcular 0$ Then\n"
                + "				$Calcular a/b$\n"
                + "		   else\n"
                + "		   		$calcular 0$	\n"
                + "		   End;\n"
                + "		5: If b != $calcular 0$ Then\n"
                + "				$Calcular a'mod'b$\n"
                + "			else\n"
                + "				$calcular 0$\n"
                + "			End;\n"
                + "		6: $Calcular a'sqrt'b$;\n"
                + "		7: $Calcular a'pot'b$;\n"
                + "	End\n"
                + "End \n"
                + "\n"
                + "\n"
                + "Saludo n, nombre = \n"
                + "	Let hola = ['h','o','l','a',' ']\n"
                + "	Let adios = ['a','d','i','o','s',' ']\n"
                + "	Case n\n"
                + "		'a': hola ++ nombre;\n"
                + "		'b': adios ++ nombre;\n"
                + "		'c': hola++['u','s','e','r',' ']++nombre ++ [' '] ++ adios;\n"
                + "	End\n"
                + "End\n"
                + "\n"
                + "\n"
                + "OperarLista lista, op = \n"
                + "	CASE op\n"
                + "		1: $sum lista$;\n"
                + "		2: $product lista$;\n"
                + "		3: $Length lista$;\n"
                + "		4: $min lista$;\n"
                + "		5: $max lista$;\n"
                + "		6: $succ lista !! $calcular 1$$;\n"
                + "		7: $decc lista !! $calcular 1$$;\n"
                + "	End\n"
                + "End\n"
                + "\n"
                + "OperarCadena cadena, op =\n"
                + "	if op == $calcular 1$ then\n"
                + "		$revers cadena$\n"
                + "	else\n"
                + "		if op == $calcular 2$ then\n"
                + "			$impr cadena$\n"
                + "		else\n"
                + "			if op == $calcular 3$ then\n"
                + "				$par cadena$\n"
                + "			else\n"
                + "				if op == $calcular 4$ then\n"
                + "					$asc cadena$\n"
                + "				else\n"
                + "					if op == $calcular 5$ then\n"
                + "						$desc cadena$\n"
                + "					else\n"
                + "						let vacio = cadena\n"
                + "					End\n"
                + "				End\n"
                + "			End\n"
                + "		End\n"
                + "	End\n"
                + "End\n"
                + "\n"
                + "Fibonacci2 n =\n"
                + "    If n==$Calcular 0$ || n==$Calcular 1$ Then\n"
                + "         $Calcular n$\n"
                + "    Else\n"
                + "        $Calcular $Fibonacci2{$Calcular n-1$}$ + $Fibonacci2{$Calcular n-2$}$$\n"
                + "    End\n"
                + "End"
                + "\n"
                + "\n"
                + "");
        System.out.println("\n * * * ** * * ** * ** * * ** ** * ** * ** ** * *  * *\n");

        EjecutarHK.Analizar(""
                //       + "Saludo 'c',\"aylin\"\n"
                //
                //     + "OperarLista [3,5,2],7\n"
                //
                // + "Fibonacci2 7"
                //
                //   + "OperarCadena \"aylin\",6\n
                ///    + "Operacion 5,3,7\n"
                //  + "let id = [$revers [$calcular 1$ , $calcular 2$]$,$revers [$calcular 1$ , $calcular 2$]$ ,$calcular 1$]"
                //  + "IncrementaSegunN 3,2\n"
                //

                + "\"hola\" ++ \"mundo\"\n"
                + "let lista = [9,4,5]\n"
                + "lista !!1\n"
                + "");

//        EjecutarHK.Analizar(""
////                + "Calcular 75*3-20+3'pot'4\n"
////                //  + ">286\n"
////                + "ConjuntoFuncPolinomial 3,%\n"
////                //+ ">6690675214\n"
//                + "IncrementaSegunN 3,70-5+2\n"
//                //                //+ ">70\n"
//    //            + "ConjuntoFuncPolinomial 1,7\n"
//                //                //+ ">50420\n"
//     //           + "ConjuntoFuncPolinomial 2,-3\n"
//                //                // + ">44.33333\n"
//                + "ConjuntoFuncPolinomial 4,5*4\n"
//                //     + ">8316\n"
//                + "ObtenerModa [$Calcular 5$,$Calcular %-80*10$,$Calcular 700$,$Calcular 230$,$Calcular 14$]\n"
//                //+ ">700\n"
//                + "let listaProm = [1,5,70,9,20,45,23,90]\n"
//                + "ObtenerPromedio listaProm"
//                // 32.875
//                + "");
        System.out.println("\n/////////////////////////////////////////////////////\n");
        //    paradigmas.ReporteError.imprimirError();
    }

    public static void Analizar(String texto) throws Exception {
        StringReader miReader = new StringReader(texto);
        LexicoH miAnalizador = new LexicoH(miReader);
        VariableHK.pilaAmbito.push(paradigmas.Atributos.nombreArchivo);

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
        VariableHK.pilaAmbito.pop();
    }

//    public static void llenarTablaSimbolosHaskell() {
//        for (int i = 0; i < Metodo_FuncionHK.metodoFuncionHK.size(); i++) {
//            MF m = (MF) Metodo_FuncionHK.metodoFuncionHK.get(i);
//            paradigmas.Atributos.crearSimboloHaskell(m.nombre, m.tipo, "Metodo", m.ambito, " - ");
//        }
//       // EjecutarHK.llenarTablaSimbolosHaskell();
//    }
//    
}
