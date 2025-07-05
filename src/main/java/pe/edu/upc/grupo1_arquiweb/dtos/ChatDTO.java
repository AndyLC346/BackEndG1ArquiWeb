package pe.edu.upc.grupo1_arquiweb.dtos;

import pe.edu.upc.grupo1_arquiweb.entities.Tienda;
import pe.edu.upc.grupo1_arquiweb.entities.Users;

import java.time.LocalDate;

public class ChatDTO {

    private Long idChat;
    private String contenido;
    private LocalDate fechaInicioChat;
    private Users user;
    private Tienda tienda;

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Long getIdChat() {
        return idChat;
    }

    public void setIdChat(Long idChat) {
        this.idChat = idChat;
    }

    public LocalDate getFechaInicioChat() {
        return fechaInicioChat;
    }

    public void setFechaInicioChat(LocalDate fechaInicioChat) {
        this.fechaInicioChat = fechaInicioChat;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}
