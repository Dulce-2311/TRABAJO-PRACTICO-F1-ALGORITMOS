package proyecto.ordenamiento;

import proyecto.modelo.Paquete;

public class QuickSort {

    public static <T extends Comparable<T>> void ordenar(Paquete<T>[] arreglo) {
        quickSort(arreglo, 0, arreglo.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(Paquete<T>[] arr, int low, int high) {
        if (low < high) {
            int pi = particion(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> int particion(Paquete<T>[] arr, int low, int high) {
        Paquete<T> pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] != null && pivot != null &&
                arr[j].compararPrioridad(pivot) > 0) {

                i++;
                Paquete<T> temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Paquete<T> temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}