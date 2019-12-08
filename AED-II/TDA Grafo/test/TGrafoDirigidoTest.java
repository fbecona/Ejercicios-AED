
import java.util.Collection;
import java.util.Map;
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
public class TGrafoDirigidoTest {
    
    TGrafoDirigido grafoDirigido;
    
    public TGrafoDirigidoTest() {
        grafoDirigido = UtilGrafos.cargarGrafo("src/aeropuertos.txt", "src/conexiones.txt", true, TGrafoDirigido.class); //copiar archivos!!!!
    }
    
}
