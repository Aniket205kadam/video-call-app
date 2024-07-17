package dev.aniket.VideoCallApp.service;

import dev.aniket.VideoCallApp.Exception.UserException;
import dev.aniket.VideoCallApp.model.User;
import dev.aniket.VideoCallApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public void register(User user) {
//        //email-id is already exist
//        if (repository.findByEmail(user.getEmail()).isPresent()) {
//            throw new UserException("Email Id Is Already Exist.");
//        }
//
//        //username is already exist
//        if (repository.findByUsername(user.getUsername()).isPresent()) {
//            throw new UserException("Username Is Already Taken.");
//        }

        System.out.println("Register");
        user.setStatus("online");
        repository.save(user);
    }

    public User login(User user) {
        Optional<User> existingUser = repository.findByEmail(user.getEmail());

        if (existingUser.isEmpty()) {
            throw new UserException("User Is Not Exist");
        }

        //check the password
        if (!existingUser.get().getPassword().equals(user.getPassword())) {
            throw new UserException("Password Incorrect");
        }
        existingUser.get().setStatus("online");
        repository.save(existingUser.get());
        return existingUser.get();
    }

    public void logout(String email) {
        Optional<User> user = repository.findByEmail(email);

        if (user.isEmpty()) {
            throw new UserException("User Is Not Exist");
        }

        user.get().setStatus("offline");
        //update the status in database
        repository.save(user.get());
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
