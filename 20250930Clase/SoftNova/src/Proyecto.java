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
        if (equipo.comprobarValidezEquipo()) this.equipo = equipo;
    }

    public String getListaTareasStr() {
        String listaTareasStr = "";
        listaTareasStr += "Lista de tareas del proyecto " + nombre + ":\n";
        for (Tarea t: listaTareas){
            listaTareasStr += t.getTitulo() + "\n";
        }
        return listaTareasStr;
    }

    public List<Tarea> getListaTareas() {
        return Collections.unmodifiableList(listaTareas);
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    @Override
    public String toString() {
        String listaTareasStr = "";
        listaTareasStr += "Lista de tareas del proyecto " + nombre + ":\n";
        for (Tarea t: listaTareas){
            listaTareasStr += t.getTitulo() + "\n";
        }
        String nombreEquipo = "No hay equipo asignado";

        if(equipo != null) nombreEquipo = equipo.getNombre();
        return "Detalles del proyecto:\n" +
                "nombre='" + nombre + '\'' + "\n" +
                "fechaInicio=" + fechaInicio + "\n" +
                "presupuesto=" + presupuesto + "\n" +
                getListaTareasStr() + "\n" +
                "equipo=" + nombreEquipo;
    }
}
