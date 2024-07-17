package dev.aniket.VideoCallApp.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {

    private static final List<User> USER_LIST = new ArrayList<>();

    public void register(User user) {
        user.setStatus("online");
        USER_LIST.add(user);
    }

    public User login(User user) {
        var userIndex = IntStream.range(0, USER_LIST.size())
                .filter(i -> USER_LIST.get(i).getEmail().equals(user.getEmail()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("User Not Found")); //the findAny() method returns an Optional.

        var currUser = USER_LIST.get(userIndex);

        if (!currUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Password Incorrect");
        }

        currUser.setStatus("online");

        return currUser;
    }

    public void logout(String email) {
        System.out.println("Logout: " + email);
        var userIndex = IntStream.range(0, USER_LIST.size())
                .filter(i -> USER_LIST.get(i).getEmail().equals(email))
                .findAny()
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        USER_LIST.get(userIndex).setStatus("offline");
    }

    public List<User> getAllUsers() {
        return USER_LIST;
    }
}

//the var keyword is used to declare local variables with type inference.

//class FindAnyExample {
//    public static void main(String[] args) {
//        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
//
//        Optional<String> anyName = names.stream()
//                .filter(name -> name.startsWith("F"))
//                .findAny();
//
//        anyName.ifPresent(System.out::println);
//    }
//}
