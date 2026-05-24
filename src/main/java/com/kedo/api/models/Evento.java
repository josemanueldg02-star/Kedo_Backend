package com.kedo.api.models;

//IMPORTS
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    // Coordenadas para posicionar el pin en Google Maps
    @Column(nullable = false)
    private Double latitud;

    @Column(nullable = false)
    private Double longitud;

    @Column(name = "fecha_evento", nullable = false)
    private LocalDateTime fechaEvento;

    //ManyToOne
    @ManyToOne
    @JoinColumn(name = "creador_id", nullable = false)
    private Usuario creador;
}
