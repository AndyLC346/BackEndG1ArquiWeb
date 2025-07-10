package pe.edu.upc.grupo1_arquiweb.dtos;


import java.time.LocalDate;

public class ListarDescuentosOrdenadosPorPorcentajeDTO {

    private Long idDescuento;
    private String codigoDescuento;
    private double porcentajeDescuento;
    private LocalDate fechaInicioDescuento;
    private LocalDate fechaFinDescuento;
    private Long idProducto;

    /* Getters y Setters */

    public Long getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(Long idDescuento) {
        this.idDescuento = idDescuento;
    }

    public String getCodigoDescuento() {
        return codigoDescuento;
    }

    public void setCodigoDescuento(String codigoDescuento) {
        this.codigoDescuento = codigoDescuento;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public LocalDate getFechaInicioDescuento() {
        return fechaInicioDescuento;
    }

    public void setFechaInicioDescuento(LocalDate fechaInicioDescuento) {
        this.fechaInicioDescuento = fechaInicioDescuento;
    }

    public LocalDate getFechaFinDescuento() {
        return fechaFinDescuento;
    }

    public void setFechaFinDescuento(LocalDate fechaFinDescuento) {
        this.fechaFinDescuento = fechaFinDescuento;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }
}
