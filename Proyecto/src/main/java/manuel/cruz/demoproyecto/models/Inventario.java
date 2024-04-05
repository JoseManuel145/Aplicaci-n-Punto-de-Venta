package manuel.cruz.demoproyecto.models;

import java.util.ArrayList;

public class Inventario {
    private ArrayList <Producto> productos = new ArrayList<>();

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void addProduct(Producto producto){
        productos.add(producto);
    }
    public void delProducto (String id){
        for (int i = 0; i < productos.size(); i++){
            if (productos.get(i).getId().equals(id));{
                productos.remove(i);
            }
        }
    }
    public Producto getProductoPorId(String id) {
        for (Producto producto : productos) {
            if (id.equals(producto.getId())) {
                return producto;
            }
        }
        return null;
    }
    public void reducirStock(String id) {
        Producto producto = getProductoPorId(id);
        if (producto != null && producto.getCantidad() > 0) {
            producto.setCantidad(producto.getCantidad() - 1);
        }
    }

    public void aumentarStock(String id) {
        Producto producto = getProductoPorId(id);
        if (producto != null) {
            producto.setCantidad(producto.getCantidad() + 1);
        }
    }
}
