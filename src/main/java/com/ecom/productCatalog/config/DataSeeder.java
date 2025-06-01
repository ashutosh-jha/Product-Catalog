package com.ecom.productCatalog.config;

import com.ecom.productCatalog.model.Category;
import com.ecom.productCatalog.model.Product;
import com.ecom.productCatalog.repository.CategoryRepository;
import com.ecom.productCatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //clear the existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        //Create Categories

        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category homeAndKitchen = new Category();
        homeAndKitchen.setName("Home and Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics,clothing,homeAndKitchen));
        //Create Products

        Product phone = new Product();
        phone.setName("SmartPhone");
        phone.setDescription("Latest smartphone with AI capabilities");
        phone.setPrice(79999.00);
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("Laptop with high gaming capability");
        laptop.setPrice(179999.00);
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Jacket");
        jacket.setDescription("Cozy jacket");
        jacket.setPrice(2999.00);
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setCategory(clothing);

        Product gasBurner = new Product();
        gasBurner.setName("Toshiba");
        gasBurner.setDescription("3 burner gas");
        gasBurner.setPrice(1999.99);
        gasBurner.setImageUrl("https://placehold.co/600x400");
        gasBurner.setCategory(homeAndKitchen);

        productRepository.saveAll(Arrays.asList(phone,laptop,jacket,gasBurner));


    }
}
