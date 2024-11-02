package com.programming.techie.springredditclone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.Instant;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
//@Getter
//@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @NotBlank(message = "Post Name cannot be empty or Null")
    private String postName;
    @Nullable
    private String url;
    @Nullable
    @Lob
    private String description;
    private Integer voteCount;
    @ManyToOne(fetch = FetchType.LAZY) // many posts from 1 user
    @JoinColumn(name = "userId", referencedColumnName = "userId") // User.userId -> Post.userId
    private User user;
    private Instant createdDate;
    @ManyToOne(fetch = LAZY) // many subreddits from 1 user
    @JoinColumn(name = "id", referencedColumnName = "id") // User.userId -> Subreddit.id
    private Subreddit subreddit;
}