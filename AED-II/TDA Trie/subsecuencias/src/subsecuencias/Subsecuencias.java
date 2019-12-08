package subsecuencias;

import java.util.LinkedList;

public class Subsecuencias {

    public static void main(String[] args) {
        
        TArbolTrie trieSufijos = new TArbolTrie();
        String palabra = "ttctaatgtcccgacgctttatagcatcccatgcgattgcgaccttctcccctttatacgtctctacggtatgtttgtcgttcctctgtgtacgtctggtgcttcagtatcccgggtcggcaggaccgcccccggcgcaccgaagcgaacaagtatttaaacttgtgttcgcgacttgtctagattgatgtgttgtttcggtggactttatacctttctatatactgcgggttacgcatggcggttcctctttattctaagcttccactccattgcgcagcttagactcgattttttatttggcgggtcataaatctcacctctctgctcttccatattcggacagtcgggagattatgacgttgccatgtccgaccggtagataccagggacagacgcccggcgtgtaacggaaactgttccgctctcaccgtggtcacctcagcatatgtttcgtgtctcgtttgatggctcagctgggacgactagtacggtctggaagcgtagagctggcttcatgtacctctttcggtctttgtgcgcttcgtgttcctggggtgtcgtcccacgacatctgaagttagttgtcattaacccccccggcgccttgtcgaaaatatccaggcctagtatgcctgcggatgcctctatcgtgactcggttgctgtggtttagtttggactcttactccatactttaacccgttacctactggctctgttaatgcatggttacgcgcgtgtattccccggtctgcaaggttgtgtgcgatgaggtgcgaattcgcagcatcggacatacaggacagcgtggtcgggaatcgtccgcggccctgtgggccagtgatagtgaggtctacgtgagctaacatgctggatggttgggagggcttgtagtttcagatgtcgaaatgcaaccccgataacaccccgttaccttgtctgacgaccttaggtgcgtctgtaacggagactaagaccggtcacaagtcaatcggtg".toLowerCase();
        
        for(int i=0; i<palabra.length();i++){
            trieSufijos.insertar(palabra.substring(i), i);
        }
        LinkedList<String> lista = trieSufijos.buscarSecuencia("ggc");
        for(String sub : lista){
            System.out.println(sub);
        }
        
    }
    
}
