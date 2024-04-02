package com.example.tp2;

import com.example.tp2.entities.Product;
import com.example.tp2.repository.ProductRepository;
import com.example.tp2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Tp2Application implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(Tp2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //productRepository.save(new Product(null,"Computer",3400,32));
        //productRepository.save(new Product(null,"Computer",3400,32));
        //productRepository.save(new Product(null,"Computer",3400,32));
        List<Product> products = productRepository.findAll();
        products.forEach(p ->
                System.out.println(p.toString()));
        Product product =productRepository.findById(Long.valueOf(1)).get();
        System.out.println("********");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("********");
        System.out.println("------------");
        List<Product> productList = productRepository.findByNameContains("C");
        productList.forEach(p1 ->{
            System.out.println(p1);
        } );
        System.out.println("-----------");
        List<Product> productList2 = productRepository.search("%C%");
        productList2.forEach(p1 ->{
            System.out.println(p1);
        } );
        System.out.println("-----------");
        List<Product> productList3 = productRepository.searchByPrice(3000);
        productList3.forEach(p1 ->{
            System.out.println(p1);
        } );

    }


    }

