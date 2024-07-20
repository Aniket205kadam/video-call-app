package dev.aniket.VideoCallApp.controller;

import dev.aniket.VideoCallApp.model.User;
import dev.aniket.VideoCallApp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {
//    private final UserServiceInMemory service;
    private final UserService service;

    @PostMapping
    public void register(@RequestBody User user) {
        log.info("Register endpoint was called");
        service.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        log.info("login endpoint was called");
        log.info("login email is " + user.getEmail());
       return service.login(user);
    }

    @PostMapping("/logout")
    public void logout(@RequestBody User user) {
        log.info("logout endpoint was called");
        service.logout(user.getEmail());
    }

    @GetMapping
    public List<User> getAllUsers() {
        log.info("getAllUsers endpoint was called");
        return service.getAllUsers();
    }

    @GetMapping("/{username}")
    public List<User> getUser(@PathVariable String username) {
        System.out.println(username);
        return null;
    }
}
