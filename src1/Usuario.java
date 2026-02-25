public abstract class Usuario {
    protected String idUsuario;
    protected String nombre;
    protected  int librosPrestados;

    public Usuario(String idUsuario, String nombre, int librosPrestados) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.librosPrestados = 0;
    }

    public abstract boolean puedePedir();
    public void registrarPrestamo() { this.librosPrestados++; }
    public void devolverLibro() { this.librosPrestados--; }
    public String getNombre() { return nombre; }   
}