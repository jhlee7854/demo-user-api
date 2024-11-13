package kr.pe.jonghak.demo.user.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private final String id;
    private String name;
    private String email;
}
