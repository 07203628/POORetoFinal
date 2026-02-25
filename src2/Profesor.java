// Clase Profesor que hereda de Usuario
class Profesor extends Usuario {
    public Profesor(String idUsuario, String nombre) { 
        super(idUsuario, nombre, 0); // Llama al constructor de la clase padre Usuario con el id, nombre y 0 libros prestados
    }

// Método que determina si el profesor puede pedir más libros prestados
    @Override
    public boolean puedePedir() {
        return librosPrestados < 5;
    }
}