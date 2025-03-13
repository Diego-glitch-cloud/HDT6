import java.util.Map;

public interface MapFactory {
    <K, V> Map<K, V> createMap();
}