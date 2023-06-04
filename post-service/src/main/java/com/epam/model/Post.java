package com.epam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "post_id", nullable = false)
    private long id;

    @Column(name = "author_id", nullable = false)
    private long authorId;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "topic")
    private String topic;

    @Column(name = "posted_at")
    private Date postedAt;
}
