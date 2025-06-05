import java.util.*;
import java.time.LocalDate;

public class Tarea extends Registro{
    private int estado; // El estado puede ser 0, 1 o 2 (pendiente, en progreso, finalizado)
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Tarea(String nombre, String descripcion, int estado, LocalDate fechaFin) {
        super(nombre,descripcion);
        this.estado = estado; // Tiene que estar dentro de los valores correspondientes.
        this.fechaInicio = LocalDate.now();
        this.fechaFin = fechaFin;

    }

    public Tarea(String nombre, String descripcion, int estado) {
        super(nombre, descripcion);
        this.estado = estado; // Tiene que estar dentro de los valores correspondientes.
        this.fechaInicio = LocalDate.now();
        this.esAlta = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public boolean esAlta()
    {
        return this.esAlta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(int estado) {
        if (estado >= 0 && estado < 4) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException("El estado de la tarea debe ser 0, 1 o 2 (Pendiente, en progreso o finalizado.)");
        }
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void bajaAlta() {
        this.esAlta = false;
    }

    public void subirAlta() {
        this.esAlta = true;
    }

    @Override
    public String toString() {
        String estadoString;
        if (estado == 0) {
            estadoString = "Pendiente";
        } else {
            if (estado == 1) {
                estadoString = "En progreso";
            } else {
                estadoString = "Finalizado";
            }
        }
        return "Tarea [" +
                "código = " + codigo +
                ", nombre = " + nombre +
                ", descripción = " + descripcion +
                ", estado = " + estadoString +
                ", fechaInicio = " + fechaInicio +
                ", fechaFin = " + fechaFin +
                ", esAlta = " + esAlta +
                ']';
    }

}
