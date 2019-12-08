package subsecuencias;

import java.util.LinkedList;

public class TArbolTrie  {
    
    private TNodoTrie raiz;

    public TNodoTrie getRaiz() {
        return raiz;
    }
    
    public void insertar(String palabra, int inicioPalabra){
        if(raiz == null){
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra,inicioPalabra);
    }
    
    public LinkedList<String> buscarSecuencia(String texto){
        LinkedList<String> resultado = new LinkedList<>();
        if(raiz!=null){
            raiz.buscarSecuencia(texto,resultado);
        }
        return resultado;
    }

}
