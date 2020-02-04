package gr.codehub.B2BEnterprise.services;

import gr.codehub.B2BEnterprise.model.Customer;
import gr.codehub.B2BEnterprise.model.Product;
import gr.codehub.B2BEnterprise.repository.CustomerRepository;
import gr.codehub.B2BEnterprise.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class EnterpriseServiceForCustomers {
    //PRWTOS TROPOS ME TIN XRHSH CUSTOMER REPOSITORY
    public CustomerRepository loadCustomer(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        CustomerRepository customers = new CustomerRepository();
        //employees.clear();
        while (sc.hasNext()){
            String line = sc.nextLine();
            String []metadata = line.split(",");
            Customer e = new Customer(Integer.parseInt(metadata[0]), metadata[1], metadata[2], metadata[3]);
            customers.addCustomer(e);
        }
        return customers;
    }

    //DEUTEROS TROPOS XWRIS TIN XRHSH CUSTOMER REPOSITORY
    /*public void loadCustomer(String filename){}
    public List<Customer> getCustomer(String filename) throws FileNotFoundException {
        List<Customer> customers = new ArrayList<>();
        Path pathToFile = Paths.get(filename);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Customer customer = createCustomer(attributes);
                customers.add(customer);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return customers;
    }

    private Customer createCustomer(String[] metadata) {
        int code = Integer.parseInt(metadata[0]);
        String title = metadata[1];
        String city = metadata[2];
        String description = metadata[3];
        return new Customer(code, title, city, description);
    }*/


}
