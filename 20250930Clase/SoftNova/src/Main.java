import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Inicio de demo de SoftNova:");
        Proyecto chimera = new Proyecto("Chimera", new Date(), 1000000);
        Tarea backend = new Tarea("Desarrollo Backend", 1000);
        Tarea frontend = new Tarea("Desarrollo frontend", 3000);
        Tarea api = new Tarea("Desarrollar API", 600);
        Tarea pantallitas = new Tarea("Crear pantallas", 1500);
        Equipo damdawers = new Equipo("Equipo formado por los alumnso de DAM/DAW");

        chimera.asignarEquipo(damdawers);
        chimera.añadirTarea(backend);
        chimera.añadirTarea(frontend);
        backend.añadirSubtarea(api);
        frontend.añadirSubtarea(pantallitas);

        System.out.println("La tarea " + api.getTitulo() + " es hija de " + api.getPadre().getTitulo() + " y está en estado " + api.getEstado());
        List<Tarea> listaTareas = chimera.getListaTareas();


//        Tarea pruebaFallo = new Tarea("Intento añadir tarea", 1);
//        listaTareas.add(pruebaFallo);
//
//        System.out.println("Nueva lista de tareas del proyecto " + chimera.getNombre() + ":");
//        for (Tarea t: listaTareas){
//            System.out.println(t.getTitulo());
//        }

        System.out.println(chimera.toString()); //Se puede hacer directamente sout del objeto, sin el toString()

        System.out.println(pantallitas);
        pantallitas.actualizarTareaEnCurso();
        System.out.println(pantallitas);
        pantallitas.actualizarTareaHecha();
        System.out.println(pantallitas);

        Empleado victor = new Empleado("12345678O", "Victor", Empleado.Rol.TESTER);
        Empleado kenneth = new Empleado("23456789A", "Kenneth", Empleado.Rol.ANALISTA);
        Empleado jorge = new Empleado("34567890C", "Jorge", Empleado.Rol.DEVELOPER);
        Empleado jose = new Empleado("12345678P", "Jose", Empleado.Rol.PM);

        damdawers.añadirEmpleado(victor);
        damdawers.añadirEmpleado(kenneth);
        damdawers.añadirEmpleado(jorge);
        damdawers.añadirEmpleado(jose);

        System.out.println(damdawers);

        chimera.asignarEquipo(damdawers);
        System.out.println(chimera);

    }

}
