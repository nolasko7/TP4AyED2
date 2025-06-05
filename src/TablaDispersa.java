import java.lang.*;
import java.util.*;

public class TablaDispersa {
    private List<Registro> registro;
    private int numElem;
    private double factorCarga;
    private static final int size = 101;

    public TablaDispersa () {
        registro = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            registro.add(null);
        }
        numElem = 0;
    }

    public boolean insertar (Registro t) {
        if (numElem >= size) {
            return false;
        }

        int base = calcularPosicion(t.getCodigo());
        int posicion = base;
        int i = 0;

        while (registro.get(posicion) != null && registro.get(posicion).esAlta()) {
            i++;
            if (i >= registro.size()) return false;
            posicion = resolverColision(base, i);
        }

        registro.set(posicion,t);
        numElem++;

        return true;
    }

    public Registro buscar (String codigo) {
        int base = calcularPosicion(codigo);
        int posicion = base;
        int i = 0;
        Registro t;

        while (i < size) {
            posicion = resolverColision(base, i);
            t = registro.get(posicion);

            if (t == null) return null;
            if (t.getCodigo().equals(codigo) && t.esAlta()) return t;

            i++;
        }
        return null;

    }

    public boolean eliminar (String codigo) {
        int base = calcularPosicion(codigo);
        int posicion = base;
        int i = 0;

        while (i < size) {
            posicion = resolverColision(base, i);

            if (registro.get(posicion) == null) return false;
            if (registro.get(posicion).getCodigo().equals(codigo) && registro.get(posicion).esAlta()) {
                registro.get(posicion).bajaAlta();
                return true;
            }

            i++;
        }
        return false;
    }

    public int calcularPosicion (String codigo) {
        double A = 0.6180339887; // Constante para el método de multiplicación
        double valor = obtenerValorNumerico(codigo);
        double producto = valor * A;
        double decimal = producto - Math.floor(producto);

        return (int)(decimal * 101);
    }

    private double obtenerValorNumerico (String codigo) {
        UUID id = UUID.fromString(codigo);
        return Math.abs(id.getMostSignificantBits() ^ id.getLeastSignificantBits());
    }

    public int resolverColision (int posicion, int i) {
        return (posicion + i * i) % 101;
    }

    public double calcularFactorCarga() {
        return (double) numElem / 101;
    }

    public void mostrarTabla () {
        System.out.println("La tabla contiene:");
        for (int i = 0; i < size; i++) {
            if (registro.get(i) != null && registro.get(i).esAlta()) {
                System.out.println("Indice = " + i + " - " + registro.get(i));
            }
        }
    }
    public Registro getRegistro(int pos) {
        return registro.get(pos);
    }

    public int getNumElem() {
        return numElem;
    }

}
