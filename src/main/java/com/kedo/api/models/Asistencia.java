package com.kedo.api.models;

//IMPORTS
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "asistencias")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación hacia el Usuario que asiste.
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Relación hacia el Evento al que quiere ir
    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    // Guardamos cuándo le dio al botón de "Asistir"
    @Column(name = "fecha_confirmacion", updatable = false)
    private LocalDateTime fechaConfirmacion = LocalDateTime.now();
}
