package com.jongwan.fun.domain.controller.category;

import com.jongwan.fun.domain.controller.category.vo.CreateCategoryRequest;
import com.jongwan.fun.domain.controller.category.vo.UpdateCategoryRequest;
import com.jongwan.fun.domain.model.category.Category;
import com.jongwan.fun.domain.service.category.CategoryService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Controller;

import java.util.List;

@GraphQLApi
@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GraphQLQuery
    public List<Category> categories() {
        return categoryService.getCategories();
    }

    @GraphQLMutation
    public Category createCategory(CreateCategoryRequest category) {
        return categoryService.create(Category.builder()
                                          .name(category.getName())
                                          .order(category.getOrder())
                                          .build());
    }

    @GraphQLMutation
    public Category updateCategory(@GraphQLArgument(name = "categoryId") String categoryId, UpdateCategoryRequest request) {
        return categoryService.updateCategory(categoryId, request.getCategoryName(), request.getOrder());
    }

    @GraphQLMutation
    public void deleteCategory(@GraphQLArgument(name = "categoryId") String categoryId) {
        categoryService.delete(categoryId);
    }

}
