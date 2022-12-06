package com.ibrahim.inventory;

import com.ibrahim.inventory.entities.Category;
import com.ibrahim.inventory.entities.Product;
import com.ibrahim.inventory.repository.CategoryRepository;
import com.ibrahim.inventory.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CategoryRepository categoryRepository,
                                        ProductRepository productRepository)
    {
        return args ->
        {
            Random random=new Random();
            List.of("Computer","Smartphone","Headphone").forEach(cat->{
                Category category= Category.builder().name(cat).build();
                categoryRepository.save(category);
            });
            categoryRepository.findAll().forEach(category -> {
                for (int i = 0; i < 10; i++) {
                    Product product= Product.builder().
                            id(UUID.randomUUID().toString())
                            .name("Smartphone "+i)
                            //pour éviter des nombres qui commencent par des 0
                            .price(100+Math.random()*201)
                            //nombre entre 0 et 100
                            .quantity(random.nextInt(100))
                            .category(category)
                            .build();
                    productRepository.save(product);
                }
            });
        };
    }
}
