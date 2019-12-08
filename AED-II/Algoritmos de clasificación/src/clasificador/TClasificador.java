
package clasificador;

public class TClasificador implements IClasificador {

    public static void main(String args[]) {
        TClasificador clasif = new TClasificador();
        IGeneradorDatos gdg = new GeneradorDatosGenericos();
        
        int[] vectorAleatorio = gdg.generarDatosAleatorios();       
        int[] vectorAscendente = gdg.generarDatosAscendentes();
        int[] vectorDescendente = gdg.generarDatosDescendentes();

       /* int[] resAleatorio = clasif.clasificar(vectorAleatorio,
                        METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resAleatorio.length; i++) {
                System.out.println(resAleatorio[i] + " ");
        }
        int[] resAscendente = clasif.clasificar(vectorAscendente,
                        METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resAscendente.length; i++) {
                System.out.println(resAscendente[i] + " ");
        }
        int[] resDescendente = clasif.clasificar(vectorDescendente,
                        METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resDescendente.length; i++) {
                System.out.println(resDescendente[i] + " ");
        }
       */ 
        
        System.out.println(clasif.tiempoMedioAlgoritmo(METODO_CLASIFICACION_SHELL));
        
        
        
        
        
        
    }

    /**
     * Punto de entrada al clasificador
     * 
     * @param metodoClasificacion
     * @param orden
     * @param tamanioVector
     * @return Un vector del tam. solicitado, ordenado por el algoritmo
     *         solicitado
     */
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion, boolean cascara) {
        switch (metodoClasificacion) {
        case METODO_CLASIFICACION_INSERCION:
            if(cascara){
                return ordenarPorInsercionCascara(datosParaClasificar);
            }
            return ordenarPorInsercion(datosParaClasificar);
        case METODO_CLASIFICACION_SHELL:
            if(cascara){
                return ordenarPorShellCascara(datosParaClasificar);
            }
            return ordenarPorShell(datosParaClasificar);
        case METODO_CLASIFICACION_BURBUJA:
            if(cascara){
                return ordenarPorBurbujaCascara(datosParaClasificar);
            }
            return ordenarPorBurbuja(datosParaClasificar);            
        case METODO_CLASIFICACION_QUICKSORT:
            if(cascara){
                return ordenarPorQuickSortCascara(datosParaClasificar);
            }
            return ordenarPorQuickSort(datosParaClasificar);
        default:
                System.err.println("Este codigo no deberia haberse ejecutado");
                break;
        }
        return datosParaClasificar;
    }
    
    /**
     * @param datosParaClasificar
     * @return
     */
    public int[] ordenarPorShell(int[] datosParaClasificar) {
        int j, inc;
        int[] incrementos = new int[] { 3223, 358, 51, 10, 3, 1 };

        for (int posIncrementoActual = 1; posIncrementoActual < incrementos.length; posIncrementoActual++) {
            inc = incrementos[posIncrementoActual];
            if (inc < (datosParaClasificar.length / 2)) {
                for (int i = inc; i < datosParaClasificar.length; i++) {
                    j = i - inc;
                while (j >= 0) {
                        if (datosParaClasificar[j] > datosParaClasificar[j
                                        + inc]) {
                                intercambiar(datosParaClasificar, j, j + inc);
                                j = j--;
                        }
                    }
                }
            }
        }
        return datosParaClasificar;
    }
    
    public int[] ordenarPorShellCascara(int[] datosParaClasificar){
        if (datosParaClasificar != null) { 
            return datosParaClasificar;
        }
        return null;        
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    public int[] ordenarPorInsercion(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
                for (int i = 2; i < datosParaClasificar.length; i++) {
                        int j = i - 1;
                        while ((j >= 0)
                                        && (datosParaClasificar[j + 1] > datosParaClasificar[j])) {
                                intercambiar(datosParaClasificar, j, j + 1);
                                j--;
                        }
                }
                return datosParaClasificar;
        }
        return null;
    }
    
    public int[] ordenarPorInsercionCascara(int[] datosParaClasificar){
        if (datosParaClasificar != null) { 
            return datosParaClasificar;
        }
        return null;        
    }

    private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        datosParaClasificar = null;
        int n = datosParaClasificar.length - 1;
        for (int i = 0; i <= n; i++) {
                for (int j = n; j >= (i + 1); j--) {
                        if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                                intercambiar(datosParaClasificar, j - 1, j);
                        }
                }
        }
        return datosParaClasificar;
    }
    
    public int[] ordenarPorBurbujaCascara(int[] datosParaClasificar){
        if (datosParaClasificar != null) { 
            return datosParaClasificar;
        }
        return null;        
    }
    
   @Override
    public int[] ordenarPorQuickSort(int[] datosParaClasificar) {
        quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1);
        return datosParaClasificar;
    } 
    
    public int[] ordenarPorQuickSortCascara(int[] datosParaClasificar){
        if (datosParaClasificar != null) { 
            return datosParaClasificar;
        }
        return null;        
    }
    
    private void quicksort(int[] entrada, int i, int j) {
        int izquierda = i;
        int derecha = j;
        int posicionPivote = encuentraPivote(izquierda,derecha,entrada); 
        if (posicionPivote >= 0){
            int pivote = entrada[posicionPivote];  
            while (izquierda <= derecha) {
                while ((entrada[izquierda] < pivote) && (izquierda < j)) {
                    izquierda++; 
                }
                while ((pivote < entrada[derecha]) && (derecha > i)) {
                    derecha--; 
                }
                if (izquierda <= derecha) {
                    intercambiar(entrada, izquierda, derecha); 
                    izquierda++;
                    derecha--;
                }
            }
            if (i < derecha){
                quicksort(entrada, i, derecha);
            }
            if (izquierda < j){
                quicksort(entrada, izquierda, j);
            }
        }
    }    

    private int encuentraPivote(int izquierda, int derecha, int[] entrada) {
        return entrada[izquierda];
    }    
    
    @Override
    public int[] ordenarPorSeleccion(int[] datosParaClasificar) {
        // Implementar m�todo aqu�
        return null;
    }

    @Override
    public int[] ordenarPorHeapSort(int[] datosParaClasificar) {
        // Implementar m�todo aqu�
        return null;
    }



    @Override
    public int[] ordenarPorCuenta(int[] datosParaClasificar) {
        // Implementar m�todo aqu�
        return null;
    }

    private void intercambiar(int[] vector, int pos1, int pos2) {
        int temp = vector[pos2];
        vector[pos2] = vector[pos1];
        vector[pos1] = temp;
    }
    
    public float tiempoMedioAlgoritmo(int metodoClasificacion){      //CAMBIAR LA CANTIDAD DE ELEMENTOS Y EL ORDEN
        float t1 = System.nanoTime();
        float t2;
        float total = 0;
        int cantLLamadas = 0;
        int tiemporesolucion = 10;
        IGeneradorDatos gdg = new GeneradorDatosGenericos();
        
        int[] vectorOriginal = gdg.generarDatosAleatorios();//cambiar por aleatorio o los otros
        int[] datosCopia;
        
        while(total<tiemporesolucion){
            cantLLamadas++;
            datosCopia = vectorOriginal;
            clasificar(datosCopia, metodoClasificacion, true);
            t2 = System.nanoTime();
            total += t2-t1;
        }
        float tiempoAlgoritmoBase = total/cantLLamadas;
        
        t1 = System.nanoTime(); 
        total = 0;
        cantLLamadas = 0;
        
        while(total<tiemporesolucion){
            cantLLamadas++;
            datosCopia = vectorOriginal;
            clasificar(datosCopia, metodoClasificacion, true);
            t2 = System.nanoTime();
            total += t2-t1;
        }
        float tiempoMedioCascara = total/cantLLamadas;
        
        float tiempoMedioAlgoritmo = tiempoAlgoritmoBase - tiempoMedioCascara;
        return tiempoMedioAlgoritmo/1000000;
    }
    
    
    
    @Override
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 

    
    
}
