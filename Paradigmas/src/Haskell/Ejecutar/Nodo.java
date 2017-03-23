package Haskell.Ejecutar;


public class Nodo {

    public String texto;
    public String valor;
    public int cantidadHijos;
    public Nodo padre;
    public Nodo hijos[];
    public String tipo;
    public String ambito;

    public Nodo(String texto) {
        this.texto = texto;
        this.valor = texto;
        this.tipo = texto;
        this.cantidadHijos = 0;
    }

    public Nodo(String texto, String tipo) {
        this.texto = texto;
        this.valor = texto;
        this.tipo = tipo;
        this.cantidadHijos = 0;
    }

    public void insertarHijo(Nodo nuevo, Nodo nueva2) {

        if (nuevo == null) {
            return;
        }
        Nodo aux[] = new Nodo[this.cantidadHijos + 1];

        for (int i = 0; i < this.cantidadHijos; i++) {
            aux[i] = this.hijos[i];
            aux[i].padre = this;
        }
        nuevo.padre = this;
        aux[this.cantidadHijos] = nuevo;
        this.hijos = aux;
        this.cantidadHijos++;

    }

    public void insertar(Nodo nuevo) {
        if (nuevo == null) {
            return; //si el nodo nuevo es nulo, no se creo en la gramatica y no debe ser agregado por lo tanto
        }
        Nodo aux[] = new Nodo[this.cantidadHijos + 1];
        //se copian los hijos del nodo al auxiliar
        for (int i = 0; i < this.cantidadHijos; i++) {
            aux[i] = this.hijos[i];
            aux[i].padre = this;
        }
        nuevo.padre = this;
        aux[this.cantidadHijos] = nuevo;
        this.hijos = aux;
        this.cantidadHijos++;

    }
}
