package gr.codehub.B2BEnterprise.model;

import gr.codehub.B2BEnterprise.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Product {
    private int id;
    private String name;
    private double grossPrice;
    private int quantity;

    public Product(){

    }
    public Product(int code, String title, String city, String description) {
    }

    public Product(int id, String name, double grossPrice, int quantity) {
        this.id = id;
        this.name = name;
        this.grossPrice = grossPrice;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grossPrice=" + grossPrice +
                ", quantity=" + quantity +
                '}';
    }

}
