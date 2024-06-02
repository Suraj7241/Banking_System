package com.Banking.Model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    
    @OneToMany(mappedBy = "user")
    private List<Account> accounts;

    // getters and setters
}
