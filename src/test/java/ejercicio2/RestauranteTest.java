package ejercicio2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestauranteTest {
    @Test
    public void testReservaMesa() {
        Mesa mesa = new Mesa(1, 5);
        mesa.reservarMesa(5);

        assertTrue(mesa.estaReservada());
    }

    @Test
    public void testDesocuparMesa() {
        Mesa mesa = new Mesa(1, 5);
        mesa.reservarMesa(5);
        mesa.desocuparMesa();

        assertFalse(mesa.estaReservada());
    }

    @Test
    public void testPagoTarjetaVisa() {
        Plato plato = new Plato("Milanesa", 1500);
        Plato plato2 = new Plato("Pure de Papas", 3500);
        Bebida bebida3 = new Bebida("Vino", 2500);
        Mesa mesa1 = new Mesa(1, 10);


        Pedido pedido1 = new Pedido();
        pedido1.agregarplato(plato);
        pedido1.agregarplato(plato2);
        pedido1.agregarBebida(bebida3);
        pedido1.confirmarPedido();
        mesa1.agregarPedido(pedido1);
        var visa = new Visa();

        assertEquals(7796.25, visa.montoAPagar(mesa1.cobrar()));
    }

    @Test
    public void testPagoTarjetaMastercard() {
        Mesa mesa2 = new Mesa(2, 8);
        Plato plato3 = new Plato("Asado", 5500);
        Bebida bebida1 = new Bebida("Agua saborizada", 1000);
        Bebida bebida2 = new Bebida("Gaseosa", 1500);

        Pedido pedido1 = new Pedido();
        pedido1.agregarplato(plato3);
        pedido1.agregarBebida(bebida1);
        pedido1.agregarBebida(bebida2);
        pedido1.confirmarPedido();
        mesa2.agregarPedido(pedido1);

        var master = new MasterCard();
        assertEquals(8226.75, master.montoAPagar(mesa2.cobrar()));


    }

    @Test
    public void testPagoTarjetaComarca() {
        Mesa mesa2 = new Mesa(2, 8);
        Plato plato3 = new Plato("Asado", 5500);
        Bebida bebida1 = new Bebida("Agua saborizada", 1000);
        Bebida bebida2 = new Bebida("Gaseosa", 1500);

        Pedido pedido1 = new Pedido();
        pedido1.agregarplato(plato3);
        pedido1.agregarBebida(bebida1);
        pedido1.agregarBebida(bebida2);
        pedido1.confirmarPedido();
        mesa2.agregarPedido(pedido1);

        var comarca = new ComarcaPlus();
        comarca.montoAPagar(mesa2.cobrar());

        assertEquals(8148.0, comarca.montoAPagar(mesa2.cobrar()));
    }

    @Test
    public void testPagoTarjetaViedma() {
        Mesa mesa2 = new Mesa(2, 8);
        Plato plato3 = new Plato("Asado", 5500);
        Bebida bebida1 = new Bebida("Agua saborizada", 1000);
        Bebida bebida2 = new Bebida("Gaseosa", 1500);

        Pedido pedido1 = new Pedido();
        pedido1.agregarplato(plato3);
        pedido1.agregarBebida(bebida1);
        pedido1.agregarBebida(bebida2);
        pedido1.confirmarPedido();
        mesa2.agregarPedido(pedido1);

        var tarjetaComun = new TarjetaViedma();

        assertEquals(8400, tarjetaComun.montoAPagar(mesa2.cobrar()));
    }
}