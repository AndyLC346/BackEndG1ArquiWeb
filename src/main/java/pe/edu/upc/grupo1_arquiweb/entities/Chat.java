package pe.edu.upc.grupo1_arquiweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChat;

    @Column(name="contenido", nullable = false, length = 400)
    private String contenido;

    @Column(name="fechaInicioChat", nullable = false)
    private LocalDate fechaInicioChat;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "tienda_id")
    private Tienda tienda;

    public Chat() {
    }

    public Chat(Long idChat,String contenido,LocalDate fechaInicioChat, Users user, Tienda tienda) {
        this.idChat = idChat;
        this.contenido = contenido;
        this.fechaInicioChat = fechaInicioChat;
        this.user = user;
        this.tienda = tienda;
    }

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
