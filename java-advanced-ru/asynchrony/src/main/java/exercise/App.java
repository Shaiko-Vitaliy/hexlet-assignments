package exercise;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CompletionException;

class App {

    // BEGIN
    private static Path getFullPath(String path) {
        return Paths.get(path).toAbsolutePath().normalize();
    }

    public static CompletableFuture<String> unionFiles(String source1, String source2, String output) throws Exception {
        CompletableFuture<String> firstSourceData = CompletableFuture.supplyAsync(() -> {
            String lines;
            try {
                lines = Files.readString(getFullPath(source1));
            } catch (IOException e) {
                throw new CompletionException(e);
            }
            return lines;
        });

        CompletableFuture<String> secondSourceData = CompletableFuture.supplyAsync(() -> {
            String lines;
            try {
                lines = Files.readString(getFullPath(source2));
            } catch (IOException e) {
                throw new CompletionException(e);
            }
            return lines;
        });

        return firstSourceData.thenCombine(secondSourceData, (first, second) -> {
            String joinedData = String.join(" ", first, second);
            byte[] strToBytes = joinedData.getBytes();
            try {
                Files.write(getFullPath(output), strToBytes);
            } catch (Exception e) {
                throw new CompletionException(e);
            }
            return joinedData;
        }).exceptionally(e -> {
            System.out.println("Something went wrong - " + e.getMessage());
            return e.getMessage();
        });
    }

    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> result = App.unionFiles("src/main/resources/file1.txt", "src/main/resources/file2.txt",
                "src/main/resources/resultFile.txt");
        System.out.println(result.get());
        // END
    }
}

