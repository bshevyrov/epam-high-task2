package ua.com.company.service;

import ua.com.company.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post createPost(Post post);
    Optional<Post> getPostById(Long id);
    List<Post> getPostsByUserId(Long userId);
    Post updatePost(Long id, Post post);
    void deletePost(Long id);
}