package pe.edu.upc.grupo1_arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.grupo1_arquiweb.entities.Tienda;

import java.util.List;

@Repository
public interface ITiendaRepository extends JpaRepository<Tienda, Long> {

    @Query("SELECT t FROM Tienda t "
            + "WHERE LOWER(t.nombreTienda) LIKE CONCAT('%', LOWER(:nombre), '%')")
    List<Tienda> buscar(@Param("nombre") String nombre);
}
