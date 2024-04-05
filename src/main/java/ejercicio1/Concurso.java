package ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {
    private LocalDate fechaInicio;
    private LocalDate fechaCierre;
    private String nombre;
    private ArrayList<Participante> inscriptos;

    public Concurso(LocalDate inicio, LocalDate fin, String nombre) {
        this.fechaCierre = fin;
        this.fechaInicio = inicio;
        this.nombre = nombre;
        this.inscriptos = new ArrayList<Participante>();

    }

    public void inscribir(Participante unParticipante, LocalDate fechaInscripcion) {
        if (fechaInscripcion.isBefore(this.fechaCierre)) {
            if (!estaInscripto(unParticipante)) {
                this.inscriptos.add(unParticipante);
                ganaPuntosExtras(unParticipante, fechaInscripcion);
            } else {
                throw new RuntimeException("El participante ya está inscripto");
            }
        } else {
            throw new RuntimeException("La inscripcion al concurso finalizo");
        }
    }

    public void ganaPuntosExtras(Participante unParticipante, LocalDate fechaInscripcion) {
        if (fechaInscripcion.isEqual(this.fechaInicio) || fechaInscripcion.isAfter(this.fechaInicio)) {
            unParticipante.SumarPuntaje(10);
        }
    }

    public boolean estaInscripto(Participante unParticipante) {
        return this.inscriptos.contains(unParticipante);
    }

}
