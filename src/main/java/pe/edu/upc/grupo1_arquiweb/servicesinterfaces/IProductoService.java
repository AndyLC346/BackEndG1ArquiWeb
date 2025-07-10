package pe.edu.upc.grupo1_arquiweb.servicesinterfaces;

import pe.edu.upc.grupo1_arquiweb.dtos.CantidadProductosDTO;
import pe.edu.upc.grupo1_arquiweb.entities.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> list();
    public void insert (Producto p);
    public void update(Producto p);
    public void delete (Long id);
    public Producto searchId(Long id);
    public List<Producto> search(String name);
    List<CantidadProductosDTO> qualitybyStore();
    List<Producto> comparar(Long id1, Long id2);
}
