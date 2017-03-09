package Arbol;


public class VariableLocal {

    public String nombre;
    public String tipo;
    public Nodo valor;

    VariableLocal sig;

    public void setValor(Nodo valor) {
        this.valor = valor;
    }
    VariableLocal ant;

    public VariableLocal(String nombre, String tipo, Nodo valor) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
    }

    public VariableLocal(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        valor = new Nodo("nulo", tipo);
    }

    @Override
    public String toString() {
        return "VariableLocal{" + "nombre=" + nombre + ", tipo=" + tipo + ", valor=" + valor + ", sig=" + sig + ", ant=" + ant + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public VariableLocal getSig() {
        return sig;
    }

    public void setSig(VariableLocal sig) {
        this.sig = sig;
    }

    public VariableLocal getAnt() {
        return ant;
    }

    public void setAnt(VariableLocal ant) {
        this.ant = ant;
    }
    
}
