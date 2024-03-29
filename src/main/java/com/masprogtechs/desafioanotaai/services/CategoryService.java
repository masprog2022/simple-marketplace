package com.masprogtechs.desafioanotaai.services;

import com.masprogtechs.desafioanotaai.domain.category.Category;
import com.masprogtechs.desafioanotaai.domain.category.exceptions.CategoryNotFoundException;
import com.masprogtechs.desafioanotaai.domain.category.CategoryDTO;
import com.masprogtechs.desafioanotaai.domain.product.Product;
import com.masprogtechs.desafioanotaai.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category insert(CategoryDTO categoryData){
        Category newCategory = new Category(categoryData);
        this.categoryRepository.save(newCategory);
        return newCategory;
    }

    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    public Category update(String id, CategoryDTO categoryData) {
        Category category = this.categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        if(!categoryData.title().isEmpty()) category.setTitle(categoryData.title());
        if(!categoryData.description().isEmpty()) category.setDescription(categoryData.description());

        this.categoryRepository.save(category);
        return category;
    }

    public void delete(String id) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        this.categoryRepository.delete(category);
    }

    public Optional<Category> getById(String id) {
        return this.categoryRepository.findById(id);
    }
}
