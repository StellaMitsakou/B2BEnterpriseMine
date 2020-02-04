package gr.codehub.B2BEnterprise.services;

import gr.codehub.B2BEnterprise.model.Customer;
import gr.codehub.B2BEnterprise.model.Product;
import gr.codehub.B2BEnterprise.repository.CustomerRepository;
import gr.codehub.B2BEnterprise.repository.ProductRepository;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IEnterpriseService {
    CustomerRepository getCustomers() ;
    Customer getCustomerByCode(int code) throws FileNotFoundException;
    ProductRepository getProducts();
    Product getProductByCode(int code) throws IOException;
}
