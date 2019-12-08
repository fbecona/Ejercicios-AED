package dispositivosip;

import java.util.Collection;

public class TNodoTrie implements INodoTrie{
    
    private static final int CANT_CHR_ABECEDARIO = 255;
    private final TNodoTrie[] hijos;
    private boolean esPalabra;
    private Dispositivo dispositivo;
    
    public Dispositivo getDispositivo(){
        return this.dispositivo;
    }

    public void setEsPalabra(boolean esPalabra) {
        this.esPalabra = esPalabra;
    }

    public void setDispositivo(Dispositivo abonado) {
        this.dispositivo = abonado;
    }
    
    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }
    
    @Override
    public void insertar(Dispositivo dispositivo) {
        String ip = dispositivo.getIp();
        TNodoTrie nodo = this;
        for (int c = 0; c < ip.length(); c++) {
            int indice = ip.charAt(c);
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.setEsPalabra(true);
        nodo.setDispositivo(dispositivo);
    }

    public TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c);
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }
    
    @Override
    public void buscarDispositivos(String primerosDigitos, Collection<Dispositivo> dispositivos) {
        TNodoTrie nodo = this.buscarNodoTrie(primerosDigitos);
        if(nodo!=null){
            buscarDispostivos(dispositivos, nodo);
        }
    }    
    
    private void buscarDispostivos(Collection<Dispositivo> dispositivo, TNodoTrie nodo){
        if(nodo.esPalabra){
            dispositivo.add(nodo.getDispositivo());
        }
        for (int c=0; c<CANT_CHR_ABECEDARIO;c++){
            if(nodo.hijos[c]!=null){
                buscarDispostivos(dispositivo, nodo.hijos[c]);
            }
        }
    }
}
