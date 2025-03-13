import java.util.*;

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
    }
}