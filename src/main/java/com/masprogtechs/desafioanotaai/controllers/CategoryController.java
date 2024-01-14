package com.masprogtechs.desafioanotaai.controllers;

import com.masprogtechs.desafioanotaai.domain.category.Category;
import com.masprogtechs.desafioanotaai.domain.category.CategoryDTO;
import com.masprogtechs.desafioanotaai.services.CategoryService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDTO categoryData){
      Category newCategory = this.categoryService.insert(categoryData);
      return ResponseEntity.ok().body(newCategory);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        List<Category> categories = this.categoryService.getAll();
        return ResponseEntity.ok().body(categories);
     }

     @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") String id, @RequestBody CategoryDTO categoryData){
         Category updatedCategory = this.categoryService.update(id, categoryData);
         return ResponseEntity.ok().body(updatedCategory);

     }


     @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathParam("id") String id){
        this.categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }






}
