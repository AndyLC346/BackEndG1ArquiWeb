package pe.edu.upc.grupo1_arquiweb.dtos;

public class CantidadProductosDTO {

    private String nombre;
    private int    cantidadProductos;

    public CantidadProductosDTO(String nombre, int cantidadProductos) {
        this.nombre            = nombre;
        this.cantidadProductos = cantidadProductos;
    }
    public String getNombre()              { return nombre; }
    public int    getCantidadProductos()   { return cantidadProductos; }
    public void   setNombre(String nombre) { this.nombre = nombre; }
    public void   setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }
}
