// Clase que representa un libro en la biblioteca
public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int unidadesDisponibles;

// Constructor para inicializar un libro con su información y stock disponible
    public Libro(String isbn, String titulo, String autor, int unidadesDisponibles) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.unidadesDisponibles = unidadesDisponibles;
    }

// Método para actualizar el stock de un libro, sumando o restando la cantidad indicada
    public void actualizarStock(int cantidad) {
        this.unidadesDisponibles += cantidad; // Actualiza el stock del libro sumando la cantidad (puede ser positiva o negativa)
    }

// Métodos para obtener la cantidad de unidades disponibles y el título del libro
    public int getUnidadesDisponibles() { return unidadesDisponibles; } // Obtener la cantidad de unidades disponibles del libro
    public String getTitulo() { return titulo; } // Obtener el título del libro

// Método para representar el libro como una cadena de texto, mostrando su título y unidades disponibles
    @Override
    public String toString() {
        return titulo + " (Disponibles: " + unidadesDisponibles + ")";     // Representación del libro mostrando su título y unidades disponibles   
    }
}