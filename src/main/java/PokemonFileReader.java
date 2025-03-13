import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class PokemonFileReader {
    public List<Pokemon> readCSV(String filePath) {
        List<Pokemon> pokemonList = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] values;
            csvReader.readNext(); // Saltar la línea de encabezado
            while ((values = csvReader.readNext()) != null) {
                Pokemon pokemon = new Pokemon(
                    values[0], // Name
                    Integer.parseInt(values[1]), // Número Pokedex 
                    values[2], // Type1
                    values[3], // Type2
                    values[4], // Classification
                    Double.parseDouble(values[5]), // Height
                    Double.parseDouble(values[6]), // Weight
                    values[7], // Abilities
                    Integer.parseInt(values[8]), // Generation
                    values[9].equalsIgnoreCase("Yes") // Legendary Status
                );
                pokemonList.add(pokemon);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return pokemonList;
    }
}