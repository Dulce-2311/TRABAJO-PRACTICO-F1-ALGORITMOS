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

            capacidad = Integer.parseInt(br.readLine().split("=")[1]);
            zonas = Integer.parseInt(br.readLine().split("=")[1]);
            paquetesPorZona = Integer.parseInt(br.readLine().split("=")[1]);
        br.readLine(); // saltar encabezado

        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");

            String codigo = datos[0];
            double peso = Double.parseDouble(datos[1]);
            String prioridad = datos[2];
            int valorizacion = Integer.parseInt(datos[3]);
            int zona = Integer.parseInt(datos[4]);

            Paquete<String> paquete = new Paquete<>(
                    codigo, peso, prioridad, valorizacion, zona
            );

            listaPaquetes.add(paquete);
        }

     } catch (IOException e) {
         System.out.println("Error al leer el archivo: " + e.getMessage());
     }
 }
 
public int getCapacidad() {
    return capacidad;
}

public int getZonas() {
    return zonas;
}

public int getPaquetesPorZona() {
    return paquetesPorZona;
}

public ArrayList<Paquete<String>> getListaPaquetes() {
    return listaPaquetes;
}
    
    


}
