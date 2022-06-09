package com.example.bars.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@Document
public class Customer
{
    @Id
    private String username;
    private String password;
    private Date creationDate = new Date();
    private PasswordEncoder passwordEncoder;

    public Customer() {

    }

    public Customer(String username, String password) {
        this.username = username;
        this.password = passwordEncoder.encode(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
