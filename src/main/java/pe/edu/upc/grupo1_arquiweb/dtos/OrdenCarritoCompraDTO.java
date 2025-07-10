package pe.edu.upc.grupo1_arquiweb.dtos;

import java.time.LocalDate;

public class OrdenCarritoCompraDTO {
    private Long idCarritoCompra;
    private LocalDate fechaCreaCarritoCompra;
    private String username;
    private String nombreProducto;
    private double precioProducto;
    private int cantidad;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
