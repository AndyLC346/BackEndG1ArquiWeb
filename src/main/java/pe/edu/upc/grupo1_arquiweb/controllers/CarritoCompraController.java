package pe.edu.upc.grupo1_arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.grupo1_arquiweb.dtos.BuscarCarritoCompraxIDDTO;
import pe.edu.upc.grupo1_arquiweb.dtos.CarritoCompraDTO;
import pe.edu.upc.grupo1_arquiweb.dtos.CarritoCompraDTO2;
import pe.edu.upc.grupo1_arquiweb.dtos.OrdenCarritoCompraDTO;
import pe.edu.upc.grupo1_arquiweb.entities.CarritoCompra;
import pe.edu.upc.grupo1_arquiweb.entities.MetodoPago;
import pe.edu.upc.grupo1_arquiweb.entities.Producto;
import pe.edu.upc.grupo1_arquiweb.entities.Users;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.ICarritoCompraService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carritocompra")
public class CarritoCompraController {

    @Autowired
    private ICarritoCompraService ccS;

    @GetMapping
    public List<CarritoCompraDTO> listar() {
        return ccS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CarritoCompraDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody CarritoCompraDTO2 dto) {
        CarritoCompra carrito = new CarritoCompra();

        carrito.setFechaCreaCarritoCompra(dto.getFechaCreaCarritoCompra());
        carrito.setCantidad(dto.getCantidad());

        // Asociar solo por ID (sin traer entidades completas)
        MetodoPago mp = new MetodoPago();
        mp.setIdMetodoPago(dto.getIdMetodoPago());
        carrito.setMetodoPago(mp);

        Producto producto = new Producto();
        producto.setIdProducto(dto.getIdProducto());
        carrito.setProducto(producto);

        Users user = new Users();
        user.setIdUser(dto.getIdUser()); // ✔ CORRECTO
        carrito.setUser(user);

        ccS.insert(carrito);
    }


    @PutMapping
    public void modificar(@RequestBody CarritoCompraDTO dto) {
        ModelMapper m = new ModelMapper();
        CarritoCompra cc = m.map(dto, CarritoCompra.class);
        ccS.update(cc);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        ccS.delete(id);
    }

    @GetMapping("/{id}")
    public CarritoCompraDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        CarritoCompraDTO dto = m.map(ccS.searchId(id), CarritoCompraDTO.class);
        return dto;
    }

    @GetMapping("/carrito-ordenado-porPrecio")
    public List<OrdenCarritoCompraDTO> listarCarritoOrdenado() {
        List<Object[]> resultados = ccS.ordenarCarritoCompra();
        List<OrdenCarritoCompraDTO> dtoList = new ArrayList<>();

        for (Object[] row : resultados) {
            OrdenCarritoCompraDTO dto = new OrdenCarritoCompraDTO();
            dto.setIdCarritoCompra(((Number) row[0]).longValue());
            dto.setFechaCreaCarritoCompra(LocalDate.parse(row[1].toString()));
            dto.setUsername((String) row[2]);
            dto.setNombreProducto((String) row[3]);
            dto.setPrecioProducto(((Number) row[4]).doubleValue());
            dto.setCantidad(((Number) row[5]).intValue());
            dtoList.add(dto);
        }

        return dtoList;
    }
    @GetMapping("/BuscarCarritoPorID")
    public List<BuscarCarritoCompraxIDDTO> buscarCarritoxID(@RequestParam("idUsuario") int idUsuario) {
        return ccS.BuscarCarritoCompraXID(idUsuario).stream().map(c -> {
            BuscarCarritoCompraxIDDTO dto = new BuscarCarritoCompraxIDDTO();
            dto.setIdCarrito(c.getIdCarritoCompra().intValue());
            dto.setNombre(c.getUser().getUsername());
            dto.setNombreProducto(c.getProducto().getNombreProducto());
            dto.setPrecioBase(c.getProducto().getPrecioProducto());
            dto.setFechaCreacion(c.getFechaCreaCarritoCompra());
            return dto;
        }).collect(Collectors.toList());
    }
}
