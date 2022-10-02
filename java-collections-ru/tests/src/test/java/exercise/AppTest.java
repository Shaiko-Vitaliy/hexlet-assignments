package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numberExpected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        numberExpected.remove(4);
        numberExpected.remove(3);
        numberExpected.remove(2);
        List<Integer> numberActual = new ArrayList<>(App.take(numberExpected, 2));
        Assertions.assertEquals(numberExpected, numberActual);
        // END
    }
}
