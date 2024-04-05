package persistenciaEj1;

import ejercicio1.RegistroInscripcion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class EnDiscoRegistroInscripcion implements RegistroInscripcion {
    private String ruta;

    public EnDiscoRegistroInscripcion(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public void registrar(String registro) {
        try {
            Files.write(Paths.get(ruta),
                    registro.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo persistir...", e);
        }
    }
}
