package com.jongwan.fun.domain.model.category;

import com.jongwan.fun.domain.model.category.code.CategoryStatusCode;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Category {

    @Id
    private String categoryId;
    @Setter
    private String name;
    @Setter
    @Column(name = "`order`")
    private int order;
    @Setter
    @Enumerated(EnumType.STRING)
    private CategoryStatusCode categoryStatusCode;

    @Builder
    public Category(String name, int order) {
        this.categoryId = UUID.randomUUID().toString();
        this.name = name;
        this.order = order;
        this.categoryStatusCode = CategoryStatusCode.CREATED;
    }

}
