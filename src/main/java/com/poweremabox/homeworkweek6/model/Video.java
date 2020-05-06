package com.poweremabox.homeworkweek6.model;

public class Video {

    private String name;
    private String producent;
    private int date;

    public Video(String name,String producent, int date) {
        this.name = name;
        this.producent = producent;
        this.date = date;
    }

    public Video() {
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
