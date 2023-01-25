package exercise;

import java.util.*;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int n) {
        var valueElement = Math.min(n, apartments.size());
        return apartments.stream()
                .sorted(Home::compareTo)
                .map(Object::toString)
                .limit(valueElement)
                .toList();
    }
}
// END
