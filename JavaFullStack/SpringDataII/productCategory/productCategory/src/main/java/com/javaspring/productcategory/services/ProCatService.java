package com.javaspring.productcategory.services;

import com.javaspring.productcategory.models.Category;
import com.javaspring.productcategory.models.CategoryProduct;
import com.javaspring.productcategory.models.Product;
import com.javaspring.productcategory.repositories.CategoryProductRepository;
import com.javaspring.productcategory.repositories.CategoryRepository;
import com.javaspring.productcategory.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProCatService {
    private final ProductRepository proRepo; //private final ProductRepository productRepository
    private final CategoryRepository catRepo;
    private final CategoryProductRepository catProRepo;

    public ProCatService(ProductRepository proRepo, CategoryRepository catRepo, CategoryProductRepository catProRepo) {
        this.proRepo = proRepo;
        this.catRepo = catRepo;
        this.catProRepo = catProRepo;
    }

    //All products
    public List<Product> allProducts() { return proRepo.findAll();}
    //we create this method here then we do the query for it in the Product Repository

    //All Categories
    public List<Category> allCategories() { return catRepo.findAll();}

    //Create Product
    public Product createProduct(Product p) {
        return proRepo.save(p);
    }

    //Create Category
    public Category createCategory(Category c){ return catRepo.save(c); }

    //Create categories product
    //public  CategoryProduct createCategoryProduct(CategoryProduct catPro){return catProRepo.save(catPro);}

    //Add Category to specific product
    //public CategoryProduct createCategoryForProduct(CategoryProduct x){return catProRepo.save(x);}

    public void AddCategoryForProduct(Long product_id,Long category_id) {
        Product product = proRepo.findById(product_id).orElse(null);
        Category category = catRepo.findById(category_id).orElse(null);
        List <Product> productsList = category.getProducts();
        productsList.add(product);
        category.setProducts(productsList);
        catRepo.save(category);
    }
    public void AddProductForCategory(Long category_id,Long product_id) {
        Category category = catRepo.findById(category_id).orElse(null);
        Product product = proRepo.findById(product_id).orElse(null);
        List <Category> categoryList = product.getCategories();
        categoryList.add(category);
        product.setCategories(categoryList);
        proRepo.save(product);
    }

    //Get product by Id
    public Product findProduct(Long id) { return proRepo.findById(id).orElse(null); }
// same as
//        Optional<Product> optionalProduct = p
//        if (optionalProduct.isPresent()) {
//            return optionalProduct.get();
//        } else {
//            return null;
//        }

    //Get Category by Id
    public Category findCategory(Long id) { return catRepo.findById(id).orElse(null);}
// same as
//        Optional<Category> optionalCategory = c
//        if (optionalCategory.isPresent()) {
//            return optionalCategory.get();
//        } else {
//            return null;
//        }


    //find the categories a product is in
    public List<Category> findCategoriesInProduct(Product product){ return catRepo.findByProductsContains(product);}

    //find the categories a product is NOT in
    public List<Category> findCategoriesNotInProduct(Product product){ return catRepo.findByProductsNotContains(product);}

    //find the products in a category
    public List<Product> findProductsInCategory(Category category){ return proRepo.findByCategoriesContains(category);}

    //find the products NOT in a category
    public List<Product> findProductsNotInCategory(Category category){ return proRepo.findByCategoriesNotContains(category);}
}
