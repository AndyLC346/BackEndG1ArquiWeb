package pe.edu.upc.grupo1_arquiweb.dtos;

import pe.edu.upc.grupo1_arquiweb.entities.MetodoPago;
import pe.edu.upc.grupo1_arquiweb.entities.Producto;
import pe.edu.upc.grupo1_arquiweb.entities.Users;

import java.time.LocalDate;

public class CarritoCompraDTO {

    private Long idCarritoCompra;
    private LocalDate fechaCreaCarritoCompra;
    private int cantidad;
    private MetodoPago metodoPago;
    private Producto producto;
    private Users user;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Long getIdCarritoCompra() {
        return idCarritoCompra;
    }

    public void setIdCarritoCompra(Long idCarritoCompra) {
        this.idCarritoCompra = idCarritoCompra;
    }

    public LocalDate getFechaCreaCarritoCompra() {
        return fechaCreaCarritoCompra;
    }

    public void setFechaCreaCarritoCompra(LocalDate fechaCreaCarritoCompra) {
        this.fechaCreaCarritoCompra = fechaCreaCarritoCompra;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
