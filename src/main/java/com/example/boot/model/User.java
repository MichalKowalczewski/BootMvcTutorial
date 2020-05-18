package com.example.boot.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {

    private int id;
//ustawimy pola walidacji za pomocą javax.validation - wszystkie pola walidacji do sprawdzenia pod adresem -
// https://docs.oracle.com/javaee/7/api/javax/validation/constraints/package-summary.html
    @NotEmpty
    @Size(min=3)
    private String firstName;

    @NotEmpty
    @Size(min=3)
    private String lastName;

    private String email;

    public User() {
    }

    public User(int id, @NotEmpty @Size(min = 3) String firstName, @NotEmpty @Size(min = 3) String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
