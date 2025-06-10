import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;



class GestorTest {

    @BeforeEach
    public void configuracionTest() {
        String nombre = "Jordi";
        ArrayList<Float> notas = new ArrayList<>();
        notas.add(10f);
        notas.add(10f);
        notas.add(10f);
        Gestor.anadirAlumno(nombre, notas);
    }

    @Test
    public void menuTest(){
        String menu = "Escoge una opción:\n" +
                "1. Añadir un alumno.\n" +
                "2. Eliminar alumno.\n" +
                "3. Añadir una nota.\n" +
                "4. Consultar notas alumno.\n" +
                "5. Salir.";
        assertEquals(menu, Gestor.menu());
    }

    @Test
    public void anadirAlumnoCorrectamenteTest() {
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
    public void anadirNotaCorrectamenteTest() {
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
    public void mostrarNotasAlumnoTest() {
        String resultado = "Notas del alumno Jordi:10.0 10.0 10.0 ";
        assertEquals(resultado, Gestor.mostrarNotas("Jordi"));
    }

    @Test
    public void eliminarAlumnoCorrectamenteTest() {
        String resultado = "Almuno Jordi eliminado correctamente.";
        assertEquals(resultado, Gestor.eliminarAlumno("Jordi"));
    }

    @AfterEach
    public void cerrarConfiguracionesTest() {
        Gestor.notasAlumnos.clear();
    }

}