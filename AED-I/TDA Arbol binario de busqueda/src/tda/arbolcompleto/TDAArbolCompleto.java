package tda.arbolcompleto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TDAArbolCompleto {

    public static void main(String[] args) throws IOException {
        
        String[] h = new String[1];
        
        TArbolBB<Integer> prueba = new TArbolBB<>();
        prueba.insertar(new TElementoAB<>(7,20));
        prueba.insertar(new TElementoAB<>(2,5));
        prueba.insertar(new TElementoAB<>(1,4));
        prueba.insertar(new TElementoAB<>(4,3));
        prueba.insertar(new TElementoAB<>(3,1));
        prueba.insertar(new TElementoAB<>(15,0));
        prueba.insertar(new TElementoAB<>(10,3));
        prueba.insertar(new TElementoAB<>(8,24));
        prueba.insertar(new TElementoAB<>(12,9));
        prueba.insertar(new TElementoAB<>(19,0));
        
        System.out.println(prueba.claveAnterior(7));
        
     
        TArbolBB /* < tipo del dato de los elementos > */ arbol = new TArbolBB/* <> */();
        BufferedReader bfData1;
        try (FileReader frData1 = new FileReader("src/"/*nombre del archivo después de src*/)) {
            bfData1 = new BufferedReader(frData1);
            String newLine1 = bfData1.readLine();
            while(newLine1!=null){
                String[] newLineData1 = newLine1.split(",");
                //crear el dato
                //ej Alumno alumnoIng = new Alumno(Integer.parseInt(newLineData1[0]),newLineData1[1],newLineData1[2]);
//VER A QUE ARBOL INSERTAR    arbol.insertar(new TElementoAB(/*clave del elemento,dato*/));
                newLine1 = bfData1.readLine();
            }
            bfData1.close();
        }
        
        BufferedWriter bfWriter1;
        try (FileWriter frWriter1 = new FileWriter("src/"/*nombre del archivo después de src*/,true)) {
            bfWriter1 = new BufferedWriter(frWriter1);
            String[] clavesOrdenadas = arbol.inOrden().split("~"/*ver si no el separador es este*/);
            for(String unaClave : clavesOrdenadas){
                bfWriter1.write(unaClave + "\n");
            }
            bfWriter1.close();
        }
        //RECORDAR PONERLE CLOSE AL FileWriter SI NO SE LE SACA EL try        
    }
    
}
