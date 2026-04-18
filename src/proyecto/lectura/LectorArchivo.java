package proyecto.lectura;

import proyecto.modelo.Paquete;
import java.util.ArrayList;

public class LectorArchivo {
    private int capacidad;
    private int zonas;
    private int paquetesPorZona;
    
 private ArrayList<Paquete<String>> listaPaquetes;

    public LectorArchivo() {
        listaPaquetes = new ArrayList<>();
    }

}
