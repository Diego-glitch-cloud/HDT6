import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public List<Pokemon> readCSV(String filePath) {
        // ArrayList de pokemons
        List<Pokemon> pokemonList = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            br.readLine(); // Saltar el titulo de las columnas
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Pokemon pokemon = new Pokemon(
                    values[0], // Name
                    Integer.parseInt(values[1]), // Número Pokedex / convierte string en entero
                    values[2], // Type1
                    values[3], // Type2
                    values[4], // Classification
                    Double.parseDouble(values[5]), // Height / convierte string en Double
                    Double.parseDouble(values[6]), // Weight
                    values[7], // Abilities
                    Integer.parseInt(values[8]), // Generation
                    values[9].equalsIgnoreCase("Yes") // Legendary Status
                );
                // Cada fila es un pokemon que se agrega al Arraylist de pokemones
                pokemonList.add(pokemon);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pokemonList;
    }
}