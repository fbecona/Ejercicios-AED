package tda.arbol.avl;

public class Lista<T> implements ILista<T> {
    
    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertarAlPrincipio(Nodo<T> unNodo){
        unNodo = unNodo.clonar();
        if (esVacia()) {
            primero = unNodo;
        }else{
            unNodo.setSiguiente(null);
            primero = unNodo;
        }
    }
    
    @Override
    public void insertarAlFinal(Nodo<T> unNodo) {
        unNodo = unNodo.clonar();
        unNodo.setSiguiente(null);
        if (esVacia()) {
            primero = unNodo;
        } else {
            Nodo<T> aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(unNodo);
        }
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            Nodo<T> aux = primero;
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }
    
    @Override
    public boolean insertarOrdenadamente(Nodo<T> unNodo){
        unNodo = unNodo.clonar();
        //PARA INSERTAR SI ESTÁ VACÍA
        if (this.esVacia()){
            this.primero = unNodo;
            return true;
        }
        //PARA VERIFICAR QUE YA NO ESTÁ EL ELEMENTO
        if(this.buscar(unNodo.getEtiqueta())!=null){
            return false;
        }
        //PARA INSERTAR AL PRINCIPIO
        if(this.primero.getEtiqueta().compareTo(unNodo.getEtiqueta())>0){
            unNodo.setSiguiente(this.primero);
            this.primero = unNodo;
            return true;
        }
        //PARA INSERTAR AL FINAL SI HAY SOLO UN ELEMENTO
        if(this.cantElementos()==1 && this.primero.getEtiqueta().compareTo(unNodo.getEtiqueta())<0){
            this.primero.setSiguiente(unNodo);
        }
        Nodo<T> actual = this.primero;
        while(actual.getSiguiente()!=null){
            //PARA INSERTAR EN EL MEDIO
            if(actual.getSiguiente().getEtiqueta().compareTo(unNodo.getEtiqueta())>0){
                unNodo.setSiguiente(actual.getSiguiente());
                actual.setSiguiente(unNodo);
                return true;
            }
            //PARA INSERTAR AL FINAL
           if(actual.getSiguiente().getSiguiente()==null &&                         
                   actual.getSiguiente().getEtiqueta().compareTo(unNodo.getEtiqueta())<0){
               actual.getSiguiente().setSiguiente(unNodo);
               return true;
           }           
            actual = actual.getSiguiente();
        }
        return false;
    }

    @Override
    public Lista<T> insercionDirecta(Lista<T> listaDesordenada) {
        Lista<T> listaOrdenada = new Lista();
        while(listaDesordenada.getPrimero()!=null){
            Nodo<T> aux = listaDesordenada.getPrimero();
            listaDesordenada.setPrimero(listaDesordenada.getPrimero().getSiguiente());
            aux.setSiguiente(null);
            listaOrdenada.insertarOrdenadamente(aux);
        }
        return listaOrdenada;
    }
    
    
    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        Nodo<T> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            Nodo<T> temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                Nodo<T> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            Nodo<T> temp = primero;
            while (temp != null) {
                temp.imprimirEtiqueta();
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    @Override
    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } else {
            Nodo<T> temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;

    }

    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            INodo aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = unNodo;
    }


}
