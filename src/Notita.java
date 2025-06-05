public class Notita extends Registro {
    private String color;

    public Notita(String nombre, String descripcion, String color) {
        super(nombre, descripcion);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    @Override
    public String toString() {
        return "Notita [codigo = " + codigo + ", nombre = " + nombre + ", descripcion = " + descripcion + ", color = " + color;
    }
}
