package pe.edu.upc.grupo1_arquiweb.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.grupo1_arquiweb.entities.Resena;
import pe.edu.upc.grupo1_arquiweb.repositories.IResenaRepository;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.IResenaService;

import java.util.List;

@Service
public class ResenaServiceImplement implements IResenaService {

    @Autowired
    private IResenaRepository rR;

    @Override
    public List<Resena> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Resena r) {
        rR.save(r);
    }

    @Override
    public void update(Resena r) {
        rR.save(r);
    }

    @Override
    public void delete(Long id) {
        rR.deleteById(id);
    }

    @Override
    public Resena searchId(Long id) {
        return rR.findById(id).orElse(new Resena());
    }

    @Override
    public List<Resena> searchrating(double valor) {
        return rR.buscarPorCalificacion(valor);
    }

    @Override
    public List<Resena> listReviewsRating() {
        return rR.listarResenasCalificacion();
    }
}
