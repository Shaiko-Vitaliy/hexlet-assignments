package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag{

    public SingleTag(String nameTag, Map<String, String> mapTag) {
        super(nameTag, mapTag);
    }

    @Override
    public String toString() {
        if (this.getMapTag().isEmpty()){
            return "<" + this.getNameTag() + ">";
        }
        return "<" + this.getNameTag() + " " + super.toString() + ">";
    }
}
// END
