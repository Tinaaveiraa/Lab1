package logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ManejadorProducto {
    private Map<Integer, Producto> productosNumRegistro;
    private static ManejadorProducto instancia = null;

    private ManejadorProducto() {
        productosNumRegistro = new HashMap<Integer, Producto>();
    }

    public static ManejadorProducto getInstance() {
        if (instancia == null)
            instancia = new ManejadorProducto();
        return instancia;
    }

    public void addProducto(Producto prod) {
    	Integer numRegistro = prod.getNumReg();
        productosNumRegistro.put(numRegistro, prod);
    }

    public Producto obtenerProducto(Integer numRegistro) {
        return productosNumRegistro.get(numRegistro);
    }

    public Producto[] getProductos() {
        if (productosNumRegistro.isEmpty())
            return null;
        else {
            Collection<Producto> prods = productosNumRegistro.values();
            Object[] o = prods.toArray();
            Producto[] productos = new Producto[o.length];
            for (int i = 0; i < o.length; i++) {
                productos[i] = (Producto) o[i];
            }

            return productos;
        }
    }
}
