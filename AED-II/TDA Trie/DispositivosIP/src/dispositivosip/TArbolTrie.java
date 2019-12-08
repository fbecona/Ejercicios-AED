package dispositivosip;

import java.util.Collection;
import java.util.LinkedList;

public class TArbolTrie implements IArbolTrie{
    
    private TNodoTrie raiz;
    
    @Override
    public void insertar(Dispositivo dipositivo){
        if(raiz == null){
            raiz = new TNodoTrie();
        }
        raiz.insertar(dipositivo);
    }

    @Override
    public Collection<Dispositivo> buscarDispositivos(String subred) {
        Collection<Dispositivo> coleccion = new LinkedList<>();
        if(raiz!=null){
            raiz.buscarDispositivos(subred, coleccion);
        }
        return coleccion;    
    }
}
