package com.jongwan.fun.domain.controller.category.vo;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Getter;

@Getter
public class CreateCategoryRequest {

    @GraphQLQuery
    private String name;
    @GraphQLQuery
    private int order;
}
