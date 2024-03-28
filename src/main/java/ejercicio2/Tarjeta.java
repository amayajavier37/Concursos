package ejercicio2;

public abstract class Tarjeta {
    private String numeroTarjeta;

    public Tarjeta(String nombre, double descuento) {
        this.numeroTarjeta = numeroTarjeta;

    }

    // Método abstracto para calcular el descuento
    public abstract double calcularDescuento(double costoTotal);

    public abstract double montoAPagar(Pedido unPedido);

    public double calcularCostoTotalConPropina(double costoTotalComida) {
        double propina = calcularPropina(costoTotalComida);
        return costoTotalComida + propina;
    }

    private double calcularPropina(double costoTotalComida) {
        if (costoTotalComida <= 0) {
            return 0.0;
        } else if (costoTotalComida <= 2000) {
            return costoTotalComida * 0.02;
        } else if (costoTotalComida <= 3000) {
            return costoTotalComida * 0.03;
        } else {
            return costoTotalComida * 0.05;
        }
    }

}

