import object_model.Contact_model;
import object_model.User_model;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Data_Provider {
    @DataProvider
    public Iterator<Object[]> data() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/registr_data.csv")));
        String line = reader.readLine();
        while (line != null) {

            String[] split = line.split(",");
            String type=split[0];
            String email=split[1];
            String password=split[2];
            String expectedMessage=split[3];
            list.add(new Object[]{
                    type,User_model.builder().email(split[0]).password(split[1]).build(),expectedMessage
            });
            line = reader.readLine();
        }

        reader.close();


        return list.iterator();


    }







}