package ejercicio1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FakeProveedorFecha implements ProveedorFecha {
    @Override
    public LocalDateTime fecha() {
        return LocalDateTime.of(2024, 4, 5, 2, 44, 12);
    }

    @Override
    public String formatearFecha(LocalDateTime fecha) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.format(formato);
    }
}

