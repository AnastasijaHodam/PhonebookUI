package com.phonebook.utils;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addNewContact(){
        List<Object[]> list=new ArrayList<>();
        list.add(new Object[]{"Oliver", "Twist", "01234567890", "Twister@gmail.com", "Rishon", "qa"});
        list.add(new Object[]{"Oliver", "Twist", "012345678901", "Twisa@gmail.com", "Rishon", "qa"});
        list.add(new Object[]{"Oliver", "Twist", "01234567890123", "Twis@gmail.com", "Rishon", "qa"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]>addNewContactWithCsv() throws IOException {
        List<Object[]>list=new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));

        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(",");

            list.add(new Object[]{new Contact().setName(split[0])
                    .setLastname(split[1]).setPhone(split[2]).setEmail(split[3])
                    .setAddress(split[4]).setDescripton(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }

}
