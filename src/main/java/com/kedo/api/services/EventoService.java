package com.kedo.api.services;

//IMPORTS
import com.kedo.api.models.Evento;
import com.kedo.api.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    // Método para crear un evento
    public Evento crearEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    // Método para pedir todos los eventos y pintarlos en el mapa.
    public List<Evento> obtenerTodos() {
        return eventoRepository.findAll();
    }
}
