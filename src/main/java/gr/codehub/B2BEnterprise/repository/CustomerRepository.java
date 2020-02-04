package gr.codehub.B2BEnterprise.repository;

import gr.codehub.B2BEnterprise.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
public class CustomerRepository {
    List<Customer> customers;

    public CustomerRepository() {
        customers = new ArrayList<>();
    }

    public CustomerRepository(String filename) {
        this();
    }

    public void addCustomer(Customer s){
        customers.add(s);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomerByCode(int code){
        return customers
                .stream()
                .filter(customer -> customer.getCode()==code)
                .findFirst()
                .get();
    }
}
