import java.util.Scanner;

// Clase principal para ejecutar el programa de la biblioteca
public class Main {
    public static void main(String[] args) {
        Biblioteca miBiblioteca = new Biblioteca();
        try (Scanner sc = new Scanner(System.in)) {
            boolean salir = false;
            while (!salir) {
                System.out.println("\n--- MENU BIBLIOTECA ---");
                System.out.println("1. Registrar libro");
                System.out.println("2. Registrar usuario");
                System.out.println("3. Generar reporte");
                System.out.println("4. Mostrar libros");
                System.out.println("5. Mostrar usuarios");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");

                String opcion = sc.nextLine();
                clearPreviousLine();
                switch (opcion) {
                    case "1" -> {
                        System.out.print("ISBN: ");
                        String isbn = sc.nextLine();
                        System.out.print("Título: ");
                        String titulo = sc.nextLine();
                        System.out.print("Autor: ");
                        String autor = sc.nextLine();
                        System.out.print("Unidades disponibles: ");
                        int unidades = 0;
                        String unidadesStr = sc.nextLine();
                        clearPreviousLine();
                        try {
                            unidades = Integer.parseInt(unidadesStr);
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. Se usará 1 unidad por defecto.");
                            unidades = 1;
                        }
                        Libro nuevoLibro = new Libro(isbn, titulo, autor, unidades);
                        miBiblioteca.registrarLibro(nuevoLibro);
                        System.out.println("Libro registrado: " + nuevoLibro);
                    }
                    case "2" -> {
                        System.out.print("Tipo de usuario (E = Estudiante, P = Profesor): ");
                        String tipo = sc.nextLine().trim().toUpperCase();
                        System.out.print("ID usuario: ");
                        String id = sc.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        Usuario nuevoUsuario;
                        if (tipo.equals("P")) {
                            nuevoUsuario = new Profesor(id, nombre);
                        } else {
                            nuevoUsuario = new Estudiante(id, nombre);
                        }
                        miBiblioteca.registrarUsuario(nuevoUsuario);
                        System.out.println("Usuario registrado: " + nombre + " (" + id + ")");
                    }
                    case "3" -> miBiblioteca.generarReporte();
                    case "4" -> miBiblioteca.mostrarLibros();
                    case "5" -> miBiblioteca.mostrarUsuarios();
                    case "6" -> salir = true;
                    default -> System.out.println("Opción no válida.");
                }
            }

            System.out.println("Saliendo...");
        }
    }

    private static void clearPreviousLine() {
        final String ESC = "\u001B";
        System.out.print(ESC + "[1A" + ESC + "[2K");
        System.out.flush();
    }
}
