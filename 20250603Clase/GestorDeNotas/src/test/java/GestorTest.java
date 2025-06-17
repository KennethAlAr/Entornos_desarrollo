import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;



class GestorTest {

    @BeforeEach
    public void configuracion() {
        String nombre = "Jordi";
        ArrayList<Float> notas = new ArrayList<>();
        notas.add(10f);
        notas.add(10f);
        notas.add(10f);
        Gestor.anadirAlumno(nombre, notas);
    }

    @Test
    public void menu(){
        String menu = "Escoge una opción:\n" +
                "1. Añadir un alumno.\n" +
                "2. Eliminar alumno.\n" +
                "3. Añadir una nota.\n" +
                "4. Modificar una nota.\n" +
                "5. Eliminar una nota.\n" +
                "6. Consultar notas alumno.\n" +
                "7. Consultar medias alumnos.\n" +
                "8. Salir.";
        assertEquals(menu, Gestor.menu());
    }

    @Test
    public void anadirAlumnoCorrectamente() {
        String resultado = "Alumno Joel añadido con éxito.";
        String nombre = "Joel";
        ArrayList<Float> notas = new ArrayList<>();
        notas.add(10f);
        notas.add(10f);
        notas.add(10f);
        assertEquals(resultado, Gestor.anadirAlumno(nombre, notas));
    }

//    @Test
//    public void anadirAlumnoRepetidoTest() {
//        String nombre = "Jordi";
//        ArrayList<Float> notas = new ArrayList<>();
//        notas.add(10f);
//        notas.add(10f);
//        notas.add(10f);
//        Gestor.anadirAlumno(nombre, notas);
//        assertThrows(IllegalArgumentException.class, () -> {
//            Gestor.anadirAlumno(nombre, notas);
//        });
//    }

    @Test
    public void anadirNotaCorrectamente() {
        String nombre = "Kenneth";
        ArrayList<Float> notas = new ArrayList<>();
        notas.add(10f);
        notas.add(10f);
        notas.add(10f);
        Gestor.anadirAlumno(nombre, notas);
        Gestor.anadirNota(nombre, 10f);
        assertTrue(Gestor.notasAlumnos.get(nombre).size() == 4);
    }

    @Test
    public void mostrarNotasAlumno() {
        String resultado = "Notas del alumno Jordi:10.0 10.0 10.0 ";
        assertEquals(resultado, Gestor.mostrarNotas("Jordi"));
    }

    @Test
    public void mostrarNotasAlumnoNoExistente() {
        assertThrows(IllegalArgumentException.class, () -> Gestor.mostrarNotas("Victor"));
    }

    @Test
    public void eliminarAlumnoCorrectamente() {
        String resultado = "Alumno Jordi eliminado correctamente.";
        assertEquals(resultado, Gestor.eliminarAlumno("Jordi"));
    }

    @Test
    public void eliminarNotaAlumnoCorrectamente() {
        float resultado = 10f;
        assertEquals(resultado, Gestor.eliminarNotaAlumno("Jordi", 0));
    }

    @Test
    public void eliminarNotaAlumnoNoExistente() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Gestor.eliminarNotaAlumno("Jordi", 3));
    }

    @Test
    public void consultarMediasPorAlumno() {
        HashMap<String, Float> resultado = new HashMap<>();
        resultado.put("Jordi", 10f);
        assertEquals(resultado, Gestor.consultarMediasPorAlumno());
    }

    @AfterEach
    public void cerrarConfiguraciones() {
        Gestor.notasAlumnos.clear();
    }

}