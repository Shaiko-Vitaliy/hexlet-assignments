package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    private final String nameTag;
    private final Map<String, String> mapTag;

    public Tag(String nameTag, Map<String, String> mapTag) {
        this.nameTag = nameTag;
        this.mapTag = mapTag;
    }

    public String getNameTag() {
        return nameTag;
    }

    public Map<String, String> getMapTag() {
        return mapTag;
    }

    public String toString() {
        if (this.mapTag.isEmpty()) {
            return "";
        }
        StringBuilder build = new StringBuilder();
        for (Map.Entry<String, String> item : getMapTag().entrySet()) {
            build.append(item.getKey()).append("=\"").append(item.getValue()).append("\" ");
        }
        build.delete(build.length() - 1, build.length());
        return build.toString();

    }
}
// END
