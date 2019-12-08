package buscartelefonos;

public class TAbonado implements Comparable {

    private final String nombre;
    private final String telefono;

    TAbonado(String unNombre, String unTelefono) {

        this.nombre = unNombre;
        this.telefono = unTelefono;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getTelefono() {
        return this.telefono;
    }

    @Override
    public int compareTo(Object o) {
        return (this.nombre.compareTo(((TAbonado)o).getNombre()));
    }
}
