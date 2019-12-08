package tda.arbol.avl;

public class TElementoAB<T> implements IElementoAB<T> {

    private final Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private final T datos;
    
    private int altura;
    
    
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
        altura = 0;
    }
    
    @Override
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }
    
    public int getAltura(){
        return this.altura;
    }
    
    public void setAltura(int altura){
        this.altura = altura;
    }
        
    public int getBalance(){
        int hIzq = 0;
        int hDer = 0;
        if(this.getHijoIzq()!=null){
            hIzq = this.getHijoIzq().getAltura() + 1;
        }
        if(this.getHijoDer()!=null){
            hDer = this.getHijoDer().getAltura() + 1;
        }
        this.setAltura(Integer.max(hIzq, hDer));
        return hDer - hIzq;    
    }
    
    public TElementoAB<T> rotacionLL(TElementoAB<T> k2){
        TElementoAB<T> k1 = k2.getHijoIzq();
        k2.setHijoIzq(k1.getHijoDer());
        k1.setHijoDer(k2);
        k2.getBalance();
        k1.getBalance();
        return k1;
    }
    
    public TElementoAB<T> rotacionRR(TElementoAB<T> k1){
        TElementoAB<T> k2 = k1.getHijoDer();
        k1.setHijoDer(k2.getHijoIzq());
        k2.setHijoIzq(k1);
        k1.getBalance();
        k2.getBalance();
        return k2;
    }
    
    public TElementoAB<T> rotacionLR(TElementoAB<T> k3){
        k3.setHijoIzq(rotacionRR(k3.getHijoIzq()));
        return rotacionLL(k3);
    }
    
    public TElementoAB<T> rotacionRL(TElementoAB<T> k1){
        k1.setHijoDer(rotacionLL(k1.getHijoDer()));
        return rotacionRR(k1);
    }

    /**
     * Insertar Árbol AVL
     * 
     * @param unElemento
     * @return 
     */
    @Override
    public TElementoAB<T> insertar(TElementoAB<T> unElemento) {
        if(unElemento.getEtiqueta().compareTo(etiqueta)==0){
            return this;
        }
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                hijoIzq = getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
            }
        }
        if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                hijoDer = getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
            }
        }
        int balance = getBalance();
        if(hijoIzq!=null&& balance<-1)
        {
            int balanceIzq = hijoIzq.getBalance();
            if(balanceIzq<0){
                return rotacionLL(this);
            }else if(balanceIzq>0){
                return rotacionLR(this);
            }
        }
        if(hijoDer!=null&& balance>1)
        {
            int balanceDer = hijoDer.getBalance();
            if(balanceDer<0){
                return rotacionRL(this);
            }else if(balanceDer>0){
                return rotacionRR(this);
            }
        }        
        return this;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (etiqueta.equals(unaEtiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }        
    
    public TElementoAB<T> buscarConContains(Comparable unaEtiqueta) {
        String container = (String) etiqueta;
        String contained = ((String) unaEtiqueta).replace("\"","");
        if (container.contains(contained)) {  
            return this;
        }else{
            TElementoAB<T> left = null;
            TElementoAB<T> right = null;
            if (hijoIzq != null) {
                left = getHijoIzq().buscarConContains(unaEtiqueta);
            }
            if (hijoDer != null) {
                right = getHijoDer().buscarConContains(unaEtiqueta);
            }
            if(left == null && right == null){
                return null;
            }else{
                if(left!=null && right == null){
                    return left;
                }
                return right;
            }
        }
    }     
    public int obtenerAltura() {
        int alturaIzquierda = -1;
        int alturaDerecha = -1;
        if (this.hijoIzq != null) {
            alturaIzquierda = this.hijoIzq.obtenerAltura();
        }
        if (this.hijoDer != null) {
            alturaDerecha = this.hijoDer.obtenerAltura();
        }
        return Integer.max(alturaIzquierda+1, alturaDerecha+1);
    }        

    public boolean esAvl() {
        int hIzq = 0;
        int hDer = 0;
        if(hijoIzq!=null){
            hIzq = hijoIzq.obtenerAltura() + 1;
        }
        if(hijoDer!=null){
            hDer = hijoDer.obtenerAltura() + 1;
        }
        if(Math.abs(hIzq-hDer)>=2){
            return false;
        }else{
            boolean izqAvl = true;
            boolean derAvl = true;
            if(hijoIzq!=null){
                izqAvl = hijoIzq.esAvl();
            }
            if(hijoDer!=null){
                derAvl = hijoDer.esAvl();
            }
            return izqAvl && derAvl;
        }
    }       
    
    public TElementoAB<T> clonar(){
        return new TElementoAB(etiqueta,datos);
    }

    public String inOrden() {
        String tempStr = "";
        if (hijoIzq != null) {
            tempStr = hijoIzq.inOrden();
        }
        tempStr = tempStr + this.etiqueta + "~";
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.inOrden();
        }
        return tempStr;
    }
    
    public void inOrdenLista(Lista<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrdenLista(unaLista);
        }
        unaLista.insertarAlFinal(new Nodo<>(etiqueta,datos));
        if (hijoDer != null) {
            hijoDer.inOrdenLista(unaLista);
        }
    }
    
    public int obtenerTamanio() {
        int subIzquierdo = 0;
        int subDerecho = 0;
        if (hijoIzq != null) {
            subIzquierdo += hijoIzq.obtenerTamanio();
        }
        if (hijoDer != null) {
            subDerecho += hijoDer.obtenerTamanio();
        }
        return subIzquierdo + subDerecho + 1;
    }        
    
    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }    
    
    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }    
    
}
