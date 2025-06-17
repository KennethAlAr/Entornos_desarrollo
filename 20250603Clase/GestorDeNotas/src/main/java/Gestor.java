/**
 * Sistema gestor de notas
 * @author Kenneth Alonso
 * @version 1.0
 */

/*
Sistema gestor de notas:
Tenemos un diccionario de (String[nombre alumno],Arraylist(double)[notas curso]).
Nuestro producto ha de permitir hacer lo siguiente:
* Añadir una nota a un alumno
* Añadir un alumno al diccionario
* Modificar una nota de un alumno
* Eliminar una nota de un alumno
* Eliminar un alumno del diccionario
* Listar las notas de un alumno
* Listar los alumnos con su nota media
* Salir

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Gestor {

    static HashMap<String, ArrayList<Float>> notasAlumnos = new HashMap<>();

    /**
     * Función que construye el menú de la aplicación
     * @return menu String que contiene el menú de la aplicación a imprimir
     */
    public static String menu() {
        String menu = "Escoge una opción:\n" +
                "1. Añadir un alumno.\n" +
                "2. Eliminar alumno.\n" +
                "3. Añadir una nota.\n" +
                "4. Modificar una nota.\n" +
                "5. Eliminar una nota.\n" +
                "6. Consultar notas alumno.\n" +
                "7. Consultar medias alumnos.\n" +
                "8. Salir.";
        return menu;
    }

    /**
     * Función que añade un alumno en el diccionario si este no existe.
     * @param nombre Nombre del alumno
     * @param notas Lista de notas del alumno
     * @throws IllegalArgumentException El alumno ya existe en el sistema
     */
    public static String anadirAlumno(String nombre, ArrayList<Float> notas) {
        if (notasAlumnos.containsKey(nombre)) {
            throw new IllegalArgumentException("El alumno " + nombre + " ya existe.");
        }
        notasAlumnos.put(nombre, notas);
        return "Alumno " + nombre + " añadido con éxito.";
    }

    /**
     * Función que añade una nota a un alumno que ya existe.
     * @param nombre nombre del alumno
     * @param nota nota del alumno
     * @throws IllegalArgumentException Alumno no existente en sistema
     */
    public static String anadirNota(String nombre, Float nota) {
        if (!notasAlumnos.containsKey(nombre)) {
            System.out.printf("El alumno %s no existe en el sistema.", nombre);
            throw new IllegalArgumentException(("El alumno " + nombre + " no existe."));
        }
        notasAlumnos.get(nombre).add(nota);
        return "Nota " + nota + " añadida al alumno " + nombre + " con éxito.";
    }

    /**
     * Función para mostrar las notas de un almuno.
     * @param nombre Nombre del alumno
     * @return Mensaje de éxito
     * @throws IllegalArgumentException Alumno no existente
     */
    public static String mostrarNotas(String nombre) {
        if (!notasAlumnos.containsKey(nombre)) {
            System.out.printf("El alumno %s no existe en el sistema.", nombre);
            throw new IllegalArgumentException(("El alumno " + nombre + " no existe."));
        }
        String resultado = "Notas del alumno " + nombre + ":";
        System.out.println("Notas del alumno " + nombre + ":");
        for (int i = 0; i < notasAlumnos.get(nombre).size(); i++) {
            resultado += notasAlumnos.get(nombre).get(i) + " ";
        }
        return resultado;
    }

    /**
     * Función para eliminar un alumno.
     * @param nombre Nombre del alumno
     * @throws IllegalArgumentException Alumno no existente en el sistema
     */
    public static String eliminarAlumno(String nombre) {
        if (notasAlumnos.remove(nombre) == null) {
            throw new IllegalArgumentException(("Alumno " + nombre + " no existe en el sistema."));
        }
        notasAlumnos.remove(nombre);
        return "Alumno " + nombre + " eliminado correctamente.";
    }

    /**
     * Función para eliminar una nota de un alumno
     * @param nombre Nombre del alumno
     * @param posicion Posición de la nota a eliminar
     * @return nota eliminada
     * @throws IllegalArgumentException Alumno no existente en sistema
     * @throws ArrayIndexOutOfBoundsException Nota no existente en la lista del alumno
     */
    public static float eliminarNotaAlumno(String nombre, int posicion) {
        if (!notasAlumnos.containsKey(nombre)) {
            throw new IllegalArgumentException ("El alumno " + nombre + " no existe en el sistema.");
        } else if (notasAlumnos.get(nombre).size() <= (posicion)) {
            throw new ArrayIndexOutOfBoundsException("No existe la posición " + posicion +  " en la lista de notas.");
        }
        return notasAlumnos.get(nombre).remove(posicion);
    }

    /**
     * Función para modificar una nota de un alumno
     * @param nombre Nombre del alumno
     * @param posicion Posición de la nota a modificar
     * @param nuevaNota Nota a sustituir por un valor anterior
     * @return valor nota antes de modificación
     * @throws IllegalArgumentException Alumno no existente en sistema
     * @throws ArrayIndexOutOfBoundsException Nota no existente en la lista del alumno
     */
    public static float modificarNotaAlumno(String nombre, int posicion, float nuevaNota) {
        if (!notasAlumnos.containsKey(nombre)) {
            throw new IllegalArgumentException ("El alumno " + nombre + " no existe en el sistema.");
        } else if (notasAlumnos.get(nombre).size() <= (posicion)) {
            throw new ArrayIndexOutOfBoundsException("No existe la posición " + posicion +  " en la lista de notas.");
        }
        return notasAlumnos.get(nombre).set(posicion, nuevaNota);
    }

    /**
     * Función para listar a los alumnos con la media de sus notas
     * @return HashMap de todos los alumnos con su nota media
     */
    public static HashMap<String, Float> consultarMediasPorAlumno() {
        HashMap<String, Float> mediaNotas = new HashMap<>();
        for (String alumno : notasAlumnos.keySet()) {
            ArrayList<Float> notas = notasAlumnos.get(alumno);
            float total = 0;
            for (float nota : notas) {
                total += nota;
            }
            mediaNotas.put(alumno, total/notas.size());
        }
        return mediaNotas;
    }

    /**
     * Función principal del programa.
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int posicion;
        float nota;

        while (opcion != 8) {
            System.out.println(menu());
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Inserta el nombre del alumno:");
                    String nombre = sc.nextLine();
                    System.out.println("Inserta las notas del alumno separadas por espacios:");
                    ArrayList<Float> notas = new ArrayList<>();
                    String[] notasInput = sc.nextLine().split(" ");
                    for (int i = 0; i < notasInput.length; i++) {
                        notas.add(Float.parseFloat(notasInput[i]));
                    }
                    try {
                        System.out.println(anadirAlumno(nombre, notas));
                    } catch (IllegalArgumentException ie) {
                        System.err.println(ie.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Inserta el nombrte del alumno:");
                    nombre = sc.nextLine();
                    try {
                        System.out.println(Gestor.eliminarAlumno(nombre));
                    } catch(IllegalArgumentException ie) {
                        System.err.println(ie.getMessage());;
                    }
                case 3:
                    System.out.println("Inserta el nombre del alumno:");
                    nombre = sc.nextLine();
                    System.out.println("Inserta la nota del alumno.");
                    nota = sc.nextFloat();
                    sc.nextLine();
                    try {
                        System.out.println(anadirNota (nombre, nota));
                    } catch (IllegalArgumentException ie) {
                        System.err.println(ie.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Inserta el nombre del alumno:");
                    nombre = sc.nextLine();
                    System.out.println("Inserta la posición de la nota que quieres eliminar:");
                    posicion = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Inserta la nota del alumno:");
                    nota = sc.nextFloat();
                    sc.nextLine();
                    try {
                        System.out.println("Se ha modificado la nota " + modificarNotaAlumno(nombre, posicion, nota) + " por la nota " + nota + ".");
                    } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Inserta el nombre del alumno:");
                    nombre = sc.nextLine();
                    System.out.println("Inserta la posición de la nota que quieres eliminar:");
                    posicion = sc.nextInt();
                    sc.nextLine();
                    try {
                        System.out.println("Se ha eliminado la nota " + eliminarNotaAlumno(nombre, posicion) + ".");
                    } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Inserta el nombre del alumno: ");
                    nombre = sc.nextLine();
                    try {
                        System.out.println(mostrarNotas (nombre));
                    } catch (IllegalArgumentException ie) {
                        System.err.println(ie.getMessage());
                    }
                    break;
                case 7:
                    HashMap<String, Float> mediaNotas = consultarMediasPorAlumno();
                    for (String alumno : mediaNotas.keySet()) {
                        System.out.println("El alumno " + alumno + " tiene una media de " + mediaNotas.get(alumno) + ".");
                    }
            }
        }


    }
}
