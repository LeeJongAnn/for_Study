package com.memories.springboard.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.management.relation.Role;
import javax.persistence.*;
import java.sql.Timestamp;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 64)
    private String username;

    @Column(nullable = false, length = 256)
    private String password;

    @Column(nullable = false, length = 64)
    private String email;

    @CreationTimestamp
    private Timestamp createTimestamp;

    @ColumnDefault("USER")
    private String role;


    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

}

