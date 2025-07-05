package pe.edu.upc.grupo1_arquiweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Tienda")
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTienda;

    @Column(name = "ubicacion", nullable = false, length = 200)
    private String ubicacion;

    @Column(name = "nombreTienda", nullable = false, length = 200)
    private String nombreTienda;

    @Column(name = "descripcionTienda", nullable = false, length = 200)
    private String descripcionTienda;

    @Column(name = "telefonoTienda", nullable = false, length = 9)
    private String telefonoTienda;

    @Column(name = "correoElectronico", nullable = false, length = 100)
    private String correoElectronico;

    @Column(name = "latitudTienda", nullable = false)
    private double latitudTienda;

    @Column(name = "longitudTienda", nullable = false)
    private double longitudTienda;

    public Tienda() {
    }

    public Tienda(Long idTienda, String ubicacion, String nombreTienda, String descripcionTienda, String telefonoTienda, String correoElectronico, double latitudTienda, double longitudTienda) {
        this.idTienda = idTienda;
        this.ubicacion = ubicacion;
        this.nombreTienda = nombreTienda;
        this.descripcionTienda = descripcionTienda;
        this.telefonoTienda = telefonoTienda;
        this.correoElectronico = correoElectronico;
        this.latitudTienda = latitudTienda;
        this.longitudTienda = longitudTienda;
    }

    public Long getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(Long idTienda) {
        this.idTienda = idTienda;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getDescripcionTienda() {
        return descripcionTienda;
    }

    public void setDescripcionTienda(String descripcionTienda) {
        this.descripcionTienda = descripcionTienda;
    }

    public String getTelefonoTienda() {
        return telefonoTienda;
    }

    public void setTelefonoTienda(String telefonoTienda) {
        this.telefonoTienda = telefonoTienda;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public double getLatitudTienda() {
        return latitudTienda;
    }

    public void setLatitudTienda(double latitudTienda) {
        this.latitudTienda = latitudTienda;
    }

    public double getLongitudTienda() {
        return longitudTienda;
    }

    public void setLongitudTienda(double longitudTienda) {
        this.longitudTienda = longitudTienda;
    }
}
