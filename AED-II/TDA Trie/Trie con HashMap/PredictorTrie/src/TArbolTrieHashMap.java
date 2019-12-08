

import java.util.LinkedList;


public class TArbolTrieHashMap implements IArbolTrie {

    private TNodoTrieHashMap raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
        }
        raiz.insertar(palabra);
    }

    @Override
    public int buscar(String palabra) {
        return raiz.buscar(palabra);          
    }    
    
    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }


    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> palabras = new LinkedList<>();
        if(raiz!=null){
            this.raiz.predecir(prefijo, palabras);
        }
        return palabras;
    }
}
