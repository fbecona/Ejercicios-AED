
package subsecuencias;

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author estudiante.fit
 */
public class TArbolTrieTest {

    private TArbolTrie trie;
    
    public TArbolTrieTest() {
        trie = new TArbolTrie();
        trie.insertar("a", 0);
        trie.insertar("a", 1);
    }
    
    @Test
    public void testInsertar() {
        LinkedList<Integer> inicios = trie.getRaiz().getHijos()[0].getIniciosPalabra();
        assertEquals(2, inicios.size());
    }
    
    @Test
    public void testBuscarSecuencia() {
        LinkedList<String> lista = new LinkedList<>();
        lista.add("0-0");
        lista.add("1-1");
        assertEquals(lista, trie.buscarSecuencia("a"));
    }
    
}
