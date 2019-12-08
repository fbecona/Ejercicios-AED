package buscartelefonos;

import java.util.Collection;
import java.util.LinkedList;

public class TArbolTrie implements IArbolTrie{
    
    private TNodoTrie raiz;
    
    @Override
    public void insertar(TAbonado abonado){
        if(raiz == null){
            raiz = new TNodoTrie();
        }
        raiz.insertar(abonado);
    }

    @Override
    public Collection<TAbonado> buscarTelefonos(String pais, String area) {
        LinkedList<TAbonado> lista = new LinkedList<>();
        if(raiz!=null){
            raiz.buscarTelefonos(pais+area, lista);
        }
        return (Collection<TAbonado>) lista;    
    }
}
