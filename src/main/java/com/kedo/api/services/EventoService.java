package com.kedo.api.services;

//IMPORTS
import com.kedo.api.models.Evento;
import com.kedo.api.models.Usuario;
import com.kedo.api.repositories.EventoRepository;
import com.kedo.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    // Repositorio de Usuario para poder buscar en la base de datos.
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método inteligente para crear un evento con "Auto-Registro"
    public Evento crearEvento(Evento eventoFront) {

        String emailCreador = eventoFront.getCreador().getEmail();

        // Buscamos al usuario. Si no existe, ejecutamos la función orElseGet para crearlo.
        Usuario usuarioReal = usuarioRepository.findByEmail(emailCreador)
                .orElseGet(() -> {
                    Usuario nuevoUsuario = new Usuario();
                    nuevoUsuario.setEmail(emailCreador);
                    nuevoUsuario.setNombre("Empresa Automática");
                    nuevoUsuario.setRol("EMPRESA");
                    nuevoUsuario.setPassword("Auth_Firebase_Generica!");

                    // Lo guardamos en la base de datos local y lo devolvemos
                    return usuarioRepository.save(nuevoUsuario);
                });

        // Le asignamos el usuario real al evento.
        eventoFront.setCreador(usuarioReal);

        // Guardamos el evento
        return eventoRepository.save(eventoFront);
    }

    // Método para pedir todos los eventos y ponerlos en el mapa.
    public List<Evento> obtenerTodos() {
        return eventoRepository.findAll();
    }

    // Método para eliminar un evento por su ID.
    public void eliminarEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}
