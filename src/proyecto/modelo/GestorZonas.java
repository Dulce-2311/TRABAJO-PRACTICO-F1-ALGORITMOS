package proyecto.modelo;

import java.util.List;

public class GestorZonas {
    private Paquete<T>[][] matriz;
    private int zonas;
    private int paquetesPorZona;

    public GestorZonas(int zonas, int paquetesPorZona) {
        this.zonas = zonas;
        this.paquetesPorZona = paquetesPorZona;
        matriz = new Paquete[zonas][paquetesPorZona];
    }
    public void cargarPaquetes(List<Paquete<T>> lista) {
        int[] contador = new int[zonas];

        for (Paquete<T> p : lista) {
            int zona = p.getZona() - 1;

            if (contador[zona] < paquetesPorZona) {
                matriz[zona][contador[zona]] = p;
                contador[zona]++;
            }
        }
    }

    public void mostrarMatriz() {
        for (int i = 0; i < zonas; i++) {
            System.out.println("Zona " + (i + 1) + ":");
            for (int j = 0; j < paquetesPorZona; j++) {
                System.out.println(matriz[i][j]);
            }
            System.out.println();
        }
    } 
    
    public Paquete<T>[][] getMatriz() {
    return matriz;
}   

}
