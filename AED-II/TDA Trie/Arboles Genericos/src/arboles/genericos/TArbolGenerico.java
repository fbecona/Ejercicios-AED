package arboles.genericos;

public class TArbolGenerico<T> implements IArbolGenerico<T> {

    TElementoGenerico<T> raiz;

    public TArbolGenerico() {
        raiz = null;
    }

    @Override
    public TElementoGenerico<T> getRaiz() {
        return raiz;
    }

    @Override
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre) {
        if(etiquetaPadre==""){
            raiz = new TElementoGenerico<>(unaEtiqueta,null);
            return true;
        }
        if(this.raiz!=null){
            return raiz.insertar(unaEtiqueta, etiquetaPadre);
        }
        return false;
    }
    
    @Override
    public TElementoGenerico<T> buscar(Comparable unaEtiqueta) {
        if(raiz!=null){
            return raiz.buscar(unaEtiqueta);
        }
        return null;
    }

    @Override
    public void listarOrdenado() {
        if(raiz!=null){
            raiz.listarOrdenado("");
        }

    }

}
