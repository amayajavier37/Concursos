package ejercicio2;

class Visa extends Tarjeta {
    public Visa() {
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


        double descuentoBebidas = calcularDescuento(costoTotalBebidas);


        double costoAPagar = costoTotalPlatos + (costoTotalBebidas - descuentoBebidas);
        costoAPagar = calcularCostoTotalConPropina(costoAPagar);
        return costoAPagar;

    }

}
