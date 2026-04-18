package proyecto.modelo;

public class GestorZonas {
    private Paquete<T>[][] matriz;
    private int zonas;
    private int paquetesPorZona;

    public GestorZonas(int zonas, int paquetesPorZona) {
        this.zonas = zonas;
        this.paquetesPorZona = paquetesPorZona;
        matriz = new Paquete[zonas][paquetesPorZona];
    }
    
}
