package com.example.sam.randomtraveler;

public class Info {
    private String from,to,price,dateFrom,dateTo;

    public Info(String from,String to,String price,String dateFrom,String dateTo){
        this.setFrom(from);
        this.setTo(to);
        this.setPrice(price);
        this.setDateFrom(dateFrom);
        this.setDateTo(dateTo);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }
}
