/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tda.arbolcompleto;

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
public class TElementoABTest {
    
    public TElementoABTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getHijoIzq method, of class TElementoAB.
     */
    @Test
    public void testGetHijoIzq() {
        System.out.println("getHijoIzq");
        TElementoAB instance = null;
        TElementoAB expResult = null;
        TElementoAB result = instance.getHijoIzq();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHijoDer method, of class TElementoAB.
     */
    @Test
    public void testGetHijoDer() {
        System.out.println("getHijoDer");
        TElementoAB instance = null;
        TElementoAB expResult = null;
        TElementoAB result = instance.getHijoDer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertar method, of class TElementoAB.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        TElementoAB instance = null;
        boolean expResult = false;
        boolean result = instance.insertar(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class TElementoAB.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Comparable unaEtiqueta = null;
        TElementoAB instance = null;
        TElementoAB expResult = null;
        TElementoAB result = instance.buscar(unaEtiqueta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class TElementoAB.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        Comparable unaEtiqueta = null;
        TElementoAB instance = null;
        TElementoAB expResult = null;
        TElementoAB result = instance.eliminar(unaEtiqueta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEtiqueta method, of class TElementoAB.
     */
    @Test
    public void testGetEtiqueta() {
        System.out.println("getEtiqueta");
        TElementoAB instance = null;
        Comparable expResult = null;
        Comparable result = instance.getEtiqueta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDatos method, of class TElementoAB.
     */
    @Test
    public void testGetDatos() {
        System.out.println("getDatos");
        TElementoAB instance = null;
        Object expResult = null;
        Object result = instance.getDatos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHijoIzq method, of class TElementoAB.
     */
    @Test
    public void testSetHijoIzq() {
        System.out.println("setHijoIzq");
        TElementoAB instance = null;
        instance.setHijoIzq(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHijoDer method, of class TElementoAB.
     */
    @Test
    public void testSetHijoDer() {
        System.out.println("setHijoDer");
        TElementoAB instance = null;
        instance.setHijoDer(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clonar method, of class TElementoAB.
     */
    @Test
    public void testClonar() {
        System.out.println("clonar");
        TElementoAB instance = null;
        TElementoAB expResult = null;
        TElementoAB result = instance.clonar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of preOrden method, of class TElementoAB.
     */
    @Test
    public void testPreOrden() {
        System.out.println("preOrden");
        TElementoAB instance = null;
        String expResult = "";
        String result = instance.preOrden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inOrden method, of class TElementoAB.
     */
    @Test
    public void testInOrden() {
        System.out.println("inOrden");
        TElementoAB instance = null;
        String expResult = "";
        String result = instance.inOrden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of postOrden method, of class TElementoAB.
     */
    @Test
    public void testPostOrden() {
        System.out.println("postOrden");
        TElementoAB instance = null;
        String expResult = "";
        String result = instance.postOrden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inOrdenLista method, of class TElementoAB.
     */
    @Test
    public void testInOrdenLista() {
        System.out.println("inOrdenLista");
        TElementoAB instance = null;
        instance.inOrdenLista(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerAltura method, of class TElementoAB.
     */
    @Test
    public void testObtenerAltura() {
        System.out.println("obtenerAltura");
        TElementoAB instance = null;
        int expResult = 0;
        int result = instance.obtenerAltura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTamanio method, of class TElementoAB.
     */
    @Test
    public void testObtenerTamanio() {
        System.out.println("obtenerTamanio");
        TElementoAB instance = null;
        int expResult = 0;
        int result = instance.obtenerTamanio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerNivel method, of class TElementoAB.
     */
    @Test
    public void testObtenerNivel() {
        System.out.println("obtenerNivel");
        Comparable unaEtiqueta = null;
        TElementoAB instance = null;
        int expResult = 0;
        int result = instance.obtenerNivel(unaEtiqueta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerCantidadHojas method, of class TElementoAB.
     */
    @Test
    public void testObtenerCantidadHojas() {
        System.out.println("obtenerCantidadHojas");
        TElementoAB instance = null;
        int expResult = 0;
        int result = instance.obtenerCantidadHojas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nivelDeHojas method, of class TElementoAB.
     */
    @Test
    public void testNivelDeHojas() {
        System.out.println("nivelDeHojas");
        int nivel = 0;
        TElementoAB instance = null;
        String expResult = "";
        String result = instance.obtenerNivelDeHojas(nivel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cantidadDeHojas method, of class TElementoAB.
     */
    @Test
    public void testCantidadDeHojas() {
        System.out.println("cantidadDeHojas");
        TElementoAB instance = null;
        int expResult = 0;
        int result = instance.cantidadDeHojas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cantidadNodosNivel method, of class TElementoAB.
     */
    @Test
    public void testCantidadNodosNivel() {
        System.out.println("cantidadNodosNivel");
        int actual = 0;
        int nivel = 0;
        TElementoAB instance = null;
        int expResult = 0;
        int result = instance.obtenerCantidadNodosUnNivel(actual, nivel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarContando method, of class TElementoAB.
     */
    @Test
    public void testInsertarContando() {
        System.out.println("insertarContando");
        TElementoAB instance = null;
        int expResult = 0;
        int result = instance.insertarContando(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarContandoArray method, of class TElementoAB.
     */
    @Test
    public void testInsertarContandoArray() {
        System.out.println("insertarContandoArray");
        TElementoAB instance = null;
        int[] expResult = null;
        int[] result = instance.insertarContandoArray(null,null);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerCantidadDeHojas method, of class TElementoAB.
     */
    @Test
    public void testObtenerCantidadDeHojas() {
        System.out.println("obtenerCantidadDeHojas");
        TElementoAB instance = null;
        int expResult = 0;
        int result = instance.obtenerCantidadDeHojas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cantidadNodosUnNivel method, of class TElementoAB.
     */
    @Test
    public void testCantidadNodosUnNivel() {
        System.out.println("cantidadNodosUnNivel");
        int actual = 0;
        int nivel = 0;
        TElementoAB instance = null;
        int expResult = 0;
        int result = instance.obtenerCantidadNodosUnNivel(actual, nivel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hojasConSuNivel method, of class TElementoAB.
     */
    @Test
    public void testHojasConSuNivel() {
        System.out.println("hojasConSuNivel");
        int actual = 0;
        TElementoAB instance = null;
        String expResult = "";
        String result = instance.hojasConSuNivel(actual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cantidadNodosCompletos method, of class TElementoAB.
     */
    @Test
    public void testCantidadNodosCompletos() {
        System.out.println("cantidadNodosCompletos");
        TElementoAB instance = null;
        int expResult = 0;
        int result = instance.obtenerCantidadNodosCompletos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esDeBusqueda method, of class TElementoAB.
     */
    @Test
    public void testEsDeBusqueda() {
        System.out.println("esDeBusqueda");
        TElementoAB instance = null;
        boolean expResult = false;
        boolean result = instance.esDeBusqueda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sumaClaves method, of class TElementoAB.
     */
    @Test
    public void testSumaClaves() {
        System.out.println("sumaClaves");
        TElementoAB instance = null;
        int expResult = 0;
        int result = instance.sumaClaves();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of menorClave method, of class TElementoAB.
     */
    @Test
    public void testMenorClave() {
        System.out.println("menorClave");
        TElementoAB instance = null;
        Comparable expResult = null;
        Comparable result = instance.menorClave();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mayorClave method, of class TElementoAB.
     */
    @Test
    public void testMayorClave() {
        System.out.println("mayorClave");
        TElementoAB instance = null;
        Comparable expResult = null;
        Comparable result = instance.mayorClave();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of claveAnterior method, of class TElementoAB.
     */
    @Test
    public void testClaveAnterior() {
        System.out.println("claveAnterior");
        Comparable clave = null;
        TElementoAB instance = null;
        Comparable expResult = null;
        Comparable result = instance.claveAnterior(clave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mayorDatoEntre method, of class TElementoAB.
     */
    @Test
    public void testMayorDatoEntre() {
        System.out.println("mayorDatoEntre");
        Comparable claveMenor = null;
        Comparable claveMayor = null;
        TElementoAB instance = null;
        Integer expResult = null;
        Integer result = instance.mayorDatoEntre(claveMenor, claveMayor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
