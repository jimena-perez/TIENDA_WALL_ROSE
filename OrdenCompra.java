import java.util.ArrayList;

public class OrdenCompra {
    private int id;
    private Cliente cliente;
    private ArrayList<LineaOrden> lineas;
    private double total;

    public OrdenCompra(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.lineas = new ArrayList<>();
        this.total = 0;
    }

    public void agregarLinea(Producto producto, int cantidad) {
        LineaOrden linea = new LineaOrden(producto, cantidad);
        lineas.add(linea);
        total += linea.getSubtotal();
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<LineaOrden> getLineas() {
        return lineas;
    }

    public double getTotal() {
        return total;
    }
}