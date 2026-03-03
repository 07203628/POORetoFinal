import java.util.ArrayList;

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

    public void registrarLibro(Libro book) { listaLibros.add(book); }
    public void registrarUsuario(Usuario user) { listaUsuario.add(user); }
    public void realizarPrestamo(Usuario user, Libro book) {
        if (!user.puedePedir()) {
            System.out.println("El usuario " + user.getNombre() + " ha alcanzado su límite.");
            return;
        }

        if (book.getUnidadesDisponibles() <= 0) {
            System.out.println("No hay copias disponibles de " + book.getTitulo());
            return;
        }
        Prestamo nuevoPrestamo = new Prestamo(contadorPrestamos++, book, user);
        listaPrestamos.add(nuevoPrestamo);
        book.actualizarStock(-1);
        user.registrarPrestamo();
        System.out.println("Préstamo realizado. \nLibro: " + book.getTitulo() + "\nUsuario: " + user.getNombre());
    }

    public void generarReporte() {
        System.out.println("\n--- BIBLIOTECA ---");
        System.out.println("Total libros registrados: " + listaLibros.size());
        for ( Libro l : listaLibros) {
            System.out.println(" - " + l.getTitulo() + " (Disponibles: " + l.getUnidadesDisponibles() + ")");
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