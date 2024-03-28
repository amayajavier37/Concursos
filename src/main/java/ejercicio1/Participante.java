package ejercicio1;

import java.util.Objects;

public class Participante {
    private String nombre;
    private int dni;
    private int puntaje;

    public Participante(String nombre, int dni) {
        this.puntaje = 0;
        this.dni = dni;
    }

    public void SumarPuntaje(int puntos) {
        this.puntaje += puntos;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return dni == that.dni && Objects.equals(nombre, that.nombre);
    }

}
