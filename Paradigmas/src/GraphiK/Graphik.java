package Graphik;

import Graphik.Ejecutar.*;
import Graphik.Objetos.ObjetoALS;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;

public class Graphik {

    public static void main(String[] args) throws Exception {
        String path_Lexico = System.getProperty("user.dir").replace("\\", "/") + "/src/Graphik/LexicoALS.jflex";
//Genera el LEXICO
        File f = new File(path_Lexico);
        String[] Flex = new String[1];
        Flex[0] = System.getProperty("user.dir").replace("\\", "/") + "/src/Graphik/LexicoALS.jflex";//Sustituí por la direccion de tu .flex 
        jflex.Main.main(Flex);
//Genera el SINTACTICO
        String Params[] = new String[5];

        Params[0] = "-destdir";//habilita destino
        Params[1] = System.getProperty("user.dir").replace("\\", "/") + "/src/Graphik";//destino
        Params[2] = "-parser";//habilita nombre
        Params[3] = "SintacticoALS";//nombre
        Params[4] = System.getProperty("user.dir").replace("\\", "/") + "/src/Graphik/SintacticoALS.cup";//loc de .cup//loc de .cup

        try {
            java_cup.Main.main(Params);
        } catch (Exception e) {
            System.out.println(e);
        }

        archivos();
//        Analizar("importar Nodo.gk?\n"
//                + "incluir_HK FormCuadraticaPositiva?\n"
//                + "incluir_HK FormCuadraticaNegativa?\n"
//                + "incluir_HK Permutacion?\n"
//                + "incluir_HK FuncionPolinomial1?\n"
//                + "\n"
//                + "ALS ALS_basico:publico{"
//                + "vacio inicio(){\n"
//                + "     var entero a = 4?\n"
//                + "     imprimir(llamar FormCuadraticaPositiva())?\n"
//                + "	imprimir(llamar FormCuadraticaNegativa())?\n"
//                + "	imprimir(\"permutación: \" + llamar Permutacion_gk((10*2 - 14), a))?\n"
//                + "	a = 3?\n"
//                + "	var decimal x = ((18/2)^2) - (15 - a)?\n"
//                + "	llamar FuncionPolinomial1(x)?\n"
//                + "	llamar creacion_nodos()?\n"
//                + "}\n"
        //+ "cadena FormCuadraticaPositiva(){\n"
//                + "	a = (5*2)^2 - 4?\n"
//                + "	var entero b = 3?\n"
//                + "	var entero c = 8?\n"
//                 + "	imprimir(llamarHK FormCuadraticaPositiva(a, b, c))?\n"
//                + "	retornar \"Primer función ejecutada con éxito\"?\n"
//                + "     imprimir(\"Hola Guapa\")?"
//                + "}\n"
//                + "cadena FormCuadraticaNegativa(): privado{\n"
//                + "	var decimal arreglo[3] = {96, 3, 8}?\n"
//                  + "	imprimir(llamarHK FormCuadraticaNegativa(arreglo[0], arreglo[1],arreglo[2]))?\n"
//                + "	retornar \"Segunda función ejecutada con éxito\"?\n"
//                + "}\n"
//                + "vacio FuncionPolinomial1(entero valor_entrada){\n"
//                + "	var entero arreglo[5]?\n"
//                + "	var entero i?\n"
//                + "	Para(i=0: i<5: i++){\n"
//                + "     imprimir(\"Holiiiiii Guapa\")?"
//                + "		arreglo[i] = llamarHK FuncionPolinomial1(valor_entrada * i)?\n"
//                + "		imprimir(\"polinomial: \" + arreglo[i])?\n"
//                + "	}\n"
//                + "}\n"
//                + "entero Permutacion_gk(entero n, entero r){\n"
//                + "	Mientras(r>0){\n"
//                + "     imprimir(\"Holoooo Guapa\")?"
//                + "		imprimir(\"Factorial: \" + llamarHK Permuctacion(n,r))?\n"
//                + "		r= r - 1?\n"
//                + "	}\n"
//                + "}\n"
//                                + "vacio creacion_nodos(){\n"
//                                + "	Nodo nod1 = nuevo Nodo()?\n"
//                                + "	nod1.nombre = \"primero\"?\n"
//                                + "	nod1numero = 1?\n"
//                                + "	nod1.cambiar_bandera()?\n"
//                                + "	Nodo nod2 = nuevo Nodo()?\n"
//                                + "	nod2.nombre = \"segundo\"?\n"
//                                + "	nod2.numero = 2?\n"
//                                + "	Si(nod1.bandera == nod2.bandera){\n"
//                                + "		imprimir(\"las banderas son iguales para los nodos \" + nod1.nombre\n"
//                                + "		+ \" \" + nod2.nombre)?\n"
//                                + "	}Sino{\n"
//                                + "		imprimir(\"las banderas son diferentes para los nodos \" +\n"
//                                + "		nod1.nombre + \" \" + nod2.nombre)?\n"
//                                + "	}\n"
//                                + "	imprimir(\"Se creó un nodo con éxito\")?\n"
//                                + "}\n"
//                + "}");
////        Analizar("Importar archivo2.gk?\n"
////                + "importar operaciones_matematicas.gk?\n"
////                + "incluir_HK incremento? #indica que utilizará la función incremento en el código de entrada\n"
////                + "incluir_HK polinomial? #indica que utilizará la función polinomial en el código de entrada\n"
////                + "\n"
////                + "ALS ALS_basico:publico{"
////                //           + "var cadena texto, variable_1, a1, prueba?\n"
////                + "\n"
////                + "#Visibilidad explícita de variables\n"
////                //                + "var entero a = 1:publico?\n"
////                //                + "var cadena b = 2:privado?\n"
////                //                + "var entero c = 3:publico?\n"
////                //                + "var caracter letra ='a'?\n"
////                //                + "var bool bandera = 1?\n"
////                + "var entero arreglo1 [2][2] = {{2,3,4},{5,6,7},{8,9,10}}?\n"
////                //                + ""
////                //                + "var entero arreglo2 [2][3]?"
////                ////                + "\n"
////                ////                + "\n"
////                + "vacio inicio(){\n"
////                + "      imprimir (\"Arreglo = \" + arreglo1[0][0])?"//2
////                + "      arreglo1[0][0] = 11?"
////                + "      imprimir (\"Arreglo = \" + arreglo1[0][0])?"//11
////                //                + "      imprimir (\"Arreglo = \" + arreglo1[1][1])?"//6
////                //                + "      imprimir (\"Arreglo = \" + arreglo1[2][2])?"//10
////                //                + "	x = 10 + (5 ^ 2) + llamar funcion_sumar(2)?\n"
////                //   + "	var bool bandera = verdadero?\n"
////                //                + "	var entero numero = 15*2.4?\n"
////                //                + "	var entero numero2 = 15*\" hola\"?\n"
////                //                + "	var entero numero3 = 15*verdadero?\n"
////                //                + "	var entero numero4 = 15*2?\n"
////                //                + "	var entero numero5 = 15/2.4?\n"
////                //                + "	var entero numero6 = 15/\"hola\"?\n"
////                //                    + "	var entero numero3 = 15/falso?\n"
////                //                + "	llamar metodo_principal(letra,2)?\n"
////                //           + "	bandera = llamar funcion_logica(numero)?\n"
////                + "	\n"
////                //                + "	Si((a+c)>(2+a)){\n"
////                //                + "     imprimir(\"Entro en el si\")?"
////                //                + "		c = (a + b) * 2?\n"
////                //                + "		a = c^2?\n"
////                //                + "	}\n"
////                //                + "	\n"
////                //                + "	Si((b>a)||(b>c)){\n"
////                //                + "		c = (a + b) * 2?\n"
////                //                + "		imprimir(\"sumatorio de a + b por 2 = \" + c)?\n"
////                //                + "	}Sino{\n"
////                //                + "		c = a - (b^3)?\n"
////                //                + "		imprimir(\"resta de a - b al cubo = \" + c)?\n"
////                //                + "	}\n"
////                //                + "	\n"
////                //                + "	var entero i?\n"
////                //                + "	Para(i=1: i<10: i++){\n"
////                //                + "		imprimir(\"El valor actual es: \" + i)?\n"
////                //                + "             var entero j = i ^ 2?\n"
////                //                + "		imprimir(\"su valor al cuadrado es: \" + j)?\n"
////                //                + "	}\n"
////                //                + "	\n"
////                //                + "	Mientras(a<=c){\n"
////                //                + "     imprimir(\"mientras es\"+a+c)?\n"
////                //                + "		a = a +1?\n"
////                //                + "	}\n"
////                //                + "	\n"
////                //                + "	Hacer{\n"
////                //                + "		imprimir(\"hacer es: \" + c +\"-\"+(a*100))?\n"
////                //                + "		c = 5 * c?\n"
////                //                + "	}Mientras(c<=(a*100))?\n"
////                + "}\n"
////                + "\n"
////                //                + "entero metodo_sumarizar(entero x, entero y, cadena texto):privado{\n"
////                //                + "	var entero número = 10?\n"
////                //                + "	numero = llamar funcion_calculada(x,y,z) + x^2 + (a*(x+y))/2?\n"
////                //                + "	var decimal calculo = (5.2 ^ 2) * llamar retornar_impuesto() - llamar diferencia(a,b,c)?\n"
////                //                + "	\n"
////                //                + "	var entero arreglo1 [3]= {1,2,200+2-50}? #para un arreglo de una dimensión\n"
////                //                + "	var entero arreglo1[2][2]= {{1,1+1},{x+2}},{{x*y^2,3},{8}}? #para un arreglo de una	dimensión\n"
////                //                + "	#En una posición especifica\n"
////                //                + "	arreglo[2] = 3 * a?\n"
////                //                + "	arreglo[x+2] = llamar funcion_anazada(x)?\n"
////                //                + "}\n"
////                //                + "\n"
////                //                + "\n"
////                //                + "vacio metodo_especial(){\n"
////                //                + "		llamar calculo_polinomo(x, y)?\n"
////                //                + "		var entero resultado_funcion = llamar retornar_impuesto()?\n"
////                //                + "		var entero calculo = llamarHK incremento(x+2) : protegido?\n"
////                //                + "}\n"
////                //                + "\n"
////                //                + "#/ \n"
////                //                + "<cualquier cosa en varias líneas>\n"
////                //                + "/#\n"
////                //                + "\n"
////                //                + "vacio metodo_principal(entero x, entero y){\n"
////                //                + "      imprimir(\"* * * *  METODO PRINCIPAL  * * * *\")?\n"
////                //                + "	var entero gran_total = (a*b + (3^c)) / (a+d)?\n"
////                //                + "	var cadena texto = \"valor de salida:\" + \" \" + gran_total?\n"
////                //                //      + "	var decimal g = gran_total + llamar funcion_final(\"inicio\", \"final\")?\n"
////                //                + "\n"
////                //                + "	var entero numero = 5 * 3?\n"
////                //                + "	numero = numero + 27?\n"
////                //                + "	Si((15>x && a+b>y)){\n"
////                //                + "		numero = numero + x + y?\n"
////                //                + "	}Sino{\n"
////                //                + "		numero = numero + a + b?\n"
////                //                + "	}\n"
////                //                + "	\n"
////                //                + "	Seleccion(x) {\n"
////                //                + "		Caso 'a':\n"
////                //                + "			imprimir(\"opción 1: \" + a)?\n"
////                //                + "			imprimir(\"para: \" + x)?\n"
////                //                + "		Caso 'b':\n"
////                //                + "			imprimir(\"opción 2: \" + b)?\n"
////                //                + "			imprimir(\"para: \" + x)?\n"
////                //                + "		Caso 'c':\n"
////                //                + "			imprimir(\"opción 3: \" + c)?\n"
////                //                + "			imprimir(\"para: \" + x)?\n"
////                //                + "		Defecto:\n"
////                //                + "			imprimir(\"opción por defecto\")?\n"
////                //                + "		}\n"
////                //                + "}\n"
////                //                + "	\n"
////                //                + "entero funcion_final(cadena texto_entrada, cadena texto_procesado){\n"
////                //                + "	retornar 5? \n"
////                //                + "}\n"
////                //                + "\n"
////                //                + "ALS ALS_basico:publico{\n"
////                //                + "	var decimal a?\n"
////                //                + "	var entero numero:protegido?\n"
////                //                + "	var decimal calculo_num = (a + b) / c?\n"
////                //                + "}\n"
////                //                + "\n"
////                //                + "ALS ALS_intermedio hereda ALS_basico{\n"
////                //              + "	var nodo_ALS nodo1 = nuevo nodo_ALS()?\n"
////                //                + "	var entero y = 5?\n"
////                //                + "	var entero x = nodo1.Retornar_calculo(y) :publico ?\n"
////                //                + "}\n"
////                //                + "	\n"
////                //                + "\n"
//                + "}#Pagina 52");
    }

    public static void Analizar(String texto) throws Exception {
        StringReader miReader = new StringReader(texto);
        LexicoALS miAnalizador = new LexicoALS(miReader);
        VariableG.pilaAmbito.push(paradigmas.Atributos.nombreArchivo);

        SintacticoALS parser = new SintacticoALS(miAnalizador);
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

        iniciarEjecutarPrueba();
    }

    public static void iniciarEjecutarPrueba() {
        ObjetoALS a = new ObjetoALS();
        a = (ObjetoALS) ALS.listaALS.get(0);
        ArrayList v = new ArrayList();
        v = (ArrayList) a.variables.clone();
        VariableG.listaVariables = (ArrayList) v.clone();
        Metodo_FuncionG.listaMetodos = (ArrayList) a.metodos.clone();
        Metodo_FuncionG.buscarMain();
    }

    public static void iniciarEjecutar() {
        ObjetoALS a = new ObjetoALS();
        a = (ObjetoALS) ALS.listaALS.get(ALS.listaALS.size() - 1);
        VariableG.listaVariables = (ArrayList) a.variables.clone();
        Metodo_FuncionG.listaMetodos = (ArrayList) a.metodos.clone();
        Metodo_FuncionG.buscarMain();
    }

    public static void archivos() {
        try {
            Analizar(""
                    + "ALS Ejemplo_entrada:publico {\n"
                    + "	\n"
                    //   + "	var entero num =2?\n"
                    + "\n"
                    + "    vacio inicio(){\n"
                    + "        imprimir(\"Entro en INICIO \")?\n"
                    + "        aritmetica a = nuevo aritmetica()?\n"
                    //      + "        llamar a.aritmetica1()?"
                    //      + "        llamar a.aritmetica2()?\n"
                    + "        llamar a.aritmetica3()?\n"
                    //                    + "        var entero i = llamar a.operacion(1,2,3)?\n"
                    + "        imprimir(\"Resultado de operacion A: \" + a.h)?\n"
                    //                    // + "         a.h = 5?"
                    //                    + "        imprimir(\"Resultado de operacion B: \" + a.h)?\n"
                    + "        aritmetica b = nuevo aritmetica()?\n"
                    + "         llamar b.a3()?"
                    + "        imprimir(\"Resultado de operacion B: \" + b.h)?\n"
                    + "        aritmetica c= nuevo aritmetica()?\n"
                    + "        imprimir(\"Resultado de operacion C: \" + c.h)?\n"
                    + "        imprimir(\"Resultado de operacion A: \" + a.h)?\n"
                    + "        imprimir(\"Resultado de operacion B: \" + b.h)?\n"
                    + "        aritmetica d = nuevo aritmetica()?\n"
                    + "        llamar d.aritmetica3()?\n"
                    + "        imprimir(\"Resultado de operacion D: \" + d.h)?\n"
                    //              
                    ////                                        //                                        + "        \n"
                    ////                                                            + "        var entero j = llamar a.ciclo1(i)?\n"
                    ////                                                            + "        imprimir(\"Resultado de ciclo 1: \" + j)?\n"
                    //                                        + "        \n"
                    //                                        + "        \n"
                    //                                        + "        var bool bandera = llamar a.ciclo2()?\n"
                    //                                        + "        imprimir(\"Valor de bandera: \" + bandera)?\n"
                    //                                        + "        \n"
                    //                                        + "        \n"
                    //                                        + "        llamar a.arreglo()?\n"
                    //                                                            + "        \n"
                    //                    + "        salon s = nuevo salon()?\n"
                    //                    + "        llamar s.cargar_estudiantes()?\n"
                    + "        \n"
                    + "    }   \n"
                    + "    \n"
                    + "}\n"
                    + "\n"
                    + "\n"
                    + "ALS aritmetica:publico {\n"
                    + "    \n"
                    //   + "    var decimal pi = 3.1516:privado?\n"
                    + "    var decimal h=5:privado?\n"
                    + "    \n"
                    + "    vacio aritmetica1():publico{\n"
                    + "    \n"
                    + "        imprimir(\"Salida aritmética1: \")?\n"
                    + "        imprimir(  (10+41*(-1)^2 - (14/2)^3) + 15.6  )?\n"
                    + "        imprimir(\"Resultado = 40.6\")?\n"
                    + "        \n"
                    + "    }\n"
                    + "    \n"
                    + "    vacio aritmetica2():publico{\n"
                    + "        \n"
                    + "        var entero b = 15 + 13*(2) - 16?\n"
                    + "        var entero c, a?\n"
                    + "        c = 11 - 3 * (6^4) + 16?\n"
                    + "        a = ((b^2) + (c^2))?\n"
                    + "        \n"
                    + "        imprimir(\"Salida aritmética2: \")?\n"
                    + "        imprimir(\"a^2 = \" + ((b^2) + (c^2)))?\n"
                    + "        imprimir(\"Resultado = 50\")?        \n"
                    + "    }\n"
                    + "    vacio a3():publico{\n"
                    + "         h=1000?"
                    + "}\n"
                    + "    \n"
                    + "    vacio aritmetica3():publico{\n"
                    //                    + "       var entero r = 25?\n"
                    //                    + "        var decimal a = pi * (r^2)?\n"
                    //                    + "        \n"
                    //                    + "        imprimir(\"Salida aritmética3: \")?\n"
                    //                    + "        imprimir(\"El área de un circulo es: \" + a)?\n"
                    //                    + "        imprimir(\"Resultado = 85.0932\")?        \n"
                    + "        \n"
                    + "        h = 16.75?\n"
                    //                    + "        \n"
                    //                    + "        var decimal f = a + h/4 * (20 - 3^2)?\n"
                    //                    + "        imprimir(\"Segunda salida aritmética3: \")?\n"
                    //                    + "        imprimir(\"Valor de f = \" + f)?\n"
                    //                    + "        imprimir(\"Resultado = 164.65\")?        \n"
                    + "    }\n"
                    + "    \n"
                    + "    "
                    + "entero operacion(entero a, entero b, entero c):publico{\n"
                    + "        \n"
                    + "        var entero x, y, z?\n"
                    + "        \n"
                    + "        x = 105*2-(5^1) + a?\n"
                    + "        y = 24^3 + b?\n"
                    + "        z = (x + y)/10 + c?\n"
                    + "        imprimir(\"valor de z = \" + z)?\n"
                    + "        \n"
                    + "        retornar z?\n"
                    + "    }\n"
                    + "    \n"
                    //////////////////////////////

                    + "    entero ciclo1(entero i):publico{\n"
                    + "        Para(x=0:x<10:x++){\n"
                    + "            Si(i>20 && i>x){\n"
                    + "                i = i + (i * 2)?\n"
                    + "            }Sino{\n"
                    + "                i = i + (i * 2)?\n"
                    + "            }\n"
                    + "        }        \n"
                    + "        retornar i?\n"
                    + "    }\n"
                    + "    \n"
                    + "    "
                    + "bool ciclo2():publico{\n"
                    + "        \n"
                    + "        var entero conteo = 1?\n"
                    + "        Mientras (conteo < 11) {\n"
                    + "            Si(conteo == 2 || conteo == 4 || conteo == 6 || conteo == 8){\n"
                    + "                imprimir(\"Numero par menor a 10\")?\n"
                    + "            }\n"
                    + "            Sino{\n"
                    + "                imprimir(\"Conteo es: \" + conteo)?\n"
                    + "            }\n"
                    + "            conteo=conteo+1?\n"
                    + "        }\n"
                    + "        retornar verdadero?\n"
                    + "    }  \n"
                    + "    \n"
                    + ""
                    + "    vacio arreglo():publico{\n"
                    + "        imprimir(\"----- Arreglo -----\")?\n"
                    + "        var entero arreglo[5] = {5,6,9,2,10}?\n"
                    + "        Para(i=0:i<5:i++){\n"
                    + "          imprimir(arreglo[i]+\" \")?\n"
                    + "        }\n"
                    + "    }\n"
                    + "    \n"
                    + "    \n"
                    + "}\n"
                    //////////////////////////////////////////////
                    + "ALS salon:publico {\n"
                    + "    \n"
                    + "    \n"
                    + "    vacio cargar_estudiantes():publico{\n"
                    + "    \n"
                    + "        var estudiante estudiante1 = nuevo estudiante()?\n"
                    + "        llamar estudiante1.ingresar_datos(\"Luis\", 22, 201754321)?\n"
                    + "        llamar estudiante1.ingresar_detalle(\"3 calle\", \"5551223\", \"1234\")?\n"
                    + "        \n"
                    //                    + "        var estudiante estudiante2 = nuevo estudiante()?\n"
                    //                    + "        llamar estudiante2.ingresar_datos(\"Pedro\", 20, 201754322)?\n"
                    //                    + "        llamar estudiante2.ingresar_detalle(\"2 calle\", \"5551224\", \"444555333\")?\n"
                    //                    + "        \n"
                    //                    + "        var estudiante estudiante3 = nuevo estudiante()?\n"
                    //                    + "        llamar estudiante3.ingresar_datos(\"Juan\", 19, 201754323)?\n"
                    //                    + "        llamar estudiante3.ingresar_detalle(\"primera avenida\", \"2551224\", \"44435333\")?\n"
                    //                    + "        \n"
                    //                    + "        llamar estudiante1.siguiente_semestre()?\n"
                    //                    + "        llamar estudiante2.siguiente_semestre()?\n"
                    //                    + "        llamar estudiante3.siguiente_semestre()?\n"
                    + "        \n"
                    + "        \n"
                    + "        imprimir(\"Datos de estudiantes\")?\n"
                    + "        \n"
                    + "        imprimir(estudiante1.nombre + \" tiene \" + estudiante1.edad + \" años, vide en: \" + estudiante1.d.direccion)?\n"
                    //                    + "        imprimir(estudiante2.nombre + \" tiene \" + estudiante1.edad + \" años, vide en: \" + estudiante2.d.direccion)?\n"
                    //                    + "        imprimir(estudiante3.nombre + \" tiene \" + estudiante1.edad + \" años, vide en: \" + estudiante3.d.direccion)?\n"
                    //                    + "        \n"
                    + "        \n"
                    + "    }\n"
                    + "    \n"
                    + "}");
        } catch (Exception ex) {
            Logger.getLogger(Graphik.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR :OOOO = " + ex);
        }
    }
}
