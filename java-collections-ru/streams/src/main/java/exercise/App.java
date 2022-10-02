package exercise;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// BEGIN
class App {
    private static List<String> FREE_DOMAIN = Arrays.asList(
            "gmail.com", "yandex.ru", "hotmail.com");
    public static long getCountOfFreeEmails(List<String> emails) {
        return emails.stream()
                .map(email -> email.split("@")[1])
                .filter(FREE_DOMAIN :: contains)
                .count();
    }
}
// END
