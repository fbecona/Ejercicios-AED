package arboles.genericos;


public interface IArbolGenerico<T> {
    
    public TElementoGenerico getRaiz();

    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre);
    
    public TElementoGenerico<T> buscar(Comparable unaEtiqueta);
    
    public void listarOrdenado();
}
