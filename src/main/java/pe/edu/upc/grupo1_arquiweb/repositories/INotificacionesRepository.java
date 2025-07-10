package pe.edu.upc.grupo1_arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.grupo1_arquiweb.entities.Notificaciones;

import java.util.List;

@Repository
public interface INotificacionesRepository extends JpaRepository<Notificaciones, Long> {

    @Query("SELECT n FROM Notificaciones n WHERE n.leido = :estado")
    List<Notificaciones> buscarPorLeido(@Param("estado") boolean estado);
}
