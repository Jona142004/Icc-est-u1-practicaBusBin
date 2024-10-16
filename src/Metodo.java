import java.util.Scanner;

public class Metodo {

    // Búsqueda binaria 
    public static int findByEdad(Persona[] personas, int edad) {
        ordenarPersonasPorEdad(personas);
        //System.out.println(personas);

        int inicio = 0;
        int fin = personas.length - 1;

        // Búsqueda binaria
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2; // Encontrar el punto medio
                System.out.println();
                System.out.println( "Inicio :" + inicio + "Medio :" + medio + "Fin :" + fin);
            if (personas[medio].getEdad() == edad) {
                return medio; // Devuelve el índice donde se encontró el numero
            }

            if (personas[medio].getEdad() < edad) {
                inicio = medio + 1;
            } else { // Si es mayor, buscar en la mitad izquierda
                fin = medio - 1;
                System.out.println();
                System.out.println("IZQUIERDA");
            }
        }

        return -1; 
    }

    public static void ordenarPersonasPorEdad(Persona[] personas) {
        boolean intercambiado;
        for (int i = 0; i < personas.length - 1; i++) {
            intercambiado = false;
            for (int j = 0; j < personas.length - i - 1; j++) {
                if (personas[j].getEdad() > personas[j + 1].getEdad()) {
                    // Intercambiar
                    Persona aux = personas[j];
                    personas[j] = personas[j + 1];
                    personas[j + 1] = aux;
                    intercambiado = true;
                }
            }
            if (!intercambiado) break;
        }
    }

    public static int leerEnteroValido(String mensaje, boolean permitirNegativo, Scanner scanner) {
        int numero;
        do {
            System.out.println(mensaje);
            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese un entero válido.");
                scanner.next(); 
            }
            numero = scanner.nextInt();
            scanner.nextLine(); 
            if (!permitirNegativo && numero <= 0) {
                System.out.println("El número debe ser mayor a 0.");
            }
        } while (!permitirNegativo && numero <= 0);
        return numero;

    }
    
}
   
