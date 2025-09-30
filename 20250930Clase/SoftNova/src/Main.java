import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println("Inicio de demo de SoftNova:");
        Proyecto chimera = new Proyecto("Chimera", new Date(), 1000000);
        Tarea backend = new Tarea("Desarrollo Backend", 1000);
        Tarea api = new Tarea("Desarrollar API", 600);
        chimera.añadirTarea(backend);
        backend.añadirSubtarea(api);

        System.out.println("La tarea " + api.getTitulo() + " es hija de " + api.getPadre().getTitulo() + " y está en estado " + api.getEstado());
    }

}
