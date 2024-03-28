package ejercicio2;

class Visa extends Tarjeta {
    public Visa() {
        super("Visa", 0.03);
    }

    @Override
    public double calcularDescuento(double costoTotal) {
        // Visa ofrece un descuento del 3% sobre el costo total de las bebidas
        return costoTotal * 0.03;
    }

    @Override
    public double montoAPagar(Pedido unPedido) {
        double costoTotalPlatos = unPedido.getPrecioPlatos();
        double costoTotalBebidas = unPedido.getPrecioBebidas();

        // Aplicar descuento del 3% sobre el costo total de las bebidas
        double descuentoBebidas = calcularDescuento(costoTotalBebidas);

        // Calcular el costo total a pagar restando el descuento de las bebidas
        double costoAPagar = costoTotalPlatos + (costoTotalBebidas - descuentoBebidas);
        costoAPagar = calcularCostoTotalConPropina(costoAPagar);
        return costoAPagar;

    }

}
