package gr.codehub.B2BEnterprise.repository;

import gr.codehub.B2BEnterprise.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    List<Product> products;

    public ProductRepository(String s) {
        products = new ArrayList<>();
    }

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int code){
        return products
                .stream()
                .filter(product -> product.getId()==code)
                .findFirst()
                .get();
    }

}
