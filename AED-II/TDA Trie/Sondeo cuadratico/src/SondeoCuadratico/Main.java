package SondeoCuadratico;

/**
 *
 * @author jechague
 */
public class Main {

    public static void main(String[] args) {     
        
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/SondeoCuadratico/claves_insertar.txt");
        Hash hash = new Hash(lineas.length); 
        for (String linea : lineas) {
            hash.insertar(Integer.parseInt(linea));
        }
        
        String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("src/SondeoCuadratico/claves_buscar.txt");
        for (String linea2 : lineas2) {
            /*System.out.println(*/hash.buscar(Integer.parseInt(linea2));
        }
    }
        
}
