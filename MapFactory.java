
import java.util.*;

public interface MapFactory {
    <K, V> Map<K, V> createMap();
}