// Clase abstracta que representa a un usuario de la biblioteca
public abstract class Usuario {
    protected String idUsuario;
    protected String nombre;
    protected  int librosPrestados;

// Constructor que inicializa el ID, nombre y establece los libros prestados a 0
    public Usuario(String idUsuario, String nombre, int librosPrestados) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.librosPrestados = 0;
    }

// Método abstracto que debe ser implementado por las clases hijas para determinar si el usuario puede pedir un libro
    public abstract boolean puedePedir();
    public void registrarPrestamo() { this.librosPrestados++; } // Método para registrar un préstamo, incrementa el contador de libros prestados
    public void devolverLibro() { this.librosPrestados--; } // Método para registrar la devolución de un libro, decrementa el contador de libros prestados
    public String getNombre() { return nombre; }   // Método para obtener el nombre del usuario
}