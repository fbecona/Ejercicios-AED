package tda.arbol.avl;

public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    public TArbolBB() {
        raiz = null;
    }

    @Override
    public void insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
        } else {
            raiz = raiz.insertar(unElemento);
        }
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }
    
    public TElementoAB<T> buscarWithContains(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscarConContains(unaEtiqueta);
        }
    }
    
    public int obtenerAltura() {
        if (raiz != null){
            return raiz.obtenerAltura();
        }
        else{
            return -1;
        }
    }   

    public boolean esAvl(){
        if(raiz!=null){
            return raiz.esAvl();
        }else{
            return true;
        }
    }
    
    public boolean esVacio() {
        return (raiz == null);
    }

    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }
    
    public TElementoAB<T> getRaiz(){
        return this.raiz;
    }  
    
    public String inOrden() {
        if (raiz == null) {
            return "arbol vacio";
        } else {
            return raiz.inOrden();
        }
    }    
    
    public Lista<T> inOrdenLista() {
        Lista <T> listaInorden = null;
        if (raiz!=null) {
            listaInorden = new Lista<>();
            raiz.inOrdenLista(listaInorden);
        }
        return listaInorden;
    } 
    
    public int obtenerTamanio() {
        if (raiz!=null) {
            return raiz.obtenerTamanio();
        } else {
            return 0;
        }
    }       
}
