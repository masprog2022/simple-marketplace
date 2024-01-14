package com.masprogtechs.desafioanotaai.controllers;


import com.masprogtechs.desafioanotaai.domain.product.Product;
import com.masprogtechs.desafioanotaai.domain.product.ProductDTO;
import com.masprogtechs.desafioanotaai.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productData){
        Product newProduct = this.productService.insert(productData);
        return ResponseEntity.ok().body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = this.productService.getAll();
        return ResponseEntity.ok().body(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") String id, @RequestBody ProductDTO productData){
        Product updatedProduct = this.productService.update(id, productData);
        return ResponseEntity.ok().body(updatedProduct);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathParam("id") String id){
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
