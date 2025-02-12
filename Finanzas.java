import java.util.ArrayList;
import java.util.List;

public class Finanzas {
    List<Transaccion> transacciones = new ArrayList<>();
    double ahorro = 0;

    // Método para registrar una transacción
    public void registrarTransaccion(String tipo, double cantidad) {
        Transaccion transaccion = new Transaccion(tipo, cantidad);
        transacciones.add(transaccion);

        if (tipo.equals("Ingreso")) {
            ahorro += cantidad;
        } else if (tipo.equals("Gasto")) {
            ahorro -= cantidad;
        }
    }

    // Método para calcular el ahorro disponible
    public double calcularAhorroDisponible() {
        return ahorro;
    }
}
