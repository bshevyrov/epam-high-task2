package ua.com.company.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.com.company.model.Post;
import ua.com.company.repository.PostRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostServiceImpl postService;

    private Post post;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        post = new Post();
        post.setId(1L);
        post.setContent("Test content");
    }

    @Test
    void testCreatePost() {
        when(postRepository.save(post)).thenReturn(post);

        Post createdPost = postService.createPost(post);
        assertNotNull(createdPost);
        assertEquals(post.getContent(), createdPost.getContent());
    }

    @Test
    void testGetPostById() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));

        Optional<Post> foundPost = postService.getPostById(1L);
        assertTrue(foundPost.isPresent());
        assertEquals(post.getContent(), foundPost.get().getContent());
    }

    @Test
    void testGetPostsByUserId() {
        List<Post> posts = Arrays.asList(post);
        when(postRepository.findByUserId(1L)).thenReturn(posts);

        List<Post> foundPosts = postService.getPostsByUserId(1L);
        assertFalse(foundPosts.isEmpty());
        assertEquals(1, foundPosts.size());
        assertEquals(post.getContent(), foundPosts.get(0).getContent());
    }

    @Test
    void testUpdatePost() {
        when(postRepository.existsById(1L)).thenReturn(true);
        when(postRepository.save(post)).thenReturn(post);

        Post updatedPost = postService.updatePost(1L, post);
        assertNotNull(updatedPost);
        assertEquals(post.getContent(), updatedPost.getContent());
    }

    @Test
    void testDeletePost() {
        doNothing().when(postRepository).deleteById(1L);

        postService.deletePost(1L);
        verify(postRepository, times(1)).deleteById(1L);
    }
}