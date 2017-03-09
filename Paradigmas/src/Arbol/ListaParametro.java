
package Arbol;


import java.util.ArrayList;


public class ListaParametro {
    
public ArrayList<VariableLocal> listaParametros;

    public ListaParametro() {
        listaParametros = new ArrayList();
    }

    @Override
    public String toString() {
        return "ListaParametro{" + "listaParametros=" + listaParametros + '}';
    }

    public ArrayList<VariableLocal> getListaParametros() {
        return listaParametros;
    }

    public void setListaParametros(ArrayList<VariableLocal> listaParametros) {
        this.listaParametros = listaParametros;
    }

    public void insertar(VariableLocal nueva) {
        if (existe(nueva.nombre)) {
            System.out.println("El parametro: " + nueva.nombre + " ya existe");
     //       TablaDeErrores.getInstance().insertar(new nodoError("El parametro: " + nueva.nombre + " ya existe","Semantico"));
            return;
        }
        listaParametros.add(nueva);
    }

    boolean existe(String nombre) {
        if (nombre.equals("tmp$$")) return false;
         for (VariableLocal varLocal : listaParametros) {
            if (varLocal.nombre.equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public VariableLocal buscar(String nombre) {
        for (VariableLocal actual : listaParametros) {
            if (actual.nombre.equals(nombre)) {
                return actual;
            }
        }
        return null;
    }

}

