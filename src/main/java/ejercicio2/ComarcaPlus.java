package ejercicio2;

public class ComarcaPlus extends Tarjeta {
    public ComarcaPlus() {
        super("Visa", 0.02);
    }

    @Override
    public double calcularDescuento(double costoTotal) {
        return costoTotal * 0.03;
    }

    @Override
    public double montoAPagar(Pedido unPedido) {
        double costoTotalPlatos = unPedido.getPrecioPlatos();
        double costoTotalBebidas = unPedido.getPrecioBebidas();

        double costoTotal = costoTotalPlatos + costoTotalBebidas;


        double descuento = calcularDescuento(costoTotal);

        double costoAPagar = costoTotal - descuento;
        costoAPagar = calcularCostoTotalConPropina(costoAPagar);
        return costoAPagar;
    }
}
