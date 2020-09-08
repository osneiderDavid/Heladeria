package Code;

/**
 *
 * @author Parra
 */
public class Producto{
    private int id;
    private String sabores;
    private String descripcion;
    private double precio;
    private String descuento;
    private int cantidad;
    private String estado;
    public Producto(int id, String sabores, String descripcion, double precio, String descuento, int cantidad, String estado) {
        this.id = id;
        this.sabores = sabores;
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
        this.cantidad = cantidad;
        this.estado = estado;
    }

   public Producto(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setSabores(String sabores) {
        this.sabores = sabores;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getSabores() {
        return sabores;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescuento() {
        return descuento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getEstado(){
        return estado;
    }
}
