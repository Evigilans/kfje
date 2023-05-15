package com.epam.controller;

import com.epam.model.Post;
import com.epam.model.dto.PostDto;
import com.epam.service.PostService;
import com.epam.validation.group.PostCreateValidationGroup;
import com.epam.validation.group.PostUpdateValidationGroup;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/posts")
@Validated
public class PostController {

    private final PostService postService;

    @GetMapping("/{postId}")
    public ResponseEntity<Post> findPostById(@PathVariable long postId) {
        Optional<Post> optionalPost = postService.findPostById(postId);
        return optionalPost.map(post -> ResponseEntity.ok().body(post)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@Validated(PostCreateValidationGroup.class) @RequestBody PostDto postDto) {
        Post post = postService.createPost(postDto);
        return post == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(post);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable long postId, @Validated(PostUpdateValidationGroup.class) @RequestBody PostDto postDto) {
        Post post = postService.updatePost(postId, postDto);
        return post == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(post);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable String postId) {
        postService.deletePostById(postId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity.badRequest().body(errors);
    }
}
