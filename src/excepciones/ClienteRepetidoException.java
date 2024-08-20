package excepciones;

/**
 * Excepción utilizada para indicar la existencia de un usuario repetido en el sistema.
 * 
 */
@SuppressWarnings("serial")
public class ClienteRepetidoException extends Exception {

    public ClienteRepetidoException(String string) {
        super(string);
    }

}
