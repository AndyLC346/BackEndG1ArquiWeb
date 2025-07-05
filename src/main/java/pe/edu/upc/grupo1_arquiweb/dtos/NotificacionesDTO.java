package pe.edu.upc.grupo1_arquiweb.dtos;

import pe.edu.upc.grupo1_arquiweb.entities.Users;

import java.time.LocalDateTime;

public class NotificacionesDTO {

    private Long idNotificacion;
    private String mensaje;
    private LocalDateTime fechaEnvioNotificacion;
    private boolean leido;
    private Users user;

    public Long getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Long idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaEnvioNotificacion() {
        return fechaEnvioNotificacion;
    }

    public void setFechaEnvioNotificacion(LocalDateTime fechaEnvioNotificacion) {
        this.fechaEnvioNotificacion = fechaEnvioNotificacion;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
