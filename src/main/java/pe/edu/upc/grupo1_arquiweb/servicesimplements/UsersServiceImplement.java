package pe.edu.upc.grupo1_arquiweb.servicesimplements;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.grupo1_arquiweb.entities.Users;
import pe.edu.upc.grupo1_arquiweb.repositories.IUsersRepository;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.IUsersService;

import java.util.List;

@Service
public class UsersServiceImplement implements IUsersService {
    @Autowired
    private IUsersRepository uR;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Users u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        uR.save(u);
    }

    @Override
    public void update(Users u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        uR.save(u);
    }


    @Override
    public void delete(Long id) {
        uR.deleteById(id);
    }

    @Override
    public Users searchId(Long id) {
        return uR.findById(id).orElse(new Users());
    }
}
