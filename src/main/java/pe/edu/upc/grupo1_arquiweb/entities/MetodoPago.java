package pe.edu.upc.grupo1_arquiweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "MetodoPago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMetodoPago;

    @Column(name = "tipo", nullable = false, length = 100)
    private String tipo;

    @Column(name = "vencimientoMetodo", nullable = false)
    private LocalDate vencimientoMetodo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "metodoPago")
    @JsonIgnoreProperties("metodoPago")
    private List<CarritoCompra> carritos;

    public MetodoPago(List<CarritoCompra> carritos) {
        this.carritos = carritos;
    }

    public List<CarritoCompra> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<CarritoCompra> carritos) {
        this.carritos = carritos;
    }

    public MetodoPago() {
    }

    public MetodoPago(Long idMetodoPago, String tipo, LocalDate vencimientoMetodo, Users user) {
        this.idMetodoPago = idMetodoPago;
        this.tipo = tipo;
        this.vencimientoMetodo = vencimientoMetodo;
        this.user = user;
    }

    public Long getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Long idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
