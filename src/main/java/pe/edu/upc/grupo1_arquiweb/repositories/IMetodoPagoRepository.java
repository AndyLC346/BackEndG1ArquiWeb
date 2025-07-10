package pe.edu.upc.grupo1_arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.grupo1_arquiweb.entities.MetodoPago;

import java.util.List;

@Repository
public interface IMetodoPagoRepository extends JpaRepository<MetodoPago,Long> {

    @Query("SELECT m FROM MetodoPago m WHERE LOWER(m.tipo) LIKE LOWER(CONCAT('%', :tipo, '%'))")
    List<MetodoPago> buscarPorTipo(@Param("tipo") String tipo);

    @Query(value = "SELECT tipo, COUNT(*) FROM metodo_pago GROUP BY tipo", nativeQuery = true)
    List<String[]> contarMetodosPorTipo();
}
