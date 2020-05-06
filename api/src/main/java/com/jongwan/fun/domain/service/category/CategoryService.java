package com.jongwan.fun.domain.service.category;

import com.jongwan.fun.common.error.FunExceptionCode;
import com.jongwan.fun.domain.model.category.Category;
import com.jongwan.fun.domain.model.category.code.CategoryStatusCode;
import com.jongwan.fun.domain.repository.category.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(String categoryId, String categoryName, int order) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> FunExceptionCode.CATEGORY_NOT_FOUND.newInstance(categoryId));
        category.setName(categoryName);
        category.setOrder(order);
        return categoryRepository.save(category);
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public void delete(String categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> FunExceptionCode.CATEGORY_NOT_FOUND.newInstance(categoryId));
        category.setCategoryStatusCode(CategoryStatusCode.DELETED);
        categoryRepository.save(category);
    }

}
