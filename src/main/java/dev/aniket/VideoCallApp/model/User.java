package dev.aniket.VideoCallApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

//@Data
//@Builder
//public class User {
//    private String username;
//    private String email;
//    private String password;
//    private String status;
//
//}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    @NotEmpty
    private String username;

    @Column(unique = true)
    @Email
    private String email;

    @Size(min = 8)
    private String password;

    @NotEmpty
    private String status;

    public User(String username, String email, String password, String status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
    }
}
