import java.util.ArrayList;

// Crear lista de libros, usuarios y préstamos
public class Biblioteca {
    private final ArrayList<Libro> listaLibros;
    private final ArrayList<Usuario> listaUsuario;
    private final ArrayList<Prestamo> listaPrestamos;
    private int contadorPrestamos = 1;

// Constructor para inicializar las listas de la biblioteca
    public Biblioteca() {
        listaLibros = new ArrayList<>();
        listaUsuario = new ArrayList<>();
        listaPrestamos = new ArrayList<>();
    }
// Métodos para registrar libros, usuarios y realizar préstamos
    public void registrarLibro(Libro book) { listaLibros.add(book); } // Método para registrar un libro en la biblioteca
    public void registrarUsuario(Usuario user) { listaUsuario.add(user); } // Método para registrar un usuario en la biblioteca
    public void realizarPrestamo(Usuario user, Libro book) { // Método para realizar un préstamo de un libro a un usuario
        if (!user.puedePedir()) { // Verificar si el usuario puede pedir más libros
            System.out.println("El usuario " + user.getNombre() + " ha alcanzado su límite.");
            return;
        }
// Verificar si el libro tiene unidades disponibles
        if (book.getUnidadesDisponibles() <= 0) { // Si no hay unidades disponibles, mostrar un mensaje y salir del método
            System.out.println("No hay copias disponibles de " + book.getTitulo());
            return;
        }
// Crear un nuevo préstamo, actualizar el stock del libro y registrar el préstamo en el usuario
        Prestamo nuevoPrestamo = new Prestamo(contadorPrestamos++, book, user); // Crear un nuevo préstamo con un ID único, el libro y el usuario
        listaPrestamos.add(nuevoPrestamo); // Agregar el nuevo préstamo a la lista de préstamos activos
        book.actualizarStock(-1); // Actualizar el stock del libro, restando una unidad
        user.registrarPrestamo(); // Registrar el préstamo en el usuario, incrementando su contador de libros prestados
        System.out.println("Préstamo realizado. \nLibro: " + book.getTitulo() + "\nUsuario: " + user.getNombre());
    }

// Método para generar un reporte de la biblioteca
    public void generarReporte() {
        System.out.println("\n--- BIBLIOTECA ---");
        System.out.println("Total libros registrados: " + listaLibros.size());
        for ( Libro l : listaLibros) { // Mostrar cada libro con su título y unidades disponibles
            System.out.println(" - " + l.getTitulo() + " (Disponibles: " + l.getUnidadesDisponibles() + ")"); // Mostrar el título del libro y las unidades disponibles
        }
        System.out.println("Total usuarios: " + listaUsuario.size());
        System.out.println("Préstamos activos: " + listaPrestamos.size());
        System.out.println("------------------");
    }
}