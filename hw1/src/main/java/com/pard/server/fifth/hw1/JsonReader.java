package com.pard.server.fifth.hw1;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import java.io.InputStream;
import java.util.List;

public class JsonReader {
    public static List<User> readUsersFromFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new ClassPathResource("data/users.json").getInputStream();
            return mapper.readValue(inputStream, new TypeReference<List<User>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
