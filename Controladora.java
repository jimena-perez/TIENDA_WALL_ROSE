import java.util.ArrayList;

public class Controladora {
    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;
    private ArrayList<OrdenCompra> ordenes;
    private int contadorOrdenes;

    public Controladora() {
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
        ordenes = new ArrayList<>();
        contadorOrdenes = 1;
    }

    public boolean agregarCliente(String id, String nombre, String email) {
        if (buscarCliente(id) == null) {
            clientes.add(new Cliente(id, nombre, email));
            return true;
        }
        return false;
    }

    public Cliente buscarCliente(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean agregarProducto(String codigo, String nombre, double precio, int existencias) {
        if (buscarProducto(codigo) == null) {
            productos.add(new Producto(codigo, nombre, precio, existencias));
            return true;
        }
        return false;
    }

    public Producto buscarProducto(String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    public OrdenCompra crearOrden(String idCliente) {
        Cliente cliente = buscarCliente(idCliente);

        if (cliente != null) {
            OrdenCompra orden = new OrdenCompra(contadorOrdenes, cliente);
            ordenes.add(orden);
            contadorOrdenes++;
            return orden;
        }

        return null;
    }

    public boolean agregarProductoAOrden(int idOrden, String codigoProducto, int cantidad) {
        OrdenCompra orden = buscarOrden(idOrden);
        Producto producto = buscarProducto(codigoProducto);

        if (orden != null && producto != null) {
            if (producto.descontarExistencias(cantidad)) {
                orden.agregarLinea(producto, cantidad);
                return true;
            }
        }

        return false;
    }

    public OrdenCompra buscarOrden(int idOrden) {
        for (OrdenCompra orden : ordenes) {
            if (orden.getId() == idOrden) {
                return orden;
            }
        }
        return null;
    }
}