package com.example.montreal_art;

public class Reservations {
    int image;
    String type,indate,outdate,price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    Reservations(int image,String type, String indate, String outdate, String price) {
        this.image=image;
        this.type=type;
        this.indate=indate;
        this.outdate=outdate;
        this.price=price;

    }
    public String getIndate() {
        return indate;
    }
    public void setIndate(String indate) {
        this.indate = indate;
    }
    public String getOutdate() {
        return outdate;
    }
    public void setOutdate(String outdate) {
        this.outdate = outdate;
    }

    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }
}