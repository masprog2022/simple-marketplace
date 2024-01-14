package com.masprogtechs.desafioanotaai.repositories;

import com.masprogtechs.desafioanotaai.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}
