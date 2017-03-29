package paradigmas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import Haskell.Metodo_FuncionHK;
import Haskell.Objetos.MF;

/**
 *
 * @author Aylin
 */
public class Graficar {

    public static void main(String[] args) throws Exception {

        Haskell.Haskell.Analizar(""
                + "FuncionPolinomial x = $Calcular x + 1$"
                + "end");

        Graphik.Graphik.Analizar(""
                + "incluir_HK FuncionPolinomial?\n"
                + ""
                + "ALS detalle:publico{"
                + "vacio inicio(){\n"
                + "     var decimal arregloX[10]?\n"
                + "     var decimal arregloY[10]?\n"
                + "     var entero i?\n"
                + "     Para (i=0:i<=5:i++){\n"
                + "         arregloX[i] = llamar FuncionPolinomial(i)?\n"
                + "     }\n"
                + "     Para (i=0:i<=5:i++){\n"
                + "         arregloY[i] = llamar FuncionPolinomial(i+1)?\n"
                + "     }\n"
                + "     graphikar_funcion(arregloX,arregloY)?\n"
                + "}"
                + ""
                + "entero FuncionPolinomial(entero x){"
                + "     retornar x+1?"
                + "}"
                + "}");
    }

    public static void crearArbol() throws IOException {
        String arbol = "digraph G{ "
                + "rankdir=LR;\n"
                + "nodo0[shape=record, color=blue, label= \"Funciones Haskell++\"];\n";
        arbol += crearNodo();
        arbol += "\n}";

        String ruta = "C:\\Users\\Aylin\\Documents\\NetBeansProjects\\Paradigmas\\arbol.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if (archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(arbol);
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(arbol);
        }
        bw.close();
        ///
        try {
            String dotPath = "C:\\Program Files (x86)\\Graphviz 2.28\\bin\\dot.exe";

            String fileInputPath = "C:\\Users\\Aylin\\Documents\\NetBeansProjects\\Paradigmas\\arbol.txt";
            String fileOutputPath = "C:\\Users\\Aylin\\Documents\\NetBeansProjects\\Paradigmas\\src\\Imagenes\\arbol.jpg";

            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);

        } catch (Exception ex) {
        } finally {
        }

    }

    public static String crearNodo() {
        String cadena = "";
        int numNodo = 1;
        for (int i = 0; i < Metodo_FuncionHK.metodoFuncionHK.size(); i++) {
            MF m = (MF) Metodo_FuncionHK.metodoFuncionHK.get(i);
            cadena += "nodo" + numNodo + "[shape=record, color=blue, label= \"" + m.nombre + "\"]nodo0->nodo" + numNodo + ";\n";
            int numHijo = numNodo;
            for (int j = 0; j < m.parametro.size(); j++) {
                numHijo++;
                String p = (String) m.parametro.get(j);
                cadena += "nodo" + numHijo + "[shape=record, color=blue, label= \"" + p + "\"]nodo" + numNodo + "->nodo" + numHijo + ";\n";
            }
            numNodo=numHijo+1;
        }
        return cadena;
    }
}
