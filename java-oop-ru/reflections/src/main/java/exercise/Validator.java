package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> result = new ArrayList<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            NotNull notNull= field.getAnnotation(NotNull.class);
            if (notNull != null) {
                try {
                    Field fieldName = address.getClass().getDeclaredField(field.getName());
                    fieldName.setAccessible(true);
                    if (fieldName.get(address) == null) {
                        result.add(field.getName());
                    }
                } catch (NoSuchFieldException | RuntimeException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> result = new HashMap<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            NotNull notNull= field.getAnnotation(NotNull.class);
            MinLength minLength= field.getAnnotation(MinLength.class);
            List<String> resultAnotasion = new ArrayList<>();
            try {
                Field fieldName = address.getClass().getDeclaredField(field.getName());
                fieldName.setAccessible(true);
                int count = 0;
                    if (notNull != null && fieldName.get(address) == null) {
                        resultAnotasion.add("can not be null");
                        count++;
                    }
                    if (minLength != null && fieldName.get(address) != null) {
                        if (fieldName.get(address).toString().length() < minLength.minLength()) {
                            resultAnotasion.add("length less than " + minLength.minLength());
                            count++;
                        }
                    }
                if(count > 0) {
                    result.put(field.getName(), resultAnotasion);
                }
            } catch (NoSuchFieldException | RuntimeException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
// END
