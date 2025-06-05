import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numEntrada = 0;
        int numIngreso = 0;
        Scanner input = new Scanner(System.in);
        TablaDispersa tabla = new TablaDispersa();
        String nombre = "";
        String descripcion = "";
        String codigo = "";
        String color = "";
        int estado = 0;

        boolean valido;

        do {
            System.out.println("==============MENU DE REGISTRO==============");
            System.out.println();
            System.out.println("1. Ingresar tarea (registro).");
            System.out.println("2. Ingresar notita (registro).");
            System.out.println("3. Buscar una registro.");
            System.out.println("4. Eliminar una registro.");
            System.out.println("5. Mostrar la tabla de registros.");
            System.out.println("6. Salir.");
            do {
                valido = false;
                try {
                    numEntrada = input.nextInt();
                    valido = true;
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese un valor entre 1 y 5");
                    input.nextLine();
                }
            } while (!valido);
            input.nextLine();

            switch (numEntrada) {
                case 1:
                    limpiarConsola();
                    do {
                        valido = true;
                        try {
                            System.out.println("Ingrese el numero de tareas a ingresar: ");
                            numIngreso = input.nextInt();
                            if (numIngreso < 0 || numIngreso > 101) {
                                throw new IllegalArgumentException("Solo pueden haber 101 registros como maximo.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Debe ingresar el numero de tareas.");
                            input.nextLine();
                            valido = false;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            valido = false;
                        }
                    } while(!valido);
                    input.nextLine();

                    for (int i = 0; i < numIngreso; i++) {
                        limpiarConsola();
                        System.out.println("Ingrese el nombre de la tarea (Numero "+ (i+1) + " ): ");
                        nombre = input.nextLine();
                        System.out.println("Ingrese la descripcion de la tarea: ");
                        descripcion = input.nextLine();
                        do {
                            valido = true;
                            try {
                                System.out.println("Ingrese el estado de la tarea: ");
                                estado = input.nextInt();
                                if (estado < 0 || estado > 2) {
                                    throw new IllegalArgumentException("El estado debe estar entre los valores 0 y 2.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Ingrese un valor entero entre 0 y 2");
                                input.nextLine();
                                valido = false;
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                                valido = false;
                            }
                        } while (!valido);
                        input.nextLine();

                        Tarea t1 = new Tarea(nombre,descripcion,estado);
                        tabla.insertar(t1);
                        limpiarConsola();
                    }
                    break;
                case 2:
                    limpiarConsola();
                    do {
                        valido = true;
                        try {
                            System.out.println("Ingrese el numero de notitas a ingresar: ");
                            numIngreso = input.nextInt();
                            if (numIngreso < 0 || numIngreso > 101) {
                                throw new IllegalArgumentException("Solo pueden haber 101 registros como maximo.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Debe ingresar el numero de tareas.");
                            input.nextLine();
                            valido = false;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            valido = false;
                        }
                    } while(!valido);
                    input.nextLine();

                    for (int i = 0; i < numIngreso; i++) {
                        limpiarConsola();
                        System.out.println("Ingrese el nombre de la notita (Numero "+ (i+1) + " ): ");
                        nombre = input.nextLine();
                        System.out.println("Ingrese la descripcion de la notita: ");
                        descripcion = input.nextLine();
                        System.out.println("Ingrese el color de la notita: ");
                        color = input.nextLine();
                        Notita t1 = new Notita(nombre,descripcion,color);
                        tabla.insertar(t1);
                        limpiarConsola();
                    }
                    break;
                case 3:
                    limpiarConsola();
                    System.out.println("Ingrese el codigo del registro que desea buscar: ");
                    codigo = input.nextLine();
                    limpiarConsola();
                    Registro t1 = tabla.buscar(codigo);
                    if (t1 != null) {
                        System.out.println(t1.toString());
                    } else {
                        System.out.println("El registro con el codigo " + codigo + " no existe.");
                    }
                    break;
                case 4:
                    limpiarConsola();
                    System.out.println("Ingrese el codigo del registro a eliminar: ");
                    codigo = input.nextLine();
                    limpiarConsola();
                    if (tabla.eliminar(codigo)) {
                        System.out.println("El registro con el codigo " + codigo + " se ha eliminado correctamente.");
                    } else {
                        System.out.println("El registro con el codigo " + codigo + "no existe o ya fue eliminada.");
                    }
                    break;
                case 5:
                    limpiarConsola();
                    tabla.mostrarTabla();
                    System.out.println("Presione ENTER para continuar.");
                    input.nextLine();
                    limpiarConsola();
                    break;
            }

        } while (numEntrada > 0 && numEntrada < 6);
    }
    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}