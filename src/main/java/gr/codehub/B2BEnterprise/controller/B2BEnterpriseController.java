package gr.codehub.B2BEnterprise.controller;

import gr.codehub.B2BEnterprise.model.Customer;
import gr.codehub.B2BEnterprise.model.Product;
import gr.codehub.B2BEnterprise.repository.CustomerRepository;
import gr.codehub.B2BEnterprise.repository.ProductRepository;
import gr.codehub.B2BEnterprise.services.EnterpriseServiceForCustomers;
import gr.codehub.B2BEnterprise.services.EnterpriseServiceForProducts;
import gr.codehub.B2BEnterprise.services.EnterpriseServiceIntro;
import gr.codehub.B2BEnterprise.services.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@RestController
public class B2BEnterpriseController {

    @Autowired
    private IEnterpriseService ea;

    @GetMapping("customers")
    public List<Customer> getCustomerController()  throws FileNotFoundException{ //Adi gia List<Customer> tha borousa na valw kai CustomerRepository.
        EnterpriseServiceForCustomers sc = new EnterpriseServiceForCustomers();
        //return sc.loadCustomer("customers.csv");    //Gyrnaei lista
        return sc.loadCustomer("customers.csv").getCustomers();    //Gyrnaei CustomerRepository
    }

    @GetMapping("products")
    public List<Product> getProductController() throws FileNotFoundException {  //Adi gia List<Product> tha borousa na valw kai ProductRepository.
        EnterpriseServiceForProducts sc = new EnterpriseServiceForProducts();
        //return sc.loadProducts("products.csv");   //Gyrnaei lista
        return sc.loadProducts("products.csv").getProducts(); //Gyrnaei ProductsRepository
    }


    @GetMapping("intro")
    public String getHello() throws IOException {
        EnterpriseServiceIntro sc = new EnterpriseServiceIntro();
        return sc.getIntro("intro.txt");
    }

    @GetMapping("customer/{id}")
    public Customer getCustomers(@PathVariable int id) throws FileNotFoundException {
        return  ea.getCustomerByCode(id);
    }

    @GetMapping("product/{id}")
    public Product getProducts(@PathVariable int id) throws IOException {
        return  ea.getProductByCode(id);
    }
}
