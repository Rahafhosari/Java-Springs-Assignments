package com.javaspring.productcategory.controllers;

import com.javaspring.productcategory.models.Category;
import com.javaspring.productcategory.models.CategoryProduct;
import com.javaspring.productcategory.models.Product;
import com.javaspring.productcategory.services.ProCatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PreUpdate;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    private final ProCatService proCatServ;

    public HomeController(ProCatService proCatServ) {
        this.proCatServ = proCatServ;
    }

    //For POSTMAN Testing (@RestController)
    @RequestMapping("/show/pro")
    public List<Product> AllProducts() {
        return proCatServ.allProducts();
    }

    @RequestMapping("/show/cat")
    public List<Category> AllCategories() {
        return proCatServ.allCategories();
    }

    //Create New Category
    @RequestMapping(value = "/create/cat", method = RequestMethod.POST)
    public List<Category> createCategory(@RequestParam(value = "name") String name) {
        Category cat = proCatServ.createCategory(new Category(name));
        return proCatServ.allCategories();
    }
//HOMEPAGE
    @RequestMapping("/")
    public String homePage(){
        return "home.jsp";
    }

    //Show and Add Products
    @RequestMapping("/products")
    public String showProducts(@ModelAttribute("product") Product product, Model model) {
        List<Product> products = proCatServ.allProducts();
        model.addAttribute("products", products);
        return "product.jsp";
    }

    @RequestMapping(value = "/products/new", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product.jsp";
        } else {
            Product p = proCatServ.createProduct(product);
            return "redirect:/products";
        }
    }

    //Show and Add Category
    @RequestMapping("/categories")
    public String showCategories(@ModelAttribute("category") Category category, Model model) { //modelAttribute is for the form & model is for displaying info
        List<Category> categories = proCatServ.allCategories();
        model.addAttribute("categories", categories);
        return ("category.jsp");
    }

    @RequestMapping(value = "/category/new", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category.jsp";
        } else {
            Category category1 = proCatServ.createCategory(category);
            return "redirect:/categories";
        }
    }

    //Product info Display & categories product belong to
    @RequestMapping(value = "/product/{id}")
    public String productInfo(@PathVariable("id") Long id, Model model,@ModelAttribute("categoryProduct") CategoryProduct catPro,@ModelAttribute("product") Product product,@ModelAttribute("category") Category category) { //can use one model to show different attributes
        Product product1 = proCatServ.findProduct(id);
        model.addAttribute("product", product1);
        //List<Category> categories = proCatServ.findCategory(id);
        List<Category> categories = proCatServ.findCategoriesInProduct(product1);
        model.addAttribute("categories", categories);
        List<Category> notInCategory = proCatServ.findCategoriesNotInProduct(product1);
        model.addAttribute("notInCategories", notInCategory);
        return ("infoProduct.jsp");
    }
    //Add Category to product
    //in order to add product or category through the form we have to use @ModelAttribute
    //Model Attribute should be in the function that will display the page
    //and in the function tha will process the form

    @RequestMapping(value = "/catTopro/{id}", method = RequestMethod.POST)
    public String addCategoryToProduct(@PathVariable(value="id") Long product_id,@RequestParam("select_category") Long category_id) {
            proCatServ.AddCategoryForProduct(product_id,category_id);
            return "redirect:/product/" + product_id;
    }

    
    @RequestMapping(value = "/category/{id}")
    public String categoryInfo(@PathVariable("id") Long id, Model model,@ModelAttribute("categoryProduct") CategoryProduct catPro,@ModelAttribute("product") Product product,@ModelAttribute("category") Category category) { //can use one model to show different attributes
        //Get category by ID
        Category category1 = proCatServ.findCategory(id);
        model.addAttribute("category", category1);
        //Get a list of all products in Category
        List<Product> productsInCategory = proCatServ.findProductsInCategory(category1);
        model.addAttribute("products",productsInCategory);
        //Get a list of all products NOT in Category
        List<Product> productsNotInCategory = proCatServ.findProductsNotInCategory(category1);
        model.addAttribute("productNotInCategory",productsNotInCategory);
        return ("infoCategory.jsp");
    }

    @RequestMapping(value="/proTocat/{id}", method = RequestMethod.POST)
    public String AddProductForCategory(@PathVariable(value="id") Long category_id,@RequestParam("select_product") Long product_id) {
        proCatServ.AddProductForCategory(category_id,product_id);
        return "redirect:/category/" + category_id;
    }
}

//or
//@RequestMapping(value = "/catTopro/{id}", method = RequestMethod.POST)
//public String addCategoryToProduct(@PathVariable(value="id") Long product_id,@RequestParam("select_category") Long category_id) {
//Product product1 = proCatServ.findProduct(product_id);
//Long productId = product1.getId();
//return "redirect:/product/" + product_id;
//}

//@RequestParam("nameSelect"),

//Category info Display & Products in Categories
//        @RequestMapping("/product/{id}")
//        public String categoryInfo(@ModelAttribute("product") Product product, Model model,@PathVariable("id") Long id){
//            List<Product> products = proCatServ.findProduct(id);
//            model.addAttribute("products",products);
//            return ("product.jsp");
//        }
    //Add product to category
