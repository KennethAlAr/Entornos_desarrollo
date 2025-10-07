public class Empleado {

    public static enum Rol {
        ANALISTA, DEVELOPER, TESTER, PM
    }

    private String dni;
    private String nombre;
    private Rol rol;


    public Empleado (String dni, String nombre, Rol rol) {
        this.dni = dni;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public Rol getRol() {
        return rol;
    }
}