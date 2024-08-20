package excepciones;

/**
 * Excepción utilizada para indicar la existencia de un usuario repetido en el sistema.
 * 
 */
@SuppressWarnings("serial")
public class ProveedorRepetidoException extends Exception {

    public ProveedorRepetidoException(String string) {
        super(string);
    }

}
