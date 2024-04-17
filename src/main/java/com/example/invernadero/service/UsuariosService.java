package demo.Invernadero.lalo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.invernadero.models.Usuarios;
import com.example.invernadero.repository.UsuariosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    public Optional<Usuarios> getUsuarioById(Long id) {
        return usuariosRepository.findById(id);
    }

    public Usuarios saveUsuario(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    public Usuarios updateUsuario(Long id, Usuarios newUsuarios) {
        return usuariosRepository.findById(id)
                .map(usuario -> {
                    usuario.setNombre(newUsuarios.getNombre());
                    usuario.setApellido_paterno(newUsuarios.getApellido_paterno());
                    usuario.setApellido_materno(newUsuarios.getApellido_materno());
                    usuario.setTipo(newUsuarios.getTipo());
                    return usuariosRepository.save(usuario);
                })
                .orElse(null);
    }

    public void deleteUsuario(Long id) {
        usuariosRepository.deleteById(id);
    }
}
