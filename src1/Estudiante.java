class Estudiante extends Usuario {
    public Estudiante(String idUsuario, String nombre) { 
        super(idUsuario, nombre, 0); 
    }
    
    @Override
    public boolean puedePedir() {
        return  librosPrestados < 2; 
    }
}