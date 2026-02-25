// Clase principal para ejecutar el programa de la biblioteca
public class Main {
    public static void main(String[] args) {
        Biblioteca miBiblioteca = new Biblioteca(); // Crear una instancia de la biblioteca

// Crear algunos libros con su código, título, autor y cantidad disponible
        Libro book1 = new Libro("1234", "ABC", "Juan", 2);
        Libro book2 = new Libro("456", "DFG", "Pedro", 4);

// Crear algunos usuarios, un estudiante y un profesor
        Usuario user1 = new Estudiante("A01", "Diego");
        Usuario user2 = new Profesor("P01", "Carlos");

// Registrar los libros y usuarios en la biblioteca
        miBiblioteca.registrarLibro(book1);
        miBiblioteca.registrarLibro(book2);
        miBiblioteca.registrarUsuario(user1);
        miBiblioteca.registrarUsuario(user2);

// Realizar algunos préstamos de libros a los usuarios
        miBiblioteca.realizarPrestamo(user1, book1);
        miBiblioteca.realizarPrestamo(user1, book2);
        miBiblioteca.realizarPrestamo(user2, book1);
        miBiblioteca.realizarPrestamo(user2, book2);
        miBiblioteca.generarReporte();
    }
}