package excepciones;

/**
 * Excepción utilizada para indicar la inexistencia de un usuario en el sistema.
 * 
 */
@SuppressWarnings("serial")
public class ClienteNoExisteException extends Exception {

    public ClienteNoExisteException(String string) {
        super(string);
    }
}
