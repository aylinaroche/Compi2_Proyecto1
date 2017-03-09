package Arbol;
import java.util.ArrayList;

public class NodoArreglo {
    private int id;
    private Nodo nodo;
    private NodoArreglo siguiente;
    private NodoArreglo anterior;
    private ListaNodos lista;

    @Override
    public String toString() {
        return "NodoArreglo{" + "id=" + id + ", nodo=" + nodo + ", siguiente=" + siguiente + ", anterior=" + anterior + ", lista=" + lista + '}';
    }
    
    public NodoArreglo(){
    }
    
    public NodoArreglo(int id, String tipo){
        this.id=id;
        this.nodo=new Nodo("nulo",tipo);
        this.siguiente=null;
        this.anterior=null;
        this.lista=null;
    }
    
    public NodoArreglo(int id, ArrayList indices, String tipo){
        this.id=id;
        this.nodo=null;
        this.siguiente=null;
        this.anterior=null;
        this.lista=new ListaNodos(indices, tipo);
    }
    
    public NodoArreglo(NodoArreglo clon){
        this.id=clon.getId();
        this.nodo=clon.getNodo();
        this.lista=null;
        this.siguiente=null;
        this.anterior=null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }

    public NodoArreglo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoArreglo siguiente) {
        this.siguiente = siguiente;
    }

    public NodoArreglo getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoArreglo anterior) {
        this.anterior = anterior;
    }

    public ListaNodos getLista() {
        return lista;
    }

    public void setLista(ListaNodos lista) {
        this.lista = lista;
    }
    
    
    
}
