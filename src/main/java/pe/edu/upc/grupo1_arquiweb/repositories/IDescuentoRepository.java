package pe.edu.upc.grupo1_arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.grupo1_arquiweb.entities.Descuento;

import java.util.List;

@Repository
public interface IDescuentoRepository extends JpaRepository<Descuento, Long> {

    @Query(value = " SELECT " +
            " id_descuento, " +
            " codigo_descuento, " +
            " porcentaje_descuento, " +
            " fecha_inicio_descuento, " +
            " fecha_fin_descuento " +
            " FROM descuento " +
            " WHERE CURRENT_DATE BETWEEN fecha_inicio_descuento AND fecha_fin_descuento " +
            " ORDER BY fecha_fin_descuento ASC", nativeQuery = true)
    List<Object[]> listarDescuentosVigentes();

    @Query(" SELECT d FROM Descuento d " +
            " WHERE CURRENT_DATE BETWEEN d.fechaInicioDescuento AND d.fechaFinDescuento " +
            " ORDER BY d.porcentajeDescuento DESC ")
    List<Descuento> listarDescuentosOrdenadosPorPorcentaje();
}
