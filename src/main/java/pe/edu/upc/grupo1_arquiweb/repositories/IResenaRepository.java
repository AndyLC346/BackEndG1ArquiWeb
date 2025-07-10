package pe.edu.upc.grupo1_arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.grupo1_arquiweb.entities.Resena;

import java.util.List;

@Repository
public interface IResenaRepository extends JpaRepository<Resena, Long> {

    @Query("SELECT r FROM Resena r WHERE r.calificacion = :valor")
    List<Resena> buscarPorCalificacion(@Param("valor") double valor);

    @Query("SELECT r FROM Resena r JOIN FETCH r.user u JOIN FETCH r.producto p ORDER BY r.calificacion DESC")
    public List<Resena> listarResenasCalificacion();
}
