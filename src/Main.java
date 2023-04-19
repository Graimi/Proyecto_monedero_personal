
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce tu nombre:");
        String nombre = sc.nextLine();

        System.out.println("Introduce tu edad:");
        int edad = sc.nextInt();
        sc.nextLine();

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEdad(edad);
        

        boolean dniCorrecto = false;
        while (!dniCorrecto) {
            System.out.println("Introduce tu DNI:");
            String DNI = sc.nextLine();
            dniCorrecto = usuario.setDNI(DNI);
            if (!dniCorrecto) {
                System.out.println("DNI incorrecto. Inténtalo de nuevo.");
            }
        }

        Cuenta cuenta = new Cuenta(usuario);

        boolean salir = false;
        while (!salir) {
            System.out.println("Elige una opción:");
            System.out.println("1. Añadir ingreso");
            System.out.println("2. Añadir gasto");
            System.out.println("3. Ver ingresos");
            System.out.println("4. Ver gastos");
            System.out.println("5. Ver saldo");
            System.out.println("6. Salir");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce la cantidad del ingreso:");
                    double cantidadIngreso = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Introduce la descripción del ingreso:");
                    String descripcionIngreso = sc.nextLine();
                    cuenta.addIngresos(descripcionIngreso, cantidadIngreso);
                    break;
                case 2:
                    System.out.println("Introduce la cantidad del gasto:");
                    double cantidadGasto = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Introduce la descripción del gasto:");
                    String descripcionGasto = sc.nextLine();
                    try {
                        cuenta.addGastos(descripcionGasto, cantidadGasto);
                    } catch (GastoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    for (Ingreso i : cuenta.getIngresos()) {
                        System.out.println(i);
                    }
                    break;
                case 4:
                    for (Gasto g : cuenta.getGastos()) {
                        System.out.println(g);
                    }
                    break;
                case 5:
                    System.out.println(cuenta.getSaldo());
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
        sc.close();
        System.out.println("Fin del programa.");
        System.out.println("Gracias por utilizar la aplicación de M03B en el curso 2s2223.");
    }

}
