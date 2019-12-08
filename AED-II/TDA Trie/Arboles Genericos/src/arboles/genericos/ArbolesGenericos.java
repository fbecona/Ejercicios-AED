
package arboles.genericos;

public class ArbolesGenericos {

    public static void main(String[] args) {
        TArbolGenerico ucu = new TArbolGenerico();
        ucu.insertar("Rectoria", "");
        ucu.insertar("Vicerrectoría del medio universitario", "Rectoria");
        ucu.insertar("Vicerrectoría académica", "Rectoria");
        ucu.insertar("Vicerrectoría administrativa", "Rectoria");
        ucu.insertar("Vicerrectoría del medio universitario", "Rectoria");
        ucu.insertar("Facultad de ciencias empresariales", "Vicerrectoría académica");
        ucu.insertar("Facultad de ciencias humanas", "Vicerrectoría académica");
        ucu.insertar("Facultad de ingeniería y tecnologías", "Vicerrectoría académica");
        ucu.insertar("Facultad de psicología", "Vicerrectoría académica");
        ucu.insertar("Departamento de informática y ciencias de la computación", "Facultad de ingeniería y tecnologías");
        ucu.insertar("Departamento de ingeniería eléctrica", "Facultad de ingeniería y tecnologías");
        ucu.insertar("Departamento de matemáticas", "Facultad de ingeniería y tecnologías");
        ucu.listarOrdenado();
        
        
        System.out.println(ucu.buscar("Facultad de ingeniería y tecnologías").getEtiqueta());
    }
    
}
