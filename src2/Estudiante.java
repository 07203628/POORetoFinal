// Clase Estudiante que hereda de Usuario
class Estudiante extends Usuario {
    public Estudiante(String idUsuario, String nombre) { 
        super(idUsuario, nombre, 0); // Llama al constructor de la clase padre Usuario con el id, nombre y 0 libros prestados
    }

// Método que determina si el estudiante puede pedir más libros (máximo 2)
    @Override
    public boolean puedePedir() {
        return  librosPrestados < 2; // El estudiante puede pedir un libro si tiene menos de 2 libros prestados
    }
}