package buscartelefonos;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        
        TArbolTrie trie = new TArbolTrie();
        String[] abonados = ManejadorArchivosGenerico.leerArchivo("src/buscarTelefonos/abonados.txt");
        for(String abonado : abonados){
            String[] datos = abonado.split(",");
            trie.insertar(new TAbonado(datos[1], datos[0]));
        }
        Collection<TAbonado> coleccion = trie.buscarTelefonos("598", "93");
        Iterator iterador = coleccion.iterator();
        TreeMap<String,String> treeMap = new TreeMap<>();
        while(iterador.hasNext()){
            TAbonado abonado = (TAbonado) iterador.next();
            treeMap.put(abonado.getNombre(), abonado.getTelefono());
        }
        int cantidad = coleccion.size();
        String[] aGuardar = new String[cantidad];
        int i = 0;
        for(Map.Entry<String, String> pair : treeMap.entrySet()){
            aGuardar[i] = (String) (pair.getKey() + "-" + pair.getValue());
            i++;
        }
        ManejadorArchivosGenerico.escribirArchivo("src/buscarTelefonos/RESULTADO", aGuardar);
    }
    
}
