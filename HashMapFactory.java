import java.util.HashMap;
import java.util.Map;

public class HashMapFactory implements MapFactory{
    @Override
    public <K, V> Map<K, V> createMap() {
        return new HashMap<>();
    }
}
