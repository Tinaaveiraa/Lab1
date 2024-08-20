package logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ManejadorCliente {
    private Map<String, Cliente> clientesNickname;
    private static ManejadorCliente instancia = null;

    private ManejadorCliente() {
        clientesNickname = new HashMap<String, Cliente>();
    }

    public static ManejadorCliente getInstance() {
        if (instancia == null)
            instancia = new ManejadorCliente();
        return instancia;
    }

    public void addCliente(Cliente cli) {
        String nickname = cli.getNickname();
        clientesNickname.put(nickname, cli);
    }

    public Cliente obtenerCliente(String nickname) {
        return ((Cliente) clientesNickname.get(nickname));
    }

    public Cliente[] getClientes() {
        if (clientesNickname.isEmpty())
            return null;
        else {
            Collection<Cliente> clts = clientesNickname.values();
            Object[] o = clts.toArray();
            Cliente[] clientes = new Cliente[o.length];
            for (int i = 0; i < o.length; i++) {
                clientes[i] = (Cliente) o[i];
            }

            return clientes;
        }
    }

}
