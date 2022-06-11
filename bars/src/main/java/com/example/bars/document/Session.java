package com.example.bars.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

@Document
public class Session {
    private Date creationDate;
    private Date dateExpire;
    @Id
    private String token;

    public Session() {};

    public Session(Customer customer) {
        this.creationDate = new Date();
        this.dateExpire = addHoursToJavaUtilDate(new Date(), 2);
        this.token = Base64.getEncoder().encodeToString((customer.getUsername() + customer.getPassword() + new Timestamp(System.currentTimeMillis())).getBytes());
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDateExpire() {
        return dateExpire;
    }

    public void setDateExpire(Date dateExpire) {
        this.dateExpire = dateExpire;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }
}
