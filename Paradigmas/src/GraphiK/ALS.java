package Graphik;

import Graphik.Ejecutar.NodoG;
import Graphik.Ejecutar.RecorridoGuardar;
import Graphik.Ejecutar.VariableG;
import java.util.ArrayList;

/**
 *
 * @author Aylin
 */
public class ALS {

    public static ArrayList listaALS = new ArrayList();
    public static ArrayList<varALS> variableALS = new ArrayList();

    public static void agregarALS(String nombre, NodoG nodo, String visible) {
        ObjetoALS obj = new ObjetoALS();
        obj.nombre = nombre;
        obj.nodo = nodo;
        obj.visibilidad = visible;
        listaALS.add(obj);
        paradigmas.Atributos.crearSimboloGraphik(nombre, "ALS", "Objeto ALS", "Clase", " - ");
    }

    public static Object buscarALS(String nombre) {
        Object retorno = "";
        for (int i = 0; i < listaALS.size(); i++) {
            ObjetoALS obj = (ObjetoALS) listaALS.get(i);

            if (obj.nombre.equals(nombre)) {
                VariableG.pilaAmbito.push("Global");
                VariableG.nivelAmbito++;
                VariableG.nombreALS.push(nombre);
                try {
                    RecorridoGuardar g = new RecorridoGuardar();
                    retorno = g.Recorrido(obj.nodo);
                } catch (Exception ex) {
                    System.out.println("Error ALS = " + ex);
                }
                //   VariableG.eliminarVariable();
                VariableG.nivelAmbito--;
                VariableG.pilaAmbito.pop();
                VariableG.nombreALS.pop();
                return retorno;
            }
        }
        paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "No se ha encontrado el metodo", 0, 0);

        return "";
    }

    public static String tipoALS(String nombre) {
        for (int i = 0; i < variableALS.size(); i++) {
            varALS v = variableALS.get(i);
            if (v.nombre.equals(nombre)) {
                return v.als;
            }
        }
        //paradigmas.ReporteError.agregarErrorGK(nombre, "Error Semantico", "No se ha encontrado el metodo", 0, 0);
        return "";
    }

    public static void agregarVariableALS(String als, String nombre) {
        varALS ins = new varALS();
        ins.als = als;
        ins.nombre = nombre;
        variableALS.add(ins);

    }

}

class ObjetoALS {

    public String nombre;
    public String visibilidad;
    public NodoG nodo;
}

class varALS {

    public String nombre;
    public String als;
}
