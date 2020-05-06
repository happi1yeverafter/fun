package com.jongwan.fun.domain.controller.post.vo;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Getter;

@Getter
public class CreatePostRequest {

    @GraphQLQuery
    private String title;
    @GraphQLQuery
    private String contents;

}
