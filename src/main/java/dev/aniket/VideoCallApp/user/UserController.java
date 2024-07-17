package dev.aniket.VideoCallApp.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {
    private final UserService service;

    @PostMapping
    public void register(@RequestBody User user) {
        service.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        System.out.println("Email: " + user.getEmail());
       return service.login(user);
    }

//    @PostMapping("/logout")
//    public void logout(String email) {
//        service.logout(email);
//    }

    @PostMapping("/logout")
    public void logout(@RequestBody User user) {
        service.logout(user.getEmail());
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler(Exception exception) {
        exception.printStackTrace();
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
}
