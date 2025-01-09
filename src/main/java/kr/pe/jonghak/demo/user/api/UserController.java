package kr.pe.jonghak.demo.user.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class UserController {
    private final UserRepository userRepository;
    private final List<User> users = new ArrayList<>();

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userRepository.save(user);
        log.info("registered user: {}", registeredUser.getName());
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userRepository.findAll();
        log.info("response user list: {}", users);
        return ResponseEntity.ok(users);
    }
}
