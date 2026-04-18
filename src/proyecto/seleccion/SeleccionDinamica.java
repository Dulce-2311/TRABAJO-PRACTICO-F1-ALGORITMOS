package proyecto.seleccion;

import java.util.ArrayList;
import java.util.List;
import proyecto.modelo.Paquete;

public class SeleccionDinamica {

    public List<Paquete<?>> seleccionar(List<Paquete<?>> paquetes, int capacidad) {

        int n = paquetes.size();

        // Tabla DP
        int[][] dp = new int[n + 1][capacidad + 1];

        // Construcción de la tabla
        for (int i = 1; i <= n; i++) {
            Paquete<?> p = paquetes.get(i - 1);

            for (int w = 0; w <= capacidad; w++) {

                if (p.getPeso() <= w) {
                    dp[i][w] = Math.max(
                            dp[i - 1][w],
                            dp[i - 1][w - (int) p.getPeso()] + p.getValorizacion()
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Reconstruir solución
        List<Paquete<?>> seleccion = new ArrayList<>();
        int w = capacidad;

        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                Paquete<?> p = paquetes.get(i - 1);
                seleccion.add(p);
                w -= (int) p.getPeso();
            }
        }

        return seleccion;
    }
}