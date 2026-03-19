package com.saga.msnotificaciones.repository;

import com.saga.msnotificaciones.model.RegistroNotificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotificacionRepository extends JpaRepository<RegistroNotificacion, Long> {
    List<RegistroNotificacion> findByIdPedido(Long idPedido);
}
