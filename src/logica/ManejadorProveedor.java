package logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ManejadorProveedor {
    private Map<String, Proveedor> proveedoresNickname;
    private static ManejadorProveedor instancia = null;

    private ManejadorProveedor() {
        proveedoresNickname = new HashMap<String, Proveedor>();
    }

    public static ManejadorProveedor getInstance() {
        if (instancia == null)
            instancia = new ManejadorProveedor();
        return instancia;
    }

    public void addProveedor(Proveedor prov) {
        String nickname = prov.getNickname();
        proveedoresNickname.put(nickname, prov);
    }

    public Proveedor obtenerProveedor(String nickname) {
        return proveedoresNickname.get(nickname);
    }

    public Proveedor[] getProveedores() {
        if (proveedoresNickname.isEmpty())
            return null;
        else {
            Collection<Proveedor> provs = proveedoresNickname.values();
            Object[] o = provs.toArray();
            Proveedor[] proveedores = new Proveedor[o.length];
            for (int i = 0; i < o.length; i++) {
                proveedores[i] = (Proveedor) o[i];
            }

            return proveedores;
        }
    }
}
