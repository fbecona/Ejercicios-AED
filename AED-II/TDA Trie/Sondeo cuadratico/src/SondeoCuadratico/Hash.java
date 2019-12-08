package SondeoCuadratico;

/**
 *
 * @author estudiante.fit
 */
public class Hash implements IHash {
    
    private final int[] hashTable;
    
    public Hash(int m) {
        int extra = m;
        hashTable = new int[nextPrime(m+extra)];
    }

    public int nextPrime(int input) {
        input++;
        for(int i=2;i<input;i++) {
            if(input % i ==0  ) {
                input++;
                i=2;
            }
            else{
                continue;
            }
        }
        return input;
    }

    @Override
    public int funcionHashing(int unaClave) {
          return unaClave % hashTable.length;
    }
    
    @Override
    public int buscar(int unaClave) {
        int comparaciones = 0;
        while(comparaciones<hashTable.length){
            int hash = funcionHashing(unaClave+comparaciones^2);
            if(hashTable[hash]==unaClave){
                return comparaciones;
            }
            if(hashTable[hash]==0){
                return -comparaciones;
            }
            comparaciones++;
        }
        return -comparaciones;
    }

    @Override
    public int insertar(int unaClave) {
        int comparaciones = 0;
        while(comparaciones<hashTable.length){
            int hash = funcionHashing(unaClave+comparaciones^2);
            if(hashTable[hash]==0){
                hashTable[hash] = unaClave;
                return comparaciones;
            }
            comparaciones++;
        }
        return -comparaciones;
    }
   
}
