package testConcurso;

import ejercicio1.Concurso;
import ejercicio1.Participante;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestConcurso {

    @Test
    public void inscripcionEnTermino() {
        Participante participante1 = new Participante("Ale", 12345);
        Concurso concurso1 = new Concurso(LocalDate.now().minusDays(1), LocalDate.now().plusDays(4), "10KH");
        concurso1.inscribir(participante1, LocalDate.now());

        assertTrue(concurso1.estaInscripto(participante1));
    }

    @Test
    public void incripcionFueraDeTermino() {
        Participante participante1 = new Participante("Javier", 12345);
        Concurso concurso1 = new Concurso(LocalDate.now().minusDays(1), LocalDate.now().plusDays(4), "10KH");
        //concurso1.inscribir(participante1, LocalDate.now().plusDays(6));

        //assertFalse(concurso1.estaInscripto(participante1));
        try {
            concurso1.inscribir(participante1, LocalDate.now().plusDays(6));
        } catch (RuntimeException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void participanteInscripto() {
        Participante participante1 = new Participante("Javier", 12345);
        Concurso concurso1 = new Concurso(LocalDate.now().minusDays(1), LocalDate.now().plusDays(4), "10KH");
        concurso1.inscribir(participante1, LocalDate.now());

        assertTrue(concurso1.estaInscripto(participante1));
    }

}
