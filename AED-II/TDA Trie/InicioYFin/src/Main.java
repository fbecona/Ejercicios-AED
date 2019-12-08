
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        TreeMap<String,String> h = new TreeMap<>();
        for(String key: h.keySet()){
            
        }
        
        TTrieSufijosHashMap trie = new TTrieSufijosHashMap();
        String a = "hola";

        String eltexto = "panamabananaslozanasenlasmananascuandolasranasnocomenlasanas";
        for(int i = 0; i<eltexto.length();i++){
            trie.insertar(eltexto.substring(i), i);
        }
        
        ArrayList<Integer> posicionesPatron = trie.posicionesPatron("ana");
        Integer[] posiciones = new Integer[posicionesPatron.size()];
        posicionesPatron.toArray(posiciones);
        for(int i = 0; i<posiciones.length;i++){
            System.out.println(posiciones[i]);
        }
        
        // TODO: insertar todos los sufijos en el trie, "anotando" la posición del texto (base 0) en que comienza cada sufijo
        //TODO: hallar las posiciones del texto en que comienza cada ocurrencia del patrón "ana" 
        //algun arrayList = trie.posicionesPatron("ana");
        // TODO: IMPRIMIR EN CONSOLA LAS POSICIONES DEL TEXTO EN QUE SE ENCUENTRA EL PATRÓN "ana"
    }
}
