package Graphik;

import Haskell.*;
import java.io.File;
import java.io.StringReader;
import java_cup.runtime.Symbol;
import paradigmas.Atributos;

/**
 *
 * @author Aylin
 */
public class Graphik {

    public static void main(String[] args) throws Exception {
        String path_Lexico = System.getProperty("user.dir").replace("\\", "/") + "/src/Graphik/LexicoG.jflex";
//Genera el LEXICO
        File f = new File(path_Lexico);
        String[] Flex = new String[1];
        Flex[0] = System.getProperty("user.dir").replace("\\", "/") + "/src/Graphik/LexicoG.jflex";//Sustituí por la direccion de tu .flex 
        jflex.Main.main(Flex);
//Genera el SINTACTICO
        String Params[] = new String[5];

        Params[0] = "-destdir";//habilita destino
        Params[1] = System.getProperty("user.dir").replace("\\", "/") + "/src/Graphik";//destino
        Params[2] = "-parser";//habilita nombre
        Params[3] = "SintacticoG";//nombre
        Params[4] = System.getProperty("user.dir").replace("\\", "/") + "/src/Graphik/SintacticoG.cup";//loc de .cup//loc de .cup

        try {
            java_cup.Main.main(Params);
        } catch (Exception e) {
            System.out.println(e);
        }

        Analizar("importar Nodo.gk?\n"
                + "incluir_HK FormCuadraticaPositiva?\n"
                + "incluir_HK FormCuadraticaNegativa?\n"
                + "incluir_HK Permutacion?\n"
                + "incluir_HK FuncionPolinomial1?\n"
                + "var entero a:publico?\n"
                + "\n"
              // + "als als : publico {\n"
                + "vacio inicio(){\n"
                + "	a = 4?\n"
                + "	imprimir(llamar FormCuadraticaPositiva())?\n"
                + "	imprimir(llamar FormCuadraticaNegativa())?\n"
                + "	imprimir(\"permutación: \" + llamar Permutacion_gk((10*2 - 14), a))?\n"
                + "	a = 3?\n"
                + "	var decimal x = ((18/2)^2) - (15 - a)?\n"
                + "	llamar FuncionPolinomial1(x)?\n"
                + "	llamar creacion_nodos()?\n"
                + "}\n"
                + "cadena FormCuadraticaPositiva(){\n"
                + "	a = (5*2)^2 - 4?\n"
                + "	var entero b = 3?\n"
                + "	var entero c = 8?\n"
                + "	imprimir(llamarHK FormCuadraticaPositiva(a, b, c))?\n"
                + "	retornar \"Primer función ejecutada con éxito\"?\n"
                + "}\n"
                + "cadena FormCuadraticaNegativa():privado{\n"
                + "	var decimal arreglo[3] = {96, 3, 8}?\n"
                + "	imprimir(llamarHK FormCuadraticaNegativa(arreglo[0], arreglo[1],\n"
                + "	arreglo[2]))?\n"
                + "	retornar \"Segunda función ejecutada con éxito\"?\n"
                + "}\n"
                + "vacio FuncionPolinomial1(entero valor_entrada){\n"
                + "	var entero arreglo[5]?\n"
                + "	var entero i?\n"
                + "	Para(i=0: i<5: i++){\n"
                + "		arreglo[i] = llamarHK FuncionPolinomial1(valor_entrada * i)?\n"
                + "		imprimir(\"polinomial: \" + arreglo[i])?\n"
                + "	}\n"
                + "}\n"
                + "entero Permutacion_gk(entero n, entero r){\n"
                + "	Mientras(r>0){\n"
                + "		imprimir(\"Factorial: \" + llamarHK Permuctacion(n,r))?\n"
                + "		r= r - 1?\n"
                + "	}\n"
                + "}\n"
                + "vacio creacion_nodos(){\n"
                + "	Nodo nod1 = nuevo Nodo()?\n"
                + "	nod1.nombre = \"primero\"?\n"
                + "	nod1numero = 1?\n"
                + "	nod1.cambiar_bandera()?\n"
                + "	Nodo nod2 = nuevo Nodo()?\n"
                + "	nod2.nombre = \"segundo\"?\n"
                + "	nod2.numero = 2?\n"
                + "	Si(nod1.bandera == nod2.bandera){\n"
                + "		imprimir(\"las banderas son iguales para los nodos \" + nod1.nombre\n"
                + "		+ \" \" + nod2.nombre)?\n"
                + "	}Sino{\n"
                + "		imprimir(\"las banderas son diferentes para los nodos \" +\n"
                + "		nod1.nombre + \" \" + nod2.nombre)?\n"
                + "	}\n"
                + "	imprimir(\"Se creó un nodo con éxito\")?\n"
           //     + "}\n"
                + "}");
    }

    public static void Analizar(String texto) throws Exception {
        StringReader miReader = new StringReader(texto);
        LexicoG miAnalizador = new LexicoG(miReader);

        SintacticoG parser = new SintacticoG(miAnalizador);
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
