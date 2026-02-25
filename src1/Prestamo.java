import java.util.Date;

public class Prestamo {
    private final int idPrestamo;
    private final Date fechaInicio;
    private final Libro book;
    private final Usuario user;

    public Prestamo(int idPrestamo, Libro book, Usuario user) {
        this.idPrestamo = idPrestamo;
        this.fechaInicio = new Date();
        this.book = book;
        this.user = user;
    }

    public void finalizarPrestamo() {
        book.actualizarStock(1);
        user.devolverLibro();
        System.out.println("\nPréstamo finalizado " + book.getTitulo());
    }
}