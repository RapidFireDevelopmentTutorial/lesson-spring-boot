package za.co.rapidfiredev.lesson.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.rapidfiredev.lesson.domain.Post;
import za.co.rapidfiredev.lesson.repository.PostRepository;
import za.co.rapidfiredev.lesson.service.impl.PostServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PostServiceIntTest {

    @Autowired
    private PostService postService;

    Post newPost;

    Post savedPost;

    List<Post> savedPosts;

    @BeforeEach
    void setUp() {
        newPost = Post.builder()
                .id("1")
                .likes(0)
                .subject("Test Subject")
                .message("Test Message")
                .build();


        savedPosts = new ArrayList<>();
        savedPosts.add(newPost);
    }

    @Test
    void addPost() {

        Post post = postService.addPost(this.newPost);
        assertNotNull(post);
        assertEquals("1", post.getId());
    }

    @Test
    void getPostById() {
        postService.addPost(this.newPost);
        Post post = postService.getPostById("1");
        assertNotNull(post);
        assertEquals("1", post.getId());
    }

    @Test
    void getAllPosts() {
        postService.addPost(this.newPost);
        List<Post> posts = postService.getAllPosts();
        assertNotNull(posts);
        assertEquals(posts.size(), 1);
        assertEquals(posts.get(0), newPost);
    }

    @Test
    void addLike() {
        postService.addPost(this.newPost);
        Post post = postService.likePost("1");
        assertNotNull(post);
        assertEquals("1", post.getId());
        assertEquals(1, post.getLikes());

    }

}