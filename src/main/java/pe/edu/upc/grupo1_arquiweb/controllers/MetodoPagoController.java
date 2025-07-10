package pe.edu.upc.grupo1_arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.grupo1_arquiweb.dtos.CantidadMetodoPagoDTO;
import pe.edu.upc.grupo1_arquiweb.dtos.MetodoPagoDTO;
import pe.edu.upc.grupo1_arquiweb.entities.MetodoPago;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.IMetodoPagoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/metodosdepago")
public class MetodoPagoController {

    @Autowired
    private IMetodoPagoService mpS;

    @GetMapping
    public List<MetodoPagoDTO> listar() {
        return mpS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MetodoPagoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody MetodoPagoDTO dto) {
        ModelMapper m = new ModelMapper();
        MetodoPago mp= m.map(dto, MetodoPago.class);
        mpS.insert(mp);
    }

    @PutMapping
    public void modificar(@RequestBody MetodoPagoDTO dto) {
        ModelMapper m = new ModelMapper();
        MetodoPago mp = m.map(dto, MetodoPago.class);
        mpS.update(mp);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        mpS.delete(id);
    }

    @GetMapping("/{id}")
    public MetodoPagoDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        MetodoPagoDTO dto = m.map(mpS.searchId(id), MetodoPagoDTO.class);
        return dto;
    }

    @GetMapping("/buscarportipo")
    public List<MetodoPagoDTO> buscarPorTipo(@RequestParam("valor") String valor) {
        return mpS.searchByTipo(valor)
                .stream()
                .map(m -> new ModelMapper().map(m, MetodoPagoDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/cantidadportipo")
    public List<CantidadMetodoPagoDTO> obtenerCantidadPorTipo() {
        List<String[]> filas = mpS.contarMetodosPorTipo();
        List<CantidadMetodoPagoDTO> lista = new ArrayList<>();

        for (String[] fila : filas) {
            CantidadMetodoPagoDTO dto = new CantidadMetodoPagoDTO();
            dto.setTipo(fila[0]);
            dto.setCantidad(Integer.parseInt(fila[1]));
            lista.add(dto);
        }
        return lista;
    }
}
