package tda.lista.completo;

public class Nodo<T> implements INodo<T> { 
    //implementa INodo<T> y añade al tipo: setDato(), clonar(), equals(), 
    
    private final Comparable etiqueta;
    private T dato;
    private Nodo<T> siguiente = null;

    public Nodo(Comparable etiqueta, T dato ) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    @Override
    public T getDato() {
        return this.dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public void imprimir() {
        System.out.println(dato.toString());
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

    @Override
    public Nodo<T> clonar() {   //IMPORTANTE
        return new Nodo<>(this.etiqueta, this.dato);
    }

    public boolean equals(Nodo unNodo) {
       return this.etiqueta.equals(unNodo.getEtiqueta());
    }

    @Override
    public int compareTo(Comparable etiqueta) {     //IMPORTANTE
        return this.etiqueta.compareTo(etiqueta);
    }

    @Override
    public Nodo<T> getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void setSiguiente(Nodo<T> nodo) {
        this.siguiente = nodo;
    }

}
