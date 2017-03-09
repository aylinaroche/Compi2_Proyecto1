package Arbol;

import java.util.ArrayList;

public class ListaNodos {

    private NodoArreglo inicio;
    private NodoArreglo fin;
    private int contador;

    public ListaNodos(ArrayList indices, String tipo) {
        //si el arreglo de indices tiene mas de un elemento quiere decir que se necesita agregar una dimension mas al arreglo
        if (indices.size() > 1) {
            //se creara el nuevo ArrayList de indices que se utilizara en los nodos de esta lista
            ArrayList indicesAuxiliares = new ArrayList(indices);
            indicesAuxiliares.remove(0);
            //se obtiene la cantidad de elementos disponibles para esta lista            
            int primerIndice = (Integer) indices.get(0);
            int contadorAuxiliar = 1;
            while (contadorAuxiliar <= primerIndice) {
                //se crea el nodo al cual se le incluira sus listas pertinentes (lista de listas para simular las dimensiones de un arreglo)
                NodoArreglo temporal = new NodoArreglo(contadorAuxiliar, indicesAuxiliares, tipo);
                this.insertar(temporal);
                contadorAuxiliar++;
            }
        } else {
            int contadorAuxiliar = 1;
            int y = (Integer) indices.get(0);
            while (contadorAuxiliar <= y) {
                this.insertar(new NodoArreglo(contadorAuxiliar, tipo));
                contadorAuxiliar++;
            }
        }
    }

    private void insertar(NodoArreglo nuevo) {
        if (inicio == null) {
            inicio = nuevo;
            fin = inicio;
        } else {
            this.fin.setSiguiente(nuevo);
            nuevo.setAnterior(this.fin);
            this.fin = nuevo;
        }
        contador++;
    }

    public void ingresarNodo(Nodo AIngresar, ArrayList indices) {
        int primerIndice = (Integer) indices.get(0);
        if ((primerIndice + 1) > this.contador) {
            System.out.println("Los parametros utilizados para almacenar un elemento dentro del arreglo son incorrectos");
            
            //TablaDeErrores.getInstance().insertar(new nodoError("Los parametros utilizados para almacenar un elemento dentro del arreglo son incorrectos","Semantico"));
            return;
        }
        //Si existe otro elemento en el arreglo quiere decir que es necesario recorrer otra lista
        if (indices.size() > 1) {

            //se creara el nuevo ArrayList de indices que se utilizara en los nodos de esta lista
            ArrayList indicesAuxiliares = new ArrayList(indices);
            indicesAuxiliares.remove(0);

            //se obtiene la cantidad de elementos disponibles para esta lista            
            primerIndice = (Integer) indices.get(0);
            int contadorAuxiliar = 0;
            NodoArreglo temporal = inicio;
            while (contadorAuxiliar < primerIndice) {
                temporal = temporal.getSiguiente();
                
                contadorAuxiliar++;
            }
            //verifica que no haya ingresado una dimension de mas
            if (temporal.getLista() == null) {
                System.out.println("Los parametros utilizados para almacenar un elemento dentro del arreglo son incorrectos");
                //TablaDeErrores.getInstance().insertar(new nodoError("Los parametros utilizados para almacenar un elemento dentro del arreglo son incorrectos","Semantico"));
                return;
            }
            temporal.getLista().ingresarNodo(AIngresar, indicesAuxiliares);
        } else {
            //se obtiene la cantidad de elementos disponibles para esta lista            
            primerIndice = (Integer) indices.get(0);
            int contadorAuxiliar = 0;
            NodoArreglo temporal = inicio;
            while (contadorAuxiliar < primerIndice) {
                temporal = temporal.getSiguiente();
                contadorAuxiliar++;
            }
            //verifica que no haya ingresado una dimension menos
            if (temporal.getLista() != null) {
                System.out.println("Los parametros utilizados para almacenar un elemento dentro del arreglo son incorrectos");
                //TablaDeErrores.getInstance().insertar(new nodoError("Los parametros utilizados para almacenar un elemento dentro del arreglo son incorrectos","Semantico"));
                return;
            }
            //verifica que el tipo del nodo a ingresar sea el correcto
////            if (Recoleccion.compararTipo(AIngresar, temporal.getNodo()) == null) {
////                System.out.println("No se puede ingresar un elemento de tipo: " + AIngresar.tipo + " en un arreglo de tipo: " + temporal.getNodo().tipo);
////                //TablaDeErrores.getInstance().insertar(new nodoError("No se puede ingresar un elemento de tipo: " + AIngresar.tipo + " en un arreglo de tipo: " + temporal.getNodo().tipo,"Semantico"));
////                return;
////            }
            temporal.setNodo(AIngresar);
        }
    }

    public Nodo retornarNodo(ArrayList indices) {
        int primerIndice = (Integer) indices.get(0);
        if ((primerIndice + 1) > this.contador) {
            System.out.println("Los parametros utilizados para retornar un elemento dentro del arreglo son incorrectos");
            //TablaDeErrores.getInstance().insertar(new nodoError("Los parametros utilizados para retornar un elemento dentro del arreglo son incorrectos","Semantico"));
            return null;
        }
        //Si existe otro elemento en el arreglo quiere decir que es necesario recorrer otra lista
        if (indices.size() > 1) {
            //se creara el nuevo ArrayList de indices que se utilizara en los nodos de esta lista
            ArrayList indicesAuxiliares = new ArrayList(indices);
            indicesAuxiliares.remove(0);

            int contadorAuxiliar = 0;
            NodoArreglo temporal = inicio;
            while (contadorAuxiliar < primerIndice) {
                temporal = temporal.getSiguiente();
                contadorAuxiliar++;
            }
            //verifica que no haya ingresado una dimension de mas
            if (temporal.getLista() == null) {
                System.out.println("Los parametros utilizados para retornar un elemento dentro del arreglo son incorrectos");
                //TablaDeErrores.getInstance().insertar(new nodoError("Los parametros utilizados para retornar un elemento dentro del arreglo son incorrectos","Semantico"));
                return null;
            }
            return temporal.getLista().retornarNodo(indicesAuxiliares);
        } else {
            int contadorAuxiliar = 0;
            NodoArreglo temporal = inicio;
            while (contadorAuxiliar < primerIndice) {
                temporal = temporal.getSiguiente();
                contadorAuxiliar++;
            }
            //verifica que no haya ingresado una dimension menos
            if (temporal.getLista() != null) {
                System.out.println("Los parametros utilizados para retornar un elemento dentro del arreglo son incorrectos");
                //TablaDeErrores.getInstance().insertar(new nodoError("Los parametros utilizados para retornar un elemento dentro del arreglo son incorrectos","Semantico"));
                return null;
            }
            return temporal.getNodo();
        }
    }

    public int obtenerListaOrdenada(int ordenamiento, String tipo) {
        if (inicio == null) {
            System.out.println("La lista esta vacia");
            
            return 0;
        }
        NodoArreglo temporal = inicio;

        while (temporal != null) {
            if (temporal.getLista() != null) {
                if(temporal.getLista().obtenerListaOrdenada(ordenamiento, tipo)==0){
                    return 0;
                }
            } else //se verifica que el nodo del temporal sea diferente de nulo para agregarlo a la lista ordenada
             if (!temporal.getNodo().texto.equals("nulo")) {
                    NodoArreglo respuesta = new NodoArreglo(temporal);
                    if(ListaOrdenada.getInstance().insertar(respuesta, ordenamiento, tipo)==0){
                        return 0;
                    }
                }
            temporal = temporal.getSiguiente();
        }
        return 1;
    }

    public void ordenar(String tipo) {
        NodoArreglo temporal = inicio;
        while (temporal != null) {
            if (temporal.getLista() != null) {
                temporal.getLista().ordenar(tipo);
            } else if (ListaOrdenada.getInstance().getInicio() == null) {
                temporal.setNodo(new Nodo("nulo", tipo));
            } else {
                temporal.setNodo(ListaOrdenada.getInstance().sacar());
            }
            temporal = temporal.getSiguiente();
        }
    }
    
    public void ordenarClon(String tipo, ListaNodos clonada) {
        NodoArreglo temporal = inicio;
        NodoArreglo temporalClonada = clonada.getInicio();
        
        while (temporal != null) {
            if (temporal.getLista() != null) {
                temporal.getLista().ordenarClon(tipo, temporalClonada.getLista());
            } else if (temporalClonada.getNodo().texto.equals("nulo")) {
                temporal.setNodo(new Nodo("nulo", tipo));
            } else {
                temporal.setNodo(ListaOrdenada.getInstance().sacar());
            }
            temporal = temporal.getSiguiente();
            temporalClonada=temporalClonada.getSiguiente();
        }
    }

    public ArrayList obtenerDimensiones(){
        ArrayList indices = new ArrayList();
        ListaNodos temporal = this;
        while(temporal!=null){
            indices.add(temporal.getContador());
            temporal=temporal.getInicio().getLista();
        }
        return indices;
    }
    
    public String obtenerTipo(){
        NodoArreglo temporal = inicio;
        while(temporal!=null){
            if(temporal.getLista()==null){
                return temporal.getNodo().tipo;
            }
            temporal=temporal.getLista().getInicio();
        }
        return "nulo";
    }
    
    public String obtenerCadenaCaracter(int tipo) {
        String respuesta = "";
        NodoArreglo temporalNumero = inicio;
        while (temporalNumero != null) {
            //si es un nodo que es una lista de listas
            if (temporalNumero.getLista() != null) {
                respuesta += temporalNumero.getLista().obtenerCadenaCaracter(tipo);
            } else if (tipo == 1 && (!temporalNumero.getNodo().texto.equals("nulo"))) {
                respuesta += temporalNumero.getNodo().valor.substring(1, temporalNumero.getNodo().valor.length() - 1);
            } else if (tipo == 2 && (!temporalNumero.getNodo().texto.equals("nulo"))) {
                String auxiliarCadena =temporalNumero.getNodo().valor.substring(1, 2);
                respuesta += auxiliarCadena.substring(0, 1);
            }
            temporalNumero = temporalNumero.getSiguiente();
        }
        return respuesta;
    }

    public int obtenerEntero() {
        int respuesta = 0;

        NodoArreglo temporalNumero = inicio;
        while (temporalNumero != null) {
            //si es un nodo que es una lista de listas
            if (temporalNumero.getLista() != null) {
                respuesta += temporalNumero.getLista().obtenerEntero();
            } else if (!temporalNumero.getNodo().texto.equals("nulo")) {
                respuesta += Integer.parseInt(temporalNumero.getNodo().valor);
            }
            temporalNumero = temporalNumero.getSiguiente();
        }
        return respuesta;
    }
    
    public double obtenerDecimal(){
    double respuesta = 0;

        NodoArreglo temporalNumero = inicio;
        while (temporalNumero != null) {
            //si es un nodo que es una lista de listas
            if (temporalNumero.getLista() != null) {
                respuesta += temporalNumero.getLista().obtenerDecimal();
            } else if (!temporalNumero.getNodo().texto.equals("nulo")) {
                respuesta += Double.parseDouble(temporalNumero.getNodo().valor);
            }
            temporalNumero = temporalNumero.getSiguiente();
        }
        return respuesta;
    }

    public NodoArreglo getInicio() {
        return inicio;
    }

    public NodoArreglo getFin() {
        return fin;
    }

    public int getContador() {
        return contador;
    }

    public void setInicio(NodoArreglo inicio) {
        this.inicio = inicio;
    }

    public void setFin(NodoArreglo fin) {
        this.fin = fin;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

}
