package ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {
    ProveedorFecha proveedorFecha;
    private LocalDate fechaInicio;
    private LocalDate fechaCierre;
    private String nombre;
    private ArrayList<Participante> inscriptos;
    private RegistroInscripcion registro;

    public Concurso(LocalDate inicio, LocalDate fin, String nombre,
                    RegistroInscripcion registro, ProveedorFecha fecha) {
        this.fechaCierre = fin;
        this.fechaInicio = inicio;
        this.nombre = nombre;
        this.inscriptos = new ArrayList<Participante>();
        this.registro = registro;
        this.proveedorFecha = fecha;
    }

    public void inscribir(Participante unParticipante, LocalDate fechaInscripcion) {
        if (estaInscripto(unParticipante)) {
            throw new RuntimeException("El participante ya está inscripto");
        }
        if (fechaInscripcion.isAfter(this.fechaCierre)) {
            throw new RuntimeException("La inscripción al concurso ha finalizado");
        }
        this.inscriptos.add(unParticipante);
        ganaPuntosExtras(unParticipante, fechaInscripcion);


        String fecha = this.proveedorFecha.formatearFecha(this.proveedorFecha.fecha());
        String nombreYFecha = fecha + ", " + unParticipante.getNombre() + ", " + this.nombre + "\n";
        this.registro.registrar(nombreYFecha);
    }

    public void ganaPuntosExtras(Participante unParticipante, LocalDate fechaInscripcion) {
        if (!fechaInscripcion.isEqual(this.fechaInicio)) {
            return;
        }
        unParticipante.SumarPuntaje(10);
    }

    public boolean estaInscripto(Participante unParticipante) {
        return this.inscriptos.contains(unParticipante);
    }

}
