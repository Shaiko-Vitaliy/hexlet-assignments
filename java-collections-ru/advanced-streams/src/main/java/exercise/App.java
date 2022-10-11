package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    public static String getForwardedVariables(String line) {
        var result = Arrays.stream(line.split("\n"))
                .filter(x -> x.startsWith("environment"))
                .map(x -> x.substring(13, x.length() -1))
                .flatMap(x -> Arrays.stream(x.split(",")).filter(y -> y.startsWith("X_FORWARDED_")))
                .map(x -> x.replaceAll("X_FORWARDED_", ""))
                .reduce((x1, x2) -> x1 +"," + x2)
                .stream().collect(Collectors.joining());
    return result;
    }
}
//END
