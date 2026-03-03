import java.util.ArrayList;

// Clase que gestiona libros usuarios y préstamos en la biblioteca
public class Biblioteca {
    private final ArrayList<Libro> listaLibros;
    private final ArrayList<Usuario> listaUsuario;
    private final ArrayList<Prestamo> listaPrestamos;
    private int contadorPrestamos = 1;

    public Biblioteca() {
        listaLibros = new ArrayList<>();
        listaUsuario = new ArrayList<>();
        listaPrestamos = new ArrayList<>();
    }

    public void registrarLibro(Libro book) { listaLibros.add(book); } // Método para registrar un libro en la biblioteca
    public void registrarUsuario(Usuario user) { listaUsuario.add(user); } // Método para registrar un usuario en la biblioteca
    public void realizarPrestamo(Usuario user, Libro book) { // Método para realizar un préstamo de un libro a un usuario
        if (!user.puedePedir()) { // Verificar si el usuario puede pedir más libros
            System.out.println("El usuario " + user.getNombre() + " ha alcanzado su límite.");
            return;
        }

        if (book.getUnidadesDisponibles() <= 0) { // Si no hay unidades disponibles, mostrar un mensaje y salir del método
            System.out.println("No hay copias disponibles de " + book.getTitulo());
            return;
        }
        Prestamo nuevoPrestamo = new Prestamo(contadorPrestamos++, book, user); // Crear un nuevo préstamo con un ID único, el libro y el usuario
        listaPrestamos.add(nuevoPrestamo); // Agregar el nuevo préstamo a la lista de préstamos activos
        book.actualizarStock(-1); // Actualizar el stock del libro, restando una unidad
        user.registrarPrestamo(); // Registrar el préstamo en el usuario, incrementando su contador de libros prestados
        System.out.println("Préstamo realizado. \nLibro: " + book.getTitulo() + "\nUsuario: " + user.getNombre());
    }

    public void generarReporte() {
        System.out.println("\n--- BIBLIOTECA ---");
        System.out.println("Total libros registrados: " + listaLibros.size());
        for ( Libro l : listaLibros) { // Mostrar cada libro con su título y unidades disponibles
            System.out.println(" - " + l.getTitulo() + " (Disponibles: " + l.getUnidadesDisponibles() + ")"); // Mostrar el título y unidades
        }
        System.out.println("Total usuarios: " + listaUsuario.size());
        System.out.println("Préstamos activos: " + listaPrestamos.size());
        System.out.println("------------------");
    }

    public void mostrarLibros() {
        System.out.println("\n--- LISTA DE LIBROS ---");
        if (listaLibros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (Libro l : listaLibros) {
            System.out.println("ISBN: " + l.getIsbn() + " | Título: " + l.getTitulo() + " | Autor: " + l.getAutor() + " | Disponibles: " + l.getUnidadesDisponibles());
        }
    }

    public void mostrarUsuarios() {
        System.out.println("\n--- USUARIOS (ESTUDIANTES) ---");
        boolean anyEst = false;
        for (Usuario u : listaUsuario) {
            if (u instanceof Estudiante) {
                anyEst = true;
                System.out.println(" - " + u.getNombre() + " (" + u.getIdUsuario() + ") - Prestados: " + u.getLibrosPrestados());
            }
        }
        if (!anyEst) System.out.println("No hay estudiantes registrados.");

        System.out.println("\n--- USUARIOS (PROFESORES) ---");
        boolean anyProf = false;
        for (Usuario u : listaUsuario) {
            if (u instanceof Profesor) {
                anyProf = true;
                System.out.println(" - " + u.getNombre() + " (" + u.getIdUsuario() + ") - Prestados: " + u.getLibrosPrestados());
            }
        }
        if (!anyProf) System.out.println("No hay profesores registrados.");
    }
}
