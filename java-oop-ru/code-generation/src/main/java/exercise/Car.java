package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

// BEGIN
@Value
//@AllArgsConstructor
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return objectMapper.writeValueAsString(this);
    }

    public static Car unserialize(String line) throws IOException {
        Car car;
        ObjectMapper objectMapper = new ObjectMapper();
        car = objectMapper.readValue(line, Car.class);
        return car;
    }
    // END
}
