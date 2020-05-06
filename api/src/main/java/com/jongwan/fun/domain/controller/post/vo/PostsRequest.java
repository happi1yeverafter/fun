package com.jongwan.fun.domain.controller.post.vo;

import com.jongwan.fun.common.model.PageableRequest;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Getter;

@Getter
public class PostsRequest extends PageableRequest {

    @GraphQLQuery
    private String categoryId;

}
