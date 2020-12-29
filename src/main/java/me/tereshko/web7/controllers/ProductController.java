package me.tereshko.web7.controllers;


import me.tereshko.web7.models.Product;
import me.tereshko.web7.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getAllProductById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    @GetMapping("/delete/{id}")
    public void getDeleteById(@PathVariable Long id, HttpServletResponse httpServletResponse) throws IOException {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
        httpServletResponse.sendRedirect("/products");
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

//    @PostMapping("/test1")
//    public List<Product> test1(@PathVariable Long price){
//        return productRepository.findAllByPriceBetweenMinAndMax(1L, 5L);
//    }
}
