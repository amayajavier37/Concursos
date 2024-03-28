package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Plato> platos;
    private List<Bebida> bebidas;
    private boolean confirmado;

    public Pedido() {
        this.platos = new ArrayList<>();
        this.bebidas = new ArrayList<>();
        this.confirmado = false;
    }

    public void agregarplato(Plato plato) {
        platos.add(plato);
    }

    public void agregarBebida(Bebida bebida) {
        bebidas.add(bebida);
    }

    public double getPrecioPlatos() {
        double costoTotal = 0.0;
        for (Plato plato : platos) {
            costoTotal += plato.getPrecio();
        }
        return costoTotal;
    }

    public double getPrecioBebidas() {
        double costoTotal = 0.0;
        for (Bebida bebida : bebidas) {
            costoTotal += bebida.getPrecio();
        }
        return costoTotal;
    }

    public void confirmarPedido() {
        confirmado = true;
    }


}
