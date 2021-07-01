package com.javaspring.productcategory.repositories;

import com.javaspring.productcategory.models.CategoryProduct;
import org.springframework.data.repository.CrudRepository;

public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {

}
