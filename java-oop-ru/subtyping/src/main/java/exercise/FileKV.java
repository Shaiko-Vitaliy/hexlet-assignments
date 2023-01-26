package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage{
    private String filepatch;

    public FileKV(String filepatch, Map<String, String> map) {
        this.filepatch = filepatch;
        Map<String, String> map1 = new HashMap<>(map);
        String setLine = Utils.serialize(map1);
        Utils.writeFile(filepatch, setLine);

    }

    @Override
    public void set(String key, String value) {
        String lineJson = Utils.readFile(filepatch);
        Map<String, String> setMap = Utils.unserialize(lineJson);
        setMap.put(key, value);
        String setLineJson = Utils.serialize(setMap);
        Utils.writeFile(filepatch, setLineJson);
    }

    @Override
    public void unset(String key){
        String lineJson = Utils.readFile(filepatch);
        Map<String, String> unsetMap = Utils.unserialize(lineJson);
        unsetMap.remove(key);
        String unsetLineJson = Utils.serialize(unsetMap);
        Utils.writeFile(filepatch, unsetLineJson);
    }

    @Override
    public String get(String key, String defaultValue) {
        String lineJson = Utils.readFile(filepatch);
        Map<String, String> getMap = Utils.unserialize(lineJson);
        return getMap.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String lineJson = Utils.readFile(filepatch);
        return Utils.unserialize(lineJson);
    }
}
// END
