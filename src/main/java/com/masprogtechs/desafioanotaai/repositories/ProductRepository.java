package com.masprogtechs.desafioanotaai.repositories;


import com.masprogtechs.desafioanotaai.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
