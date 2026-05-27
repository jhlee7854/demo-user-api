package kr.pe.jonghak.demo.user.api;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RestController
@Slf4j
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserCreateRequest userRequest) {
        User userToRegister = new User(
                UUID.randomUUID().toString(),
                userRequest.name().trim(),
                userRequest.email().trim().toLowerCase(Locale.ROOT)
        );
        User registeredUser = userRepository.save(userToRegister);
        log.info("registered userId={}", registeredUser.getId());
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
