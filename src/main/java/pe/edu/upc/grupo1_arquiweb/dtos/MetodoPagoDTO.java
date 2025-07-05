package pe.edu.upc.grupo1_arquiweb.dtos;

import pe.edu.upc.grupo1_arquiweb.entities.Users;

import java.time.LocalDate;

public class MetodoPagoDTO {

    private Long idMetodoPago;
    private String Tipo;
    private LocalDate vencimientoMetodo;
    private Users user;

    public Long getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Long idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public LocalDate getVencimientoMetodo() {
        return vencimientoMetodo;
    }

    public void setVencimientoMetodo(LocalDate vencimientoMetodo) {
        this.vencimientoMetodo = vencimientoMetodo;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
