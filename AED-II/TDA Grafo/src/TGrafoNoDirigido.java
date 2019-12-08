
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

//RECORDAR DESVISITAR VÉRTICES ANTES DE HACER UNA bpf o una bea

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {

    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));       //INSERTA LAS ARISTAS CON LAS DOS DIRECCIONES AL SER NO DIRIGIDO
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        int costoPrim = 0;
        LinkedList<TArista> aristasAAM = new LinkedList<>();
        LinkedList<Comparable> U = new LinkedList<>();
        LinkedList<Comparable> UComplemento = new LinkedList<>();
        boolean primeraClave = true;
        for(Comparable clave : super.getVertices().keySet()){
            UComplemento.add(clave);
            if(primeraClave){
                U.add(clave);
                UComplemento.remove(clave);
                primeraClave = false;
            }
        }
        if(UComplemento.isEmpty()){
            return null;
        }
        while(!UComplemento.isEmpty()){
            TArista min = this.lasAristas.buscarMin(U, UComplemento); //devuelve una arista con origen en U y destino en U complemento
            aristasAAM.add(min);
            costoPrim += min.costo;
            U.add(min.getEtiquetaDestino());                
            UComplemento.remove(min.getEtiquetaDestino());
        }
        LinkedList<TVertice> vertices = new LinkedList<>(); ///SI CREO EL NUEVO GRAFO CON LOS VERTICES HEREDADOS VAN A TENER
        for(Comparable u : U){                              ///LAS ADYACENCIAS QUE INCLUSO NO FORMEN PARTE DEL AAM
            vertices.add(new TVertice(u));                  ///PROBLEMA DE REFERENCIAS
        }
        System.out.println("Costo PRIM: " + costoPrim);
        return new TGrafoNoDirigido(vertices, aristasAAM);
    }
    
    public Collection<TVertice> bea() {
        return super.bea();
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        super.desvisitarVertices();
        LinkedList<TVertice> visitados = new LinkedList<>();
        TVertice origen = super.getVertices().get(etiquetaOrigen);
        origen.bea(visitados);
        return visitados;
    }
    
    public LinkedList<TVertice> puntosArticulacion(Comparable origen){
        super.desvisitarVertices();
        LinkedList<TVertice> puntosArt = new LinkedList<TVertice>();
        TVertice vertice = super.getVertices().get(origen);
        int[] numbp = new int[1];
        numbp[0]=1;
        vertice.puntosDeArticulacion(puntosArt, numbp, null);
        return puntosArt;
    }    

    public int numBacon(String nombreActor){
        TVertice actor = super.getVertices().get(nombreActor);
        TCaminos caminos = new TCaminos();
        actor.todosLosCaminos("Kevin_Bacon", new TCamino(actor), caminos);
        Collection<TCamino> listaCaminos = caminos.getCaminos();
        int distancia = Integer.MAX_VALUE;
        for(TCamino camino : listaCaminos){
            int distAux = camino.getOtrosVertices().size();
            if(distAux<distancia){
                distancia = distAux;
            }
        }
        actor.setBacon(distancia);
        return distancia;
    }
    
    public int numBacon2(Comparable actor) {         
        this.desvisitarVertices();
        TVertice bacon = this.getVertices().get("Kevin_Bacon");
        TVertice destino = this.getVertices().get(actor);
        if(bacon != null && destino != null){
              if(destino.getBacon()!=Integer.MAX_VALUE){
                  return destino.getBacon();
              }else{
                  return bacon.numBacon2(actor);
              }
        }
        return -1;
    }    
    
    @Override
    public TGrafoNoDirigido Kruskal() {
        LinkedList<TArista> aristas = new LinkedList<>();
        LinkedList<LinkedList<Comparable>> componentesConexos = new LinkedList<>();
        for(Comparable clave : super.getVertices().keySet()){
            LinkedList<Comparable> componente = new LinkedList<>();
            componente.add(clave);
            componentesConexos.add(componente);
        }
        while(componentesConexos.size()!=1){
            double min = Integer.MAX_VALUE;
            TArista arista;
            bucleComponentes:
            for(LinkedList<Comparable> componente1 : componentesConexos){
                for(LinkedList<Comparable> componente2 : componentesConexos){
                    if(componente1!=componente2){
                        TArista aux = this.lasAristas.buscarMin(componente1, componente2);
                        if(aux!=null){
                            if(aux.costo<min){
                                arista = aux;
                                min = aux.costo;
                                aristas.add(aux);
                                componente1.add(aux.getEtiquetaDestino());
                                componente2.remove(aux.getEtiquetaDestino());
                                if(componente2.isEmpty()){
                                    componentesConexos.remove(componente2);
                                    break bucleComponentes;
                                }
                            }
                        }
                    }
                }
            }
        }
        LinkedList<TVertice> vertices = new LinkedList<>();
        for(Comparable clave : super.getVertices().keySet()){
            vertices.add(new TVertice(clave));
        }
        return new TGrafoNoDirigido(vertices, aristas);
    }
    

    //componentes fuertes, camino crítico


    
}
