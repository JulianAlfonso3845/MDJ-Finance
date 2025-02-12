public class Transaccion {
    String tipo; // Puede ser "Ingreso" o "Gasto"
    double cantidad;

    public Transaccion(String tipo, double cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }
}
