package subsecuencias;

import java.util.LinkedList;

public class TNodoTrie {
    
    private static final int CANT_CHR_ABECEDARIO = 26;
    private final TNodoTrie[] hijos;

    public TNodoTrie[] getHijos() {
        return hijos;
    }
    
    private boolean esPalabra;

    private final LinkedList<Integer> iniciosPalabra;
  
    public boolean getEsPalabra(){
        return this.esPalabra;
    }

    public void setEsPalabra(boolean esPalabra) {
        this.esPalabra = esPalabra;
    }
    
    public void addInicioPalabra(int inicioDePalabra) {
        this.iniciosPalabra.add(inicioDePalabra);
    }
    
    public LinkedList<Integer> getIniciosPalabra(){
        return this.iniciosPalabra;
    }
    
    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        iniciosPalabra = new LinkedList<>();
        esPalabra = false;
    }
    
    public void insertar(String palabra, int inicioPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < palabra.length(); c++) {
            int indice = palabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.setEsPalabra(true);
        nodo.addInicioPalabra(inicioPalabra);
    }

    public void buscarSecuencia(String texto, LinkedList<String> resultado) {
        TNodoTrie nodo = buscarNodoTrie(texto);
        if(nodo!=null){
            LinkedList<Integer> inicios = new LinkedList<>();
            buscarSecuencia(inicios, nodo);
            inicios.forEach((inicio) -> {
                int fin = inicio + texto.length() - 1;
                resultado.add(inicio+"-"+fin);
            });
        }
    }    

    private void buscarSecuencia(LinkedList<Integer> inicios, TNodoTrie nodo) {
        if(nodo.esPalabra){
            inicios.addAll(nodo.getIniciosPalabra());
        }
        for(int i=0;i<CANT_CHR_ABECEDARIO;i++){
            if(nodo.hijos[i]!=null){
                buscarSecuencia(inicios, nodo.hijos[i]);
            }
        }
        
    }
    
    public TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }
}
