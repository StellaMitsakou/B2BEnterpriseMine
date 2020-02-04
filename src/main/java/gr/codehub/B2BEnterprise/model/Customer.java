package gr.codehub.B2BEnterprise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int code;
    private String title;
    private String city;
    private String description;

    @Override
    public String toString() {
        return "Customer{" +
                "code=" + code +
                ", title='" + title + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Customer(int code, String title, String description) {
        this.code = code;
        this.title = title;
        this.description = description;
    }

}
