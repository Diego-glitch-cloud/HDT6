import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MapFactory factory = null;
        PokemonFactory pokemonfactory = new PokemonFactory();
        int option = 0;
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
                            pokedex.put(pokemonName.toLowerCase(), pokemonT);
                            System.out.println(pokemonName + " ha sido añadido a tu colección");
                        }
                    } else {
                        System.out.println("Error: El Pokémon " + pokemonName + " no existe en la base de datos");
                    }
                    break;
                case 2:
                    // Mostrar datos de un Pokémon

                    System.out.print("Ingrese el nombre del Pokémon: ");
                    String pokemonToShow = scanner.nextLine();

                    Pokemon pokemon = pokedex.get(pokemonToShow.toLowerCase());
                    if (pokemon != null) {
                        System.out.println("\nDatos del Pokémon:");
                        System.out.println("Nombre: " + pokemon.getName());
                        System.out.println("Número en la Pokédex: " + pokemon.getPokedexNumber());
                        System.out.println("Tipo 1: " + pokemon.getType1());
                        System.out.println("Tipo 2: " + (pokemon.getType2().isEmpty() ? "N/A" : pokemon.getType2()));
                        System.out.println("Clasificación: " + pokemon.getClassification());
                        System.out.println("Altura: " + pokemon.getHeight() + " m");
                        System.out.println("Peso: " + pokemon.getWeight() + " kg");
                        System.out.println("Habilidades: " + pokemon.getAbilities());
                        System.out.println("Generación: " + pokemon.getGeneration());
                        System.out.println("Legendario: " + (pokemon.isLegendaryStatus() ? "Sí" : "No"));
                    } else {
                        System.out.println("Error: El Pokémon " + pokemonToShow
                                + " no está en tu colección. Primero agrégalo con la opción 1");
                    }
                    break;
                case 3:
                    // Mostrar Pokémon de la colección del usuario ordenados por tipo
                    if (pokedex.isEmpty()) {
                        System.out.println("Tu colección está vacía");
                    } else {
                        System.out.println("\nTu colección de Pokémon ordenada por tipo:");
                        System.out.println("-------------------------------------");
                        System.out.printf("%-15s %-10s\n", "Nombre", "Tipo 1");
                        System.out.println("-------------------------------------");
                        // Formato de Impresión por Claude https://claude.ai/

                        // Convertir el Map a List para ordenar por tipo (Map en JCF no tiene método sort)
                        List<Pokemon> userPokemon = new ArrayList<>(pokedex.values());
                        userPokemon.sort(Comparator.comparing(Pokemon::getType1));

                        for (Pokemon p : userPokemon) {
                            System.out.printf("%-15s %-10s\n", p.getName(), p.getType1());
                        }
                    }
                    break;
                case 4:
                    // Mostrar todos los Pokémon ordenados por tipo

                    System.out.println("\nTodos los Pokémon ordenados por tipo:");
                    System.out.println("-------------------------------------");
                    System.out.printf("%-15s %-10s\n", "Nombre", "Tipo 1");
                    System.out.println("-------------------------------------");
                    // Formato de Impresión por Claude https://claude.ai/

                    // El TreeSet ya está ordenado por tipo1
                    for (Pokemon p : pokemones.getPokemonSet()) {
                        System.out.printf("%-15s %-10s\n",
                                p.getName(),
                                p.getType1());
                    }
                    break;
                case 5:
                    // Buscar Pokémon por habilidad
                    System.out.print("Ingrese la habilidad que desea buscar: ");
                    String ability = scanner.nextLine().toLowerCase();

                    System.out.println("\nPokémon con la habilidad " + ability + ":");
                    System.out.println("-------------------------------------");

                    boolean foundPokemon = false;
                    for (Pokemon p : pokemones.getPokemonSet()) {
                        if (p.getAbilities().toLowerCase().contains(ability)) {
                            System.out.println(p.getName());
                            foundPokemon = true;
                        }
                    }

                    if (!foundPokemon) {
                        System.out.println("No se encontraron Pokémon con esa habilidad");
                    }
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
        scanner.close();
    }
}