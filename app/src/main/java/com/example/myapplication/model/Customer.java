package com.example.myapplication.model;

public class Customer {
    private  long   id;

    private String first_name;
    private String last_name;
    private int phone_number;
    private String city;
    private String flowers;
    private String gift;

    public long getId(){ return  id;}
    public  void setId(long id ){ this.id = id;}

    public String getFirst_name() {
        return first_name;
    }
    public void setfirst_name(String first_name) {
        this.first_name =first_name;}

    public String getLast_name() {
        return last_name;
    }
    public void setlast_name(String last_name) {
    this.last_name=last_name; }

    public int getPhone_number() {
        return phone_number;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFlowers() {
        return flowers;
    }

    public void setflowers(String flowers){
        this.flowers =flowers;
    }

    public String getGift() {
        return gift;
    }



    public void setphone_number(int phone_number) {
        this.phone_number =phone_number;

    }

    public void setcity(String city) {
   this.city=city ;}

    public void setgift(String gift) {
    this.gift=gift;}
}
