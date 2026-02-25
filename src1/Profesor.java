class Profesor extends Usuario {
    public Profesor(String idUsuario, String nombre) { 
        super(idUsuario, nombre, 0); 
    }
    
    @Override
    public boolean puedePedir() {
        return librosPrestados < 5;
    }
}