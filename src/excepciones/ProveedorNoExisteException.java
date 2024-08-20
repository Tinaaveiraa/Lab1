package excepciones;

/**
 * Excepción utilizada para indicar la inexistencia de un usuario en el sistema.
 * 
 */
@SuppressWarnings("serial")
public class ProveedorNoExisteException extends Exception {

    public ProveedorNoExisteException(String string) {
        super(string);
    }
}
