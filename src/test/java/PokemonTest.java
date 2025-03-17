import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class PokemonTest {
    
    private Map<String, Pokemon> pokedex;
    private PokemonManager pokemones;
    private MapFactory factory;
    private Pokemon bulbasaur;
    private Pokemon charmander;
    private Pokemon squirtle;
    
    @Before
    public void setUp() {
        factory = new HashMapFactory();
        pokedex = factory.createMap(); // utiliza como default HashMap
        pokemones = new PokemonManager();
        
        
        // Crear algunos Pokémon de prueba
        bulbasaur = new Pokemon("Bulbasaur", 1, "Grass", "Poison", "Seed Pokémon", 0.7, 6.9, "Overgrow, Chlorophyll", 1, false);
        charmander = new Pokemon("Charmander", 4, "Fire", "", "Lizard Pokémon", 0.6, 8.5, "Blaze, Solar-power", 1, false);
        squirtle = new Pokemon("Squirtle", 7, "Water", "", "Tiny Turtle Pokémon", 0.5, 9.0, "Torrent, Rain-dish", 1, false);
        
        // Añadir a la pokedex
        pokedex.put(bulbasaur.getName(), bulbasaur);
        pokedex.put(charmander.getName(), charmander);
        pokedex.put(squirtle.getName(), squirtle);
    } // Before como parámetros iniciales de las prubeas por https://claude.ai/
    
    @Test
    public void testPokemonSearch() {
        // Prueba buscar un Pokémon por nombre
        Pokemon foundPokemon = pokedex.get("Bulbasaur");
        assertNotNull("El Pokémon Bulbasaur debería encontrarse en la pokedex", foundPokemon);
        assertEquals("El tipo primario debería ser Grass", "Grass", foundPokemon.getType1());
        
        // Prueba buscar un Pokémon que no existe
        Pokemon notFound = pokedex.get("Mewtwo");
        assertNull("El Pokémon Mewtwo no debería encontrarse en la pokedex", notFound);
    }
    
    @Test
    public void testPokemonCompareTo() {
        // Prueba que el método compareTo funcione correctamente para ordenar por tipo
        // Fire viene antes que Grass en orden alfabético
        assertTrue(charmander.compareTo(bulbasaur) < 0);
        assertTrue(bulbasaur.compareTo(charmander) > 0);

        // Mismo pokémon debería ser igual
        assertEquals(0, bulbasaur.compareTo(bulbasaur));

        // Pokémon con mismo tipo pero diferente nombre
        Pokemon ivysaur = new Pokemon("Ivysaur", 2, "Grass", "Poison", "Seed Pokémon", 1.0, 13.0,
                "Overgrow, Chlorophyll", 1, false);
        assertTrue(bulbasaur.compareTo(ivysaur) < 0); // Bulbasaur viene antes que Ivysaur alfabéticamente
    }
    
}