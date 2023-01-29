package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;



class ValidationTest {

    @Test
    void testValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        List<String> result1 = Validator.validate(address1);
        List<String> expected1 = List.of();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        List<String> result2 = Validator.validate(address2);
        List<String> expected2 = List.of("country");
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("USA", null, null, null, "1");
        List<String> result3 = Validator.validate(address3);
        List<String> expected3 = List.of("city", "street", "houseNumber");
        assertThat(result3).isEqualTo(expected3);
    }

    // BEGIN
    @Test
    void testAdvencadValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        Map<String, List<String>> expectedMap1 = Map.of("city", List.of("length less than 4"));
        Map<String, List<String>> resultMap1 = Validator.advancedValidate(address1);
        assertThat(resultMap1).isEqualTo(expectedMap1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        Map<String, List<String>> expectedMap2 = Map.of("country", List.of("can not be null"));
        Map<String, List<String>> resultMap2 = Validator.advancedValidate(address2);
        assertThat(resultMap2).isEqualTo(expectedMap2);

        Address address3 = new Address("USA", null, null, null, "1");
        Map<String, List<String>> expectedMap3 = Map.of("country", List.of("length less than 4"),
                "city", List.of("can not be null"), "street", List.of("can not be null"),
                "houseNumber", List.of("can not be null"));
        Map<String, List<String>> resultMap3 = Validator.advancedValidate(address3);
        assertThat(resultMap3).isEqualTo(expectedMap3);
    }
    // END
}
