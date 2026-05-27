package kr.pe.jonghak.demo.user.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class UserController {
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User userToRegister = new User(UUID.randomUUID().toString(), user.getName(), user.getEmail());
        User registeredUser = userRepository.save(userToRegister);
        log.info("registered user: {}", registeredUser.getName());
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        log.warn("blocked unauthenticated request to list all users");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
