import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MapFactory factory = null;
        PokemonFactory pokemonfactory = new PokemonFactory();
        int option = 0;
        boolean validOption = false;
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("\nSelecciona qué implementación de MAP deseas usar");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        System.out.print("Ingrese el número de la implementación que desea utilizar: ");
            
        option = Integer.parseInt(scanner.nextLine());    

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
        Map<String, Pokemon> pokedex = factory.createMap();

        // Base de datos con todos los pokemon del CSV
        PokemonManager pokemones = new PokemonManager();

        pokemones.loadPokemonData("src/main/resources/pokemon_data.csv");





        boolean salir = false;
        while (!salir) {
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
                    // Agregar un Pokémon a la colección del usuario (pokedex)

                    System.out.print("Ingrese el nombre del Pokémon que desea agregar: ");
                    String pokemonName = scanner.nextLine();
                    
                    // Buscar el Pokémon en el conjunto completo
                    Pokemon pokemonT = null;
                    for (Pokemon p : pokemones.getPokemonSet()) {
                        if (p.getName().toLowerCase().equals(pokemonName.toLowerCase())) {
                            pokemonT = p;
                            break;
                        }
                    }
                    
                    if (pokemonT != null) {
                        // Verificar si ya está en la colección del usuario
                        if (pokedex.containsKey(pokemonName)) {
                            System.out.println("Este Pokémon ya está en tu colección");
                        } else {
                            pokedex.put(pokemonName, pokemonT);
                            System.out.println(pokemonName + " ha sido añadido a tu colección");
                        }
                    } else {
                        System.out.println("Error: El Pokémon " + pokemonName + " no existe en la base de datos");
                    }
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
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor ingrese un número entre 1 y 6");
            }
        }
    }
}