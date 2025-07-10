package pe.edu.upc.grupo1_arquiweb.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.grupo1_arquiweb.dtos.CantidadProductosDTO;
import pe.edu.upc.grupo1_arquiweb.entities.Producto;
import pe.edu.upc.grupo1_arquiweb.repositories.IProductoRepository;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.IProductoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImplement implements IProductoService {

    @Autowired
    private IProductoRepository pR;

    @Override
    public List<Producto> list() {
        return pR.findAll();
    }

    @Override
    public void insert(Producto p) {
        pR.save(p);
    }

    @Override
    public void update(Producto p) {
        pR.save(p);
    }

    @Override
    public void delete(Long id) {
        pR.deleteById(id);
    }

    @Override
    public Producto searchId(Long id) {
        return pR.findById(id).orElse(new Producto());
    }

    @Override
    public List<Producto> search(String name) {
        return pR.buscar(name);
    }

    @Override
    public List<CantidadProductosDTO> qualitybyStore() {
        return pR.cantidadProductosPorTienda().stream()
                .map(arr -> new CantidadProductosDTO(
                        (String) arr[0],
                        ((Number) arr[1]).intValue()))
                .collect(Collectors.toList());

    }

    @Override
    public List<Producto> comparar(Long id1, Long id2) {
        return pR.compararProductos(id1, id2);
    }
}
