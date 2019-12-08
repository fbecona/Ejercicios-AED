package SondeoLineal;

/**
 *
 * @author jechague
 */
public class Main {

    public static void main(String[] args) {
        String[] valoresInsertar = ManejadorArchivosGenerico.leerArchivo("src/SondeoLineal/claves_insertar.txt");
        Hash tablaHash = new Hash(valoresInsertar.length);
        for(String valor : valoresInsertar){
            tablaHash.insertar(Integer.parseInt(valor));
        }
        String[] valoresBuscar = ManejadorArchivosGenerico.leerArchivo("src/SondeoLineal/claves_buscar.txt");
        for(String valor : valoresBuscar){
            System.out.println(tablaHash.buscar(Integer.parseInt(valor)));
        }
        
    }
        
}
