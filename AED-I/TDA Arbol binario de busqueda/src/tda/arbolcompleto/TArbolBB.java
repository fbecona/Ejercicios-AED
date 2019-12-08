package tda.arbolcompleto;


public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;
    
    public TArbolBB() {
        raiz = null;
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (raiz==null) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }
    
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (raiz==null) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }
    
    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (raiz!=null) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
        else{
            System.out.println("arbol vacio");
        }
    }

    public boolean vaciar() {
        if (raiz!=null) {
            raiz = null;
            return true;
        }
        return false;
    }    
        
    public String preOrden() {
        if (raiz == null) {
            return "arbol vacio";
        } else {
            return raiz.preOrden();
        }
    }

    public String inOrden() {
        if (raiz == null) {
            return "arbol vacio";
        } else {
            return raiz.inOrden();
        }
    }

    public String postOrden() {
        if (raiz == null) {
            return "arbol vacio";
        } else {
            return raiz.postOrden();
        }
    }
    

    public Lista<T> inorden() {
        Lista <T> listaInorden = null;
        if (raiz!=null) {
            listaInorden = new Lista<>();
            raiz.inOrdenLista(listaInorden);
        }
        return listaInorden;
    }        

    public int obtenerAltura() {
        if (raiz != null){
            return raiz.obtenerAltura();
        }
        else{
            return -1;
        }
    }   

    public int obtenerTamanio() {
        if (raiz!=null) {
            return raiz.obtenerTamanio();
        } else {
            return 0;
        }
    }       
    
    //nivel de la raiz es 0
    
    public int obtenerNivel(Comparable unaEtiqueta) {
        if (raiz!=null) {
            if(raiz.buscar(unaEtiqueta)!=null){
                return raiz.obtenerNivel(unaEtiqueta);  
            }else{
                return -1;
            }
        } else {
            return 0;
        }
    }    
    
    public int obtenerCantidadHojas() {
        if (raiz!=null) {
            return raiz.obtenerCantidadDeHojas();
        } else {
            return 0;
        }
    }

    public String obtenerNivelDeHojas(){
        if(raiz==null){
            return "";
        }else{
            return raiz.obtenerNivelDeHojas(0);
        }
    }


    public int obtenerCantidadDeNodosUnNivel(int nivel){
        if(raiz==null){
            return 0;
        }else{
            int actual = 0;
            return raiz.obtenerCantidadNodosUnNivel(actual, nivel);
        }
    }        
    
    public String obtenerHojasConSuNivel(){
        if(raiz==null){
            return "";
        }else{
            return raiz.hojasConSuNivel(0);
        }
    }
    
    public int obtenerCantidadDeNodosUnaAltura(int altura){
        if(raiz==null){
            return 0;
        }else{
            return raiz.obtenerCantidadNodosUnaAltura(altura)[1];
        }
    }

    public int obtenerCantidadNodosCompletos(){
        if(raiz==null){
            return 0;
        }else{
            return raiz.obtenerCantidadNodosCompletos();
        }
    }
      
    
    public boolean esDeBusqueda(){
        if(raiz==null){
            return true;
        }else{
            return raiz.esDeBusqueda();
        }
    }    
    
    public int sumaClaves(){
        if(raiz==null){
            return 0;
        }else{
            return raiz.sumaClaves();
        }
    }    
    
    public Comparable menorClave(){
        if(raiz==null){
            return null;
        }else{
            return raiz.menorClave();
        }
    }    
    
    public Comparable mayorClave(){
        if(raiz==null){
            return null;
        }else{
            return raiz.mayorClave();
        }
    }
    
    public Comparable claveAnterior(Comparable clave){
        if(raiz==null){
            return null;
        }else{
            return raiz.claveAnterior(clave);
        }
    }

    public TElementoAB elementoConMenorEtiquetaYEsteValor(T valor){
        if(raiz==null){
            return null;
        }else{
            return raiz.valorConMenorEtiqueta(valor);
        }
        
    }
    
    public Integer mayorDatoEntre(Comparable claveMenor,Comparable claveMayor){
        if(raiz==null){
            return null;
        }else{
            return raiz.mayorDatoEntre(claveMenor,claveMayor);
        }
    }

    public int insertarContando(TElementoAB<T> unElemento){
        if (raiz==null){
           raiz = unElemento;
           return 0;
        }else{
            return raiz.insertarContando(unElemento);
        }
    }    
            
    public int insertarContandoArray(TElementoAB<T> unElemento){
        if (raiz==null){
           raiz = unElemento;
           return 0;
        }else{
            int[] contador = new int[1];
            contador[0] = 0;
            return raiz.insertarContandoArray(contador, unElemento)[0];
        }
    }        
    
    

}
