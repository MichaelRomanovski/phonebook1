import object_model.Contact_model;
import object_model.User_model;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Data_Provider {

    @DataProvider
    public Iterator<Object[]> data_registration() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader("src/test/resources/registration_data.csv"));
        String line = reader.readLine(); // skip header
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            String[] split = line.split(",", -1);
            if (split.length < 3) {
                System.out.println("Skipping bad line: " + line);
                continue;
            }
            String type = split[0];
            String email = split[1];
            String password = split[2];
            String expectedMessage = split.length > 3 ? split[3] : "";
            list.add(new Object[]{
                    type,
                    User_model.builder().email(email).password(password).build(), expectedMessage});
        }
        reader.close();
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> data_contact() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader("src/test/resources/add_contact_data.csv"));
        String line = reader.readLine(); // skip header
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            String[] split = line.split(",", -1);
            if (split.length < 3) {
                System.out.println("Skipping bad line: " + line);
                continue;}
            String type = split[0];
            String email = split[1];
            String password = split[2];
            String expectedMessage = split.length > 3 ? split[3] : "";
            list.add(new Object[]{
                    type,
                    User_model.builder().email(email).password(password).build(), expectedMessage});
        }
        reader.close();
        return list.iterator();
    }



    @DataProvider
    public Iterator<Object[]> data_login() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader("src/test/resources/login_data.csv"));
        String line = reader.readLine(); // skip header
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            String[] split = line.split(",", -1);
            if (split.length < 3) {
                System.out.println("Skipping bad line: " + line);
                continue;}
            String type = split[0];
            String email = split[1];
            String password = split[2];
            String expectedMessage = split.length > 3 ? split[3] :"";
            list.add(new Object[]{
                    type,
                    User_model.builder().email(email).password(password).build(), expectedMessage});
        }
        reader.close();
        return list.iterator();
    }








}





