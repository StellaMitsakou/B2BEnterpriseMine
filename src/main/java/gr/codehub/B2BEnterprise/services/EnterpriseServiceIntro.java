package gr.codehub.B2BEnterprise.services;

import gr.codehub.B2BEnterprise.model.Product;

import java.io.*;
import java.util.List;

public class EnterpriseServiceIntro {
    public String getIntro(String filename) throws IOException {
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = "";
        while ((st = br.readLine()) != null)
            return st;
        return st;
    }
}
