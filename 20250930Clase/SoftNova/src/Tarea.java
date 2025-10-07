import java.util.ArrayList;

public class Tarea {

    public static enum Estado {
        PENDIENTE, EN_CURSO, HECHA
    }

    private String titulo;
    private int horasEstimadas;
    private Estado estado;
    private ArrayList<Tarea> listaSubtareas;
    private Tarea padre;

    public Tarea(String titulo, int horasEstimadas) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.estado = Estado.PENDIENTE;
        this.listaSubtareas = new ArrayList<Tarea>();
        this.padre = null;
    }

    public void actualizarTareaPendiente() {
        this.estado = Estado.PENDIENTE;
    }

    public void actualizarTareaEnCurso() {
        this.estado = Estado.EN_CURSO;
    }

    public void actualizarTareaHecha() {
        this.estado = Estado.HECHA;
    }

    public void añadirSubtarea(Tarea subtarea) {
        if (listaSubtareas.contains(subtarea)) {
            throw new IllegalArgumentException("La subtarea ya existe");
        }
        listaSubtareas.add(subtarea);
        subtarea.padre = this;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public String getEstado() {
        return switch (estado) {
            case PENDIENTE -> "Pendiente";
            case EN_CURSO -> "En curso";
            case HECHA -> "Hecha";
        };
    }

    public Tarea getPadre() {
        return padre;
    }

    public String getListaTareasStr() {
        String listaTareasStr = "";
        listaTareasStr += "Lista de subtareas de la tarea " + titulo + ":\n";
        for (Tarea t: listaSubtareas){
            listaTareasStr += t.getTitulo() + "\n";
        }
        return listaTareasStr;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "titulo='" + titulo + '\'' +
                ", horasEstimadas=" + horasEstimadas +
                ", estado=" + estado +
                getListaTareasStr() +
                ", padre=" + padre.getTitulo() +
                '}';
    }
}
