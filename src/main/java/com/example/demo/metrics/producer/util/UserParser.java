package com.example.demo.metrics.producer.util;

import com.example.demo.metrics.producer.dto.User;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserParser {

    private final static String PATHFILE = "/names.csv";

    public List<User> parseUsers() {
        List<User> userList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new InputStreamReader(getClass().getResourceAsStream(PATHFILE)))) {
            List<String[]> users = reader.readAll();
            for (String[] user : users) {
                String firstName = user[0];
                String lastName = user[1];
                User newUser = new User();
                newUser.setFirstName(firstName);
                newUser.setLastName(lastName);
                newUser.setAge(generateRandomAge());
                userList.add(newUser);
            }
            }  catch (IOException | CsvException e) {
                e.printStackTrace();
            }
        return userList;
    }


    private int generateRandomAge() {
        return new Random().nextInt(52) + 18;
    }
}
