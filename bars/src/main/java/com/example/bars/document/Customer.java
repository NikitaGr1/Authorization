package com.example.bars.document;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@Document
public class Customer
{
    @Id
    private String guid;
    private String username;
    private String password;
    private String sessionToken;
    private Date creationDate = new Date();
    private long auid;
    private PasswordEncoder passwordEncoder;

    public Customer() {

    }

    public Customer(String username, String password) {
        this.username = username;
        this.password = passwordEncoder.encode(password);
    }

    public String getGuid() {
        return guid;
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

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public long getAuid() {
        return auid;
    }

    public void setAuid(long auid) {
        this.auid = auid;
    }
}
