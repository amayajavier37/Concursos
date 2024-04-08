package ejercicio1;

import org.junit.jupiter.api.Test;
import persistenciaEj1.EnDiscoRegistroInscripcion;
import persistenciaEj1.EnMailRegistroInscripcion;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestConcurso {

    @Test
    public void inscripcionEnTermino() {
        Participante participante1 = new Participante("Ale", 12345);
        Participante participante2 = new Participante("Javier", 54321);

        Concurso concurso1 = new Concurso(LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(4), "10KH",
                new EnDiscoRegistroInscripcion("C:\\Users\\amaya\\IdeaProjects\\Concursos\\src\\main\\resources\\prueba.txt"),
                new FakeProveedorFecha());
        concurso1.inscribir(participante1, LocalDate.now().minusDays(1));
        concurso1.inscribir(participante2, LocalDate.now().plusDays(1));

        assertTrue(concurso1.estaInscripto(participante1));
        assertTrue(concurso1.estaInscripto(participante2));
    }

    @Test
    public void incripcionFueraDeTermino() {
        Participante participante1 = new Participante("Javier", 12345);
        Concurso concurso1 = new Concurso(LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(4), "10KH",
                new EnDiscoRegistroInscripcion("C:\\Users\\amaya\\IdeaProjects\\Concursos\\src\\main\\resources\\prueba.txt"),
                new FakeProveedorFecha());

        try {
            concurso1.inscribir(participante1, LocalDate.now().plusDays(6));
        } catch (RuntimeException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void participanteInscripto() {
        Participante participante1 = new Participante("Javier", 12345);
        Concurso concurso1 = new Concurso(LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(4), "10KH",
                new EnDiscoRegistroInscripcion("C:\\Users\\amaya\\IdeaProjects\\Concursos\\src\\main\\resources\\prueba.txt"),
                new FakeProveedorFecha());
        concurso1.inscribir(participante1, LocalDate.now());

        assertTrue(concurso1.estaInscripto(participante1));
    }

    @Test
    public void inscripcionEnMemoria() {
        var fakeRegistro = new FakeRegistroInscripcion();
        Concurso concurso = new Concurso(LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(5), "Concurso", fakeRegistro,
                new FakeProveedorFecha());
        Participante participante = new Participante("Agustin", 21445);

        concurso.inscribir(participante, LocalDate.now());
        String str = "05/04/2024, Agustin, Concurso";

        assertTrue(fakeRegistro.comienzaCon(str));
    }

    //Envia el mail, falta hacer el fake de envio
    @Test
    public void mensajeEmail() {
        var registro = new EnMailRegistroInscripcion();
        Concurso concurso = new Concurso(LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(5), "Concurso", registro,
                new FakeProveedorFecha());
        Participante participante = new Participante("Agustin", 21445);
        Participante participante1 = new Participante("Javier", 21445);
        Participante participante2 = new Participante("Amaya", 21445);
        concurso.inscribir(participante, LocalDate.now());
        concurso.inscribir(participante1, LocalDate.now());
        concurso.inscribir(participante2, LocalDate.now());

        registro.envioDeMail();

        assertTrue(concurso.estaInscripto(participante1));
    }


}

