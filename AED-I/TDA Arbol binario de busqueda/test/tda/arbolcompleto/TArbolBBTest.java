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
public class TArbolBBTest {
    
    public TArbolBBTest() {
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
     * Test of insertar method, of class TArbolBB.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        TArbolBB instance = new TArbolBB();
        boolean expResult = false;
        boolean result = instance.insertar(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class TArbolBB.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Comparable unaEtiqueta = null;
        TArbolBB instance = new TArbolBB();
        TElementoAB expResult = null;
        TElementoAB result = instance.buscar(unaEtiqueta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class TArbolBB.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        Comparable unaEtiqueta = null;
        TArbolBB instance = new TArbolBB();
        instance.eliminar(unaEtiqueta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of preOrden method, of class TArbolBB.
     */
    @Test
    public void testPreOrden() {
        System.out.println("preOrden");
        TArbolBB instance = new TArbolBB();
        String expResult = "";
        String result = instance.preOrden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inOrden method, of class TArbolBB.
     */
    @Test
    public void testInOrden() {
        System.out.println("inOrden");
        TArbolBB instance = new TArbolBB();
        String expResult = "";
        String result = instance.inOrden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of postOrden method, of class TArbolBB.
     */
    @Test
    public void testPostOrden() {
        System.out.println("postOrden");
        TArbolBB instance = new TArbolBB();
        String expResult = "";
        String result = instance.postOrden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inorden method, of class TArbolBB.
     */
    @Test
    public void testInorden() {
        System.out.println("inorden");
        TArbolBB instance = new TArbolBB();
        Lista expResult = null;
        Lista result = instance.inorden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerAltura method, of class TArbolBB.
     */
    @Test
    public void testObtenerAltura() {
        System.out.println("obtenerAltura");
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.obtenerAltura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTamanio method, of class TArbolBB.
     */
    @Test
    public void testObtenerTamanio() {
        System.out.println("obtenerTamanio");
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.obtenerTamanio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerNivel method, of class TArbolBB.
     */
    @Test
    public void testObtenerNivel() {
        System.out.println("obtenerNivel");
        Comparable unaEtiqueta = null;
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.obtenerNivel(unaEtiqueta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerCantidadHojas method, of class TArbolBB.
     */
    @Test
    public void testObtenerCantidadHojas() {
        System.out.println("obtenerCantidadHojas");
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.obtenerCantidadHojas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esVacio method, of class TArbolBB.
     */
    @Test
    public void testEsVacio() {
        System.out.println("esVacio");
        TArbolBB instance = new TArbolBB();
        boolean expResult = false;
        boolean result = instance.esVacio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of vaciar method, of class TArbolBB.
     */
    @Test
    public void testVaciar() {
        System.out.println("vaciar");
        TArbolBB instance = new TArbolBB();
        boolean expResult = false;
        boolean result = instance.vaciar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nivelDeHojas method, of class TArbolBB.
     */
    @Test
    public void testNivelDeHojas() {
        System.out.println("nivelDeHojas");
        TArbolBB instance = new TArbolBB();
        String expResult = "";
        String result = instance.nivelDeHojas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cantidadDeHojas method, of class TArbolBB.
     */
    @Test
    public void testCantidadDeHojas() {
        System.out.println("cantidadDeHojas");
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.cantidadDeHojas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cantidadDeNodosNivel method, of class TArbolBB.
     */
    @Test
    public void testCantidadDeNodosNivel() {
        System.out.println("cantidadDeNodosNivel");
        int nivel = 0;
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.cantidadDeNodosNivel(nivel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of claveAnterior method, of class TArbolBB.
     */
    @Test
    public void testClaveAnterior() {
        System.out.println("claveAnterior");
        Comparable clave = null;
        TArbolBB instance = new TArbolBB();
        Comparable expResult = null;
        Comparable result = instance.claveAnterior(clave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarContando method, of class TArbolBB.
     */
    @Test
    public void testInsertarContando() {
        System.out.println("insertarContando");
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.insertarContando(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarContandoArray method, of class TArbolBB.
     */
    @Test
    public void testInsertarContandoArray() {
        System.out.println("insertarContandoArray");
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.insertarContandoArray(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cantidadDeNodosUnNivel method, of class TArbolBB.
     */
    @Test
    public void testCantidadDeNodosUnNivel() {
        System.out.println("cantidadDeNodosUnNivel");
        int nivel = 0;
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.obtenerCantidadDeNodosUnNivel(nivel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hojasConSuNivel method, of class TArbolBB.
     */
    @Test
    public void testHojasConSuNivel() {
        System.out.println("hojasConSuNivel");
        TArbolBB instance = new TArbolBB();
        String expResult = "";
        String result = instance.obtenerHojasConSuNivel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cantidadNodosCompletos method, of class TArbolBB.
     */
    @Test
    public void testCantidadNodosCompletos() {
        System.out.println("cantidadNodosCompletos");
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.obtenerCantidadNodosCompletos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esDeBusqueda method, of class TArbolBB.
     */
    @Test
    public void testEsDeBusqueda() {
        System.out.println("esDeBusqueda");
        TArbolBB instance = new TArbolBB();
        boolean expResult = false;
        boolean result = instance.esDeBusqueda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sumaClaves method, of class TArbolBB.
     */
    @Test
    public void testSumaClaves() {
        System.out.println("sumaClaves");
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.sumaClaves();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of menorClave method, of class TArbolBB.
     */
    @Test
    public void testMenorClave() {
        System.out.println("menorClave");
        TArbolBB instance = new TArbolBB();
        Comparable expResult = null;
        Comparable result = instance.menorClave();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mayorClave method, of class TArbolBB.
     */
    @Test
    public void testMayorClave() {
        System.out.println("mayorClave");
        TArbolBB instance = new TArbolBB();
        Comparable expResult = null;
        Comparable result = instance.mayorClave();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mayorDatoEntre method, of class TArbolBB.
     */
    @Test
    public void testMayorDatoEntre() {
        System.out.println("mayorDatoEntre");
        Comparable claveMenor = null;
        Comparable claveMayor = null;
        TArbolBB instance = new TArbolBB();
        Integer expResult = null;
        Integer result = instance.mayorDatoEntre(claveMenor, claveMayor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
