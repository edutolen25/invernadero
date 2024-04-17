package demo.Invernadero.lalo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.example.invernadero.models.Usuarios;
import com.example.invernadero.service.UsuariosService;

@RestController
@RequestMapping("api/controlinvernadero/v1/usuario")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public ResponseEntity<List<Usuarios>> getAllUsuarios() {
        List<Usuarios> usuarios = usuariosService.getAllUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> getUsuarioById(@PathVariable Long id) {
        Optional<Usuarios> usuario = usuariosService.getUsuarioById(id);
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Insertar un nuevo alumno usuarios
    @PostMapping
    public ResponseEntity<Usuarios> saveUsuario(@RequestBody Usuarios usuario) {
        Usuarios saveUsuario = usuariosService.saveUsuario(usuario);
        return new ResponseEntity<>(saveUsuario, HttpStatus.CREATED);
    }

    // Actualizar alumno por ID
    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> updateUsuario(@PathVariable Long id, @RequestBody Usuarios newUsuario) {
        Usuarios updateUsuario = usuariosService.updateUsuario(id, newUsuario);
        return new ResponseEntity<>(updateUsuario, HttpStatus.OK);
    }

    // Eliminar alumno por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuariosService.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
