package com.jongwan.fun.domain.model.post;

import com.jongwan.fun.domain.model.category.Category;
import com.jongwan.fun.domain.model.post.code.PostStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Setter
    private String title;
    @Setter
    private String contents;
    private ZonedDateTime createdDatetime;
    @Setter
    private ZonedDateTime updatedDatetime;
    @Enumerated(EnumType.STRING)
    @Setter
    private PostStatus status;

    @Builder
    public Post(String title, String contents, PostStatus status) {
        this.id = UUID.randomUUID().toString();
        this.createdDatetime = ZonedDateTime.now();
        this.status = status;
        this.title = title;
        this.contents = contents;
    }

}
