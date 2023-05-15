package com.epam.service;

import com.epam.client.UserClient;
import com.epam.model.Post;
import com.epam.model.dto.PostDto;
import com.epam.model.dto.UserDto;
import com.epam.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final UserClient userClient;

    public Optional<Post> findPostById(long postId) {
        return postRepository.findById(postId);
    }

    public Post createPost(PostDto postDto) {
        Post post = null;

        UserDto author = userClient.findUserById(postDto.getAuthorId());
        if (author != null) {
            post = new Post();
            post.setAuthorId(postDto.getAuthorId());
            post.setText(postDto.getText());
            post.setPostedAt(new Date());
            post = postRepository.save(post);

            author.setAmountOfPosts(author.getAmountOfPosts() + 1);
            userClient.updateUser(author.getId(), author);
        }

        return post;
    }

    public Post updatePost(long postId, PostDto postDto) {
        Post updatedPost = null;

        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            updatedPost = optionalPost.get();
            updatedPost.setAuthorId(postDto.getAuthorId());
            updatedPost.setText(postDto.getText());
            updatedPost.setPostedAt(new Date());
        }

        return updatedPost;
    }

    public void deletePostById(String postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            postRepository.deleteById(postId);

            UserDto author = userClient.findUserById(optionalPost.get().getAuthorId());
            if (author != null) {
                author.setAmountOfPosts(author.getAmountOfPosts() - 1);
                userClient.updateUser(author.getId(), author);
            }
        }
    }
}
