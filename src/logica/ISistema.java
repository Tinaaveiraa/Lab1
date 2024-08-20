package logica;

import excepciones.ClienteNoExisteException;
import excepciones.ProveedorNoExisteException;
import excepciones.ClienteRepetidoException;
import excepciones.ProveedorRepetidoException;
import java.util.Date;

public interface ISistema {

    /**
     * Registra al cliente en el sistema.
     * @param nickname Nickname del cliente.
     * @param email Email del cliente.
     * @param nombre Nombre del cliente.
     * @param apellido Apellido del cliente.
     * @param fnacimiento Fecha de nacimiento del cliente.
     * @throws ClienteRepetidoException Si el cliente ya está registrado en el sistema.
     */
    public abstract void registrarCliente(String nickname, String email, String nombre, String apellido, Date fnacimiento) throws ClienteRepetidoException;

    /**
     * Registra al proveedor en el sistema.
     * @param nickname Nickname del proveedor.
     * @param email Email del proveedor.
     * @param nombre Nombre del proveedor.
     * @param apellido Apellido del proveedor.
     * @param fnacimiento Fecha de nacimiento del proveedor.
     * @param URL URL del proveedor.
     * @param nombreEmpresa Nombre de la empresa del proveedor.
     * @throws ProveedorRepetidoException Si el proveedor ya está registrado en el sistema.
     */
    public abstract void registrarProveedor(String nickname, String email, String nombre, String apellido, Date fnacimiento, String URL, String nombreEmpresa) throws ProveedorRepetidoException;

    /**
     * Retorna la información de un cliente con el nickname indicado.
     * @param nickname Nickname del cliente.
     * @return Información del cliente.
     * @throws ClienteNoExisteException Si el cliente no está registrado en el sistema.
     */
    public abstract DataCliente verInfoCliente(String nickname) throws ClienteNoExisteException;

    /**
     * Retorna la información de un proveedor con el nickname indicado.
     * @param nickname Nickname del proveedor.
     * @return Información del proveedor.
     * @throws ProveedorNoExisteException Si el proveedor no está registrado en el sistema.
     */
    public abstract DataProveedor verInfoProveedor(String nickname) throws ProveedorNoExisteException;

    /**
     * Retorna la información de todos los clientes registrados en el sistema.
     * @return Información de los clientes del sistema.
     * @throws ClienteNoExisteException Si no existen clientes registrados en el sistema.
     */
    public abstract DataCliente[] getClientes() throws ClienteNoExisteException;

    /**
     * Retorna la información de todos los proveedores registrados en el sistema.
     * @return Información de los proveedores del sistema.
     * @throws ProveedorNoExisteException Si no existen proveedores registrados en el sistema.
     */
    public abstract DataProveedor[] getProveedores() throws ProveedorNoExisteException;
}

