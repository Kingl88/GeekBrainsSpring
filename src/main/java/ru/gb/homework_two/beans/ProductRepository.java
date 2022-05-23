package ru.gb.homework_two.beans;

import org.springframework.stereotype.Component;
import ru.gb.homework_two.entity.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "Milk", 10));
        products.add(new Product(2, "Bread", 5));
        products.add(new Product(3, "Tomato", 7));
        products.add(new Product(4, "Butter", 12));
        products.add(new Product(5, "Watermelon", 4));
    }

    public List<Product> getAllProduct(){
        return products;
    }

    public Product getProductById(int id){
        return getAllProduct().get(id);
    }

}
