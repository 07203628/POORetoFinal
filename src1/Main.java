public class Main {
    public static void main(String[] args) {
        Biblioteca miBiblioteca = new Biblioteca();

        Libro book1 = new Libro("1234", "ABC", "Juan", 2);
        Libro book2 = new Libro("456", "DFG", "Pedro", 4);

        Usuario user1 = new Estudiante("A01", "Diego");
        Usuario user2 = new Profesor("P01", "Carlos");

        miBiblioteca.registrarLibro(book1);
        miBiblioteca.registrarLibro(book2);
        miBiblioteca.registrarUsuario(user1);
        miBiblioteca.registrarUsuario(user2);

        miBiblioteca.realizarPrestamo(user1, book1);
        miBiblioteca.realizarPrestamo(user1, book2);
        miBiblioteca.realizarPrestamo(user2, book1);
        miBiblioteca.realizarPrestamo(user2, book2);
        miBiblioteca.generarReporte();
    }
}