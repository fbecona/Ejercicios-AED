package dispositivosip;

import java.util.Collection;

/**
 *
 * @author fedeb
 */
public class DispositivosIP {

    public static void main(String[] args) {
        String[] h = new String[3];
        TArbolTrie trie = new TArbolTrie();
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/dispositivosip/dispositivos.txt");
        for(String linea:lineas){
            String[] ipDispositivo = linea.split(",");
            Dispositivo dispostivo = new Dispositivo(ipDispositivo[0],ipDispositivo[1]);
            trie.insertar(dispostivo);
        }
        
        Collection<Dispositivo> dispositivos = trie.buscarDispositivos("100.024.008.");
        for(Dispositivo dispositivo : dispositivos){
            System.out.println(dispositivo.ip +","+ dispositivo.dispositivo);
        }
        
        
    }
    
}
