package ejercicio2;


public class Mesa {
    private int idMesa;
    private int capacidad;
    private Pedido pedido;
    private boolean reservado;

    public Mesa(int idMesa, int capacidad) {
        this.idMesa = idMesa;
        this.capacidad = capacidad;
        this.pedido = new Pedido();
    }

    public void reservarMesa(int cantidadLugaresAreservar) {
        if (this.capacidad >= cantidadLugaresAreservar) {
            this.capacidad -= cantidadLugaresAreservar;
            this.reservado = true;
        }

    }

    public boolean estaReservada() {
        return this.reservado;
    }

    public void desocuparMesa() {
        this.reservado = false;
    }

    public void agregarPedido(Pedido unPedido) {
        this.pedido = unPedido;
    }

    public Pedido cobrar() {
        return pedido;
    }
}
