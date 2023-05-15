package com.epam.repository;

import com.epam.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post, String> {
    Optional<Post> findById(long id);
}
