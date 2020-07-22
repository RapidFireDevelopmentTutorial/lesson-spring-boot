package za.co.rapidfiredev.lesson.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.rapidfiredev.lesson.domain.Post;
import za.co.rapidfiredev.lesson.service.PostService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @GetMapping("/post/{id}")
    public Post getPost(String id) {
        return postService.getPostById(id);
    }

    @GetMapping("/post/{id}/like")
    public Post listPost(@PathVariable String id) {
        return postService.likePost(id);
    }

}
