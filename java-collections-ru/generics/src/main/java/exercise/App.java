package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        Map<String, String> resultMap = new HashMap<>();
        List<Map<String, String>> resultList = new ArrayList<>();
        var count = 0;
        for (Map<String, String> book : books) {
            count = 0;
            for (Map.Entry<String, String> oneBook : book.entrySet()) {
                for (Map.Entry<String, String> oneWhere : where.entrySet()) {
                    if (oneBook.getValue().equals(oneWhere.getValue())) {
                        count++;
                    }
                }
            }
            if (count == where.size()) {
                resultList.add(book);
            }
        }
        return resultList;
    }
}
//END
