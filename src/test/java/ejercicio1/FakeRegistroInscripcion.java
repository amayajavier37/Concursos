package ejercicio1;

public class FakeRegistroInscripcion implements RegistroInscripcion {
    private String contenido;

    @Override
    public void registrar(String registro) {
        this.contenido = registro;
    }

    public boolean comienzaCon(String comienza) {
        return this.contenido.startsWith(comienza);
    }

    public String getContenido() {
        return contenido;
    }
}
