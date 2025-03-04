package ta5;

public class FiltradorPalabras {

    public static String filtrarPalabra(String unaPalabra) {
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < unaPalabra.length(); i++) {
            char caracter = unaPalabra.charAt(i);
            if ((caracter >= 'A' && caracter <= 'Z') ||
                 (caracter >= 'a' && caracter <= 'z'))
                    sb.append(caracter);
            }
	return sb.toString().toLowerCase();
    }
    
}
