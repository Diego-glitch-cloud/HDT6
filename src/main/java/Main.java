import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MapFactory factory = null;
        PokemonFactory pokemonfactory = new PokemonFactory();
        int option = 0;
        boolean validOption = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!validOption) {
            System.out.println("\nSelecciona qué implementación de MAP deseas usar");
            System.out.println("1. HashMap");
            System.out.println("2. TreeMap");
            System.out.println("3. LinkedHashMap");
            System.out.print("Ingrese el número de la implementación que desea utilizar: ");

            try {
                option = Integer.parseInt(scanner.nextLine());

                if (option >= 1 && option <= 3) {
                    validOption = true;
                } else {
                    System.out.println("Error: Opción inválida. Por favor ingrese un número entre 1 y 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número válido.");
            }
        }

        switch (option) {
            case 1:
                System.out.println("Has seleccionado HashMap.");
                break;
            case 2:
                System.out.println("Has seleccionado TreeMap.");
                break;
            case 3:
                System.out.println("Has seleccionado LinkedHashMap.");
                break;
        }
        
        factory = pokemonfactory.getFactory(option);
        Map<String, Pokemon> map = factory.createMap();

        PokemonManager pokemones = new PokemonManager();

        pokemones.loadPokemonData("src/main/resources/pokemon_data.csv");




        
        boolean exit = false;
        while (!exit) {
            System.out.println("\n MENÚ PRINCIPAL ");
            System.out.println("1. Agregar un Pokémon a tu colección");
            System.out.println("2. Mostrar datos de un Pokémon");
            System.out.println("3. Mostrar Pokémon de tu colección ordenados por tipo");
            System.out.println("4. Mostrar todos los Pokémon ordenados por tipo");
            System.out.println("5. Buscar Pokémon por habilidad");
            System.out.println("6. Salir");
            System.out.print("Ingrese el número de la opción deseada: ");

            int menuOpcion = Integer.parseInt(scanner.nextLine());

            switch (menuOpcion) {
                case 1:
                    // Lógica para agregar un Pokémon a la colección
                    break;
                case 2:
                    // Lógica para mostrar datos de un Pokémon
                    break;
                case 3:
                    // Lógica para mostrar Pokémon de la colección ordenados por tipo
                    break;
                case 4:
                    // Lógica para mostrar todos los Pokémon ordenados por tipo
                    break;
                case 5:
                    // Lógica para buscar Pokémon por habilidad

                    break;
                case 6:
                    // Salir del programa
                    exit = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor ingrese un número entre 1 y 6");
            }
        }
    }
}