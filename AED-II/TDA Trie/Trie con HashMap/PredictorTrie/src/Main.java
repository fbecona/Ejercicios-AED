
import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        
        TArbolTrieHashMap trie = new TArbolTrieHashMap();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("./src/palabrasEx.txt");
        for (String p : palabrasclave) {
            trie.insertar(p);
        }
        
        LinkedList<String> prediccion = trie.predecir("programa");
        for(String n : prediccion){
            System.out.println(n);
        }
        
    }
}