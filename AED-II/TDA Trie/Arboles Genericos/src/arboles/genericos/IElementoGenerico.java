package arboles.genericos;

public interface IElementoGenerico<T> {

    public Comparable getEtiqueta();

    public T getDatos();
    
    public TElementoGenerico<T> getHijoIzq();

    public TElementoGenerico<T> getHermanoDer();
    
    public void setHijoIzq(TElementoGenerico<T> elemento);

    public void setHermanoDer(TElementoGenerico<T> elemento);
    
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre);
    
    public TElementoGenerico<T> buscar(Comparable unaEtiqueta);
    
    public void listarOrdenado(String tabsAnteriores);    
}




