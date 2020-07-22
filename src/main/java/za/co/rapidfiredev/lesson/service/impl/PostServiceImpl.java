package za.co.rapidfiredev.lesson.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.rapidfiredev.lesson.domain.Post;
import za.co.rapidfiredev.lesson.repository.PostRepository;
import za.co.rapidfiredev.lesson.service.PostService;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPostById(String id) {
        return postRepository.findById(id).get();
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post likePost(String id) {
        Post post = postRepository.findById(id).get();
        //First do
        //post.setLikes(post.getLikes()+1);
        post.addLike();
        return postRepository.save(post);
    }
}
