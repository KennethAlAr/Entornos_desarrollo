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

    public String getNombre() {
        return nombre;
    }

    public boolean comprobarValidezEquipo() {
        boolean valido = true;
        for (Empleado.Rol rol: Empleado.Rol.values()) {
            boolean encontrado = false;
            for (Empleado e: listaEmpleados) {
                if (e.getRol() == rol) {
                    encontrado = true;
                    break;
                }
            }
            if(!encontrado) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String listaEmpleadosStr = "";
        for (Empleado e: listaEmpleados) {
            listaEmpleadosStr += "Empleado: " + e.getNombre() + " con rol " + e.getRol() + "\n";
        }
        return "Equipo{" +
                "nombre='" + nombre + '\'' + "\n" +
                listaEmpleadosStr;
    }
}
