package com.saga.msnotificaciones.controller;

import com.saga.msnotificaciones.model.RegistroNotificacion;
import com.saga.msnotificaciones.repository.NotificacionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    private final NotificacionRepository repository;

    public NotificacionController(NotificacionRepository repository) {
        this.repository = repository;
    }

    // El orquestador llama este endpoint
    @PostMapping("/enviar")
    public ResponseEntity<Map<String, Object>> enviarNotificacion(
            @RequestBody Map<String, Object> request) {

        Long idPedido = Long.valueOf(request.get("idPedido").toString());
        String mensaje = request.getOrDefault("mensaje",
                "Notificacion del pedido #" + idPedido).toString();

        RegistroNotificacion registro = new RegistroNotificacion(idPedido, mensaje);
        repository.save(registro);

        System.out.println("[MS-NOTIFICACIONES] Notificacion guardada para pedido: " + idPedido);

        return ResponseEntity.ok(Map.of(
                "status", "ENVIADA",
                "idPedido", idPedido,
                "mensaje", mensaje
        ));
    }

    // Ver todos los registros (util para el video)
    @GetMapping
    public ResponseEntity<List<RegistroNotificacion>> listar() {
        return ResponseEntity.ok(repository.findAll());
    }
}
