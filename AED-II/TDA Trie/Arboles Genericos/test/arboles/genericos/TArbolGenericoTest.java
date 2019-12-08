/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.genericos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author estudiante.fit
 */
public class TArbolGenericoTest {
    
    public TArbolGenericoTest() {
    }
    
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        Comparable unaEtiqueta = null;
        Comparable etiquetaPadre = null;
        TArbolGenerico instance = new TArbolGenerico();
        boolean expResult = false;
        boolean result = instance.insertar(unaEtiqueta, etiquetaPadre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Comparable unaEtiqueta = null;
        TArbolGenerico instance = new TArbolGenerico();
        TElementoGenerico expResult = null;
        TElementoGenerico result = instance.buscar(unaEtiqueta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testListarOrdenado() {
        System.out.println("listarOrdenado");
        TArbolGenerico instance = new TArbolGenerico();
        instance.listarOrdenado();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
