package com.kedo.api.controllers;

import com.kedo.api.models.Asistencia;
import com.kedo.api.models.Evento;
import com.kedo.api.services.AsistenciaService;
import com.kedo.api.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private AsistenciaService asistenciaService;

    @PostMapping
    public Evento crearEvento(@RequestBody Evento evento) {
        return eventoService.crearEvento(evento);
    }

    @GetMapping
    public List<Evento> listarEventos() {
        return eventoService.obtenerTodos();
    }

    // Endpoint para borrar un evento
    @DeleteMapping("/{id}")
    public void eliminarEvento(@PathVariable Long id) {
        eventoService.eliminarEvento(id);
    }

    // NUEVO ENDPOINT: Simula cuando el usuario le da al botón "Asistir"
    // URL de ejemplo: http://localhost:8081/api/eventos/1/asistir/1
    @PostMapping("/{eventoId}/asistir/{usuarioId}")
    public Asistencia asistirAEvento(@PathVariable Long eventoId, @PathVariable Long usuarioId) {
        // Nota: Usamos la URL para pasar el ID del usuario porque aún no he
        // metido seguridad JWT. Cuando meta Spring Security, el ID del usuario irá encriptado en un token.
        return asistenciaService.confirmarAsistencia(eventoId, usuarioId);
    }
}