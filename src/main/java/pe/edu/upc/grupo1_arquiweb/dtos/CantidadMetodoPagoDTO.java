package pe.edu.upc.grupo1_arquiweb.dtos;

public class CantidadMetodoPagoDTO {

    private String tipo;
    private int cantidad;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
