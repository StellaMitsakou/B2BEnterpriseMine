package gr.codehub.B2BEnterprise.services;

import gr.codehub.B2BEnterprise.model.Customer;
import gr.codehub.B2BEnterprise.model.Product;
import gr.codehub.B2BEnterprise.repository.CustomerRepository;
import gr.codehub.B2BEnterprise.repository.ProductRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

@Service
public class EnterpriseService implements IEnterpriseService {

    public CustomerRepository getCustomers() {
        return new CustomerRepository("customers.csv");
    }

    public Customer getCustomerByCode(int code) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("customers.csv"));
        CustomerRepository customers = new CustomerRepository();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] metadata = line.split(",");
            Customer e = new Customer(Integer.parseInt(metadata[0]), metadata[1], metadata[2], metadata[3]);
            customers.addCustomer(e);
        }
        return customers.getCustomerByCode(code);
    }

    public ProductRepository getProducts() {
        try {
            return new ProductRepository("products.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Product getProductByCode(int code) throws IOException {
        ProductRepository products = new ProductRepository("products.xlsx");

        FileInputStream excelFile = new FileInputStream(new File("products.xlsx"));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> row = datatypeSheet.iterator();
        row.next(); //reads the headers
        while (row.hasNext()) {
            Row currentRow = row.next();
            Iterator<Cell> cellIterator = currentRow.iterator();
            Cell codeCell = cellIterator.next();
            Cell nameCell = cellIterator.next();
            Cell grossPriceCell = cellIterator.next();
            Cell quantityCell = cellIterator.next();

            Product product = new Product(
                    (int) codeCell.getNumericCellValue(),
                    nameCell.getStringCellValue(),
                    grossPriceCell.getNumericCellValue(),
                    (int) quantityCell.getNumericCellValue()

            );
            products.addProduct(product);
        }
        return products.getProductById(code);
    }

}

