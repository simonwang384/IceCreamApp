package com.example.icecreamapp;

import java.io.Serializable;
import java.text.*;
import java.util.Date;

public class OrderItem implements Serializable {
    private Date date;
    private String flavor;
    private String d;
    private String size;
    private double price;
    private DateFormat sdf;

    public OrderItem(String flavor, String size, double price) {
        sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        date = new Date();
        d = sdf.format(date);

        this.flavor = flavor;
        this.size = size;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "Date = " + d +
                "\nFlavor = '" + flavor +
                "\nSize = '" + size +
                "\nPrice = " + "$" + String.format("%.2f",price);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date d) {
        this.date = d;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getD() {
        return d;
    }
}
