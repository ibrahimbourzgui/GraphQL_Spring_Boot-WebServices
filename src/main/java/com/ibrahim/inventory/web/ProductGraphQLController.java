package com.ibrahim.inventory.web;

import com.ibrahim.inventory.dto.ProductDto;
import com.ibrahim.inventory.entities.Category;
import com.ibrahim.inventory.entities.Product;
import com.ibrahim.inventory.repository.CategoryRepository;
import com.ibrahim.inventory.repository.ProductRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class ProductGraphQLController {

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    public ProductGraphQLController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @QueryMapping //pour toutes les requêtes de type 'SELECT'
    public List<Product> productList()
    {
        return productRepository.findAll();
    }
    @QueryMapping
    public Product productById(@Argument String id)
    {

        return productRepository.findById(id).orElseThrow(
                ()-> new RuntimeException(String.format("Product %s not found",id))
        );
    }
    @QueryMapping
    public List<Category> categories()
    {
        return categoryRepository.findAll();
    }
    @QueryMapping
    public Category categoryById(@Argument Long id)
    {
//        return Optional.ofNullable(categoryRepository.findById(id).orElseThrow(
//                () -> new RuntimeException(String.format("Category with this ID %s not found", id))
//        ));
        return categoryRepository.findById(id).orElseThrow(
                ()-> new RuntimeException(String.format("Category with this ID %s not found",id))
        );
    }
    @MutationMapping
    public Product saveProduct(@Argument ProductDto product)
    {
        Category category= categoryRepository.findById(product.categoryId()).orElse(null);
        Product productToSave= new Product();
        productToSave.setId(UUID.randomUUID().toString());
        productToSave.setName(product.name());
        productToSave.setPrice(product.price());
        productToSave.setQuantity(product.quantity());
        productToSave.setCategory(category);
        return productRepository.save(productToSave);
    }

    @MutationMapping
    public Product updateProduct(@Argument String id,@Argument ProductDto product)
    {
        Category category= categoryRepository.findById(product.categoryId()).orElse(null);
        Product productToSave= new Product();
        productToSave.setId(id);
        productToSave.setName(product.name());
        productToSave.setPrice(product.price());
        productToSave.setQuantity(product.quantity());
        productToSave.setCategory(category);
        return productRepository.save(productToSave);
    }
    @MutationMapping
    public void deleteProduct(@Argument String id)
    {

        productRepository.deleteById(id);

    }
}
