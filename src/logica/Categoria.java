package logica;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nombre;
    private List<Categoria> subcategorias;

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.subcategorias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Categoria> getSubcategorias() {
        return subcategorias;
    }

    public void addSubcategoria(Categoria subcategoria) {
        subcategorias.add(subcategoria);
    }

    public void removeSubcategoria(Categoria subcategoria) {
        subcategorias.remove(subcategoria);
    }

    public Categoria getSubcategoria(String nombre) {
        for (Categoria subcategoria : subcategorias) {
            if (subcategoria.getNombre().equals(nombre)) {
                return subcategoria;
            }
        }
        return null; // Si no se encuentra la subcategoría
    }

    /*// Método para imprimir la jerarquía de categorías (opcional)
    public void printCategoria(String prefix) {
        System.out.println(prefix + nombre);
        for (Categoria subcategoria : subcategorias) {
            subcategoria.printCategoria(prefix + "  ");
        }
    }*/
}
