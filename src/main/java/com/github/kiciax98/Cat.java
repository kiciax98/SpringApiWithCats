package com.github.kiciax98;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Cat {

    private static int idCounter=0;
    private int id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date date;
    private float weight;
    private String keeperName;

    public void setName(String imie) {
        this.name = imie;
    }
    public void setDate(Date data) {
        this.date = data;
    }
    public void setWeight(float waga) {
        this.weight = waga;
    }
    public void setKeeperName(String keeperName) {
        this.keeperName = keeperName;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getKeeperName() {
        return keeperName;
    }
    public Date getDate() {
        return date;
    }
    public float getWeight() {
        return weight;
    }

    Cat(){
    }

    public Cat(String name, Date date, float weight, String keeperName){
        id = idCounter++;
        this.name = name;
        this.date = date;
        this.weight = weight;
        this.keeperName = keeperName;
    }

    public void introduction(){

        System.out.println ("Cat name is " + name + " date of birth " + date + " weight " + weight + " kg, keeper name "+ keeperName);
    }
}
