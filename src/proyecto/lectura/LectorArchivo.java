package proyecto.lectura;

import proyecto.modelo.Paquete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorArchivo {
    private int capacidad;
    private int zonas;
    private int paquetesPorZona;

 private ArrayList<Paquete<String>> listaPaquetes;

    public LectorArchivo() {
        listaPaquetes = new ArrayList<>();
    }

    public void leerArchivo(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            String linea;

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }    


}
