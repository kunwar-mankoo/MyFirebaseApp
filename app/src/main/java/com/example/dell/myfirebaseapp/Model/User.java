package com.example.dell.myfirebaseapp.Model;

public class User {
    public String FirstName;
    public String LastName;
    public String Email;
    public String Mobile;
    public String Password;

    public User()  {
    }

    public User(String firstName, String lastName, String email, String mobile, String password) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Mobile = mobile;
        Password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
