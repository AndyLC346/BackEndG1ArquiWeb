package pe.edu.upc.grupo1_arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.grupo1_arquiweb.dtos.DescuentoDTO;
import pe.edu.upc.grupo1_arquiweb.dtos.ListaDescuentoVigenteDTO;
import pe.edu.upc.grupo1_arquiweb.dtos.ListarDescuentosOrdenadosPorPorcentajeDTO;
import pe.edu.upc.grupo1_arquiweb.entities.Descuento;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.IDescuentoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/descuentos")
public class DescuentoController {

    @Autowired
    private IDescuentoService dS;

    @GetMapping
    public List<DescuentoDTO> listar() {
        return dS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DescuentoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody DescuentoDTO dto) {
        ModelMapper m = new ModelMapper();
        Descuento d = m.map(dto, Descuento.class);
        dS.insert(d);
    }

    @PutMapping
    public void modificar(@RequestBody DescuentoDTO dto) {
        ModelMapper m = new ModelMapper();
        Descuento d = m.map(dto, Descuento.class);
        dS.update(d);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        dS.delete(id);
    }

    @GetMapping("/{id}")
    public DescuentoDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        DescuentoDTO dto = m.map(dS.searchId(id), DescuentoDTO.class);
        return dto;
    }

    @GetMapping("/listarDescVigente")
    public List<ListaDescuentoVigenteDTO> listardescuentvigentes() {
        List<Object[]> filaLista = dS.listarDescuentosVigentes();
        List<ListaDescuentoVigenteDTO> dtoLista = new ArrayList<>();

        for (Object[] columna : filaLista) {
            ListaDescuentoVigenteDTO dto = new ListaDescuentoVigenteDTO();
            dto.setIdDescuento(((Number) columna[0]).longValue());
            dto.setCodigoDescuento((String) columna[1]);
            dto.setPorcentajeDescuento(((Number) columna[2]).doubleValue());
            dto.setFechaInicioDescuento(((java.sql.Date) columna[3]).toLocalDate());
            dto.setFechaFinDescuento(((java.sql.Date) columna[4]).toLocalDate());
            dtoLista.add(dto);
        }

        return dtoLista;
    }

    @GetMapping("/ListarDescuentosOrdenadosXPorcentaje")
    public List<ListarDescuentosOrdenadosPorPorcentajeDTO> listarDescuentosOrdenadosPorPorcentaje() {
        List<Descuento> listaDescuentos = dS.obtenerDescuentosOrdenados();
        List<ListarDescuentosOrdenadosPorPorcentajeDTO> dtoLista = new ArrayList<>();

        for (Descuento d : listaDescuentos) {
            ListarDescuentosOrdenadosPorPorcentajeDTO dto = new ListarDescuentosOrdenadosPorPorcentajeDTO();
            dto.setIdDescuento(d.getIdDescuento());
            dto.setCodigoDescuento(d.getCodigoDescuento());
            dto.setPorcentajeDescuento(d.getPorcentajeDescuento());
            dto.setFechaInicioDescuento(d.getFechaInicioDescuento());
            dto.setFechaFinDescuento(d.getFechaFinDescuento());
            dto.setIdProducto(d.getProducto().getIdProducto());
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
