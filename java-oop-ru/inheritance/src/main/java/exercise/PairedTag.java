package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag{
    private final String bodyTag;
    private final List<Tag> childrenTag;

    public PairedTag(String nameTag, Map<String, String> mapTag, String bodyTag, List<Tag> childrenTag) {
        super(nameTag, mapTag);
        this.bodyTag = bodyTag;
        this.childrenTag = childrenTag;
    }

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append("<").append(this.getNameTag())
                .append(this.getMapTag().isEmpty() ? "" : " ")
                .append(super.toString()).append(">").append(this.bodyTag);
        for (Tag item : this.childrenTag) {
            build.append(item.toString());
        }
        build.append("</").append(this.getNameTag()).append(">");
        return build.toString() ;
    }

    //"<p class=\"m-10\" id=\"10\" lang=\"en\">Text paragraph</p>";
    // <div lang=\"ru\" id=\"abc\"><br id=\"s\">"bodyTAG"<hr class=\"a-5\"></div>
}
// END
