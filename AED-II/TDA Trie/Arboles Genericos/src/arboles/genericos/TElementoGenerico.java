package arboles.genericos;

public class TElementoGenerico<T> implements IElementoGenerico<T> {

    private final Comparable etiqueta;
    private TElementoGenerico<T> hijoIzq;
    private TElementoGenerico<T> hermanoDer;
    private final T datos;

    public TElementoGenerico(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
        hijoIzq = null;
        hermanoDer = null;
    }

    @Override
    public TElementoGenerico<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public TElementoGenerico<T> getHermanoDer() {
        return hermanoDer;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }
    
    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public void setHijoIzq(TElementoGenerico<T> elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHermanoDer(TElementoGenerico<T> elemento) {
        this.hermanoDer = elemento;
    }
    
    @Override
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre) {
        if(this.etiqueta==etiquetaPadre){
            if(hijoIzq == null){
                this.setHijoIzq(new TElementoGenerico(unaEtiqueta, null));
            }else{
                TElementoGenerico aux = this.hijoIzq;
                while(aux.getHermanoDer()!=null){
                    aux = aux.getHermanoDer();
                }
                aux.setHermanoDer(new TElementoGenerico(unaEtiqueta, null));
            }
            return true;
        }
        TElementoGenerico aux = this.hijoIzq;
        while(aux!=null){
            if(aux.insertar(unaEtiqueta, etiquetaPadre)){
                return true;
            }
            aux = aux.getHermanoDer();
        }
        return false;
    }

    @Override
    public TElementoGenerico<T> buscar(Comparable unaEtiqueta) {
        if(this.etiqueta == unaEtiqueta){
            return this;
        }
        TElementoGenerico aux = this.hijoIzq;
        while(aux!=null){
            TElementoGenerico busqueda = aux.buscar(unaEtiqueta);
            if(busqueda!=null){
                return busqueda;
            }
            aux = aux.getHermanoDer();
        }
        return null;

    }

    @Override
    public void listarOrdenado(String tabsAnteriores) {
        System.out.println(tabsAnteriores + etiqueta);
        TElementoGenerico aux = this.hijoIzq;
        while(aux!=null){
            aux.listarOrdenado('\t' + tabsAnteriores);
            aux = aux.getHermanoDer();
        }        
    }
}
