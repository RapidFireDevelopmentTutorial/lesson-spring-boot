package za.co.rapidfiredev.lesson.service;

import za.co.rapidfiredev.lesson.domain.Post;

import java.util.List;

public interface PostService {

    Post addPost(Post post);

    Post getPostById(String id);

    List<Post> getAllPosts();

    Post likePost(String id);

}
