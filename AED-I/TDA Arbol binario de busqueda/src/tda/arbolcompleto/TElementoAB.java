package tda.arbolcompleto;


public class TElementoAB<T> implements IElementoAB<T> {

    private final Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private final T datos;

    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            return false;
        }
    }
    
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.equals(etiqueta)) {
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

   @Override
   public TElementoAB eliminar(Comparable unaEtiqueta){
        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = this.hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = this.hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }
        return quitaElNodo();
    }
    
    private TElementoAB quitaElNodo(){
        if (hijoIzq == null) {
            return hijoDer;
        }
        if (hijoDer == null) {
            return hijoIzq;
        }
        TElementoAB elHijo = hijoIzq;
        TElementoAB elPadre = this;
        while(elHijo.hijoDer != null){
            elPadre = elHijo;
            elHijo = elHijo.hijoDer;
        }
        if (elPadre != this) {
            elPadre.hijoDer = elHijo.hijoIzq;
            elHijo.hijoIzq = hijoIzq;
        }
        elHijo.hijoDer = hijoDer;
        return elHijo;
    }    
    
    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
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
        
    public TElementoAB<T> clonar(){
        return new TElementoAB(etiqueta,datos);
    }
    
    public String preOrden() {
        String tempStr = "";
        tempStr = tempStr + this.etiqueta + "~";
        if (hijoIzq != null) {
            tempStr = tempStr + hijoIzq.preOrden();
        }
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.preOrden();
        }
        return tempStr;
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
    
    public String postOrden() {
        String tempStr = "";
        if (hijoIzq != null) {
            tempStr = tempStr + hijoIzq.postOrden();
        }
        if (hijoDer != null) {
            tempStr = tempStr + hijoDer.postOrden();
        }
        tempStr = tempStr + this.etiqueta + "~";
        return tempStr;
    }        

    public void inOrdenLista(Lista<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrdenLista(unaLista);
        }
        unaLista.insertar(new Nodo<>(etiqueta,datos));
        if (hijoDer != null) {
            hijoDer.inOrdenLista(unaLista);
        }
    }
    
    public int obtenerAltura() { //INTERESANTE ALGORITMO EN POSTORDEN
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
    
    public int obtenerTamanio() { //cantidad de nodos
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
    

    public int obtenerNivel(Comparable unaEtiqueta) {
        if (this.etiqueta.compareTo(unaEtiqueta) == 0) {
            return 0;
        } else {
            if (etiqueta.compareTo(this.etiqueta) < 0) {
                if (hijoIzq != null) {
                    return 1 + hijoIzq.obtenerNivel(unaEtiqueta);
                } else{
                    return 0;
                }
            } else {
                if (hijoDer != null) {
                    return 1 + hijoDer.obtenerNivel(unaEtiqueta);
                }else{
                    return 0;
                }
            }
        }
    }
    

    public int obtenerCantidadDeHojas() {
        int contIzq = 0;
        int contDer = 0;
        if(hijoIzq==null&&hijoDer==null){
            return 1;
        }else{
            if(hijoIzq!=null){
                contIzq+= hijoIzq.obtenerCantidadDeHojas();
            }
            if(hijoDer!=null){
                contDer+=hijoDer.obtenerCantidadDeHojas();
            }
        }
        return contIzq+contDer;
    }
    
    
   
    public String obtenerNivelDeHojas(int nivel) {
        String resultado = "";
        if(hijoIzq==null&&hijoDer==null){
            resultado+=String.valueOf(nivel)+"~";
        }else{
            nivel++;
            if(hijoIzq!=null){
                resultado+= hijoIzq.obtenerNivelDeHojas(nivel);
            }
            if(hijoDer!=null){
                resultado+=hijoDer.obtenerNivelDeHojas(nivel);
            }
        }
        return resultado;
    }
    
    //la altura de las hojas siempre es 0
    
    public int obtenerCantidadNodosUnNivel(int actual, int nivel){
        int cantidad = 0;
        if(actual==nivel){
            cantidad++;
        }else{
            actual++;
            if(hijoIzq!=null){
                cantidad+=hijoIzq.obtenerCantidadNodosUnNivel(actual, nivel);
            }
            if(hijoDer!=null){
                cantidad+=hijoDer.obtenerCantidadNodosUnNivel(actual, nivel);
            }
        }
        return cantidad;
    }
    

    public int[] obtenerCantidadNodosUnaAltura(int altura) {
        int hIzq = -1;
        int hDer = -1;
        int cant = 0;
        if(hijoIzq != null){
            hIzq = hijoIzq.obtenerCantidadNodosUnaAltura(altura)[0];
            cant += hijoIzq.obtenerCantidadNodosUnaAltura(altura)[1];
        }
        if(hijoDer != null){
            hDer = hijoDer.obtenerCantidadNodosUnaAltura(altura)[0];
            cant += hijoDer.obtenerCantidadNodosUnaAltura(altura)[1];
        }
        int alturaNodo = Integer.max(hIzq + 1, hDer + 1);
        if(altura == alturaNodo){
            cant++;
        }
        int[] resultado = new int[2];
        resultado[0] = alturaNodo;
        resultado[1] = cant;
        return resultado; 
    }
    
 
  public String hojasConSuNivel(int actual) {
        String resultado = "";
        if(hijoIzq==null && hijoDer == null){
            resultado += etiqueta + "," + String.valueOf(actual)+"~"; 
        }else{
            actual++;
            if(hijoIzq!=null){
                resultado+= hijoIzq.hojasConSuNivel(actual);
            }
            if(hijoDer!=null){
                resultado+= hijoDer.hojasConSuNivel(actual);
            }
        }
        return resultado;
    }
  
  //la altura de las hojas siempre es 0
  
    public int obtenerCantidadNodosCompletos() {
        int contador = 0;
        if(hijoIzq!=null && hijoDer!=null){
            contador++;
        }else{
            if(hijoIzq!=null){
                contador+= hijoIzq.obtenerCantidadNodosCompletos();
            }
            if(hijoDer!=null){
                contador+= hijoDer.obtenerCantidadNodosCompletos();
            }
        }
        return contador;
    }
        
    public boolean esDeBusqueda() {
        boolean x = true;
        boolean y = true;
        if(hijoIzq!=null){
            if(etiqueta.compareTo(hijoIzq.getEtiqueta())<=0){
                x = false;
            }else{
                x = hijoIzq.esDeBusqueda();
            }
        }
        if(hijoDer!=null){
            if(etiqueta.compareTo(hijoDer.getEtiqueta())>=0){
                y = false;
            }else{
                y = hijoDer.esDeBusqueda();
            }
        }
        return x && y;
    }
    

    public int sumaClaves() {
        int x = 0;
        int y = 0;
        if(hijoIzq!=null){
            x = hijoIzq.sumaClaves();
        }
        if(hijoDer!=null){
            y = hijoDer.sumaClaves();
        }
        return x + y + (int)etiqueta;
    }    
    


    public Comparable menorClave() {
        if(hijoIzq!=null){
            return hijoIzq.menorClave();
        }else{
            return etiqueta;
        }
    }

    public Comparable mayorClave() {
        if(hijoDer!=null){
            return hijoDer.mayorClave();
        }else{
            return etiqueta;
        }
    }
    
    public Comparable claveAnterior(Comparable clave) {
        if(clave.compareTo(etiqueta)==0 && hijoIzq!=null){
            TElementoAB<T> padre = this;
            TElementoAB<T> hijo = hijoIzq;
            while(hijo!=null){
                padre = hijo;
                hijo = hijo.getHijoDer();
            }
            return padre.getEtiqueta();
        }else{
            String x = "";
            String y = "";
            if(clave.compareTo(etiqueta)<0 && hijoIzq!=null){
                x = String.valueOf(hijoIzq.claveAnterior(clave));
            }
            if(clave.compareTo(etiqueta)>0 && hijoDer!=null){
                y = String.valueOf(hijoDer.claveAnterior(clave));
            }
            return x + y;
        }
    }
    

    public TElementoAB valorConMenorEtiqueta(T valor){
        TElementoAB x = null;
        if(hijoIzq!=null){
            x = hijoIzq.valorConMenorEtiqueta(valor);
        }
        if(datos.equals(valor)&&x==null){
            x = this;
        }
        if(hijoDer!=null&&x==null){
            x = hijoDer.valorConMenorEtiqueta(valor);
        }
        return x;
    }    
    
    public Integer mayorDatoEntre(Comparable claveMenor, Comparable claveMayor) {
        int valorMenor = 0;
        int valorMayor = 0;
        int esteValor = 0;
        if(claveMenor.compareTo(etiqueta)<0&&claveMayor.compareTo(etiqueta)>0){
            esteValor = (Integer) datos;
        }
        if(claveMenor.compareTo(etiqueta)<0 && hijoIzq!=null){
            valorMenor = hijoIzq.mayorDatoEntre(claveMenor, claveMayor);
        }else{
            if(claveMenor.compareTo(etiqueta)==0){
                valorMenor = (Integer)datos;
            }
        }
        if(claveMayor.compareTo(etiqueta)>0 && hijoDer!=null){
            valorMayor = hijoDer.mayorDatoEntre(claveMenor, claveMayor);
        }else{
            if(claveMayor.compareTo(etiqueta)==0){
                valorMayor = (Integer)datos;
            }
        }
        return Integer.max(esteValor, Integer.max(valorMayor, valorMenor));
    } 
    
    public int insertarContando(TElementoAB<T> unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                 return getHijoIzq().insertarContando(unElemento) + 1;
            } else {
                hijoIzq = unElemento;
                return 0;
            }
        } else {
            if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
                if (hijoDer != null) {
                   return  getHijoDer().insertarContando(unElemento) + 1;

                } else {
                    hijoDer = unElemento;
                     return 0;
                }
            } else {
                 return 0;
            }
        }
    }
    
    public int[] insertarContandoArray(int[] contador, TElementoAB<T> unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                contador[0]++;
                return getHijoIzq().insertarContandoArray(contador, unElemento);
            } else {
                hijoIzq = unElemento;
                return contador;
            }
        } else {
            if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
                if (hijoDer != null) {
                   return  getHijoDer().insertarContandoArray(contador, unElemento);
                } else {
                    hijoDer = unElemento;
                    return contador;
                }
            } else {
                 return contador;
            }
        }
    }   
}