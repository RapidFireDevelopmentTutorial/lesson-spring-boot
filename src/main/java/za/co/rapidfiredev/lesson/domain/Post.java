package za.co.rapidfiredev.lesson.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {

    @Id
    private String id;
    private String subject;
    private String message;

    @Setter(AccessLevel.NONE)
    private int likes;

    public void addLike() {
        this.likes++;
    }

}
