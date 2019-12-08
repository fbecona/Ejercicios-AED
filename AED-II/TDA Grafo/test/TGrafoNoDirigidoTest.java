/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Collection;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fedeb
 */
public class TGrafoNoDirigidoTest {
    
    TGrafoNoDirigido grafoNoDirigido;
    
    public TGrafoNoDirigidoTest() {
        grafoNoDirigido = UtilGrafos.cargarGrafo("src/aeropuertos.txt", "src/conexiones.txt", true, TGrafoNoDirigido.class); //copiar archivos!!!!
    }
 
}
