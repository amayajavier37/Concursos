package ejercicio2;

public class MasterCard extends Tarjeta {
    public MasterCard() {
        super("Visa", 0.03);
    }

    @Override
    public double calcularDescuento(double costoTotal) {
        return costoTotal * 0.03;
    }

    @Override
    public double montoAPagar(Pedido unPedido) {
        double costoTotalPlatos = unPedido.getPrecioPlatos();
        double costoTotalBebidas = unPedido.getPrecioBebidas();

        double descuentoPlatos = calcularDescuento(costoTotalPlatos);

        double costoAPagar = costoTotalBebidas + (costoTotalPlatos - descuentoPlatos);
        costoAPagar = calcularCostoTotalConPropina(costoAPagar);
        return costoAPagar;
    }

}
