package ejercicio2;

class TarjetaViedma extends Tarjeta {
    public TarjetaViedma() {
        super("TarjetaViedma", 0.0);
    }

    @Override
    public double calcularDescuento(double costoTotal) {
        return 0;
    }

    @Override
    public double montoAPagar(Pedido unPedido) {
        double costoTotalPlatos = unPedido.getPrecioPlatos();
        double costoTotalBebidas = unPedido.getPrecioBebidas() + calcularDescuento(0);

        double costoAPagar = costoTotalPlatos + costoTotalBebidas;
        costoAPagar = calcularCostoTotalConPropina(costoAPagar);
        return costoAPagar;
    }
}
