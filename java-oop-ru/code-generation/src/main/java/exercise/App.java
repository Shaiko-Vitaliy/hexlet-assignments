package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

// BEGIN
public class App {
    public static void save(Path path, Car car) throws IOException {
        String lineJson = car.serialize();
        Files.write(path, lineJson.getBytes());
    }

    public static Car extract(Path path) throws IOException {
        String lineFromFile = readFile(path);
        return Car.unserialize(lineFromFile);
    }

    public static String readFile(Path path) throws IOException {
        return Files.readString(path);
    }
}
// END
