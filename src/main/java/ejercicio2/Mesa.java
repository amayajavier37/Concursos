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

//    public double calcularCostoTotalConPropina(double costoTotalComida) {
//        double propina = calcularPropina(costoTotalComida);
//        return costoTotalComida + propina;
//    }
//
//    private double calcularPropina(double costoTotalComida) {
//        if (costoTotalComida <= 0) {
//            return 0.0;
//        } else if (costoTotalComida <= 1000) {
//            return costoTotalComida * 0.02;
//        } else if (costoTotalComida <= 2000) {
//            return costoTotalComida * 0.03;
//        } else {
//            return costoTotalComida * 0.05;
//        }
//    }


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
