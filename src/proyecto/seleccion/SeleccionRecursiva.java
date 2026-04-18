package proyecto.seleccion;

import java.util.ArrayList;
import java.util.List;
import proyecto.modelo.Paquete;

public class SeleccionRecursiva {

    private int mejorValor = 0;
    private List<Paquete<?>> mejorSeleccion = new ArrayList<>();

    public List<Paquete<?>> seleccionar(List<Paquete<?>> paquetes, int capacidad) {
        backtracking(paquetes, 0, capacidad, 0, new ArrayList<>());
        return mejorSeleccion;
    }

    private void backtracking(List<Paquete<?>> paquetes, int index, int capacidadRestante,
                             int valorActual, List<Paquete<?>> seleccionActual) {

        // Caso base
        if (index == paquetes.size()) {
            if (valorActual > mejorValor) {
                mejorValor = valorActual;
                mejorSeleccion = new ArrayList<>(seleccionActual);
            }
            return;
        }

        Paquete<?> actual = paquetes.get(index);

        // Opción 1: NO tomar el paquete
        backtracking(paquetes, index + 1, capacidadRestante, valorActual, seleccionActual);

        // Opción 2: tomar el paquete (si cabe)
        if (actual.getPeso() <= capacidadRestante) {
            seleccionActual.add(actual);

            backtracking(
                    paquetes,
                    index + 1,
                    capacidadRestante - (int) actual.getPeso(),
                    valorActual + actual.getValorizacion(),
                    seleccionActual
            );

            // backtracking (deshacer)
            seleccionActual.remove(seleccionActual.size() - 1);
        }
    }
}
