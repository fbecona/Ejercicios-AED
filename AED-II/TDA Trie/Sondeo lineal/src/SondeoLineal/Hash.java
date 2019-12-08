/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SondeoLineal;

/**
 *
 * @author estudiante.fit
 */
public class Hash implements IHash {
    
    private final int[] hashTable;
    
    public Hash(int m) {
        int extra = m/10;   //división entera
        hashTable = new int[m+extra];
    }

    @Override
    public int funcionHashing(int unaClave) {
          return unaClave % hashTable.length;
    }
    
    @Override
    public int buscar(int unaClave) {
        int comparaciones = 0;
        while(comparaciones<hashTable.length){
            int hash = funcionHashing(unaClave+comparaciones);
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
            int hash = funcionHashing(unaClave+comparaciones);
            if(hashTable[hash]==0){
                hashTable[hash] = unaClave;
                return comparaciones;
            }
            comparaciones++;
        }
        return -comparaciones;
    }
   
}
