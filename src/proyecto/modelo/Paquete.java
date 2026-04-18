package proyecto.modelo;

public class Paquete<T extends Comparable<T>> {

    private String codigo;
    private double peso;
    private T prioridad;
    private int valorizacion;
    private int zona;

    // Constructor
    public Paquete(String codigo, double peso, T prioridad, int valorizacion, int zona) {
        this.codigo = codigo;
        this.peso = peso;
        this.prioridad = prioridad;
        this.valorizacion = valorizacion;
        this.zona = zona;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public double getPeso() {
        return peso;
    }

    public T getPrioridad() {
        return prioridad;
    }

    public int getValorizacion() {
        return valorizacion;
    }

    public int getZona() {
        return zona;
    }

    // Comparar prioridad
    public int compararPrioridad(Paquete<T> otro) {
        return this.prioridad.compareTo(otro.prioridad);
    }

    // Mostrar datos
    @Override
    public String toString() {
        return "Paquete{" +
                "codigo='" + codigo + '\'' +
                ", peso=" + peso +
                ", prioridad=" + prioridad +
                ", valorizacion=" + valorizacion +
                ", zona=" + zona +
                '}';
    }
}