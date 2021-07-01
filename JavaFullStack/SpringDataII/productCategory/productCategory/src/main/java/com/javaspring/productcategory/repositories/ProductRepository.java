package com.javaspring.productcategory.repositories;

import com.javaspring.productcategory.models.Category;
import com.javaspring.productcategory.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    public List<Product> findAll();
    public List<Product> findByCategoriesContains(Category category);
    public List<Product> findByCategoriesNotContains(Category category);
}
