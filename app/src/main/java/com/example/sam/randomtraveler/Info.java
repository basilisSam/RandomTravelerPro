package com.example.sam.randomtraveler;

public class Info {
    private String from,to,price,dateFrom,dateTo,rfrom,rto,rdateFrom,rdateTo;

    public Info(String from,String to,String price,String dateFrom,String dateTo,String rfrom,String rto,String rdateFrom,String rdateTo){
        this.setFrom(from);
        this.setTo(to);
        this.setPrice(price);
        this.setDateFrom(dateFrom);
        this.setDateTo(dateTo);
        this.setRfrom(rfrom);
        this.setRto(rto);
        this.setRdateFrom(rdateFrom);
        this.setRdateTo(rdateTo);
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

    public String getRfrom() {
        return rfrom;
    }

    public void setRfrom(String rfrom) {
        this.rfrom = rfrom;
    }

    public String getRto() {
        return rto;
    }

    public void setRto(String rto) {
        this.rto = rto;
    }

    public String getRdateFrom() {
        return rdateFrom;
    }

    public void setRdateFrom(String rdateFrom) {
        this.rdateFrom = rdateFrom;
    }

    public String getRdateTo() {
        return rdateTo;
    }

    public void setRdateTo(String rdateTo) {
        this.rdateTo = rdateTo;
    }
}
