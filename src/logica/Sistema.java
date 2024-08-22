package logica;

import excepciones.ClienteNoExisteException;
import excepciones.ProveedorNoExisteException;
import excepciones.ClienteRepetidoException;
import excepciones.ProveedorRepetidoException;

public class Sistema implements ISistema {

    public Sistema() {
    }

    // Registro de Cliente
    public void registrarCliente(String nickname, String email, String nombre, String apellido, String fNacimiento) throws ClienteRepetidoException {
        ManejadorCliente mc = ManejadorCliente.getInstance();
        Cliente c = mc.obtenerCliente(nickname);
        if (c != null)
            throw new ClienteRepetidoException("El cliente con nickname " + nickname + " ya está registrado");

        c = new Cliente(nickname, email, nombre, apellido, fNacimiento);
        mc.addCliente(c);
    }

    // Registro de Proveedor
    public void registrarProveedor(String nickname, String email, String nombre, String apellido, String URL, String nombreEmpresa, String fnacimiento) throws ProveedorRepetidoException {
        ManejadorProveedor mp = ManejadorProveedor.getInstance();
        Proveedor p = mp.obtenerProveedor(nickname);
        if (p != null)
            throw new ProveedorRepetidoException("El proveedor con nickname " + nickname + " ya está registrado");

        p = new Proveedor(nickname, email, nombre, apellido, fnacimiento, URL, nombreEmpresa);
        mp.addProveedor(p);
    }

    // Ver información de Cliente
    public DataCliente verInfoCliente(String nickname) throws ClienteNoExisteException {
        ManejadorCliente mc = ManejadorCliente.getInstance();
        Cliente c = mc.obtenerCliente(nickname);
        if (c != null)
            return new DataCliente(c.getNickname(), c.getEmail(), c.getNombre(), c.getApellido(), c.getfNacimiento());
        else
            throw new ClienteNoExisteException("El cliente con nickname " + nickname + " no existe");
    }

    // Ver información de Proveedor
    public DataProveedor verInfoProveedor(String nickname) throws ProveedorNoExisteException {
        ManejadorProveedor mp = ManejadorProveedor.getInstance();
        Proveedor p = mp.obtenerProveedor(nickname);
        if (p != null)
            return new DataProveedor(p.getNickname(), p.getEmail(), p.getNombre(), p.getApellido(), p.getfNacimiento(), p.getURL(), p.getNombreEmpresa());
        else
            throw new ProveedorNoExisteException("El proveedor con nickname " + nickname + " no existe");
    }

    // Obtener todos los Clientes
    public DataCliente[] getClientes() throws ClienteNoExisteException {
        ManejadorCliente mc = ManejadorCliente.getInstance();
        Cliente[] clientes = mc.getClientes();

        if (clientes != null) {
            DataCliente[] dc = new DataCliente[clientes.length];
            Cliente cliente;

            for (int i = 0; i < clientes.length; i++) {
                cliente = clientes[i];
                dc[i] = new DataCliente(cliente.getNickname(), cliente.getEmail(), cliente.getNombre(), cliente.getApellido(), cliente.getfNacimiento());
            }

            return dc;
        } else {
            throw new ClienteNoExisteException("No existen clientes registrados");
        }
    }

    // Obtener todos los Proveedores
    public DataProveedor[] getProveedores() throws ProveedorNoExisteException {
        ManejadorProveedor mp = ManejadorProveedor.getInstance();
        Proveedor[] proveedores = mp.getProveedores();

        if (proveedores != null) {
            DataProveedor[] dp = new DataProveedor[proveedores.length];
            Proveedor proveedor;

            for (int i = 0; i < proveedores.length; i++) {
                proveedor = proveedores[i];
                dp[i] = new DataProveedor(proveedor.getNickname(), proveedor.getEmail(), proveedor.getNombre(), proveedor.getApellido(), proveedor.getfNacimiento(), proveedor.getURL(), proveedor.getNombreEmpresa());
            }

            return dp;
        } else {
            throw new ProveedorNoExisteException("No existen proveedores registrados");
        }
    }
}
