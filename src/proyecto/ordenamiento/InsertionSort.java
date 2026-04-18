package proyecto.ordenamiento;

import proyecto.modelo.Paquete;

public class InsertionSort {

    // Método genérico para ordenar por prioridad (de mayor a menor)
    public static <T extends Comparable<T>> void ordenar(Paquete<T>[] arreglo) {

        for (int i = 1; i < arreglo.length; i++) {
            Paquete<T> actual = arreglo[i];
            int j = i - 1;

            // Orden descendente (mayor prioridad primero)
            while (j >= 0 && arreglo[j] != null && arreglo[j].compararPrioridad(actual) < 0) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }

            arreglo[j + 1] = actual;
        }
    }
}