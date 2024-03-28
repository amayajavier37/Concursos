package ejercicio2;

public class ComarcaPlus extends Tarjeta {
    public ComarcaPlus() {
        super("Visa", 0.02);
    }

    @Override
    public double calcularDescuento(double costoTotal) {
        // Master ofrece un descuento del 3% sobre el costo total de los platos
        return costoTotal * 0.03;
    }

    @Override
    public double montoAPagar(Pedido unPedido) {
        double costoTotalPlatos = unPedido.getPrecioPlatos();
        double costoTotalBebidas = unPedido.getPrecioBebidas();

        // Sumar el costo total de platos y bebidas
        double costoTotal = costoTotalPlatos + costoTotalBebidas;

        // Aplicar descuento del 2% sobre el costo total (bebidas + platos principales) para tarjeta Comarca Plus
        double descuento = calcularDescuento(costoTotal);

        // Calcular el costo total a pagar restando el descuento
        double costoAPagar = costoTotal - descuento;
        costoAPagar = calcularCostoTotalConPropina(costoAPagar);
        return costoAPagar;
    }
}
