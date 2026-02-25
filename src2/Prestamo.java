import java.util.Date; // Importamos la clase Date para manejar las fechas de los préstamos

// Clase que representa un préstamo de libro a un usuario
public class Prestamo {
    private final int idPrestamo;
    private final Date fechaInicio;
    private final Libro book;
    private final Usuario user;

// Constructor de la clase Prestamo que inicializa el ID del préstamo, el libro prestado y el usuario que lo recibe
    public Prestamo(int idPrestamo, Libro book, Usuario user) {
        this.idPrestamo = idPrestamo;
        this.fechaInicio = new Date();
        this.book = book;
        this.user = user;
    }

// Método para finalizar el préstamo, actualizando el stock del libro y notificando al usuario
    public void finalizarPrestamo() {
        book.actualizarStock(1);
        user.devolverLibro();
        System.out.println("\nPréstamo finalizado " + book.getTitulo()); // Notificación de que el préstamo ha sido finalizado, mostrando el título del libro
    }
}