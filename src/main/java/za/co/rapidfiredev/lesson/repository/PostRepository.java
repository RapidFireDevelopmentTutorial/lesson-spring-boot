package za.co.rapidfiredev.lesson.repository;

import org.springframework.stereotype.Repository;
import za.co.rapidfiredev.lesson.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
