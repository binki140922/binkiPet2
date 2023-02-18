package jsonTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import jsonTest.model.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;


public class JsonTest {

    ClassLoader classLoader = JsonTest.class.getClassLoader();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void jsonTest() throws IOException {

        try (
                InputStream resource = (classLoader.getResourceAsStream("User.json"));
                InputStreamReader reader = new InputStreamReader(resource);
        ) {
            User user = objectMapper.readValue(reader, User.class);
            assertThat(user.firstName).isEqualTo("Вася");
            assertThat(user.cars.length).isEqualTo(3);

        }
    }
}
