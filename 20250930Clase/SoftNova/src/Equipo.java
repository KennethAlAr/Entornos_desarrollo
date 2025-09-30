import java.util.ArrayList;

public class Equipo {

    private String nombre;
    private ArrayList<Empleado> listaEmpleados;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList<Empleado>();
    }

    public void añadirEmpleado (Empleado e) {
        this.listaEmpleados.add(e);
    }

}
