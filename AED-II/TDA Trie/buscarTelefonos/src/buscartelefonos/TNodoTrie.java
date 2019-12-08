package buscartelefonos;

import java.util.LinkedList;

public class TNodoTrie implements INodoTrie{
    
    private static final int CANT_CHR_ABECEDARIO = 11;
    private final TNodoTrie[] hijos;
    private boolean esPalabra;
    private TAbonado abonado;
    
    public TAbonado getAbonado(){
        return this.abonado;
    }

    public void setEsPalabra(boolean esPalabra) {
        this.esPalabra = esPalabra;
    }

    public void setAbonado(TAbonado abonado) {
        this.abonado = abonado;
    }
    
    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }
    
    @Override
    public void insertar(TAbonado abonado) {
        String telefono = abonado.getTelefono();
        TNodoTrie nodo = this;
        for (int c = 0; c < telefono.length(); c++) {
            int indice = telefono.charAt(c) - '0';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.setEsPalabra(true);
        nodo.setAbonado(abonado);
    }

    public TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - '0';
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }
    
    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrie nodo = this.buscarNodoTrie(primerosDigitos);
        if(nodo!=null){
            buscarTelefonos(abonados, nodo);
        }
    }    
    
    private void buscarTelefonos(LinkedList<TAbonado> abonados, TNodoTrie nodo){
        if(nodo.esPalabra){
            abonados.add(nodo.getAbonado());
        }
        for (int c=0; c<CANT_CHR_ABECEDARIO;c++){
            if(nodo.hijos[c]!=null){
                buscarTelefonos(abonados, nodo.hijos[c]);
            }
        }
    }
}
