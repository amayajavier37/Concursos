package ejercicio1;

import java.time.LocalDateTime;

public interface ProveedorFecha {
    LocalDateTime fecha();

    String formatearFecha(LocalDateTime fecha);
}
