package za.co.rapidfiredev.lesson.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.rapidfiredev.lesson.domain.Post;
import za.co.rapidfiredev.lesson.repository.PostRepository;
import za.co.rapidfiredev.lesson.service.impl.PostServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class PostServiceTest {

    PostRepository postRepository = mock(PostRepository.class);

    PostService postService = new PostServiceImpl(postRepository);


    Post newPost;

    Post savedPost;

    List<Post> savedPosts;

    @BeforeEach
    void setUp() {
        newPost = Post.builder()
                .likes(0)
                .subject("Test Subject")
                .message("Test Message")
                .build();
        savedPost = Post.builder()
                .id("1")
                .likes(0)
                .subject("Test Subject")
                .message("Test Message")
                .build();

        savedPosts = new ArrayList<>();
        savedPosts.add(savedPost);
    }

    @Test
    void addPost() {
        when(postRepository.save(this.newPost)).thenReturn(this.savedPost);

        Post post = postService.addPost(this.newPost);
        assertNotNull(post);
        assertEquals("1", post.getId());
    }

    @Test
    void getPostById() {

        when(postRepository.findById("1")).thenReturn(Optional.of(savedPost));

        Post post = postService.getPostById("1");
        assertNotNull(post);
        assertEquals("1", post.getId());
    }

    @Test
    void getAllPosts() {
        when(postRepository.findAll()).thenReturn(savedPosts);

        List<Post> posts = postService.getAllPosts();
        assertNotNull(posts);
        assertEquals(posts.size(), 1);
        assertEquals(posts.get(0), savedPost);
    }

    @Test
    void addLike() {
        when(postRepository.findById("1")).thenReturn(Optional.of(this.savedPost));
        when(postRepository.save(this.savedPost)).thenReturn(this.savedPost);

        Post post = postService.likePost("1");

        assertNotNull(post);
        assertEquals("1", post.getId());
        assertEquals(1, post.getLikes());

    }

}