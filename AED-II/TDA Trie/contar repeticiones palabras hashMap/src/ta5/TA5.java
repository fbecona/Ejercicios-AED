package ta5;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TA5 {

    public static void main(String[] args) {
        
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/ta5/libro.txt");
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(String linea:lineas){
            String[] palabras = linea.split(" ");
            for(String palabra:palabras){
                String palabraAInsertar = FiltradorPalabras.filtrarPalabra(palabra).trim();
                if(!hashMap.containsKey(palabraAInsertar)){            
                    hashMap.put(palabraAInsertar, 0);
                }else{
                    Integer i = hashMap.get(palabraAInsertar);
                    i+=1;
                    hashMap.replace(linea, i);            
                }                
            }
        }
        //obtener los 10 con valores más altos
        //Falta parte C
        
    }
    
   
    
                

}
