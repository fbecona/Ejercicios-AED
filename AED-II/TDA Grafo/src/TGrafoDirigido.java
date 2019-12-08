import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices; //Map de vertices del grafo.
    

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     * @param nomVerticeOrigen
     * @param nomVerticeDestino
     * @return
     */
    @Override
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el v�rtice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
     *
     * @param nombreVertice
     * @return
     */
    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            getVertices().remove(nombreVertice);
            return getVertices().containsKey(nombreVertice);
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @return True si existe la adyacencia, false en caso contrario
     */
    @Override
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Matodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @param arista
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            tempbool = (vertOrigen != null) && (vertDestino != null);
            if (tempbool) {
                //getLasAristas().add(arista);
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }

        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse v�rtices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override
    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }


    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    @Override
    public void desvisitarVertices() {
        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
    }

    /**
     * @return the vertices
     */
    @Override
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Double[][] floyd() {
        Double[][] matrizCostos = UtilGrafos.obtenerMatrizCostos(this.vertices);
        for(int k = 0; k<this.vertices.size(); k++){
            for(int fila = 0; fila<this.vertices.size(); fila++){
                for(int columna = 0; columna<this.vertices.size(); columna++){
                    Double posibleValor = matrizCostos[fila][k] + matrizCostos[k][columna];
                    if(posibleValor<matrizCostos[fila][columna]){
                        matrizCostos[fila][columna] = posibleValor;
                   }
                }
            }
        }
        return matrizCostos;
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] matrizFloyd = this.floyd();  //la claves en la matriz están ordenadas alfabéticamente
        Double max = Double.MIN_VALUE;
        int columna = 0;
        for(Comparable clave : vertices.keySet()){
            if(clave.equals(etiquetaVertice)){
                for(int fila = 0; fila<vertices.keySet().size(); fila++){
                    if(matrizFloyd[fila][columna]>max){
                        max = matrizFloyd[fila][columna];
                    }
                }
            }
            columna++;
        }
        return max;
    }
    
    @Override
    public Comparable centroDelGrafo() {
        Comparable centro = null;
        Comparable min = Double.MAX_VALUE;
        for(Comparable clave : vertices.keySet()){
            Comparable excentricidadClave = obtenerExcentricidad(clave);
            if(excentricidadClave.compareTo(min)<0){
                min = excentricidadClave;
                centro = clave;
            }
        }        
        return centro;
    }    
    
    @Override
    public boolean[][] warshall() { //existe camino entre 2 vértices
        int n = this.vertices.keySet().size();  
        boolean[][] matrizWarshall = new boolean[n][n];
        int fila = 0;
        for(Comparable claveOrigen : this.vertices.keySet()){           //la claves en los sets están ordenadas alfabéticamente
            TVertice origen = vertices.get(claveOrigen);
            int columna = 0;
            for(Comparable claveDestino : this.vertices.keySet()){      //la claves en los sets están ordenadas alfabéticamente
                if(origen.buscarAdyacencia(claveDestino)!=null){        //hay adyacencia
                    matrizWarshall[fila][columna] = true;
                }
                if(fila==columna){
                    matrizWarshall[fila][columna] = true;               //siempre se puede ir de un vértice al mismo vértice
                }
                columna++;
            }
            fila++;
        }
        for(int k = 0; k<this.vertices.size(); k++){                    //se llena ir de un lugar a otro con escalas intermedias
            for(fila = 0; fila<this.vertices.size(); fila++){
                for(int columna = 0; columna<this.vertices.size(); columna++){
                    if(!matrizWarshall[fila][columna]){
                        matrizWarshall[fila][columna] = matrizWarshall[fila][k] && matrizWarshall[k][columna];
                    }
                }
            }
        }  
        return matrizWarshall;
    }
    
    @Override
    public Collection<TVertice> bpf() {                             //Búsqueda en profundidad
        this.desvisitarVertices();
        LinkedList<TVertice> visitados = new LinkedList<>();
        for(Comparable etiquetaOrigen : this.vertices.keySet()){
            TVertice vertice = this.vertices.get(etiquetaOrigen);
            if(!vertice.getVisitado()){
                vertice.bpf(visitados);
            }
        }
        return visitados;
    }

    @Override
    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {    //Búsqueda en profundidad
        this.desvisitarVertices();
        TVertice vertice = this.vertices.get(etiquetaOrigen);
        return bpf(vertice);
    }
    
    @Override
    public Collection<TVertice> bpf(TVertice vertice) {             //Búsqueda en profundidad
        this.desvisitarVertices();
        LinkedList<TVertice> visitados = new LinkedList<>();
        vertice.bpf(visitados);
        return visitados;
    }
    
    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino){
        desvisitarVertices();
        TCaminos caminos = new TCaminos();
        TVertice origen = this.vertices.get(etiquetaOrigen);
        TCamino camino = new TCamino(origen);
        return origen.todosLosCaminos(etiquetaDestino, camino, caminos);
    }

    @Override
    public boolean tieneCiclo() {
        for(Comparable etiquetaOrigen : this.vertices.keySet()){
            TVertice vertice = this.vertices.get(etiquetaOrigen);
            if(this.tieneCiclo(vertice.getEtiqueta())){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean tieneCiclo(Comparable etiquetaOrigen) {
        TVertice origen = this.vertices.get(etiquetaOrigen);
        TCamino camino = new TCamino(origen);
        return this.tieneCiclo(camino);
    }

    @Override
    public boolean tieneCiclo(TCamino camino) {
        TVertice origen = camino.getOrigen();
        LinkedList<Comparable> listaCamino = (LinkedList<Comparable>)camino.getOtrosVertices();
        return origen.tieneCiclo(listaCamino);    
    }

    public Collection<Comparable> sortTopologico() {
        this.desvisitarVertices();
        TGrafoDirigido grafoOpuesto = grafoOpuesto();
        LinkedList<Comparable> dependientes = new LinkedList<>();
        for(Comparable claveOrigen : grafoOpuesto.vertices.keySet()){
            TVertice vertice = grafoOpuesto.vertices.get(claveOrigen);       
            LinkedList<TAdyacencia> adyacentes = vertice.getAdyacentes();     
            for(TAdyacencia ady : adyacentes){
                Comparable etiquetaDestino = ady.getDestino().getEtiqueta();
                if(!dependientes.contains(etiquetaDestino)){
                    dependientes.add(etiquetaDestino);
                }
            }
        }
        LinkedList<Comparable> clasificacion = new LinkedList<>();
        for(Comparable claveOrigen : grafoOpuesto.vertices.keySet()){
            TVertice vertice = grafoOpuesto.vertices.get(claveOrigen); 
            grafoOpuesto.desvisitarVertices();
            if(!dependientes.contains(claveOrigen)){
                vertice.sortTopologico(clasificacion);
            }
        }
        return clasificacion;
    }
    
    public TGrafoDirigido grafoOpuesto(){
        LinkedList<TVertice> listaVertices = new LinkedList<>();
        LinkedList<TArista> aristasOpuestas = new LinkedList<>();
        for(Comparable claveOrigen : this.vertices.keySet()){
            listaVertices.add(new TVertice(claveOrigen));
            TVertice vertice = this.vertices.get(claveOrigen);
            LinkedList<TAdyacencia> adyacentes = vertice.getAdyacentes();
            for(TAdyacencia ady : adyacentes){
                Comparable claveDestino = ady.getDestino().getEtiqueta();
                TArista aristaOpuesta = new TArista(claveDestino, claveOrigen, ady.getCosto());
                aristasOpuestas.add(aristaOpuesta);
            }
        }
        return new TGrafoDirigido(listaVertices, aristasOpuestas);
    }    
    
    public boolean tieneTodasLasAristas(){
        for(Comparable claveOrigen : this.vertices.keySet()){
            LinkedList<Comparable> claves = new LinkedList<>();
            for(Comparable clave : this.vertices.keySet()){
                claves.add(clave);
            }
            TVertice vertice = this.vertices.get(claveOrigen);
            LinkedList<TAdyacencia> adyacentes = vertice.getAdyacentes();
            for(TAdyacencia ady : adyacentes){
                Comparable claveDestino = ady.getDestino().getEtiqueta();
                claves.remove(claveDestino);
            }
            if(claves.size()>1){
                return false;
            }
        }
        return true;
    }
    
    public boolean esConexo(){
        for(Comparable claveOrigen : this.vertices.keySet()){
            for(Comparable claveDestino : this.vertices.keySet()){
                Collection<TCamino> caminos = todosLosCaminos(claveOrigen, claveDestino).getCaminos();
                if(caminos.isEmpty()){
                    return false;
                }
            }    
        }
        return true;
    }
    
    @Override
    public Collection<TVertice> bea() {
        this.desvisitarVertices();
        LinkedList<TVertice> visitados = new LinkedList<>();
        for(Comparable claveOrigen : this.vertices.keySet()){
            TVertice origen = vertices.get(claveOrigen);
            if(!origen.getVisitado()){
                origen.bea(visitados);
            }
        }
        return visitados;
    }
 
    public TCaminos caminoCritico(Comparable etOrigen, Comparable etDestino){
        Collection<TCamino> caminos = this.todosLosCaminos(etOrigen, etDestino).getCaminos();
        Double costoMax = Double.MIN_VALUE;
        for(TCamino camino : caminos){
            if(camino.getCostoTotal()>costoMax){
                costoMax = camino.getCostoTotal();
            }
        }
        TCaminos caminosCriticos = new TCaminos();
        for(TCamino camino : caminos){
            if(camino.getCostoTotal().equals(costoMax)){
                caminosCriticos.getCaminos().add(camino);
            }
        }
        return caminosCriticos;
    }
}
