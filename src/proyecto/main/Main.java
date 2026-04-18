package proyecto.main;

import proyecto.lectura.LectorArchivo;
import proyecto.modelo.GestorZonas;
import proyecto.modelo.Paquete;
import proyecto.ordenamiento.InsertionSort;
import proyecto.ordenamiento.QuickSort;
import proyecto.seleccion.SeleccionRecursiva;
import proyecto.seleccion.SeleccionDinamica;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1. Leer archivo
        LectorArchivo lector = new LectorArchivo();
        lector.leerArchivo("datos.txt"); // asegúrate de tener este archivo

        int capacidad = lector.getCapacidad();
        int zonas = lector.getZonas();
        int paquetesPorZona = lector.getPaquetesPorZona();

        List<Paquete<String>> lista = lector.getListaPaquetes();

        // 2. Crear matriz
        GestorZonas<String> gestor = new GestorZonas<>(zonas, paquetesPorZona);
        gestor.cargarPaquetes(lista);

        System.out.println("=== MATRIZ ORIGINAL ===");
        gestor.mostrarMatriz();

        // 3. Ordenamiento (InsertionSort)
        System.out.println("=== ORDENADO CON INSERTION SORT ===");
        Paquete<String>[][] matriz = gestor.getMatriz();

        for (int i = 0; i < matriz.length; i++) {
            InsertionSort.ordenar(matriz[i]);
        }

        gestor.mostrarMatriz();

        // 4. Ordenamiento (QuickSort)
        System.out.println("=== ORDENADO CON QUICK SORT ===");

        for (int i = 0; i < matriz.length; i++) {
            QuickSort.ordenar(matriz[i]);
        }

        gestor.mostrarMatriz();

        // 5. Selección Recursiva
        System.out.println("=== SELECCION RECURSIVA ===");

        SeleccionRecursiva selRec = new SeleccionRecursiva();
        List<Paquete<?>> seleccionRec = selRec.seleccionar((List) lista, capacidad);

        for (Paquete<?> p : seleccionRec) {
            System.out.println(p);
        }

        // 6. Selección Dinámica
        System.out.println("=== SELECCION DINAMICA ===");

        SeleccionDinamica selDyn = new SeleccionDinamica();
        List<Paquete<?>> seleccionDyn = selDyn.seleccionar((List) lista, capacidad);

        for (Paquete<?> p : seleccionDyn) {
            System.out.println(p);
        }
    }
}
