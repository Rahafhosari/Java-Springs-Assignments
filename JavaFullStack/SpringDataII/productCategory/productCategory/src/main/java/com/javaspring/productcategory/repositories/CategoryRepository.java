package com.javaspring.productcategory.repositories;

import com.javaspring.productcategory.models.Category;
import com.javaspring.productcategory.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    public List<Category> findAll();
    public List<Category> findByProductsContains(Product product);
    public List<Category> findByProductsNotContains(Product product);
}
