import java.util.List;
import java.util.TreeSet;

public class PokemonManager {
    private TreeSet<Pokemon> pokemonSet;

    public PokemonManager() {
        this.pokemonSet = new TreeSet<>();
    }

    public void loadPokemonData(String filePath) {
        PokemonFileReader fileReader = new PokemonFileReader();
        List<Pokemon> pokemonList = fileReader.readCSV(filePath);
        pokemonSet.addAll(pokemonList);
    }

    public TreeSet<Pokemon> getPokemonSet() {
        return pokemonSet;
    }
}