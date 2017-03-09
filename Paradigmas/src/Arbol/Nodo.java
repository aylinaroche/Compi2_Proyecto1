package Arbol;

import java.util.ArrayList;

public class Nodo {

    public String texto; //texto del token o No Terminal
    public String valor; //atributo valor que toman los tokens y que iran tomando los no terminales al sintetizar
    public int cantidadHijos; //entero auxiliar para saber el numero de hijos de un Nodo
    public Nodo padre; //Nodo padre
    public Nodo hijos[]; //arreglo de hijos
    public String tipo; //tipo de los terminales de la produccion F
    public ListaNodos nodosArr; //valor utilizado para igualar un arreglo a otro
    public String ambito;

    //Atributos que no son utilizados 
    public Nodo nodoHeredado; //hermanos o padre
    public ArrayList<Integer> posiciones; //lista con los indices en donde se debe insertar un dato en un arreglo cuando se asigna inmediatamente, es decir x2[][] = {1,2,3}....}
//    public Arreglo Arr; //arreglo que se utiliza cuando se asigna inmediatamente, este va bajando para obtener sus valores
    //  public ArregloLocal ArrLocal; //funciona igual que el arreglo pero se maneja en la pila

    public ListaParametro parametros; //lista de parametros que se utiliza para las llamadas a metodos

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
 //       this.ambito = ambito;
    }

    public Nodo() {
    }

    public void insertarNodoHijo(Nodo nuevo, Nodo nueva2) {

        if (nuevo == null) {
            return; //si el nodo nuevo es nulo, no se creo en la gramatica y no debe ser agregado por lo tanto
        }
        //Se declara un nodo auxiliar para contener a los hijos
        Nodo aux[] = new Nodo[this.cantidadHijos + 1];

        //se copian los hijos del nodo al auxiliar
        for (int i = 0; i < this.cantidadHijos; i++) {
            aux[i] = this.hijos[i];
            aux[i].padre = this;
        }
        //Se indica el padre del nuevo nodo y se inserta al arreglo de hijos
        nuevo.padre = this;
        aux[this.cantidadHijos] = nuevo;

        //se asigna los hijos en el arreglo auxiliar al Nodo y aumenta el numero de hijos
        this.hijos = aux;
        this.cantidadHijos++;

    }

    public void insertar(Nodo nuevo) {
        if (nuevo == null) {
            return; //si el nodo nuevo es nulo, no se creo en la gramatica y no debe ser agregado por lo tanto
        }
        //Se declara un nodo auxiliar para contener a los hijos
        Nodo aux[] = new Nodo[this.cantidadHijos + 1];

        //se copian los hijos del nodo al auxiliar
        for (int i = 0; i < this.cantidadHijos; i++) {
            aux[i] = this.hijos[i];
            aux[i].padre = this;
        }
        //Se indica el padre del nuevo nodo y se inserta al arreglo de hijos
        nuevo.padre = this;
        aux[this.cantidadHijos] = nuevo;

        //se asigna los hijos en el arreglo auxiliar al Nodo y aumenta el numero de hijos
        this.hijos = aux;
        this.cantidadHijos++;

    }
}
