package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        MaxThread max = new MaxThread(numbers);
        MinThread min = new MinThread(numbers);
        max.start();
        min.start();
        try {
            max.join();
            min.join();
        } catch (InterruptedException e) {
            System.err.println(e.toString());
        }
        return Map.of("min", min.getMinNum(), "max", max.getMaxNum());
    }
    // END
}
