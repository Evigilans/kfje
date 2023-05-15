package com.epam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "amount_of_posts")
    private int amountOfPosts;
}
