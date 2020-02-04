package gr.codehub.B2BEnterprise.services;

import gr.codehub.B2BEnterprise.model.Product;
import gr.codehub.B2BEnterprise.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
@Service
public class EnterpriseServiceForProducts {
    //PRWTOS TROPOS ME TIN XRHSH CUSTOMER REPOSITORY
    public ProductRepository loadProducts(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        ProductRepository products = new ProductRepository("products.xlsx");
        //employees.clear();
        while (sc.hasNext()){
            String line = sc.nextLine();
            String []metadata = line.split(",");
            Product e = new Product(Integer.parseInt(metadata[0]), metadata[1], Double.parseDouble(metadata[2]), Integer.parseInt(metadata[3]));
            products.addProduct(e);
        }
        return products;
    }


    //DEUTEROS TROPOS XWRIS TIN XRHSH PRODUCT REPOSITORY
   /* public List<Product> loadProducts(String filename) throws FileNotFoundException{
        List<Product> products = new ArrayList<>();
        Path pathToFile = Paths.get(filename);  //Is the best - recommended way according to Johny!!

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                String[] attributes = line.split(",");

                Product product = createProduct(attributes);

                // adding book into ArrayList
                products.add(product);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return products;
    }
    private static Product createProduct(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String name = metadata[1];
        double price = Double.parseDouble(metadata[2]);
        int quantity = Integer.parseInt(metadata[3]);

        // create and return book of this metadata
        return new Product(id, name, price, quantity);
    }
*/


}
