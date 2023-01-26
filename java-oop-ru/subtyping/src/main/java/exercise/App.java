package exercise;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

    public static void swapKeyValue(KeyValueStorage storage) throws IOException {
        Map<String, String> resMap = new HashMap<>(storage.toMap());
        for (Map.Entry<String, String> item : resMap.entrySet()) {
            storage.unset(item.getKey());
            storage.set(item.getValue(), item.getKey());
        }
    }
}
// END
