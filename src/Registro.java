import java.util.*;
public class Registro {
    protected String codigo;
    protected String nombre;
    protected String descripcion;
    protected boolean esAlta;

    public Registro(String nombre, String descripcion) {
        this.nombre = nombre;
        this.codigo = UUID.randomUUID().toString();
        this.descripcion = descripcion;
        this.esAlta = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean esAlta() {
        return esAlta;
    }

    public void bajaAlta() {
        this.esAlta = !this.esAlta;
    }

    @Override
    public String toString() {
        return nombre + " - " + descripcion + " - Alta: " + esAlta;
    }
}
