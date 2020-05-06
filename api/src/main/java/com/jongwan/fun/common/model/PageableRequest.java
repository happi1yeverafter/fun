package com.jongwan.fun.common.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
public class PageableRequest {

    @GraphQLQuery
    private Integer page;
    @GraphQLQuery
    private Integer size;

    public Pageable getPageable() {
        if (page == null && size == null) {
            return Pageable.unpaged();
        }
        return PageRequest.of(this.page - 1, size);
    }

}
