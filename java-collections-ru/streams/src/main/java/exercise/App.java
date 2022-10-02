package exercise;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        var result1 = emails.stream()
                .filter(email -> email.endsWith("yandex.ru"))
                .count();
        var result2 = emails.stream()
                .filter(email -> email.endsWith("gmail.com"))
                .count();
        var result3 = emails.stream()
                .filter(email -> email.endsWith("hotmail.com"))
                .count();
        return result1 + result2 + result3;
    }
}
// END
