import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Proyecto {

    private String nombre;
    private Date fechaInicio;
    private int presupuesto;
    private List<Tarea> listaTareas;
    private Equipo equipo;

    public Proyecto(String nombre, Date fechaInicio, int presupuesto) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.presupuesto = presupuesto;
        this.listaTareas = new ArrayList<Tarea>();
        this.equipo = null;
    }

    public void añadirTarea(Tarea t) {
        listaTareas.add(t);
    }

    public void asignarEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Tarea> getListaTareas() {
        return Collections.unmodifiableList(listaTareas);
    }

}
