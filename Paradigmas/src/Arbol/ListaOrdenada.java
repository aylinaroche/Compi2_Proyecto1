/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

/**
 *
 * @author rudy6_000
 */
public class ListaOrdenada {

    private NodoArreglo inicio;
    private NodoArreglo fin;
    private int contador;

    private static ListaOrdenada listaOrdenada;

    private ListaOrdenada() {
        inicio = null;
        fin = null;
    }

    public static ListaOrdenada getInstance() {
        if (listaOrdenada == null) {
            listaOrdenada = new ListaOrdenada();
        }
        return listaOrdenada;
    }

    public static void reinicializar() {
        listaOrdenada = new ListaOrdenada();
    }

    public int insertar(NodoArreglo nuevo, int ordenamiento, String tipo) {
        if (inicio == null) {
            inicio = nuevo;
            fin = inicio;
        } else {
            //dependiendo de que tipo de ordenamiento sea se va ordenar la lista cuando se inserte
            switch (ordenamiento) {
                case 1:
                    contador++;
                    return insertarAscDesc(nuevo, tipo, 1);
                case 2:
                    contador++;
                    return insertarAscDesc(nuevo, tipo, 2);
                case 3:
                    contador++;
                    return insertarParesImpares(nuevo, tipo, 3);
                case 4:
                    contador++;
                    return insertarParesImpares(nuevo, tipo, 4);
                case 5:
                    contador++;
                    return insertarPrimos(nuevo, tipo);
                case 6:
                    this.fin.setSiguiente(nuevo);
                    nuevo.setAnterior(this.fin);
                    this.fin = nuevo;
                    break;
                default:
                    return 0;
            }
        }
        contador++;
        return 1;
    }
    
    private boolean esPrimo(int numero) {
        int contador = 2;
        boolean primo = true;
        while ((primo) && (contador != numero)) {
            if (numero % contador == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }

    private int insertarPrimos(NodoArreglo nuevo, String tipo) {
        NodoArreglo temporalPares = inicio;
        if (tipo.equalsIgnoreCase("entero") || tipo.equalsIgnoreCase("decimal")) {
            double valorNuevo = Double.parseDouble(nuevo.getNodo().valor);
            int aproximacion = (int) valorNuevo;
            //si el valor es par se inserta al inicio
            if (esPrimo(aproximacion)) {
                temporalPares = inicio;
            } else {
                temporalPares = null;
            }
        } else if (tipo.equalsIgnoreCase("caracter")) {
            char valor = nuevo.getNodo().valor.charAt(1);
            int valorNuevo = (int) valor;
            //si el valor del ascii es par:
            if ((esPrimo(valorNuevo))) {
                temporalPares = inicio;
            } else {
                temporalPares = null;
            }
        } else {
            //no se puede declarar ordenamiento de pares de cadenas por lo tanto tira error
            System.out.println("Error, no es posible un ordenamiento de primos de tipo: " + tipo);
//            //TablaDeErrores.getInstance().insertar(new nodoError("Error, no es posible un ordenamiento de primos de tipo: " + tipo,"Semantico"));
            return 0;
        }
        //si viene antes del primero
        if (temporalPares == inicio) {
            inicio.setAnterior(nuevo);
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        } //si viene despues del ultimo elemento
        else if (temporalPares == null) {
            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
        }
        return 1;
    }

    private int insertarParesImpares(NodoArreglo nuevo, String tipo, int ordenamiento) {
        NodoArreglo temporalPares = inicio;
        if (tipo.equalsIgnoreCase("entero") || tipo.equalsIgnoreCase("decimal")) {
            double valorNuevo = Double.parseDouble(nuevo.getNodo().valor);
            int aproximacion = (int) valorNuevo;
            //si el valor es par se inserta al inicio
            if ((aproximacion % 2 == 0 && ordenamiento == 3) || (aproximacion % 2 != 0 && ordenamiento == 4)) {
                temporalPares = inicio;
            } else {
                temporalPares = null;
            }
        } else if (tipo.equalsIgnoreCase("caracter")) {
            char valor = nuevo.getNodo().valor.charAt(1);
            int valorNuevo = (int) valor;
            //si el valor del ascii es par:
            if ((valorNuevo % 2 == 0 && ordenamiento == 3) || (valorNuevo % 2 != 0 && ordenamiento == 4)) {
                temporalPares = inicio;
            } else {
                temporalPares = null;
            }
        } else {
            //no se puede declarar ordenamiento de pares de cadenas por lo tanto tira error
            System.out.println("Error, no es posible un ordenamiento de pares/impares de tipo: " + tipo);
            //TablaDeErrores.getInstance().insertar(new nodoError("Error, no es posible un ordenamiento de  pares/impares de tipo: " + tipo,"Semantico"));
            return 0;
        }
        //si viene antes del primero
        if (temporalPares == inicio) {
            inicio.setAnterior(nuevo);
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        } //si viene despues del ultimo elemento
        else if (temporalPares == null) {
            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
        }
        return 1;
    }

    private int insertarAscDesc(NodoArreglo nuevo, String tipo, int ordenamiento) {
        NodoArreglo temporalNumero = inicio;
        if (tipo.equalsIgnoreCase("entero") || tipo.equalsIgnoreCase("decimal")) {
            double valorNuevo = Double.parseDouble(nuevo.getNodo().valor);
            //se encuentra la posicion que sera la siguiente a la del nuevo nodo
            while (temporalNumero != null) {
                double valorTemporal = Double.parseDouble(temporalNumero.getNodo().valor);
                //si es orden ascendente
                if (ordenamiento == 1 && valorNuevo < valorTemporal) {
                    break;
                } //si es orden descendente
                else if (ordenamiento == 2 && valorNuevo > valorTemporal) {
                    break;
                }
                temporalNumero = temporalNumero.getSiguiente();
            }
        } else if (tipo.equalsIgnoreCase("caracter")) {
            char valor = nuevo.getNodo().valor.charAt(1);
            int valorNuevo = (int) valor;
            System.out.println("char: " + valor + "; ascii: " + valorNuevo);
            //se encuentra la posicion que sera la siguiente a la del nuevo nodo
            while (temporalNumero != null) {
                char caracterTemporal = temporalNumero.getNodo().valor.charAt(1);
                int valorTemporal = (int) caracterTemporal;
                //si es orden ascendente
                if (ordenamiento == 1 && valorNuevo < valorTemporal) {
                    break;
                } //si es orden descendente
                else if (ordenamiento == 2 && valorNuevo > valorTemporal) {
                    break;
                }
                temporalNumero = temporalNumero.getSiguiente();
            }
        } else {
            //se encuentra la posicion que sera la siguiente a la del nuevo nodo
            while (temporalNumero != null) {
                //si es orden ascendente
                if (ordenamiento == 1 && (nuevo.getNodo().valor.compareToIgnoreCase(temporalNumero.getNodo().valor) < 0)) {
                    break;
                } else if (ordenamiento == 2 && (nuevo.getNodo().valor.compareToIgnoreCase(temporalNumero.getNodo().valor) > 0)) {
                    break;
                }
                temporalNumero = temporalNumero.getSiguiente();
            }
        }
        //si viene antes del primero
        if (temporalNumero == inicio) {
            inicio.setAnterior(nuevo);
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        } //si viene despues del ultimo elemento
        else if (temporalNumero == null) {
            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
        } //si viene en medio
        else {
            nuevo.setAnterior(temporalNumero.getAnterior());
            nuevo.setSiguiente(temporalNumero);
            temporalNumero.getAnterior().setSiguiente(nuevo);
            temporalNumero.setAnterior(nuevo);
        }
        return 1;
    }
    

    public void imprimir() {
        NodoArreglo temporal = inicio;
        while (temporal != null) {
            System.out.println("En la lista ordena existe: " + temporal.getNodo().texto);
            temporal = temporal.getSiguiente();
        }
    }

    public Nodo sacar() {
        NodoArreglo devuelta = new NodoArreglo(inicio);
        inicio = inicio.getSiguiente();
        return devuelta.getNodo();
    }

    public NodoArreglo getInicio() {
        return inicio;
    }

    public void setInicio(NodoArreglo inicio) {
        this.inicio = inicio;
    }

    public NodoArreglo getFin() {
        return fin;
    }

    public void setFin(NodoArreglo fin) {
        this.fin = fin;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

}
