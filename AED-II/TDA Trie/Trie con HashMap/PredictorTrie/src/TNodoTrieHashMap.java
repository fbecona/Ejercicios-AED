import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class TNodoTrieHashMap implements INodoTrie {

    private final HashMap<Character,TNodoTrieHashMap> hijos;
    
    private boolean esPalabra;

    public TNodoTrieHashMap() {
        hijos = new HashMap<>();
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            Character letra = unaPalabra.charAt(c);
            if (!nodo.hijos.containsKey(letra)) {
                nodo.hijos.put(letra, new TNodoTrieHashMap());
            }
            nodo = nodo.hijos.get(letra);
        }
        nodo.esPalabra = true;
    }

   @Override
    public int buscar(String unaPalabra) {
        int contador = 0;
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            Character letra = unaPalabra.charAt(c);
            if (!nodo.hijos.containsKey(letra)) {
                return 0;
            }         
            nodo = nodo.hijos.get(letra);
            contador ++;
        }
        if(nodo.esPalabra){
            return contador;            
        }
        return 0;
    }
      
    
    @Override
    public void imprimir() {
        imprimir("", this);
    }    
    
    private void imprimir(String s, TNodoTrieHashMap nodo) {
        if (nodo.esPalabra) {
            System.out.println(s);
        }
        Set<Character> claves = nodo.hijos.keySet();
        for(Character clave : claves){
            imprimir(s + clave, nodo.hijos.get(clave));
        }
    }
    
    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrieHashMap nodo = this.buscarNodoTrie(prefijo);
        if(nodo!=null){
            this.predecir("", prefijo, palabras, nodo);
        }
    }
    
    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrieHashMap nodo) {
        if(nodo.esPalabra){
            palabras.add(prefijo+s);
        }
        Set<Character> claves = nodo.hijos.keySet();
        for(Character clave : claves){
            predecir(s + clave, prefijo, palabras, nodo.hijos.get(clave));
        }
    }

    private TNodoTrieHashMap buscarNodoTrie(String unaPalabra) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            Character letra = unaPalabra.charAt(c);
            if (!nodo.hijos.containsKey(letra)) {
                return null;
            }
            nodo = nodo.hijos.get(letra);
        }
        return nodo;
    }

 
}
