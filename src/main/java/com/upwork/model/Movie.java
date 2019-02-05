package com.upwork.model;

public class Movie {
    private String name;
    private ParentalControlLevel level;

    public Movie(String name, ParentalControlLevel level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParentalControlLevel getLevel() {
        return level;
    }

    public void setLevel(ParentalControlLevel level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
