package exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {
    @Test
    void testAppWithEmptryArrays() {
        String[][] arr = new String[2][2];
        String[][] expected = new String[4][4];
        String[][] actual = App.enlargeArrayImage(arr);
        Assertions.assertArrayEquals(expected, actual);
        assertThat(expected.length).isEqualTo(actual.length);
        assertThat(expected[0].length).isEqualTo(actual[0].length);
    }

    @Test
    void testApp() {
        String[][] arr = {
                {"1", "2"},
                {"3", "4"},
        };
        String[][] expected = {
                {"1", "1", "2", "2"},
                {"1", "1", "2", "2"},
                {"3", "3", "4", "4"},
                {"3", "3", "4", "4"},
        };
        String[][] actual = App.enlargeArrayImage(arr);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testAppRow() {
        String[][] arr = {
                {"1", "2"}
        };
        String[][] expected = {
                {"1", "1", "2", "2"},
                {"1", "1", "2", "2"}
        };
        String[][] actual = App.enlargeArrayImage(arr);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testAppColumn() {
        String[][] arr = {
                {"1"},
                {"1"},
        };
        String[][] expected = {
                {"1", "1"},
                {"1", "1"},
                {"1", "1"},
                {"1", "1"}
        };
        String[][] actual = App.enlargeArrayImage(arr);
        Assertions.assertArrayEquals(expected, actual);
    }


}
// END
