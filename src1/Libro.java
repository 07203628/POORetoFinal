public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int unidadesDisponibles;

    public Libro(String isbn, String titulo, String autor, int unidadesDisponibles) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public void actualizarStock(int cantidad) {
        this.unidadesDisponibles += cantidad;
    }

    public int getUnidadesDisponibles() { return unidadesDisponibles; }
    public String getTitulo() { return titulo; }

    @Override
    public String toString() {
        return titulo + " (Disponibles: " + unidadesDisponibles + ")";        
    }
}