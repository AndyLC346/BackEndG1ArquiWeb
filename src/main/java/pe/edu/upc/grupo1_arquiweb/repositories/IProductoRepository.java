package pe.edu.upc.grupo1_arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.grupo1_arquiweb.entities.Producto;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p "
            + "WHERE LOWER(p.nombreProducto) LIKE CONCAT('%', LOWER(:nombre), '%')")
    List<Producto> buscar(@Param("nombre") String nombre);

    @Query("""
           SELECT t.nombreTienda, COUNT(p.idProducto)
           FROM   Producto p
           JOIN   p.tienda t
           GROUP  BY t.nombreTienda
           ORDER  BY COUNT(p.idProducto) DESC
           """)
    List<Object[]> cantidadProductosPorTienda();

    @Query("SELECT p FROM Producto p WHERE p.idProducto IN (:id1, :id2)")
    List<Producto> compararProductos(@Param("id1") Long id1,
                                     @Param("id2") Long id2);
}
