package exercise;

import java.io.IOException;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();
    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);

    }


    // BEGIN
    @Test
    public void fileKVTest() throws IOException {
        String patch = "src/test/resources/file";
        Map<String, String> actual = new HashMap<>(Map.of(
                "key", "val",
                "key2", "val2",
                "key3", "val3"));
        KeyValueStorage stor = new FileKV(patch, actual);
        assertThat(stor.toMap()).isEqualTo(actual);
        actual.put("key4", "val4");
        stor.set("key4", "val4");
        assertThat(stor.get("key4", "default")).isEqualTo(actual.get("key4"));
        actual.remove("key4");
        stor.unset("key4");
        assertThat(stor.toMap()).isEqualTo(actual);
    }
}
