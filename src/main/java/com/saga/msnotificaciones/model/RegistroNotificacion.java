package com.saga.msnotificaciones.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "registro_notificaciones")
@Data
@NoArgsConstructor
public class RegistroNotificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_pedido", nullable = false)
    private Long idPedido;

    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private LocalDateTime fecha;

    public RegistroNotificacion(Long idPedido, String mensaje) {
        this.idPedido = idPedido;
        this.mensaje = mensaje;
        this.fecha = LocalDateTime.now();
    }
}