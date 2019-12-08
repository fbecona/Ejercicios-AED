
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;


public class TVertice<T> implements IVertice {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    private int numBp;
    private int numBajo;
    private int bacon = Integer.MAX_VALUE;
    
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public T getDatos() {
        return datos;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }


    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }
    
    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

  
    @Override
    public void bpf(Collection<TVertice> visitados) {
        visitado = true;
        visitados.add(this);
        for(TAdyacencia adyacente : adyacentes){
            TVertice destino = adyacente.getDestino();
            if(!destino.visitado){
                destino.bpf(visitados);
            }
        }
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        visitado = true;
        for(TAdyacencia adyacente : adyacentes){
            TVertice destino = adyacente.getDestino();
            caminoPrevio.agregarAdyacencia(adyacente);
            if(destino.etiqueta.equals(etVertDest)){
                todosLosCaminos.getCaminos().add(caminoPrevio.copiar());
            }else{
                if(!destino.visitado){ 
                    destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                }
            }
            caminoPrevio.eliminarAdyacencia(adyacente);
        }
        visitado = false;
        return todosLosCaminos;
    }

    @Override
    public boolean tieneCiclo(LinkedList<Comparable> camino) {
        visitado = true;
        for(TAdyacencia adyacente : adyacentes){
            TVertice destino = adyacente.getDestino();
            Comparable etDestino = destino.etiqueta;
            if(camino.contains(etDestino)){
                return true;
            }else{
                if(!destino.visitado){ 
                    camino.add(etDestino);
                    if(destino.tieneCiclo(camino)){
                        return true;
                    }
                    camino.remove(etDestino);
                }
            }
        }
        visitado = false;
        return false;
    }

    public void sortTopologico(LinkedList<Comparable> clasificacion) {
        visitado = true;
        for(TAdyacencia adyacente : adyacentes){
            TVertice destino = adyacente.getDestino();
            if(!destino.visitado){
                destino.sortTopologico(clasificacion);
            }
        }
        clasificacion.add(etiqueta);  
    }
    
    @Override
    public void bea(Collection<TVertice> visitados) {
        Queue<TVertice> colaVisitados = (LinkedList <TVertice>) visitados;
        String tempStr = (String) etiqueta;
        visitado = true;
        visitados.add(this);
        while(!visitados.isEmpty()){
            TVertice origen = colaVisitados.poll(); //elimina el primero
            LinkedList<TAdyacencia> adyacentes = origen.adyacentes;
            for(TAdyacencia adyacente : adyacentes){
                TVertice destino = adyacente.getDestino();
                if(!destino.visitado){
                    destino.visitado = true;
                    visitados.add(destino);
                    colaVisitados.add(destino);
                    tempStr += "-"+destino.getEtiqueta();
                }
            }
        }
        System.out.println(tempStr);
    }
    
    public void puntosDeArticulacion(LinkedList<TVertice> vertices, int[] numBp, Comparable padre) {
        visitado = true;
        this.numBp = numBp[0];
        numBp[0]++;
        this.numBajo = this.numBp;
        int cantHijosRaiz = 0;
        for(TAdyacencia adyacente : adyacentes){
            TVertice vertice = adyacente.getDestino();
            if(!vertice.visitado){
                vertice.puntosDeArticulacion(vertices, numBp, etiqueta);
                if(vertice.numBajo<this.numBajo){
                    this.numBajo = vertice.numBajo;
                }
                if(!vertices.contains(this) && vertice.numBajo>this.numBp){
                    vertices.add(this);
                }
            }else{  //SI YA ESTÁ VISITADO ES UN ARCO DE RETROCESO
                if(vertice.etiqueta!=padre){    //en un grafo no dirigido siempre hay una arista de retroceso con los adyacentes
                    if(vertice.numBp<this.numBajo){
                        this.numBajo = vertice.numBp;
                    }
                }
            }
            cantHijosRaiz++;    //La raíz no puede tener arcos de retroceso
        }
        if(!vertices.contains(this) && padre==null && cantHijosRaiz>1){
            vertices.add(this);
        }
    }
    
    public int numBacon2(Comparable actor) {    //CON BUSQUEDA EN AMPLITUD
        LinkedList<TVertice> cola = new LinkedList<>();
        this.setVisitado(true);
        cola.add(this);
        this.setBacon(0);
        while(!cola.isEmpty()){
            TVertice x=cola.removeFirst();
            LinkedList<TAdyacencia> ady = x.getAdyacentes();
            
            for(TAdyacencia y: ady){
                if(!y.getDestino().visitado){
                    
                    y.getDestino().setBacon(x.getBacon()+1);
                    y.getDestino().setVisitado(true);
                    cola.addLast(y.getDestino());
                    if(y.getDestino().getEtiqueta().equals(actor)){
                        return y.getDestino().getBacon();
                    }
                }
            }
        }
        return -1;
    }

    public int getBacon() {
        return this.bacon;
    }

    public void setBacon(int newBacon) {
        this.bacon = newBacon;
    }
    
}
