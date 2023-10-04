import java.util.Scanner;

public class PruebaLista {

    public static void main(String[] args) {
        Lista miLista = new Lista();
        Scanner scanner = new Scanner(System.in);

        // Insertar algunos elementos iniciales
        miLista.insertarAlFrente(1);
        miLista.insertarAlFrente(2);
        miLista.insertarAlFinal(3);
        miLista.insertarAlFinal(4);
        miLista.insertarAlFrente(1);
        miLista.insertarAlFrente(2);
        miLista.insertarAlFinal(3);
        miLista.insertarAlFinal(4);
        miLista.insertarAlFinal(3);
        miLista.insertarAlFinal(4);

        // Imprimir la lista antes de la inserción
        System.out.println("Lista antes de la inserción:");
        miLista.imprimir();

        do {
            // Pedir al usuario la posición y el elemento a insertar
            System.out.print("Ingrese la posición donde desea insertar: ");
            int posicion = scanner.nextInt();

            System.out.print("Ingrese el elemento que desea insertar: ");
            int elemento = scanner.nextInt();

            // Insertar el elemento en la posición especificada
            miLista.insertarEnPosicion(elemento, posicion);

            // Imprimir la lista después de la inserción
            System.out.println("Lista después de la inserción:");
            miLista.imprimir();

            // Consumir la línea en blanco
            scanner.nextLine();

            System.out.print("¿Desea terminar? (Si/No): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("Si")) {
                break;
            }
        } while (true);
    }
}
