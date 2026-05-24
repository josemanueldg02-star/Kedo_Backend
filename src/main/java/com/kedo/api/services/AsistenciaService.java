package com.kedo.api.services;

//IMPORTS
import com.kedo.api.models.Asistencia;
import com.kedo.api.models.Evento;
import com.kedo.api.models.Usuario;
import com.kedo.api.repositories.AsistenciaRepository;
import com.kedo.api.repositories.EventoRepository;
import com.kedo.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRespository;
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Asistencia confirmarAsistencia(Long eventoId, Long usuarioId) {
        //1. Buscamos el evento y el usuario en la BD (.orElseThrow() lanza el error si no existen).
        Evento evento = eventoRepository.findById(eventoId).orElseThrow();
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow();

        // 2. Creamos el ticket de asistencia y los unimos.
        Asistencia nuevaAsistencia = new Asistencia();
        nuevaAsistencia.setEvento(evento);
        nuevaAsistencia.setUsuario(usuario);

        // 3. Lo guardamos en PostgreSQL
        return asistenciaRespository.save(nuevaAsistencia);
    }
}
