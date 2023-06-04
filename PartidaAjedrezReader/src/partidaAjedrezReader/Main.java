package partidaAjedrezReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "partidas_ajedrez.csv";
        PartidaAjedrezReader reader = new PartidaAjedrezReader(filePath);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de linea que desea procesar (empezando desde 1):");

        boolean numeroValido = false;
        do {
            try {
                if (scanner.hasNextInt()) {
                    int numeroLinea = scanner.nextInt();

                    if (numeroLinea < 1) {
                        System.out.println("El numero de linea debe ser mayor o igual a 1.");
                    } else if (numeroLinea != (int) numeroLinea) {
                        System.out.println("El numero de línea no puede contener decimales.");
                    } else {
                        int totalFilas = 20050;

                        if (numeroLinea > totalFilas) {
                            System.out.println("El numero de linea excede el numero total de filas en el archivo.");
                        } else {
                            reader.mostrarInformacionPartida((int) numeroLinea);
                            numeroValido = true;
                        }
                    }
                } else {
                    System.out.println("Debe ingresar un numero y debe ser entero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("El numero de linea ingresado no es valido.");
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado.");
            }

            if (!numeroValido) {
                System.out.println("Ingrese nuevamente el numero de linea:");
                scanner.nextLine(); 
            }
        } while (!numeroValido);

        scanner.close();
    }
}
