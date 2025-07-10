package pe.edu.upc.grupo1_arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.grupo1_arquiweb.entities.CarritoCompra;

import java.util.List;

@Repository
public interface ICarritoCompraRepository extends JpaRepository<CarritoCompra, Long> {

    @Query(value = "SELECT " +
            " cc.id_carrito_compra, " +
            " cc.fecha_crea_carrito_compra, " +
            " u.username, " +
            " p.nombre_producto, " +
            " p.precio_producto, " +
            " cc.cantidad " +
            " FROM carrito_compra cc " +
            " JOIN producto p ON cc.producto_id = p.id_producto " +
            " JOIN users u ON cc.user_id = u.id_user " +
            " ORDER BY p.precio_producto DESC",
            nativeQuery = true)
    List<Object[]> ordenarCarritoCompra();

    @Query(" SELECT c FROM CarritoCompra c WHERE c.user.idUser = :idUsuario ORDER BY c.fechaCreaCarritoCompra DESC")
    List<CarritoCompra> BuscarCarritoCompraXID(@Param("idUsuario") int idUsuario);
}