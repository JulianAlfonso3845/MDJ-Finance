import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MDJFinanceApp {
    public static void main(String[] args) {
        Finanzas finanzas = new Finanzas();
        Usuario perfil = null;
        Scanner scanner = new Scanner(System.in);

        List<Usuario> usuarios = new ArrayList<>();

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese su nombre de usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Ingrese su contraseña: ");
                    String contrasena = scanner.nextLine();
                    Usuario usuario = iniciarSesion(usuarios, nombreUsuario, contrasena);
                    if (usuario != null) {
                        mostrarMenu(usuario, finanzas, perfil, scanner);
                    } else {
                        System.out.println("Nombre de usuario o contraseña incorrectos.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese un nombre de usuario: ");
                    nombreUsuario = scanner.nextLine();
                    System.out.print("Ingrese una contraseña: ");
                    contrasena = scanner.nextLine();
                    usuarios.add(new Usuario(nombreUsuario, contrasena));
                    System.out.println("Registro exitoso. Ahora puede iniciar sesión.");
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static Usuario iniciarSesion(List<Usuario> usuarios, String nombreUsuario, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.verificarContrasena(contrasena)) {
                return usuario;
            }
        }
        return null;
    }

    private static void mostrarMenu(Usuario usuario, Finanzas finanzas, Usuario perfil, Scanner scanner) {
        // Implementa el menú principal aquí
        System.out.println("¡Bienvenido, " + usuario.getNombreUsuario() + "!");
        
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar transacción de Ingreso");
            System.out.println("2. Ingresar transacción de Gasto");
            System.out.println("3. Ver Ahorro Disponible");
            System.out.println("4. Configurar Perfil de Usuario");
            System.out.println("5. Ver estado perfil");
            System.out.println("6. Salir");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad de ingreso: ");
                    double ingreso = Double.parseDouble(scanner.nextLine());
                    finanzas.registrarTransaccion("Ingreso", ingreso);
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad de gasto: ");
                    double gasto = Double.parseDouble(scanner.nextLine());
                    finanzas.registrarTransaccion("Gasto", gasto);
                    break;
                case 3:
                    // Calcula el ahorro disponible
                    double ahorroDisponible = finanzas.calcularAhorroDisponible();
                    System.out.println("Ahorro Disponible: $" + ahorroDisponible);
                    break;
                case 4:
                    System.out.print("Ingrese su nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese su correo: ");
                    String correo = scanner.nextLine();
                    perfil = new Usuario(nombre, correo);
                    break;
                case 5:
                    if (perfil != null) {
                        System.out.println("Perfil de Usuario:");
                        System.out.println("Nombre: " + perfil.getNombre());
                        System.out.println("Correo: " + perfil.getCorreo());
                    } else {
                        System.out.println("No se ha configurado un perfil de usuario.");
                    }
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}
