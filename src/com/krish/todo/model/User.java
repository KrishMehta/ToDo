package com.krish.todo.model;

/**
 * Class created by Krish
 */

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String gender;

    public User() {
    }

    public User(String firstName, String lastName, String email, String username, String password, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

}
