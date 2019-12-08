
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author fedeb
 */
public class Main {
    
    public static void main (String[] args){
        
        TGrafoDirigido grafoDirigido = UtilGrafos.cargarGrafo("src/aeropuertos.txt", "src/conexiones.txt", false, TGrafoDirigido.class);
        
        Double[][] floyd = grafoDirigido.floyd();
        UtilGrafos.imprimirMatrizMejorado(floyd, grafoDirigido.getVertices(), "FLOYD");
        System.out.println("Excentricidad Montevideo: " + grafoDirigido.obtenerExcentricidad("Montevideo"));
        System.out.println("Centro del grafo : " + grafoDirigido.centroDelGrafo());
        boolean[][] warshall = grafoDirigido.warshall();
        
        Collection<TVertice> bpfMontevideo = grafoDirigido.bpf("Punta_del_Este");
        for(TVertice vertice : bpfMontevideo){
            System.out.println(vertice.getEtiqueta());
        }
        
        grafoDirigido.desvisitarVertices();
        TCaminos todosLosCaminos = grafoDirigido.todosLosCaminos("Punta_del_Este", "Porto_Alegre");
        todosLosCaminos.imprimirCaminosConsola();
        System.out.println(grafoDirigido.tieneCiclo());
        
        TGrafoDirigido grafoDirigidoClasificacion = UtilGrafos.cargarGrafo("src/vertices.txt", "src/aristas.txt", false, TGrafoDirigido.class);  
        Collection<Comparable> clasificacionMontevideo = grafoDirigidoClasificacion.sortTopologico();
        for(Comparable vertice : clasificacionMontevideo){
            System.out.println(vertice);
        }        
        
        System.out.println(grafoDirigidoClasificacion.esConexo());
        
        TGrafoNoDirigido grafoNoDirigido = UtilGrafos.cargarGrafo("src/aeropuertos.txt", "src/conexiones.txt", false, TGrafoNoDirigido.class);
        TGrafoNoDirigido Prim = grafoNoDirigido.Prim();
        
        grafoNoDirigido.desvisitarVertices();
        grafoNoDirigido.bea("San_Pablo");
        
        TGrafoNoDirigido puntArt = UtilGrafos.cargarGrafo("src/vertices.txt", "src/aristas.txt", false, TGrafoNoDirigido.class);  
                
        
        LinkedList<TVertice> puntosArticulacion = puntArt.puntosArticulacion("Nairobi");
        for(TVertice puntoArt : puntosArticulacion){
            System.out.println(puntoArt.getEtiqueta());
        }
        
        TGrafoNoDirigido gnd = (TGrafoNoDirigido) UtilGrafos.cargarGrafo(
        "src/actores.csv",
        "src/en_pelicula.csv",
        false, TGrafoNoDirigido.class);

        // invocar a numBacon como indica la letra y mostrar en consola el resultado
        System.out.println(gnd.numBacon("John_Goodman"));
        System.out.println(gnd.numBacon("Tom_Cruise"));
        System.out.println(gnd.numBacon("Jason_Statham"));
        System.out.println(gnd.numBacon("Lukas_Haas"));
        System.out.println(gnd.numBacon("Djimon_Hounsou"));
        
        TGrafoNoDirigido grafoNoDirigidoA = UtilGrafos.cargarGrafo("src/aeropuertos.txt", "src/conexiones.txt", false, TGrafoNoDirigido.class);

        
        grafoNoDirigidoA.Kruskal();

        grafoDirigido.desvisitarVertices();
        TCaminos caminoCriticos = grafoDirigido.caminoCritico("San_Pablo", "Punta_del_Este");
        for(TCamino camino : caminoCriticos.getCaminos()){
            camino.imprimirEtiquetasConsola();
        } 
    }
    
}
