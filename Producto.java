public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int existencias;

    public Producto(String codigo, String nombre, double precio, int existencias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public boolean descontarExistencias(int cantidad) {
        if (cantidad <= existencias) {
            existencias -= cantidad;
            return true;
        }
        return false;
    }
}