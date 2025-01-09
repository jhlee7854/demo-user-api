package kr.pe.jonghak.demo.user.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("users")
public class User {
    @Id
    private final String id;
    private String name;
    private String email;
}
