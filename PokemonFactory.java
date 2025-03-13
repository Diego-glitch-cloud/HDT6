import java.util.*;

public class PokemonFactory {
    public MapFactory getFactory(int opcion) {
        switch (opcion) {
            case 1:
                return new HashMapFactory();
            case 2:
                return new TreeMapFactory();
            case 3:
                return new LinkedHashMapFactory();
            default:
                throw new IllegalArgumentException("Opción inválida: " + opcion);
        }
    }
}
