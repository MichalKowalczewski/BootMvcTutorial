package com.example.boot.dao;

import com.example.boot.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
//Przykładowe DAO - żebyśmy mieli skąd pobierać dane, zanim zastosujemy bazy danych i Spring Data
public class UserDAO {

    private List<User> users = new ArrayList<User>();

    @PostConstruct
    public void init(){
        users.add(new User(0,"Jan", "Nowak", "jan.nowak@test.pl"));
        users.add(new User(1,"Stefan", "Kowalski","stefan.kowalski@test.pl"));
        users.add(new User(2,"Maria", "Skłodowska","maria.sklodowska@test.pl"));
        users.add(new User(3,"Przykladowy", "Uzytkownik","przykladowy.uzytkownik@test.pl"));
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(int id){
        return users.get(id);
    }
}
