import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cantidadPersonas = Metodo.leerEnteroValido("Ingrese la cantidad de personas: ", false, scanner);
        Persona[] personas = new Persona[cantidadPersonas];

        for (int i = 0; i < cantidadPersonas; i++) {
            System.out.println("Ingrese el nombre de la persona " + (i + 1) + ":");
            String nombre = scanner.nextLine();
            int edad = Metodo.leerEnteroValido("Ingrese la edad de la persona:", false, scanner);

            personas[i] = new Persona(nombre, edad); 
        }

        int edadBuscada = Metodo.leerEnteroValido("Ingrese la edad que desea buscar: ", false, scanner);

        int indice = Metodo.findByEdad(personas, edadBuscada);

        if (indice != -1) {
            System.out.println(" La Persona con edad " + personas[indice].getEdad()  + " es " + personas[indice].getNombre());
        } else {
            System.out.println("No se encontró ninguna persona con esa edad.");
        }

        scanner.close();
    }
}
